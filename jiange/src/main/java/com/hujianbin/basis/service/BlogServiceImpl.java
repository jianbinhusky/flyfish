package com.hujianbin.basis.service;

import java.util.List;
import java.util.Map;

import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hujianbin.basis.bean.Blog;
import com.hujianbin.basis.dao.BlogDao;
import com.hujianbin.basis.search.BlogSearchBean;
import com.hujianbin.common.util.PageModel;

@Component(value="blogService")
@Service
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class BlogServiceImpl implements BlogService{

	@Autowired
	@Setter
	private BlogDao blogDao;
		
	public void addBlog(Blog blog){
		blogDao.insertBlog(blog);
	}
	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void batchAddBlog(List<Blog> list){
		blogDao.batchInsertBlog(list);
	}
	
	public Blog getBlogByExample(Blog blog){
		return blogDao.getBlogByExample(blog);
	}
	
	public void modifyBlogByExample(Blog blog){
		blogDao.updateBlogByExample(blog);
	}
	
	public void removeBlogByExample(Blog blog){
		blogDao.deleteBlogByExample(blog);
	}
	
	public void removeBlogByCondition(BlogSearchBean condition){
		blogDao.deleteBlogByCondition(condition);
	}
	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void batchRemoveBlogByExample(List<Blog> list){
		blogDao.batchDeleteBlogByExample(list);
	}
	
	public PageModel queryBlogBySql(String where,int offset,int limit){
		//condition.buildSql();//只用orderSql
		PageModel pm=new PageModel();
		pm.setOffset(offset);
		pm.setPageSize(limit);
		pm.setCount(blogDao.getBlogCountByWhere(where));
		pm.setData(blogDao.getBlogListByWhere(where,offset,limit));
		return pm;
	}
	
	public PageModel queryBlogByCondition(BlogSearchBean condition){
		PageModel pm=new PageModel();
		pm.setOffset(condition.getStart());
		pm.setPageSize(condition.getCount());
		pm.setCount(blogDao.getBlogCountByCondition(condition));
		pm.setData(blogDao.getBlogListByCondition(condition));
		return pm;
	}
	
	public List<Blog> queryBlogListByWhere(String where){
		return blogDao.getBlogListBySql(where);
	}
	
	public List<Blog> queryBlogListByExample(Blog blog){
		return blogDao.getBlogListByExample(blog);
	}
	
	public List<Blog> getBlogByCondition(BlogSearchBean condition){
		return blogDao.getBlogByCondition(condition);
	}
	
	public List<Blog> queryBlogListByCondition(BlogSearchBean condition){
		return blogDao.getBlogListByCondition(condition);
	}
	
	public void modifyBlogBySql(String sql){
		blogDao.updateBlogByWhere(sql);
	}
	
	public void modifyBlogByCondition(BlogSearchBean condition){
		blogDao.updateBlog(condition);
	}
	
	public void removeBlogBySql(String sql){
		blogDao.deleteBlogByWhere(sql);
	}
	
	public int getBlogCountBySql(String sql){
		return blogDao.getBlogCountByWhere(sql);
	}
	
	public int getBlogCountByExample(Blog blog){
		return blogDao.getBlogCountByExample(blog);
	}
	
	public int getBlogCountByCondition(BlogSearchBean condition){
		return blogDao.getBlogCountByCondition(condition);
	}
	
	public Map<String,Object> getBlogColumnByCondition(BlogSearchBean condition){
		return blogDao.getBlogColumnByCondition(condition);
	}
	
	public void updateBlogByExample(Blog blog){
		blogDao.updateBlogByExample(blog);
	}
	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void batchModifyBlogByExample(List<Blog> list){
		blogDao. batchModifyBlogByExample(list);
	}
}
