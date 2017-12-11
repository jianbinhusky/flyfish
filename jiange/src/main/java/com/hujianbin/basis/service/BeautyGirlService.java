package com.hujianbin.basis.service;

import java.util.List;
import java.util.Map;

import com.hujianbin.basis.bean.BeautyGirl;
import com.hujianbin.basis.search.BeautyGirlSearchBean;
import com.hujianbin.common.util.PageModel;

public interface BeautyGirlService {

	/**
	 * 新增BeautyGirl记录
	 * @param BeautyGirl
	 */
	public void addBeautyGirl(BeautyGirl beautyGirl);
	
	/**
	 * 批量新增BeautyGirl记录
	 * @param List
	 */
	public void batchAddBeautyGirl(List<BeautyGirl> list);
	
	/**
	 * 按照实例查找BeautyGirl记录,主要为根据主键查找
	 * @param beautyGirl
	 * @return BeautyGirl
	 */
	public BeautyGirl getBeautyGirlByExample(BeautyGirl beautyGirl);
	
	/**
	 * 修改BeautyGirl记录
	 * @param BeautyGirl
	 */
	public void modifyBeautyGirlByExample(BeautyGirl beautyGirl);
	
	/**
	 * 根据BeautyGirl实例删除记录
	 * @param BeautyGirl
	 */
	public void removeBeautyGirlByExample(BeautyGirl beautyGirl);
	
	/**
	 * 根据条件删除记录
	 * @param BeautyGirlSearchBean
	 */
	public void removeBeautyGirlByCondition(BeautyGirlSearchBean condition);
	
	public void batchRemoveBeautyGirlByExample(List<BeautyGirl> list);
	
	public void batchModifyBeautyGirlByExample(List<BeautyGirl> list);
	
	public PageModel queryBeautyGirlByCondition(BeautyGirlSearchBean condition);
	
	public PageModel queryBeautyGirlBySql(String sql,int offset,int limit);
	
	public List<BeautyGirl> queryBeautyGirlListByWhere(String where);
	
	public List<BeautyGirl> queryBeautyGirlListByExample(BeautyGirl beautyGirl);
	
	public List<BeautyGirl> getBeautyGirlByCondition(BeautyGirlSearchBean condition);
	
	public List<BeautyGirl> queryBeautyGirlListByCondition(BeautyGirlSearchBean condition);
	
	public void modifyBeautyGirlBySql(String sql);
	
	public void modifyBeautyGirlByCondition(BeautyGirlSearchBean condition);
	
	public void removeBeautyGirlBySql(String sql);
	
	public int getBeautyGirlCountBySql(String sql);
	
	public int getBeautyGirlCountByExample(BeautyGirl beautyGirl);
	
	public int getBeautyGirlCountByCondition(BeautyGirlSearchBean condition);
	
	public Map<String,Object> getBeautyGirlColumnByCondition(BeautyGirlSearchBean condition);
	
	public void updateBeautyGirlByExample(BeautyGirl beautyGirl);
}
