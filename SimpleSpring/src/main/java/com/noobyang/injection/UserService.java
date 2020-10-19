package com.noobyang.injection;

public class UserService {

    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;

        // 看看有没有拿到userDao
        System.out.println("UserService " + userDao);
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;

        // 看看有没有拿到userDao
        System.out.println("setUserDao " + userDao);
    }

    public void save() {
        userDao.save();
    }

}
