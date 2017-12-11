package com.hujianbin.codetool.ibatistools.util;


import com.hujianbin.codetool.ibatistools.bean.ColumnModel;
import com.hujianbin.codetool.ibatistools.bean.ConnHistory;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class DBUtil {

	public DBUtil() {
	}
	
	/**
	 * 获取所有表名
	 * @param conn 连接对象
	 * @param sql 
	 * @return String[]
	 */
	public static String[] getAllTables(Connection conn,String sql){
		String[] allt=null;
		List<String> list=new ArrayList<String>();
		Statement stat=null;
		ResultSet rs=null;
		
		try {
			stat = conn.createStatement();
			rs=stat.executeQuery(sql);
			while(rs.next()){
				list.add(rs.getString(1));
			}
			allt=list.toArray(new String[0]);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try{
			if(rs!=null)
				rs.close();
			if(stat!=null)
				stat.close();
			}catch(Exception e){
				
			}
		}
		
		return allt;
	}
	
	/**
	 * 获取所有表名
	 * @param conn 连接对象
	 * @param sql 
	 * @return List<String>
	 */
	public static List<String> getTabaleList(Connection conn,String sql){
		List<String> list=new ArrayList<String>();
		Statement stat=null;
		ResultSet rs=null;
		
		try {
			stat = conn.createStatement();
			rs=stat.executeQuery(sql);
			while(rs.next()){
				list.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try{
			if(rs!=null)
				rs.close();
			if(stat!=null)
				stat.close();
			}catch(Exception e){
				
			}
		}
		
		return list;
	}
	
	/**
	 * 获取数据库字段类型
	 * @param conn
	 * @param sql
	 * @return Map
	 */
	public static Map<String,String> getColumns(Connection conn,String sql){
		Map<String,String> allt=new LinkedHashMap<String,String>();
		Statement stat=null;
		ResultSet rs=null;
		try {
			stat = conn.createStatement();
			rs=stat.executeQuery(sql);
			ResultSetMetaData rsmd= rs.getMetaData();
			int rsmdl=rsmd.getColumnCount();
			for(int i=1;i<=rsmdl;i++){
				String typeName=rsmd.getColumnTypeName(i);
				
				if("varchar2".equalsIgnoreCase(typeName)||"varchar".equalsIgnoreCase(typeName)){
					typeName="varchar";
				}else if("date".equalsIgnoreCase(typeName)||"datetime".equalsIgnoreCase(typeName)){
					typeName="date";
				}else if("int".equalsIgnoreCase(typeName)||"integer".equalsIgnoreCase(typeName)){
					typeName="";
				}
				allt.put(rsmd.getColumnLabel(i),typeName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try{
			if(rs!=null)
				rs.close();
			if(stat!=null)
				stat.close();
			}catch(Exception e){
				
			}
		}
		return allt;
	}
	
	/**
	 * 获取表注释
	 * @return
	 */
	public static String getTableComment(Connection conn,String tableName,String dbType){
		String comment="";
		Statement stat=null;
		ResultSet rs=null;
		try{
			if(dbType.equalsIgnoreCase("mysql")){
				stat=conn.createStatement();
				rs=stat.executeQuery("SHOW CREATE TABLE `"+tableName+"`");
				String tmp="";
				while(rs.next()){
					tmp=rs.getString(2);
					break;
				}
				int index = tmp.indexOf("COMMENT='");
                if(index >= 0) {
                	comment = tmp.substring(index+9);
                    comment = comment.substring(0,comment.length() - 1);
                }
                
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null)
					rs.close();
				if(stat!=null)
					stat.close();
				}catch(Exception e){
					
				}
		}
		
		return comment;
	}
	
	/**
	 * 获取表字段
	 * @param conn 连接对象
	 * @param tableName 表名
	 * @return List ColumnModel
	 */
	public static List<ColumnModel> getTableColumns(Connection conn,String tableName,String dbType){
		List<ColumnModel> colList=new ArrayList<ColumnModel>();
		String name=null,type=null,comment=null,pname=null,precision=null,scale=null,notnull=null;
		String sql=null;
		String extra = null;
		if(dbType.equalsIgnoreCase("oracle")){
			tableName=tableName.toUpperCase();
			//sql="select t1.COLUMN_NAME,t1.DATA_TYPE,t2.COMMENTS from user_tab_columns t1 left join user_col_comments t2 on t2.COLUMN_NAME=t1.COLUMN_NAME where t1.table_name='"+tableName+"' and t2.TABLE_NAME='"+tableName+"'";
			sql="SELECT T1.TABLE_NAME,T1.COLUMN_NAME,T1.DATA_TYPE,T1.DATA_PRECISION,T1.DATA_SCALE,T1.NULLABLE,T2.COMMENTS,T3.COLUMN_NAME P_COLUMN_NAME FROM USER_TAB_COLUMNS T1 LEFT JOIN USER_COL_COMMENTS T2 ON T2.COLUMN_NAME=T1.COLUMN_NAME LEFT JOIN (SELECT * FROM USER_CONS_COLUMNS WHERE CONSTRAINT_NAME IN (SELECT CONSTRAINT_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME='"+tableName+"' AND CONSTRAINT_TYPE ='P')) T3 ON T3.COLUMN_NAME=T1.COLUMN_NAME WHERE T1.TABLE_NAME='"+tableName+"' AND T2.TABLE_NAME='"+tableName+"' ORDER BY T1.COLUMN_ID ASC";
			name="COLUMN_NAME";
			type="DATA_TYPE";
			comment="COMMENTS";
			pname="P_COLUMN_NAME";
			precision="DATA_PRECISION";
			scale="DATA_SCALE";
			notnull="NULLABLE";
		}else if(dbType.equalsIgnoreCase("mysql")){
			sql="show full fields from `"+tableName+"`";
			name="Field";
			type="Type";
			comment="Comment";
			pname="Key";
			notnull="Null";
			extra = "Extra";
		}else if(dbType.equalsIgnoreCase("mssqlserver")){
			sql="SELECT SYS.COLUMNS.NAME COLUMN_NAME, SYS.TYPES.NAME DATA_TYPE,SYS.TYPES.IS_NULLABLE,(SELECT COUNT(*) FROM SYS.IDENTITY_COLUMNS WHERE SYS.IDENTITY_COLUMNS.OBJECT_ID = SYS.COLUMNS.OBJECT_ID AND SYS.COLUMNS.COLUMN_ID = SYS.IDENTITY_COLUMNS.COLUMN_ID) AS P_COLUMN_NAME ,(SELECT VALUE FROM SYS.EXTENDED_PROPERTIES WHERE SYS.EXTENDED_PROPERTIES.MAJOR_ID = SYS.COLUMNS.OBJECT_ID AND SYS.EXTENDED_PROPERTIES.MINOR_ID = SYS.COLUMNS.COLUMN_ID) AS COMMENTS FROM SYS.COLUMNS, SYS.TABLES, SYS.TYPES WHERE SYS.COLUMNS.OBJECT_ID = SYS.TABLES.OBJECT_ID AND SYS.COLUMNS.SYSTEM_TYPE_ID=SYS.TYPES.SYSTEM_TYPE_ID AND SYS.TABLES.NAME='"+tableName+"' ORDER BY SYS.COLUMNS.COLUMN_ID";
			name="COLUMN_NAME";
			type="DATA_TYPE";
			comment="COMMENTS";
			pname="P_COLUMN_NAME";
			notnull="IS_NULLABLE";
		}else if(dbType.equalsIgnoreCase("postgresql")){
			sql="select b.attname as field,c.typname as typename,b.attlen as length,b.atttypmod-4 as lengthvar,b.attnotnull as notnull,d.colname as pkcolumn,e.description from pg_class a left join pg_attribute b on b.attrelid=a.oid left join pg_type c on b.atttypid=c.oid left join (select pg_constraint.conname as pk_name,pg_attribute.attname as colname,pg_type.typname as typename from pg_constraint inner join pg_class on pg_constraint.conrelid = pg_class.oid inner join pg_attribute on pg_attribute.attrelid = pg_class.oid and  pg_attribute.attnum = pg_constraint.conkey[1] inner join pg_type on pg_type.oid = pg_attribute.atttypid where pg_class.relname = '"+tableName+"' and pg_constraint.contype='p') d on b.attname=d.colname left join pg_description e on e.objsubid=b.attnum and e.objoid=a.oid where a.relname='"+tableName+"' and b.attnum>0 order by b.attnum";
			name="field";
			type="typename";
			comment="description";
			pname="pkcolumn";
			notnull="notnull";
		}else if(dbType.equalsIgnoreCase("h2")){
			sql="SELECT C.COLUMN_NAME,C.IS_NULLABLE,C.TYPE_NAME,C.REMARKS,I.INDEX_TYPE_NAME  FROM INFORMATION_SCHEMA.COLUMNS C LEFT JOIN  INFORMATION_SCHEMA.INDEXES I ON (C.TABLE_NAME =I.TABLE_NAME AND C.COLUMN_NAME =I.COLUMN_NAME )  WHERE   C.TABLE_NAME ='"+tableName+"' ORDER  BY C.ORDINAL_POSITION ASC";
			name="COLUMN_NAME";
			type="TYPE_NAME";
			comment="REMARKS";
			pname="INDEX_TYPE_NAME";
			notnull="IS_NULLABLE";
		}
		Statement stat=null;
		ResultSet rs=null;
		try {
			stat = conn.createStatement();
			rs=stat.executeQuery(sql);
			while(rs.next()){
				ColumnModel cm=new ColumnModel();
				String na=rs.getString(name);
				cm.setName(na);
				String ty=rs.getString(type);
				if(ty.equalsIgnoreCase("date")||ty.equalsIgnoreCase("datetime")||ty.equalsIgnoreCase("time")||ty.equalsIgnoreCase("TIMESTAMP")||ty.toLowerCase().indexOf("timestamp")>-1){
					cm.setType("Date");
					cm.setJdbcType("TIMESTAMP");
				}else if(ty.toLowerCase().indexOf("float")>-1||ty.toLowerCase().indexOf("double")>-1||ty.toLowerCase().indexOf("numeric")>-1){
					cm.setType("Double");
					cm.setJdbcType("NUMERIC");
				}else if(ty.toLowerCase().indexOf("number")>-1){
					int precisionValue=rs.getInt(precision);
					int scaleValue=rs.getInt(scale);
					if(scaleValue>0){
						cm.setType("Double");
					}else{
						if(precisionValue>10){
							cm.setType("Long");
						}else{
							cm.setType("Integer");
						}
					}
					cm.setJdbcType("NUMERIC");
				}
				else if(ty.toLowerCase().indexOf("bigint")<0&&(ty.toLowerCase().indexOf("int")>-1||ty.toLowerCase().indexOf("integer")>-1)){
					cm.setType("Integer");
					cm.setJdbcType("NUMERIC");
				}else if(ty.toLowerCase().indexOf("bigint")>-1){
					cm.setType("Long");
					cm.setJdbcType("NUMERIC");
				}else if(ty.toLowerCase().indexOf("varchar")>-1||ty.toLowerCase().indexOf("varchar2")>-1||ty.toLowerCase().indexOf("char")>-1||ty.toLowerCase().indexOf("nchar")>-1){
					cm.setType("String");
					cm.setJdbcType("VARCHAR");
				}else if(ty.equalsIgnoreCase("clob")||ty.equalsIgnoreCase("text")){
					cm.setType("String");
					cm.setJdbcType("CLOB");
				}else if(ty.equalsIgnoreCase("blob")){
					cm.setType("byte[]");
					cm.setJdbcType("BLOB");
				}else{
					cm.setType("String");
					cm.setJdbcType("VARCHAR");
				}
				String co=rs.getString(comment);
				cm.setComment(co==null?na:co);
				String pn=rs.getString(pname);
				cm.setPrimaryKey(false);
				if(dbType.equalsIgnoreCase("oracle")||dbType.equalsIgnoreCase("postgresql")){
					if(pn!=null)
						cm.setPrimaryKey(true);
				}else if(dbType.equalsIgnoreCase("mysql")){
					if(pn!=null){
						if(pn.equalsIgnoreCase("pri"))
							cm.setPrimaryKey(true);
					}
				}else if(dbType.equalsIgnoreCase("h2")){
					if(pn!=null){
						if(pn.equalsIgnoreCase("PRIMARY KEY"))
							cm.setPrimaryKey(true);
					}
				}
				
				cm.setNotNull(false);
				String isNotNull=rs.getString(notnull);
				if(dbType.equalsIgnoreCase("oracle")){
					if("N".equalsIgnoreCase(isNotNull)){
						cm.setNotNull(true);
					}
				}else if(dbType.equalsIgnoreCase("mysql")){
					if("NO".equalsIgnoreCase(isNotNull)){
						cm.setNotNull(true);
					}
				}else if(dbType.equalsIgnoreCase("postgresql")){
					if("t".equalsIgnoreCase(isNotNull)){
						cm.setNotNull(true);
					}
				}else if(dbType.equalsIgnoreCase("h2")){
					if("NO".equalsIgnoreCase(isNotNull))
						cm.setNotNull(true);
				}
				
				if (extra != null) {
					String extraValue = rs.getString(extra);
					if ((dbType.equalsIgnoreCase("mysql"))
							&& ("auto_increment".equals(extraValue))) {
						cm.setAutoIncrement(true);
					}

				}
				
				colList.add(cm);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null)
					rs.close();
				if(stat!=null)
					stat.close();
				}catch(Exception e){
					
				}
		}
		return colList;
	}
	
	/**
	 * 检查连接是否正确
	 * @param driver
	 * @param url
	 * @param user
	 * @param password
	 * @return
	 */
	public static Connection checkConn(String driver ,String url,String username,String password){
		
		Connection conn=null;
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			
		}
		return conn;
	}
	
	/**
	 * 获取历史连接
	 * @param history
	 * @return Connection
	 */
	public static Connection getConnection(ConnHistory history){
		Connection conn=null;
		try {
			Class.forName(history.getDriverClass());
			conn=DriverManager.getConnection(history.getDbUrl(), history.getDbUser(), history.getDbPasswd());
		} catch (ClassNotFoundException e) {
		} catch (SQLException e) {
		} finally{
			
		}
		return conn;
	}

}
