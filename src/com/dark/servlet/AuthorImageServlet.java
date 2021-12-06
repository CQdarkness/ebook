package com.dark.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Random;

@WebServlet("/auImage.do")
public class AuthorImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("image/jpeg;charset=utf-8");
//        PrintWriter writer = resp.getWriter();
        //获取请求头
//        Enumeration<String> headerNames = req.getHeaderNames();
//        writer.print("headerName:"+headerNames);
        //生成图片
        int width=180;
        int height=50;
        //内存中创建图片
        BufferedImage valideImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        //得到图片，便于编辑
        Graphics graphics = valideImage.getGraphics();
        //设置图片样式
        graphics.setColor(Color.white);
        graphics.fillRect(0,0,width,height);
        graphics.setColor(Color.cyan);
        graphics.drawRect(1,1,width-3,height-3);
        //随机划线
        graphics.setColor(Color.ORANGE);
        for(int i=0;i<6;i++){
            int x1=new Random().nextInt(width);
            int x2=new Random().nextInt(width);
            int y1=new Random().nextInt(height);
            int y2=new Random().nextInt(height);
            graphics.drawLine(x1,y1,x2,y2);
        }
        //数字和字母的组合
        String baseNumLetter = "0123456789ABCDEFGHJKLMNOPQRSTUVWXYZ";
        String randomChar = createRandomChar((Graphics2D) graphics, baseNumLetter);
        //存入session
        req.getSession().setAttribute("vcode",randomChar);
        //设置响应头控制浏览器不要缓存
        resp.setDateHeader("expries", -1);
        resp.setHeader("Cache-Control", "no-cache");
        resp.setHeader("Pragma", "no-cache");
        //输出
        ImageIO.write(valideImage,"jpg",resp.getOutputStream());

    }
    /**
     * 创建随机字符
     * @param g
     * @param baseChar
     * @return 随机字符
     */
    private String createRandomChar(Graphics2D g,String baseChar) {
        g.setFont(new Font("宋体", Font.BOLD, 25));
        StringBuffer sb = new StringBuffer();
        int x = 20;
        String ch ="";
        // 控制字数
        for (int i = 0; i < 5; i++) {
            // 设置字体旋转角度
            int degree = new Random().nextInt() % 30;
            ch = baseChar.charAt(new Random().nextInt(baseChar.length())) + "";
            sb.append(ch);
            // 正向角度
            g.rotate(degree * Math.PI / 180, x, 20);
            g.drawString(ch, x, 30);
            // 反向角度
            g.rotate(-degree * Math.PI / 180, x, 20);
            x += 30;
        }
        return sb.toString();
    }
}
