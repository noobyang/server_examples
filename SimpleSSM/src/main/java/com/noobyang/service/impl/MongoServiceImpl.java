package com.noobyang.service.impl;

import com.noobyang.entity.Dept;
import com.noobyang.service.IMongoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("mongoService")
public class MongoServiceImpl implements IMongoService {

    private static final Logger logger = LoggerFactory.getLogger("MongoServiceImpl");

    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public void insert(Dept dept) {
        logger.info("insert " + dept.toString());
        try {
            mongoTemplate.insert(dept);
        } catch (Exception e) {
            logger.debug(e.toString());
        }
    }
}
