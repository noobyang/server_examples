package com.noobyang.service.impl;

import com.noobyang.redis.RedisUtil;
import com.noobyang.service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("redisService")
public class RedisServiceImpl implements IRedisService {

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public void setValueRedis(String key, String value) {
        redisUtil.set(key, value);
    }
}
