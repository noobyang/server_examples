package com.noobyang.hello;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {

    private String message;

    @Override
    public void init() throws ServletException {
        message = "Hello, First Servlet!";
        System.out.println("init");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        System.out.println("service");
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
        super.destroy();
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("getServletConfig");
        return super.getServletConfig();
    }

    @Override
    public ServletContext getServletContext() {
        System.out.println("getServletContext");
        return super.getServletContext();
    }

    @Override
    public String getServletInfo() {
        System.out.println("getServletInfo");
        return super.getServletInfo();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet");

        // 设置:响应内容类型
        resp.setContentType("text/html;charset=UTF-8");
//        resp.setCharacterEncoding("UTF-8");
        // 设置头信息，告诉浏览器我回送的数据编码是utf-8的
//        resp.setHeader("Content-Type", "text/html;charset=UTF-8");

        // 输出文本
        PrintWriter out = resp.getWriter();
        // 使用meta标签模拟http消息头，告诉浏览器回送数据的编码和格式
        // out.write("<meta http-equiv='content-type' content='text/html;charset=UTF-8'>");

        out.write("<h1> " + message + " </h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        System.out.println("doPost");
    }

}
