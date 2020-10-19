package com.noobyang.injection;

import org.springframework.stereotype.Repository;

@Repository("userDao2")
public class UserDao2 {

    public void save() {
        System.out.println("DB:保存用户");
    }

}
