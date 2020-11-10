package com.noobyang.entity;

import java.util.HashSet;
import java.util.Set;

public class Developer {

    private int developerId;
    private String developerName;

    //使用Set集合来维护与Project关系
    private Set<Project> projects = new HashSet<>();

    public int getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(int developerId) {
        this.developerId = developerId;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

}
