package com.hujianbin.basis.search;

import java.util.*;

import com.hujianbin.common.util.SearchBean;

public class BlogCategorySearchBean extends SearchBean{
	
	/** 原始属性主键自增 主键**/
	private Integer id;
	private Integer noEqualsId;
	/** In主键自增 主键**/
	private List<Integer> inId;
	/** NotIn主键自增 主键**/
	private List<Integer> notInId;
	/** 原始属性用户id **/
	private Integer userId;
	/** 等于用户id **/
	private Integer equalsUserId;
	/** 是否为空用户id **/
	private Boolean isNotNullUserId;
	/** In用户id **/
	private List<Integer> inUserId;
	/** NotIn用户id **/
	private List<Integer> notInUserId;
	/** 不等于用户id **/
	private Integer noEqualsUserId;
	/** 大于用户id **/
	private Integer greaterUserId;
	/** 大于等于用户id **/
	private Integer greaterEqualsUserId;
	/** 小于用户id **/
	private Integer lessUserId;
	/** 小于等于用户id **/
	private Integer lessEqualsUserId;
	/** 原始属性分类名 **/
	private String categoryName;
	/** 等于分类名 **/
	private String equalsCategoryName;
	/** 是否为空分类名 **/
	private Boolean isNotNullCategoryName;
	/** In分类名 **/
	private List<String> inCategoryName;
	/** NotIn分类名 **/
	private List<String> notInCategoryName;
	/** 不等于分类名 **/
	private String noEqualsCategoryName;
	/** 大于分类名 **/
	private String greaterCategoryName;
	/** 大于等于分类名 **/
	private String greaterEqualsCategoryName;
	/** 小于分类名 **/
	private String lessCategoryName;
	/** 小于等于分类名 **/
	private String lessEqualsCategoryName;
	/** Like分类名 **/
	private String likeCategoryName;
	/** Like左匹配分类名 **/
	private String leftLikeCategoryName;
	/** Like右匹配分类名 **/
	private String rightLikeCategoryName;

	
  	public BlogCategorySearchBean() {
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
	public void setUserId(Integer userId){
		this.userId=userId;
	}
	public Integer getUserId(){
		return userId;
	}
	public void setEqualsUserId(Integer equalsUserId){
		this.equalsUserId=equalsUserId;
	}
	public Integer getEqualsUserId(){
		return equalsUserId;
	}
	public void setIsNotNullUserId(Boolean isNotNullUserId){
		this.isNotNullUserId=isNotNullUserId;
	}
	public Boolean getIsNotNullUserId(){
		return isNotNullUserId;
	}
	public void setInUserId(List<Integer> inUserId){
		this.inUserId=inUserId;
	}
	public List<Integer> getInUserId(){
		return inUserId;
	}
	public void setNotInUserId(List<Integer> notInUserId){
		this.notInUserId=notInUserId;
	}
	public List<Integer> getNotInUserId(){
		return notInUserId;
	}
	public void setNoEqualsUserId(Integer noEqualsUserId){
		this.noEqualsUserId=noEqualsUserId;
	}
	public Integer getNoEqualsUserId(){
		return noEqualsUserId;
	}
	public void setGreaterUserId(Integer greaterUserId){
		this.greaterUserId=greaterUserId;
	}
	public Integer getGreaterUserId(){
		return greaterUserId;
	}
	public void setGreaterEqualsUserId(Integer greaterEqualsUserId){
		this.greaterEqualsUserId=greaterEqualsUserId;
	}
	public Integer getGreaterEqualsUserId(){
		return greaterEqualsUserId;
	}
	public void setLessUserId(Integer lessUserId){
		this.lessUserId=lessUserId;
	}
	public Integer getLessUserId(){
		return lessUserId;
	}
	public void setLessEqualsUserId(Integer lessEqualsUserId){
		this.lessEqualsUserId=lessEqualsUserId;
	}
	public Integer getLessEqualsUserId(){
		return lessEqualsUserId;
	}
	public void setCategoryName(String categoryName){
		this.categoryName=categoryName;
	}
	public String getCategoryName(){
		return categoryName;
	}
	public void setEqualsCategoryName(String equalsCategoryName){
		this.equalsCategoryName=equalsCategoryName;
	}
	public String getEqualsCategoryName(){
		return equalsCategoryName;
	}
	public void setIsNotNullCategoryName(Boolean isNotNullCategoryName){
		this.isNotNullCategoryName=isNotNullCategoryName;
	}
	public Boolean getIsNotNullCategoryName(){
		return isNotNullCategoryName;
	}
	public void setInCategoryName(List<String> inCategoryName){
		this.inCategoryName=inCategoryName;
	}
	public List<String> getInCategoryName(){
		return inCategoryName;
	}
	public void setNotInCategoryName(List<String> notInCategoryName){
		this.notInCategoryName=notInCategoryName;
	}
	public List<String> getNotInCategoryName(){
		return notInCategoryName;
	}
	public void setNoEqualsCategoryName(String noEqualsCategoryName){
		this.noEqualsCategoryName=noEqualsCategoryName;
	}
	public String getNoEqualsCategoryName(){
		return noEqualsCategoryName;
	}
	public void setGreaterCategoryName(String greaterCategoryName){
		this.greaterCategoryName=greaterCategoryName;
	}
	public String getGreaterCategoryName(){
		return greaterCategoryName;
	}
	public void setGreaterEqualsCategoryName(String greaterEqualsCategoryName){
		this.greaterEqualsCategoryName=greaterEqualsCategoryName;
	}
	public String getGreaterEqualsCategoryName(){
		return greaterEqualsCategoryName;
	}
	public void setLessCategoryName(String lessCategoryName){
		this.lessCategoryName=lessCategoryName;
	}
	public String getLessCategoryName(){
		return lessCategoryName;
	}
	public void setLessEqualsCategoryName(String lessEqualsCategoryName){
		this.lessEqualsCategoryName=lessEqualsCategoryName;
	}
	public String getLessEqualsCategoryName(){
		return lessEqualsCategoryName;
	}
	public void setLikeCategoryName(String likeCategoryName){
		this.likeCategoryName=likeCategoryName;
	}
	public String getLikeCategoryName(){
		return likeCategoryName;
	}
	public void setLeftLikeCategoryName(String leftLikeCategoryName){
		this.leftLikeCategoryName=likeCategoryName;
	}
	public String getLeftLikeCategoryName(){
		return leftLikeCategoryName;
	}
	public void setRightLikeCategoryName(String rightLikeCategoryName){
		this.rightLikeCategoryName=rightLikeCategoryName;
	}
	public String getRightLikeCategoryName(){
		return rightLikeCategoryName;
	}

}
