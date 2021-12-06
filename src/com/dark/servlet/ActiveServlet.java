package com.dark.servlet;

import com.dark.model.MallUser;
import com.dark.service.MallUserService;
import com.dark.service.impl.MallUserServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;
import java.io.IOException;

@WebServlet("/active.do")
public class ActiveServlet extends BaseServlet{
    private MallUserService mallUserService=new MallUserServiceImpl();
    public String activeEmail(HttpServletRequest req, HttpServletResponse resp) throws SerialException, IOException {
        //获取参数
        String vocode = req.getParameter("vcodeEmail");
        MallUser unActiveUser= (MallUser) req.getServletContext().getAttribute("unActiveUser");
        if(unActiveUser!=null&&unActiveUser.getVcode().equals(vocode)){
            unActiveUser.setStatus("y");
            //更新用户信息
            mallUserService.updateUser(unActiveUser);
            return "p:/login_user.html";
        }else{
            return "r:/login_user.html";
        }
    }
}
