package com.noobyang;

import com.opensymphony.xwork2.ActionSupport;

public class PrivilegeAction extends ActionSupport {

    public String login() {
        System.out.println("我是登陆");

        return "success";
    }

    public String register() {
        System.out.println("我是注册");
        return "success";
    }

}
