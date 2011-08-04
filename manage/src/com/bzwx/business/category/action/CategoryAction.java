package com.bzwx.business.category.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.bzwx.base.Struts2BaseAction;
import com.bzwx.business.category.pojo.Category;
import com.bzwx.business.category.service.CategoryService;

/**
 * com.bzwx.business.category.action.CategoryAction
 * 
 * @author wwh
 * @version 1.0
 * @created 2011-7-28
 */
@ParentPackage("json-default")
@Namespace("/category")
@Scope("prototype")
@Results({ @Result(type = "json") })
public class CategoryAction extends Struts2BaseAction {

	private static final long serialVersionUID = 1L;

	@Autowired
	private CategoryService categoryService;
	HttpServletResponse response = ServletActionContext.getResponse();
	HttpServletRequest request = ServletActionContext.getRequest();

	private List<Category> list = null;
	private Category category = null;

	@JSON(serialize = false)
	public String getAllList() {
		list = categoryService.getAllList();
		return SUCCESS;
	}

	@JSON(serialize = false)
	public String getListByMap() {
		String cateId = request.getParameter("cateId");
		String parentId = request.getParameter("parentId");
		String cateCode = request.getParameter("cateCode");
		Map<String, Object> map = new HashMap<String, Object>();
		if (null != cateId)
			map.put("cateId", cateId);
		if (null != parentId)
			map.put("parentId", parentId);
		if (null != cateCode)
			map.put("cateCode", cateCode);

		list = categoryService.getListByMap(map);
		return SUCCESS;
	}

	@JSON(serialize = false)
	public String getChildListByParentId() {
		String cateId = request.getParameter("cateId");
		list = categoryService.getChildListByParentId(Long.valueOf(cateId));
		return SUCCESS;
	}

	@JSON(serialize = false)
	public String getListByParentId() {
		String parentId = request.getParameter("parentId");
		list = categoryService.getListByParentId(Long.valueOf(parentId));
		return SUCCESS;
	}

	@JSON(serialize = false)
	public String getListByParentCode() {
		String cateCode = request.getParameter("cateCode");
		list = categoryService.getListByParentCode(cateCode);
		return SUCCESS;
	}

	@JSON(serialize = false)
	public String getInfoById() {
		String cateId = request.getParameter("cateId");
		if (null != cateId) {
			category = categoryService.getInfoById(Long.valueOf(cateId.trim()));
		}
		// request.setAttribute("category", category);
		return SUCCESS;
	}

	@JSON(serialize = false)
	public String getCategoryById() {
		String cateId = request.getParameter("cateId");
		if (null != cateId) {
			category = categoryService.getCategoryById(Integer.valueOf(cateId
					.trim()));
		}
		// request.setAttribute("category", category);
		return SUCCESS;
	}

	// 业务跳转部分
	@JSON(serialize = false)
	@Action(value = "categoryAction", results = { @Result(name = "categoryTreeList", location = "/admin/category/categoryTreeList.jsp") })
	public String getTreeList() {
		String cateId = request.getParameter("cateId");
		String contextPath = request.getParameter("cateId");
		String jsonTreeData = categoryService.getTreeStr(cateId, contextPath);
		request.setAttribute("jsonTreeData", jsonTreeData);
		return "categoryTreeList";
	}

	@Action(value = "deleteAction", results = { @Result(name = "categoryTreeList", location = "/admin/category/categoryTreeList.jsp") })
	public String deleteById() {
		String cateId = request.getParameter("cateId");

		System.out.println(cateId);
		if (null != cateId && !"".equals(cateId)) {
			categoryService.delete(Long.valueOf(cateId));

			category = new Category();
			category.setCateId(Integer.valueOf(cateId));
			category.setParentId(Integer.valueOf(request
					.getParameter("parentId")));
		}

		return "categoryTreeList";
	}

	@Action(value = "insertOrUpdateAction", results = { @Result(name = "categoryTreeList", location = "/admin/category/categoryTreeList.jsp") })
	public String insertOrUpdate() {
		String cateId = request.getParameter("cateId");
		category = new Category();
		category.setCateCode(request.getParameter("cateCode"));
		category.setCateDesc(request.getParameter("cateDesc"));
		category.setCateName(request.getParameter("cateName"));
		category.setCateNote(request.getParameter("cateNote"));
		category.setCateStatus(Integer.valueOf(request
				.getParameter("cateStatus") == null ? "0" : request
				.getParameter("cateStatus")));
		category.setCateValue(request.getParameter("cateValue"));
		category.setParentId(Integer
				.valueOf(request.getParameter("parentId") == null ? "0"
						: request.getParameter("parentId")));
		category.setSortFlag(Integer
				.valueOf(request.getParameter("sortFlag") == null ? "0"
						: request.getParameter("sortFlag")));
		if (cateId == null || "".equals(cateId) || "0".equals(cateId)
				|| "null".equals(cateId)) {
			categoryService.insert(category);
		} else {
			category.setCateId(Integer.valueOf(cateId));
			categoryService.update(category);
		}
		return "categoryTreeList";
	}

	public List<Category> getList() {
		return list;
	}

	public Category getCategory() {
		return category;
	}

}
