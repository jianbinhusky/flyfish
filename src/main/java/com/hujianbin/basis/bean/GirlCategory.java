package com.hujianbin.basis.bean;

import java.io.Serializable;
import java.util.*;

/**
 * girl类型表
 * @author Guodang Zuo
 * @since 1.0
 *
 */
public class GirlCategory implements Serializable{
  	public GirlCategory() {
  	}
	/** 主键自增 主键**/
	private Integer id;
	/** 分类名称 **/
	private String categoryName;
	/** 父类Id **/
	private Integer parentId;
	/** 分类排序 **/
	private Integer orderNum;
	/** 状态，0无效，1有效 **/
	private Integer status;
	public void setId(Integer id){
		this.id=id;
	}
	public Integer getId(){
		return id;
	}
	public void setCategoryName(String categoryName){
		this.categoryName=categoryName;
	}
	public String getCategoryName(){
		return categoryName;
	}
	public void setParentId(Integer parentId){
		this.parentId=parentId;
	}
	public Integer getParentId(){
		return parentId;
	}
	public void setOrderNum(Integer orderNum){
		this.orderNum=orderNum;
	}
	public Integer getOrderNum(){
		return orderNum;
	}
	public void setStatus(Integer status){
		this.status=status;
	}
	public Integer getStatus(){
		return status;
	}
}
