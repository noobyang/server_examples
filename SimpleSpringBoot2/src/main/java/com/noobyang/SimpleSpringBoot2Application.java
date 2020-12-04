package com.noobyang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.noobyang.*") // 扫描所需要的包
public class SimpleSpringBoot2Application {

    public static void main(String[] args) {
        SpringApplication.run(SimpleSpringBoot2Application.class, args);
    }

}
