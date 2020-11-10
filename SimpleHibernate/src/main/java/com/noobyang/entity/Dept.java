package com.noobyang.entity;

import java.util.HashSet;
import java.util.Set;

public class Dept {

    private int id ;

    private Set<Employee> set = new HashSet<>();

    private String deptName;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Employee> getSet() {
        return set;
    }

    public void setSet(Set<Employee> set) {
        this.set = set;
    }

}
