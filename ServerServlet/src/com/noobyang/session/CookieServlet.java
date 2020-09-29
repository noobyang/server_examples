package com.noobyang.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

@WebServlet(name = "SessionServlet", urlPatterns = "/SessionServlet")
public class CookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 访问一个网站,只要不关闭该浏览器，不管该用户点击多少个超链接，访问多少资源，直到用户关闭浏览器，
        // 整个这个过程我们称为一次会话.

        // Cookie是由W3C组织提出，最早由netscape社区发展的一种机制
        // Cookie的流程：
        // 浏览器访问服务器，如果服务器需要记录该用户的状态，
        // 就使用response向浏览器发送一个Cookie，浏览器会把Cookie保存起来。
        // 当浏览器再次访问服务器的时候，浏览器会把请求的网址连同Cookie一同交给服务器。


        // 取出 Cookie
        Cookie[] cookies = req.getCookies();
        for (int i = 0; cookies != null && i < cookies.length; i++) {
            String name = cookies[i].getName();
            // 经过 URLEncoding 就要 URLDecoding
            String value = URLDecoder.decode(cookies[i].getValue(), "UTF-8");
        }


        // 设置 Cookie
        // 设置response的编码
        resp.setContentType("text/html;charset=UTF-8");
        // 创建Cookie对象，指定名称和值
        Cookie cookie = new Cookie("username", URLEncoder.encode("中文", "UTF-8"));
        //设置Cookie的时间
        cookie.setMaxAge(1000);
        // 一级域名相同的网页Cookie之间可以相互访问
        cookie.setDomain(".noobyang.com");
        // 设置只允许 SessionServlet 访问
        cookie.setPath("/SessionServlet");
        // HTTP协议不仅仅是无状态的，而且是不安全的！如果不希望Cookie在非安全协议中传输，
        // 可以设置Cookie的secure属性为true，浏览器只会在HTTPS和SSL等安全协议中传输该Cookie。
        // 当然了，设置secure属性不会将Cookie的内容加密。
        cookie.setSecure(true);
        // 向浏览器给一个Cookie
        resp.addCookie(cookie);
        resp.getWriter().write("我已经向浏览器发送了一个Cookie");


        // Cookie Max Age
        // 如果MaxAge为正数，浏览器会把Cookie写到硬盘中，只要还在MaxAge秒之前，登陆网站时该Cookie就有效【不论关闭了浏览器还是电脑】
        // 如果MaxAge为负数，Cookie是临时性的，仅在本浏览器内有效，关闭浏览器Cookie就失效了，Cookie不会写到硬盘中。Cookie默认值就是-1。这也就为什么在我第一个例子中，如果我没设置Cookie的有效期，在硬盘中就找不到对应的文件。
        // 如果MaxAge为0，则表示删除该Cookie。Cookie机制没有提供删除Cookie对应的方法，把MaxAge设置为0等同于删除Cookie

        // Cookie的名称相同，通过response添加到浏览器中，会覆盖原来的Cookie。

        // 删除，修改Cookie时，新建的Cookie除了value、maxAge之外的所有属性都要与原Cookie相同。
        // 否则浏览器将视为不同的Cookie，不予覆盖，导致删除修改失败！



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
