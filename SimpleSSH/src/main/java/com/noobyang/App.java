package com.noobyang;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {


    }

    public static void testStruts() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        System.out.println(context);
    }



}
