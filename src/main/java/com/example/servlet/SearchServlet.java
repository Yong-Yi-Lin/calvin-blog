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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/blog_search")//博客详情
public class SearchServlet extends HttpServlet {
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
//        String sid = req.getParameter("id"); //获取到文章id
        String key = req.getParameter("f"); //获取搜索关键词

        List<Article> articles = ArticleDao.searchArticle(key);
        JsonResult json = new JsonResult();

        json.setOk(true);
        Map<String,Object> data = new HashMap<>();
        data.put("articles",articles);
        json.setData(data);
        resp.setContentType("application/json; charset=utf-8");
        resp.getWriter().write(WebUtil.write(json));
    }
}

