package com.dark.filter;

import com.dark.model.MallCart;
import com.dark.model.MallUser;
import com.dark.model.Message;
import com.dark.util.JsonWriter;
import com.dark.util.Tools;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter("/cart.do,/pay,/cart.do,/order.do,/personal.do")
public class LoginStatus implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //强转
        HttpServletResponse resp=(HttpServletResponse) servletResponse;
        HttpServletRequest req=(HttpServletRequest) servletRequest;
        Message message=new Message();
        //设置请求编码
        req.setCharacterEncoding("utf-8");
        //判定是否登录
        MallUser mallUser =(MallUser) req.getSession().getAttribute("mallUser");
        if(mallUser==null){
            //未登录，重定向至登录界面
            resp.sendRedirect("login.html");
        }
        //更新筛选链
        filterChain.doFilter(req,resp);
    }
}
