package com.noobyang.function;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FunctionServlet", urlPatterns = "/FunctionServlet")
public class FunctionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 方法返回客户端发出请求时的完整URL
        System.out.println("RequestURL " + req.getRequestURL());
        // 方法返回请求行中的资源名部分
        System.out.println("RequestURI " + req.getRequestURI());
        // 方法返回请求行中的参数部分
        System.out.println("QueryString " + req.getQueryString());
        // 方法返回请求URL中的额外路径信息。额外路径信息是请求URL中的位于Servlet的路径之后和查询参数之前的内容，它以“/”开头。
        System.out.println("PathInfo " + req.getPathInfo());
        // 方法返回发出请求的客户机的IP地址
        System.out.println("RemoteAddr " + req.getRemoteAddr());
        // 方法返回发出请求的客户机的完整主机名
        System.out.println("RemoteHost " + req.getRemoteHost());
        // 方法返回客户机所使用的网络端口号
        System.out.println("RemotePort " + req.getRemotePort());
        // 方法返回WEB服务器的IP地址
        System.out.println("LocalAddr " + req.getLocalAddr());
        // 方法返回WEB服务器的主机名
        System.out.println("LocalName " + req.getLocalName());


        // 客户机请求头
        System.out.println("HeaderNames " + req.getHeaderNames());
        System.out.println("Header " + req.getHeader("Expires"));
        System.out.println("Headers " + req.getHeaders("Expires"));

        // 客户机请求参数
        System.out.println("ParameterMap " + req.getParameterMap());
        System.out.println("Parameter " + req.getParameter("name"));
        System.out.println("ParameterValues " + req.getParameterValues("name"));


//        // 防盗链
//        String referer = req.getHeader("Referer");
//        // 如果不是从我的首页来或者从地址栏直接访问的，
//        if (referer == null || !referer.contains("localhost:8080/index.jsp")) {
//            // 回到首页去
//            resp.sendRedirect("/index.jsp");
//            return;
//        }
//
//        // 能执行下面的语句，说明是从我的首页点击进来的，那没问题，照常显示
//        resp.setContentType("text/html;charset=UTF-8");
//        resp.getWriter().write("我来啦啦啦");


        // 超链接方式提交数据
        // resp.sendRedirect("servlet的地址?参数名="+参数值 &"参数名="+参数值);
        // <a href="/zhongfucheng/Servlet111?username=xxx">使用超链接将数据带给浏览器</a>


        // 实现转发
        req.setAttribute("username", "noobyang");
        // 获取到requestDispatcher对象，跳转到index.jsp
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/ServletDispatcher");
        // 调用requestDispatcher对象的forward()实现转发,传入request和response方法
        requestDispatcher.forward(req, resp);

        // 转发是带着转发前的请求的参数的。重定向是新的请求。
        // 转发: 访问 Servlet 处理业务逻辑，然后 forward 到 jsp 显示处理结果，浏览器里 URL 不变
        // 重定向: 提交表单，处理成功后 redirect 到另一个 jsp，防止表单重复提交，浏览器里 URL 变了


        req.getRequestDispatcher("/Head").include(req, resp);
        resp.getWriter().write("--------------------------------------------");
        req.getRequestDispatcher("/Foot").include(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
