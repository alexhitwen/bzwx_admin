package com.bzwx.business.order.pojo;

/**
 * 菜品订单 条目 管理 com.bzwx.business.order.pojo.Item
 * 
 * @author wwh
 * @version 1.0
 * @created 2011-7-27
 */
public class Item {

	private long itemId;
	private long recId;
	private double recPrice;
	private long recNum;
	private long orderId;
	// private double item_price;// rec_price * rec_num
	private int itemStatus;

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public long getRecId() {
		return recId;
	}

	public void setRecId(long recId) {
		this.recId = recId;
	}

	public double getRecPrice() {
		return recPrice;
	}

	public void setRecPrice(double recPrice) {
		this.recPrice = recPrice;
	}

	public long getRecNum() {
		return recNum;
	}

	public void setRecNum(long recNum) {
		this.recNum = recNum;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public int getItemStatus() {
		return itemStatus;
	}

	public void setItemStatus(int itemStatus) {
		this.itemStatus = itemStatus;
	}

}
