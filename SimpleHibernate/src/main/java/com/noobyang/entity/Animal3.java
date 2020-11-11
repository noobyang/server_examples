package com.noobyang.entity;

public class Animal3 {

    /**
     * 使用了union-subclass节点，主键就不能采用自动增长策略了。
     * 我们改成UUID即可。对应的实体id类型要改成String
     */
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
