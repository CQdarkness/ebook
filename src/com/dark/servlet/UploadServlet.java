package com.dark.servlet;

import com.alibaba.fastjson.JSONObject;
import com.dark.model.MallUser;
import com.dark.model.Message;
import com.dark.service.MallUserService;
import com.dark.service.impl.MallUserServiceImpl;
import com.dark.util.JsonWriter;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Iterator;
import java.util.List;

@WebServlet("/upload.do")
public class UploadServlet extends BaseServlet {
    public String upload(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //创建DiskFileItemFactory对象
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        //配置临时目录
        ServletContext servletContext = this.getServletConfig().getServletContext();
        File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
        diskFileItemFactory.setRepository(repository);
        //设置上传的目录
        String dirPath = getServletContext().getRealPath("/uploads");
        //创建文件对象
        File file = new File(dirPath);
        //判断目录是否存在
        if (!file.exists()) {
            //创建目录
            file.mkdirs();
        }
        //创建ServletFileUpload对象
        ServletFileUpload upload = new ServletFileUpload(diskFileItemFactory);
        //设置编码
        upload.setHeaderEncoding("UTF-8");
        try {
            //解析请求,得到FileItem集合
            List<FileItem> fileItems = upload.parseRequest(req);
            // Process the uploaded items
            Iterator<FileItem> iter = fileItems.iterator();
            while (iter.hasNext()) {
                FileItem item = iter.next();
                //判断FileItem的类型
                if (item.isFormField()) {
                    //如果是普通的表单元素，处理表单元素
                    //获取表单元素的名称
                    String name = item.getFieldName();
                    if ("username".equals(name)) {
                        //获取表单元素的值
                        String value = item.getString();
                    }

                } else {
                    //如果是文件，执行文件上传操作
                    //processUploadedFile(item);
                    //获取文件名称
                    String fileName = item.getName();  //ISO8859-1 转换成UTF-8

//                    byte[] bytes = fileName.getBytes("GBK");
//                    fileName = new String(bytes,"UTF-8");
                    //获取文件类型
                    String contentType = item.getContentType();
                    //获取文件大小
                    long sizeInBytes = item.getSize();
                    //创建文件对象
                    File uploadedFile = new File(file, fileName);

                    //执行上传操作
                    item.write(uploadedFile);
                    //更新用户信息
                    MallUserService mallUserService=new MallUserServiceImpl();
                    String account = req.getParameter("account");
                    MallUser userByAccount = mallUserService.findUserByAccount(account);
                    System.out.println(uploadedFile.getPath());
                    userByAccount.setAvatar("uploads\\"+uploadedFile.getName());
                    if (mallUserService.updateUser(userByAccount)!=0){
                        return "r:/personal.html";
                    }else{
                        return "r:/personal.html";
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "r:/personal.html";
    }

}
