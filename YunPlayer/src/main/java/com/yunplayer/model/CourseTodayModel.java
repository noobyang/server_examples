package com.yunplayer.model;

public class CourseTodayModel {
    private int ctid;
    private int cid;

    public CourseTodayModel() {
        super();
    }

    public CourseTodayModel(int ctid, int cid) {
        this.ctid = ctid;
        this.cid = cid;
    }

    public int getCtid() {
        return ctid;
    }

    public void setCtid(int ctid) {
        this.ctid = ctid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
}
