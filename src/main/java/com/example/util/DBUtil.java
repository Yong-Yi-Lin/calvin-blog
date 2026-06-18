package com.example.util;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//数据库工具类，提供获取数据库连接，释放资源统一代码
public class DBUtil {

    //一个程序，连接一个数据库，只需要一个连接池，其中保存了多个数据库连接对象
    private static MysqlDataSource ds; //静态变量，类加载时执行初始化，只执行一次
    //获取连接池，内部使用，不开放
    private static DataSource getDataSource() throws SQLException {
        if(ds == null){
            ds = new MysqlDataSource();
            ds.setURL("jdbc:mysql://127.0.0.1:3306/blog");
            ds.setUser("root");
            ds.setPassword("hlw");
            ds.setUseSSL(false); //不安全连接，不设置会有警告
            ds.setCharacterEncoding("UTF-8");
        }
        return ds;
    }

    //获取数据库连接对象，开放给外部的jdbc代码使用
    public static Connection getConnection(){
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("获取数据库连接报错",e);
        }
    }

    //释放资源,查询操作需要释放三个资源
    public static void close(Connection c, Statement s, ResultSet rs){
        try {
            if(rs != null) rs.close();
            if(s != null) s.close();
            if(c != null) c.close();
        } catch (SQLException e) {
            throw new RuntimeException("释放数据库资源出错",e);
        }
    }

    //更新操作释放两个资源
    public static void close(Connection c,Statement s){
        close(c,s,null);
    }
}

