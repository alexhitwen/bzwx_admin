package com.bzwx.business.recipes.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bzwx.business.recipes.pojo.Recipes;

/**
 * 
 * com.bzwx.business.recipes.dao.RecipesDao
 * 
 * @author wwh
 * @version 1.0
 * @created 2011-7-27
 */
public interface RecipesDao {
	
	

	public List<Recipes> getRecListByCateId(Long cateId); // 按分类查询菜品列表返回给客户端
	public List<Recipes> getRecListByCateMap(Map<String, Object> map); // 按分类查询菜品列表返回给客户端
	public List<Recipes> getRecListNoInCateByCateMap(Map<String, Object> map); // 按分类查询非栏目下菜品列表
	
	public List<Recipes> getListForClientByMap(Map<String, Object> map); // 按条件查询菜品列表返回给客户端

	public List<Recipes> getAllListForClient(); // 查询所有菜品列表返回给客户端

	public List<Recipes> pageQuery(HashMap<String, String> map); // 分页查询菜品列表

}
