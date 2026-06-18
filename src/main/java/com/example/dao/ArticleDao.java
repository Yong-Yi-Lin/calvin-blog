package com.example.dao;

import com.example.pojo.Article;
import com.example.util.DruidUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ArticleDao {
    //通过用户id查询用户的所有文章
    public static List<Article> searchUserBlog(Integer id){
        List<Article> articles = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            c = DruidUtil.getConnection();
            String sql = "select * from article where user_id=?";
            ps = c.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while(rs.next()){
                Article a = new Article();
                a.setId(rs.getInt("id"));
                a.setTitle(rs.getString("title"));
                java.sql.Date date = rs.getDate("date");
                long time = date.getTime();
                a.setDate(new java.util.Date(time));
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String dateString = df.format(a.getDate());
                a.setDateString(dateString);
                String content = rs.getString("content");
                a.setContent(content.length()>50 ? content.substring(0,50) : content);
                a.setUserId(id);
                a.setLikeCount(rs.getInt("likeCount"));
                a.setAuthor(rs.getString("author"));
                articles.add(a);
            }
            return articles;
        } catch (SQLException e) {
            throw new RuntimeException("查询文章出错",e);
        } finally {
            DruidUtil.close(c,ps,rs);
        }
    }

    //根据文章id查文章
    public static Article searchBlogById(int id) {
        Article a = null;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            c = DruidUtil.getConnection();
            String sql = "select * from article where id=?";
            ps = c.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while(rs.next()){
                a = new Article();
                a.setId(id);
                a.setTitle(rs.getString("title"));
                java.sql.Date date = rs.getDate("date");
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String dateString = df.format(new java.util.Date(date.getTime()));
                a.setDateString(dateString);
                a.setContent(rs.getString("content"));
                a.setUserId(rs.getInt("user_id"));
                a.setLikeCount(rs.getInt("likeCount"));
                a.setAuthor(rs.getString("author"));
            }
            return a;
        } catch (SQLException throwables) {
            throw new RuntimeException("查询文章详情jdbc出错",throwables);
        } finally{
            DruidUtil.close(c,ps,rs);
        }
    }

    //添加一个方法
    //查询所有用户的文章-即查询文章这个表的所有文章
    public static List<Article> selectAllBlogs(){
        List<Article> articles = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            c = DruidUtil.getConnection();
            String sql = "select * from article";
            ps = c.prepareStatement(sql);
            //ps.setInt(1,id);
            rs = ps.executeQuery();
            while(rs.next()){
                Article a = new Article();
                a.setId(rs.getInt("id"));
                a.setTitle(rs.getString("title"));
                java.sql.Date date = rs.getDate("date");
                long time = date.getTime();
                a.setDate(new java.util.Date(time));
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String dateString = df.format(a.getDate());
                a.setDateString(dateString);
                String content = rs.getString("content");
                a.setContent(content.length()>50 ? content.substring(0,50) : content);
                a.setUserId(rs.getInt("user_id"));
                articles.add(a);
                a.setAuthor(rs.getString("author"));
                a.setLikeCount(rs.getInt("likeCount"));
            }
            return articles;
        } catch (SQLException e) {
            throw new RuntimeException("查询文章出错",e);
        } finally {
            DruidUtil.close(c,ps,rs);
        }
    }


    //插入（添加）文章
    public static int insertArticle(Article a) {
        Connection c = null;
        PreparedStatement ps = null;
        try{
            c = DruidUtil.getConnection();
            String sql = "insert into article(title,`date`,content,user_id,author) values(?,?,?,?,?)";
            ps = c.prepareStatement(sql);
            ps.setString(1,a.getTitle());
            //ps.setDate(2,new java.sql.Date(a.getDate().getTime()))
            ps.setDate(2,new java.sql.Date(System.currentTimeMillis()));
            ps.setString(3,a.getContent());
            ps.setInt(4,a.getUserId());
            ps.setString(5,a.getAuthor());
            return ps.executeUpdate();
        } catch (SQLException throwables) {
            throw new RuntimeException("发布文章jdbc出错",throwables);
        } finally {
            DruidUtil.close(c,ps);
        }
    }

    //得到我的文章数量
    public static int getCount(Integer id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            c = DruidUtil.getConnection();
            String sql = "select * from article where user_id=?";
            ps = c.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            int count = 0;
            while(rs.next()){
                count++;
            }
            return count;
        } catch (SQLException throwables) {
            throw new RuntimeException("查询文章数目出错",throwables);
        } finally{
            DruidUtil.close(c,ps,rs);
        }
    }

    public static int getAuthor(Integer id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            c = DruidUtil.getConnection();
            String sql = "select user_id from article where id=?";
            ps = c.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            int user_id = 0;
            while(rs.next()){
                user_id = rs.getInt("user_id");
            }
            return user_id;
        } catch (SQLException throwables) {
            throw new RuntimeException("查询文章数目出错",throwables);
        } finally{
            DruidUtil.close(c,ps,rs);
        }
    }


    //修改文章
    public static int UpdateOne(Article a,Integer id) {
        Connection c = null;
        PreparedStatement ps = null;
        try{
            c = DruidUtil.getConnection();
            String sql = "update article set title=?,date=?,content=?,user_id=? where id=?";
            ps = c.prepareStatement(sql);
            ps.setString(1,a.getTitle());
            ps.setDate(2,new java.sql.Date(System.currentTimeMillis()));
            ps.setString(3,a.getContent());
            ps.setInt(4,a.getUserId());
            ps.setInt(5,id);

            return ps.executeUpdate();
        } catch (SQLException throwables) {
            throw new RuntimeException("修改文章jdbc出错",throwables);
        } finally {
            DruidUtil.close(c,ps);
        }
    }

    //删除文章
    public static int DeleteOne(Integer id) {
        Connection c = null;
        PreparedStatement ps = null;
        try{
            c = DruidUtil.getConnection();
            String sql = "delete from article where id = ?";
            ps = c.prepareStatement(sql);
            ps.setInt(1,id);

            return ps.executeUpdate();
        } catch (SQLException throwables) {
            throw new RuntimeException("删除文章jdbc出错",throwables);
        } finally {
            DruidUtil.close(c,ps);
        }
    }

    //查找点赞量
    public static int getLikeCount(Integer id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            c = DruidUtil.getConnection();
            String sql = "select likeCount from article where id=?";
            ps = c.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            int count = 0;
            while(rs.next()){
                count = rs.getInt("likeCount");
            }
            return count;
        } catch (SQLException throwables) {
            throw new RuntimeException("查询文章数目出错",throwables);
        } finally{
            DruidUtil.close(c,ps,rs);
        }
    }


    //改变点赞数量
    public static int UpdateLike(Integer like,Integer id) {
        Connection c = null;
        PreparedStatement ps = null;
        try{
            c = DruidUtil.getConnection();
            String sql = "update article set likeCount = ? where id = ?";
            ps = c.prepareStatement(sql);
            ps.setInt(1,like);
            ps.setInt(2,id);

            return ps.executeUpdate();
        } catch (SQLException throwables) {
            throw new RuntimeException("修改文章jdbc出错",throwables);
        } finally {
            DruidUtil.close(c,ps);
        }
    }

    //用关键词搜索文章,利用模糊查询
//    SELECT * FROM `article` WHERE title LIKE '%今%' or content LIKE '%今%';
    public static List<Article> searchArticle(String key) {
        List<Article> articles = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            c = DruidUtil.getConnection();
            String sql = "SELECT * FROM article WHERE title LIKE ? or content LIKE ? or author Like ?";
            ps = c.prepareStatement(sql);
            ps.setString(1,"%"+key+"%");
            ps.setString(2,"%"+key+"%");
            ps.setString(3,"%"+key+"%");
            rs = ps.executeQuery();
            while(rs.next()){
                Article a = new Article();
                a.setId(rs.getInt("id"));
                a.setTitle(rs.getString("title"));
                java.sql.Date date = rs.getDate("date");
                long time = date.getTime();
                a.setDate(new java.util.Date(time));
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String dateString = df.format(a.getDate());
                a.setDateString(dateString);
                String content = rs.getString("content");
                a.setContent(content.length()>50 ? content.substring(0,50) : content);
                a.setUserId(rs.getInt("user_id"));
                articles.add(a);
            }
            return articles;


        } catch (SQLException throwables) {
            throw new RuntimeException("检验用户名昵称错误",throwables);
        } finally{
            DruidUtil.close(c,ps,rs);
        }
    }


}
