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

@WebServlet("/blog_AllList")//博客列表
public class BlogAllListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //未登录，访问跳转到登陆页面
        User user = WebUtil.checkLogin(req);
//        String path=req.getContextPath();
//        if(user == null){
//            resp.sendRedirect(path+"/login.html");
//            return; //未登录，直接跳转，不会执行后边逻辑
//        }
        //查找所有文章
        List<Article> articles = ArticleDao.selectAllBlogs();

        //先构造响应正文需要的java对象，再转化为json字符串，再设置到响应正文
        JsonResult json = new JsonResult();
        json.setOk(true);
        //前端需要的数据有articles，可以用map保存，然后设置到json.data中
        Map<String,Object> data = new HashMap<>();
        data.put("articles",articles);
        data.put("username",user.getUsername());
        json.setData(data);
        resp.setContentType("application/json; charset=utf-8");
        resp.getWriter().write(WebUtil.write(json));
    }
}

