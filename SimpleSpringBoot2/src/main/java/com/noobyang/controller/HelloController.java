package com.noobyang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public @ResponseBody String hello() {
        System.out.println("欢迎进入 SpringBoot");
        return "Hello World!";
    }

}
