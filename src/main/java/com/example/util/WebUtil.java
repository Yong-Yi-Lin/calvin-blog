package com.example.util;

import com.example.pojo.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;

public class WebUtil {
    public static User checkLogin(HttpServletRequest req){
        User user = null;
        HttpSession session = req.getSession(false);
        if(session != null){
            user = (User) session.getAttribute("user");
            return user;
        }
        return null;
    }

    //使用单例
    private static ObjectMapper mapper = new ObjectMapper();

    //反序列化：json字符串转换Java对象
    //使用泛型，传一个什么类型，就返回该类型的对象
    //泛型方法：方法限定符 <类型型参列表> 返回值类型 方法名
    public static <T> T read(InputStream is,Class<T> clazz){
        try {
            return mapper.readValue(is,clazz);
        } catch (IOException e) {
            throw new RuntimeException("json反序列化出错",e);
        }
    }

    //序列化：将java对象转化为json字符串
    public static String write(Object o){
        try {
            return mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("json序列化出错",e);
        }
    }
}
