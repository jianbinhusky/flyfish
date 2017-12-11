package com.hujianbin.basis.bean;

import java.io.Serializable;
import java.util.*;

/**
 * beauty girls
 * @author Guodang Zuo
 * @since 1.0
 *
 */
public class BeautyGirl implements Serializable{
  	public BeautyGirl() {
  	}
	/** 主键自增 主键**/
	private Integer id;
	/** 名字 **/
	private String girlName;
	/** 类型 **/
	private Integer girlType;
	/** 图片地址 **/
	private String imageUrl;
	/** 时间戳 **/
	private Long timeStamp;
	/** 喜欢数 **/
	private Integer likeCount;
	/** 收藏数 **/
	private Integer collectCount;
	/** 推荐指数 **/
	private Integer recommendLevel;
	/** 添加时间 **/
	private Date createTime;
	public void setId(Integer id){
		this.id=id;
	}
	public Integer getId(){
		return id;
	}
	public void setGirlName(String girlName){
		this.girlName=girlName;
	}
	public String getGirlName(){
		return girlName;
	}
	public void setGirlType(Integer girlType){
		this.girlType=girlType;
	}
	public Integer getGirlType(){
		return girlType;
	}
	public void setImageUrl(String imageUrl){
		this.imageUrl=imageUrl;
	}
	public String getImageUrl(){
		return imageUrl;
	}
	public void setTimeStamp(Long timeStamp){
		this.timeStamp=timeStamp;
	}
	public Long getTimeStamp(){
		return timeStamp;
	}
	public void setLikeCount(Integer likeCount){
		this.likeCount=likeCount;
	}
	public Integer getLikeCount(){
		return likeCount;
	}
	public void setCollectCount(Integer collectCount){
		this.collectCount=collectCount;
	}
	public Integer getCollectCount(){
		return collectCount;
	}
	public void setRecommendLevel(Integer recommendLevel){
		this.recommendLevel=recommendLevel;
	}
	public Integer getRecommendLevel(){
		return recommendLevel;
	}
	public void setCreateTime(Date createTime){
		this.createTime=createTime;
	}
	public Date getCreateTime(){
		return createTime;
	}
}
