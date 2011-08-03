package com.bzwx.business.recipes.action;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.bzwx.base.Struts2BaseAction;
import com.bzwx.business.IRecipesUpdate;
import com.bzwx.business.recipes.pojo.Recipes;
import com.bzwx.business.recipes.service.RecCateMapService;
import com.bzwx.business.recipes.service.RecipesService;

public class RecCateMapAction extends Struts2BaseAction implements
		IRecipesUpdate {

	private static final long serialVersionUID = 1L;
	HttpServletRequest request = ServletActionContext.getRequest();

	private Recipes recipes;

	@Autowired
	private RecipesService recipesService;
	@Autowired
	private RecCateMapService recCateMapService;
	
	
	
	private List<Recipes> cateRecList;
	private List<Recipes> AllList;

	@Action(value = "getRecListByCateId", results = { @Result(name = "recCateMapList", location = "/admin/recipes/recCateMapList.jsp") })
	public String getRecListByCateId() {

		String beginNum1 = request.getParameter("beginNum1") == null ? "1"
				: request.getParameter("beginNum1");
		String endNum1 = request.getParameter("endNum1") == null ? "10"
				: request.getParameter("endNum1");

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("beginNum", beginNum1);
		map.put("endNum", endNum1);
		AllList = recipesService.pageQuery(map);

		String cateId = request.getParameter("cateId");
		String parentId = request.getParameter("parentId");
		if (null != cateId && parentId != null) {
			// 查询本栏目下的数据
			
		}

		return "recCateMapList";
	}

	@Override
	public String getRecipesUpdate() {
		return null;
	}

	public Recipes getRecipes() {
		return recipes;
	}

	public void setRecipes(Recipes recipes) {
		this.recipes = recipes;
	}

	public List<Recipes> getCateRecList() {
		return cateRecList;
	}

	public void setCateRecList(List<Recipes> cateRecList) {
		this.cateRecList = cateRecList;
	}

	public List<Recipes> getAllList() {
		return AllList;
	}

	public void setAllList(List<Recipes> allList) {
		AllList = allList;
	}

}
