package com.noobyang;

import com.noobyang.dao.impl.DeptDaoImpl;
import com.noobyang.entity.Dept;
import com.noobyang.rabbit.MessageSender;
import com.noobyang.redis.RedisUtil;
import com.noobyang.service.impl.MongoServiceImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;


import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class App {

    private static final Logger logger = LoggerFactory.getLogger("App");

    static private DeptDaoImpl deptDao;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        deptDao = (DeptDaoImpl) context.getBean("deptDao");

        logger.debug("pBeforeClass");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {

        logger.debug("tearDownAfterClass");
    }

    @Test
    public void testSpringMVCSelectDept() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        deptDao = (DeptDaoImpl) context.getBean("deptDao");
        logger.debug("testSpringMVCSelectDept", deptDao.selectDept(1));

    }

    @Test
    public void testMyBatisSelectDept() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

            SqlSession sqlSession = sqlSessionFactory.openSession();

            logger.debug("testMyBatisSelectDept", sqlSession.selectOne("com.noobyang.entity.DeptMapper.selectDept", 1));
            sqlSession.commit();

            sqlSession.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLog4j2() {
        // 记录trace级别的信息
        logger.trace("log4j2日志输出：This is trace message.");
        // 记录debug级别的信息
        logger.debug("log4j2日志输出：This is debug message.");
        // 记录info级别的信息
        logger.info("log4j2日志输出：This is info message.");
        // 记录error级别的信息
        logger.error("log4j2日志输出：This is error message.");
        // 记录warn级别的信息
        logger.warn("log4j2日志输出：This is warn message.");
    }

    @Test
    public void testRedis() {
        logger.debug("testRedis");
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        RedisUtil redisUtil = (RedisUtil) context.getBean("redisUtil");
        redisUtil.set("CCC", "DDD");

    }

//    @Test
//    public void testRabbitMQ() {
//        logger.debug("testRabbitMQ");
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        MessageSender messageSender = (MessageSender) context.getBean("messageSender");
//
//        // 设置RoutingKey，匹配message.*即可
//        messageSender.setRoutingKey("message.test");
//        // 发送消息
//        messageSender.sendDataToQueue("insert Queue");
//    }

    @Test
    public void testMongoDB() {
        logger.debug("testMongoDB");
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MongoTemplate mongoTemplate = (MongoTemplate) context.getBean("mongoTemplate");


        Map<String, Object> map = new HashMap<>();
        map.put("_id", "10086");
        map.put("name", "noobyang");
        map.put("age", "26");
        mongoTemplate.save(map, "collectionName");

    }

}
