package com.noobyang.entity;

public class IdCard {

    private int idCardId;
    private String idCardName;

    //维护与用户之间的关系
    private IdUser user ;

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

    public IdUser getUser() {
        return user;
    }

    public void setUser(IdUser user) {
        this.user = user;
    }

}
