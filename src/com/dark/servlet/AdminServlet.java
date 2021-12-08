package com.dark.servlet;

import com.dark.model.Admin;
import com.dark.service.AdminService;
import com.dark.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/login.do")
public class AdminServlet extends HttpServlet {
    //调用服务
    AdminService adminService=new AdminServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        Admin admin = adminService.login(account, password);
        if(admin!=null){
            HttpSession session = req.getSession();
            session.setAttribute("admin",admin);
            resp.sendRedirect("booksManager/booksManager.jsp");
        }else{
            resp.sendRedirect("login.jsp");
        }

    }
}
