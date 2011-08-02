package com.bzwx.business.category.dao;

import java.util.List;
import java.util.Map;

import com.bzwx.base.IBatisBaseDao;
import com.bzwx.business.category.pojo.Category;

public class CategoryDaoImpl extends IBatisBaseDao<Category> implements
		CategoryDao {

	@Override
	public void insert(Category o) {
		getSqlSessionTemplate().insert(
				"com.bzwx.business.category.pojo.Category.insert", o);
	}

	@Override
	public void update(Category o) {
		getSqlSessionTemplate().update(
				"com.bzwx.business.category.pojo.Category.update", o);
	}

	@Override
	public void updateByMap(Map<String, Object> map) {
		getSqlSessionTemplate().update(
				"com.bzwx.business.category.pojo.Category.updateByMap", map);
	}

	@Override
	public void delete(Long recId) {
		getSqlSessionTemplate().delete(
				"com.bzwx.business.category.pojo.Category.delete", recId);
	}

	@Override
	public void deleteByIds(String ids) {
		getSqlSessionTemplate().delete(
				"com.bzwx.business.category.pojo.Category.deleteByIds", ids);
	}

	@Override
	public Category getInfoById(Long id) {
		Category o = (Category) getSqlSessionTemplate().selectOne(
				"com.bzwx.business.category.pojo.Category.getInfoById", id);
		return o;
	}
	
	@Override
	public Category getCategoryById(int id) {
		Category o = (Category) getSqlSessionTemplate().selectOne(
				"com.bzwx.business.category.pojo.Category.getCategoryById", id);
		return o;
	}
	

	@Override
	public Category getInfoByMap(Map<String, Object> map) {
		Category o = (Category) this.getSqlSessionTemplate().selectOne(
				"com.bzwx.business.category.pojo.Category.getInfoByMap", map);
		return o;
	}

	@Override
	public List<Category> getAllList() {
		List<Category> list = (this.getSqlSessionTemplate().selectList(
				"com.bzwx.business.category.pojo.Category.getAllList", null));
		return list;
	}

	@Override
	public List<Category> getListByMap(Map<String, Object> map) {
		List<Category> list = (this.getSqlSessionTemplate().selectList(
				"com.bzwx.business.category.pojo.Category.getListByMap", map));
		return list;
	}

	@Override
	public List<Category> getListByValue(String sql) {
		List<Category> list = (this.getSqlSessionTemplate().selectList(
				"com.bzwx.business.category.pojo.Category.getListByValue", sql));
		return list;
	}

	@Override
	public List<Category> getChildListByParentId(Long parentId) {
		List<Category> list = (this.getSqlSessionTemplate()
				.selectList(
						"com.bzwx.business.category.pojo.Category.getChildListByParentId",
						parentId));
		return list;
	}

	@Override
	public List<Category> getListByParentId(Long cateId) {
		List<Category> list = (this.getSqlSessionTemplate()
				.selectList(
						"com.bzwx.business.category.pojo.Category.getListByParentId",
						cateId));
		return list;
	}

}
