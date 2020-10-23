package com.noobyang.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringJDBC {

    private static final Logger log = LoggerFactory.getLogger(TestSpringJDBC.class);

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserDao userDao = (UserDao) applicationContext.getBean("userDaoJDBC");

        userDao.save();
    }

}
