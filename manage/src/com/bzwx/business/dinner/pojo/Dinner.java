package com.bzwx.business.dinner.pojo;

/**
 * 餐台信息管理 com.bzwx.business.dinner.pojo.Dinner
 * 
 * @author wwh
 * @version 1.0
 * @created 2011-7-30
 */
public class Dinner {

	private long dinId;
	private String dinName;
	private String dinCode;
	private String dinNote;
	private String dinDesc;
	private String orderFlag; // 餐台下单标志（是否空闲）

	public long getDinId() {
		return dinId;
	}

	public void setDinId(long dinId) {
		this.dinId = dinId;
	}

	public String getDinName() {
		return dinName;
	}

	public void setDinName(String dinName) {
		this.dinName = dinName;
	}

	public String getDinCode() {
		return dinCode;
	}

	public void setDinCode(String dinCode) {
		this.dinCode = dinCode;
	}

	public String getDinNote() {
		return dinNote;
	}

	public void setDinNote(String dinNote) {
		this.dinNote = dinNote;
	}

	public String getDinDesc() {
		return dinDesc;
	}

	public void setDinDesc(String dinDesc) {
		this.dinDesc = dinDesc;
	}

	public String getOrderFlag() {
		return orderFlag;
	}

	public void setOrderFlag(String orderFlag) {
		this.orderFlag = orderFlag;
	}

}
