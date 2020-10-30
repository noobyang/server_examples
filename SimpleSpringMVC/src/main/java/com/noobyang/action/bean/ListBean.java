package com.noobyang.action.bean;

import java.util.ArrayList;
import java.util.List;

public class ListBean {

    private List<User> list = new ArrayList<User>();

    public ListBean(){

    }
    public List<User> getList() {
        return list;
    }
    public void setList(List<User> list) {
        this.list = list;
    }

}
