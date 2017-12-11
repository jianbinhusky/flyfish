package com.hujianbin.basis.dao;

import org.apache.ibatis.executor.BatchResult;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupportExt;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.hujianbin.basis.search.BlogUserSearchBean;
import com.hujianbin.basis.bean.BlogUser;

/**
 * <p>Title: </p>
 *
 * <p>Description:BlogUser</p>
 *
 * <p>Copyright: Copyright (c) 2015</p>
 *
 * <p>Author: hujianbin</p>
 *
 * @author AutoCreate
 * @version 1.0
 */

@Component(value="blogUserDao")
public class BlogUserDaoImpl extends SqlSessionDaoSupportExt implements BlogUserDao {
	public BlogUserDaoImpl() {
		
    }

  	public int insertBlogUser(BlogUser blogUser){
    	return getSqlSession().insert("com.hujianbin.basis.dao.BlogUserDao.insertBlogUser", blogUser);
  	}

  	public int updateBlogUser(BlogUser blogUser){
    	return getSqlSession().update("com.hujianbin.basis.dao.BlogUserDao.updateBlogUser", blogUser);
  	}
  
  	public BlogUser getBlogUserByWhere(String where){
    	return (BlogUser) getSqlSession().selectOne("com.hujianbin.basis.dao.BlogUserDao.getBlogUserByWhere", where);
  	}
  
  	public List<BlogUser> getBlogUserListByWhere(String where){
    	return getSqlSession().selectList("com.hujianbin.basis.dao.BlogUserDao.getBlogUserListByWhere", where);
  	}
  	
  	public List<BlogUser> getBlogUserListByWhere(String where,int offset,int limit){
  		return getSqlSession().selectList("com.hujianbin.basis.dao.BlogUserDao.getBlogUserListByWhere", where,new RowBounds(offset, limit));
  	}
  	
  	public List<BlogUser> getBlogUserListByCondition(BlogUserSearchBean condition){
    	return getSqlSession().selectList("com.hujianbin.basis.dao.BlogUserDao.getBlogUserListByCondition", condition,new RowBounds(condition.getStart(), condition.getCount()));
  	}
  
  	public List<BlogUser> getBlogUserListBySql(String sql){
    	return getSqlSession().selectList("com.hujianbin.basis.dao.BlogUserDao.getBlogUserByWhere", sql);
  	}
  
  	public int getBlogUserCountByWhere(String where){
    	return getSqlSession().selectOne("com.hujianbin.basis.dao.BlogUserDao.getBlogUserCountByWhere", where);
  	}
  	
  	public int getBlogUserCountByExample(BlogUser blogUser){
    	return getSqlSession().selectOne("com.hujianbin.basis.dao.BlogUserDao.getBlogUserCountByExample", blogUser);
  	}
  	
  	public int getBlogUserCountByCondition(BlogUserSearchBean condition){
    	return getSqlSession().selectOne("com.hujianbin.basis.dao.BlogUserDao.getBlogUserCountByCondition", condition);
  	}
  
  	public int updateBlogUserByWhere(String where){
    	return getSqlSession().update("com.hujianbin.basis.dao.BlogUserDao.updateBlogUserByWhere", where);
  	}
  
  	public int deleteBlogUserByWhere(String where){
   		return getSqlSession().delete("com.hujianbin.basis.dao.BlogUserDao.deleteBlogUserByWhere",where);
  	}
  	
  	public List<BatchResult> batchInsertBlogUser(List<BlogUser> list){
  		List<BatchResult> results=new ArrayList<BatchResult>();
  		SqlSession sqlSession=getBatchSqlSession();
  		for (int i=1;i<=list.size();i++) {
			sqlSession.insert("com.hujianbin.basis.dao.BlogUserDao.insertBlogUser", list.get(i-1));
			if(i%1000==0)
				results.addAll(sqlSession.flushStatements());
		}
		results.addAll(sqlSession.flushStatements());
		return results;
  	}
  	
  	public BlogUser getBlogUserByExample(BlogUser blogUser){
  		return getSqlSession().selectOne("com.hujianbin.basis.dao.BlogUserDao.getBlogUserByExample", blogUser);
  	}
  	
  	public List<BlogUser> getBlogUserListByExample(BlogUser blogUser){
  		return getSqlSession().selectList("com.hujianbin.basis.dao.BlogUserDao.getBlogUserByExample", blogUser);
  	}
  	
  	public int deleteBlogUserByExample(BlogUser blogUser){
  		return getSqlSession().delete("com.hujianbin.basis.dao.BlogUserDao.deleteBlogUserByExample",blogUser);
  	}
  	
  	public int deleteBlogUserByCondition(BlogUserSearchBean condition){
  		return getSqlSession().delete("com.hujianbin.basis.dao.BlogUserDao.deleteBlogUserByCondition",condition);
  	}
  	
  	public List<BatchResult> batchDeleteBlogUserByExample(List<BlogUser> list){
  		List<BatchResult> results=new ArrayList<BatchResult>();
  		SqlSession sqlSession=getBatchSqlSession();
  		for (int i=1;i<=list.size();i++) {
			sqlSession.delete("com.hujianbin.basis.dao.BlogUserDao.deleteBlogUserByExample", list.get(i-1));
			if(i%1000==0)
				results.addAll(sqlSession.flushStatements());
		}
		results.addAll(sqlSession.flushStatements());
		return results;
  	}
  	
  	public List<BlogUser> getBlogUserByCondition(BlogUserSearchBean condition){
    	return getSqlSession().selectList("com.hujianbin.basis.dao.BlogUserDao.getBlogUserByCondition", condition);
  	}
  	
  	public int updateBlogUser(BlogUserSearchBean condition){
  		return getSqlSession().update("com.hujianbin.basis.dao.BlogUserDao.updateBlogUserByCondition", condition);
  	}
  	
  	public Map<String,Object> getBlogUserColumnByCondition(BlogUserSearchBean condition){
  		return getSqlSession().selectOne("com.hujianbin.basis.dao.BlogUserDao.getBlogUserColumnByCondition", condition);
  	}
  	
  	public List<Map<String,Object>> getBlogUserColumnListByCondition(BlogUserSearchBean condition){
  		return getSqlSession().selectList("com.hujianbin.basis.dao.BlogUserDao.getBlogUserColumnByCondition", condition);
  	}
  	
  	public int updateBlogUserByExample(BlogUser blogUser){
  		return getSqlSession().update("com.hujianbin.basis.dao.BlogUserDao.updateBlogUserByExample", blogUser);
  	}
  	
  	public List<BatchResult> batchModifyBlogUserByExample(List<BlogUser> list){
  		List<BatchResult> results=new ArrayList<BatchResult>();
  		SqlSession sqlSession=getBatchSqlSession();
  		for (int i=1;i<=list.size();i++) {
			sqlSession.update("com.hujianbin.basis.dao.BlogUserDao.updateBlogUserByExample", list.get(i-1));
			if(i%1000==0)
				results.addAll(sqlSession.flushStatements());
		}
		results.addAll(sqlSession.flushStatements());
		return results;
  	}
}
