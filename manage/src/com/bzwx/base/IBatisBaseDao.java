package com.bzwx.base;

//import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * IBatis 基类 com.bzwx.base.IBatisBaseDao
 * 
 * @author wwh
 * @version 1.0
 * @created 2011-7-30
 */
@Repository
public abstract class IBatisBaseDao<T> extends SqlSessionDaoSupport {

	@Autowired
	public void setMySqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	// 新增
	public abstract void insert(T o);

	// 修改
	public abstract void update(T o);

	// 按条件修改相关标志状态
	public abstract void updateByMap(Map<String, Object> map);

	// 删除
	public abstract void delete(Long recId);

	// 按ids删除
	public abstract void deleteByIds(String ids);

	// 按主键查询对象
	public abstract T getInfoById(Long id);

	// 按条件查询对象
	public abstract T getInfoByMap(Map<String, Object> map);

	// 查询所有列表
	public abstract List<T> getAllList();

	// 按map查询对象列表
	public abstract List<T> getListByMap(Map<String, Object> map);

}
