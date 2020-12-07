package com.noobyang.service.impl;

import com.noobyang.entity.User;
import com.noobyang.mapper.UserMapper;
import com.noobyang.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public void setValueRedis(String key, String value) {
        try {
            ValueOperations<String, String> operations = redisTemplate.opsForValue();
            operations.set(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUser(int id) {
        return userMapper.selectUser(id);
    }

    @Override
    public List<User> selectUsers() {
        return userMapper.selectUsers();
    }

    @Override
    public void insertUser(String name, int age) {
        userMapper.insertUser(name, age);
    }
}
