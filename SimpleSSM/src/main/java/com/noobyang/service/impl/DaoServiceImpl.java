package com.noobyang.service.impl;

import com.noobyang.dao.IDeptDao;
import com.noobyang.entity.Dept;
import com.noobyang.service.IDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("daoService")
public class DaoServiceImpl implements IDaoService {

    @Autowired
    private IDeptDao deptDao;

    @Override
    public Dept selectDept(Integer deptId) {
        return deptDao.selectDept(deptId);
    }

    @Override
    public int insertDept(Dept dept) {
        return deptDao.insertDept(dept);
    }

}
