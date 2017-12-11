package com.hujianbin.basis.bean;

import java.io.Serializable;
import java.util.*;

/**
 * 管理员用户表
 * @author Guodang Zuo
 * @since 1.0
 *
 */
public class SysManager implements Serializable{
  	public SysManager() {
  	}
	/**  主键**/
	private Integer id;
	/** 用户名 **/
	private String managername;
	/** 密码的MD5摘要值 **/
	private String password;
	/** 真实姓名 **/
	private String realname;
	/** 手机号码 **/
	private String phone;
	/** 邮箱 **/
	private String mail;
	/** 部门 **/
	private String department;
	/** 创建时间 **/
	private Date createTime;
	/** 创建本账号的管理员用户名 **/
	private String createUser;
	/** 权限最近修改时间 **/
	private Date modifyTime;
	/** 上次登录时间 **/
	private Date loginTime;
	/** 上次登录IP **/
	private String loginIp;
	/** 状态，0：禁用，1：启用 **/
	private Integer state;
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
	public void setPassword(String password){
		this.password=password;
	}
	public String getPassword(){
		return password;
	}
	public void setRealname(String realname){
		this.realname=realname;
	}
	public String getRealname(){
		return realname;
	}
	public void setPhone(String phone){
		this.phone=phone;
	}
	public String getPhone(){
		return phone;
	}
	public void setMail(String mail){
		this.mail=mail;
	}
	public String getMail(){
		return mail;
	}
	public void setDepartment(String department){
		this.department=department;
	}
	public String getDepartment(){
		return department;
	}
	public void setCreateTime(Date createTime){
		this.createTime=createTime;
	}
	public Date getCreateTime(){
		return createTime;
	}
	public void setCreateUser(String createUser){
		this.createUser=createUser;
	}
	public String getCreateUser(){
		return createUser;
	}
	public void setModifyTime(Date modifyTime){
		this.modifyTime=modifyTime;
	}
	public Date getModifyTime(){
		return modifyTime;
	}
	public void setLoginTime(Date loginTime){
		this.loginTime=loginTime;
	}
	public Date getLoginTime(){
		return loginTime;
	}
	public void setLoginIp(String loginIp){
		this.loginIp=loginIp;
	}
	public String getLoginIp(){
		return loginIp;
	}
	public void setState(Integer state){
		this.state=state;
	}
	public Integer getState(){
		return state;
	}
}
