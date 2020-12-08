package com.noobyang.request;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * 参考地址：
 *
 * https://www.cnblogs.com/aknife/p/11265878.html
 */
public class CustomHttpClient {

    public static void doGet() {
        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建http GET请求
        HttpGet httpGet = new HttpGet("http://127.0.0.1:8080/testMongo");

        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = httpclient.execute(httpGet);
            System.out.println(response.getStatusLine());
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println(content);
            }
        }catch(Exception e){
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    response.close();
                    httpclient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void doPost() throws UnsupportedEncodingException {
        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClientBuilder.create().setRedirectStrategy(new LaxRedirectStrategy()).build();
        // 创建http POST请求
        HttpPost httpPost = new HttpPost("http://127.0.0.1:8080/insertUser");
        // 设置2个post参数，一个是scope、一个是q
        List<NameValuePair> parameters = new ArrayList<NameValuePair>();
        parameters.add(new BasicNameValuePair("name", "post"));
        parameters.add(new BasicNameValuePair("age", "100"));
        // 构造一个form表单式的实体
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters);
        // 将请求实体设置到httpPost对象中
        httpPost.setEntity(formEntity);

        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = httpclient.execute(httpPost);
            System.out.println(response.getStatusLine());
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println(content);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if (response != null) {
                try {
                    response.close();
                    httpclient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
