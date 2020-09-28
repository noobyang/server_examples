package com.noobyang.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SessionServlet", urlPatterns = "/SessionServlet")
public class SessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 访问一个网站,只要不关闭该浏览器，不管该用户点击多少个超链接，访问多少资源，直到用户关闭浏览器，
        // 整个这个过程我们称为一次会话.

        // Cookie是由W3C组织提出，最早由netscape社区发展的一种机制
        // Cookie的流程：
        // 浏览器访问服务器，如果服务器需要记录该用户的状态，
        // 就使用response向浏览器发送一个Cookie，浏览器会把Cookie保存起来。
        // 当浏览器再次访问服务器的时候，浏览器会把请求的网址连同Cookie一同交给服务器。

        // 设置response的编码
        resp.setContentType("text/html;charset=UTF-8");
        // 创建Cookie对象，指定名称和值
        Cookie cookie = new Cookie("username", "noobyang");
        //设置Cookie的时间
        cookie.setMaxAge(1000);
        // 向浏览器给一个Cookie
        resp.addCookie(cookie);
        resp.getWriter().write("我已经向浏览器发送了一个Cookie");





    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
