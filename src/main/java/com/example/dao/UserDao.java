package com.example.dao;

import com.example.pojo.User;
import com.example.util.DruidUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public static User isLogin(String email, String password){
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = DruidUtil.getConnection();
            String sql = "select * from user where email=? and password=?";
            ps = c.prepareStatement(sql);
            ps.setString(1,email);
            ps.setString(2,password);
            rs = ps.executeQuery();
            User user = null;
            while(rs.next()){
                user = new User();
                int id = rs.getInt("id");
                String username = rs.getString("username");
                user.setId(id);
                user.setUsername(username);
                user.setPassword(password);
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException("校验账号密码出错",e);
        } finally {
            DruidUtil.close(c,ps,rs);
        }
    }

    public int insertUser(String username,String password,String email) {
        Connection c = null;
        PreparedStatement ps = null;
        try{
            c = DruidUtil.getConnection();
            String sql = "insert into user(username,password,email) values(?,?,?)";
            ps = c.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            ps.setString(3,email);
            return ps.executeUpdate();
        } catch (SQLException throwables) {
            throw new RuntimeException("注册用户jdbc出错",throwables);
        } finally {
            DruidUtil.close(c,ps);
        }
    }

    public int updateUserInfo(User beUpdated,Integer userId) {
        Connection c = null;
        PreparedStatement ps = null;
        try{
            c = DruidUtil.getConnection();
            String sql = "update user set username=?,Email=?,Biography=? where id=?";
            ps = c.prepareStatement(sql);
            ps.setString(1,beUpdated.getUsername());
            ps.setString(2, beUpdated.getEmail());
            ps.setString(3, beUpdated.getBiography());
            ps.setInt(4,userId);
            return ps.executeUpdate();
        } catch (SQLException throwables) {
            throw new RuntimeException("修改用户信息出错",throwables);
        } finally {
            DruidUtil.close(c,ps);
        }
    }

        //通过用户id查询用户信息
        public User searchUserInfo(Integer UserId) {
            User u= null;
            Connection c = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            try{
                c = DruidUtil.getConnection();
                String sql = "select * from user where id=?";
                ps = c.prepareStatement(sql);
                ps.setInt(1,UserId);
                rs = ps.executeQuery();
                while(rs.next()){
                    u = new User();
                    u.setId(rs.getInt(1));
                    u.setUsername(rs.getString(2));
                    u.setPassword(rs.getString(3));
                    u.setEmail(rs.getString(4));
                    u.setBiography(rs.getString(5));
                    u.setAvatar(rs.getString(6));
                }
                return u;
            } catch (SQLException throwables) {
                throw new RuntimeException("查询用户错误",throwables);
            } finally{
                DruidUtil.close(c,ps,rs);
            }
        }

    public int updateUserPassword(User beUpdated,Integer userId) {
        Connection c = null;
        PreparedStatement ps = null;
        try{
            c = DruidUtil.getConnection();
            String sql = "update user set password=? where id=?";
            ps = c.prepareStatement(sql);
            ps.setString(1,beUpdated.getPassword());
            ps.setInt(2,userId);
            return ps.executeUpdate();
        } catch (SQLException throwables) {
            throw new RuntimeException("修改用户信息出错",throwables);
        } finally {
            DruidUtil.close(c,ps);
        }
    }

    public Boolean isExist(String username,String email) {
        User u= null;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            c = DruidUtil.getConnection();
            String sql = "SELECT * FROM user WHERE username = ? or email = ?";
            ps = c.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,email);
            rs = ps.executeQuery();

            return rs.next();

        } catch (SQLException throwables) {
            throw new RuntimeException("检验用户名昵称错误",throwables);
        } finally{
            DruidUtil.close(c,ps,rs);
        }
    }

    public int updateUserAvatar(String avatar,Integer userId) {
        Connection c = null;
        PreparedStatement ps = null;
        try{
            c = DruidUtil.getConnection();
            String sql = "update user set avatar=? where id=?";
            ps = c.prepareStatement(sql);
            ps.setString(1,avatar);
            ps.setInt(2,userId);
            return ps.executeUpdate();
        } catch (SQLException throwables) {
            throw new RuntimeException("修改用户头像出错",throwables);
        } finally {
            DruidUtil.close(c,ps);
        }
    }

    public String selectAvatar(Integer UserId) {
        String avatar=null;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            c = DruidUtil.getConnection();
            String sql = "select avatar from user where id=?";
            ps = c.prepareStatement(sql);
            ps.setInt(1,UserId);
            rs = ps.executeQuery();
            while(rs.next()){
                avatar=rs.getString(1);
            }
            return avatar;
        } catch (SQLException throwables) {
            throw new RuntimeException("查询用户错误",throwables);
        } finally{
            DruidUtil.close(c,ps,rs);
        }
    }



    @Test
    public void testLogin(){
        System.out.println(isLogin("abc","123"));
    }
}
