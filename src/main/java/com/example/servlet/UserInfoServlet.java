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
import java.util.HashMap;
import java.util.Map;

@WebServlet("/UserInfo")//博客列表
public class UserInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //未登录，访问跳转到登陆页面
        User user = WebUtil.checkLogin(req);
        if(user == null){
            resp.sendRedirect("login.html");
            return; //未登录，直接跳转，不会执行后边逻辑
        }

        //解析请求
        req.setCharacterEncoding("utf-8");
        String sid = req.getParameter("id"); //获取到文章id

        UserDao userDao=new UserDao();

        //先构造响应正文需要的java对象，再转化为json字符串，再设置到响应正文
        JsonResult json = new JsonResult();
        Map<String,Object> data = new HashMap<>();
        User u = null;

        if(sid!=null){
             u= userDao.searchUserInfo(Integer.valueOf(sid));
        }else{
            //通过登陆用户id查找用户的信息
             u = userDao.searchUserInfo(user.getId());
        }
        json.setOk(true);
        data.put("user",u);
        json.setData(data);

        resp.setContentType("application/json; charset=utf-8");
        resp.getWriter().write(WebUtil.write(json));
    }

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

        int userId= user.getId();

        InputStream is = req.getInputStream();
        User newUser = WebUtil.read(is,User.class);
        //数据库修改一条数据，相当于更新一个对象
        newUser.setId(userId);

        UserDao userDao=new UserDao();
        //将id转化int类型
        int n = userDao.updateUserInfo(newUser,userId);

        JsonResult json = new JsonResult();
        json.setOk(true);
        resp.setContentType("application/json; charset=utf-8");
        resp.getWriter().write(WebUtil.write(json));
    }
}
