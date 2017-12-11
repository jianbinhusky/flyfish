package com.hujianbin.basis.dao;

import org.apache.ibatis.executor.BatchResult;

import java.util.List;
import java.util.Map;
import com.hujianbin.basis.search.BeautyGirlSearchBean;
import com.hujianbin.basis.bean.BeautyGirl;
/**
 * <p>Title: </p>
 *
 * <p>Description:BeautyGirl</p>
 *
 * <p>Copyright: Copyright (c) 2011</p>
 *
 * <p>Author: Guodang Zuo</p>
 *
 * @author AutoCreate
 * @version 1.0
 */

public interface BeautyGirlDao {

	public int insertBeautyGirl(BeautyGirl beautyGirl);

  	public int updateBeautyGirl(BeautyGirl beautyGirl);

  	public BeautyGirl getBeautyGirlByWhere(String where);
  
  	public List<BeautyGirl> getBeautyGirlListByWhere(String where,int offset,int limit);
  	
  	public List<BeautyGirl> getBeautyGirlListByCondition(BeautyGirlSearchBean condition);
  
  	public List<BeautyGirl> getBeautyGirlListBySql(String sql);
  
  	public int getBeautyGirlCountByWhere(String where);
  	
  	public int getBeautyGirlCountByExample(BeautyGirl beautyGirl);
  	
  	public int getBeautyGirlCountByCondition(BeautyGirlSearchBean condition);
  
  	public int updateBeautyGirlByWhere(String where);
  
  	public int deleteBeautyGirlByWhere(String where);
  	
  	public List<BatchResult> batchInsertBeautyGirl(List<BeautyGirl> list);
  	
  	public BeautyGirl getBeautyGirlByExample(BeautyGirl beautyGirl);
  	
  	public List<BeautyGirl> getBeautyGirlListByExample(BeautyGirl beautyGirl);
  	
  	public int deleteBeautyGirlByExample(BeautyGirl beautyGirl);
  	
  	public int deleteBeautyGirlByCondition(BeautyGirlSearchBean condition);
  	
  	public List<BatchResult> batchDeleteBeautyGirlByExample(List<BeautyGirl> list);
  	
  	public List<BeautyGirl> getBeautyGirlByCondition(BeautyGirlSearchBean condition);
  	
  	public int updateBeautyGirl(BeautyGirlSearchBean condition);
  	
  	public Map<String,Object> getBeautyGirlColumnByCondition(BeautyGirlSearchBean condition);
  	
  	public List<Map<String,Object>> getBeautyGirlColumnListByCondition(BeautyGirlSearchBean condition);
  	
  	public int updateBeautyGirlByExample(BeautyGirl beautyGirl);
  	
  	public List<BatchResult> batchModifyBeautyGirlByExample(List<BeautyGirl> list);
}
