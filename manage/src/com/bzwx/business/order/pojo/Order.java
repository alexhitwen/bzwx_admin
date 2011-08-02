package com.bzwx.business.order.pojo;

/**
 * 菜品订单管理 com.bzwx.business.order.pojo.Order
 * 
 * @author wwh
 * @version 1.0
 * @created 2011-7-27
 */
public class Order {
	private long orderId;
	private String orderName;
	private String orderCode;
	private double orderPrice;
	private long orderNum;
	private long customerNum;
	private long waiterId;
	private String waiterCode;
	private int orderStatus;

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}

	public long getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(long orderNum) {
		this.orderNum = orderNum;
	}

	public long getCustomerNum() {
		return customerNum;
	}

	public void setCustomerNum(long customerNum) {
		this.customerNum = customerNum;
	}

	public long getWaiterId() {
		return waiterId;
	}

	public void setWaiterId(long waiterId) {
		this.waiterId = waiterId;
	}

	public String getWaiterCode() {
		return waiterCode;
	}

	public void setWaiterCode(String waiterCode) {
		this.waiterCode = waiterCode;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

}
