package com.noobyang.action;

import com.noobyang.bean.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

public class ParamsAction extends ActionSupport {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String register() {

        //得到ActionContext 对象
        ActionContext context = ActionContext.getContext();
        Map<String, Object> session = context.getSession();
        Map<String, Object> application = context.getApplication();

        //这是request的Map
        Map<String, Object> request = context.getContextMap();

        System.out.println(user.getUsername());
        System.out.println(user.getPsd());

        return "success";
    }

}
