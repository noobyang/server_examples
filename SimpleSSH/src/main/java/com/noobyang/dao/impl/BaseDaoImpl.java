package com.noobyang.dao.impl;

import com.noobyang.dao.BaseDao;
import org.hibernate.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

    Class<T> clazz;

    public BaseDaoImpl(){
        ParameterizedType pt =  (ParameterizedType)this.getClass().getGenericSuperclass();
        clazz = (Class<T>)pt.getActualTypeArguments()[0];
    }

    @Override
    public void save(T entity) {
        getHibernateTemplate().save(entity);
    }

    @Override
    public void update(T entity) {
        getHibernateTemplate().update(entity);
    }

    @Override
    public void delete(Serializable id) {
        getHibernateTemplate().delete(findObjectById(id));
    }

    @Override
    public T findObjectById(Serializable id) {
        return getHibernateTemplate().get(clazz, id);
    }

    @Override
    public List<T> findObjects() {
        return getHibernateTemplate().loadAll(clazz);
    }
}
