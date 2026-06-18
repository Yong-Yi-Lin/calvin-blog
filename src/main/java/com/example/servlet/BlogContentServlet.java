package com.example.servlet;

import com.example.dao.ArticleDao;
import com.example.dao.UserDao;
import com.example.pojo.Article;
import com.example.pojo.JsonResult;
import com.example.pojo.User;
import com.example.util.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/blog_content")//博客详情
public class BlogContentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //未登录，访问跳转到登陆页面
        User user = WebUtil.checkLogin(req);
        if(user == null){
            resp.sendRedirect("login.html");
            return; //未登录，直接跳转，不会执行后边逻辑
        }

        //路径为：blog_content?id=文章id
        //解析请求
        String sid = req.getParameter("id"); //获取到文章id
        //通过文章id查询整篇文章
        Article a = ArticleDao.searchBlogById(Integer.parseInt(sid));//获取文章的内容
        int author_id = ArticleDao.getAuthor(Integer.valueOf(sid));
        UserDao userDao = new UserDao();
        //根据文章的id查询作者信息
        User u =userDao.searchUserInfo(author_id);

        JsonResult json = new JsonResult();
        json.setOk(true);
        Map<String,Object> data = new HashMap<>();
        data.put("article",a);
        data.put("user",u);
        json.setData(data);
        resp.setContentType("application/json; charset=utf-8");
        resp.getWriter().write(WebUtil.write(json));
    }
}
