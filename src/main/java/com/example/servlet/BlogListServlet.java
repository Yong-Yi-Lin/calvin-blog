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
import java.util.List;
import java.util.Map;

@WebServlet("/blog_myList")//博客列表
public class BlogListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //未登录，访问跳转到登陆页面
        User user = WebUtil.checkLogin(req);
        if(user == null){
            resp.sendRedirect("login.html");
            return; //未登录，直接跳转，不会执行后边逻辑
        }
        req.setCharacterEncoding("utf-8");
        String uid = req.getParameter("id"); //获取到用户id

        UserDao userDao = new UserDao();

        List<Article> articles=null;
        User u=null;
        if(uid != null){
            articles = ArticleDao.searchUserBlog(Integer.valueOf(uid));
            u=userDao.searchUserInfo(Integer.valueOf(uid));
        }else {
            //通过登陆用户id查找所有文章
            articles = ArticleDao.searchUserBlog(user.getId());
            //查询登录用户的用户信息
            u=userDao.searchUserInfo(user.getId());
        }

        //先构造响应正文需要的java对象，再转化为json字符串，再设置到响应正文
        JsonResult json = new JsonResult();
        json.setOk(true);
        //前端需要的数据有nickname，articles，可以用map保存，然后设置到json.data中
        Map<String,Object> data = new HashMap<>();
        data.put("articles",articles);
        data.put("user",u);
        json.setData(data);

        resp.setContentType("application/json; charset=utf-8");
        resp.getWriter().write(WebUtil.write(json));
    }
}
