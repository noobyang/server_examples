package com.noobyang.header;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "NoCacheServlet", urlPatterns = "/NoCacheServlet")
public class NoCacheServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 浏览器有三消息头设置缓存，为了兼容性！将三个消息头都设置了
        resp.setDateHeader("Expires", -1);
        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Pragma", "no-cache");

        // 这里为了看效果
        PrintWriter printWriter = resp.getWriter();
        printWriter.print("你好 " + new Date().toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
