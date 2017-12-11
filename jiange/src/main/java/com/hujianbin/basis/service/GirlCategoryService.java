package com.hujianbin.basis.service;

import java.util.List;
import java.util.Map;

import com.hujianbin.basis.bean.GirlCategory;
import com.hujianbin.basis.search.GirlCategorySearchBean;
import com.hujianbin.common.util.PageModel;

public interface GirlCategoryService {

	/**
	 * 新增GirlCategory记录
	 * @param GirlCategory
	 */
	public void addGirlCategory(GirlCategory girlCategory);
	
	/**
	 * 批量新增GirlCategory记录
	 * @param List
	 */
	public void batchAddGirlCategory(List<GirlCategory> list);
	
	/**
	 * 按照实例查找GirlCategory记录,主要为根据主键查找
	 * @param girlCategory
	 * @return GirlCategory
	 */
	public GirlCategory getGirlCategoryByExample(GirlCategory girlCategory);
	
	/**
	 * 修改GirlCategory记录
	 * @param GirlCategory
	 */
	public void modifyGirlCategoryByExample(GirlCategory girlCategory);
	
	/**
	 * 根据GirlCategory实例删除记录
	 * @param GirlCategory
	 */
	public void removeGirlCategoryByExample(GirlCategory girlCategory);
	
	/**
	 * 根据条件删除记录
	 * @param GirlCategorySearchBean
	 */
	public void removeGirlCategoryByCondition(GirlCategorySearchBean condition);
	
	public void batchRemoveGirlCategoryByExample(List<GirlCategory> list);
	
	public void batchModifyGirlCategoryByExample(List<GirlCategory> list);
	
	public PageModel queryGirlCategoryByCondition(GirlCategorySearchBean condition);
	
	public PageModel queryGirlCategoryBySql(String sql,int offset,int limit);
	
	public List<GirlCategory> queryGirlCategoryListByWhere(String where);
	
	public List<GirlCategory> queryGirlCategoryListByExample(GirlCategory girlCategory);
	
	public List<GirlCategory> getGirlCategoryByCondition(GirlCategorySearchBean condition);
	
	public List<GirlCategory> queryGirlCategoryListByCondition(GirlCategorySearchBean condition);
	
	public void modifyGirlCategoryBySql(String sql);
	
	public void modifyGirlCategoryByCondition(GirlCategorySearchBean condition);
	
	public void removeGirlCategoryBySql(String sql);
	
	public int getGirlCategoryCountBySql(String sql);
	
	public int getGirlCategoryCountByExample(GirlCategory girlCategory);
	
	public int getGirlCategoryCountByCondition(GirlCategorySearchBean condition);
	
	public Map<String,Object> getGirlCategoryColumnByCondition(GirlCategorySearchBean condition);
	
	public void updateGirlCategoryByExample(GirlCategory girlCategory);
}
