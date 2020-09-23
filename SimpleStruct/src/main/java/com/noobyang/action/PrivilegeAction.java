package com.noobyang.action;

import com.opensymphony.xwork2.ActionSupport;

public class PrivilegeAction extends ActionSupport {

    // 如果我们 action 不写 method 的话，默认执行的是 execute() 方法, execute() 方法默认返回值是 SUCCESS
    @Override
    public String execute() throws Exception {
        System.out.println("我是execute()");

        return SUCCESS;
    }

    public String login() {
        System.out.println("我是登陆");

        return "success";
    }

    public String register() {
        System.out.println("我是注册");
        return "success";
    }

}
