package com.hujianbin.basis.bean;

import java.io.Serializable;
import java.util.*;

/**
 * 博客表
 * @author hujianbin
 * @since 1.0
 *
 */
public class Blog implements Serializable{
  	public Blog() {
  	}
	/** 文章ID，主键自增 主键**/
	private Long id;
	/** 作者ID **/
	private Integer userId;
	/**  **/
	private Integer categoryId;
	/** 标题 **/
	private String title;
	/** 摘要 **/
	private String summary;
	/** 标签 **/
	private String tag;
	/** 图片地址 **/
	private String img;
	/** 内容 **/
	private String content;
	/** 创建时间 **/
	private Date createTime;
	/** 修改时间 **/
	private Date modifiedTime;
	/** 是否发布 **/
	private Integer isPublish;
	/** 是否有效 **/
	private Integer status;
	public void setId(Long id){
		this.id=id;
	}
	public Long getId(){
		return id;
	}
	public void setUserId(Integer userId){
		this.userId=userId;
	}
	public Integer getUserId(){
		return userId;
	}
	public void setCategoryId(Integer categoryId){
		this.categoryId=categoryId;
	}
	public Integer getCategoryId(){
		return categoryId;
	}
	public void setTitle(String title){
		this.title=title;
	}
	public String getTitle(){
		return title;
	}
	public void setSummary(String summary){
		this.summary=summary;
	}
	public String getSummary(){
		return summary;
	}
	public void setTag(String tag){
		this.tag=tag;
	}
	public String getTag(){
		return tag;
	}
	public void setImg(String img){
		this.img=img;
	}
	public String getImg(){
		return img;
	}
	public void setContent(String content){
		this.content=content;
	}
	public String getContent(){
		return content;
	}
	public void setCreateTime(Date createTime){
		this.createTime=createTime;
	}
	public Date getCreateTime(){
		return createTime;
	}
	public void setModifiedTime(Date modifiedTime){
		this.modifiedTime=modifiedTime;
	}
	public Date getModifiedTime(){
		return modifiedTime;
	}
	public void setIsPublish(Integer isPublish){
		this.isPublish=isPublish;
	}
	public Integer getIsPublish(){
		return isPublish;
	}
	public void setStatus(Integer status){
		this.status=status;
	}
	public Integer getStatus(){
		return status;
	}
}
