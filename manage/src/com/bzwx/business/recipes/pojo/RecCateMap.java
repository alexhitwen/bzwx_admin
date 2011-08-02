package com.bzwx.business.recipes.pojo;

/**
 * 菜品-栏目映射关系 com.bzwx.business.recipes.pojo.RecCateMap
 * 
 * @author wwh
 * @version 1.0
 * @created 2011-8-2
 */
public class RecCateMap {

	private Long id;
	private Long recId;
	private Long cateId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRecId() {
		return recId;
	}

	public void setRecId(Long recId) {
		this.recId = recId;
	}

	public Long getCateId() {
		return cateId;
	}

	public void setCateId(Long cateId) {
		this.cateId = cateId;
	}

}
