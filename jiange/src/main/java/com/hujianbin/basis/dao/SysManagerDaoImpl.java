package com.hujianbin.basis.dao;

import com.hujianbin.basis.bean.SysManager;
import com.hujianbin.basis.search.SysManagerSearchBean;
import org.apache.ibatis.executor.BatchResult;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupportExt;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>Title: </p>
 *
 * <p>Description:SysManager</p>
 *
 * <p>Copyright: Copyright (c) 2011</p>
 *
 * <p>Author: Guodang Zuo</p>
 *
 * @author AutoCreate
 * @version 1.0
 */

@Component(value="sysManagerDao")
public class SysManagerDaoImpl extends SqlSessionDaoSupportExt implements SysManagerDao {
	public SysManagerDaoImpl() {
		
    }

  	public int insertSysManager(SysManager sysManager){
    	return getSqlSession().insert("com.hujianbin.basis.dao.SysManagerDao.insertSysManager", sysManager);
  	}

  	public int updateSysManager(SysManager sysManager){
    	return getSqlSession().update("com.hujianbin.basis.dao.SysManagerDao.updateSysManager", sysManager);
  	}
  
  	public SysManager getSysManagerByWhere(String where){
    	return (SysManager) getSqlSession().selectOne("com.hujianbin.basis.dao.SysManagerDao.getSysManagerByWhere", where);
  	}
  
  	public List<SysManager> getSysManagerListByWhere(String where){
    	return getSqlSession().selectList("com.hujianbin.basis.dao.SysManagerDao.getSysManagerListByWhere", where);
  	}
  	
  	public List<SysManager> getSysManagerListByWhere(String where,int offset,int limit){
  		return getSqlSession().selectList("com.hujianbin.basis.dao.SysManagerDao.getSysManagerListByWhere", where,new RowBounds(offset, limit));
  	}
  	
  	public List<SysManager> getSysManagerListByCondition(SysManagerSearchBean condition){
    	return getSqlSession().selectList("com.hujianbin.basis.dao.SysManagerDao.getSysManagerListByCondition", condition,new RowBounds(condition.getStart(), condition.getCount()));
  	}
  
  	public List<SysManager> getSysManagerListBySql(String sql){
    	return getSqlSession().selectList("com.hujianbin.basis.dao.SysManagerDao.getSysManagerByWhere", sql);
  	}
  
  	public int getSysManagerCountByWhere(String where){
    	return getSqlSession().selectOne("com.hujianbin.basis.dao.SysManagerDao.getSysManagerCountByWhere", where);
  	}
  	
  	public int getSysManagerCountByExample(SysManager sysManager){
    	return getSqlSession().selectOne("com.hujianbin.basis.dao.SysManagerDao.getSysManagerCountByExample", sysManager);
  	}
  	
  	public int getSysManagerCountByCondition(SysManagerSearchBean condition){
    	return getSqlSession().selectOne("com.hujianbin.basis.dao.SysManagerDao.getSysManagerCountByCondition", condition);
  	}
  
  	public int updateSysManagerByWhere(String where){
    	return getSqlSession().update("com.hujianbin.basis.dao.SysManagerDao.updateSysManagerByWhere", where);
  	}
  
  	public int deleteSysManagerByWhere(String where){
   		return getSqlSession().delete("com.hujianbin.basis.dao.SysManagerDao.deleteSysManagerByWhere",where);
  	}
  	
  	public List<BatchResult> batchInsertSysManager(List<SysManager> list){
  		List<BatchResult> results=new ArrayList<BatchResult>();
  		SqlSession sqlSession=getBatchSqlSession();
  		for (int i=1;i<=list.size();i++) {
			sqlSession.insert("com.hujianbin.basis.dao.SysManagerDao.insertSysManager", list.get(i-1));
			if(i%1000==0)
				results.addAll(sqlSession.flushStatements());
		}
		results.addAll(sqlSession.flushStatements());
		return results;
  	}
  	
  	public SysManager getSysManagerByExample(SysManager sysManager){
  		return getSqlSession().selectOne("com.hujianbin.basis.dao.SysManagerDao.getSysManagerByExample", sysManager);
  	}
  	
  	public List<SysManager> getSysManagerListByExample(SysManager sysManager){
  		return getSqlSession().selectList("com.hujianbin.basis.dao.SysManagerDao.getSysManagerByExample", sysManager);
  	}
  	
  	public int deleteSysManagerByExample(SysManager sysManager){
  		return getSqlSession().delete("com.hujianbin.basis.dao.SysManagerDao.deleteSysManagerByExample",sysManager);
  	}
  	
  	public int deleteSysManagerByCondition(SysManagerSearchBean condition){
  		return getSqlSession().delete("com.hujianbin.basis.dao.SysManagerDao.deleteSysManagerByCondition",condition);
  	}
  	
  	public List<BatchResult> batchDeleteSysManagerByExample(List<SysManager> list){
  		List<BatchResult> results=new ArrayList<BatchResult>();
  		SqlSession sqlSession=getBatchSqlSession();
  		for (int i=1;i<=list.size();i++) {
			sqlSession.delete("com.hujianbin.basis.dao.SysManagerDao.deleteSysManagerByExample", list.get(i-1));
			if(i%1000==0)
				results.addAll(sqlSession.flushStatements());
		}
		results.addAll(sqlSession.flushStatements());
		return results;
  	}
  	
  	public List<SysManager> getSysManagerByCondition(SysManagerSearchBean condition){
    	return getSqlSession().selectList("com.hujianbin.basis.dao.SysManagerDao.getSysManagerByCondition", condition);
  	}
  	
  	public int updateSysManager(SysManagerSearchBean condition){
  		return getSqlSession().update("com.hujianbin.basis.dao.SysManagerDao.updateSysManagerByCondition", condition);
  	}
  	
  	public Map<String,Object> getSysManagerColumnByCondition(SysManagerSearchBean condition){
  		return getSqlSession().selectOne("com.hujianbin.basis.dao.SysManagerDao.getSysManagerColumnByCondition", condition);
  	}
  	
  	public List<Map<String,Object>> getSysManagerColumnListByCondition(SysManagerSearchBean condition){
  		return getSqlSession().selectList("com.hujianbin.basis.dao.SysManagerDao.getSysManagerColumnByCondition", condition);
  	}
  	
  	public int updateSysManagerByExample(SysManager sysManager){
  		return getSqlSession().update("com.hujianbin.basis.dao.SysManagerDao.updateSysManagerByExample", sysManager);
  	}
  	
  	public List<BatchResult> batchModifySysManagerByExample(List<SysManager> list){
  		List<BatchResult> results=new ArrayList<BatchResult>();
  		SqlSession sqlSession=getBatchSqlSession();
  		for (int i=1;i<=list.size();i++) {
			sqlSession.update("com.hujianbin.basis.dao.SysManagerDao.updateSysManagerByExample", list.get(i-1));
			if(i%1000==0)
				results.addAll(sqlSession.flushStatements());
		}
		results.addAll(sqlSession.flushStatements());
		return results;
  	}
}
