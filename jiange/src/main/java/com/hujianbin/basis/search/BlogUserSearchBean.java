package com.hujianbin.basis.search;

import java.util.*;

import com.hujianbin.common.util.SearchBean;

public class BlogUserSearchBean extends SearchBean{
	
	/** 原始属性主键自增 主键**/
	private Integer id;
	private Integer noEqualsId;
	/** In主键自增 主键**/
	private List<Integer> inId;
	/** NotIn主键自增 主键**/
	private List<Integer> notInId;
	/** 原始属性用户名 **/
	private String userName;
	/** 等于用户名 **/
	private String equalsUserName;
	/** 是否为空用户名 **/
	private Boolean isNotNullUserName;
	/** In用户名 **/
	private List<String> inUserName;
	/** NotIn用户名 **/
	private List<String> notInUserName;
	/** 不等于用户名 **/
	private String noEqualsUserName;
	/** 大于用户名 **/
	private String greaterUserName;
	/** 大于等于用户名 **/
	private String greaterEqualsUserName;
	/** 小于用户名 **/
	private String lessUserName;
	/** 小于等于用户名 **/
	private String lessEqualsUserName;
	/** Like用户名 **/
	private String likeUserName;
	/** Like左匹配用户名 **/
	private String leftLikeUserName;
	/** Like右匹配用户名 **/
	private String rightLikeUserName;

	
  	public BlogUserSearchBean() {
  	}
  	
  	public void buildSql(){
  		//注意手工拼接sql和动态拼接sql的不同
  		StringBuffer whereBuf=new StringBuffer("");
  		StringBuffer orderBuf=new StringBuffer();
  		//TODO 在此处增加查询条件
  		setCountSql(whereBuf.toString());
  		//TODO 在此处增加排序,为更好兼容各种数据库建议增加排序条件
  		setOrderSql(orderBuf.toString());
  		setSql(whereBuf.append(" ").append(orderBuf).toString());
  	}
  	
  	public void setId(Integer id){
		this.id=id;
	}
	public Integer getId(){
		return id;
	}
	public void setNoEqualsId(Integer noEqualsId){
		this.noEqualsId=noEqualsId;
	}
	public Integer getNoEqualsId(){
		return noEqualsId;
	}
	public void setInId(List<Integer> inId){
		this.inId=inId;
	}
	public List<Integer> getInId(){
		return inId;
	}
	public void setNotInId(List<Integer> notInId){
		this.notInId=notInId;
	}
	public List<Integer> getNotInId(){
		return notInId;
	}
	public void setUserName(String userName){
		this.userName=userName;
	}
	public String getUserName(){
		return userName;
	}
	public void setEqualsUserName(String equalsUserName){
		this.equalsUserName=equalsUserName;
	}
	public String getEqualsUserName(){
		return equalsUserName;
	}
	public void setIsNotNullUserName(Boolean isNotNullUserName){
		this.isNotNullUserName=isNotNullUserName;
	}
	public Boolean getIsNotNullUserName(){
		return isNotNullUserName;
	}
	public void setInUserName(List<String> inUserName){
		this.inUserName=inUserName;
	}
	public List<String> getInUserName(){
		return inUserName;
	}
	public void setNotInUserName(List<String> notInUserName){
		this.notInUserName=notInUserName;
	}
	public List<String> getNotInUserName(){
		return notInUserName;
	}
	public void setNoEqualsUserName(String noEqualsUserName){
		this.noEqualsUserName=noEqualsUserName;
	}
	public String getNoEqualsUserName(){
		return noEqualsUserName;
	}
	public void setGreaterUserName(String greaterUserName){
		this.greaterUserName=greaterUserName;
	}
	public String getGreaterUserName(){
		return greaterUserName;
	}
	public void setGreaterEqualsUserName(String greaterEqualsUserName){
		this.greaterEqualsUserName=greaterEqualsUserName;
	}
	public String getGreaterEqualsUserName(){
		return greaterEqualsUserName;
	}
	public void setLessUserName(String lessUserName){
		this.lessUserName=lessUserName;
	}
	public String getLessUserName(){
		return lessUserName;
	}
	public void setLessEqualsUserName(String lessEqualsUserName){
		this.lessEqualsUserName=lessEqualsUserName;
	}
	public String getLessEqualsUserName(){
		return lessEqualsUserName;
	}
	public void setLikeUserName(String likeUserName){
		this.likeUserName=likeUserName;
	}
	public String getLikeUserName(){
		return likeUserName;
	}
	public void setLeftLikeUserName(String leftLikeUserName){
		this.leftLikeUserName=likeUserName;
	}
	public String getLeftLikeUserName(){
		return leftLikeUserName;
	}
	public void setRightLikeUserName(String rightLikeUserName){
		this.rightLikeUserName=rightLikeUserName;
	}
	public String getRightLikeUserName(){
		return rightLikeUserName;
	}

}
