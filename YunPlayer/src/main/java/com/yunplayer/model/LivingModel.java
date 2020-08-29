package com.yunplayer.model;

public class LivingModel {
	private int liid;
	private int liveid;

	public LivingModel() {
		super();
	}

	public LivingModel(int liid, int liveid) {
		this.liid = liid;
		this.liveid = liveid;
	}

	public int getLiid() {
		return liid;
	}

	public void setLiid(int liid) {
		this.liid = liid;
	}

	public int getLiveid() {
		return liveid;
	}

	public void setLiveid(int liveid) {
		this.liveid = liveid;
	}
}
