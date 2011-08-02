package com.bzwx.common.dictionary.pojo;

/**
 * 数据字典管理 com.bzwx.common.dictionary.pojo.Dictionary
 * 
 * @author wwh
 * @version 1.0
 * @created 2011-7-30
 */
public class Dictionary {

	private long dictionaryId; // 字典主键
	private long parentId; // 父节点ID
	private String keyCode; // 条目code
	private String keyName; // 条目显示名称
	private String keyValue;// 条目value
	private String description;// 条目相信说明
	private int sortFlag;// 排序字段

	public long getDictionaryId() {
		return dictionaryId;
	}

	public void setDictionaryId(long dictionaryId) {
		this.dictionaryId = dictionaryId;
	}

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public String getKeyCode() {
		return keyCode;
	}

	public void setKeyCode(String keyCode) {
		this.keyCode = keyCode;
	}

	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	public String getKeyValue() {
		return keyValue;
	}

	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getSortFlag() {
		return sortFlag;
	}

	public void setSortFlag(int sortFlag) {
		this.sortFlag = sortFlag;
	}

}
