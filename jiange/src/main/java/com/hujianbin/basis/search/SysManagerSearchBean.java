package com.hujianbin.basis.search;

import java.util.*;

import com.hujianbin.common.util.SearchBean;

public class SysManagerSearchBean extends SearchBean{
	
	/** 原始属性 主键**/
	private Integer id;
	/** 原始属性用户名 **/
	private String managername;
	/** 等于用户名 **/
	private String equalsManagername;
	/** 是否为空用户名 **/
	private Boolean isNotNullManagername;
	/** In用户名 **/
	private List<String> inManagername;
	/** NotIn用户名 **/
	private List<String> notInManagername;
	/** 不等于用户名 **/
	private String noEqualsManagername;
	/** 大于用户名 **/
	private String greaterManagername;
	/** 大于等于用户名 **/
	private String greaterEqualsManagername;
	/** 小于用户名 **/
	private String lessManagername;
	/** 小于等于用户名 **/
	private String lessEqualsManagername;
	/** Like用户名 **/
	private String likeManagername;
	/** Like左匹配用户名 **/
	private String leftLikeManagername;
	/** Like右匹配用户名 **/
	private String rightLikeManagername;
	/** 原始属性密码的MD5摘要值 **/
	private String password;
	/** 等于密码的MD5摘要值 **/
	private String equalsPassword;
	/** 是否为空密码的MD5摘要值 **/
	private Boolean isNotNullPassword;
	/** In密码的MD5摘要值 **/
	private List<String> inPassword;
	/** NotIn密码的MD5摘要值 **/
	private List<String> notInPassword;
	/** 不等于密码的MD5摘要值 **/
	private String noEqualsPassword;
	/** 大于密码的MD5摘要值 **/
	private String greaterPassword;
	/** 大于等于密码的MD5摘要值 **/
	private String greaterEqualsPassword;
	/** 小于密码的MD5摘要值 **/
	private String lessPassword;
	/** 小于等于密码的MD5摘要值 **/
	private String lessEqualsPassword;
	/** Like密码的MD5摘要值 **/
	private String likePassword;
	/** Like左匹配密码的MD5摘要值 **/
	private String leftLikePassword;
	/** Like右匹配密码的MD5摘要值 **/
	private String rightLikePassword;
	/** 原始属性真实姓名 **/
	private String realname;
	/** 等于真实姓名 **/
	private String equalsRealname;
	/** 是否为空真实姓名 **/
	private Boolean isNotNullRealname;
	/** In真实姓名 **/
	private List<String> inRealname;
	/** NotIn真实姓名 **/
	private List<String> notInRealname;
	/** 不等于真实姓名 **/
	private String noEqualsRealname;
	/** 大于真实姓名 **/
	private String greaterRealname;
	/** 大于等于真实姓名 **/
	private String greaterEqualsRealname;
	/** 小于真实姓名 **/
	private String lessRealname;
	/** 小于等于真实姓名 **/
	private String lessEqualsRealname;
	/** Like真实姓名 **/
	private String likeRealname;
	/** Like左匹配真实姓名 **/
	private String leftLikeRealname;
	/** Like右匹配真实姓名 **/
	private String rightLikeRealname;
	/** 原始属性手机号码 **/
	private String phone;
	/** 等于手机号码 **/
	private String equalsPhone;
	/** 是否为空手机号码 **/
	private Boolean isNotNullPhone;
	/** In手机号码 **/
	private List<String> inPhone;
	/** NotIn手机号码 **/
	private List<String> notInPhone;
	/** 不等于手机号码 **/
	private String noEqualsPhone;
	/** 大于手机号码 **/
	private String greaterPhone;
	/** 大于等于手机号码 **/
	private String greaterEqualsPhone;
	/** 小于手机号码 **/
	private String lessPhone;
	/** 小于等于手机号码 **/
	private String lessEqualsPhone;
	/** Like手机号码 **/
	private String likePhone;
	/** Like左匹配手机号码 **/
	private String leftLikePhone;
	/** Like右匹配手机号码 **/
	private String rightLikePhone;
	/** 原始属性邮箱 **/
	private String mail;
	/** 等于邮箱 **/
	private String equalsMail;
	/** 是否为空邮箱 **/
	private Boolean isNotNullMail;
	/** In邮箱 **/
	private List<String> inMail;
	/** NotIn邮箱 **/
	private List<String> notInMail;
	/** 不等于邮箱 **/
	private String noEqualsMail;
	/** 大于邮箱 **/
	private String greaterMail;
	/** 大于等于邮箱 **/
	private String greaterEqualsMail;
	/** 小于邮箱 **/
	private String lessMail;
	/** 小于等于邮箱 **/
	private String lessEqualsMail;
	/** Like邮箱 **/
	private String likeMail;
	/** Like左匹配邮箱 **/
	private String leftLikeMail;
	/** Like右匹配邮箱 **/
	private String rightLikeMail;
	/** 原始属性部门 **/
	private String department;
	/** 等于部门 **/
	private String equalsDepartment;
	/** 是否为空部门 **/
	private Boolean isNotNullDepartment;
	/** In部门 **/
	private List<String> inDepartment;
	/** NotIn部门 **/
	private List<String> notInDepartment;
	/** 不等于部门 **/
	private String noEqualsDepartment;
	/** 大于部门 **/
	private String greaterDepartment;
	/** 大于等于部门 **/
	private String greaterEqualsDepartment;
	/** 小于部门 **/
	private String lessDepartment;
	/** 小于等于部门 **/
	private String lessEqualsDepartment;
	/** Like部门 **/
	private String likeDepartment;
	/** Like左匹配部门 **/
	private String leftLikeDepartment;
	/** Like右匹配部门 **/
	private String rightLikeDepartment;
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
	/** 原始属性创建本账号的管理员用户名 **/
	private String createUser;
	/** 等于创建本账号的管理员用户名 **/
	private String equalsCreateUser;
	/** 是否为空创建本账号的管理员用户名 **/
	private Boolean isNotNullCreateUser;
	/** In创建本账号的管理员用户名 **/
	private List<String> inCreateUser;
	/** NotIn创建本账号的管理员用户名 **/
	private List<String> notInCreateUser;
	/** 不等于创建本账号的管理员用户名 **/
	private String noEqualsCreateUser;
	/** 大于创建本账号的管理员用户名 **/
	private String greaterCreateUser;
	/** 大于等于创建本账号的管理员用户名 **/
	private String greaterEqualsCreateUser;
	/** 小于创建本账号的管理员用户名 **/
	private String lessCreateUser;
	/** 小于等于创建本账号的管理员用户名 **/
	private String lessEqualsCreateUser;
	/** Like创建本账号的管理员用户名 **/
	private String likeCreateUser;
	/** Like左匹配创建本账号的管理员用户名 **/
	private String leftLikeCreateUser;
	/** Like右匹配创建本账号的管理员用户名 **/
	private String rightLikeCreateUser;
	/** 原始属性权限最近修改时间 **/
	private Date modifyTime;
	/** 等于权限最近修改时间 **/
	private Date equalsModifyTime;
	/** 是否为空权限最近修改时间 **/
	private Boolean isNotNullModifyTime;
	/** In权限最近修改时间 **/
	private List<Date> inModifyTime;
	/** NotIn权限最近修改时间 **/
	private List<Date> notInModifyTime;
	/** 不等于权限最近修改时间 **/
	private Date noEqualsModifyTime;
	/** 大于权限最近修改时间 **/
	private Date greaterModifyTime;
	/** 大于等于权限最近修改时间 **/
	private Date greaterEqualsModifyTime;
	/** 小于权限最近修改时间 **/
	private Date lessModifyTime;
	/** 小于等于权限最近修改时间 **/
	private Date lessEqualsModifyTime;
	/** 原始属性上次登录时间 **/
	private Date loginTime;
	/** 等于上次登录时间 **/
	private Date equalsLoginTime;
	/** 是否为空上次登录时间 **/
	private Boolean isNotNullLoginTime;
	/** In上次登录时间 **/
	private List<Date> inLoginTime;
	/** NotIn上次登录时间 **/
	private List<Date> notInLoginTime;
	/** 不等于上次登录时间 **/
	private Date noEqualsLoginTime;
	/** 大于上次登录时间 **/
	private Date greaterLoginTime;
	/** 大于等于上次登录时间 **/
	private Date greaterEqualsLoginTime;
	/** 小于上次登录时间 **/
	private Date lessLoginTime;
	/** 小于等于上次登录时间 **/
	private Date lessEqualsLoginTime;
	/** 原始属性上次登录IP **/
	private String loginIp;
	/** 等于上次登录IP **/
	private String equalsLoginIp;
	/** 是否为空上次登录IP **/
	private Boolean isNotNullLoginIp;
	/** In上次登录IP **/
	private List<String> inLoginIp;
	/** NotIn上次登录IP **/
	private List<String> notInLoginIp;
	/** 不等于上次登录IP **/
	private String noEqualsLoginIp;
	/** 大于上次登录IP **/
	private String greaterLoginIp;
	/** 大于等于上次登录IP **/
	private String greaterEqualsLoginIp;
	/** 小于上次登录IP **/
	private String lessLoginIp;
	/** 小于等于上次登录IP **/
	private String lessEqualsLoginIp;
	/** Like上次登录IP **/
	private String likeLoginIp;
	/** Like左匹配上次登录IP **/
	private String leftLikeLoginIp;
	/** Like右匹配上次登录IP **/
	private String rightLikeLoginIp;
	/** 原始属性状态，0：禁用，1：启用 **/
	private Integer state;
	/** 等于状态，0：禁用，1：启用 **/
	private Integer equalsState;
	/** 是否为空状态，0：禁用，1：启用 **/
	private Boolean isNotNullState;
	/** In状态，0：禁用，1：启用 **/
	private List<Integer> inState;
	/** NotIn状态，0：禁用，1：启用 **/
	private List<Integer> notInState;
	/** 不等于状态，0：禁用，1：启用 **/
	private Integer noEqualsState;
	/** 大于状态，0：禁用，1：启用 **/
	private Integer greaterState;
	/** 大于等于状态，0：禁用，1：启用 **/
	private Integer greaterEqualsState;
	/** 小于状态，0：禁用，1：启用 **/
	private Integer lessState;
	/** 小于等于状态，0：禁用，1：启用 **/
	private Integer lessEqualsState;

	
  	public SysManagerSearchBean() {
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
	public void setManagername(String managername){
		this.managername=managername;
	}
	public String getManagername(){
		return managername;
	}
	public void setEqualsManagername(String equalsManagername){
		this.equalsManagername=equalsManagername;
	}
	public String getEqualsManagername(){
		return equalsManagername;
	}
	public void setIsNotNullManagername(Boolean isNotNullManagername){
		this.isNotNullManagername=isNotNullManagername;
	}
	public Boolean getIsNotNullManagername(){
		return isNotNullManagername;
	}
	public void setInManagername(List<String> inManagername){
		this.inManagername=inManagername;
	}
	public List<String> getInManagername(){
		return inManagername;
	}
	public void setNotInManagername(List<String> notInManagername){
		this.notInManagername=notInManagername;
	}
	public List<String> getNotInManagername(){
		return notInManagername;
	}
	public void setNoEqualsManagername(String noEqualsManagername){
		this.noEqualsManagername=noEqualsManagername;
	}
	public String getNoEqualsManagername(){
		return noEqualsManagername;
	}
	public void setGreaterManagername(String greaterManagername){
		this.greaterManagername=greaterManagername;
	}
	public String getGreaterManagername(){
		return greaterManagername;
	}
	public void setGreaterEqualsManagername(String greaterEqualsManagername){
		this.greaterEqualsManagername=greaterEqualsManagername;
	}
	public String getGreaterEqualsManagername(){
		return greaterEqualsManagername;
	}
	public void setLessManagername(String lessManagername){
		this.lessManagername=lessManagername;
	}
	public String getLessManagername(){
		return lessManagername;
	}
	public void setLessEqualsManagername(String lessEqualsManagername){
		this.lessEqualsManagername=lessEqualsManagername;
	}
	public String getLessEqualsManagername(){
		return lessEqualsManagername;
	}
	public void setLikeManagername(String likeManagername){
		this.likeManagername=likeManagername;
	}
	public String getLikeManagername(){
		return likeManagername;
	}
	public void setLeftLikeManagername(String leftLikeManagername){
		this.leftLikeManagername=likeManagername;
	}
	public String getLeftLikeManagername(){
		return leftLikeManagername;
	}
	public void setRightLikeManagername(String rightLikeManagername){
		this.rightLikeManagername=rightLikeManagername;
	}
	public String getRightLikeManagername(){
		return rightLikeManagername;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public String getPassword(){
		return password;
	}
	public void setEqualsPassword(String equalsPassword){
		this.equalsPassword=equalsPassword;
	}
	public String getEqualsPassword(){
		return equalsPassword;
	}
	public void setIsNotNullPassword(Boolean isNotNullPassword){
		this.isNotNullPassword=isNotNullPassword;
	}
	public Boolean getIsNotNullPassword(){
		return isNotNullPassword;
	}
	public void setInPassword(List<String> inPassword){
		this.inPassword=inPassword;
	}
	public List<String> getInPassword(){
		return inPassword;
	}
	public void setNotInPassword(List<String> notInPassword){
		this.notInPassword=notInPassword;
	}
	public List<String> getNotInPassword(){
		return notInPassword;
	}
	public void setNoEqualsPassword(String noEqualsPassword){
		this.noEqualsPassword=noEqualsPassword;
	}
	public String getNoEqualsPassword(){
		return noEqualsPassword;
	}
	public void setGreaterPassword(String greaterPassword){
		this.greaterPassword=greaterPassword;
	}
	public String getGreaterPassword(){
		return greaterPassword;
	}
	public void setGreaterEqualsPassword(String greaterEqualsPassword){
		this.greaterEqualsPassword=greaterEqualsPassword;
	}
	public String getGreaterEqualsPassword(){
		return greaterEqualsPassword;
	}
	public void setLessPassword(String lessPassword){
		this.lessPassword=lessPassword;
	}
	public String getLessPassword(){
		return lessPassword;
	}
	public void setLessEqualsPassword(String lessEqualsPassword){
		this.lessEqualsPassword=lessEqualsPassword;
	}
	public String getLessEqualsPassword(){
		return lessEqualsPassword;
	}
	public void setLikePassword(String likePassword){
		this.likePassword=likePassword;
	}
	public String getLikePassword(){
		return likePassword;
	}
	public void setLeftLikePassword(String leftLikePassword){
		this.leftLikePassword=likePassword;
	}
	public String getLeftLikePassword(){
		return leftLikePassword;
	}
	public void setRightLikePassword(String rightLikePassword){
		this.rightLikePassword=rightLikePassword;
	}
	public String getRightLikePassword(){
		return rightLikePassword;
	}
	public void setRealname(String realname){
		this.realname=realname;
	}
	public String getRealname(){
		return realname;
	}
	public void setEqualsRealname(String equalsRealname){
		this.equalsRealname=equalsRealname;
	}
	public String getEqualsRealname(){
		return equalsRealname;
	}
	public void setIsNotNullRealname(Boolean isNotNullRealname){
		this.isNotNullRealname=isNotNullRealname;
	}
	public Boolean getIsNotNullRealname(){
		return isNotNullRealname;
	}
	public void setInRealname(List<String> inRealname){
		this.inRealname=inRealname;
	}
	public List<String> getInRealname(){
		return inRealname;
	}
	public void setNotInRealname(List<String> notInRealname){
		this.notInRealname=notInRealname;
	}
	public List<String> getNotInRealname(){
		return notInRealname;
	}
	public void setNoEqualsRealname(String noEqualsRealname){
		this.noEqualsRealname=noEqualsRealname;
	}
	public String getNoEqualsRealname(){
		return noEqualsRealname;
	}
	public void setGreaterRealname(String greaterRealname){
		this.greaterRealname=greaterRealname;
	}
	public String getGreaterRealname(){
		return greaterRealname;
	}
	public void setGreaterEqualsRealname(String greaterEqualsRealname){
		this.greaterEqualsRealname=greaterEqualsRealname;
	}
	public String getGreaterEqualsRealname(){
		return greaterEqualsRealname;
	}
	public void setLessRealname(String lessRealname){
		this.lessRealname=lessRealname;
	}
	public String getLessRealname(){
		return lessRealname;
	}
	public void setLessEqualsRealname(String lessEqualsRealname){
		this.lessEqualsRealname=lessEqualsRealname;
	}
	public String getLessEqualsRealname(){
		return lessEqualsRealname;
	}
	public void setLikeRealname(String likeRealname){
		this.likeRealname=likeRealname;
	}
	public String getLikeRealname(){
		return likeRealname;
	}
	public void setLeftLikeRealname(String leftLikeRealname){
		this.leftLikeRealname=likeRealname;
	}
	public String getLeftLikeRealname(){
		return leftLikeRealname;
	}
	public void setRightLikeRealname(String rightLikeRealname){
		this.rightLikeRealname=rightLikeRealname;
	}
	public String getRightLikeRealname(){
		return rightLikeRealname;
	}
	public void setPhone(String phone){
		this.phone=phone;
	}
	public String getPhone(){
		return phone;
	}
	public void setEqualsPhone(String equalsPhone){
		this.equalsPhone=equalsPhone;
	}
	public String getEqualsPhone(){
		return equalsPhone;
	}
	public void setIsNotNullPhone(Boolean isNotNullPhone){
		this.isNotNullPhone=isNotNullPhone;
	}
	public Boolean getIsNotNullPhone(){
		return isNotNullPhone;
	}
	public void setInPhone(List<String> inPhone){
		this.inPhone=inPhone;
	}
	public List<String> getInPhone(){
		return inPhone;
	}
	public void setNotInPhone(List<String> notInPhone){
		this.notInPhone=notInPhone;
	}
	public List<String> getNotInPhone(){
		return notInPhone;
	}
	public void setNoEqualsPhone(String noEqualsPhone){
		this.noEqualsPhone=noEqualsPhone;
	}
	public String getNoEqualsPhone(){
		return noEqualsPhone;
	}
	public void setGreaterPhone(String greaterPhone){
		this.greaterPhone=greaterPhone;
	}
	public String getGreaterPhone(){
		return greaterPhone;
	}
	public void setGreaterEqualsPhone(String greaterEqualsPhone){
		this.greaterEqualsPhone=greaterEqualsPhone;
	}
	public String getGreaterEqualsPhone(){
		return greaterEqualsPhone;
	}
	public void setLessPhone(String lessPhone){
		this.lessPhone=lessPhone;
	}
	public String getLessPhone(){
		return lessPhone;
	}
	public void setLessEqualsPhone(String lessEqualsPhone){
		this.lessEqualsPhone=lessEqualsPhone;
	}
	public String getLessEqualsPhone(){
		return lessEqualsPhone;
	}
	public void setLikePhone(String likePhone){
		this.likePhone=likePhone;
	}
	public String getLikePhone(){
		return likePhone;
	}
	public void setLeftLikePhone(String leftLikePhone){
		this.leftLikePhone=likePhone;
	}
	public String getLeftLikePhone(){
		return leftLikePhone;
	}
	public void setRightLikePhone(String rightLikePhone){
		this.rightLikePhone=rightLikePhone;
	}
	public String getRightLikePhone(){
		return rightLikePhone;
	}
	public void setMail(String mail){
		this.mail=mail;
	}
	public String getMail(){
		return mail;
	}
	public void setEqualsMail(String equalsMail){
		this.equalsMail=equalsMail;
	}
	public String getEqualsMail(){
		return equalsMail;
	}
	public void setIsNotNullMail(Boolean isNotNullMail){
		this.isNotNullMail=isNotNullMail;
	}
	public Boolean getIsNotNullMail(){
		return isNotNullMail;
	}
	public void setInMail(List<String> inMail){
		this.inMail=inMail;
	}
	public List<String> getInMail(){
		return inMail;
	}
	public void setNotInMail(List<String> notInMail){
		this.notInMail=notInMail;
	}
	public List<String> getNotInMail(){
		return notInMail;
	}
	public void setNoEqualsMail(String noEqualsMail){
		this.noEqualsMail=noEqualsMail;
	}
	public String getNoEqualsMail(){
		return noEqualsMail;
	}
	public void setGreaterMail(String greaterMail){
		this.greaterMail=greaterMail;
	}
	public String getGreaterMail(){
		return greaterMail;
	}
	public void setGreaterEqualsMail(String greaterEqualsMail){
		this.greaterEqualsMail=greaterEqualsMail;
	}
	public String getGreaterEqualsMail(){
		return greaterEqualsMail;
	}
	public void setLessMail(String lessMail){
		this.lessMail=lessMail;
	}
	public String getLessMail(){
		return lessMail;
	}
	public void setLessEqualsMail(String lessEqualsMail){
		this.lessEqualsMail=lessEqualsMail;
	}
	public String getLessEqualsMail(){
		return lessEqualsMail;
	}
	public void setLikeMail(String likeMail){
		this.likeMail=likeMail;
	}
	public String getLikeMail(){
		return likeMail;
	}
	public void setLeftLikeMail(String leftLikeMail){
		this.leftLikeMail=likeMail;
	}
	public String getLeftLikeMail(){
		return leftLikeMail;
	}
	public void setRightLikeMail(String rightLikeMail){
		this.rightLikeMail=rightLikeMail;
	}
	public String getRightLikeMail(){
		return rightLikeMail;
	}
	public void setDepartment(String department){
		this.department=department;
	}
	public String getDepartment(){
		return department;
	}
	public void setEqualsDepartment(String equalsDepartment){
		this.equalsDepartment=equalsDepartment;
	}
	public String getEqualsDepartment(){
		return equalsDepartment;
	}
	public void setIsNotNullDepartment(Boolean isNotNullDepartment){
		this.isNotNullDepartment=isNotNullDepartment;
	}
	public Boolean getIsNotNullDepartment(){
		return isNotNullDepartment;
	}
	public void setInDepartment(List<String> inDepartment){
		this.inDepartment=inDepartment;
	}
	public List<String> getInDepartment(){
		return inDepartment;
	}
	public void setNotInDepartment(List<String> notInDepartment){
		this.notInDepartment=notInDepartment;
	}
	public List<String> getNotInDepartment(){
		return notInDepartment;
	}
	public void setNoEqualsDepartment(String noEqualsDepartment){
		this.noEqualsDepartment=noEqualsDepartment;
	}
	public String getNoEqualsDepartment(){
		return noEqualsDepartment;
	}
	public void setGreaterDepartment(String greaterDepartment){
		this.greaterDepartment=greaterDepartment;
	}
	public String getGreaterDepartment(){
		return greaterDepartment;
	}
	public void setGreaterEqualsDepartment(String greaterEqualsDepartment){
		this.greaterEqualsDepartment=greaterEqualsDepartment;
	}
	public String getGreaterEqualsDepartment(){
		return greaterEqualsDepartment;
	}
	public void setLessDepartment(String lessDepartment){
		this.lessDepartment=lessDepartment;
	}
	public String getLessDepartment(){
		return lessDepartment;
	}
	public void setLessEqualsDepartment(String lessEqualsDepartment){
		this.lessEqualsDepartment=lessEqualsDepartment;
	}
	public String getLessEqualsDepartment(){
		return lessEqualsDepartment;
	}
	public void setLikeDepartment(String likeDepartment){
		this.likeDepartment=likeDepartment;
	}
	public String getLikeDepartment(){
		return likeDepartment;
	}
	public void setLeftLikeDepartment(String leftLikeDepartment){
		this.leftLikeDepartment=likeDepartment;
	}
	public String getLeftLikeDepartment(){
		return leftLikeDepartment;
	}
	public void setRightLikeDepartment(String rightLikeDepartment){
		this.rightLikeDepartment=rightLikeDepartment;
	}
	public String getRightLikeDepartment(){
		return rightLikeDepartment;
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
	public void setCreateUser(String createUser){
		this.createUser=createUser;
	}
	public String getCreateUser(){
		return createUser;
	}
	public void setEqualsCreateUser(String equalsCreateUser){
		this.equalsCreateUser=equalsCreateUser;
	}
	public String getEqualsCreateUser(){
		return equalsCreateUser;
	}
	public void setIsNotNullCreateUser(Boolean isNotNullCreateUser){
		this.isNotNullCreateUser=isNotNullCreateUser;
	}
	public Boolean getIsNotNullCreateUser(){
		return isNotNullCreateUser;
	}
	public void setInCreateUser(List<String> inCreateUser){
		this.inCreateUser=inCreateUser;
	}
	public List<String> getInCreateUser(){
		return inCreateUser;
	}
	public void setNotInCreateUser(List<String> notInCreateUser){
		this.notInCreateUser=notInCreateUser;
	}
	public List<String> getNotInCreateUser(){
		return notInCreateUser;
	}
	public void setNoEqualsCreateUser(String noEqualsCreateUser){
		this.noEqualsCreateUser=noEqualsCreateUser;
	}
	public String getNoEqualsCreateUser(){
		return noEqualsCreateUser;
	}
	public void setGreaterCreateUser(String greaterCreateUser){
		this.greaterCreateUser=greaterCreateUser;
	}
	public String getGreaterCreateUser(){
		return greaterCreateUser;
	}
	public void setGreaterEqualsCreateUser(String greaterEqualsCreateUser){
		this.greaterEqualsCreateUser=greaterEqualsCreateUser;
	}
	public String getGreaterEqualsCreateUser(){
		return greaterEqualsCreateUser;
	}
	public void setLessCreateUser(String lessCreateUser){
		this.lessCreateUser=lessCreateUser;
	}
	public String getLessCreateUser(){
		return lessCreateUser;
	}
	public void setLessEqualsCreateUser(String lessEqualsCreateUser){
		this.lessEqualsCreateUser=lessEqualsCreateUser;
	}
	public String getLessEqualsCreateUser(){
		return lessEqualsCreateUser;
	}
	public void setLikeCreateUser(String likeCreateUser){
		this.likeCreateUser=likeCreateUser;
	}
	public String getLikeCreateUser(){
		return likeCreateUser;
	}
	public void setLeftLikeCreateUser(String leftLikeCreateUser){
		this.leftLikeCreateUser=likeCreateUser;
	}
	public String getLeftLikeCreateUser(){
		return leftLikeCreateUser;
	}
	public void setRightLikeCreateUser(String rightLikeCreateUser){
		this.rightLikeCreateUser=rightLikeCreateUser;
	}
	public String getRightLikeCreateUser(){
		return rightLikeCreateUser;
	}
	public void setModifyTime(Date modifyTime){
		this.modifyTime=modifyTime;
	}
	public Date getModifyTime(){
		return modifyTime;
	}
	public void setEqualsModifyTime(Date equalsModifyTime){
		this.equalsModifyTime=equalsModifyTime;
	}
	public Date getEqualsModifyTime(){
		return equalsModifyTime;
	}
	public void setIsNotNullModifyTime(Boolean isNotNullModifyTime){
		this.isNotNullModifyTime=isNotNullModifyTime;
	}
	public Boolean getIsNotNullModifyTime(){
		return isNotNullModifyTime;
	}
	public void setInModifyTime(List<Date> inModifyTime){
		this.inModifyTime=inModifyTime;
	}
	public List<Date> getInModifyTime(){
		return inModifyTime;
	}
	public void setNotInModifyTime(List<Date> notInModifyTime){
		this.notInModifyTime=notInModifyTime;
	}
	public List<Date> getNotInModifyTime(){
		return notInModifyTime;
	}
	public void setNoEqualsModifyTime(Date noEqualsModifyTime){
		this.noEqualsModifyTime=noEqualsModifyTime;
	}
	public Date getNoEqualsModifyTime(){
		return noEqualsModifyTime;
	}
	public void setGreaterModifyTime(Date greaterModifyTime){
		this.greaterModifyTime=greaterModifyTime;
	}
	public Date getGreaterModifyTime(){
		return greaterModifyTime;
	}
	public void setGreaterEqualsModifyTime(Date greaterEqualsModifyTime){
		this.greaterEqualsModifyTime=greaterEqualsModifyTime;
	}
	public Date getGreaterEqualsModifyTime(){
		return greaterEqualsModifyTime;
	}
	public void setLessModifyTime(Date lessModifyTime){
		this.lessModifyTime=lessModifyTime;
	}
	public Date getLessModifyTime(){
		return lessModifyTime;
	}
	public void setLessEqualsModifyTime(Date lessEqualsModifyTime){
		this.lessEqualsModifyTime=lessEqualsModifyTime;
	}
	public Date getLessEqualsModifyTime(){
		return lessEqualsModifyTime;
	}
	public void setLoginTime(Date loginTime){
		this.loginTime=loginTime;
	}
	public Date getLoginTime(){
		return loginTime;
	}
	public void setEqualsLoginTime(Date equalsLoginTime){
		this.equalsLoginTime=equalsLoginTime;
	}
	public Date getEqualsLoginTime(){
		return equalsLoginTime;
	}
	public void setIsNotNullLoginTime(Boolean isNotNullLoginTime){
		this.isNotNullLoginTime=isNotNullLoginTime;
	}
	public Boolean getIsNotNullLoginTime(){
		return isNotNullLoginTime;
	}
	public void setInLoginTime(List<Date> inLoginTime){
		this.inLoginTime=inLoginTime;
	}
	public List<Date> getInLoginTime(){
		return inLoginTime;
	}
	public void setNotInLoginTime(List<Date> notInLoginTime){
		this.notInLoginTime=notInLoginTime;
	}
	public List<Date> getNotInLoginTime(){
		return notInLoginTime;
	}
	public void setNoEqualsLoginTime(Date noEqualsLoginTime){
		this.noEqualsLoginTime=noEqualsLoginTime;
	}
	public Date getNoEqualsLoginTime(){
		return noEqualsLoginTime;
	}
	public void setGreaterLoginTime(Date greaterLoginTime){
		this.greaterLoginTime=greaterLoginTime;
	}
	public Date getGreaterLoginTime(){
		return greaterLoginTime;
	}
	public void setGreaterEqualsLoginTime(Date greaterEqualsLoginTime){
		this.greaterEqualsLoginTime=greaterEqualsLoginTime;
	}
	public Date getGreaterEqualsLoginTime(){
		return greaterEqualsLoginTime;
	}
	public void setLessLoginTime(Date lessLoginTime){
		this.lessLoginTime=lessLoginTime;
	}
	public Date getLessLoginTime(){
		return lessLoginTime;
	}
	public void setLessEqualsLoginTime(Date lessEqualsLoginTime){
		this.lessEqualsLoginTime=lessEqualsLoginTime;
	}
	public Date getLessEqualsLoginTime(){
		return lessEqualsLoginTime;
	}
	public void setLoginIp(String loginIp){
		this.loginIp=loginIp;
	}
	public String getLoginIp(){
		return loginIp;
	}
	public void setEqualsLoginIp(String equalsLoginIp){
		this.equalsLoginIp=equalsLoginIp;
	}
	public String getEqualsLoginIp(){
		return equalsLoginIp;
	}
	public void setIsNotNullLoginIp(Boolean isNotNullLoginIp){
		this.isNotNullLoginIp=isNotNullLoginIp;
	}
	public Boolean getIsNotNullLoginIp(){
		return isNotNullLoginIp;
	}
	public void setInLoginIp(List<String> inLoginIp){
		this.inLoginIp=inLoginIp;
	}
	public List<String> getInLoginIp(){
		return inLoginIp;
	}
	public void setNotInLoginIp(List<String> notInLoginIp){
		this.notInLoginIp=notInLoginIp;
	}
	public List<String> getNotInLoginIp(){
		return notInLoginIp;
	}
	public void setNoEqualsLoginIp(String noEqualsLoginIp){
		this.noEqualsLoginIp=noEqualsLoginIp;
	}
	public String getNoEqualsLoginIp(){
		return noEqualsLoginIp;
	}
	public void setGreaterLoginIp(String greaterLoginIp){
		this.greaterLoginIp=greaterLoginIp;
	}
	public String getGreaterLoginIp(){
		return greaterLoginIp;
	}
	public void setGreaterEqualsLoginIp(String greaterEqualsLoginIp){
		this.greaterEqualsLoginIp=greaterEqualsLoginIp;
	}
	public String getGreaterEqualsLoginIp(){
		return greaterEqualsLoginIp;
	}
	public void setLessLoginIp(String lessLoginIp){
		this.lessLoginIp=lessLoginIp;
	}
	public String getLessLoginIp(){
		return lessLoginIp;
	}
	public void setLessEqualsLoginIp(String lessEqualsLoginIp){
		this.lessEqualsLoginIp=lessEqualsLoginIp;
	}
	public String getLessEqualsLoginIp(){
		return lessEqualsLoginIp;
	}
	public void setLikeLoginIp(String likeLoginIp){
		this.likeLoginIp=likeLoginIp;
	}
	public String getLikeLoginIp(){
		return likeLoginIp;
	}
	public void setLeftLikeLoginIp(String leftLikeLoginIp){
		this.leftLikeLoginIp=likeLoginIp;
	}
	public String getLeftLikeLoginIp(){
		return leftLikeLoginIp;
	}
	public void setRightLikeLoginIp(String rightLikeLoginIp){
		this.rightLikeLoginIp=rightLikeLoginIp;
	}
	public String getRightLikeLoginIp(){
		return rightLikeLoginIp;
	}
	public void setState(Integer state){
		this.state=state;
	}
	public Integer getState(){
		return state;
	}
	public void setEqualsState(Integer equalsState){
		this.equalsState=equalsState;
	}
	public Integer getEqualsState(){
		return equalsState;
	}
	public void setIsNotNullState(Boolean isNotNullState){
		this.isNotNullState=isNotNullState;
	}
	public Boolean getIsNotNullState(){
		return isNotNullState;
	}
	public void setInState(List<Integer> inState){
		this.inState=inState;
	}
	public List<Integer> getInState(){
		return inState;
	}
	public void setNotInState(List<Integer> notInState){
		this.notInState=notInState;
	}
	public List<Integer> getNotInState(){
		return notInState;
	}
	public void setNoEqualsState(Integer noEqualsState){
		this.noEqualsState=noEqualsState;
	}
	public Integer getNoEqualsState(){
		return noEqualsState;
	}
	public void setGreaterState(Integer greaterState){
		this.greaterState=greaterState;
	}
	public Integer getGreaterState(){
		return greaterState;
	}
	public void setGreaterEqualsState(Integer greaterEqualsState){
		this.greaterEqualsState=greaterEqualsState;
	}
	public Integer getGreaterEqualsState(){
		return greaterEqualsState;
	}
	public void setLessState(Integer lessState){
		this.lessState=lessState;
	}
	public Integer getLessState(){
		return lessState;
	}
	public void setLessEqualsState(Integer lessEqualsState){
		this.lessEqualsState=lessEqualsState;
	}
	public Integer getLessEqualsState(){
		return lessEqualsState;
	}

}
