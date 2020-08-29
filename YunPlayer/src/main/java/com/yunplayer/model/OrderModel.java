package com.yunplayer.model;

public class OrderModel {
	private int orderid;
	private String uid;
	private String open_id;
	private int class_type;
	private int cid;
	private String total;
	private int iscoupon;
	private String value;
	private int isvip;
	private String pay;
	private String create_time;

	public OrderModel() {
		super();
	}

	public OrderModel(int orderid, String uid, String open_id, int class_type, int cid, String total, int iscoupon, String value, int isvip, String pay, String create_time) {
		this.orderid = orderid;
		this.uid = uid;
		this.open_id = open_id;
		this.class_type = class_type;
		this.cid = cid;
		this.total = total;
		this.iscoupon = iscoupon;
		this.value = value;
		this.isvip = isvip;
		this.pay = pay;
		this.create_time = create_time;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getOpen_id() {
		return open_id;
	}

	public void setOpen_id(String open_id) {
		this.open_id = open_id;
	}

	public int getClass_type() {
		return class_type;
	}

	public void setClass_type(int class_type) {
		this.class_type = class_type;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public int getIscoupon() {
		return iscoupon;
	}

	public void setIscoupon(int iscoupon) {
		this.iscoupon = iscoupon;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getIsvip() {
		return isvip;
	}

	public void setIsvip(int isvip) {
		this.isvip = isvip;
	}

	public String getPay() {
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
}
