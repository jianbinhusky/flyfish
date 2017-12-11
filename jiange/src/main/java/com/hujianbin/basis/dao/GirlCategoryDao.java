package com.hujianbin.basis.dao;

import org.apache.ibatis.executor.BatchResult;

import java.util.List;
import java.util.Map;
import com.hujianbin.basis.search.GirlCategorySearchBean;
import com.hujianbin.basis.bean.GirlCategory;
/**
 * <p>Title: </p>
 *
 * <p>Description:GirlCategory</p>
 *
 * <p>Copyright: Copyright (c) 2011</p>
 *
 * <p>Author: Guodang Zuo</p>
 *
 * @author AutoCreate
 * @version 1.0
 */

public interface GirlCategoryDao {

	public int insertGirlCategory(GirlCategory girlCategory);

  	public int updateGirlCategory(GirlCategory girlCategory);

  	public GirlCategory getGirlCategoryByWhere(String where);
  
  	public List<GirlCategory> getGirlCategoryListByWhere(String where,int offset,int limit);
  	
  	public List<GirlCategory> getGirlCategoryListByCondition(GirlCategorySearchBean condition);
  
  	public List<GirlCategory> getGirlCategoryListBySql(String sql);
  
  	public int getGirlCategoryCountByWhere(String where);
  	
  	public int getGirlCategoryCountByExample(GirlCategory girlCategory);
  	
  	public int getGirlCategoryCountByCondition(GirlCategorySearchBean condition);
  
  	public int updateGirlCategoryByWhere(String where);
  
  	public int deleteGirlCategoryByWhere(String where);
  	
  	public List<BatchResult> batchInsertGirlCategory(List<GirlCategory> list);
  	
  	public GirlCategory getGirlCategoryByExample(GirlCategory girlCategory);
  	
  	public List<GirlCategory> getGirlCategoryListByExample(GirlCategory girlCategory);
  	
  	public int deleteGirlCategoryByExample(GirlCategory girlCategory);
  	
  	public int deleteGirlCategoryByCondition(GirlCategorySearchBean condition);
  	
  	public List<BatchResult> batchDeleteGirlCategoryByExample(List<GirlCategory> list);
  	
  	public List<GirlCategory> getGirlCategoryByCondition(GirlCategorySearchBean condition);
  	
  	public int updateGirlCategory(GirlCategorySearchBean condition);
  	
  	public Map<String,Object> getGirlCategoryColumnByCondition(GirlCategorySearchBean condition);
  	
  	public List<Map<String,Object>> getGirlCategoryColumnListByCondition(GirlCategorySearchBean condition);
  	
  	public int updateGirlCategoryByExample(GirlCategory girlCategory);
  	
  	public List<BatchResult> batchModifyGirlCategoryByExample(List<GirlCategory> list);
}
