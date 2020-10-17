package com.noobyang.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

// 加载配置类的信息
@ContextConfiguration(classes = Configuration.class)
public class Test1 {

    @Test
    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        IUser userDao = (IUser) applicationContext.getBean("userDao");

        System.out.println(userDao);
    }
}