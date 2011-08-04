package com.bzwx.business.recipes.dao;

import java.util.List;
import java.util.Map;

import com.bzwx.base.IBatisBaseDao;
import com.bzwx.business.recipes.pojo.RecCateMap;

public class RecCateMapDaoImpl extends IBatisBaseDao<RecCateMap> implements
		RecCateMapDao {

	@Override
	public void insert(RecCateMap o) {
		getSqlSessionTemplate().insert(
				"com.bzwx.business.recipes.pojo.RecCateMap.insert", o);
	}

	@Override
	public void deleteByMap(Map<String, Object> map) {
		getSqlSessionTemplate().delete(
				"com.bzwx.business.recipes.pojo.RecCateMap.deleteByMap", map);
	}

	@Override
	public void update(RecCateMap o) {
		getSqlSessionTemplate().update(
				"com.bzwx.business.recipes.pojo.RecCateMap.update", o);
	}

	@Override
	public void updateByMap(Map<String, Object> map) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long recId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteByIds(String ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public RecCateMap getInfoById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RecCateMap getInfoByMap(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RecCateMap> getAllList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RecCateMap> getListByMap(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

}
