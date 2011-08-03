package com.bzwx.business.recipes.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 菜品信息管理com.bzwx.business.recipes.pojo.Recipes
 * 
 * @author wwh
 * @version 1.0
 * @created 2011-7-27
 */
public class Recipes implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long firstCateId;// 非表字段
	private String firstCateName;// 非表字段
	private Long secCateId; // 非表字段
	private String secCateName; // 非表字段
	private String allCateName; // 非表字段

	private long recId; // 菜品主键
	private String recName; // 菜品显示名称
	private String recCode; // 菜品代号(酒店自定义)
	private double recPrice; // 菜品价格（常规价格）
	private double recDiscountPrice; // 菜品折扣/促销价格
	private String recPicUrl; // 菜品图片地址
	private String recNote; // 菜品简要说明
	private String recDesc; // 菜品详细介绍，配料等
	private int sortFlag; // 排序字段

	private int recVersion = 1; // 更新版本
	private int recStatus = 0; // 菜品当前状态（-1删除；0，默认正常未同步；1，正常并已同步；2，过期无需同步；3，待上市稍后同步）
	private Date createDate; // 创建时间
	private Date updateDate; // 最新修改时间

	public Long getFirstCateId() {
		return firstCateId;
	}

	public void setFirstCateId(Long firstCateId) {
		this.firstCateId = firstCateId;
	}

	public String getFirstCateName() {
		return firstCateName;
	}

	public void setFirstCateName(String firstCateName) {
		this.firstCateName = firstCateName;
	}

	public Long getSecCateId() {
		return secCateId;
	}

	public void setSecCateId(Long secCateId) {
		this.secCateId = secCateId;
	}

	public String getSecCateName() {
		return secCateName;
	}

	public void setSecCateName(String secCateName) {
		this.secCateName = secCateName;
	}

	public String getAllCateName() {
		return allCateName;
	}

	public void setAllCateName(String allCateName) {
		this.allCateName = allCateName;
	}

	public long getRecId() {
		return recId;
	}

	public void setRecId(long recId) {
		this.recId = recId;
	}

	public String getRecName() {
		return recName;
	}

	public void setRecName(String recName) {
		this.recName = recName;
	}

	public String getRecCode() {
		return recCode;
	}

	public void setRecCode(String recCode) {
		this.recCode = recCode;
	}

	public double getRecPrice() {
		return recPrice;
	}

	public void setRecPrice(double recPrice) {
		this.recPrice = recPrice;
	}

	public double getRecDiscountPrice() {
		return recDiscountPrice;
	}

	public void setRecDiscountPrice(double recDiscountPrice) {
		this.recDiscountPrice = recDiscountPrice;
	}

	public String getRecPicUrl() {
		return recPicUrl;
	}

	public void setRecPicUrl(String recPicUrl) {
		this.recPicUrl = recPicUrl;
	}

	public String getRecNote() {
		return recNote;
	}

	public void setRecNote(String recNote) {
		this.recNote = recNote;
	}

	public String getRecDesc() {
		return recDesc;
	}

	public void setRecDesc(String recDesc) {
		this.recDesc = recDesc;
	}

	public int getSortFlag() {
		return sortFlag;
	}

	public void setSortFlag(int sortFlag) {
		this.sortFlag = sortFlag;
	}

	public int getRecVersion() {
		return recVersion;
	}

	public void setRecVersion(int recVersion) {
		this.recVersion = recVersion;
	}

	public int getRecStatus() {
		return recStatus;
	}

	public void setRecStatus(int recStatus) {
		this.recStatus = recStatus;
	}


	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
