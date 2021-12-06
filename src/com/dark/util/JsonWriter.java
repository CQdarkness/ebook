package com.dark.util;

import com.alibaba.fastjson.JSON;
import com.dark.model.Message;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public final class JsonWriter {
    public static void write(Message message, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        //转换为JSON
        Object result = JSON.toJSON(message);
        //写出
        out.print(result);
        //关闭
        out.close();
    }
}
