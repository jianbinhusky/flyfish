package com.hujianbin.basis.dao;

import org.apache.ibatis.executor.BatchResult;

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

public interface BlogCategoryDao {

	public int insertBlogCategory(BlogCategory blogCategory);

  	public int updateBlogCategory(BlogCategory blogCategory);

  	public BlogCategory getBlogCategoryByWhere(String where);
  
  	public List<BlogCategory> getBlogCategoryListByWhere(String where,int offset,int limit);
  	
  	public List<BlogCategory> getBlogCategoryListByCondition(BlogCategorySearchBean condition);
  
  	public List<BlogCategory> getBlogCategoryListBySql(String sql);
  
  	public int getBlogCategoryCountByWhere(String where);
  	
  	public int getBlogCategoryCountByExample(BlogCategory blogCategory);
  	
  	public int getBlogCategoryCountByCondition(BlogCategorySearchBean condition);
  
  	public int updateBlogCategoryByWhere(String where);
  
  	public int deleteBlogCategoryByWhere(String where);
  	
  	public List<BatchResult> batchInsertBlogCategory(List<BlogCategory> list);
  	
  	public BlogCategory getBlogCategoryByExample(BlogCategory blogCategory);
  	
  	public List<BlogCategory> getBlogCategoryListByExample(BlogCategory blogCategory);
  	
  	public int deleteBlogCategoryByExample(BlogCategory blogCategory);
  	
  	public int deleteBlogCategoryByCondition(BlogCategorySearchBean condition);
  	
  	public List<BatchResult> batchDeleteBlogCategoryByExample(List<BlogCategory> list);
  	
  	public List<BlogCategory> getBlogCategoryByCondition(BlogCategorySearchBean condition);
  	
  	public int updateBlogCategory(BlogCategorySearchBean condition);
  	
  	public Map<String,Object> getBlogCategoryColumnByCondition(BlogCategorySearchBean condition);
  	
  	public List<Map<String,Object>> getBlogCategoryColumnListByCondition(BlogCategorySearchBean condition);
  	
  	public int updateBlogCategoryByExample(BlogCategory blogCategory);
  	
  	public List<BatchResult> batchModifyBlogCategoryByExample(List<BlogCategory> list);
}
