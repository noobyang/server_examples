package com.noobyang.aop;

import org.springframework.stereotype.Component;

@Component
public class OrderDao {

    public void save() {

        System.out.println("我已经进货了！！！");

    }
}
