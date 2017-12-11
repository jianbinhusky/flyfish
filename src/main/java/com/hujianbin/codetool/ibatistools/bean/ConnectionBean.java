package com.hujianbin.codetool.ibatistools.bean;

import lombok.Data;

@Data
public class ConnectionBean {

	private String connName;
	
	private Integer dbType;
	
	private String mapend;
	
	private String driver;
	
	private String url;
	
	private String username;
	
	private String password;
}
