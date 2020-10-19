package com.noobyang.aop;

public class User implements IUser {
    @Override
    public void say() {
        System.out.println("User say");
    }
}
