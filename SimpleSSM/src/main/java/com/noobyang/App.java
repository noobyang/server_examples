package com.noobyang;

import com.noobyang.dao.impl.DeptDaoImpl;
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


import java.io.IOException;
import java.io.Reader;


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

}
