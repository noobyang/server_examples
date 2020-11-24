package com.noobyang.dao.impl;

import com.noobyang.dao.IDeptDao;
import com.noobyang.entity.Dept;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("deptDao")
public class DeptDaoImpl implements IDeptDao {

    @Resource
    private SqlSessionTemplate sqlSessionTemplate;

    /**
     * 根据部门编号查询部门信息
     *
     * @param deptId 部门编号
     * @return 部门信息
     */
    @Override
    public Dept selectDept(Integer deptId) {
        return sqlSessionTemplate.selectOne("com.noobyang.entity.DeptMapper.selectDept", deptId);
    }

    /**
     * 添加部门信息
     *
     * @param dept 部门信息
     * @return 添加成功的记录数
     */
    @Override
    public int insertDept(Dept dept) {
        return sqlSessionTemplate.insert("com.noobyang.entity.DeptMapper.insertDept", dept);
    }
}
