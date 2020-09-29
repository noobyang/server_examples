package com.noobyang.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SessionServlet", urlPatterns = "/SessionServlet")
public class SessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Session 是另一种记录浏览器状态的机制。不同的是Cookie保存在浏览器中，Session保存在服务器中。
        // 用户使用浏览器访问服务器的时候，服务器把用户的信息以某种的形式记录在服务器，这就是Session

        // Session比Cookie使用方便，Session可以解决Cookie解决不了的事情【Session可以存储对象，Cookie只能存储字符串。】


        // 得到Session对象
        HttpSession httpSession = req.getSession();
        // 设置Session属性
        httpSession.setAttribute("name", "noobyang");
        // 获取Session属性
        httpSession.getAttribute("name");
        // 获取Session所有的属性名
        httpSession.getAttributeNames();
        // 移除Session属性
        httpSession.removeAttribute("name");
        // 获取Session被创建时间
        httpSession.getCreationTime();
        // 获取Session的id
        httpSession.getId();
        // 返回Session最后活跃的时间
        httpSession.getLastAccessedTime();
        // 获取ServletContext对象
        httpSession.getServletContext();
        // 设置Session超时时间
        httpSession.setMaxInactiveInterval(1000);
        // 获取Session超时时间
        httpSession.getMaxInactiveInterval();
        // 销毁该Session
//        httpSession.invalidate();
        // 该Session是否为新的
        httpSession.isNew();


        // 一般来讲，当我们要存进的是用户级别的数据就用Session，那什么是用户级别呢？
        // 只要浏览器不关闭，希望数据还在，就使用Session来保存。


        // Session的生命周期和有效期
        // Session在用户第一次访问服务器Servlet，jsp等动态资源就会被自动创建，Session对象保存在内存里，
        // 这也就为什么上面的例子可以直接使用request对象获取得到Session对象。

        // 如果访问HTML,IMAGE等静态资源Session不会被创建

        // Session生成后，只要用户继续访问，服务器就会更新Session的最后访问时间，
        // 无论是否对Session进行读写，服务器都会认为Session活跃了一次。

        // 由于会有越来越多的用户访问服务器，因此Session也会越来越多。
        // 为了防止内存溢出，服务器会把长时间没有活跃的Session从内存中删除，这个时间也就是Session的超时时间。
        // Session的超时时间默认是30分钟，有三种方式可以对Session的超时时间进行修改

        // HTTP协议是无状态的，Session不能依据HTTP连接来判断是否为同一个用户。
        // 于是乎：服务器向用户浏览器发送了一个名为JESSIONID的Cookie，它的值是Session的id值。
        // 其实Session依据Cookie来识别是否是同一个用户。
        // HttpServletResponse类提供了两个URL地址重写的方法：
        //    encodeURL(String url)
        //    encodeRedirectURL(String url)
        // 需要值得注意的是：这两个方法会自动判断该浏览器是否支持Cookie，
        // 如果支持Cookie，重写后的URL地址就不会带有jsessionid了
        // 【当然了，即使浏览器支持Cookie，第一次输出URL地址的时候还是会出现jsessionid（因为没有任何Cookie可带）】
        // esponse.sendRedirect(response.encodeURL(url));
        // URL地址重写的原理：将Session的id信息重写到URL地址中。服务器解析重写后URL，获取Session的id。


        // 生出随机数
        TokenProcessor tokenProcessor = TokenProcessor.getInstance();
        String token = tokenProcessor.makeToken();
        // 将随机数存进Session中
        httpSession.setAttribute("token", token);
        // 跳转到显示页面
        req.getRequestDispatcher("session.jsp").forward(req, resp);



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
