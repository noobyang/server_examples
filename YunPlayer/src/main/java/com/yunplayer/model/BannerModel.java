package com.yunplayer.model;

public class BannerModel {
	private int bid;
	private String piclink;
	private String link;
	private String state;

	public BannerModel() {
		super();
	}

	public BannerModel(int bid, String piclink, String link, String state) {
		this.bid = bid;
		this.piclink = piclink;
		this.link = link;
		this.state = state;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getPiclink() {
		return piclink;
	}

	public void setPiclink(String piclink) {
		this.piclink = piclink;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
