package com.bzwx.base.template.dao;

import java.util.List;
import java.util.Map;

import com.bzwx.base.IBatisBaseDao;
import com.bzwx.base.template.pojo.TemplateBean;

public class TemplateBeanDaoImpl extends IBatisBaseDao<TemplateBean> implements
		TemplateBeanDao {

	@Override
	public TemplateBean getInfoByCode(String code) {
		TemplateBean o = (TemplateBean) getSqlSessionTemplate().selectOne(
				"com.bzwx.base.template.pojo.TemplateBean.getInfoByCode", code);
		return o;
	}

	@Override
	public void insert(TemplateBean o) {
		getSqlSessionTemplate().insert(
				"com.bzwx.base.template.pojo.TemplateBean.insert", o);
	}

	@Override
	public void update(TemplateBean o) {
		getSqlSessionTemplate().update(
				"com.bzwx.base.template.pojo.TemplateBean.update", o);
	}

	@Override
	public void updateByMap(Map<String, Object> map) {
		getSqlSessionTemplate().update(
				"com.bzwx.base.template.pojo.TemplateBean.updateByMap", map);
	}

	@Override
	public void delete(Long recId) {
		getSqlSessionTemplate().delete(
				"com.bzwx.base.template.pojo.TemplateBean.delete", recId);
	}

	@Override
	public void deleteByIds(String ids) {
		getSqlSessionTemplate().delete(
				"com.bzwx.base.template.pojo.TemplateBean.deleteByIds", ids);
	}

	@Override
	public TemplateBean getInfoById(Long id) {
		TemplateBean o = (TemplateBean) getSqlSessionTemplate().selectList(
				"com.bzwx.base.template.pojo.TemplateBean.getInfoById", id);
		return o;
	}

	@Override
	public TemplateBean getInfoByMap(Map<String, Object> map) {
		TemplateBean o = (TemplateBean) this.getSqlSessionTemplate().selectOne(
				"com.bzwx.base.template.pojo.TemplateBean.getInfoByMap", map);
		return o;
	}

	@Override
	public List<TemplateBean> getAllList() {
		List<TemplateBean> list = (this.getSqlSessionTemplate().selectList(
				"com.bzwx.base.template.pojo.TemplateBean.getAllList", null));
		return list;
	}

	@Override
	public List<TemplateBean> getListByMap(Map<String, Object> map) {
		List<TemplateBean> list = (this.getSqlSessionTemplate().selectList(
				"com.bzwx.base.template.pojo.TemplateBean.getListByMap", map));
		return list;
	}

}
