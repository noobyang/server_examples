package com.noobyang;


import java.io.IOException;

@javax.servlet.annotation.WebServlet(name = "RegisterServlet",urlPatterns = "/RegisterServlet")
public class RegisterServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

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

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        this.doPost(request, response);

    }
}