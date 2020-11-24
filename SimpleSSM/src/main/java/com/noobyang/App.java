package com.noobyang;

import com.noobyang.dao.impl.DeptDaoImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.io.IOException;
import java.io.Reader;


public class App {

    static private DeptDaoImpl deptDao;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        deptDao = (DeptDaoImpl) context.getBean("deptDao");

        System.out.println("setUpBeforeClass");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {

        System.out.println("tearDownAfterClass");
    }

    @Test
    public void testSpringMVCSelectDept() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        deptDao = (DeptDaoImpl) context.getBean("deptDao");
        System.out.println(deptDao.selectDept(1));
    }

    @Test
    public void testMyBatisSelectDept() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

            SqlSession sqlSession = sqlSessionFactory.openSession();

            System.out.println(sqlSession.selectOne("com.noobyang.entity.DeptMapper.selectDept", 1));
            sqlSession.commit();

            sqlSession.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
