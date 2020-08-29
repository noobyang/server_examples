package com.yunplayer.model;

public class CourseNewModel {
    private int cnid;
    private int cid;

    public CourseNewModel() {
        super();
    }

    public CourseNewModel(int cnid, int cid) {
        this.cnid = cnid;
        this.cid = cid;
    }

    public int getCnid() {
        return cnid;
    }

    public void setCnid(int cnid) {
        this.cnid = cnid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
}
