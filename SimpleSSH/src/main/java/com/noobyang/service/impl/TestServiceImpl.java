package com.noobyang.service.impl;

import com.noobyang.service.ITestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements ITestService {
    @Override
    public void say() {
        System.out.println("Say Hello World !");
    }
}
