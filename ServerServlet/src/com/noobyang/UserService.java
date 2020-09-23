package com.noobyang;

public class UserService {

    private UserDao userDao = new UserDao();

    public User longin(User user) {
        return userDao.login(user);
    }

    public void register(User user) {
        userDao.register(user);
    }

}