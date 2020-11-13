package com.noobyang;

import com.noobyang.service.impl.TestServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {


    @Test
    public void testLoad() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println(context);
    }

    @Test
    public void testSpring() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        TestServiceImpl testService = (TestServiceImpl) context.getBean("testServiceImpl");

        testService.say();
    }

    @Test
    public void testStruts() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        TestServiceImpl testService = (TestServiceImpl) context.getBean("testServiceImpl");

        testService.say();
    }



}
