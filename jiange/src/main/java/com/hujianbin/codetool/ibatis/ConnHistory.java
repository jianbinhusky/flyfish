package com.hujianbin.codetool.ibatis;

import java.io.Serializable;


public class ConnHistory implements Serializable{

	private static final long serialVersionUID = 10363715070678542L;
	/** 连接名 */
	private String name;
	/** 数据库类型*/
	private String dbType;
	private int	dbIndex;
	/** 驱动类型 */
	private String driverClass;
	/** URL */
	private String dbUrl;
	/** 数据库用户名 */
	private String dbUser;
	/** 数据库密码 */
	private String dbPasswd;
	public ConnHistory() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDbType() {
		return dbType;
	}
	public void setDbType(String dbType) {
		this.dbType = dbType;
	}
	public int getDbIndex() {
		return dbIndex;
	}
	public void setDbIndex(int dbIndex) {
		this.dbIndex = dbIndex;
	}
	public String getDriverClass() {
		return driverClass;
	}
	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}
	public String getDbUrl() {
		return dbUrl;
	}
	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}
	public String getDbUser() {
		return dbUser;
	}
	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}
	public String getDbPasswd() {
		return dbPasswd;
	}
	public void setDbPasswd(String dbPasswd) {
		this.dbPasswd = dbPasswd;
	}

}
