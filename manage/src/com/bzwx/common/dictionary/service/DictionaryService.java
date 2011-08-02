package com.bzwx.common.dictionary.service;

import com.bzwx.common.dictionary.dao.DictionaryDaoImpl;

/**
 * 
 * com.bzwx.common.dictionary.service.DictionaryService
 * 
 * @author wwh
 * @version 1.0
 * @created 2011-7-30
 */
public class DictionaryService extends DictionaryDaoImpl {
//
//	/**
//	 * 删除字典ID对应的字典及其所有下属字典信息
//	 * 
//	 * 1.调用getSelfAndChildrenIdsByGroup(String dicIds)方法 得到所有字典ID
//	 * 2.调用deleteDictionarys(String dictionaryIds)方法删除字典ID对应的字典信息
//	 * 
//	 * @param dictionaryIds
//	 *            一组字典ID字符串，形如：id1,id2,id3.....
//	 */
//	public void deleteDictionarysAndChildren(String dictionaryIds) {
//		// 调用getSelfAndChildrenIdsByGroup(String dicIds)方法 得到所有字典ID
//		String dicIds = getSelfAndChildrenIdsByGroup(dictionaryIds);
//
//		// 调用deleteDictionarys(String dictionaryIds)方法删除字典ID对应的字典信息
//		this.deleteDictionarys(dicIds);
//	}
//
//	/**
//	 * 迭代获得一组字典ID及其对应的所有下属字典ID组成的字符串。形如：id1,id2,id3......,idn
//	 * 
//	 * @param dicIds
//	 *            一组ID的字符串，形如:id1,id2,id3......,idn
//	 * @return
//	 */
//	private String getSelfAndChildrenIdsByGroup(String dicIds) {
//		StringBuffer allDictionaryIds = new StringBuffer();
//		if (dicIds == null)
//			return null;
//
//		String[] ids = null;
//		if (dicIds.length() > 0) {
//			ids = dicIds.split(Constants.ID_SEPARATOR);
//		}
//		if (ids != null && ids.length > 0) {
//			for (int i = 0; i < ids.length; i++) {
//				String childIds = getSelfAndChildrenIdsByParent(Long
//						.valueOf(ids[i]));
//				if (childIds != null && childIds.length() > 0)
//					allDictionaryIds.append(childIds + Constants.ID_SEPARATOR);
//			}
//		}
//
//		return StringUtil.trim(allDictionaryIds, Constants.ID_SEPARATOR);
//	}
//
//	/**
//	 * 获得父ID及其对应的所有下属字典ID组成的字符串。形如：id1,id2,id3......,idn
//	 * 
//	 * @param parentId
//	 *            父ID
//	 * @return
//	 */
//	private String getSelfAndChildrenIdsByParent(long parentId) {
//		StringBuffer dicIds = getDictionaryIdsIterator(parentId);
//		if (StringUtil.trim(dicIds, Constants.ID_SEPARATOR) == null) {
//			return String.valueOf(parentId);
//		} else {
//			return parentId + Constants.ID_SEPARATOR
//					+ StringUtil.trim(dicIds, Constants.ID_SEPARATOR);
//		}
//	}
//
//	/**
//	 * 获得父ID及其所有下属字典ID字符串的迭代函数。
//	 * 
//	 * @param parentId
//	 *            父ID
//	 * @return
//	 */
//	private StringBuffer getDictionaryIdsIterator(long parentId) {
//		StringBuffer dicIds = new StringBuffer();
//
//		List<Dictionary> dics = getChildren(parentId);
//		if (dics != null && dics.size() > 0) {
//			for (int i = 0; i < dics.size(); i++) {
//				Dictionary dic = (Dictionary) dics.get(i);
//				if (dic != null) {
//					dicIds.append(dic.getDictionaryId()
//							+ Constants.ID_SEPARATOR);
//					StringBuffer ids = getDictionaryIdsIterator(dic
//							.getDictionaryId());
//					if (ids != null)
//						dicIds.append(ids);
//				}
//			}
//		}
//
//		return dicIds;
//	}
//
//	/**
//	 * 判断字典表初始化的状态。
//	 * 
//	 * @return 0:未进行初始化；1:初始化成功；-1:初始化不正确；
//	 */
//	public int initialState() {
//		List<Dictionary> topDics = this.getAllTopmostDictionary();
//		if (topDics != null) {
//			if (topDics.size() == 1) { // 最顶级字典项只能有一个
//				Dictionary dic = (Dictionary) topDics.get(0);
//				if (dic != null
//						&& dic.getDictionaryId() == TOPMOST_DICTIONARY_ID) {
//					return 1;
//				}
//			} else if (topDics.size() > 1) {
//				// System.out.println("初始化字典表不正确，最顶级有多个字典项");
//				return -1;
//			}
//		}
//
//		return 0;
//	}
//
//	/**
//	 * 获取最顶级字典项
//	 * 
//	 * @return
//	 */
//	public Dictionary getTopmostDictionary() {
//		List<Dictionary> topDics = this.getAllTopmostDictionary();
//		if (topDics != null) {
//			for (Dictionary dic : topDics) {
//				if (dic != null
//						&& dic.getDictionaryId() == TOPMOST_DICTIONARY_ID) {
//					return dic;
//				}
//			}
//		}
//
//		return null;
//	}
//
//	/**
//	 * 获得指定字典编码的所有子节点，结果按照字典名称的进行升序排列
//	 * 
//	 * @param dictionaryCode
//	 *            字典编码
//	 * @return
//	 */
//	public List<Dictionary> getChildren(String dictionaryCode) {
//		if (dictionaryCode == null)
//			return null;
//
//		Dictionary dic = this.getDictionary(dictionaryCode);
//		if (dic != null) {
//			return this.getOrdinalChildren(dic.getDictionaryId(), "keyName");
//		} else {
//			return null;
//		}
//	}
//
//	public Dictionary getDictionaryByKeyCode(String keyCode) {
//		return (Dictionary) this
//				.getSqlMapClientTemplate()
//				.queryForObject(
//						"com.cssweb.common.dictionary.pojo.Dictionary.getDictionaryByKeyCode",
//						keyCode);
//	}
}