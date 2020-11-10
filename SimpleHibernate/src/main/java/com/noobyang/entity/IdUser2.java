package com.noobyang.entity;

public class IdUser2 {


    private int userId;
    private String userName;

    //维护与身份证一对一的关系
    private IdCard2 idCard ;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public IdCard2 getIdCard() {
        return idCard;
    }

    public void setIdCard(IdCard2 idCard) {
        this.idCard = idCard;
    }

}
