package com.dark.servlet;

import com.dark.model.MallUser;
import com.dark.model.Message;
import com.dark.service.MallUserService;
import com.dark.service.impl.MallUserServiceImpl;
import com.dark.util.JsonWriter;
import com.dark.util.MailUtils;
import com.dark.util.Tools;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/user.do")
public class UserServlet extends BaseServlet {
    private MallUserService mallUserService = new MallUserServiceImpl();

    public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取参数
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        //查用户
        MallUser mallUser = mallUserService.findUserByAccount(account);
        //创建消息对象
        Message message = new Message();
        if (mallUser != null) {
            //验证密码
            if (mallUser.getPassword().equals(password)) {
                if (mallUser.getStatus().equals("y")) {
                    //登录成功
                    message.setCode(Tools.SUCCESS);
                    message.setResult("true");
                    message.setData(mallUser);
                    //用户存入session
                    req.getSession().setAttribute("mallUser",mallUser);
                } else {
                    message.setCode(Tools.STATUSERROR);
                    message.setResult("false");
                }
            } else {
                message.setResult("false");
            }
        } else {
            message.setResult("false");
        }
        //调用JsonWriter写出数据
        JsonWriter.write(message, resp);
    }

    public void register(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取参数判断请求类型
        String op = req.getParameter("op");
        Message message = new Message();
        if ("checkEmail".equals(op)) {
            //获取参数
            String email = req.getParameter("email");
            if (!"".equals(email)) {
                MallUser userByEmail = mallUserService.findUserByEmail(email);
                if (userByEmail != null) {
                    message.setResult("true");
                } else {
                    message.setResult("false");
                }
                //写出结果
                JsonWriter.write(message, resp);
                return;
            }
        }else if("checkAccount".equals(op)){
            String account = req.getParameter("account");
            MallUser userByAccount = mallUserService.findUserByAccount(account);
            if (userByAccount != null) {
                message.setResult("true");
            } else {
                message.setResult("false");
            }
            //写出结果
            JsonWriter.write(message, resp);
            return;
        }else if("checkAu".equals(op)){
            String valicode=(String)req.getSession().getAttribute("vcode");
            message.setValicode(valicode);
            //写出结果
            JsonWriter.write(message, resp);
                return;
        }else if ("register".equals(op)) {
            //获取表单数据，封装
            String account = req.getParameter("account");
            String password = req.getParameter("password");
            String email = req.getParameter("email");
//        String status = req.getParameter("status");
            MallUser mallUser = new MallUser();
            mallUser.setAccount(account);
            mallUser.setPassword(password);
            mallUser.setEmail(email);
            mallUser.setAvatar("");
            mallUser.setRegtime(new Date());
            mallUser.setScore(0);
            mallUser.setVcode(Tools.getUUID());
            mallUser.setStatus("n");
            //写入
            mallUserService.register(mallUser);
            //发送邮件
            String title="图书商城激活邮件";
            String text="欢迎使用图书商城，点击下面链接激活账户:<a href='"+
                    "http://127.0.0.1:8080/ebook/active.do?method=activeEmail&vcodeEmail="+
                    mallUser.getVcode()+"'>"+
                    "127.0.0.1:8080/ebook/active.do?method=activeEmail&vcodeEmail="+
                    mallUser.getVcode()+
                    "</a>";
            message.setResult("true");
            //存USER进session
            req.getServletContext().setAttribute("unActiveUser",mallUser);
            //发送
            MailUtils.sendMail(mallUser.getEmail(),text,title);
            JsonWriter.write(message, resp);
        }
    }
}
