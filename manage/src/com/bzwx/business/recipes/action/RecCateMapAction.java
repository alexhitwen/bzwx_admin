package com.bzwx.business.recipes.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.bzwx.base.Struts2BaseAction;
import com.bzwx.business.IRecipesUpdate;
import com.bzwx.business.recipes.pojo.RecCateMap;
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
	private List<Recipes> allList;

	@Action(value = "getRecListByCateId", results = { @Result(name = "recCateMapList", location = "/admin/recipes/recCateMapList.jsp") })
	public String getRecListByCateId() {
		String beginNum1 = request.getParameter("beginNum1") == null ? "1"
				: request.getParameter("beginNum1");
		String endNum1 = request.getParameter("endNum1") == null ? "10"
				: request.getParameter("endNum1");
		String beginNum2 = request.getParameter("beginNum1") == null ? "1"
				: request.getParameter("beginNum2");
		String endNum2 = request.getParameter("endNum2") == null ? "10"
				: request.getParameter("endNum2");

		// HashMap<String, Object> map1 = new HashMap<String, String>();
		// map1.put("beginNum", beginNum1);
		// map1.put("endNum", endNum1);

		// allList = recipesService.pageQuery(map1);

		// just for test for isRecommond
		String cateId = request.getParameter("cateId") == null ? "26" : request
				.getParameter("cateId");
		String parentId = request.getParameter("parentId") == null ? "22"
				: request.getParameter("parentId");
		if (null != cateId && parentId != null) {
			// 查询本栏目下的菜品数据
			Map<String, Object> cateMap = new HashMap<String, Object>();
			cateMap.put("cateId", cateId);
			// map1.put("beginNum", beginNum2);
			// map1.put("endNum", endNum2);
			request.setAttribute("parentId", parentId);
			request.setAttribute("cateId", cateId);
			allList = recipesService.getRecListNoInCateByCateMap(cateMap);
			cateRecList = recipesService.getRecListByCateMap(cateMap);
		}

		return "recCateMapList";
	}

	@Action(value = "insertRecToCate", results = { @Result(name = "recCateMapList", location = "/admin/recipes/recCateMapList.jsp") })
	public String insertRecToCate() {
		String cateId = request.getParameter("cateId");
		String parentId = request.getParameter("parentId");
		String recId = request.getParameter("recId");
		RecCateMap recCateMap = new RecCateMap();
		recCateMap.setCateId(Long.valueOf(cateId));
		recCateMap.setRecId(Long.valueOf(recId));
		if (parentId != null)
			recCateMap.setParentId(Long.valueOf(parentId));
		recCateMapService.insert(recCateMap);

		Map<String, Object> cateMap = new HashMap<String, Object>();
		cateMap.put("cateId", cateId);
		request.setAttribute("parentId", parentId);
		request.setAttribute("cateId", cateId);
		allList = recipesService.getRecListNoInCateByCateMap(cateMap);
		cateRecList = recipesService.getRecListByCateMap(cateMap);

		return "recCateMapList";
	}

	@Action(value = "deleteRecFromCate", results = { @Result(name = "recCateMapList", location = "/admin/recipes/recCateMapList.jsp") })
	public String deleteRecFromCate() {

		String cateId = request.getParameter("cateId");
		String parentId = request.getParameter("parentId");
		String recId = request.getParameter("recId");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cateId", cateId);
		if (parentId != null)
			map.put("parentId", parentId);
		map.put("recId", recId);
		recCateMapService.deleteByMap(map);

		Map<String, Object> cateMap = new HashMap<String, Object>();
		cateMap.put("cateId", cateId);
		request.setAttribute("parentId", parentId);
		request.setAttribute("cateId", cateId);
		allList = recipesService.getRecListNoInCateByCateMap(cateMap);
		cateRecList = recipesService.getRecListByCateMap(cateMap);

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
		return allList;
	}

	public void setAllList(List<Recipes> allList) {
		this.allList = allList;
	}

}
