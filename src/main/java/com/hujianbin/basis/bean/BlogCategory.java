package com.hujianbin.basis.bean;

import java.io.Serializable;
import java.util.*;

/**
 * 博客分类
 * @author hujianbin
 * @since 1.0
 *
 */
public class BlogCategory implements Serializable{
  	public BlogCategory() {
  	}
	/** 主键自增 主键**/
	private Integer id;
	/** 用户id **/
	private Integer userId;
	/** 分类名 **/
	private String categoryName;
	public void setId(Integer id){
		this.id=id;
	}
	public Integer getId(){
		return id;
	}
	public void setUserId(Integer userId){
		this.userId=userId;
	}
	public Integer getUserId(){
		return userId;
	}
	public void setCategoryName(String categoryName){
		this.categoryName=categoryName;
	}
	public String getCategoryName(){
		return categoryName;
	}
}
