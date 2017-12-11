package com.hujianbin.basis.dao;

import org.apache.ibatis.executor.BatchResult;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupportExt;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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

@Component(value="girlCategoryDao")
public class GirlCategoryDaoImpl extends SqlSessionDaoSupportExt implements GirlCategoryDao {
	public GirlCategoryDaoImpl() {
		
    }

  	public int insertGirlCategory(GirlCategory girlCategory){
    	return getSqlSession().insert("com.hujianbin.basis.dao.GirlCategoryDao.insertGirlCategory", girlCategory);
  	}

  	public int updateGirlCategory(GirlCategory girlCategory){
    	return getSqlSession().update("com.hujianbin.basis.dao.GirlCategoryDao.updateGirlCategory", girlCategory);
  	}
  
  	public GirlCategory getGirlCategoryByWhere(String where){
    	return (GirlCategory) getSqlSession().selectOne("com.hujianbin.basis.dao.GirlCategoryDao.getGirlCategoryByWhere", where);
  	}
  
  	public List<GirlCategory> getGirlCategoryListByWhere(String where){
    	return getSqlSession().selectList("com.hujianbin.basis.dao.GirlCategoryDao.getGirlCategoryListByWhere", where);
  	}
  	
  	public List<GirlCategory> getGirlCategoryListByWhere(String where,int offset,int limit){
  		return getSqlSession().selectList("com.hujianbin.basis.dao.GirlCategoryDao.getGirlCategoryListByWhere", where,new RowBounds(offset, limit));
  	}
  	
  	public List<GirlCategory> getGirlCategoryListByCondition(GirlCategorySearchBean condition){
    	return getSqlSession().selectList("com.hujianbin.basis.dao.GirlCategoryDao.getGirlCategoryListByCondition", condition,new RowBounds(condition.getStart(), condition.getCount()));
  	}
  
  	public List<GirlCategory> getGirlCategoryListBySql(String sql){
    	return getSqlSession().selectList("com.hujianbin.basis.dao.GirlCategoryDao.getGirlCategoryByWhere", sql);
  	}
  
  	public int getGirlCategoryCountByWhere(String where){
    	return getSqlSession().selectOne("com.hujianbin.basis.dao.GirlCategoryDao.getGirlCategoryCountByWhere", where);
  	}
  	
  	public int getGirlCategoryCountByExample(GirlCategory girlCategory){
    	return getSqlSession().selectOne("com.hujianbin.basis.dao.GirlCategoryDao.getGirlCategoryCountByExample", girlCategory);
  	}
  	
  	public int getGirlCategoryCountByCondition(GirlCategorySearchBean condition){
    	return getSqlSession().selectOne("com.hujianbin.basis.dao.GirlCategoryDao.getGirlCategoryCountByCondition", condition);
  	}
  
  	public int updateGirlCategoryByWhere(String where){
    	return getSqlSession().update("com.hujianbin.basis.dao.GirlCategoryDao.updateGirlCategoryByWhere", where);
  	}
  
  	public int deleteGirlCategoryByWhere(String where){
   		return getSqlSession().delete("com.hujianbin.basis.dao.GirlCategoryDao.deleteGirlCategoryByWhere",where);
  	}
  	
  	public List<BatchResult> batchInsertGirlCategory(List<GirlCategory> list){
  		List<BatchResult> results=new ArrayList<BatchResult>();
  		SqlSession sqlSession=getBatchSqlSession();
  		for (int i=1;i<=list.size();i++) {
			sqlSession.insert("com.hujianbin.basis.dao.GirlCategoryDao.insertGirlCategory", list.get(i-1));
			if(i%1000==0)
				results.addAll(sqlSession.flushStatements());
		}
		results.addAll(sqlSession.flushStatements());
		return results;
  	}
  	
  	public GirlCategory getGirlCategoryByExample(GirlCategory girlCategory){
  		return getSqlSession().selectOne("com.hujianbin.basis.dao.GirlCategoryDao.getGirlCategoryByExample", girlCategory);
  	}
  	
  	public List<GirlCategory> getGirlCategoryListByExample(GirlCategory girlCategory){
  		return getSqlSession().selectList("com.hujianbin.basis.dao.GirlCategoryDao.getGirlCategoryByExample", girlCategory);
  	}
  	
  	public int deleteGirlCategoryByExample(GirlCategory girlCategory){
  		return getSqlSession().delete("com.hujianbin.basis.dao.GirlCategoryDao.deleteGirlCategoryByExample",girlCategory);
  	}
  	
  	public int deleteGirlCategoryByCondition(GirlCategorySearchBean condition){
  		return getSqlSession().delete("com.hujianbin.basis.dao.GirlCategoryDao.deleteGirlCategoryByCondition",condition);
  	}
  	
  	public List<BatchResult> batchDeleteGirlCategoryByExample(List<GirlCategory> list){
  		List<BatchResult> results=new ArrayList<BatchResult>();
  		SqlSession sqlSession=getBatchSqlSession();
  		for (int i=1;i<=list.size();i++) {
			sqlSession.delete("com.hujianbin.basis.dao.GirlCategoryDao.deleteGirlCategoryByExample", list.get(i-1));
			if(i%1000==0)
				results.addAll(sqlSession.flushStatements());
		}
		results.addAll(sqlSession.flushStatements());
		return results;
  	}
  	
  	public List<GirlCategory> getGirlCategoryByCondition(GirlCategorySearchBean condition){
    	return getSqlSession().selectList("com.hujianbin.basis.dao.GirlCategoryDao.getGirlCategoryByCondition", condition);
  	}
  	
  	public int updateGirlCategory(GirlCategorySearchBean condition){
  		return getSqlSession().update("com.hujianbin.basis.dao.GirlCategoryDao.updateGirlCategoryByCondition", condition);
  	}
  	
  	public Map<String,Object> getGirlCategoryColumnByCondition(GirlCategorySearchBean condition){
  		return getSqlSession().selectOne("com.hujianbin.basis.dao.GirlCategoryDao.getGirlCategoryColumnByCondition", condition);
  	}
  	
  	public List<Map<String,Object>> getGirlCategoryColumnListByCondition(GirlCategorySearchBean condition){
  		return getSqlSession().selectList("com.hujianbin.basis.dao.GirlCategoryDao.getGirlCategoryColumnByCondition", condition);
  	}
  	
  	public int updateGirlCategoryByExample(GirlCategory girlCategory){
  		return getSqlSession().update("com.hujianbin.basis.dao.GirlCategoryDao.updateGirlCategoryByExample", girlCategory);
  	}
  	
  	public List<BatchResult> batchModifyGirlCategoryByExample(List<GirlCategory> list){
  		List<BatchResult> results=new ArrayList<BatchResult>();
  		SqlSession sqlSession=getBatchSqlSession();
  		for (int i=1;i<=list.size();i++) {
			sqlSession.update("com.hujianbin.basis.dao.GirlCategoryDao.updateGirlCategoryByExample", list.get(i-1));
			if(i%1000==0)
				results.addAll(sqlSession.flushStatements());
		}
		results.addAll(sqlSession.flushStatements());
		return results;
  	}
}
