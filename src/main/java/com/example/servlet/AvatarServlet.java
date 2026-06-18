package com.example.servlet;

import com.example.dao.UserDao;
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


@WebServlet("/AvatarServlet")
public class AvatarServlet extends HttpServlet {
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

        JsonResult json = new JsonResult();
        UserDao userDao = new UserDao();


        InputStream is = req.getInputStream();
        User u = WebUtil.read(is,User.class);
        int n = userDao.updateUserAvatar(u.getAvatar(),user.getId());
        if(n>0){
            json.setOk(true);
        }else{
            json.setData(false);
        }

        resp.setContentType("application/json; charset=utf-8");
        resp.getWriter().write(WebUtil.write(json));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        User user = WebUtil.checkLogin(req);
        if(user == null){
            //未登录不允许访问
            resp.sendRedirect("login.html");
            return;
        }
        //解析请求
        req.setCharacterEncoding("utf-8");
        JsonResult json = new JsonResult();
        UserDao userDao = new UserDao();

        String avatar = userDao.selectAvatar(user.getId());
        if(avatar!=null){
            json.setOk(true);
            json.setData(avatar);
        }else{
            json.setData(false);
        }

        resp.setContentType("application/json; charset=utf-8");
        resp.getWriter().write(WebUtil.write(json));
    }
}
