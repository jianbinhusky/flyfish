package com.hujianbin.basis.search;

import java.util.Date;
import java.util.List;

import com.hujianbin.common.util.SearchBean;

public class BeautyGirlSearchBean extends SearchBean{
	
	/** 原始属性主键自增 主键**/
	private Integer id;
	/** 原始属性名字 **/
	private String girlName;
	/** 等于名字 **/
	private String equalsGirlName;
	/** 是否为空名字 **/
	private Boolean isNotNullGirlName;
	/** In名字 **/
	private List<String> inGirlName;
	/** NotIn名字 **/
	private List<String> notInGirlName;
	/** 不等于名字 **/
	private String noEqualsGirlName;
	/** 大于名字 **/
	private String greaterGirlName;
	/** 大于等于名字 **/
	private String greaterEqualsGirlName;
	/** 小于名字 **/
	private String lessGirlName;
	/** 小于等于名字 **/
	private String lessEqualsGirlName;
	/** Like名字 **/
	private String likeGirlName;
	/** Like左匹配名字 **/
	private String leftLikeGirlName;
	/** Like右匹配名字 **/
	private String rightLikeGirlName;
	/** 原始属性类型 **/
	private Integer girlType;
	/** 等于类型 **/
	private Integer equalsGirlType;
	/** 是否为空类型 **/
	private Boolean isNotNullGirlType;
	/** In类型 **/
	private List<Integer> inGirlType;
	/** NotIn类型 **/
	private List<Integer> notInGirlType;
	/** 不等于类型 **/
	private Integer noEqualsGirlType;
	/** 大于类型 **/
	private Integer greaterGirlType;
	/** 大于等于类型 **/
	private Integer greaterEqualsGirlType;
	/** 小于类型 **/
	private Integer lessGirlType;
	/** 小于等于类型 **/
	private Integer lessEqualsGirlType;
	/** 原始属性图片地址 **/
	private String imageUrl;
	/** 等于图片地址 **/
	private String equalsImageUrl;
	/** 是否为空图片地址 **/
	private Boolean isNotNullImageUrl;
	/** In图片地址 **/
	private List<String> inImageUrl;
	/** NotIn图片地址 **/
	private List<String> notInImageUrl;
	/** 不等于图片地址 **/
	private String noEqualsImageUrl;
	/** 大于图片地址 **/
	private String greaterImageUrl;
	/** 大于等于图片地址 **/
	private String greaterEqualsImageUrl;
	/** 小于图片地址 **/
	private String lessImageUrl;
	/** 小于等于图片地址 **/
	private String lessEqualsImageUrl;
	/** Like图片地址 **/
	private String likeImageUrl;
	/** Like左匹配图片地址 **/
	private String leftLikeImageUrl;
	/** Like右匹配图片地址 **/
	private String rightLikeImageUrl;
	/** 原始属性时间戳 **/
	private Long timeStamp;
	/** 等于时间戳 **/
	private Long equalsTimeStamp;
	/** 是否为空时间戳 **/
	private Boolean isNotNullTimeStamp;
	/** In时间戳 **/
	private List<Long> inTimeStamp;
	/** NotIn时间戳 **/
	private List<Long> notInTimeStamp;
	/** 不等于时间戳 **/
	private Long noEqualsTimeStamp;
	/** 大于时间戳 **/
	private Long greaterTimeStamp;
	/** 大于等于时间戳 **/
	private Long greaterEqualsTimeStamp;
	/** 小于时间戳 **/
	private Long lessTimeStamp;
	/** 小于等于时间戳 **/
	private Long lessEqualsTimeStamp;
	/** 原始属性喜欢数 **/
	private Integer likeCount;
	/** 等于喜欢数 **/
	private Integer equalsLikeCount;
	/** 是否为空喜欢数 **/
	private Boolean isNotNullLikeCount;
	/** In喜欢数 **/
	private List<Integer> inLikeCount;
	/** NotIn喜欢数 **/
	private List<Integer> notInLikeCount;
	/** 不等于喜欢数 **/
	private Integer noEqualsLikeCount;
	/** 大于喜欢数 **/
	private Integer greaterLikeCount;
	/** 大于等于喜欢数 **/
	private Integer greaterEqualsLikeCount;
	/** 小于喜欢数 **/
	private Integer lessLikeCount;
	/** 小于等于喜欢数 **/
	private Integer lessEqualsLikeCount;
	/** 原始属性收藏数 **/
	private Integer collectCount;
	/** 等于收藏数 **/
	private Integer equalsCollectCount;
	/** 是否为空收藏数 **/
	private Boolean isNotNullCollectCount;
	/** In收藏数 **/
	private List<Integer> inCollectCount;
	/** NotIn收藏数 **/
	private List<Integer> notInCollectCount;
	/** 不等于收藏数 **/
	private Integer noEqualsCollectCount;
	/** 大于收藏数 **/
	private Integer greaterCollectCount;
	/** 大于等于收藏数 **/
	private Integer greaterEqualsCollectCount;
	/** 小于收藏数 **/
	private Integer lessCollectCount;
	/** 小于等于收藏数 **/
	private Integer lessEqualsCollectCount;
	/** 原始属性推荐指数 **/
	private Integer recommendLevel;
	/** 等于推荐指数 **/
	private Integer equalsRecommendLevel;
	/** 是否为空推荐指数 **/
	private Boolean isNotNullRecommendLevel;
	/** In推荐指数 **/
	private List<Integer> inRecommendLevel;
	/** NotIn推荐指数 **/
	private List<Integer> notInRecommendLevel;
	/** 不等于推荐指数 **/
	private Integer noEqualsRecommendLevel;
	/** 大于推荐指数 **/
	private Integer greaterRecommendLevel;
	/** 大于等于推荐指数 **/
	private Integer greaterEqualsRecommendLevel;
	/** 小于推荐指数 **/
	private Integer lessRecommendLevel;
	/** 小于等于推荐指数 **/
	private Integer lessEqualsRecommendLevel;
	/** 原始属性添加时间 **/
	private Date createTime;
	/** 等于添加时间 **/
	private Date equalsCreateTime;
	/** 是否为空添加时间 **/
	private Boolean isNotNullCreateTime;
	/** In添加时间 **/
	private List<Date> inCreateTime;
	/** NotIn添加时间 **/
	private List<Date> notInCreateTime;
	/** 不等于添加时间 **/
	private Date noEqualsCreateTime;
	/** 大于添加时间 **/
	private Date greaterCreateTime;
	/** 大于等于添加时间 **/
	private Date greaterEqualsCreateTime;
	/** 小于添加时间 **/
	private Date lessCreateTime;
	/** 小于等于添加时间 **/
	private Date lessEqualsCreateTime;

	
  	public BeautyGirlSearchBean() {
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
	public void setGirlName(String girlName){
		this.girlName=girlName;
	}
	public String getGirlName(){
		return girlName;
	}
	public void setEqualsGirlName(String equalsGirlName){
		this.equalsGirlName=equalsGirlName;
	}
	public String getEqualsGirlName(){
		return equalsGirlName;
	}
	public void setIsNotNullGirlName(Boolean isNotNullGirlName){
		this.isNotNullGirlName=isNotNullGirlName;
	}
	public Boolean getIsNotNullGirlName(){
		return isNotNullGirlName;
	}
	public void setInGirlName(List<String> inGirlName){
		this.inGirlName=inGirlName;
	}
	public List<String> getInGirlName(){
		return inGirlName;
	}
	public void setNotInGirlName(List<String> notInGirlName){
		this.notInGirlName=notInGirlName;
	}
	public List<String> getNotInGirlName(){
		return notInGirlName;
	}
	public void setNoEqualsGirlName(String noEqualsGirlName){
		this.noEqualsGirlName=noEqualsGirlName;
	}
	public String getNoEqualsGirlName(){
		return noEqualsGirlName;
	}
	public void setGreaterGirlName(String greaterGirlName){
		this.greaterGirlName=greaterGirlName;
	}
	public String getGreaterGirlName(){
		return greaterGirlName;
	}
	public void setGreaterEqualsGirlName(String greaterEqualsGirlName){
		this.greaterEqualsGirlName=greaterEqualsGirlName;
	}
	public String getGreaterEqualsGirlName(){
		return greaterEqualsGirlName;
	}
	public void setLessGirlName(String lessGirlName){
		this.lessGirlName=lessGirlName;
	}
	public String getLessGirlName(){
		return lessGirlName;
	}
	public void setLessEqualsGirlName(String lessEqualsGirlName){
		this.lessEqualsGirlName=lessEqualsGirlName;
	}
	public String getLessEqualsGirlName(){
		return lessEqualsGirlName;
	}
	public void setLikeGirlName(String likeGirlName){
		this.likeGirlName=likeGirlName;
	}
	public String getLikeGirlName(){
		return likeGirlName;
	}
	public void setLeftLikeGirlName(String leftLikeGirlName){
		this.leftLikeGirlName=likeGirlName;
	}
	public String getLeftLikeGirlName(){
		return leftLikeGirlName;
	}
	public void setRightLikeGirlName(String rightLikeGirlName){
		this.rightLikeGirlName=rightLikeGirlName;
	}
	public String getRightLikeGirlName(){
		return rightLikeGirlName;
	}
	public void setGirlType(Integer girlType){
		this.girlType=girlType;
	}
	public Integer getGirlType(){
		return girlType;
	}
	public void setEqualsGirlType(Integer equalsGirlType){
		this.equalsGirlType=equalsGirlType;
	}
	public Integer getEqualsGirlType(){
		return equalsGirlType;
	}
	public void setIsNotNullGirlType(Boolean isNotNullGirlType){
		this.isNotNullGirlType=isNotNullGirlType;
	}
	public Boolean getIsNotNullGirlType(){
		return isNotNullGirlType;
	}
	public void setInGirlType(List<Integer> inGirlType){
		this.inGirlType=inGirlType;
	}
	public List<Integer> getInGirlType(){
		return inGirlType;
	}
	public void setNotInGirlType(List<Integer> notInGirlType){
		this.notInGirlType=notInGirlType;
	}
	public List<Integer> getNotInGirlType(){
		return notInGirlType;
	}
	public void setNoEqualsGirlType(Integer noEqualsGirlType){
		this.noEqualsGirlType=noEqualsGirlType;
	}
	public Integer getNoEqualsGirlType(){
		return noEqualsGirlType;
	}
	public void setGreaterGirlType(Integer greaterGirlType){
		this.greaterGirlType=greaterGirlType;
	}
	public Integer getGreaterGirlType(){
		return greaterGirlType;
	}
	public void setGreaterEqualsGirlType(Integer greaterEqualsGirlType){
		this.greaterEqualsGirlType=greaterEqualsGirlType;
	}
	public Integer getGreaterEqualsGirlType(){
		return greaterEqualsGirlType;
	}
	public void setLessGirlType(Integer lessGirlType){
		this.lessGirlType=lessGirlType;
	}
	public Integer getLessGirlType(){
		return lessGirlType;
	}
	public void setLessEqualsGirlType(Integer lessEqualsGirlType){
		this.lessEqualsGirlType=lessEqualsGirlType;
	}
	public Integer getLessEqualsGirlType(){
		return lessEqualsGirlType;
	}
	public void setImageUrl(String imageUrl){
		this.imageUrl=imageUrl;
	}
	public String getImageUrl(){
		return imageUrl;
	}
	public void setEqualsImageUrl(String equalsImageUrl){
		this.equalsImageUrl=equalsImageUrl;
	}
	public String getEqualsImageUrl(){
		return equalsImageUrl;
	}
	public void setIsNotNullImageUrl(Boolean isNotNullImageUrl){
		this.isNotNullImageUrl=isNotNullImageUrl;
	}
	public Boolean getIsNotNullImageUrl(){
		return isNotNullImageUrl;
	}
	public void setInImageUrl(List<String> inImageUrl){
		this.inImageUrl=inImageUrl;
	}
	public List<String> getInImageUrl(){
		return inImageUrl;
	}
	public void setNotInImageUrl(List<String> notInImageUrl){
		this.notInImageUrl=notInImageUrl;
	}
	public List<String> getNotInImageUrl(){
		return notInImageUrl;
	}
	public void setNoEqualsImageUrl(String noEqualsImageUrl){
		this.noEqualsImageUrl=noEqualsImageUrl;
	}
	public String getNoEqualsImageUrl(){
		return noEqualsImageUrl;
	}
	public void setGreaterImageUrl(String greaterImageUrl){
		this.greaterImageUrl=greaterImageUrl;
	}
	public String getGreaterImageUrl(){
		return greaterImageUrl;
	}
	public void setGreaterEqualsImageUrl(String greaterEqualsImageUrl){
		this.greaterEqualsImageUrl=greaterEqualsImageUrl;
	}
	public String getGreaterEqualsImageUrl(){
		return greaterEqualsImageUrl;
	}
	public void setLessImageUrl(String lessImageUrl){
		this.lessImageUrl=lessImageUrl;
	}
	public String getLessImageUrl(){
		return lessImageUrl;
	}
	public void setLessEqualsImageUrl(String lessEqualsImageUrl){
		this.lessEqualsImageUrl=lessEqualsImageUrl;
	}
	public String getLessEqualsImageUrl(){
		return lessEqualsImageUrl;
	}
	public void setLikeImageUrl(String likeImageUrl){
		this.likeImageUrl=likeImageUrl;
	}
	public String getLikeImageUrl(){
		return likeImageUrl;
	}
	public void setLeftLikeImageUrl(String leftLikeImageUrl){
		this.leftLikeImageUrl=likeImageUrl;
	}
	public String getLeftLikeImageUrl(){
		return leftLikeImageUrl;
	}
	public void setRightLikeImageUrl(String rightLikeImageUrl){
		this.rightLikeImageUrl=rightLikeImageUrl;
	}
	public String getRightLikeImageUrl(){
		return rightLikeImageUrl;
	}
	public void setTimeStamp(Long timeStamp){
		this.timeStamp=timeStamp;
	}
	public Long getTimeStamp(){
		return timeStamp;
	}
	public void setEqualsTimeStamp(Long equalsTimeStamp){
		this.equalsTimeStamp=equalsTimeStamp;
	}
	public Long getEqualsTimeStamp(){
		return equalsTimeStamp;
	}
	public void setIsNotNullTimeStamp(Boolean isNotNullTimeStamp){
		this.isNotNullTimeStamp=isNotNullTimeStamp;
	}
	public Boolean getIsNotNullTimeStamp(){
		return isNotNullTimeStamp;
	}
	public void setInTimeStamp(List<Long> inTimeStamp){
		this.inTimeStamp=inTimeStamp;
	}
	public List<Long> getInTimeStamp(){
		return inTimeStamp;
	}
	public void setNotInTimeStamp(List<Long> notInTimeStamp){
		this.notInTimeStamp=notInTimeStamp;
	}
	public List<Long> getNotInTimeStamp(){
		return notInTimeStamp;
	}
	public void setNoEqualsTimeStamp(Long noEqualsTimeStamp){
		this.noEqualsTimeStamp=noEqualsTimeStamp;
	}
	public Long getNoEqualsTimeStamp(){
		return noEqualsTimeStamp;
	}
	public void setGreaterTimeStamp(Long greaterTimeStamp){
		this.greaterTimeStamp=greaterTimeStamp;
	}
	public Long getGreaterTimeStamp(){
		return greaterTimeStamp;
	}
	public void setGreaterEqualsTimeStamp(Long greaterEqualsTimeStamp){
		this.greaterEqualsTimeStamp=greaterEqualsTimeStamp;
	}
	public Long getGreaterEqualsTimeStamp(){
		return greaterEqualsTimeStamp;
	}
	public void setLessTimeStamp(Long lessTimeStamp){
		this.lessTimeStamp=lessTimeStamp;
	}
	public Long getLessTimeStamp(){
		return lessTimeStamp;
	}
	public void setLessEqualsTimeStamp(Long lessEqualsTimeStamp){
		this.lessEqualsTimeStamp=lessEqualsTimeStamp;
	}
	public Long getLessEqualsTimeStamp(){
		return lessEqualsTimeStamp;
	}
	public void setLikeCount(Integer likeCount){
		this.likeCount=likeCount;
	}
	public Integer getLikeCount(){
		return likeCount;
	}
	public void setEqualsLikeCount(Integer equalsLikeCount){
		this.equalsLikeCount=equalsLikeCount;
	}
	public Integer getEqualsLikeCount(){
		return equalsLikeCount;
	}
	public void setIsNotNullLikeCount(Boolean isNotNullLikeCount){
		this.isNotNullLikeCount=isNotNullLikeCount;
	}
	public Boolean getIsNotNullLikeCount(){
		return isNotNullLikeCount;
	}
	public void setInLikeCount(List<Integer> inLikeCount){
		this.inLikeCount=inLikeCount;
	}
	public List<Integer> getInLikeCount(){
		return inLikeCount;
	}
	public void setNotInLikeCount(List<Integer> notInLikeCount){
		this.notInLikeCount=notInLikeCount;
	}
	public List<Integer> getNotInLikeCount(){
		return notInLikeCount;
	}
	public void setNoEqualsLikeCount(Integer noEqualsLikeCount){
		this.noEqualsLikeCount=noEqualsLikeCount;
	}
	public Integer getNoEqualsLikeCount(){
		return noEqualsLikeCount;
	}
	public void setGreaterLikeCount(Integer greaterLikeCount){
		this.greaterLikeCount=greaterLikeCount;
	}
	public Integer getGreaterLikeCount(){
		return greaterLikeCount;
	}
	public void setGreaterEqualsLikeCount(Integer greaterEqualsLikeCount){
		this.greaterEqualsLikeCount=greaterEqualsLikeCount;
	}
	public Integer getGreaterEqualsLikeCount(){
		return greaterEqualsLikeCount;
	}
	public void setLessLikeCount(Integer lessLikeCount){
		this.lessLikeCount=lessLikeCount;
	}
	public Integer getLessLikeCount(){
		return lessLikeCount;
	}
	public void setLessEqualsLikeCount(Integer lessEqualsLikeCount){
		this.lessEqualsLikeCount=lessEqualsLikeCount;
	}
	public Integer getLessEqualsLikeCount(){
		return lessEqualsLikeCount;
	}
	public void setCollectCount(Integer collectCount){
		this.collectCount=collectCount;
	}
	public Integer getCollectCount(){
		return collectCount;
	}
	public void setEqualsCollectCount(Integer equalsCollectCount){
		this.equalsCollectCount=equalsCollectCount;
	}
	public Integer getEqualsCollectCount(){
		return equalsCollectCount;
	}
	public void setIsNotNullCollectCount(Boolean isNotNullCollectCount){
		this.isNotNullCollectCount=isNotNullCollectCount;
	}
	public Boolean getIsNotNullCollectCount(){
		return isNotNullCollectCount;
	}
	public void setInCollectCount(List<Integer> inCollectCount){
		this.inCollectCount=inCollectCount;
	}
	public List<Integer> getInCollectCount(){
		return inCollectCount;
	}
	public void setNotInCollectCount(List<Integer> notInCollectCount){
		this.notInCollectCount=notInCollectCount;
	}
	public List<Integer> getNotInCollectCount(){
		return notInCollectCount;
	}
	public void setNoEqualsCollectCount(Integer noEqualsCollectCount){
		this.noEqualsCollectCount=noEqualsCollectCount;
	}
	public Integer getNoEqualsCollectCount(){
		return noEqualsCollectCount;
	}
	public void setGreaterCollectCount(Integer greaterCollectCount){
		this.greaterCollectCount=greaterCollectCount;
	}
	public Integer getGreaterCollectCount(){
		return greaterCollectCount;
	}
	public void setGreaterEqualsCollectCount(Integer greaterEqualsCollectCount){
		this.greaterEqualsCollectCount=greaterEqualsCollectCount;
	}
	public Integer getGreaterEqualsCollectCount(){
		return greaterEqualsCollectCount;
	}
	public void setLessCollectCount(Integer lessCollectCount){
		this.lessCollectCount=lessCollectCount;
	}
	public Integer getLessCollectCount(){
		return lessCollectCount;
	}
	public void setLessEqualsCollectCount(Integer lessEqualsCollectCount){
		this.lessEqualsCollectCount=lessEqualsCollectCount;
	}
	public Integer getLessEqualsCollectCount(){
		return lessEqualsCollectCount;
	}
	public void setRecommendLevel(Integer recommendLevel){
		this.recommendLevel=recommendLevel;
	}
	public Integer getRecommendLevel(){
		return recommendLevel;
	}
	public void setEqualsRecommendLevel(Integer equalsRecommendLevel){
		this.equalsRecommendLevel=equalsRecommendLevel;
	}
	public Integer getEqualsRecommendLevel(){
		return equalsRecommendLevel;
	}
	public void setIsNotNullRecommendLevel(Boolean isNotNullRecommendLevel){
		this.isNotNullRecommendLevel=isNotNullRecommendLevel;
	}
	public Boolean getIsNotNullRecommendLevel(){
		return isNotNullRecommendLevel;
	}
	public void setInRecommendLevel(List<Integer> inRecommendLevel){
		this.inRecommendLevel=inRecommendLevel;
	}
	public List<Integer> getInRecommendLevel(){
		return inRecommendLevel;
	}
	public void setNotInRecommendLevel(List<Integer> notInRecommendLevel){
		this.notInRecommendLevel=notInRecommendLevel;
	}
	public List<Integer> getNotInRecommendLevel(){
		return notInRecommendLevel;
	}
	public void setNoEqualsRecommendLevel(Integer noEqualsRecommendLevel){
		this.noEqualsRecommendLevel=noEqualsRecommendLevel;
	}
	public Integer getNoEqualsRecommendLevel(){
		return noEqualsRecommendLevel;
	}
	public void setGreaterRecommendLevel(Integer greaterRecommendLevel){
		this.greaterRecommendLevel=greaterRecommendLevel;
	}
	public Integer getGreaterRecommendLevel(){
		return greaterRecommendLevel;
	}
	public void setGreaterEqualsRecommendLevel(Integer greaterEqualsRecommendLevel){
		this.greaterEqualsRecommendLevel=greaterEqualsRecommendLevel;
	}
	public Integer getGreaterEqualsRecommendLevel(){
		return greaterEqualsRecommendLevel;
	}
	public void setLessRecommendLevel(Integer lessRecommendLevel){
		this.lessRecommendLevel=lessRecommendLevel;
	}
	public Integer getLessRecommendLevel(){
		return lessRecommendLevel;
	}
	public void setLessEqualsRecommendLevel(Integer lessEqualsRecommendLevel){
		this.lessEqualsRecommendLevel=lessEqualsRecommendLevel;
	}
	public Integer getLessEqualsRecommendLevel(){
		return lessEqualsRecommendLevel;
	}
	public void setCreateTime(Date createTime){
		this.createTime=createTime;
	}
	public Date getCreateTime(){
		return createTime;
	}
	public void setEqualsCreateTime(Date equalsCreateTime){
		this.equalsCreateTime=equalsCreateTime;
	}
	public Date getEqualsCreateTime(){
		return equalsCreateTime;
	}
	public void setIsNotNullCreateTime(Boolean isNotNullCreateTime){
		this.isNotNullCreateTime=isNotNullCreateTime;
	}
	public Boolean getIsNotNullCreateTime(){
		return isNotNullCreateTime;
	}
	public void setInCreateTime(List<Date> inCreateTime){
		this.inCreateTime=inCreateTime;
	}
	public List<Date> getInCreateTime(){
		return inCreateTime;
	}
	public void setNotInCreateTime(List<Date> notInCreateTime){
		this.notInCreateTime=notInCreateTime;
	}
	public List<Date> getNotInCreateTime(){
		return notInCreateTime;
	}
	public void setNoEqualsCreateTime(Date noEqualsCreateTime){
		this.noEqualsCreateTime=noEqualsCreateTime;
	}
	public Date getNoEqualsCreateTime(){
		return noEqualsCreateTime;
	}
	public void setGreaterCreateTime(Date greaterCreateTime){
		this.greaterCreateTime=greaterCreateTime;
	}
	public Date getGreaterCreateTime(){
		return greaterCreateTime;
	}
	public void setGreaterEqualsCreateTime(Date greaterEqualsCreateTime){
		this.greaterEqualsCreateTime=greaterEqualsCreateTime;
	}
	public Date getGreaterEqualsCreateTime(){
		return greaterEqualsCreateTime;
	}
	public void setLessCreateTime(Date lessCreateTime){
		this.lessCreateTime=lessCreateTime;
	}
	public Date getLessCreateTime(){
		return lessCreateTime;
	}
	public void setLessEqualsCreateTime(Date lessEqualsCreateTime){
		this.lessEqualsCreateTime=lessEqualsCreateTime;
	}
	public Date getLessEqualsCreateTime(){
		return lessEqualsCreateTime;
	}

}
