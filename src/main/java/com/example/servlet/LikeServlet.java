package com.example.servlet;

import com.example.dao.ArticleDao;
import com.example.pojo.JsonResult;
import com.example.pojo.User;
import com.example.util.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/blog_like")//点赞功能
public class LikeServlet extends HttpServlet {
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

        //获取url中文章的id
        Integer Aid= Integer.valueOf(req.getParameter("id"));

        //获得页面更新点赞量
        int likeCount = ArticleDao.getLikeCount(Aid);

        likeCount = likeCount+1;
        JsonResult json = new JsonResult();
        //点赞后使得点赞量加1,更改数据库的点赞量
        int i = ArticleDao.UpdateLike(likeCount, Aid);
        if(i<0){
            json.setOk(false);
        }else {
            json.setOk(true);
            json.setData(likeCount);
        }
        json.setData(likeCount);
        resp.setContentType("application/json; charset=utf-8");
        resp.getWriter().write(WebUtil.write(json));
    }
}


