package com.noobyang.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 多方
 */
public class Student4 {

    private Integer id;
    private String name;
    private List<Course> courseList = new ArrayList<Course>();//关联属性

    public Student4() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public String toString() {
        return "Student4{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", courseList=" + courseList +
                '}';
    }
}
