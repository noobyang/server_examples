package com.noobyang.login;

public class UserService {

    private UserDao userDao = new UserDao();

    public User login(User user) {
        return userDao.login(user);
    }

    public void register(User user) {
        userDao.register(user);
    }

}