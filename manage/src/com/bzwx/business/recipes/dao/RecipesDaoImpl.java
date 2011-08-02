package com.bzwx.business.recipes.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bzwx.base.IBatisBaseDao;
import com.bzwx.business.recipes.pojo.Recipes;

/**
 * 
 * com.bzwx.business.recipes.dao.RecipesDaoImpl
 * 
 * @author wwh
 * @version 1.0
 * @created 2011-7-27
 */
public class RecipesDaoImpl extends IBatisBaseDao<Recipes> implements
		RecipesDao {

	@Override
	public void insert(Recipes o) {
		getSqlSessionTemplate().insert(
				"com.bzwx.business.recipes.pojo.Recipes.insert", o);
	}

	@Override
	public void update(Recipes o) {
		getSqlSessionTemplate().update(
				"com.bzwx.business.recipes.pojo.Recipes.update", o);
	}

	@Override
	public void updateByMap(Map<String, Object> map) {
		getSqlSessionTemplate().update(
				"com.bzwx.business.recipes.pojo.Recipes.updateByMap", map);
	}

	@Override
	public void delete(Long recId) {
		getSqlSessionTemplate().delete(
				"com.bzwx.business.recipes.pojo.Recipes.delete", recId);
	}

	@Override
	public void deleteByIds(String ids) {
		getSqlSessionTemplate().delete(
				"com.bzwx.business.recipes.pojo.Recipes.deleteByIds", ids);
	}

	@Override
	public Recipes getInfoById(Long id) {
		Recipes o = (Recipes) getSqlSessionTemplate().selectOne(
				"com.bzwx.business.recipes.pojo.Recipes.getInfoById", id);
		return o;
	}

	@Override
	public Recipes getInfoByMap(Map<String, Object> map) {
		Recipes o = (Recipes) this.getSqlSessionTemplate().selectOne(
				"com.bzwx.business.recipes.pojo.Recipes.getInfoByMap", map);
		return o;
	}

	@Override
	public List<Recipes> getAllList() {
		List<Recipes> list = (this.getSqlSessionTemplate().selectList(
				"com.bzwx.business.recipes.pojo.Recipes.getAllList", null));
		return list;
	}

	@Override
	public List<Recipes> getListByMap(Map<String, Object> map) {
		List<Recipes> list = (this.getSqlSessionTemplate().selectList(
				"com.bzwx.business.recipes.pojo.Recipes.getListByMap", map));
		return list;
	}

	@Override
	public List<Recipes> getListForClientByMap(Map<String, Object> map) {
		List<Recipes> list = (this.getSqlSessionTemplate().selectList(
				"com.bzwx.business.recipes.pojo.Recipes.getListByMap", map));
		return list;
	}

	@Override
	public List<Recipes> getAllListForClient() {
		List<Recipes> list = (this.getSqlSessionTemplate()
				.selectList("com.bzwx.business.recipes.pojo.Recipes.getListByMap"));
		return list;
	}

	@Override
	public List<Recipes> pageQuery(HashMap<String, String> map) {
		List<Recipes> list = (this.getSqlSessionTemplate().selectList(
				"com.bzwx.business.recipes.pojo.Recipes.pageQuery", map));
		return list;
	}

}
