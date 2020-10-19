package com.noobyang.aop;

public class UserParams implements IUser {

    private String id;
    private String username;

    public UserParams(String id, String username) {
        this.id = id;
        this.username = username;
    }

    @Override
    public void say() {
        System.out.println("UserParams say " + id + " " + username);
    }
}
