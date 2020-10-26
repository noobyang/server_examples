package com.noobyang.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringJDBC {

    private static final Logger log = LoggerFactory.getLogger(TestSpringJDBC.class);

    public static void main(String[] args) {

//        noTransaction(args);

        transaction(args);

    }

    private static void transaction(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserService3 userService = (UserService3) applicationContext.getBean("userService3");

        userService.save();
    }

    private static void noTransaction(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserDao3 userDao = (UserDao3) applicationContext.getBean("userDaoJDBC");

        userDao.save();
    }

}
