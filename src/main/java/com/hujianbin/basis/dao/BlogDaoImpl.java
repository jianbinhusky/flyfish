package com.hujianbin.basis.dao;

import org.apache.ibatis.executor.BatchResult;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupportExt;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.hujianbin.basis.search.BlogSearchBean;
import com.hujianbin.basis.bean.Blog;

/**
 * <p>Title: </p>
 *
 * <p>Description:Blog</p>
 *
 * <p>Copyright: Copyright (c) 2015</p>
 *
 * <p>Author: hujianbin</p>
 *
 * @author AutoCreate
 * @version 1.0
 */

@Component(value="blogDao")
public class BlogDaoImpl extends SqlSessionDaoSupportExt implements BlogDao {
	public BlogDaoImpl() {
		
    }

  	public int insertBlog(Blog blog){
    	return getSqlSession().insert("com.hujianbin.basis.dao.BlogDao.insertBlog", blog);
  	}

  	public int updateBlog(Blog blog){
    	return getSqlSession().update("com.hujianbin.basis.dao.BlogDao.updateBlog", blog);
  	}
  
  	public Blog getBlogByWhere(String where){
    	return (Blog) getSqlSession().selectOne("com.hujianbin.basis.dao.BlogDao.getBlogByWhere", where);
  	}
  
  	public List<Blog> getBlogListByWhere(String where){
    	return getSqlSession().selectList("com.hujianbin.basis.dao.BlogDao.getBlogListByWhere", where);
  	}
  	
  	public List<Blog> getBlogListByWhere(String where,int offset,int limit){
  		return getSqlSession().selectList("com.hujianbin.basis.dao.BlogDao.getBlogListByWhere", where,new RowBounds(offset, limit));
  	}
  	
  	public List<Blog> getBlogListByCondition(BlogSearchBean condition){
    	return getSqlSession().selectList("com.hujianbin.basis.dao.BlogDao.getBlogListByCondition", condition,new RowBounds(condition.getStart(), condition.getCount()));
  	}
  
  	public List<Blog> getBlogListBySql(String sql){
    	return getSqlSession().selectList("com.hujianbin.basis.dao.BlogDao.getBlogByWhere", sql);
  	}
  
  	public int getBlogCountByWhere(String where){
    	return getSqlSession().selectOne("com.hujianbin.basis.dao.BlogDao.getBlogCountByWhere", where);
  	}
  	
  	public int getBlogCountByExample(Blog blog){
    	return getSqlSession().selectOne("com.hujianbin.basis.dao.BlogDao.getBlogCountByExample", blog);
  	}
  	
  	public int getBlogCountByCondition(BlogSearchBean condition){
    	return getSqlSession().selectOne("com.hujianbin.basis.dao.BlogDao.getBlogCountByCondition", condition);
  	}
  
  	public int updateBlogByWhere(String where){
    	return getSqlSession().update("com.hujianbin.basis.dao.BlogDao.updateBlogByWhere", where);
  	}
  
  	public int deleteBlogByWhere(String where){
   		return getSqlSession().delete("com.hujianbin.basis.dao.BlogDao.deleteBlogByWhere",where);
  	}
  	
  	public List<BatchResult> batchInsertBlog(List<Blog> list){
  		List<BatchResult> results=new ArrayList<BatchResult>();
  		SqlSession sqlSession=getBatchSqlSession();
  		for (int i=1;i<=list.size();i++) {
			sqlSession.insert("com.hujianbin.basis.dao.BlogDao.insertBlog", list.get(i-1));
			if(i%1000==0)
				results.addAll(sqlSession.flushStatements());
		}
		results.addAll(sqlSession.flushStatements());
		return results;
  	}
  	
  	public Blog getBlogByExample(Blog blog){
  		return getSqlSession().selectOne("com.hujianbin.basis.dao.BlogDao.getBlogByExample", blog);
  	}
  	
  	public List<Blog> getBlogListByExample(Blog blog){
  		return getSqlSession().selectList("com.hujianbin.basis.dao.BlogDao.getBlogByExample", blog);
  	}
  	
  	public int deleteBlogByExample(Blog blog){
  		return getSqlSession().delete("com.hujianbin.basis.dao.BlogDao.deleteBlogByExample",blog);
  	}
  	
  	public int deleteBlogByCondition(BlogSearchBean condition){
  		return getSqlSession().delete("com.hujianbin.basis.dao.BlogDao.deleteBlogByCondition",condition);
  	}
  	
  	public List<BatchResult> batchDeleteBlogByExample(List<Blog> list){
  		List<BatchResult> results=new ArrayList<BatchResult>();
  		SqlSession sqlSession=getBatchSqlSession();
  		for (int i=1;i<=list.size();i++) {
			sqlSession.delete("com.hujianbin.basis.dao.BlogDao.deleteBlogByExample", list.get(i-1));
			if(i%1000==0)
				results.addAll(sqlSession.flushStatements());
		}
		results.addAll(sqlSession.flushStatements());
		return results;
  	}
  	
  	public List<Blog> getBlogByCondition(BlogSearchBean condition){
    	return getSqlSession().selectList("com.hujianbin.basis.dao.BlogDao.getBlogByCondition", condition);
  	}
  	
  	public int updateBlog(BlogSearchBean condition){
  		return getSqlSession().update("com.hujianbin.basis.dao.BlogDao.updateBlogByCondition", condition);
  	}
  	
  	public Map<String,Object> getBlogColumnByCondition(BlogSearchBean condition){
  		return getSqlSession().selectOne("com.hujianbin.basis.dao.BlogDao.getBlogColumnByCondition", condition);
  	}
  	
  	public List<Map<String,Object>> getBlogColumnListByCondition(BlogSearchBean condition){
  		return getSqlSession().selectList("com.hujianbin.basis.dao.BlogDao.getBlogColumnByCondition", condition);
  	}
  	
  	public int updateBlogByExample(Blog blog){
  		return getSqlSession().update("com.hujianbin.basis.dao.BlogDao.updateBlogByExample", blog);
  	}
  	
  	public List<BatchResult> batchModifyBlogByExample(List<Blog> list){
  		List<BatchResult> results=new ArrayList<BatchResult>();
  		SqlSession sqlSession=getBatchSqlSession();
  		for (int i=1;i<=list.size();i++) {
			sqlSession.update("com.hujianbin.basis.dao.BlogDao.updateBlogByExample", list.get(i-1));
			if(i%1000==0)
				results.addAll(sqlSession.flushStatements());
		}
		results.addAll(sqlSession.flushStatements());
		return results;
  	}
}
