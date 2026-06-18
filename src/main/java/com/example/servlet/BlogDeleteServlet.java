package com.example.servlet;

import com.example.dao.ArticleDao;
import com.example.pojo.JsonResult;
import com.example.pojo.User;
import com.example.util.WebUtil;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/blog_delete")//删除文章
public class BlogDeleteServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = WebUtil.checkLogin(req);
        if(user == null){
            //未登录不允许访问
            resp.sendRedirect("login.html");
            return;
        }
        //解析请求
        req.setCharacterEncoding("utf-8");
        String sid = req.getParameter("id"); //获取到文章id
        //将id转化int类型
        int id= Integer.parseInt(sid);
        int n = ArticleDao.DeleteOne(id);
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
