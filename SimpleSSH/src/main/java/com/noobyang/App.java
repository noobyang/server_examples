package com.noobyang;

import com.noobyang.entity.Person;
import com.noobyang.service.ITestService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {


    @Test
    public void testLoad() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println(context);
    }

    @Test
    public void testSpring() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        ITestService testService = (ITestService) context.getBean("testServiceImpl");

        testService.say();
    }

    @Test
    public void testHibernate() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        SessionFactory factory = (SessionFactory) context.getBean("sessionFactory");

        Session session = factory.openSession();
        session.beginTransaction();

        session.save(new Person("人员1"));

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testHibernate2() {
        //获取加载配置管理类
        Configuration configuration = new Configuration();
        //不给参数就默认加载hibernate.cfg.xml文件，
        configuration.configure();

        // 加载User的映射文件
        // 方法一
        // <mapping resource="hbm/Person.hbm.xml"/>
        // 方法二
        // configuration.configure().addClass(User.class);

        //创建Session工厂对象
        SessionFactory factory = configuration.buildSessionFactory();
        //得到Session对象
        Session session = factory.openSession();

        session.save(new Person("人员1"));

        //关闭Session
        session.close();

        factory.close();
    }



}
