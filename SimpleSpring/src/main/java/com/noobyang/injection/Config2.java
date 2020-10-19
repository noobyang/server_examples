package com.noobyang.injection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config2 {

    @Bean(name = "userDao2")
    public UserDao2 userDao() {

        return new UserDao2();
    }

    @Bean(name="userService2")
    public UserService2 userService() {

        UserService2 userService = new UserService2();

        userService.setUserDao(userDao());

        return userService;
    }

}
