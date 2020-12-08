package com.noobyang.service.impl;

import com.noobyang.service.IMongoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Repository("mongoService")
public class MongoServiceImpl implements IMongoService {

    private static final Logger logger = LoggerFactory.getLogger("MongoServiceImpl");

    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public void save() {
        logger.info("save ");

        Map<String, Object> map = new HashMap<>();
        map.put("_id", "id_" + System.currentTimeMillis()); // Warring: 貌似一定要加 _id
        map.put("AAA", "qwertyu");
        map.put("BBB", "123456789");
        map.put("CCC", "abcdef");

        mongoTemplate.save(map, "testSave");
    }
}
