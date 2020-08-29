package client;

import java.net.*;
import java.io.*;
import java.nio.charset.Charset;
import java.util.*;

public class HTTPClient {
    public static void main(String args[]) {
        //确定 HTTP 请求的 uri
        String uri = "index.htm";
        if (args.length != 0) uri = args[0];

        doGet("localhost", 8080, uri); //按照GET请求方式访问HTTPServer
    }

    /**
     * 按照GET请求方式访问HTTPServer
     */
    public static void doGet(String host, int port, String uri) {
        Socket socket = null;

        try {
            // 创建HTTP请求
            socket = new Socket(host, port);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            // HTTP 请求头
            StringBuffer sb = new StringBuffer("GET " + uri + " HTTP/1.1\r\n");
            sb.append("Accept: */*\r\n");
            sb.append("Accept-Language: zh-cn\r\n");
            sb.append("Accept-Encoding: gzip, deflate\r\n");
            sb.append("User-Agent: HTTPClient\r\n");
            sb.append("Host: localhost:8080\r\n");
            sb.append("Connection: Keep-Alive\r\n\r\n");

            // 发送HTTP请求
            OutputStream socketOut = socket.getOutputStream();
            socketOut.write(sb.toString().getBytes());

            Thread.sleep(2000);

            /*接收响应结果*/
            InputStream socketIn = socket.getInputStream();
            int size = socketIn.available();
            byte[] buffer = new byte[size];
            socketIn.read(buffer);
            System.out.println(new String(buffer, Charset.forName("UTF-8"))); //打印响应结果

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    } //#doGet()
}

