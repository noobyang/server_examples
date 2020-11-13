package com.noobyang.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 多方
 */
public class Course {

    private Integer id;
    private String name;
    private List<Student4> studentList = new ArrayList<Student4>();//关联属性

    public Course() {
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

    public List<Student4> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student4> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", studentList=" + studentList +
                '}';
    }
}
