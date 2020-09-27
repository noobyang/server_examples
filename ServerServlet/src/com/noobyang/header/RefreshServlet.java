package com.noobyang.header;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RefreshServlet", urlPatterns = "/RefreshServlet")
public class RefreshServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 每3秒自动刷新网页一次
//        resp.setHeader("Refresh", "3");
//        resp.getWriter().write("time is :" + System.currentTimeMillis());

        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write("3秒后跳转页面.....");

        // 三秒后跳转到index.jsp页面去，web应用的映射路径我设置成/，url没有写上应用名
        resp.setHeader("Refresh", "3;url='/index.jsp'");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
