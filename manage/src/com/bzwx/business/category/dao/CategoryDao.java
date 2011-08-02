package com.bzwx.business.category.dao;

import java.util.List;

import com.bzwx.business.category.pojo.Category;

public interface CategoryDao {
	List<Category> getListByValue(String sql);
	List<Category> getChildListByParentId(Long cateId);
	List<Category> getListByParentId(Long cateId);
	Category getCategoryById(int cateId);
	
	// @Select("SELECT * FROM user WHERE id = #{userId}")
	// Category getInfoById(@Param("userId") String userId);
}
