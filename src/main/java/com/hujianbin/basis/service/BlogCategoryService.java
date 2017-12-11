package com.hujianbin.basis.service;

import java.util.List;
import java.util.Map;
import com.hujianbin.basis.bean.BlogCategory;
import com.hujianbin.basis.search.BlogCategorySearchBean;
import com.hujianbin.common.util.PageModel;

public interface BlogCategoryService {

	/**
	 * 新增BlogCategory记录
	 * @param BlogCategory
	 */
	public void addBlogCategory(BlogCategory blogCategory);
	
	/**
	 * 批量新增BlogCategory记录
	 * @param List
	 */
	public void batchAddBlogCategory(List<BlogCategory> list);
	
	/**
	 * 按照实例查找BlogCategory记录,主要为根据主键查找
	 * @param blogCategory
	 * @return BlogCategory
	 */
	public BlogCategory getBlogCategoryByExample(BlogCategory blogCategory);
	
	/**
	 * 修改BlogCategory记录
	 * @param BlogCategory
	 */
	public void modifyBlogCategoryByExample(BlogCategory blogCategory);
	
	/**
	 * 根据BlogCategory实例删除记录
	 * @param BlogCategory
	 */
	public void removeBlogCategoryByExample(BlogCategory blogCategory);
	
	/**
	 * 根据条件删除记录
	 * @param BlogCategorySearchBean
	 */
	public void removeBlogCategoryByCondition(BlogCategorySearchBean condition);
	
	public void batchRemoveBlogCategoryByExample(List<BlogCategory> list);
	
	public void batchModifyBlogCategoryByExample(List<BlogCategory> list);
	
	public PageModel queryBlogCategoryByCondition(BlogCategorySearchBean condition);
	
	public PageModel queryBlogCategoryBySql(String sql,int offset,int limit);
	
	public List<BlogCategory> queryBlogCategoryListByWhere(String where);
	
	public List<BlogCategory> queryBlogCategoryListByExample(BlogCategory blogCategory);
	
	public List<BlogCategory> getBlogCategoryByCondition(BlogCategorySearchBean condition);
	
	public List<BlogCategory> queryBlogCategoryListByCondition(BlogCategorySearchBean condition);
	
	public void modifyBlogCategoryBySql(String sql);
	
	public void modifyBlogCategoryByCondition(BlogCategorySearchBean condition);
	
	public void removeBlogCategoryBySql(String sql);
	
	public int getBlogCategoryCountBySql(String sql);
	
	public int getBlogCategoryCountByExample(BlogCategory blogCategory);
	
	public int getBlogCategoryCountByCondition(BlogCategorySearchBean condition);
	
	public Map<String,Object> getBlogCategoryColumnByCondition(BlogCategorySearchBean condition);
	
	public void updateBlogCategoryByExample(BlogCategory blogCategory);
}
