package com.noobyang.action;

import com.opensymphony.xwork2.ActionSupport;

public class InterceptorAction extends ActionSupport {

    public String test() {

        System.out.println("InterceptorAction");

        return "success";
    }

}
