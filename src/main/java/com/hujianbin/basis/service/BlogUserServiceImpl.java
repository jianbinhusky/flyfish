package com.hujianbin.basis.service;

import java.util.List;
import java.util.Map;

import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hujianbin.basis.bean.BlogUser;
import com.hujianbin.basis.dao.BlogUserDao;
import com.hujianbin.basis.search.BlogUserSearchBean;
import com.hujianbin.common.util.PageModel;

@Component(value="blogUserService")
@Service
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class BlogUserServiceImpl implements BlogUserService{

	@Autowired
	@Setter
	private BlogUserDao blogUserDao;
		
	public void addBlogUser(BlogUser blogUser){
		blogUserDao.insertBlogUser(blogUser);
	}
	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void batchAddBlogUser(List<BlogUser> list){
		blogUserDao.batchInsertBlogUser(list);
	}
	
	public BlogUser getBlogUserByExample(BlogUser blogUser){
		return blogUserDao.getBlogUserByExample(blogUser);
	}
	
	public void modifyBlogUserByExample(BlogUser blogUser){
		blogUserDao.updateBlogUserByExample(blogUser);
	}
	
	public void removeBlogUserByExample(BlogUser blogUser){
		blogUserDao.deleteBlogUserByExample(blogUser);
	}
	
	public void removeBlogUserByCondition(BlogUserSearchBean condition){
		blogUserDao.deleteBlogUserByCondition(condition);
	}
	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void batchRemoveBlogUserByExample(List<BlogUser> list){
		blogUserDao.batchDeleteBlogUserByExample(list);
	}
	
	public PageModel queryBlogUserBySql(String where,int offset,int limit){
		//condition.buildSql();//只用orderSql
		PageModel pm=new PageModel();
		pm.setOffset(offset);
		pm.setPageSize(limit);
		pm.setCount(blogUserDao.getBlogUserCountByWhere(where));
		pm.setData(blogUserDao.getBlogUserListByWhere(where,offset,limit));
		return pm;
	}
	
	public PageModel queryBlogUserByCondition(BlogUserSearchBean condition){
		PageModel pm=new PageModel();
		pm.setOffset(condition.getStart());
		pm.setPageSize(condition.getCount());
		pm.setCount(blogUserDao.getBlogUserCountByCondition(condition));
		pm.setData(blogUserDao.getBlogUserListByCondition(condition));
		return pm;
	}
	
	public List<BlogUser> queryBlogUserListByWhere(String where){
		return blogUserDao.getBlogUserListBySql(where);
	}
	
	public List<BlogUser> queryBlogUserListByExample(BlogUser blogUser){
		return blogUserDao.getBlogUserListByExample(blogUser);
	}
	
	public List<BlogUser> getBlogUserByCondition(BlogUserSearchBean condition){
		return blogUserDao.getBlogUserByCondition(condition);
	}
	
	public List<BlogUser> queryBlogUserListByCondition(BlogUserSearchBean condition){
		return blogUserDao.getBlogUserListByCondition(condition);
	}
	
	public void modifyBlogUserBySql(String sql){
		blogUserDao.updateBlogUserByWhere(sql);
	}
	
	public void modifyBlogUserByCondition(BlogUserSearchBean condition){
		blogUserDao.updateBlogUser(condition);
	}
	
	public void removeBlogUserBySql(String sql){
		blogUserDao.deleteBlogUserByWhere(sql);
	}
	
	public int getBlogUserCountBySql(String sql){
		return blogUserDao.getBlogUserCountByWhere(sql);
	}
	
	public int getBlogUserCountByExample(BlogUser blogUser){
		return blogUserDao.getBlogUserCountByExample(blogUser);
	}
	
	public int getBlogUserCountByCondition(BlogUserSearchBean condition){
		return blogUserDao.getBlogUserCountByCondition(condition);
	}
	
	public Map<String,Object> getBlogUserColumnByCondition(BlogUserSearchBean condition){
		return blogUserDao.getBlogUserColumnByCondition(condition);
	}
	
	public void updateBlogUserByExample(BlogUser blogUser){
		blogUserDao.updateBlogUserByExample(blogUser);
	}
	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void batchModifyBlogUserByExample(List<BlogUser> list){
		blogUserDao. batchModifyBlogUserByExample(list);
	}
}
