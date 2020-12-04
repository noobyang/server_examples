package com.noobyang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages={"com.noobyang.*"})
//@ComponentScan("com.noobyang.*") // 扫描所需要的包
@MapperScan("com.noobyang.mapper") //扫描的mapper
public class SimpleSpringBoot2Application {

    public static void main(String[] args) {
        SpringApplication.run(SimpleSpringBoot2Application.class, args);
    }

}
