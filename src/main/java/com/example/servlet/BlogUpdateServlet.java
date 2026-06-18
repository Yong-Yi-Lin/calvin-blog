package com.example.servlet;

import com.example.dao.ArticleDao;
import com.example.dao.UserDao;
import com.example.pojo.Article;
import com.example.pojo.JsonResult;
import com.example.pojo.User;
import com.example.util.WebUtil;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/blog_update")//编辑文章
public class BlogUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = WebUtil.checkLogin(req);
        if(user == null){
            resp.sendRedirect("login.html");
            return; //未登录，直接跳转，不会执行后边逻辑
        }
        req.setCharacterEncoding("utf-8");
        //路径为：blog_content?id=文章id
        //解析请求
        String sid = req.getParameter("id"); //获取到文章id

        UserDao userDao = new UserDao();
        JsonResult json = new JsonResult();
        Map<String,Object> data = new HashMap<>();
        //通过文章id查询整篇文章
        Article a = ArticleDao.searchBlogById(Integer.parseInt(sid));
        json.setOk(true);
        data.put("article",a);

        //得到用户头像
        String avatar = userDao.selectAvatar(user.getId());
        data.put("avatar",avatar);
        data.put("username",user.getUsername());
        json.setData(data);
        resp.setContentType("application/json; charset=utf-8");
        resp.getWriter().write(WebUtil.write(json));


    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = WebUtil.checkLogin(req);
        if(user == null){
            resp.sendRedirect("login.html");
            return; //未登录，直接跳转，不会执行后边逻辑
        }
        req.setCharacterEncoding("utf-8");
        //路径为：blog_content?id=文章id
        //解析请求
        String sid = req.getParameter("id"); //获取到文章id
        JsonResult json = new JsonResult();

        InputStream is = req.getInputStream();
        Article beUpdated = WebUtil.read(is,Article.class);
        beUpdated.setUserId(user.getId());
        beUpdated.setDate(new java.util.Date());
        //将id转化int类型
        int n = ArticleDao.UpdateOne(beUpdated,Integer.parseInt(sid));
        if(n>0){
            json.setOk(true);
        }else{
            json.setOk(false);
        }
        //得到用户头像
        resp.setContentType("application/json; charset=utf-8");
        resp.getWriter().write(WebUtil.write(json));
    }
}
