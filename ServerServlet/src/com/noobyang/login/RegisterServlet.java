package com.noobyang.login;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet",urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //得到用户带过来的数据，封装到Bean对象中
        String username = request.getParameter("username");
        String psd = request.getParameter("psd");

        User user = new User();
        user.setPsd(psd);
        user.setUsername(username);

        try {
            //调用Service方法
            UserService userService = new UserService();
            userService.register(user);

            //注册成功跳转到登陆界面
            request.getRequestDispatcher("/login.jsp").forward(request, response);

            //注册成功，我也可以跳转到首页
            //request.getRequestDispatcher("/index.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();

            //注册失败，跳转到相关的提示页面
            request.setAttribute("message","注册失败了！！！");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);

    }
}