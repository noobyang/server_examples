package com.noobyang.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        IUser iUser = (IUser) applicationContext.getBean("userDao");
        System.out.println("main " + iUser.getClass());
        iUser.save();

    }

}
