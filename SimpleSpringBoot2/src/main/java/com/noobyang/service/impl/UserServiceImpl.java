package com.noobyang.service.impl;

import com.noobyang.entity.User;
import com.noobyang.mapper.UserMapper;
import com.noobyang.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public void saveMongo() {
        Map<String, Object> map = new HashMap<>();
        map.put("_id", "id_" + System.currentTimeMillis()); // Warring: 貌似一定要加 _id
        map.put("AAA", "qwertyu");
        map.put("BBB", "123456789");
        map.put("CCC", "abcdef");

        mongoTemplate.save(map, "testSave");
    }


}
