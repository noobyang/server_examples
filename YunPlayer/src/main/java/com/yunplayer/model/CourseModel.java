package com.yunplayer.model;

public class CourseModel {

	private int cid;
	private int isserices;
	private String course_name;
	private String course_detail;
	private String course_piclink;
	private int clid;
	private int course_type;
	private String course_price;
	private int course_vip;
	private int course_state;
	private String create_time;
	private int buyyers;
	private int ismain;

	public CourseModel() {
		super();
	}

	public CourseModel(int cid, int isserices, String course_name, String course_detail, String course_piclink, int clid, int course_type, String course_price, int course_vip, int course_state, String create_time, int buyyers, int ismain) {
		this.cid = cid;
		this.isserices = isserices;
		this.course_name = course_name;
		this.course_detail = course_detail;
		this.course_piclink = course_piclink;
		this.clid = clid;
		this.course_type = course_type;
		this.course_price = course_price;
		this.course_vip = course_vip;
		this.course_state = course_state;
		this.create_time = create_time;
		this.buyyers = buyyers;
		this.ismain = ismain;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getIsserices() {
		return isserices;
	}

	public void setIsserices(int isserices) {
		this.isserices = isserices;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getCourse_detail() {
		return course_detail;
	}

	public void setCourse_detail(String course_detail) {
		this.course_detail = course_detail;
	}

	public String getCourse_piclink() {
		return course_piclink;
	}

	public void setCourse_piclink(String course_piclink) {
		this.course_piclink = course_piclink;
	}

	public int getClid() {
		return clid;
	}

	public void setClid(int clid) {
		this.clid = clid;
	}

	public int getCourse_type() {
		return course_type;
	}

	public void setCourse_type(int course_type) {
		this.course_type = course_type;
	}

	public String getCourse_price() {
		return course_price;
	}

	public void setCourse_price(String course_price) {
		this.course_price = course_price;
	}

	public int getCourse_vip() {
		return course_vip;
	}

	public void setCourse_vip(int course_vip) {
		this.course_vip = course_vip;
	}

	public int getCourse_state() {
		return course_state;
	}

	public void setCourse_state(int course_state) {
		this.course_state = course_state;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public int getBuyyers() {
		return buyyers;
	}

	public void setBuyyers(int buyyers) {
		this.buyyers = buyyers;
	}

	public int getIsmain() {
		return ismain;
	}

	public void setIsmain(int ismain) {
		this.ismain = ismain;
	}
}
