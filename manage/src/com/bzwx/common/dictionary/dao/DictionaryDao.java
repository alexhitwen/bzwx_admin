package com.bzwx.common.dictionary.dao;

import java.util.List;
import java.util.Map;

import com.bzwx.common.dictionary.pojo.Dictionary;

/**
 * 
 * com.bzwx.common.dictionary.dao.DictionaryDao
 * 
 * @author wwh
 * @version 1.0
 * @created 2011-7-30
 */
public interface DictionaryDao {

	public Dictionary getInfoByCode(String dicCode);// 按code查询字典项目

	public List<Dictionary> getListByParentId(Long parentId); // 按父ID查询子节点列表

	public List<Dictionary> getListByParentCode(String dicCode); // 按父code查询子节点列表

	public List<Dictionary> getListPageByMap(Map<String, Object> pageMap); // 按父ID分页查询子节点列表

}