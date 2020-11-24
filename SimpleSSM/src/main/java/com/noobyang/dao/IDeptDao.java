package com.noobyang.dao;

import com.noobyang.entity.Dept;

public interface IDeptDao {

    Dept selectDept(Integer deptId);
    int insertDept(Dept dept);

}
