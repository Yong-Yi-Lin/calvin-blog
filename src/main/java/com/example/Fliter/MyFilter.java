package com.example.Fliter;


import com.example.pojo.User;
import com.example.util.WebUtil;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "MyFilter", urlPatterns = {""})
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpSession session = httpServletRequest.getSession(false);
        User user = WebUtil.checkLogin(httpServletRequest);
        if (session == null || user == null) {
            String p = httpServletRequest.getContextPath();
            String redirectUrl = httpServletRequest.getContextPath() + "/login.html";
            String message = "请先登录";
            String html = "<html><body><script>alert('" + message + "'); window.location.href='" + redirectUrl + "';</script></body></html>";

            ((HttpServletResponse) response).setContentType("text/html;charset=UTF-8");
            ((HttpServletResponse) response).getWriter().write(html);
            return;
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}