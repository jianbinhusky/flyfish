package com.hujianbin.basis.dao;

import org.apache.ibatis.executor.BatchResult;

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

public interface BlogDao {

	public int insertBlog(Blog blog);

  	public int updateBlog(Blog blog);

  	public Blog getBlogByWhere(String where);
  
  	public List<Blog> getBlogListByWhere(String where,int offset,int limit);
  	
  	public List<Blog> getBlogListByCondition(BlogSearchBean condition);
  
  	public List<Blog> getBlogListBySql(String sql);
  
  	public int getBlogCountByWhere(String where);
  	
  	public int getBlogCountByExample(Blog blog);
  	
  	public int getBlogCountByCondition(BlogSearchBean condition);
  
  	public int updateBlogByWhere(String where);
  
  	public int deleteBlogByWhere(String where);
  	
  	public List<BatchResult> batchInsertBlog(List<Blog> list);
  	
  	public Blog getBlogByExample(Blog blog);
  	
  	public List<Blog> getBlogListByExample(Blog blog);
  	
  	public int deleteBlogByExample(Blog blog);
  	
  	public int deleteBlogByCondition(BlogSearchBean condition);
  	
  	public List<BatchResult> batchDeleteBlogByExample(List<Blog> list);
  	
  	public List<Blog> getBlogByCondition(BlogSearchBean condition);
  	
  	public int updateBlog(BlogSearchBean condition);
  	
  	public Map<String,Object> getBlogColumnByCondition(BlogSearchBean condition);
  	
  	public List<Map<String,Object>> getBlogColumnListByCondition(BlogSearchBean condition);
  	
  	public int updateBlogByExample(Blog blog);
  	
  	public List<BatchResult> batchModifyBlogByExample(List<Blog> list);
}
