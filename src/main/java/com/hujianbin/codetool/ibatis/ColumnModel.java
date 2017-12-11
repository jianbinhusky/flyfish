package com.hujianbin.codetool.ibatis;

public class ColumnModel {

	/** 字段名 **/
	private String name;
	/** 类型 **/
	private String type;
	/** JDBC类型**/
	private String jdbcType;
	/** 注释 **/
	private String comment;
	/** 是否是主键 **/
	private boolean isPrimaryKey;
	/** 是否是唯一 **/
	private boolean isIdentity;
	/** 是否为空 */
	private boolean isNotNull;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getJdbcType() {
		return jdbcType;
	}
	public void setJdbcType(String jdbcType) {
		this.jdbcType = jdbcType;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public boolean isPrimaryKey() {
		return isPrimaryKey;
	}
	public void setPrimaryKey(boolean isPrimaryKey) {
		this.isPrimaryKey = isPrimaryKey;
	}
	public boolean isIdentity() {
		return isIdentity;
	}
	public void setIdentity(boolean isIdentity) {
		this.isIdentity = isIdentity;
	}
	public boolean isNotNull() {
		return isNotNull;
	}
	public void setNotNull(boolean isNotNull) {
		this.isNotNull = isNotNull;
	}
	public ColumnModel() {
		// TODO Auto-generated constructor stub
	}

}
