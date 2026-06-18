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
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.InputStream;

@WebServlet("/login")//登陆
public class LoginServlet extends HttpServlet {
    //登陆功能,f=login;json提交{email:abc,password:123}
    //注册功能,f=enrolled;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解析请求：通过输入流获取请求数据
        req.setCharacterEncoding("utf-8"); //设置请求对象的编码格式

        //获取请求参数-判断是login还是enrolled
        String f = req.getParameter("f");

        InputStream is = req.getInputStream();
        //将输入流中的json字符串转化为java对象
        //使用ObjectMapper将java对象和json字符串相互转换，Servlet都要用，封装到WebUtil中
        User get = WebUtil.read(is,User.class);

        //不管登陆是否成功，返回的http响应正文（body）都是json字符串
        //需要设计一个类，这个类的成员变量属性，用于前端ajax解析响应
        //先创建一个响应正文需要的Java对象，然后在转换为json字符串，再设置到响应正文
        JsonResult json = new JsonResult();

        if(f.equals("login")){
            //在数据库校验账号密码：通过账号密码在数据库查用户，若能查到则账号密码正确
            User user = UserDao.isLogin(get.getEmail(),get.getPassword());
            if(user != null){
                //登陆成功，设置session
                HttpSession session = req.getSession(true);
                session.setAttribute("user",user);
                //设置json对象中，操作是否成功为true
                json.setOk(true);
                json.setData("登录成功");
            }else {
                //登陆失败，设置操作是否成功字段为false
                json.setOk(false);
                json.setData("登录失败");
            }
        }else if (f.equals("enrolled")){
            UserDao ud=new UserDao();
            int n = ud.insertUser(get.getUsername(), get.getPassword(),get.getEmail());
            if(n>0){
                json.setOk(true);
                json.setData("注册成功");
            }else{
                json.setOk(false);
                json.setData("注册失败");
            }
        }
        //设置响应正文的格式
        resp.setContentType("application/json; charset=utf-8");
        resp.getWriter().write(WebUtil.write(json));
    }
}
