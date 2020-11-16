package com.noobyang.action;

import com.noobyang.service.ITestService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class TestAction extends ActionSupport {

    @Qualifier("testServiceImpl")
    @Autowired
    private ITestService testServiceImpl;
    public String test1()  {
        testServiceImpl.say();
        return SUCCESS;
    }

}
