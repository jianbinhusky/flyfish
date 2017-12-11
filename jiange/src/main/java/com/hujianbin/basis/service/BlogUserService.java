package com.hujianbin.basis.service;

import java.util.List;
import java.util.Map;
import com.hujianbin.basis.bean.BlogUser;
import com.hujianbin.basis.search.BlogUserSearchBean;
import com.hujianbin.common.util.PageModel;

public interface BlogUserService {

	/**
	 * 新增BlogUser记录
	 * @param BlogUser
	 */
	public void addBlogUser(BlogUser blogUser);
	
	/**
	 * 批量新增BlogUser记录
	 * @param List
	 */
	public void batchAddBlogUser(List<BlogUser> list);
	
	/**
	 * 按照实例查找BlogUser记录,主要为根据主键查找
	 * @param blogUser
	 * @return BlogUser
	 */
	public BlogUser getBlogUserByExample(BlogUser blogUser);
	
	/**
	 * 修改BlogUser记录
	 * @param BlogUser
	 */
	public void modifyBlogUserByExample(BlogUser blogUser);
	
	/**
	 * 根据BlogUser实例删除记录
	 * @param BlogUser
	 */
	public void removeBlogUserByExample(BlogUser blogUser);
	
	/**
	 * 根据条件删除记录
	 * @param BlogUserSearchBean
	 */
	public void removeBlogUserByCondition(BlogUserSearchBean condition);
	
	public void batchRemoveBlogUserByExample(List<BlogUser> list);
	
	public void batchModifyBlogUserByExample(List<BlogUser> list);
	
	public PageModel queryBlogUserByCondition(BlogUserSearchBean condition);
	
	public PageModel queryBlogUserBySql(String sql,int offset,int limit);
	
	public List<BlogUser> queryBlogUserListByWhere(String where);
	
	public List<BlogUser> queryBlogUserListByExample(BlogUser blogUser);
	
	public List<BlogUser> getBlogUserByCondition(BlogUserSearchBean condition);
	
	public List<BlogUser> queryBlogUserListByCondition(BlogUserSearchBean condition);
	
	public void modifyBlogUserBySql(String sql);
	
	public void modifyBlogUserByCondition(BlogUserSearchBean condition);
	
	public void removeBlogUserBySql(String sql);
	
	public int getBlogUserCountBySql(String sql);
	
	public int getBlogUserCountByExample(BlogUser blogUser);
	
	public int getBlogUserCountByCondition(BlogUserSearchBean condition);
	
	public Map<String,Object> getBlogUserColumnByCondition(BlogUserSearchBean condition);
	
	public void updateBlogUserByExample(BlogUser blogUser);
}
