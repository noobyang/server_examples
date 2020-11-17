package com.noobyang;

import com.noobyang.entity.Person;
import com.noobyang.service.ITestService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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

        session.save(new Person("人员1241"));

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

        //使用Hibernate操作数据库，都要开启事务,得到事务对象
        Transaction transaction = session.getTransaction();
        //开启事务
        transaction.begin();

        session.save(new Person("人员2323"));

        // Warring: 需要放在事物中！数据才能插入数据库中
        //提交事务
        transaction.commit();

        //关闭Session
        session.close();

        factory.close();
    }

    @Test
    public void testMVC() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        ITestService testService = (ITestService) context.getBean("testServiceImpl");

        testService.save(new Person("人员20006"));
    }

    private static final Logger logger = LogManager.getLogger(App.class);
    @Test
    public void testLog() {
        logger.debug("debug");

    }



}
