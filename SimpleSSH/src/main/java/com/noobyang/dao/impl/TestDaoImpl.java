package com.noobyang.dao.impl;

import com.noobyang.dao.ITestDao;
import com.noobyang.entity.Person;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

/**
 * 继承了HibernateDaoSupport这个类，这个类是需要SessionFactory的，
 * 通过注解的方式给不了【给属性的话，属性只与TestDaoImpl相关，
 * 而HibernateDaoSupport的setFactory()被定义了final】，
 *
 * 因此只能通过XML的方式来配置【XML配置TestDaoImpl，
 * TestDaoImpl是拥有setFactory方法的，不能改写，但是能通过XML注入呀】
 */
public class TestDaoImpl extends HibernateDaoSupport implements ITestDao {

    @Override
    public void save(Person person) {
        // Error: Write operations are not allowed in read-only mode (FlushMode.MANUAL): Turn your Session into FlushM
//        getHibernateTemplate().setCheckWriteOperations(false);

        getHibernateTemplate().save(person);
    }

}
