package com.hujianbin.basis.dao;

import org.apache.ibatis.executor.BatchResult;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupportExt;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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

@Component(value="beautyGirlDao")
public class BeautyGirlDaoImpl extends SqlSessionDaoSupportExt implements BeautyGirlDao {
	public BeautyGirlDaoImpl() {
		
    }

  	public int insertBeautyGirl(BeautyGirl beautyGirl){
    	return getSqlSession().insert("com.hujianbin.basis.dao.BeautyGirlDao.insertBeautyGirl", beautyGirl);
  	}

  	public int updateBeautyGirl(BeautyGirl beautyGirl){
    	return getSqlSession().update("com.hujianbin.basis.dao.BeautyGirlDao.updateBeautyGirl", beautyGirl);
  	}
  
  	public BeautyGirl getBeautyGirlByWhere(String where){
    	return (BeautyGirl) getSqlSession().selectOne("com.hujianbin.basis.dao.BeautyGirlDao.getBeautyGirlByWhere", where);
  	}
  
  	public List<BeautyGirl> getBeautyGirlListByWhere(String where){
    	return getSqlSession().selectList("com.hujianbin.basis.dao.BeautyGirlDao.getBeautyGirlListByWhere", where);
  	}
  	
  	public List<BeautyGirl> getBeautyGirlListByWhere(String where,int offset,int limit){
  		return getSqlSession().selectList("com.hujianbin.basis.dao.BeautyGirlDao.getBeautyGirlListByWhere", where,new RowBounds(offset, limit));
  	}
  	
  	public List<BeautyGirl> getBeautyGirlListByCondition(BeautyGirlSearchBean condition){
    	return getSqlSession().selectList("com.hujianbin.basis.dao.BeautyGirlDao.getBeautyGirlListByCondition", condition,new RowBounds(condition.getStart(), condition.getCount()));
  	}
  
  	public List<BeautyGirl> getBeautyGirlListBySql(String sql){
    	return getSqlSession().selectList("com.hujianbin.basis.dao.BeautyGirlDao.getBeautyGirlByWhere", sql);
  	}
  
  	public int getBeautyGirlCountByWhere(String where){
    	return getSqlSession().selectOne("com.hujianbin.basis.dao.BeautyGirlDao.getBeautyGirlCountByWhere", where);
  	}
  	
  	public int getBeautyGirlCountByExample(BeautyGirl beautyGirl){
    	return getSqlSession().selectOne("com.hujianbin.basis.dao.BeautyGirlDao.getBeautyGirlCountByExample", beautyGirl);
  	}
  	
  	public int getBeautyGirlCountByCondition(BeautyGirlSearchBean condition){
    	return getSqlSession().selectOne("com.hujianbin.basis.dao.BeautyGirlDao.getBeautyGirlCountByCondition", condition);
  	}
  
  	public int updateBeautyGirlByWhere(String where){
    	return getSqlSession().update("com.hujianbin.basis.dao.BeautyGirlDao.updateBeautyGirlByWhere", where);
  	}
  
  	public int deleteBeautyGirlByWhere(String where){
   		return getSqlSession().delete("com.hujianbin.basis.dao.BeautyGirlDao.deleteBeautyGirlByWhere",where);
  	}
  	
  	public List<BatchResult> batchInsertBeautyGirl(List<BeautyGirl> list){
  		List<BatchResult> results=new ArrayList<BatchResult>();
  		SqlSession sqlSession=getBatchSqlSession();
  		for (int i=1;i<=list.size();i++) {
			sqlSession.insert("com.hujianbin.basis.dao.BeautyGirlDao.insertBeautyGirl", list.get(i-1));
			if(i%1000==0)
				results.addAll(sqlSession.flushStatements());
		}
		results.addAll(sqlSession.flushStatements());
		return results;
  	}
  	
  	public BeautyGirl getBeautyGirlByExample(BeautyGirl beautyGirl){
  		return getSqlSession().selectOne("com.hujianbin.basis.dao.BeautyGirlDao.getBeautyGirlByExample", beautyGirl);
  	}
  	
  	public List<BeautyGirl> getBeautyGirlListByExample(BeautyGirl beautyGirl){
  		return getSqlSession().selectList("com.hujianbin.basis.dao.BeautyGirlDao.getBeautyGirlByExample", beautyGirl);
  	}
  	
  	public int deleteBeautyGirlByExample(BeautyGirl beautyGirl){
  		return getSqlSession().delete("com.hujianbin.basis.dao.BeautyGirlDao.deleteBeautyGirlByExample",beautyGirl);
  	}
  	
  	public int deleteBeautyGirlByCondition(BeautyGirlSearchBean condition){
  		return getSqlSession().delete("com.hujianbin.basis.dao.BeautyGirlDao.deleteBeautyGirlByCondition",condition);
  	}
  	
  	public List<BatchResult> batchDeleteBeautyGirlByExample(List<BeautyGirl> list){
  		List<BatchResult> results=new ArrayList<BatchResult>();
  		SqlSession sqlSession=getBatchSqlSession();
  		for (int i=1;i<=list.size();i++) {
			sqlSession.delete("com.hujianbin.basis.dao.BeautyGirlDao.deleteBeautyGirlByExample", list.get(i-1));
			if(i%1000==0)
				results.addAll(sqlSession.flushStatements());
		}
		results.addAll(sqlSession.flushStatements());
		return results;
  	}
  	
  	public List<BeautyGirl> getBeautyGirlByCondition(BeautyGirlSearchBean condition){
    	return getSqlSession().selectList("com.hujianbin.basis.dao.BeautyGirlDao.getBeautyGirlByCondition", condition);
  	}
  	
  	public int updateBeautyGirl(BeautyGirlSearchBean condition){
  		return getSqlSession().update("com.hujianbin.basis.dao.BeautyGirlDao.updateBeautyGirlByCondition", condition);
  	}
  	
  	public Map<String,Object> getBeautyGirlColumnByCondition(BeautyGirlSearchBean condition){
  		return getSqlSession().selectOne("com.hujianbin.basis.dao.BeautyGirlDao.getBeautyGirlColumnByCondition", condition);
  	}
  	
  	public List<Map<String,Object>> getBeautyGirlColumnListByCondition(BeautyGirlSearchBean condition){
  		return getSqlSession().selectList("com.hujianbin.basis.dao.BeautyGirlDao.getBeautyGirlColumnByCondition", condition);
  	}
  	
  	public int updateBeautyGirlByExample(BeautyGirl beautyGirl){
  		return getSqlSession().update("com.hujianbin.basis.dao.BeautyGirlDao.updateBeautyGirlByExample", beautyGirl);
  	}
  	
  	public List<BatchResult> batchModifyBeautyGirlByExample(List<BeautyGirl> list){
  		List<BatchResult> results=new ArrayList<BatchResult>();
  		SqlSession sqlSession=getBatchSqlSession();
  		for (int i=1;i<=list.size();i++) {
			sqlSession.update("com.hujianbin.basis.dao.BeautyGirlDao.updateBeautyGirlByExample", list.get(i-1));
			if(i%1000==0)
				results.addAll(sqlSession.flushStatements());
		}
		results.addAll(sqlSession.flushStatements());
		return results;
  	}
}
