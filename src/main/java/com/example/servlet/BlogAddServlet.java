package com.example.servlet;

import com.example.dao.ArticleDao;
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
import java.io.InputStream;

@WebServlet("/blog_add")//添加文章
public class BlogAddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = WebUtil.checkLogin(req);
        if(user == null){
            //未登录不允许访问
            resp.sendRedirect("login.html");
            return;
        }
        //解析请求
        req.setCharacterEncoding("utf-8");
        InputStream is = req.getInputStream();
        Article beInsert = WebUtil.read(is,Article.class);
        //数据库插入一条数据，相当于插入一个对象
        beInsert.setUserId(user.getId());
        beInsert.setDate(new java.util.Date());
        int n = ArticleDao.insertArticle(beInsert);

        JsonResult json = new JsonResult();
        if(n>0){
            json.setOk(true);
        }else{
            json.setOk(false);
        }

        resp.setContentType("application/json; charset=utf-8");
        resp.getWriter().write(WebUtil.write(json));
    }
}
