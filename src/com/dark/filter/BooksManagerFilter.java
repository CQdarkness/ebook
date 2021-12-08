package com.dark.filter;

import com.dark.model.Admin;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/booksManager/*")
public class BooksManagerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //请求设置字符集
        servletRequest.setCharacterEncoding("utf-8");
        //强转成HttpServlet的请求和响应
        HttpServletRequest req= (HttpServletRequest) servletRequest;
        HttpServletResponse resp= (HttpServletResponse) servletResponse;
        //权限验证
        Admin admin = (Admin) req.getSession().getAttribute("admin");
        if(admin==null){
            resp.sendRedirect("../login.jsp");
            return;
        }
        //将请求和响应对象传回过滤链接
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
