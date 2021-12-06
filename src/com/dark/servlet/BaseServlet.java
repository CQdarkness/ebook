package com.dark.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *请求时格式xxx.do?method=xxx
 */
public class BaseServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String methodName = req.getParameter("method");
        if(methodName!=null){
            try {
                //根据方法名称获取该方法对象
                Method method = this.getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
                //调用该方法，并返回结果，如果方法没有返回值，返回结果值为：null
                Object result =  method.invoke(this, req, resp);
                if(result!=null){
                    String url = result.toString();
                    String prefix = url.substring(0,url.indexOf(":"));
                    url = url.substring(url.indexOf(":")+1);
                    //result的返回格式 r:xxx.jsp
                    if("r".equals(prefix)){
                        resp.sendRedirect(getServletContext().getContextPath()+url);
                    }else{
                        req.getRequestDispatcher(url).forward(req,resp);
                    }
                }
            }catch (NoSuchMethodException | SecurityException e) {
                e.printStackTrace();
            } catch (IllegalAccessException | IllegalArgumentException e) {
                e.printStackTrace();
            } catch (InvocationTargetException ex) {
                ex.printStackTrace();
            }
        }
    }
}
