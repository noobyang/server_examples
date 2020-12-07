package com.noobyang.service;

import com.noobyang.entity.User;

import java.util.List;

public interface IUserService {

    void setValueRedis(String key, String value);

    User selectUser(int id);

    List<User> selectUsers();

    void insertUser(String name, int age);

}
