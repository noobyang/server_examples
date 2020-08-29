package server;

import java.io.*;

public class HelloServlet implements Servlet {
    public void init() throws Exception {
        System.out.println("HelloServlet init");
    }

    public void service(byte[] requestBuffer, OutputStream out) throws Exception {
        String request = new String(requestBuffer);

        // 获取 HTTP 请求的第一行
        String firstLineOfRequest = request.substring(0, request.indexOf("\r\n"));
        // 解析 HTTP 请求的第一行
        String[] parts = firstLineOfRequest.split(" ");
        String method = parts[0];
        String uri = parts[1];


        // 获取请求参数 username
        String username = null;

        // 如果请求方式为 get 则请求参数紧跟 HTTP 请求的第一行的 uri 的后面
        if (method.equalsIgnoreCase("get") && uri.indexOf("username=") != -1) {
            //parameters="username=Tom&password=1234"
            String parameters = uri.substring(uri.indexOf("?"), uri.length());

            //parts={"username=Tom","password=1234"};
            parts = parameters.split("&");
            //parts={"username","Tom"};
            parts = parts[0].split("=");
            username = parts[1];
        }

        // 如果请求方式为 post 则请求参数位于 HTTP 请求的正文中
        if (method.equalsIgnoreCase("post")) {
            int locate = request.indexOf("\r\n\r\n");
            // 获取请求正文
            String content = request.substring(locate + 4, request.length());
            if (content.indexOf("username=") != -1) {
                //parts={"username=Tom","password=1234"};
                parts = content.split("&");
                //parts={"username","Tom"};
                parts = parts[0].split("=");
                username = parts[1];
            }
        }

        // 创建 HTTP 响应的第一行
        out.write("HTTP/1.1 200 OK\r\n".getBytes());
        // 发送 HTTP 响应头
        out.write("Content-Type:text/html\r\n\r\n".getBytes());
        // 发送 HTTP 响应正文
        out.write("<html><head><title>HelloWorld</title></head><body>".getBytes());
        out.write(new String("<h1>Hello:" + username + "</h1></body><head>").getBytes());

    }
}
