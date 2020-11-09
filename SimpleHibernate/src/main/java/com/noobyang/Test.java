package com.noobyang;

import com.noobyang.entity.User;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.List;

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

        //关闭Session
        session.close();

        factory.close();
    }

}
