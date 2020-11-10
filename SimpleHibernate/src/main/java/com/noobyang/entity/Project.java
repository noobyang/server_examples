package com.noobyang.entity;

import java.util.HashSet;
import java.util.Set;

public class Project {

    private int projectId;
    private String projectName;

    //使用Set集合与developer实体维护关系
    private Set<Developer> developers = new HashSet<>();

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Set<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(Set<Developer> developers) {
        this.developers = developers;
    }

}
