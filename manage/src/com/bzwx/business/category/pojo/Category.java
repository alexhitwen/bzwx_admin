package com.bzwx.business.category.pojo;

/**
 * 菜品分类管理（待确定） com.bzwx.business.category.pojo.Category
 * 
 * @author wwh
 * @version 1.0
 * @created 2011-7-30
 */
// 菜品菜系分类（鲁、川、苏、粤、浙、闽、湘、徽、淮扬等）
// 菜品样式分类（主食、热菜、凉菜、甜品、汤羹等）
// 菜品做法类别（红烧、清蒸、锅仔、家常等）
// 菜品业务类别（招牌、推荐、折扣、促销等）
public class Category {

	private int cateId; // 类别 主键（int即可）
	private int parentId; // 类别父键
	private String cateName;// 类别显示名称
	private String cateCode;// 类别代号
	private String cateValue;// 类别代号
	private String cateNote;// 类别描述
	private String cateDesc;// 类别详细描述（来历、做法等）
	private int sortFlag; // 排序字段
	private int cateStatus=0;// 类别当前状态（ 0，正常但同步；1，正常已同步；2，过期无需同步；3，待上市等侯同步）

	public int getCateId() {
		return cateId;
	}

	public void setCateId(int cateId) {
		this.cateId = cateId;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public String getCateCode() {
		return cateCode;
	}

	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
	}

	public String getCateValue() {
		return cateValue;
	}

	public void setCateValue(String cateValue) {
		this.cateValue = cateValue;
	}

	public String getCateNote() {
		return cateNote;
	}

	public void setCateNote(String cateNote) {
		this.cateNote = cateNote;
	}

	public String getCateDesc() {
		return cateDesc;
	}

	public void setCateDesc(String cateDesc) {
		this.cateDesc = cateDesc;
	}

	public int getSortFlag() {
		return sortFlag;
	}

	public void setSortFlag(int sortFlag) {
		this.sortFlag = sortFlag;
	}

	public int getCateStatus() {
		return cateStatus;
	}

	public void setCateStatus(int cateStatus) {
		this.cateStatus = cateStatus;
	}

}
