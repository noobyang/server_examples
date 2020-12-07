package com.noobyang.service;

import com.noobyang.entity.User;

public interface IUserService {

    void setValueRedis(String key, String value);

    User selectUser(int id);

//    User selectUser();

    void insertUser(String name, int age);

}
