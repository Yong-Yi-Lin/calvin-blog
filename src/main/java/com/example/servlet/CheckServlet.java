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


@WebServlet("/CheckServlet")//验证用户信息
public class CheckServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = WebUtil.checkLogin(req);
        req.setCharacterEncoding("utf-8");
        JsonResult json = new JsonResult();
        if(user == null){
            InputStream is = req.getInputStream();
            User u = WebUtil.read(is,User.class);
            UserDao userDao = new UserDao();
            //boolean isExsitUsername=userDao.isExistName(username);
            boolean isExsit=userDao.isExist(u.getUsername(),u.getEmail());
            if(isExsit){
                json.setOk(false);
            }else {
                json.setOk(true);
            }
            resp.setContentType("application/json; charset=utf-8");
            resp.getWriter().write(WebUtil.write(json));
            //未登录不允许访问
            //resp.sendRedirect("login.html");
            return;
        }else {
            //解析请求
            //req.setCharacterEncoding("utf-8");
            //JsonResult json = new JsonResult();

            //验证当前用户的密码
            //获取当前用户的密码
            String userPassword = user.getPassword();
            int n = 0;
            //获取请求输入流，将json数据反序列化
            InputStream is = req.getInputStream();
            User u = WebUtil.read(is, User.class);
            //数据库修改一条数据，相当于更新一个对象
            String currentPassword = u.getPassword();
            //String nickname=u.getNickname();

            if (currentPassword.equals(userPassword)) {
                json.setOk(true);
            } else {
                json.setOk(false);
                json.setData("当前输入的密码有误");
            }
        }
        //先构造响应正文需要的java对象，再转化为json字符串，再设置到响应正文
        resp.setContentType("application/json; charset=utf-8");
        resp.getWriter().write(WebUtil.write(json));
    }
}



