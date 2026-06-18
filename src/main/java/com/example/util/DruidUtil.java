package com.example.util;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DruidUtil {
    private static DataSource ds = null;

    public static Connection getConnection() {
        if (ds == null) {
            InputStream in = DruidUtil.class.getClassLoader().getResourceAsStream(
                    "druid.properties");
            Properties prop = new Properties();
            try {
                prop.load(in);
                ds = DruidDataSourceFactory.createDataSource(prop);
            } catch (Exception e) {
                throw new RuntimeException("获取数据库连接报错",e);
            }
        }

        try {
            return ds.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
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
