package com.hujianbin.basis.search;

import java.util.List;

import com.hujianbin.common.util.SearchBean;

public class GirlCategorySearchBean extends SearchBean{
	
	/** 原始属性主键自增 主键**/
	private Integer id;
	/** 原始属性分类名称 **/
	private String categoryName;
	/** 等于分类名称 **/
	private String equalsCategoryName;
	/** 是否为空分类名称 **/
	private Boolean isNotNullCategoryName;
	/** In分类名称 **/
	private List<String> inCategoryName;
	/** NotIn分类名称 **/
	private List<String> notInCategoryName;
	/** 不等于分类名称 **/
	private String noEqualsCategoryName;
	/** 大于分类名称 **/
	private String greaterCategoryName;
	/** 大于等于分类名称 **/
	private String greaterEqualsCategoryName;
	/** 小于分类名称 **/
	private String lessCategoryName;
	/** 小于等于分类名称 **/
	private String lessEqualsCategoryName;
	/** Like分类名称 **/
	private String likeCategoryName;
	/** Like左匹配分类名称 **/
	private String leftLikeCategoryName;
	/** Like右匹配分类名称 **/
	private String rightLikeCategoryName;
	/** 原始属性父类Id **/
	private Integer parentId;
	/** 等于父类Id **/
	private Integer equalsParentId;
	/** 是否为空父类Id **/
	private Boolean isNotNullParentId;
	/** In父类Id **/
	private List<Integer> inParentId;
	/** NotIn父类Id **/
	private List<Integer> notInParentId;
	/** 不等于父类Id **/
	private Integer noEqualsParentId;
	/** 大于父类Id **/
	private Integer greaterParentId;
	/** 大于等于父类Id **/
	private Integer greaterEqualsParentId;
	/** 小于父类Id **/
	private Integer lessParentId;
	/** 小于等于父类Id **/
	private Integer lessEqualsParentId;
	/** 原始属性分类排序 **/
	private Integer orderNum;
	/** 等于分类排序 **/
	private Integer equalsOrderNum;
	/** 是否为空分类排序 **/
	private Boolean isNotNullOrderNum;
	/** In分类排序 **/
	private List<Integer> inOrderNum;
	/** NotIn分类排序 **/
	private List<Integer> notInOrderNum;
	/** 不等于分类排序 **/
	private Integer noEqualsOrderNum;
	/** 大于分类排序 **/
	private Integer greaterOrderNum;
	/** 大于等于分类排序 **/
	private Integer greaterEqualsOrderNum;
	/** 小于分类排序 **/
	private Integer lessOrderNum;
	/** 小于等于分类排序 **/
	private Integer lessEqualsOrderNum;
	/** 原始属性状态，0无效，1有效 **/
	private Integer status;
	/** 等于状态，0无效，1有效 **/
	private Integer equalsStatus;
	/** 是否为空状态，0无效，1有效 **/
	private Boolean isNotNullStatus;
	/** In状态，0无效，1有效 **/
	private List<Integer> inStatus;
	/** NotIn状态，0无效，1有效 **/
	private List<Integer> notInStatus;
	/** 不等于状态，0无效，1有效 **/
	private Integer noEqualsStatus;
	/** 大于状态，0无效，1有效 **/
	private Integer greaterStatus;
	/** 大于等于状态，0无效，1有效 **/
	private Integer greaterEqualsStatus;
	/** 小于状态，0无效，1有效 **/
	private Integer lessStatus;
	/** 小于等于状态，0无效，1有效 **/
	private Integer lessEqualsStatus;

	
  	public GirlCategorySearchBean() {
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
	public void setParentId(Integer parentId){
		this.parentId=parentId;
	}
	public Integer getParentId(){
		return parentId;
	}
	public void setEqualsParentId(Integer equalsParentId){
		this.equalsParentId=equalsParentId;
	}
	public Integer getEqualsParentId(){
		return equalsParentId;
	}
	public void setIsNotNullParentId(Boolean isNotNullParentId){
		this.isNotNullParentId=isNotNullParentId;
	}
	public Boolean getIsNotNullParentId(){
		return isNotNullParentId;
	}
	public void setInParentId(List<Integer> inParentId){
		this.inParentId=inParentId;
	}
	public List<Integer> getInParentId(){
		return inParentId;
	}
	public void setNotInParentId(List<Integer> notInParentId){
		this.notInParentId=notInParentId;
	}
	public List<Integer> getNotInParentId(){
		return notInParentId;
	}
	public void setNoEqualsParentId(Integer noEqualsParentId){
		this.noEqualsParentId=noEqualsParentId;
	}
	public Integer getNoEqualsParentId(){
		return noEqualsParentId;
	}
	public void setGreaterParentId(Integer greaterParentId){
		this.greaterParentId=greaterParentId;
	}
	public Integer getGreaterParentId(){
		return greaterParentId;
	}
	public void setGreaterEqualsParentId(Integer greaterEqualsParentId){
		this.greaterEqualsParentId=greaterEqualsParentId;
	}
	public Integer getGreaterEqualsParentId(){
		return greaterEqualsParentId;
	}
	public void setLessParentId(Integer lessParentId){
		this.lessParentId=lessParentId;
	}
	public Integer getLessParentId(){
		return lessParentId;
	}
	public void setLessEqualsParentId(Integer lessEqualsParentId){
		this.lessEqualsParentId=lessEqualsParentId;
	}
	public Integer getLessEqualsParentId(){
		return lessEqualsParentId;
	}
	public void setOrderNum(Integer orderNum){
		this.orderNum=orderNum;
	}
	public Integer getOrderNum(){
		return orderNum;
	}
	public void setEqualsOrderNum(Integer equalsOrderNum){
		this.equalsOrderNum=equalsOrderNum;
	}
	public Integer getEqualsOrderNum(){
		return equalsOrderNum;
	}
	public void setIsNotNullOrderNum(Boolean isNotNullOrderNum){
		this.isNotNullOrderNum=isNotNullOrderNum;
	}
	public Boolean getIsNotNullOrderNum(){
		return isNotNullOrderNum;
	}
	public void setInOrderNum(List<Integer> inOrderNum){
		this.inOrderNum=inOrderNum;
	}
	public List<Integer> getInOrderNum(){
		return inOrderNum;
	}
	public void setNotInOrderNum(List<Integer> notInOrderNum){
		this.notInOrderNum=notInOrderNum;
	}
	public List<Integer> getNotInOrderNum(){
		return notInOrderNum;
	}
	public void setNoEqualsOrderNum(Integer noEqualsOrderNum){
		this.noEqualsOrderNum=noEqualsOrderNum;
	}
	public Integer getNoEqualsOrderNum(){
		return noEqualsOrderNum;
	}
	public void setGreaterOrderNum(Integer greaterOrderNum){
		this.greaterOrderNum=greaterOrderNum;
	}
	public Integer getGreaterOrderNum(){
		return greaterOrderNum;
	}
	public void setGreaterEqualsOrderNum(Integer greaterEqualsOrderNum){
		this.greaterEqualsOrderNum=greaterEqualsOrderNum;
	}
	public Integer getGreaterEqualsOrderNum(){
		return greaterEqualsOrderNum;
	}
	public void setLessOrderNum(Integer lessOrderNum){
		this.lessOrderNum=lessOrderNum;
	}
	public Integer getLessOrderNum(){
		return lessOrderNum;
	}
	public void setLessEqualsOrderNum(Integer lessEqualsOrderNum){
		this.lessEqualsOrderNum=lessEqualsOrderNum;
	}
	public Integer getLessEqualsOrderNum(){
		return lessEqualsOrderNum;
	}
	public void setStatus(Integer status){
		this.status=status;
	}
	public Integer getStatus(){
		return status;
	}
	public void setEqualsStatus(Integer equalsStatus){
		this.equalsStatus=equalsStatus;
	}
	public Integer getEqualsStatus(){
		return equalsStatus;
	}
	public void setIsNotNullStatus(Boolean isNotNullStatus){
		this.isNotNullStatus=isNotNullStatus;
	}
	public Boolean getIsNotNullStatus(){
		return isNotNullStatus;
	}
	public void setInStatus(List<Integer> inStatus){
		this.inStatus=inStatus;
	}
	public List<Integer> getInStatus(){
		return inStatus;
	}
	public void setNotInStatus(List<Integer> notInStatus){
		this.notInStatus=notInStatus;
	}
	public List<Integer> getNotInStatus(){
		return notInStatus;
	}
	public void setNoEqualsStatus(Integer noEqualsStatus){
		this.noEqualsStatus=noEqualsStatus;
	}
	public Integer getNoEqualsStatus(){
		return noEqualsStatus;
	}
	public void setGreaterStatus(Integer greaterStatus){
		this.greaterStatus=greaterStatus;
	}
	public Integer getGreaterStatus(){
		return greaterStatus;
	}
	public void setGreaterEqualsStatus(Integer greaterEqualsStatus){
		this.greaterEqualsStatus=greaterEqualsStatus;
	}
	public Integer getGreaterEqualsStatus(){
		return greaterEqualsStatus;
	}
	public void setLessStatus(Integer lessStatus){
		this.lessStatus=lessStatus;
	}
	public Integer getLessStatus(){
		return lessStatus;
	}
	public void setLessEqualsStatus(Integer lessEqualsStatus){
		this.lessEqualsStatus=lessEqualsStatus;
	}
	public Integer getLessEqualsStatus(){
		return lessEqualsStatus;
	}

}
