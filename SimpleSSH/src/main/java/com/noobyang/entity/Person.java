package com.noobyang.entity;

import java.io.Serializable;

public class Person implements Serializable {

    private String id;
    private String username;

    public Person() {
    }

    public Person(String username) {
        this.username = username;

    }

    public Person(String id, String username) {
        this.id = id;
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
