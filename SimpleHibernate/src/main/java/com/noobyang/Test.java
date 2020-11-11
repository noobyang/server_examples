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

        testOneMany(session);

//        testManyMany(session);

//        testOneOne(session);

//        testOneOne2(session);

//        testComponent(session);

//        testExtends(session);

        testExtends3(session);

//        testQuery(session);


        testSession(factory);


        //关闭Session
        session.close();

        factory.close();
    }

    /**
     * 如果要使用getCurrentSession()，需要在配置文件中配置:
     *
     * <property name="hibernate.current_session_context_class">thread</property>
     */
    public static void testSession(SessionFactory factory) {
        // openSession:  创建Session, 每次都会创建一个新的session
        Session session1 = factory.openSession();
        Session session2 = factory.openSession();
        System.out.println(session1 == session2);
        session1.close();
        session2.close();

        // getCurrentSession 创建或者获取session
        // 线程的方式创建session
        // 一定要配置：<property name="hibernate.current_session_context_class">thread</property>
        Session session3 = factory.getCurrentSession();// 创建session，绑定到线程
        Session session4 = factory.getCurrentSession();// 从当前访问线程获取session
        System.out.println(session3 == session4);

        // 关闭 【以线程方式创建的session，可以不用关闭； 线程结束session自动关闭】
        session3.close();
        //session4.close(); 报错，因为同一个session已经关闭了！
    }

    private static void testQuery(Session session) {

        //使用Hibernate操作数据库，都要开启事务,得到事务对象
        Transaction transaction = session.getTransaction();
        //开启事务
        transaction.begin();


        // 命名
        Query query = session.createQuery("from Monkey3 m where m.name=:monkeyName");
        //HQL是从0开始的
        query.setParameter("monkeyName", "大猴子");
        System.out.println(query.list());

        // 区间
        query = session.createQuery("from Dept d where d.id between ? and ?");
        query.setParameter(0, 1);
        query.setParameter(1, 20);
        System.out.println(query.list());

        // 模糊
        query = session.createQuery("from Dept d where d.deptName like ?");
        query.setString(0, "%部%");
        System.out.println(query.list());

        // count
        query = session.createQuery("select COUNT(*) from Monkey3");
        Object o = query.uniqueResult();
        System.out.println(o);


        //-- 统计 employee 表中，每个部门的人数
        // 数据库写法：SELECT dept_id,COUNT(*) FROM  employee GROUP BY dept_id;
        // HQL写法
        query = session.createQuery("select e.dept, count(*) from Employee e group by e.dept");
        System.out.println(query.list());


        //1) 内连接   【映射已经配置好了关系，关联的时候，直接写对象的属性即可】
        query = session.createQuery("from Dept d inner join d.set");
        System.out.println(query.list());
        //2) 左外连接
        query = session.createQuery("from Dept d left join d.set");
        System.out.println(query.list());
        //3) 右外连接
        query = session.createQuery("from Employee e right join e.dept");
        System.out.println(query.list());

        //1) 迫切内连接    【使用fetch, 会把右表的数据，填充到左表对象中！】
        query = session.createQuery("from Dept d inner join fetch d.set");
        System.out.println(query.list());
        //2) 迫切左外连接
        query = session.createQuery("from Dept d left join fetch d.set");
        System.out.println(query.list());


        query = session.getNamedQuery("getAllDept");
        query.setParameter(0, 10);
        System.out.println(query.list());


        // 创建关于user对象的criteria对象
        Criteria criteria = session.createCriteria(User.class);
        //添加条件
        criteria.add(Restrictions.eq("id", 1));
        //查询全部数据
        System.out.println(criteria.list());


        SQLQuery sqlQuery = session.createSQLQuery("SELECT * FROM monkey3_ limit 0,3");
        System.out.println(sqlQuery.list());


        // 分页查询
        query = session.createQuery("from Monkey3");
        // 得到滚动结果集
        ScrollableResults scroll = query.scroll();
        // 滚动到最后一行
        scroll.last();
        int i = scroll.getRowNumber() + 1;
        System.out.println("总计路数：" + i);

        // 设置分页位置
        query.setFirstResult(0);
        query.setMaxResults(3);

        System.out.println(query.list());




        //提交事务
        transaction.commit();
    }

    private static void testExtends3(Session session) {
        //创建对象
        Cat3 cat = new Cat3();
        Monkey3 monkey = new Monkey3();

        //设置属性
        cat.setName("大花猫");
        cat.setCatchMouse("小老鼠");

        monkey.setEatBanana("吃香蕉");
        monkey.setName("大猴子");


        //使用Hibernate操作数据库，都要开启事务,得到事务对象
        Transaction transaction = session.getTransaction();
        //开启事务
        transaction.begin();

        // 1. insert 把对象添加到数据库中
        //保存对象的数据,idCard配置文件使用级联保存
        session.save(cat);
        session.save(monkey);

        //提交事务
        transaction.commit();
    }

    private static void testExtends(Session session) {
        //创建对象
        Cat cat = new Cat();
        Monkey monkey = new Monkey();

        //设置属性
        cat.setName("大花猫");
        cat.setCatchMouse("小老鼠");

        monkey.setEatBanana("吃香蕉");
        monkey.setName("大猴子");


        //使用Hibernate操作数据库，都要开启事务,得到事务对象
        Transaction transaction = session.getTransaction();
        //开启事务
        transaction.begin();

        // 1. insert 把对象添加到数据库中
        //保存对象的数据,idCard配置文件使用级联保存
        session.save(cat);
        session.save(monkey);

        //提交事务
        transaction.commit();
    }

    private static void testComponent(Session session) {
        //创建对象
        Wheel wheel = new Wheel();
        Car car = new Car();

        //设置属性
        wheel.setCount(43);
        wheel.setSize(22);
        car.setName("宝马");

        //维护关系
        car.setWheel(wheel);


        //使用Hibernate操作数据库，都要开启事务,得到事务对象
        Transaction transaction = session.getTransaction();
        //开启事务
        transaction.begin();

        // 1. insert 把对象添加到数据库中
        //保存对象的数据,idCard配置文件使用级联保存
        session.save(car);

        //提交事务
        transaction.commit();
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

    /**
     *
     * Inverse属性：表示控制权是否转移..
     *     true:控制权已转移【当前一方没有控制权】
     *     false：控制权没有转移【当前一方有控制权】
     * Inverse属性，是在维护关联关系的时候起作用的。只能在“一”的一方中使用该属性！Inverse属性的默认值为fasle，也就是当前一方是有控制权的
     * inverse属性只能在“一”的一方中设置。inverse=false表示有控制权，inverse=ture表示没有控制权
     *
     * cascade表示级联的意思，简单来说就是操作某一属性时，对其他关联字段的影响
     * casecade属性不像inverse属性只能在“一”的一方设置，它可以在“一”的一方也可以在“多”的一方设置
     * cascade有这么几个值
     *     none          不级联操作， 默认值
     *     save-update     级联保存或更新
     *     delete          级联删除
     *     save-update,delete    级联保存、更新、删除
     *     all                 同上。级联保存、更新、删除
     *
     * inverse的优先级是比cascade的优先级要高的，因此设置了inverse属性为true，那么cascade就无效了。
     *
     */
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
