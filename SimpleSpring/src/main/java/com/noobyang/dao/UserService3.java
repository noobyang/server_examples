package com.noobyang.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService3 {

    @Autowired
    private UserDao3 userDaoJDBC;

    @Transactional
    public void save() {
        userDaoJDBC.save();
        int i = 1 / 0;
        userDaoJDBC.save();

    }

}
