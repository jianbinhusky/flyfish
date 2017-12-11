package com.hujianbin.basis.dao;

import org.apache.ibatis.executor.BatchResult;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupportExt;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.hujianbin.basis.search.BlogCategorySearchBean;
import com.hujianbin.basis.bean.BlogCategory;

/**
 * <p>Title: </p>
 *
 * <p>Description:BlogCategory</p>
 *
 * <p>Copyright: Copyright (c) 2015</p>
 *
 * <p>Author: hujianbin</p>
 *
 * @author AutoCreate
 * @version 1.0
 */

@Component(value="blogCategoryDao")
public class BlogCategoryDaoImpl extends SqlSessionDaoSupportExt implements BlogCategoryDao {
	public BlogCategoryDaoImpl() {
		
    }

  	public int insertBlogCategory(BlogCategory blogCategory){
    	return getSqlSession().insert("com.hujianbin.basis.dao.BlogCategoryDao.insertBlogCategory", blogCategory);
  	}

  	public int updateBlogCategory(BlogCategory blogCategory){
    	return getSqlSession().update("com.hujianbin.basis.dao.BlogCategoryDao.updateBlogCategory", blogCategory);
  	}
  
  	public BlogCategory getBlogCategoryByWhere(String where){
    	return (BlogCategory) getSqlSession().selectOne("com.hujianbin.basis.dao.BlogCategoryDao.getBlogCategoryByWhere", where);
  	}
  
  	public List<BlogCategory> getBlogCategoryListByWhere(String where){
    	return getSqlSession().selectList("com.hujianbin.basis.dao.BlogCategoryDao.getBlogCategoryListByWhere", where);
  	}
  	
  	public List<BlogCategory> getBlogCategoryListByWhere(String where,int offset,int limit){
  		return getSqlSession().selectList("com.hujianbin.basis.dao.BlogCategoryDao.getBlogCategoryListByWhere", where,new RowBounds(offset, limit));
  	}
  	
  	public List<BlogCategory> getBlogCategoryListByCondition(BlogCategorySearchBean condition){
    	return getSqlSession().selectList("com.hujianbin.basis.dao.BlogCategoryDao.getBlogCategoryListByCondition", condition,new RowBounds(condition.getStart(), condition.getCount()));
  	}
  
  	public List<BlogCategory> getBlogCategoryListBySql(String sql){
    	return getSqlSession().selectList("com.hujianbin.basis.dao.BlogCategoryDao.getBlogCategoryByWhere", sql);
  	}
  
  	public int getBlogCategoryCountByWhere(String where){
    	return getSqlSession().selectOne("com.hujianbin.basis.dao.BlogCategoryDao.getBlogCategoryCountByWhere", where);
  	}
  	
  	public int getBlogCategoryCountByExample(BlogCategory blogCategory){
    	return getSqlSession().selectOne("com.hujianbin.basis.dao.BlogCategoryDao.getBlogCategoryCountByExample", blogCategory);
  	}
  	
  	public int getBlogCategoryCountByCondition(BlogCategorySearchBean condition){
    	return getSqlSession().selectOne("com.hujianbin.basis.dao.BlogCategoryDao.getBlogCategoryCountByCondition", condition);
  	}
  
  	public int updateBlogCategoryByWhere(String where){
    	return getSqlSession().update("com.hujianbin.basis.dao.BlogCategoryDao.updateBlogCategoryByWhere", where);
  	}
  
  	public int deleteBlogCategoryByWhere(String where){
   		return getSqlSession().delete("com.hujianbin.basis.dao.BlogCategoryDao.deleteBlogCategoryByWhere",where);
  	}
  	
  	public List<BatchResult> batchInsertBlogCategory(List<BlogCategory> list){
  		List<BatchResult> results=new ArrayList<BatchResult>();
  		SqlSession sqlSession=getBatchSqlSession();
  		for (int i=1;i<=list.size();i++) {
			sqlSession.insert("com.hujianbin.basis.dao.BlogCategoryDao.insertBlogCategory", list.get(i-1));
			if(i%1000==0)
				results.addAll(sqlSession.flushStatements());
		}
		results.addAll(sqlSession.flushStatements());
		return results;
  	}
  	
  	public BlogCategory getBlogCategoryByExample(BlogCategory blogCategory){
  		return getSqlSession().selectOne("com.hujianbin.basis.dao.BlogCategoryDao.getBlogCategoryByExample", blogCategory);
  	}
  	
  	public List<BlogCategory> getBlogCategoryListByExample(BlogCategory blogCategory){
  		return getSqlSession().selectList("com.hujianbin.basis.dao.BlogCategoryDao.getBlogCategoryByExample", blogCategory);
  	}
  	
  	public int deleteBlogCategoryByExample(BlogCategory blogCategory){
  		return getSqlSession().delete("com.hujianbin.basis.dao.BlogCategoryDao.deleteBlogCategoryByExample",blogCategory);
  	}
  	
  	public int deleteBlogCategoryByCondition(BlogCategorySearchBean condition){
  		return getSqlSession().delete("com.hujianbin.basis.dao.BlogCategoryDao.deleteBlogCategoryByCondition",condition);
  	}
  	
  	public List<BatchResult> batchDeleteBlogCategoryByExample(List<BlogCategory> list){
  		List<BatchResult> results=new ArrayList<BatchResult>();
  		SqlSession sqlSession=getBatchSqlSession();
  		for (int i=1;i<=list.size();i++) {
			sqlSession.delete("com.hujianbin.basis.dao.BlogCategoryDao.deleteBlogCategoryByExample", list.get(i-1));
			if(i%1000==0)
				results.addAll(sqlSession.flushStatements());
		}
		results.addAll(sqlSession.flushStatements());
		return results;
  	}
  	
  	public List<BlogCategory> getBlogCategoryByCondition(BlogCategorySearchBean condition){
    	return getSqlSession().selectList("com.hujianbin.basis.dao.BlogCategoryDao.getBlogCategoryByCondition", condition);
  	}
  	
  	public int updateBlogCategory(BlogCategorySearchBean condition){
  		return getSqlSession().update("com.hujianbin.basis.dao.BlogCategoryDao.updateBlogCategoryByCondition", condition);
  	}
  	
  	public Map<String,Object> getBlogCategoryColumnByCondition(BlogCategorySearchBean condition){
  		return getSqlSession().selectOne("com.hujianbin.basis.dao.BlogCategoryDao.getBlogCategoryColumnByCondition", condition);
  	}
  	
  	public List<Map<String,Object>> getBlogCategoryColumnListByCondition(BlogCategorySearchBean condition){
  		return getSqlSession().selectList("com.hujianbin.basis.dao.BlogCategoryDao.getBlogCategoryColumnByCondition", condition);
  	}
  	
  	public int updateBlogCategoryByExample(BlogCategory blogCategory){
  		return getSqlSession().update("com.hujianbin.basis.dao.BlogCategoryDao.updateBlogCategoryByExample", blogCategory);
  	}
  	
  	public List<BatchResult> batchModifyBlogCategoryByExample(List<BlogCategory> list){
  		List<BatchResult> results=new ArrayList<BatchResult>();
  		SqlSession sqlSession=getBatchSqlSession();
  		for (int i=1;i<=list.size();i++) {
			sqlSession.update("com.hujianbin.basis.dao.BlogCategoryDao.updateBlogCategoryByExample", list.get(i-1));
			if(i%1000==0)
				results.addAll(sqlSession.flushStatements());
		}
		results.addAll(sqlSession.flushStatements());
		return results;
  	}
}
