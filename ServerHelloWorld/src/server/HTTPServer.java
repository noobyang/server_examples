package server;

import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

public class HTTPServer {

    private static Map servletCache = new HashMap();

    public static void main(String args[]) {
        int port;
        ServerSocket serverSocket;

        try {
            port = Integer.parseInt(args[0]);
        } catch (Exception e) {
            System.out.println("port = 8080 (默认)");
            port = 8080; //默认端口 8080
        }

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("服务器正在监听端口：" + serverSocket.getLocalPort());

            while (true) {
                try {
                    final Socket socket = serverSocket.accept();
                    System.out.println("建立了与客户的一个新的TCP连接，该客户的地址为：" +
                            socket.getInetAddress() + ":" + socket.getPort());

                    service(socket);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } //#while
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 响应客户的 HTTP 请求
     */
    public static void service(Socket socket) throws Exception {

        /*读取 HTTP 请求信息*/
        InputStream socketIn = socket.getInputStream();
        Thread.sleep(500);
        int size = socketIn.available();
        byte[] requestBuffer = new byte[size];
        socketIn.read(requestBuffer);
        String request = new String(requestBuffer);
        System.out.println(request);

        /*解析 HTTP 请求*/
        //获取 HTTP 请求的第一行
        String firstLineOfRequest = request.substring(0, request.indexOf("\r\n"));
        //解析 HTTP 请求的第一行
        String[] parts = firstLineOfRequest.split(" ");
        String uri = parts[1];


        /**
         * ……………………………………………………………………………………………………………………………………………………
         * 处理 servlet 逻辑
         *
         * GET /server/HelloServlet?username=Tom&password=1234 HTTP/1.1
         */
        if (uri.indexOf("servlet") != -1) {
            // 获取 servlet 名字
            String servletName = null;
            if (uri.indexOf("?") != -1)
                servletName = uri.substring(uri.indexOf("servlet/") + 8, uri.indexOf("?"));
            else
                servletName = uri.substring(uri.indexOf("servlet/") + 8, uri.length());

            // 尝试从缓存中取出 servlet
            Servlet servlet = (Servlet) servletCache.get(servletName);
            if (servlet == null) {
                servlet = (Servlet) Class.forName("server." + servletName).newInstance();
                servlet.init();
                servletCache.put(servletName, servlet);
            }

            // 调用 servlet 的 service 方法
            servlet.service(requestBuffer, socket.getOutputStream());

            // 睡 1 秒等待客户接收 HTTP 响应结果
            Thread.sleep(1000);
            socket.close();
            return;
        }
        /**
         * 处理 servlet 逻辑
         * ……………………………………………………………………………………………………………………………………………………
         */


        /**
         * 决定 HTTP 请求正文的类型
         *
         * GET /index.htm HTTP/1.1
         */
        String contentType;
        if (uri.indexOf("html") != -1 || uri.indexOf("htm") != -1)
            contentType = "text/html";
        else if (uri.indexOf("jpg") != -1 || uri.indexOf("jpeg") != -1)
            contentType = "image/jpeg";
        else if (uri.indexOf("gif") != -1)
            contentType = "image/gif";
        else
            contentType = "application/octet-stream";


        /*创建 HTTP 响应结果*/
        //HTTP 响应第一行
        String responseFirstLine = "HTTP/1.1 200 OK\r\n";
        //HTTP 响应头
        String responseHeader = "Content-Type:" + contentType + "\r\n\r\n";
        //获得读取响应正文数据的输入流
        InputStream in = HTTPServer.class.getResourceAsStream("root/" + uri);

        /*发送 HTTP 响应结果*/
        OutputStream socketOut = socket.getOutputStream();
        //发送 HTTP 响应的第一行
        socketOut.write(responseFirstLine.getBytes());
        //发送 HTTP 响应的头
        socketOut.write(responseHeader.getBytes());
        //发送 HTTP 响应的正文
        int len = 0;
        byte[] buffer = new byte[128];
        while ((len = in.read(buffer)) != -1) {
            socketOut.write(buffer, 0, len);
        }

        Thread.sleep(1000);
        socket.close();

    }
}
