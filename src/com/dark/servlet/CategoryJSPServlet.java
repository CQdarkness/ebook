package com.dark.servlet;

import com.dark.model.Category;
import com.dark.service.CategoryService;
import com.dark.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/booksManager/category.do")
public class CategoryJSPServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //利用隐藏域属性判断表单类型
        String op = req.getParameter("op");
        if ("add".equals(op)) {
            //拿表单内容
            String name = req.getParameter("name");
            String navable = req.getParameter("navable");
            if (name == null) {
                resp.sendRedirect("category_add.jsp");
                return;
            }
            //封装对象
            Category category = new Category();
            category.setName(name);
            if (navable == null) {
                navable = "N";
            }
            category.setNavable(navable);
            category.setStatus("y");
            category.setSort(2);
            //存储到数据库
            CategoryService categoryService = new CategoryServiceImpl();
            System.out.println(categoryService.insertCategory(category));
            resp.sendRedirect("category_display.jsp");
        }else if("update".equals(op)){
            String name = req.getParameter("name");
            String navable = req.getParameter("navable");
            String status = req.getParameter("status");
            String sort = req.getParameter("sort");
            String updateId = req.getParameter("updateId");
            if (name == null) {
                resp.sendRedirect("category_update.jsp");
                return;
            }
            //封装对象
            Category category = new Category();
            category.setName(name);
            if (navable == null) {
                navable = "N";
            }
            if(status==null){
                status ="N";
            }
            if(sort==null){
                sort="0";
            }
            category.setId(Integer.parseInt(updateId));
            category.setNavable(navable);
            category.setStatus(status);
            category.setSort(Integer.parseInt(sort.charAt(0)+""));
            //更新存储到数据库
            CategoryService categoryService = new CategoryServiceImpl();
            System.out.println(categoryService.updateCategory(category));
            resp.sendRedirect("category_display.jsp");
        }
    }
}
