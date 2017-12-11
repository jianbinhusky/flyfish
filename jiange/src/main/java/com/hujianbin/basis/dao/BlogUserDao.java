package com.hujianbin.basis.dao;

import org.apache.ibatis.executor.BatchResult;

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

public interface BlogUserDao {

	public int insertBlogUser(BlogUser blogUser);

  	public int updateBlogUser(BlogUser blogUser);

  	public BlogUser getBlogUserByWhere(String where);
  
  	public List<BlogUser> getBlogUserListByWhere(String where,int offset,int limit);
  	
  	public List<BlogUser> getBlogUserListByCondition(BlogUserSearchBean condition);
  
  	public List<BlogUser> getBlogUserListBySql(String sql);
  
  	public int getBlogUserCountByWhere(String where);
  	
  	public int getBlogUserCountByExample(BlogUser blogUser);
  	
  	public int getBlogUserCountByCondition(BlogUserSearchBean condition);
  
  	public int updateBlogUserByWhere(String where);
  
  	public int deleteBlogUserByWhere(String where);
  	
  	public List<BatchResult> batchInsertBlogUser(List<BlogUser> list);
  	
  	public BlogUser getBlogUserByExample(BlogUser blogUser);
  	
  	public List<BlogUser> getBlogUserListByExample(BlogUser blogUser);
  	
  	public int deleteBlogUserByExample(BlogUser blogUser);
  	
  	public int deleteBlogUserByCondition(BlogUserSearchBean condition);
  	
  	public List<BatchResult> batchDeleteBlogUserByExample(List<BlogUser> list);
  	
  	public List<BlogUser> getBlogUserByCondition(BlogUserSearchBean condition);
  	
  	public int updateBlogUser(BlogUserSearchBean condition);
  	
  	public Map<String,Object> getBlogUserColumnByCondition(BlogUserSearchBean condition);
  	
  	public List<Map<String,Object>> getBlogUserColumnListByCondition(BlogUserSearchBean condition);
  	
  	public int updateBlogUserByExample(BlogUser blogUser);
  	
  	public List<BatchResult> batchModifyBlogUserByExample(List<BlogUser> list);
}
