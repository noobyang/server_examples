package com.noobyang.controller;

import com.noobyang.entity.Book;
import com.noobyang.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;


@Controller
public class HelloController {

    @RequestMapping(method = RequestMethod.GET, value = "/hello_get")
    public @ResponseBody String helloGet() {
        System.out.println("欢迎进入 SpringBoot helloGet");
        return "Get Hello World!";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/hello_post")
    public @ResponseBody String helloPost(String fname, String lname) {
        System.out.println("欢迎进入 SpringBoot helloPost");
        return "Post Hello World! " + fname + " " + lname;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/hello_post_response", produces = MediaType.APPLICATION_XML_VALUE)
    public @ResponseBody Book helloPostResponse() {
        System.out.println("欢迎进入 SpringBoot helloPostResponse");
        Book book = new Book("道德经", "老子", "0001", 100.1f);
        return book;
    }

    /**
     * Respond Add Header
     */
    @RequestMapping(method = RequestMethod.POST, value = "/hello_post_response_header", produces = MediaType.APPLICATION_XML_VALUE)
    public @ResponseBody String helloPostResponseHeader(HttpServletResponse response) {
        System.out.println("欢迎进入 SpringBoot helloPostResponseHeader");
        response.addHeader("Baeldung-Example-Header", "Value-HttpServletResponse");
        return "Response with header using HttpServletResponse";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/hello_post_response_headers", produces = MediaType.APPLICATION_XML_VALUE)
    public @ResponseBody
    ResponseEntity<String> helloPostResponseHeaders() {
        System.out.println("欢迎进入 SpringBoot helloPostResponseHeaders");
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Baeldung-Example-Header", "Value-ResponseEntityBuilderWithHttpHeaders");

        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body("Response with header using ResponseEntity");
    }


    @RequestMapping(method = RequestMethod.POST, value = "/hello_post_cross_domain")
    public @ResponseBody
    ResponseEntity<String> helloPostCrossDomain() {
        System.out.println("欢迎进入 SpringBoot helloPostCrossDomain");

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Origin", "*"); //  这里最好明确的写允许的域名
        responseHeaders.set("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
        responseHeaders.set("Access-Control-Max-Age", "3600");
        responseHeaders.set("Access-Control-Allow-Headers", "Content-Type,Access-Token,Authorization,ybg");

        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body("Post Hello World! helloPostCrossDomain ");

    }

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(method = RequestMethod.POST, value = "/test_redis")
    public @ResponseBody
    String testRedis(String key, String value) {
        System.out.println("欢迎进入 SpringBoot testRedis " + key + ", " + value);
        userService.setValueRedis(key, value);
        return "redis Hello World!";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/selectUsers")
    public @ResponseBody
    String selectUsers() {
        System.out.println("欢迎进入 SpringBoot selectUsers ");
        return userService.selectUsers().toString();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/selectUser/{id}")
    public @ResponseBody
    String selectUser(@PathVariable int id) {
        System.out.println("欢迎进入 SpringBoot selectUser " + id);
        return userService.selectUser(id).toString();
    }


    @RequestMapping(method = RequestMethod.POST, value = "/insertUser")
    public @ResponseBody
    String insertUser(String name, int age) {
        System.out.println("欢迎进入 SpringBoot insertUser " + name + ", " + age);
        userService.insertUser(name, age);
        return "mybatis Hello World!";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/testMongo")
    public @ResponseBody
    String testMongo() {
        System.out.println("欢迎进入 SpringBoot testMongo");
        userService.saveMongo();
        return "mongo Hello World!";
    }

}
