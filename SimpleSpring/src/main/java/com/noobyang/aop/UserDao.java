package com.noobyang.aop;

import org.springframework.stereotype.Component;

@Component
public class UserDao implements IUser {
    @Override
    public void save() {
        System.out.println("UserDao save");
    }
}
