package com.yunplayer.model;

public class LivePrevModel {
	private int lpid;
	private String live_name;
	private int teacherid;
	private String live_time;
	private String live_detail;
	private int liveid;

	public LivePrevModel() {
		super();
	}

	public LivePrevModel(int lpid, String live_name, int teacherid, String live_time, String live_detail, int liveid) {
		this.lpid = lpid;
		this.live_name = live_name;
		this.teacherid = teacherid;
		this.live_time = live_time;
		this.live_detail = live_detail;
		this.liveid = liveid;
	}

	public int getLpid() {
		return lpid;
	}

	public void setLpid(int lpid) {
		this.lpid = lpid;
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

	public int getLiveid() {
		return liveid;
	}

	public void setLiveid(int liveid) {
		this.liveid = liveid;
	}
}
