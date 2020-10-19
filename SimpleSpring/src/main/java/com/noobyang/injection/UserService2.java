package com.noobyang.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService2 {

    private UserDao2 userDao2;

    @Autowired
    public void setUserDao(UserDao2 userDao2) {
        this.userDao2 = userDao2;

        // 看看有没有拿到userDao
        System.out.println("setUserDao " + userDao2);
    }

    public void save() {
        userDao2.save();
    }

}
