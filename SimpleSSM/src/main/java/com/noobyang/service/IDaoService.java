package com.noobyang.service;

import com.noobyang.entity.Dept;

public interface IDaoService {

    Dept selectDept(Integer deptId);

    int insertDept(Dept dept);

}
