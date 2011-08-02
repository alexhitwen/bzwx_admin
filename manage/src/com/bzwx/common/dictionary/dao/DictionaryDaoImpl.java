package com.bzwx.common.dictionary.dao;

import java.util.List;
import java.util.Map;

import com.bzwx.base.IBatisBaseDao;
import com.bzwx.common.dictionary.pojo.Dictionary;
import com.bzwx.common.dictionary.pojo.Dictionary;

/**
 * 
 * com.bzwx.common.dictionary.dao.DictionaryDaoImpl
 * 
 * @author wwh
 * @version 1.0
 * @created 2011-7-30
 */
public class DictionaryDaoImpl extends IBatisBaseDao<Dictionary> implements
		DictionaryDao {

	public static final long TOPMOST_DICTIONARY_ID = -1; // 根ID

	public static final String TOPMOST_DICTIONARY_NAME = "字典根节点";

	@Override
	public Dictionary getInfoByCode(String code) {
		Dictionary o = (Dictionary) getSqlSessionTemplate().selectOne(
				"com.bzwx.common.dictionary.pojo.Dictionary.getInfoByCode",
				code);
		return o;
	}

	@Override
	public void insert(Dictionary o) {
		getSqlSessionTemplate().insert(
				"com.bzwx.common.dictionary.pojo.Dictionary.insert", o);
	}

	@Override
	public void update(Dictionary o) {
		getSqlSessionTemplate().update(
				"com.bzwx.common.dictionary.pojo.Dictionary.update", o);
	}

	@Override
	public void updateByMap(Map<String, Object> map) {
		getSqlSessionTemplate().update(
				"com.bzwx.common.dictionary.pojo.Dictionary.updateByMap", map);
	}

	@Override
	public void delete(Long recId) {
		getSqlSessionTemplate().delete(
				"com.bzwx.common.dictionary.pojo.Dictionary.delete", recId);
	}

	@Override
	public void deleteByIds(String ids) {
		getSqlSessionTemplate().delete(
				"com.bzwx.common.dictionary.pojo.Dictionary.deleteByIds", ids);
	}

	@Override
	public Dictionary getInfoById(Long id) {
		Dictionary o = (Dictionary) getSqlSessionTemplate().selectList(
				"com.bzwx.common.dictionary.pojo.Dictionary.getInfoById", id);
		return o;
	}

	@Override
	public Dictionary getInfoByMap(Map<String, Object> map) {
		Dictionary o = (Dictionary) this.getSqlSessionTemplate().selectOne(
				"com.bzwx.common.dictionary.pojo.Dictionary.getInfoByMap", map);
		return o;
	}

	@Override
	public List<Dictionary> getAllList() {
		List<Dictionary> list = (this.getSqlSessionTemplate().selectList(
				"com.bzwx.common.dictionary.pojo.Dictionary.getAllList", null));
		return list;
	}

	@Override
	public List<Dictionary> getListByMap(Map<String, Object> map) {
		List<Dictionary> list = (this.getSqlSessionTemplate().selectList(
				"com.bzwx.common.dictionary.pojo.Dictionary.getListByMap", map));
		return list;
	}

	@Override
	public List<Dictionary> getListByParentId(Long parentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Dictionary> getListByParentCode(String dicCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Dictionary> getListPageByMap(Map<String, Object> pageMap) {
		// TODO Auto-generated method stub
		return null;
	}

	// /**
	// * 新增字典信息
	// *
	// * @param dictionary
	// * 字典信息
	// */
	// public void insertDictionary(Dictionary dictionary) {
	// this.getSqlMapClientTemplate().insert("insert", dictionary);
	// }
	//
	// /**
	// * 删除字典ID对应的字典信息
	// *
	// * @param dictionaryIds
	// * 一组字典ID字符串，形如：id1,id2,id3.....
	// */
	// public void deleteDictionarys(String dictionaryIds) {
	// this.getSqlMapClientTemplate().delete("deleteAll", dictionaryIds);
	// }
	//
	// /**
	// * 根据字典ID获取字典信息
	// *
	// * @param id
	// * 字典ID
	// */
	// public Dictionary getDictionary(long dictionaryId) {
	// return (Dictionary) this.getSqlMapClientTemplate().queryForObject(
	// "select", dictionaryId);
	// }
	//
	// /**
	// * 根据字典编码获取字典信息
	// *
	// * @param dictionaryCode
	// * 字典编码
	// */
	// public Dictionary getDictionary(String dictionaryCode) {
	// return (Dictionary) this.getSqlMapClientTemplate().queryForObject(
	// "getDictionaryByCode", dictionaryCode);
	// }
	//
	// /**
	// * 分页查询父字典ID对应的所有子项
	// *
	// * @param parentId
	// * 父子典信息ID
	// * @param pageNo
	// * 当前页码
	// * @param pageSize
	// * 每页显示的行数
	// * @param sortName
	// * 排序的属性名
	// * @param dir
	// * 升降序
	// */
	// public List<Dictionary> getChildren(long parentId, int pageNo,
	// int pageSize, String sortName, String dir) {
	// Map<String, Object> paramMap = new HashMap<String, Object>();
	// paramMap.put("begin", (pageNo - 1) * pageSize);
	// paramMap.put("end", pageNo * pageSize);
	// paramMap.put("parentId", parentId);
	//
	// if (dir != null)
	// paramMap.put("dir", dir);
	//
	// if (sortName != null) {
	// if (sortName.equals("keyCode")) {
	// paramMap.put("sortName", "KEY_CODE");
	// } else if (sortName.equals("keyName")) {
	// paramMap.put("sortName",
	// "nlssort(KEY_NAME,'NLS_SORT=SCHINESE_PINYIN_M')");
	// } else if (sortName.equals("keyValue")) {
	// paramMap.put("sortName", "KEY_VALUE");
	// } else if (sortName.equals("description")) {
	// paramMap.put("sortName",
	// "nlssort(DESCRIPTION,'NLS_SORT=SCHINESE_PINYIN_M')");
	// } else if (sortName.equals("orderNumber")) {
	// paramMap.put("sortName", "ORDER_NUMBER");
	// }
	// }
	//
	// return this.getSqlMapClientTemplate().queryForList("getAllByPaging",
	// paramMap);
	// }
	//
	// /**
	// * 分页查询父字典对应的所有子字典项
	// *
	// * @param parentId
	// * 父ID
	// * @param pagingMap
	// * 分页条件的Map，Map中有下面的KEY：sortName,dir,begin,end
	// */
	// public List<Dictionary> getChildren(long parentId,
	// Map<String, Object> pagingMap) {
	// if (pagingMap != null && pagingMap.size() > 0) {
	// if ("keyCode".equals(pagingMap.get("sortName")))
	// pagingMap.put("sortName", "KEY_CODE");
	// if ("keyName".equals(pagingMap.get("sortName")))
	// pagingMap.put("sortName",
	// "nlssort(KEY_NAME,'NLS_SORT=SCHINESE_PINYIN_M')");
	// if ("keyValue".equals(pagingMap.get("sortName")))
	// pagingMap.put("sortName", "KEY_VALUE");
	// if ("description".equals(pagingMap.get("sortName")))
	// pagingMap.put("sortName",
	// "nlssort(DESCRIPTION,'NLS_SORT=SCHINESE_PINYIN_M')");
	// if ("orderNumber".equals(pagingMap.get("sortName")))
	// pagingMap.put("sortName", "ORDER_NUMBER");
	// }
	//
	// pagingMap.put("parentId", parentId);
	//
	// return this.getSqlMapClientTemplate().queryForList("getAllByPaging",
	// pagingMap);
	// }
	//
	// /**
	// * 根据父ID获得它的所有子节点
	// *
	// * @param parentId
	// * 父字典ID
	// */
	// public List<Dictionary> getChildren(Long parentId) {
	// return this.getSqlMapClientTemplate().queryForList(
	// "getChildrensByParentId", parentId);
	// }
	//
	// /**
	// * 根据父ID获得它的所有子节点，结果按照某个属性对应的字段进行排序
	// *
	// * @param parentId
	// * 父字典ID
	// * @param sortName
	// * 排序的属性名
	// */
	// public List<Dictionary> getOrdinalChildren(long parentId, String
	// sortName) {
	// Map<String, Object> paramMap = new HashMap<String, Object>();
	// paramMap.put("parentId", parentId);
	//
	// if (sortName != null) {
	// if (sortName.equals("keyCode")) {
	// paramMap.put("sortName", "KEY_CODE");
	// } else if (sortName.equals("keyName")) {
	// paramMap.put("sortName",
	// "nlssort(KEY_NAME,'NLS_SORT=SCHINESE_PINYIN_M')");
	// } else if (sortName.equals("keyValue")) {
	// paramMap.put("sortName", "KEY_VALUE");
	// } else if (sortName.equals("description")) {
	// paramMap.put("sortName",
	// "nlssort(DESCRIPTION,'NLS_SORT=SCHINESE_PINYIN_M')");
	// } else if (sortName.equals("orderNumber")) {
	// paramMap.put("sortName", "ORDER_NUMBER");
	// }
	// }
	//
	// return this.getSqlMapClientTemplate().queryForList(
	// "getOrdinalChildrensByParentId", paramMap);
	// }
	//
	// // /**
	// // * 根据父对象获得它的所有子节点
	// // *
	// // * @param parentDictionary
	// // * 父字典对象
	// // */
	// // public List<Dictionary> getChildren(Dictionary parentDictionary) {
	// // return this.getSqlMapClientTemplate().queryForList(
	// // "getChildrensByParent",
	// // parentDictionary);
	// // }
	//
	// /**
	// * 更新字典信息
	// *
	// * @param dictionary
	// * 字典信息对象
	// */
	// public void updateDictionary(Dictionary dictionary) {
	// this.getSqlMapClientTemplate().update("update", dictionary);
	// }
	//
	// /**
	// * 新增记录时，更新排序号
	// *
	// * @param parentId
	// * 父字典ID
	// * @param orderNumber
	// * 排序号
	// */
	// public void updateOrder(Long parentId, Integer orderNumber) {
	// Map map = new HashMap();
	// map.put("parentId", parentId);
	// map.put("orderNumber", orderNumber);
	//
	// this.getSqlMapClientTemplate().update("updateOrder_Insert", map);
	// }
	//
	// /**
	// * 修改字典信息时，更新排序号
	// *
	// * @param parentId
	// * 父字典ID
	// * @param oldOrder
	// * 老的排序号
	// * @param newOrder
	// * 新的排序号
	// */
	// public void updateOrder(long parentId, int oldOrder, int newOrder) {
	// Map map = new HashMap();
	// map.put("parentId", parentId);
	// map.put("oldOrder", oldOrder);
	// map.put("newOrder", newOrder);
	//
	// this.getSqlMapClientTemplate().update("updateOrder_Update", map);
	// }
	//
	// /**
	// * 根据字典ID更新排序号
	// *
	// * @param id
	// * 字典ID
	// * @param orderNumber
	// * 排序号
	// */
	// public void updateOrderById(Long id, Integer orderNumber) {
	// Map map = new HashMap();
	// map.put("id", id);
	// map.put("orderNumber", orderNumber);
	//
	// this.getSqlMapClientTemplate().update("updateOrder", map);
	// }
	//
	// /**
	// * 获取最顶级的所有字典信息
	// */
	// public List<Dictionary> getAllTopmostDictionary() {
	// return this.getSqlMapClientTemplate().queryForList("getTopmost");
	// }
	//
	// // new add
	// public List getDictionaryByParentKeyCode(String keyCode) {
	// return this
	// .getSqlMapClientTemplate()
	// .queryForList(
	// "com.cssweb.base.dictionary.pojo.Dictionary.getDictionaryByParentKeyCode",
	// keyCode);
	//
	// }

}