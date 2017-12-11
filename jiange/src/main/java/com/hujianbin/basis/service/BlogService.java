package com.hujianbin.basis.service;

import java.util.List;
import java.util.Map;
import com.hujianbin.basis.bean.Blog;
import com.hujianbin.basis.search.BlogSearchBean;
import com.hujianbin.common.util.PageModel;

public interface BlogService {

	/**
	 * 新增Blog记录
	 * @param Blog
	 */
	public void addBlog(Blog blog);
	
	/**
	 * 批量新增Blog记录
	 * @param List
	 */
	public void batchAddBlog(List<Blog> list);
	
	/**
	 * 按照实例查找Blog记录,主要为根据主键查找
	 * @param blog
	 * @return Blog
	 */
	public Blog getBlogByExample(Blog blog);
	
	/**
	 * 修改Blog记录
	 * @param Blog
	 */
	public void modifyBlogByExample(Blog blog);
	
	/**
	 * 根据Blog实例删除记录
	 * @param Blog
	 */
	public void removeBlogByExample(Blog blog);
	
	/**
	 * 根据条件删除记录
	 * @param BlogSearchBean
	 */
	public void removeBlogByCondition(BlogSearchBean condition);
	
	public void batchRemoveBlogByExample(List<Blog> list);
	
	public void batchModifyBlogByExample(List<Blog> list);
	
	public PageModel queryBlogByCondition(BlogSearchBean condition);
	
	public PageModel queryBlogBySql(String sql,int offset,int limit);
	
	public List<Blog> queryBlogListByWhere(String where);
	
	public List<Blog> queryBlogListByExample(Blog blog);
	
	public List<Blog> getBlogByCondition(BlogSearchBean condition);
	
	public List<Blog> queryBlogListByCondition(BlogSearchBean condition);
	
	public void modifyBlogBySql(String sql);
	
	public void modifyBlogByCondition(BlogSearchBean condition);
	
	public void removeBlogBySql(String sql);
	
	public int getBlogCountBySql(String sql);
	
	public int getBlogCountByExample(Blog blog);
	
	public int getBlogCountByCondition(BlogSearchBean condition);
	
	public Map<String,Object> getBlogColumnByCondition(BlogSearchBean condition);
	
	public void updateBlogByExample(Blog blog);
}
