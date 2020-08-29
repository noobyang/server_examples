package com.yunplayer.model;

public class LiveModel {
	private int liveid;
	private String live_name;
	private int teacherid;
	private String live_time;
	private String live_detail;
	private String live_vlink;
	private String live_price;

	public LiveModel() {
		super();
	}

	public LiveModel(int liveid, String live_name, int teacherid, String live_time, String live_detail, String live_vlink, String live_price) {
		this.liveid = liveid;
		this.live_name = live_name;
		this.teacherid = teacherid;
		this.live_time = live_time;
		this.live_detail = live_detail;
		this.live_vlink = live_vlink;
		this.live_price = live_price;
	}

	public int getLiveid() {
		return liveid;
	}

	public void setLiveid(int liveid) {
		this.liveid = liveid;
	}

	public String getLive_name() {
		return live_name;
	}

	public void setLive_name(String live_name) {
		this.live_name = live_name;
	}

	public int getTeacherid() {
		return teacherid;
	}

	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
	}

	public String getLive_time() {
		return live_time;
	}

	public void setLive_time(String live_time) {
		this.live_time = live_time;
	}

	public String getLive_detail() {
		return live_detail;
	}

	public void setLive_detail(String live_detail) {
		this.live_detail = live_detail;
	}

	public String getLive_vlink() {
		return live_vlink;
	}

	public void setLive_vlink(String live_vlink) {
		this.live_vlink = live_vlink;
	}

	public String getLive_price() {
		return live_price;
	}

	public void setLive_price(String live_price) {
		this.live_price = live_price;
	}
}
