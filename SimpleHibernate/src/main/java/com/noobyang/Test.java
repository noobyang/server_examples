package com.noobyang;

import com.noobyang.entity.*;
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

//        testUserList3(session);

//        testOneMany(session);

//        testManyMany(session);

//        testOneOne(session);

        testOneOne2(session);


        //关闭Session
        session.close();

        factory.close();
    }

    private static void testOneOne2(Session session) {
        //创建对象
        IdUser2 user = new IdUser2();
        IdCard2 idCard = new IdCard2();

        //设置对象的数据
        user.setUserName("你好3");
        idCard.setIdCardName("身份证003");
        idCard.setIdCardId(4235);

        //一对一关联数据
        idCard.setUser(user);


        //使用Hibernate操作数据库，都要开启事务,得到事务对象
        Transaction transaction = session.getTransaction();
        //开启事务
        transaction.begin();

        // 1. insert 把对象添加到数据库中
        //保存对象的数据,idCard配置文件使用级联保存
        session.save(idCard);

        //提交事务
        transaction.commit();
    }

    private static void testOneOne(Session session) {
        //创建对象
        IdUser user = new IdUser();
        IdCard idCard = new IdCard();

        //设置对象的数据
        user.setUserName("你好");
        idCard.setIdCardName("身份证001");

        //一对一关联数据
        idCard.setUser(user);


        //使用Hibernate操作数据库，都要开启事务,得到事务对象
        Transaction transaction = session.getTransaction();
        //开启事务
        transaction.begin();

        // 1. insert 把对象添加到数据库中
        //保存对象的数据,idCard配置文件使用级联保存
        session.save(idCard);

        //提交事务
        transaction.commit();
    }

    private static void testManyMany(Session session) {
        //创建对象
        Developer cj = new Developer();
        Developer wc = new Developer();
        Developer lz = new Developer();
        Project ds = new Project();
        Project oa = new Project();

        //设置对象的数据
        cj.setDeveloperName("曹吉");
        wc.setDeveloperName("王春");
        lz.setDeveloperName("老张");

        oa.setProjectName("OA系统");
        ds.setProjectName("电商系统");

        //使用Project来关联数据【在多对多中，一样的】
        oa.getDevelopers().add(wc);
        oa.getDevelopers().add(lz);

        ds.getDevelopers().add(cj);
        ds.getDevelopers().add(wc);


        //使用Hibernate操作数据库，都要开启事务,得到事务对象
        Transaction transaction = session.getTransaction();
        //开启事务
        transaction.begin();

        // 1. insert 把对象添加到数据库中
        session.save(oa);
        session.save(ds);


        //提交事务
        transaction.commit();
    }

    private static void testOneMany(Session session) {
        //创建对象
        Dept dept = new Dept();
        dept.setDeptName("开发部");

        Employee zs = new Employee();
        zs.setEmpName("张珊");
        zs.setSalary(1111);
        Employee ls = new Employee();
        ls.setEmpName("李四");
        ls.setSalary(2222);

        // 添加关系
        // 在一对多与多对一的关联关系中，保存数据最好的通过多的一方来维护关系，
        // 这样可以减少update语句的生成，从而提高hibernate的执行效率！
        // Hibernate执行了5条SQL语句
//        dept.getSet().add(zs);
//        dept.getSet().add(ls);
        // Hibernate执行了3条SQL
        zs.setDept(dept);
        ls.setDept(dept);

        // 值得注意是：配置了哪一方，哪一方才有维护关联关系的权限！
        // 当我在部门中不配置员工的关联关系了，那么在操作部门的时候就不能得到员工的数据了
        // 【也就是：在保存部门时，不能同时保存员工的数据】


        //使用Hibernate操作数据库，都要开启事务,得到事务对象
        Transaction transaction = session.getTransaction();
        //开启事务
        transaction.begin();

        // 1. insert 把对象添加到数据库中
        session.save(dept);
        session.save(zs);
        session.save(ls);


        //提交事务
        transaction.commit();
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
