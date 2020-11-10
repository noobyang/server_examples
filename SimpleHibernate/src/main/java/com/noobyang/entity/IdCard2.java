package com.noobyang.entity;

public class IdCard2 {

    private int idCardId;
    private String idCardName;

    //维护与用户之间的关系
    private IdUser2 user ;

    private int userId;

    public int getIdCardId() {
        return idCardId;
    }

    public void setIdCardId(int idCardId) {
        this.idCardId = idCardId;
    }

    public String getIdCardName() {
        return idCardName;
    }

    public void setIdCardName(String idCardName) {
        this.idCardName = idCardName;
    }

    public IdUser2 getUser() {
        return user;
    }

    public void setUser(IdUser2 user) {
        this.user = user;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}
