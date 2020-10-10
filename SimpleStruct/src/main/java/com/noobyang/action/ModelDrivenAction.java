package com.noobyang.action;

import com.noobyang.bean.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ModelDrivenAction extends ActionSupport implements ModelDriven<User> {

    // 这里一定要实例化
    User user = new User();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public User getModel() {
        return user;
    }

    @Override
    public String execute() throws Exception {

        System.out.println(user);

        return SUCCESS;
    }

}
