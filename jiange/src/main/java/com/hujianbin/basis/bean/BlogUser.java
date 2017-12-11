package com.hujianbin.basis.bean;

import java.io.Serializable;
import java.util.*;

/**
 * 用户表
 * @author hujianbin
 * @since 1.0
 *
 */
public class BlogUser implements Serializable{
  	public BlogUser() {
  	}
	/** 主键自增 主键**/
	private Integer id;
	/** 用户名 **/
	private String userName;
	public void setId(Integer id){
		this.id=id;
	}
	public Integer getId(){
		return id;
	}
	public void setUserName(String userName){
		this.userName=userName;
	}
	public String getUserName(){
		return userName;
	}
}
