package com.noobyang.entity;

import java.util.ArrayList;
import java.util.List;

public class Grade {

    private Integer id;
    private String name;
    private List<Student3> studentList = new ArrayList<Student3>();//关联属性

    public Grade() {
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

    public List<Student3> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student3> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", studentList=" + studentList +
                '}';
    }
}
