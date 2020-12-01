package com.noobyang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @RequestMapping(method = RequestMethod.GET, value = "/hello_get")
    public @ResponseBody String helloGet() {
        System.out.println("欢迎进入 SpringBoot");
        return "Get Hello World!";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/hello_post")
    public @ResponseBody String helloPost(String fname, String lname) {
        System.out.println("欢迎进入 SpringBoot");
        return "Post Hello World! " + fname + " " + lname;
    }

}
