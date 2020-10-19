package com.noobyang.injection;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test2 {

    @Test
    public void test() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(Config2.class);
        applicationContext.refresh();

        UserService2 userService2 = (UserService2) applicationContext.getBean("userService2");
        userService2.save();

        System.out.println(userService2);
    }

}