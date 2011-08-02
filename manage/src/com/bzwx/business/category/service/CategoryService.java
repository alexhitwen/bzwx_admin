package com.bzwx.business.category.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bzwx.business.category.dao.CategoryDaoImpl;
import com.bzwx.business.category.pojo.Category;

/**
 * 
 * com.bzwx.business.category.service.CategoryService
 * 
 * @author wwh
 * @version 1.0
 * @created 2011-7-29
 */
@Service
public class CategoryService extends CategoryDaoImpl {

	/**
	 * 获得树形数据
	 * 
	 * @param cateId
	 * @return
	 */
	public String getTreeStr(String cateId, String contextPath) {
		if (cateId == null) {
			cateId = "0"; // 如果无参数，从根节点开始遍历
		}

		List<Category> list = this.getChildListByParentId(Long.valueOf(cateId));
		StringBuffer sb = new StringBuffer();

		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Category category = (Category) list.get(i);
				List<Category> childList = getChildListByParentId(Long
						.valueOf(category.getCateId()));
				if (childList != null && childList.size() > 0) {
					sb.append("{cateId:'"
							+ category.getCateId()
							+ "',cateName:'"
							+ category.getCateName()
							+ "',href:'"
							+ contextPath
							+ "/admin/category/categoryTreeList.jsp?parentId="
							+ category.getCateId()
							+ "',hrefTarget:'rightFrame',children:"
							+ getTreeStr(String.valueOf(category.getCateId()),
									contextPath) + "},");
				} else {
					sb.append("{cateId:'" + category.getCateId()
							+ "',cateName:'" + category.getCateName()
							+ "',href:'" + contextPath
							+ "/admin/category/categoryTreeList.jsp?parentId="
							+ category.getCateId()
							+ "',hrefTarget:'rightFrame',leaf:true},");
				}
			}
		}

		if (sb.toString().endsWith(","))
			return sb.substring(0, sb.length() - 1) + "]";
		else
			return sb.append("]").toString();
	}

	public List<Category> getListByParentCode(String value) {
		List<Category> list = this.getListByValue("cate_code=" + value);
		return list;
	}

}
