package com.hujianbin.basis.search;

import java.util.*;

import com.hujianbin.common.util.SearchBean;

public class BlogSearchBean extends SearchBean{
	
	/** 原始属性文章ID，主键自增 主键**/
	private Long id;
	private Long noEqualsId;
	/** In文章ID，主键自增 主键**/
	private List<Long> inId;
	/** NotIn文章ID，主键自增 主键**/
	private List<Long> notInId;
	/** 原始属性作者ID **/
	private Integer userId;
	/** 等于作者ID **/
	private Integer equalsUserId;
	/** 是否为空作者ID **/
	private Boolean isNotNullUserId;
	/** In作者ID **/
	private List<Integer> inUserId;
	/** NotIn作者ID **/
	private List<Integer> notInUserId;
	/** 不等于作者ID **/
	private Integer noEqualsUserId;
	/** 大于作者ID **/
	private Integer greaterUserId;
	/** 大于等于作者ID **/
	private Integer greaterEqualsUserId;
	/** 小于作者ID **/
	private Integer lessUserId;
	/** 小于等于作者ID **/
	private Integer lessEqualsUserId;
	/** 原始属性 **/
	private Integer categoryId;
	/** 等于 **/
	private Integer equalsCategoryId;
	/** 是否为空 **/
	private Boolean isNotNullCategoryId;
	/** In **/
	private List<Integer> inCategoryId;
	/** NotIn **/
	private List<Integer> notInCategoryId;
	/** 不等于 **/
	private Integer noEqualsCategoryId;
	/** 大于 **/
	private Integer greaterCategoryId;
	/** 大于等于 **/
	private Integer greaterEqualsCategoryId;
	/** 小于 **/
	private Integer lessCategoryId;
	/** 小于等于 **/
	private Integer lessEqualsCategoryId;
	/** 原始属性标题 **/
	private String title;
	/** 等于标题 **/
	private String equalsTitle;
	/** 是否为空标题 **/
	private Boolean isNotNullTitle;
	/** In标题 **/
	private List<String> inTitle;
	/** NotIn标题 **/
	private List<String> notInTitle;
	/** 不等于标题 **/
	private String noEqualsTitle;
	/** 大于标题 **/
	private String greaterTitle;
	/** 大于等于标题 **/
	private String greaterEqualsTitle;
	/** 小于标题 **/
	private String lessTitle;
	/** 小于等于标题 **/
	private String lessEqualsTitle;
	/** Like标题 **/
	private String likeTitle;
	/** Like左匹配标题 **/
	private String leftLikeTitle;
	/** Like右匹配标题 **/
	private String rightLikeTitle;
	/** 原始属性摘要 **/
	private String summary;
	/** 等于摘要 **/
	private String equalsSummary;
	/** 是否为空摘要 **/
	private Boolean isNotNullSummary;
	/** In摘要 **/
	private List<String> inSummary;
	/** NotIn摘要 **/
	private List<String> notInSummary;
	/** 不等于摘要 **/
	private String noEqualsSummary;
	/** 大于摘要 **/
	private String greaterSummary;
	/** 大于等于摘要 **/
	private String greaterEqualsSummary;
	/** 小于摘要 **/
	private String lessSummary;
	/** 小于等于摘要 **/
	private String lessEqualsSummary;
	/** Like摘要 **/
	private String likeSummary;
	/** Like左匹配摘要 **/
	private String leftLikeSummary;
	/** Like右匹配摘要 **/
	private String rightLikeSummary;
	/** 原始属性标签 **/
	private String tag;
	/** 等于标签 **/
	private String equalsTag;
	/** 是否为空标签 **/
	private Boolean isNotNullTag;
	/** In标签 **/
	private List<String> inTag;
	/** NotIn标签 **/
	private List<String> notInTag;
	/** 不等于标签 **/
	private String noEqualsTag;
	/** 大于标签 **/
	private String greaterTag;
	/** 大于等于标签 **/
	private String greaterEqualsTag;
	/** 小于标签 **/
	private String lessTag;
	/** 小于等于标签 **/
	private String lessEqualsTag;
	/** Like标签 **/
	private String likeTag;
	/** Like左匹配标签 **/
	private String leftLikeTag;
	/** Like右匹配标签 **/
	private String rightLikeTag;
	/** 原始属性图片地址 **/
	private String img;
	/** 等于图片地址 **/
	private String equalsImg;
	/** 是否为空图片地址 **/
	private Boolean isNotNullImg;
	/** In图片地址 **/
	private List<String> inImg;
	/** NotIn图片地址 **/
	private List<String> notInImg;
	/** 不等于图片地址 **/
	private String noEqualsImg;
	/** 大于图片地址 **/
	private String greaterImg;
	/** 大于等于图片地址 **/
	private String greaterEqualsImg;
	/** 小于图片地址 **/
	private String lessImg;
	/** 小于等于图片地址 **/
	private String lessEqualsImg;
	/** Like图片地址 **/
	private String likeImg;
	/** Like左匹配图片地址 **/
	private String leftLikeImg;
	/** Like右匹配图片地址 **/
	private String rightLikeImg;
	/** 原始属性内容 **/
	private String content;
	/** 等于内容 **/
	private String equalsContent;
	/** 是否为空内容 **/
	private Boolean isNotNullContent;
	/** In内容 **/
	private List<String> inContent;
	/** NotIn内容 **/
	private List<String> notInContent;
	/** 不等于内容 **/
	private String noEqualsContent;
	/** 大于内容 **/
	private String greaterContent;
	/** 大于等于内容 **/
	private String greaterEqualsContent;
	/** 小于内容 **/
	private String lessContent;
	/** 小于等于内容 **/
	private String lessEqualsContent;
	/** Like内容 **/
	private String likeContent;
	/** Like左匹配内容 **/
	private String leftLikeContent;
	/** Like右匹配内容 **/
	private String rightLikeContent;
	/** 原始属性创建时间 **/
	private Date createTime;
	/** 等于创建时间 **/
	private Date equalsCreateTime;
	/** 是否为空创建时间 **/
	private Boolean isNotNullCreateTime;
	/** In创建时间 **/
	private List<Date> inCreateTime;
	/** NotIn创建时间 **/
	private List<Date> notInCreateTime;
	/** 不等于创建时间 **/
	private Date noEqualsCreateTime;
	/** 大于创建时间 **/
	private Date greaterCreateTime;
	/** 大于等于创建时间 **/
	private Date greaterEqualsCreateTime;
	/** 小于创建时间 **/
	private Date lessCreateTime;
	/** 小于等于创建时间 **/
	private Date lessEqualsCreateTime;
	/** 原始属性修改时间 **/
	private Date modifiedTime;
	/** 等于修改时间 **/
	private Date equalsModifiedTime;
	/** 是否为空修改时间 **/
	private Boolean isNotNullModifiedTime;
	/** In修改时间 **/
	private List<Date> inModifiedTime;
	/** NotIn修改时间 **/
	private List<Date> notInModifiedTime;
	/** 不等于修改时间 **/
	private Date noEqualsModifiedTime;
	/** 大于修改时间 **/
	private Date greaterModifiedTime;
	/** 大于等于修改时间 **/
	private Date greaterEqualsModifiedTime;
	/** 小于修改时间 **/
	private Date lessModifiedTime;
	/** 小于等于修改时间 **/
	private Date lessEqualsModifiedTime;
	/** 原始属性是否发布 **/
	private Integer isPublish;
	/** 等于是否发布 **/
	private Integer equalsIsPublish;
	/** 是否为空是否发布 **/
	private Boolean isNotNullIsPublish;
	/** In是否发布 **/
	private List<Integer> inIsPublish;
	/** NotIn是否发布 **/
	private List<Integer> notInIsPublish;
	/** 不等于是否发布 **/
	private Integer noEqualsIsPublish;
	/** 大于是否发布 **/
	private Integer greaterIsPublish;
	/** 大于等于是否发布 **/
	private Integer greaterEqualsIsPublish;
	/** 小于是否发布 **/
	private Integer lessIsPublish;
	/** 小于等于是否发布 **/
	private Integer lessEqualsIsPublish;
	/** 原始属性是否有效 **/
	private Integer status;
	/** 等于是否有效 **/
	private Integer equalsStatus;
	/** 是否为空是否有效 **/
	private Boolean isNotNullStatus;
	/** In是否有效 **/
	private List<Integer> inStatus;
	/** NotIn是否有效 **/
	private List<Integer> notInStatus;
	/** 不等于是否有效 **/
	private Integer noEqualsStatus;
	/** 大于是否有效 **/
	private Integer greaterStatus;
	/** 大于等于是否有效 **/
	private Integer greaterEqualsStatus;
	/** 小于是否有效 **/
	private Integer lessStatus;
	/** 小于等于是否有效 **/
	private Integer lessEqualsStatus;

	
  	public BlogSearchBean() {
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
  	
  	public void setId(Long id){
		this.id=id;
	}
	public Long getId(){
		return id;
	}
	public void setNoEqualsId(Long noEqualsId){
		this.noEqualsId=noEqualsId;
	}
	public Long getNoEqualsId(){
		return noEqualsId;
	}
	public void setInId(List<Long> inId){
		this.inId=inId;
	}
	public List<Long> getInId(){
		return inId;
	}
	public void setNotInId(List<Long> notInId){
		this.notInId=notInId;
	}
	public List<Long> getNotInId(){
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
	public void setCategoryId(Integer categoryId){
		this.categoryId=categoryId;
	}
	public Integer getCategoryId(){
		return categoryId;
	}
	public void setEqualsCategoryId(Integer equalsCategoryId){
		this.equalsCategoryId=equalsCategoryId;
	}
	public Integer getEqualsCategoryId(){
		return equalsCategoryId;
	}
	public void setIsNotNullCategoryId(Boolean isNotNullCategoryId){
		this.isNotNullCategoryId=isNotNullCategoryId;
	}
	public Boolean getIsNotNullCategoryId(){
		return isNotNullCategoryId;
	}
	public void setInCategoryId(List<Integer> inCategoryId){
		this.inCategoryId=inCategoryId;
	}
	public List<Integer> getInCategoryId(){
		return inCategoryId;
	}
	public void setNotInCategoryId(List<Integer> notInCategoryId){
		this.notInCategoryId=notInCategoryId;
	}
	public List<Integer> getNotInCategoryId(){
		return notInCategoryId;
	}
	public void setNoEqualsCategoryId(Integer noEqualsCategoryId){
		this.noEqualsCategoryId=noEqualsCategoryId;
	}
	public Integer getNoEqualsCategoryId(){
		return noEqualsCategoryId;
	}
	public void setGreaterCategoryId(Integer greaterCategoryId){
		this.greaterCategoryId=greaterCategoryId;
	}
	public Integer getGreaterCategoryId(){
		return greaterCategoryId;
	}
	public void setGreaterEqualsCategoryId(Integer greaterEqualsCategoryId){
		this.greaterEqualsCategoryId=greaterEqualsCategoryId;
	}
	public Integer getGreaterEqualsCategoryId(){
		return greaterEqualsCategoryId;
	}
	public void setLessCategoryId(Integer lessCategoryId){
		this.lessCategoryId=lessCategoryId;
	}
	public Integer getLessCategoryId(){
		return lessCategoryId;
	}
	public void setLessEqualsCategoryId(Integer lessEqualsCategoryId){
		this.lessEqualsCategoryId=lessEqualsCategoryId;
	}
	public Integer getLessEqualsCategoryId(){
		return lessEqualsCategoryId;
	}
	public void setTitle(String title){
		this.title=title;
	}
	public String getTitle(){
		return title;
	}
	public void setEqualsTitle(String equalsTitle){
		this.equalsTitle=equalsTitle;
	}
	public String getEqualsTitle(){
		return equalsTitle;
	}
	public void setIsNotNullTitle(Boolean isNotNullTitle){
		this.isNotNullTitle=isNotNullTitle;
	}
	public Boolean getIsNotNullTitle(){
		return isNotNullTitle;
	}
	public void setInTitle(List<String> inTitle){
		this.inTitle=inTitle;
	}
	public List<String> getInTitle(){
		return inTitle;
	}
	public void setNotInTitle(List<String> notInTitle){
		this.notInTitle=notInTitle;
	}
	public List<String> getNotInTitle(){
		return notInTitle;
	}
	public void setNoEqualsTitle(String noEqualsTitle){
		this.noEqualsTitle=noEqualsTitle;
	}
	public String getNoEqualsTitle(){
		return noEqualsTitle;
	}
	public void setGreaterTitle(String greaterTitle){
		this.greaterTitle=greaterTitle;
	}
	public String getGreaterTitle(){
		return greaterTitle;
	}
	public void setGreaterEqualsTitle(String greaterEqualsTitle){
		this.greaterEqualsTitle=greaterEqualsTitle;
	}
	public String getGreaterEqualsTitle(){
		return greaterEqualsTitle;
	}
	public void setLessTitle(String lessTitle){
		this.lessTitle=lessTitle;
	}
	public String getLessTitle(){
		return lessTitle;
	}
	public void setLessEqualsTitle(String lessEqualsTitle){
		this.lessEqualsTitle=lessEqualsTitle;
	}
	public String getLessEqualsTitle(){
		return lessEqualsTitle;
	}
	public void setLikeTitle(String likeTitle){
		this.likeTitle=likeTitle;
	}
	public String getLikeTitle(){
		return likeTitle;
	}
	public void setLeftLikeTitle(String leftLikeTitle){
		this.leftLikeTitle=likeTitle;
	}
	public String getLeftLikeTitle(){
		return leftLikeTitle;
	}
	public void setRightLikeTitle(String rightLikeTitle){
		this.rightLikeTitle=rightLikeTitle;
	}
	public String getRightLikeTitle(){
		return rightLikeTitle;
	}
	public void setSummary(String summary){
		this.summary=summary;
	}
	public String getSummary(){
		return summary;
	}
	public void setEqualsSummary(String equalsSummary){
		this.equalsSummary=equalsSummary;
	}
	public String getEqualsSummary(){
		return equalsSummary;
	}
	public void setIsNotNullSummary(Boolean isNotNullSummary){
		this.isNotNullSummary=isNotNullSummary;
	}
	public Boolean getIsNotNullSummary(){
		return isNotNullSummary;
	}
	public void setInSummary(List<String> inSummary){
		this.inSummary=inSummary;
	}
	public List<String> getInSummary(){
		return inSummary;
	}
	public void setNotInSummary(List<String> notInSummary){
		this.notInSummary=notInSummary;
	}
	public List<String> getNotInSummary(){
		return notInSummary;
	}
	public void setNoEqualsSummary(String noEqualsSummary){
		this.noEqualsSummary=noEqualsSummary;
	}
	public String getNoEqualsSummary(){
		return noEqualsSummary;
	}
	public void setGreaterSummary(String greaterSummary){
		this.greaterSummary=greaterSummary;
	}
	public String getGreaterSummary(){
		return greaterSummary;
	}
	public void setGreaterEqualsSummary(String greaterEqualsSummary){
		this.greaterEqualsSummary=greaterEqualsSummary;
	}
	public String getGreaterEqualsSummary(){
		return greaterEqualsSummary;
	}
	public void setLessSummary(String lessSummary){
		this.lessSummary=lessSummary;
	}
	public String getLessSummary(){
		return lessSummary;
	}
	public void setLessEqualsSummary(String lessEqualsSummary){
		this.lessEqualsSummary=lessEqualsSummary;
	}
	public String getLessEqualsSummary(){
		return lessEqualsSummary;
	}
	public void setLikeSummary(String likeSummary){
		this.likeSummary=likeSummary;
	}
	public String getLikeSummary(){
		return likeSummary;
	}
	public void setLeftLikeSummary(String leftLikeSummary){
		this.leftLikeSummary=likeSummary;
	}
	public String getLeftLikeSummary(){
		return leftLikeSummary;
	}
	public void setRightLikeSummary(String rightLikeSummary){
		this.rightLikeSummary=rightLikeSummary;
	}
	public String getRightLikeSummary(){
		return rightLikeSummary;
	}
	public void setTag(String tag){
		this.tag=tag;
	}
	public String getTag(){
		return tag;
	}
	public void setEqualsTag(String equalsTag){
		this.equalsTag=equalsTag;
	}
	public String getEqualsTag(){
		return equalsTag;
	}
	public void setIsNotNullTag(Boolean isNotNullTag){
		this.isNotNullTag=isNotNullTag;
	}
	public Boolean getIsNotNullTag(){
		return isNotNullTag;
	}
	public void setInTag(List<String> inTag){
		this.inTag=inTag;
	}
	public List<String> getInTag(){
		return inTag;
	}
	public void setNotInTag(List<String> notInTag){
		this.notInTag=notInTag;
	}
	public List<String> getNotInTag(){
		return notInTag;
	}
	public void setNoEqualsTag(String noEqualsTag){
		this.noEqualsTag=noEqualsTag;
	}
	public String getNoEqualsTag(){
		return noEqualsTag;
	}
	public void setGreaterTag(String greaterTag){
		this.greaterTag=greaterTag;
	}
	public String getGreaterTag(){
		return greaterTag;
	}
	public void setGreaterEqualsTag(String greaterEqualsTag){
		this.greaterEqualsTag=greaterEqualsTag;
	}
	public String getGreaterEqualsTag(){
		return greaterEqualsTag;
	}
	public void setLessTag(String lessTag){
		this.lessTag=lessTag;
	}
	public String getLessTag(){
		return lessTag;
	}
	public void setLessEqualsTag(String lessEqualsTag){
		this.lessEqualsTag=lessEqualsTag;
	}
	public String getLessEqualsTag(){
		return lessEqualsTag;
	}
	public void setLikeTag(String likeTag){
		this.likeTag=likeTag;
	}
	public String getLikeTag(){
		return likeTag;
	}
	public void setLeftLikeTag(String leftLikeTag){
		this.leftLikeTag=likeTag;
	}
	public String getLeftLikeTag(){
		return leftLikeTag;
	}
	public void setRightLikeTag(String rightLikeTag){
		this.rightLikeTag=rightLikeTag;
	}
	public String getRightLikeTag(){
		return rightLikeTag;
	}
	public void setImg(String img){
		this.img=img;
	}
	public String getImg(){
		return img;
	}
	public void setEqualsImg(String equalsImg){
		this.equalsImg=equalsImg;
	}
	public String getEqualsImg(){
		return equalsImg;
	}
	public void setIsNotNullImg(Boolean isNotNullImg){
		this.isNotNullImg=isNotNullImg;
	}
	public Boolean getIsNotNullImg(){
		return isNotNullImg;
	}
	public void setInImg(List<String> inImg){
		this.inImg=inImg;
	}
	public List<String> getInImg(){
		return inImg;
	}
	public void setNotInImg(List<String> notInImg){
		this.notInImg=notInImg;
	}
	public List<String> getNotInImg(){
		return notInImg;
	}
	public void setNoEqualsImg(String noEqualsImg){
		this.noEqualsImg=noEqualsImg;
	}
	public String getNoEqualsImg(){
		return noEqualsImg;
	}
	public void setGreaterImg(String greaterImg){
		this.greaterImg=greaterImg;
	}
	public String getGreaterImg(){
		return greaterImg;
	}
	public void setGreaterEqualsImg(String greaterEqualsImg){
		this.greaterEqualsImg=greaterEqualsImg;
	}
	public String getGreaterEqualsImg(){
		return greaterEqualsImg;
	}
	public void setLessImg(String lessImg){
		this.lessImg=lessImg;
	}
	public String getLessImg(){
		return lessImg;
	}
	public void setLessEqualsImg(String lessEqualsImg){
		this.lessEqualsImg=lessEqualsImg;
	}
	public String getLessEqualsImg(){
		return lessEqualsImg;
	}
	public void setLikeImg(String likeImg){
		this.likeImg=likeImg;
	}
	public String getLikeImg(){
		return likeImg;
	}
	public void setLeftLikeImg(String leftLikeImg){
		this.leftLikeImg=likeImg;
	}
	public String getLeftLikeImg(){
		return leftLikeImg;
	}
	public void setRightLikeImg(String rightLikeImg){
		this.rightLikeImg=rightLikeImg;
	}
	public String getRightLikeImg(){
		return rightLikeImg;
	}
	public void setContent(String content){
		this.content=content;
	}
	public String getContent(){
		return content;
	}
	public void setEqualsContent(String equalsContent){
		this.equalsContent=equalsContent;
	}
	public String getEqualsContent(){
		return equalsContent;
	}
	public void setIsNotNullContent(Boolean isNotNullContent){
		this.isNotNullContent=isNotNullContent;
	}
	public Boolean getIsNotNullContent(){
		return isNotNullContent;
	}
	public void setInContent(List<String> inContent){
		this.inContent=inContent;
	}
	public List<String> getInContent(){
		return inContent;
	}
	public void setNotInContent(List<String> notInContent){
		this.notInContent=notInContent;
	}
	public List<String> getNotInContent(){
		return notInContent;
	}
	public void setNoEqualsContent(String noEqualsContent){
		this.noEqualsContent=noEqualsContent;
	}
	public String getNoEqualsContent(){
		return noEqualsContent;
	}
	public void setGreaterContent(String greaterContent){
		this.greaterContent=greaterContent;
	}
	public String getGreaterContent(){
		return greaterContent;
	}
	public void setGreaterEqualsContent(String greaterEqualsContent){
		this.greaterEqualsContent=greaterEqualsContent;
	}
	public String getGreaterEqualsContent(){
		return greaterEqualsContent;
	}
	public void setLessContent(String lessContent){
		this.lessContent=lessContent;
	}
	public String getLessContent(){
		return lessContent;
	}
	public void setLessEqualsContent(String lessEqualsContent){
		this.lessEqualsContent=lessEqualsContent;
	}
	public String getLessEqualsContent(){
		return lessEqualsContent;
	}
	public void setLikeContent(String likeContent){
		this.likeContent=likeContent;
	}
	public String getLikeContent(){
		return likeContent;
	}
	public void setLeftLikeContent(String leftLikeContent){
		this.leftLikeContent=likeContent;
	}
	public String getLeftLikeContent(){
		return leftLikeContent;
	}
	public void setRightLikeContent(String rightLikeContent){
		this.rightLikeContent=rightLikeContent;
	}
	public String getRightLikeContent(){
		return rightLikeContent;
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
	public void setModifiedTime(Date modifiedTime){
		this.modifiedTime=modifiedTime;
	}
	public Date getModifiedTime(){
		return modifiedTime;
	}
	public void setEqualsModifiedTime(Date equalsModifiedTime){
		this.equalsModifiedTime=equalsModifiedTime;
	}
	public Date getEqualsModifiedTime(){
		return equalsModifiedTime;
	}
	public void setIsNotNullModifiedTime(Boolean isNotNullModifiedTime){
		this.isNotNullModifiedTime=isNotNullModifiedTime;
	}
	public Boolean getIsNotNullModifiedTime(){
		return isNotNullModifiedTime;
	}
	public void setInModifiedTime(List<Date> inModifiedTime){
		this.inModifiedTime=inModifiedTime;
	}
	public List<Date> getInModifiedTime(){
		return inModifiedTime;
	}
	public void setNotInModifiedTime(List<Date> notInModifiedTime){
		this.notInModifiedTime=notInModifiedTime;
	}
	public List<Date> getNotInModifiedTime(){
		return notInModifiedTime;
	}
	public void setNoEqualsModifiedTime(Date noEqualsModifiedTime){
		this.noEqualsModifiedTime=noEqualsModifiedTime;
	}
	public Date getNoEqualsModifiedTime(){
		return noEqualsModifiedTime;
	}
	public void setGreaterModifiedTime(Date greaterModifiedTime){
		this.greaterModifiedTime=greaterModifiedTime;
	}
	public Date getGreaterModifiedTime(){
		return greaterModifiedTime;
	}
	public void setGreaterEqualsModifiedTime(Date greaterEqualsModifiedTime){
		this.greaterEqualsModifiedTime=greaterEqualsModifiedTime;
	}
	public Date getGreaterEqualsModifiedTime(){
		return greaterEqualsModifiedTime;
	}
	public void setLessModifiedTime(Date lessModifiedTime){
		this.lessModifiedTime=lessModifiedTime;
	}
	public Date getLessModifiedTime(){
		return lessModifiedTime;
	}
	public void setLessEqualsModifiedTime(Date lessEqualsModifiedTime){
		this.lessEqualsModifiedTime=lessEqualsModifiedTime;
	}
	public Date getLessEqualsModifiedTime(){
		return lessEqualsModifiedTime;
	}
	public void setIsPublish(Integer isPublish){
		this.isPublish=isPublish;
	}
	public Integer getIsPublish(){
		return isPublish;
	}
	public void setEqualsIsPublish(Integer equalsIsPublish){
		this.equalsIsPublish=equalsIsPublish;
	}
	public Integer getEqualsIsPublish(){
		return equalsIsPublish;
	}
	public void setIsNotNullIsPublish(Boolean isNotNullIsPublish){
		this.isNotNullIsPublish=isNotNullIsPublish;
	}
	public Boolean getIsNotNullIsPublish(){
		return isNotNullIsPublish;
	}
	public void setInIsPublish(List<Integer> inIsPublish){
		this.inIsPublish=inIsPublish;
	}
	public List<Integer> getInIsPublish(){
		return inIsPublish;
	}
	public void setNotInIsPublish(List<Integer> notInIsPublish){
		this.notInIsPublish=notInIsPublish;
	}
	public List<Integer> getNotInIsPublish(){
		return notInIsPublish;
	}
	public void setNoEqualsIsPublish(Integer noEqualsIsPublish){
		this.noEqualsIsPublish=noEqualsIsPublish;
	}
	public Integer getNoEqualsIsPublish(){
		return noEqualsIsPublish;
	}
	public void setGreaterIsPublish(Integer greaterIsPublish){
		this.greaterIsPublish=greaterIsPublish;
	}
	public Integer getGreaterIsPublish(){
		return greaterIsPublish;
	}
	public void setGreaterEqualsIsPublish(Integer greaterEqualsIsPublish){
		this.greaterEqualsIsPublish=greaterEqualsIsPublish;
	}
	public Integer getGreaterEqualsIsPublish(){
		return greaterEqualsIsPublish;
	}
	public void setLessIsPublish(Integer lessIsPublish){
		this.lessIsPublish=lessIsPublish;
	}
	public Integer getLessIsPublish(){
		return lessIsPublish;
	}
	public void setLessEqualsIsPublish(Integer lessEqualsIsPublish){
		this.lessEqualsIsPublish=lessEqualsIsPublish;
	}
	public Integer getLessEqualsIsPublish(){
		return lessEqualsIsPublish;
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
