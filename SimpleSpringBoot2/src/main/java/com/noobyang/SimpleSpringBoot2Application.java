package com.noobyang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages={"com.noobyang.*"})
@ComponentScan("com.noobyang.*") // 扫描所需要的包
// 如果 ComponentScan 不覆盖 mapper 目录，可以使用下面注解单独配置 mapper 目录
//@MapperScan(basePackages = {"com.noobyang.mapper"}, sqlSessionFactoryRef = "sqlSessionFactory")
public class SimpleSpringBoot2Application {

    public static void main(String[] args) {
        SpringApplication.run(SimpleSpringBoot2Application.class, args);
    }

}
