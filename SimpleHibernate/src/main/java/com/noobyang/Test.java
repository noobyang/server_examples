package com.noobyang;

import com.noobyang.entity.User;
import com.noobyang.entity.UserList;
import com.noobyang.entity.UserList2;
import com.noobyang.entity.UserList3;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;


public class Test {

    public static void main(String[] args) {
        //创建对象
        User user = new User();
        user.setAge(5);
        user.setName("豆芽");
        user.setSex("女");

        //获取加载配置管理类
        Configuration configuration = new Configuration();
        //不给参数就默认加载hibernate.cfg.xml文件，
        configuration.configure();

        // 加载User的映射文件
        // 方法一
        // <mapping resource="hbm/User.hbm.xml"/>
        // 方法二
        // configuration.configure().addClass(User.class);

        //创建Session工厂对象
        SessionFactory factory = configuration.buildSessionFactory();
        //得到Session对象
        Session session = factory.openSession();


//        testUser(session);

//        testUserList(session);

//        testUserList2(session);

        testUserList3(session);


        //关闭Session
        session.close();

        factory.close();
    }

    private static void testUserList3(Session session) {
        //创建对象
        UserList3 user = new UserList3();
        user.setUsername("豆芽");
        user.setPassword("女");
        user.getAddress().put("1", "广州");
        user.getAddress().put("2", "上海");

        //使用Hibernate操作数据库，都要开启事务,得到事务对象
        Transaction transaction = session.getTransaction();
        //开启事务
        transaction.begin();

        // 1. insert 把对象添加到数据库中
        session.saveOrUpdate(user);

        //提交事务
        transaction.commit();
    }

    private static void testUserList2(Session session) {
        //创建对象
        UserList2 user = new UserList2();
        user.setUsername("豆芽");
        user.setPassword("女");
        user.getAddress().add("广州");
        user.getAddress().add("上海");

        //使用Hibernate操作数据库，都要开启事务,得到事务对象
        Transaction transaction = session.getTransaction();
        //开启事务
        transaction.begin();

        // 1. insert 把对象添加到数据库中
        session.saveOrUpdate(user);

        //提交事务
        transaction.commit();
    }

    private static void testUserList(Session session) {
        //创建对象
        UserList user = new UserList();
        user.setUsername("豆芽");
        user.setPassword("女");
        user.getAddress().add("广州");
        user.getAddress().add("上海");

        //使用Hibernate操作数据库，都要开启事务,得到事务对象
        Transaction transaction = session.getTransaction();
        //开启事务
        transaction.begin();

        // 1. insert 把对象添加到数据库中
        session.saveOrUpdate(user);

        //提交事务
        transaction.commit();
    }

    private static void testUser(Session session) {
        //创建对象
        User user = new User();
        user.setAge(5);
        user.setName("豆芽");
        user.setSex("女");

        //使用Hibernate操作数据库，都要开启事务,得到事务对象
        Transaction transaction = session.getTransaction();
        //开启事务
        transaction.begin();

        // 1. insert 把对象添加到数据库中
        session.saveOrUpdate(user);

        // 2. query HQL
        Query query = session.createQuery("FROM User");
        System.out.println(query.list());

        query = session.createQuery("FROM User WHERE id=?");
        // 这里的？号是从0开始的，并不像JDBC从1开始的！
        query.setParameter(0, user.getId());
        System.out.println(query.list());

        // 2. query QBC
        // 创建关于user对象的criteria对象
        Criteria criteria = session.createCriteria(User.class);
        //添加条件
        criteria.add(Restrictions.eq("id", 1));
        //查询全部数据
        System.out.println(criteria.list());

        // 2. 将所有的记录封装成User对象存进List集合中
        SQLQuery sqlQuery = session.createSQLQuery("SELECT * FROM user").addEntity(User.class);
        System.out.println(sqlQuery.list());


        //提交事务
        transaction.commit();
    }

}
