package com.dark.servlet;

import com.dark.model.Category;
import com.dark.model.Message;
import com.dark.service.CategoryService;
import com.dark.service.impl.CategoryServiceImpl;
import com.dark.util.JsonWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/category.do")
public class CategoryServlet extends BaseServlet{
    private CategoryService categoryService = new CategoryServiceImpl();
    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

        System.out.println(categoryService.insertCategory(category));
//        resp.sendRedirect("category_display.jsp");
    }
    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
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
        System.out.println(categoryService.updateCategory(category));
        resp.sendRedirect("category_display.jsp");
    }
    public void display(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //获取数据
        List<Category> allCategory = categoryService.findAllCategory();
        //封装成Message
        Message message = new Message(allCategory);
        JsonWriter.write(message,resp);
    }
}
