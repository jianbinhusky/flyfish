package com.hujianbin.basis.service;

import java.util.List;
import java.util.Map;

import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hujianbin.basis.bean.BlogCategory;
import com.hujianbin.basis.dao.BlogCategoryDao;
import com.hujianbin.basis.search.BlogCategorySearchBean;
import com.hujianbin.common.util.PageModel;

@Component(value="blogCategoryService")
@Service
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class BlogCategoryServiceImpl implements BlogCategoryService{

	@Autowired
	@Setter
	private BlogCategoryDao blogCategoryDao;
		
	public void addBlogCategory(BlogCategory blogCategory){
		blogCategoryDao.insertBlogCategory(blogCategory);
	}
	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void batchAddBlogCategory(List<BlogCategory> list){
		blogCategoryDao.batchInsertBlogCategory(list);
	}
	
	public BlogCategory getBlogCategoryByExample(BlogCategory blogCategory){
		return blogCategoryDao.getBlogCategoryByExample(blogCategory);
	}
	
	public void modifyBlogCategoryByExample(BlogCategory blogCategory){
		blogCategoryDao.updateBlogCategoryByExample(blogCategory);
	}
	
	public void removeBlogCategoryByExample(BlogCategory blogCategory){
		blogCategoryDao.deleteBlogCategoryByExample(blogCategory);
	}
	
	public void removeBlogCategoryByCondition(BlogCategorySearchBean condition){
		blogCategoryDao.deleteBlogCategoryByCondition(condition);
	}
	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void batchRemoveBlogCategoryByExample(List<BlogCategory> list){
		blogCategoryDao.batchDeleteBlogCategoryByExample(list);
	}
	
	public PageModel queryBlogCategoryBySql(String where,int offset,int limit){
		//condition.buildSql();//只用orderSql
		PageModel pm=new PageModel();
		pm.setOffset(offset);
		pm.setPageSize(limit);
		pm.setCount(blogCategoryDao.getBlogCategoryCountByWhere(where));
		pm.setData(blogCategoryDao.getBlogCategoryListByWhere(where,offset,limit));
		return pm;
	}
	
	public PageModel queryBlogCategoryByCondition(BlogCategorySearchBean condition){
		PageModel pm=new PageModel();
		pm.setOffset(condition.getStart());
		pm.setPageSize(condition.getCount());
		pm.setCount(blogCategoryDao.getBlogCategoryCountByCondition(condition));
		pm.setData(blogCategoryDao.getBlogCategoryListByCondition(condition));
		return pm;
	}
	
	public List<BlogCategory> queryBlogCategoryListByWhere(String where){
		return blogCategoryDao.getBlogCategoryListBySql(where);
	}
	
	public List<BlogCategory> queryBlogCategoryListByExample(BlogCategory blogCategory){
		return blogCategoryDao.getBlogCategoryListByExample(blogCategory);
	}
	
	public List<BlogCategory> getBlogCategoryByCondition(BlogCategorySearchBean condition){
		return blogCategoryDao.getBlogCategoryByCondition(condition);
	}
	
	public List<BlogCategory> queryBlogCategoryListByCondition(BlogCategorySearchBean condition){
		return blogCategoryDao.getBlogCategoryListByCondition(condition);
	}
	
	public void modifyBlogCategoryBySql(String sql){
		blogCategoryDao.updateBlogCategoryByWhere(sql);
	}
	
	public void modifyBlogCategoryByCondition(BlogCategorySearchBean condition){
		blogCategoryDao.updateBlogCategory(condition);
	}
	
	public void removeBlogCategoryBySql(String sql){
		blogCategoryDao.deleteBlogCategoryByWhere(sql);
	}
	
	public int getBlogCategoryCountBySql(String sql){
		return blogCategoryDao.getBlogCategoryCountByWhere(sql);
	}
	
	public int getBlogCategoryCountByExample(BlogCategory blogCategory){
		return blogCategoryDao.getBlogCategoryCountByExample(blogCategory);
	}
	
	public int getBlogCategoryCountByCondition(BlogCategorySearchBean condition){
		return blogCategoryDao.getBlogCategoryCountByCondition(condition);
	}
	
	public Map<String,Object> getBlogCategoryColumnByCondition(BlogCategorySearchBean condition){
		return blogCategoryDao.getBlogCategoryColumnByCondition(condition);
	}
	
	public void updateBlogCategoryByExample(BlogCategory blogCategory){
		blogCategoryDao.updateBlogCategoryByExample(blogCategory);
	}
	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void batchModifyBlogCategoryByExample(List<BlogCategory> list){
		blogCategoryDao. batchModifyBlogCategoryByExample(list);
	}
}
