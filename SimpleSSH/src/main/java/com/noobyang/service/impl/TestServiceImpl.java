package com.noobyang.service.impl;

import com.noobyang.dao.ITestDao;
import com.noobyang.entity.Person;
import com.noobyang.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service("testServiceImpl")
public class TestServiceImpl implements ITestService {

    @Override
    public void say() {
        System.out.println("Say Hello World !");
    }

    @Autowired
    private ITestDao testDaoImpl;
    @Override
    public void save(Person person) {
        testDaoImpl.save(person);
    }

}
