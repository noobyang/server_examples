package com.noobyang;

public class UserDao {

    public User login(User user) {

        if ("aaa".equals(user.getUsername()) && "123".equals(user.getPsd())) {

            System.out.println("登陆成功！");
            return user;

        } else {
            System.out.println("登陆失败！");
            return null;
        }
    }

    public void register(User user) {

        System.out.println("注册成功！" + user.getUsername());
    }


}
