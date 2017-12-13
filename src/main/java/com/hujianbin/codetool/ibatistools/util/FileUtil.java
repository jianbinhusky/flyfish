package com.hujianbin.codetool.ibatistools.util;


import com.hujianbin.codetool.ibatistools.action.IbatisToolAction;
import com.hujianbin.codetool.ibatistools.bean.CodeTemplateStr;
import com.hujianbin.codetool.ibatistools.bean.ColumnModel;
import com.hujianbin.codetool.ibatistools.bean.Config;
import com.hujianbin.codetool.ibatistools.bean.ConnectionBean;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class FileUtil {

	private static String BASE = "D:\\Users\\hujb4\\other eclipse workspace\\workspace\\jiange";
	private static String DAO = "\\src\\main\\java\\com\\hujianbin\\basis\\dao";
	private static String SEARCH = "\\src\\main\\java\\com\\hujianbin\\basis\\search";
	private static String BEAN = "\\src\\main\\java\\com\\hujianbin\\basis\\bean";
	private static String SERVICE = "\\src\\main\\java\\com\\hujianbin\\basis\\service";
	private static String MAP = "\\src\\main\\resources\\conf\\mybatis";
	private static String CONFIG = BASE + "\\src\\main\\resources\\mybatis-config.xml";
	private static String TYPEALIAS = "typeAlias";
	private static String MAPPER = "mapper";

	public static void sendFileToWorkspaceFrom(String source) {
		File file = new File(source);
		List<String> list = new ArrayList<String>();
		populator(file, list);
		System.out.println(list.size());

		String configDir = "D:\\gen\\sql-map-config.xml";
		copyConfig(configDir,CONFIG);

		for (String path : list) {
			if(path.contains("\\dao")){
				copyFile(path,BASE+DAO+"\\"+path.substring(path.lastIndexOf("\\"),path.length()));
			} else if(path.contains("\\bean")){
				copyFile(path,BASE+BEAN+"\\"+path.substring(path.lastIndexOf("\\"),path.length()));
			} else if(path.contains("\\service")){
				copyFile(path,BASE+SERVICE+"\\"+path.substring(path.lastIndexOf("\\"),path.length()));
			} else if(path.contains("\\maps")){
				copyFile(path,BASE+MAP+"\\"+path.substring(path.lastIndexOf("\\"),path.length()));
			} else if(path.contains("\\search")){
				copyFile(path,BASE+SEARCH+"\\"+path.substring(path.lastIndexOf("\\"),path.length()));
			}
		}
	}

	public static void copyFile(String source, String target) {
		InputStream inputStream = null;
		FileOutputStream fileOutputStream = null;
		BufferedReader reader = null;

		try {
			inputStream = new FileInputStream(source);
			reader = new BufferedReader(new InputStreamReader(inputStream));

			StringBuffer sb3 = new StringBuffer();
			String line2 = reader.readLine();
			while (line2 != null) {
				sb3.append(line2);
				sb3.append("\n");
				line2 = reader.readLine();
			}

			File newFile = new File(target);
			fileOutputStream = new FileOutputStream(newFile);
			fileOutputStream.write(sb3.toString().getBytes());

			inputStream.close();
			fileOutputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean isListContainKey(String key , List<String> list){
		boolean flag = false;

		for (String s : list) {
			if(s.trim().equals(key.trim())){
				flag = true;
			}
		}

		return flag;
	}

	public static void copyConfig(String source, String target){
		InputStream inputStream = null;
		InputStream inputStream2 = null;
		BufferedReader reader = null;
		BufferedReader reader2 = null;
		BufferedReader reader3 = null;
		Map<String, List<String>> map = null;
		try {
			inputStream = new FileInputStream(source);
			reader = new BufferedReader(new InputStreamReader(inputStream));


			inputStream2 = new FileInputStream(CONFIG);
			reader2 = new BufferedReader(new InputStreamReader(inputStream2));

			List<String> oldmapper = new ArrayList<String>();
			List<String> oldtypeAlias = new ArrayList<String>();
			List<String> oldXml = new ArrayList<String>();
			String line4 = reader2.readLine();
			while (line4 != null) {
				oldXml.add(line4);
				if(line4.trim().contains("<typeAlias alias=")){
					oldtypeAlias.add(line4);
				}else if(line4.trim().contains("<mapper resource=")){
					oldmapper.add(line4);
				}
				line4 = reader2.readLine();
			}

			map = new HashMap<String, List<String>>();
			List<String> mapper = new ArrayList<String>();
			List<String> typeAlias = new ArrayList<String>();
			String line = reader.readLine();
			while (line != null) {
				if(line.contains("<typeAlias")){
					line = "\t" + line;
					typeAlias.add(line);
				} else if (line.contains("<mapper")) {
					line = "\t" + line;
					mapper.add(line);
				}
				line = reader.readLine();
			}
			map.put(MAPPER, mapper);
			map.put(TYPEALIAS, typeAlias);

			StringBuffer sb1 = new StringBuffer();
			for (String typeAlia : typeAlias) {
				if (!isListContainKey(typeAlia, oldtypeAlias)) {
					sb1.append("\t" + typeAlia);
					sb1.append("\n");
				}
			}
			System.out.println(sb1.toString());
			StringBuffer sb2 = new StringBuffer();
			for (String s : mapper) {
				if (!isListContainKey(s, oldmapper)) {
					sb2.append("\t"+s);
					sb2.append("\n");
				}
			}
			System.out.println(sb2.toString());

			StringBuffer sb3 = new StringBuffer();
//			reader3 = new BufferedReader(new InputStreamReader(inputStream2));
//			String line2 = reader3.readLine();
//			while (line2 != null) {
//				sb3.append(line2);
//				sb3.append("\n");
//				if(line2.trim().equals("<typeAliases>")){
//					sb3.append(sb1.toString());
//				}else if(line2.trim().equals("<mappers>")){
//					sb3.append(sb2.toString());
//				}
//				line2 = reader2.readLine();
//			}
			for (String line2 : oldXml) {
				sb3.append(line2);
				sb3.append("\n");
				if(line2.trim().equals("<typeAliases>")){
					sb3.append(sb1.toString());
				}else if(line2.trim().equals("<mappers>")){
					sb3.append(sb2.toString());
				}
			}
			System.out.println(sb3.toString());

			FileOutputStream fileOutputStream = null;
			try {
				File newFile = new File(CONFIG);
				fileOutputStream = new FileOutputStream(newFile);
				fileOutputStream.write(sb3.toString().getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if(fileOutputStream != null){
						fileOutputStream.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}  finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void populator(File file, List<String> list) {
		File[] files = file.listFiles();
		for (File file1 : files) {
			if(file1.isFile()){
				String path = file1.getPath();
				if(path.contains("\\dao") || path.contains("\\bean") || path.contains("\\service")
						|| path.contains("\\maps") || path.contains("\\search") || path.contains("\\sql-map-config.xml")){
					System.out.println(file1.getPath());
					list.add(file1.getPath());
				}
			}else if(file1.isDirectory()){
				populator(file1, list);
			}
		}
	}

	public static void main(String[] args) {
		String source = "D:\\gen";

		sendFileToWorkspaceFrom(source);
	}

	/**
	 * 读取文件并按格式转换成 String
	 * @param file
	 * @return
	 */
	public static String readTemplateFile(File file){
		String linedata = null;
		BufferedReader buf = null;
		StringBuffer targetBuf = null;
		try {
			
			buf  = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			targetBuf = new StringBuffer();
			while((linedata=buf.readLine())!=null){
				targetBuf.append(linedata).append("\r\n");
			}			
		} catch (Exception e) {
			log.info("读取文件异常",e);
		}finally{
			try {
				buf.close();
			} catch (IOException e) {
				log.info("读取文件异常",e);
			}
		}
		
		return targetBuf.toString();
	}

	public static List<ConnectionBean> readHistory(String filepath){
		File file = new File(filepath);
		InputStream fileInputStream = null;
		List<ConnectionBean> list = new ArrayList<ConnectionBean>();
		//if history file not exists,return empty list
		if (!file.exists()) {
			return list;
		}
		try {
			fileInputStream = new FileInputStream(file);
			BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));
			String line = reader.readLine();
			StringBuffer sb = new StringBuffer();
			while (line != null) {
				String[] params = line.split(IbatisToolAction.SEPARATOR);
				ConnectionBean conn = new ConnectionBean();
				conn.setConnName(params[0]);
				conn.setDriver(params[1]);
				conn.setUrl(params[2]);
				conn.setUsername(params[3]);
				conn.setPassword(params[4]);
				conn.setDbType(Integer.valueOf(params[5]));
				list.add(conn);
				line = reader.readLine();
			}
		} catch (FileNotFoundException e) {
			log.error(e.getMessage());
		} catch (IOException e) {
			log.error(e.getMessage());
		} finally {
			try {
				fileInputStream.close();
			} catch (IOException e) {
				log.error(e.getMessage());
			}
		}
		return list;
	}

	public static void saveHistoryToFile(String filepath ,String content){
		File file = new File(filepath);
		FileOutputStream fileOutputStream = null;
		if (!file.exists()) {
			try {
				file.createNewFile();
				fileOutputStream = new FileOutputStream(file);
				fileOutputStream.write(content.getBytes());
			} catch (IOException e) {
				log.error("File Exception : ", e);
			} finally {
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					log.error(e.getMessage());
				}
			}
		} else {
			try {
				InputStream fileInputStream = new FileInputStream(file);
				BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));
				String line = reader.readLine();
				StringBuffer sb = new StringBuffer();
				while (line != null) {
					sb.append(line);
					sb.append("\n");
					line = reader.readLine();
				}
				String newContent = sb.append(content).toString();
				fileOutputStream = new FileOutputStream(file);
				fileOutputStream.write(newContent.getBytes());
				fileInputStream.close();
			} catch (FileNotFoundException e) {
				log.error(e.getMessage());
			} catch (IOException e) {
				log.error(e.getMessage());
			} finally {
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					log.error(e.getMessage());
				}
			}
		}

	}
	
	public static void writeFile(String[] selections, String dirPath, String packageName, String commonPackage , CodeTemplateStr codeTemplateStr){
		File action=new File(dirPath+"\\action");
		File dao=new File(dirPath+"\\dao");
		File domain=new File(dirPath+"\\bean");
		File maps=new File(dirPath+"\\maps");
		File search=new File(dirPath+"\\search");
		File service=new File(dirPath+"\\service");
		File struts2=new File(dirPath+"\\struts2");
		File ios=new File(dirPath+"\\ios");
		action.mkdirs();
		dao.mkdirs();
		domain.mkdirs();
		maps.mkdirs();
		search.mkdirs();
		service.mkdirs();
		struts2.mkdirs();
		ios.mkdirs();
		File configFile=new File(dirPath+"\\sql-map-config.xml");
		if(configFile.exists()){
			configFile.delete();
		}
		File springDaoFile=new File(dirPath+"\\spring-dao.xml");
		if(springDaoFile.exists()){
			springDaoFile.delete();
		}
		File springServiceFile=new File(dirPath+"\\spring-service.xml");
		if(springServiceFile.exists()){
			springServiceFile.delete();
		}
		File iosH=new File(dirPath+"\\ios.h");
		File iosM=new File(dirPath+"\\ios.m");
		List<String> classList=new ArrayList<String>();
		for(int i=0;i<selections.length;i++){
			try{
				String tableName=selections[i];
				String className=selections[i].substring(0, 1).toUpperCase()+selections[i].substring(1);
				if(tableName.startsWith(Config.tablePrefix)){
					className=tableName.replaceFirst(Config.tablePrefix, "");
					String[] cs=className.split(Config.tableSplit);
					StringBuffer cnsb=new StringBuffer();
					for (String string : cs) {
						cnsb.append(string.substring(0, 1).toUpperCase()+string.substring(1).toLowerCase());
					}
					className=cnsb.toString();
				}else{
					className=selections[i].substring(0, 1).toUpperCase()+selections[i].substring(1).toLowerCase();
				}
				String pTableName=className.substring(0, 1).toLowerCase()+className.substring(1);
				// dao
				File file = new File(dao + "\\" + className + "Dao.java");
				if(file.exists())
					file.delete();
				OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(file),Config.encoding);
				String d = codeTemplateStr.getDaoStr().replaceAll("%TableName%", className);
				d = d.replaceAll("%sTableName%", pTableName);
				d = d.replaceAll("%PackageName%", packageName.toLowerCase());
				out.write(d);
				out.flush();
				out.close();
				
				file = new File(dao + "\\" + className + "DaoImpl.java");
				if(file.exists())
					file.delete();
				out = new OutputStreamWriter(new FileOutputStream(file),Config.encoding);
				d = codeTemplateStr.getDaoImplStr().replaceAll("%TableName%", className);
				d = d.replaceAll("%sTableName%", pTableName);
				d=d.replaceAll("%pTableName%", pTableName);
				d = d.replaceAll("%PackageName%", packageName.toLowerCase());
				out.write(d);
				out.flush();
				out.close();
				
				file=new File(domain+"\\"+className+".java");
				if(file.exists())
					file.delete();
				out = new OutputStreamWriter(new FileOutputStream(file),Config.encoding);
				String comment=DBUtil.getTableComment(IbatisToolAction.conn, selections[i], IbatisToolAction.mapend);
				
				d=codeTemplateStr.getBeanStr().replaceAll("%TableName%", className);
				d=d.replaceAll("%PackageName%",packageName.toLowerCase() );
				d=d.replaceAll("%comment%", comment);
				out.write(d);
			
				List<ColumnModel> cols=DBUtil.getTableColumns(IbatisToolAction.conn, selections[i], IbatisToolAction.mapend);

				for(int k=0;k<cols.size();k++){
					ColumnModel cm=cols.get(k);
					String[] cns=cm.getName().split(Config.columnSplit);
					StringBuffer cnsb=new StringBuffer();
					if(cns.length==1){
						cnsb.append(Config.isToLower?cm.getName().toLowerCase():cm.getName());
					}else{
						for (int l=0;l<cns.length;l++) {
							if(l==0){
								cnsb.append(cns[0].substring(0, 1).toLowerCase()+cns[0].substring(1).toLowerCase());
							}else{
								cnsb.append(cns[l].substring(0, 1).toUpperCase()+cns[l].substring(1).toLowerCase());
							}
						}
					}
					String columnName=cnsb.toString();
					String isPri="";
					if(cm.isPrimaryKey())
						isPri="主键";
					out.write("\t/** "+cm.getComment()+" "+isPri+"**/\r\n");
					out.write("\tprivate "+cm.getType()+" "+columnName+";\r\n");
				}
				for(int k=0;k<cols.size();k++){
					ColumnModel cm=cols.get(k);
					String[] cns=cm.getName().split(Config.columnSplit);
					StringBuffer cnsb=new StringBuffer();
					if(cns.length==1){
						cnsb.append(Config.isToLower?cm.getName().toLowerCase():cm.getName());
					}else{
						for (int l=0;l<cns.length;l++) {
							if(l==0){
								cnsb.append(cns[0].substring(0, 1).toLowerCase()+cns[0].substring(1).toLowerCase());
							}else{
								cnsb.append(cns[l].substring(0, 1).toUpperCase()+cns[l].substring(1).toLowerCase());
							}
						}
					}
					String columnName=cnsb.toString();
					out.write("\tpublic void set"+columnName.substring(0, 1).toUpperCase()+columnName.substring(1)+"("+cm.getType()+" "+columnName+"){\r\n");
					out.write("\t\tthis."+columnName+"="+columnName+";\r\n");
					out.write("\t}\r\n");
					out.write("\tpublic "+cm.getType()+" get"+columnName.substring(0, 1).toUpperCase()+columnName.substring(1)+"(){\r\n");
					out.write("\t\treturn "+columnName+";\r\n");
					out.write("\t}\r\n");
				}
				out.write("}\r\n");
				out.flush();
				out.close();

				file=new File(search+"\\"+className+"SearchBean.java");
				if(file.exists())
					file.delete();
				out= new OutputStreamWriter(new FileOutputStream(file),Config.encoding);
				d=codeTemplateStr.getSearchBeanStr().replaceAll("%TableName%", className);
				d = d.replaceAll("%PackageName%", packageName.toLowerCase());
				d = d.replaceAll("%public%", commonPackage);
				StringBuffer fileds=new StringBuffer();
				StringBuffer methods=new StringBuffer();
				StringBuffer searchfileds=new StringBuffer();
				if(Config.daoType.equals("ibatis")){
					searchfileds.append("\t<dynamic prepend=\"where \">\r\n");
				}else if(Config.daoType.equals("mybatis")){
					searchfileds.append("\t<where>\r\n");
				}
				StringBuffer condition=new StringBuffer();
				if(Config.daoType.equals("ibatis")){
					condition.append("\t<dynamic prepend=\"where \">\r\n");
				}else if(Config.daoType.equals("mybatis")){
					condition.append("\t<where>\r\n");
				}
				String equals="equals";
				String noEquals="noEquals";
				String isNotNull="isNotNull";
				String in="in";
				String notIn="notIn";
				String greater="greater";
				String greaterEquals="greaterEquals";
				String less="less";
				String lessEquals="lessEquals";
				String like="like";
				String leftLike="leftLike";
				String rightLike="rightLike";
				for(int k=0;k<cols.size();k++){
					ColumnModel cm=cols.get(k);
					String[] cns=cm.getName().split(Config.columnSplit);
					StringBuffer cnsb=new StringBuffer();
					if(cns.length==1){
						cnsb.append(Config.isToLower?cm.getName().toLowerCase():cm.getName());
					}else{
						for (int l=0;l<cns.length;l++) {
							if(l==0){
								cnsb.append(cns[0].substring(0, 1).toLowerCase()+cns[0].substring(1).toLowerCase());
							}else{
								cnsb.append(cns[l].substring(0, 1).toUpperCase()+cns[l].substring(1).toLowerCase());
							}
						}
					}
					String caseName=cnsb.toString();
					String fliedName=caseName.substring(0, 1).toUpperCase()+caseName.substring(1);
					String isPri="";
					if(cm.isPrimaryKey()){
						isPri="主键";
			            fileds.append("/** 原始属性" + cm.getComment() + " " + isPri + "**/\r\n");
			            fileds.append("\tprivate " + cm.getType() + " " + caseName + ";\r\n");
			            fileds.append("\tprivate " + cm.getType() + " " + noEquals + fliedName + ";\r\n");
			            fileds.append("\t/** In" + cm.getComment() + " " + isPri + "**/\r\n");
			            fileds.append("\tprivate List<" + cm.getType() + "> " + in + fliedName + ";\r\n");
			            fileds.append("\t/** NotIn" + cm.getComment() + " " + isPri + "**/\r\n");
			            fileds.append("\tprivate List<" + cm.getType() + "> " + notIn + fliedName + ";\r\n");
			            methods.append("public void set" + fliedName + "(" + cm.getType() + " " + caseName + "){\r\n");
			            methods.append("\t\tthis." + caseName + "=" + caseName + ";\r\n");
			            methods.append("\t}\r\n");
			            methods.append("\tpublic " + cm.getType() + " get" + fliedName + "(){\r\n");
			            methods.append("\t\treturn " + caseName + ";\r\n");
			            methods.append("\t}\r\n");
			            methods.append("\tpublic void set" + noEquals.substring(0, 1).toUpperCase() + noEquals.substring(1) + fliedName + "(" + cm.getType() + " " + noEquals + fliedName + "){\r\n");
			            methods.append("\t\tthis." + noEquals + fliedName + "=" + noEquals + fliedName + ";\r\n");
			            methods.append("\t}\r\n");
			            methods.append("\tpublic " + cm.getType() + " get" + noEquals.substring(0, 1).toUpperCase() + noEquals.substring(1) + fliedName + "(){\r\n");
			            methods.append("\t\treturn " + noEquals + fliedName + ";\r\n");
			            methods.append("\t}\r\n");
			            methods.append("\tpublic void set" + in.substring(0, 1).toUpperCase() + in.substring(1) + fliedName + "(List<" + cm.getType() + "> " + in + fliedName + "){\r\n");
			            methods.append("\t\tthis." + in + fliedName + "=" + in + fliedName + ";\r\n");
			            methods.append("\t}\r\n");
			            methods.append("\tpublic List<" + cm.getType() + "> get" + in.substring(0, 1).toUpperCase() + in.substring(1) + fliedName + "(){\r\n");
			            methods.append("\t\treturn " + in + fliedName + ";\r\n");
			            methods.append("\t}\r\n");
			            methods.append("\tpublic void set" + notIn.substring(0, 1).toUpperCase() + notIn.substring(1) + fliedName + "(List<" + cm.getType() + "> " + notIn + fliedName + "){\r\n");
			            methods.append("\t\tthis." + notIn + fliedName + "=" + notIn + fliedName + ";\r\n");
			            methods.append("\t}\r\n");
			            methods.append("\tpublic List<" + cm.getType() + "> get" + notIn.substring(0, 1).toUpperCase() + notIn.substring(1) + fliedName + "(){\r\n");
			            methods.append("\t\treturn " + notIn + fliedName + ";\r\n");
			            methods.append("\t}\r\n");
						if(Config.daoType.equals("ibatis")){
							searchfileds.append("\t\t<isPropertyAvailable property=\""+caseName+"\">\r\n");
							searchfileds.append("\t\t\t<isNotNull property=\""+caseName+"\" prepend=\" and \">\r\n");
							searchfileds.append("\t\t\t\t").append(cm.getName()).append("=#").append(caseName).append("#\r\n");
							searchfileds.append("\t\t\t</isNotNull>\r\n");
							searchfileds.append("\t\t</isPropertyAvailable>\r\n");
							condition.append("\t\t<isPropertyAvailable property=\""+caseName+"\">\r\n");
							condition.append("\t\t\t<isNotNull property=\""+caseName+"\" prepend=\" and \">\r\n");
							condition.append("\t\t\t\t").append(cm.getName()).append("=#").append(caseName).append("#\r\n");
							condition.append("\t\t\t</isNotNull>\r\n");
							condition.append("\t\t</isPropertyAvailable>\r\n");
						}else if(Config.daoType.equals("mybatis")){
				              searchfileds.append("\t\t<if test=\"" + caseName + "!=null\">\r\n");
				              searchfileds.append("\t\t\t and ").append(cm.getName()).append("=#{").append(caseName).append(",jdbcType=").append(cm.getJdbcType()).append("}\r\n");
				              searchfileds.append("\t\t</if>\r\n");
				              condition.append("\t\t<if test=\"" + caseName + "!=null\">\r\n");
				              condition.append("\t\t\t and ").append(cm.getName()).append("=#{").append(caseName).append(",jdbcType=").append(cm.getJdbcType()).append("}\r\n");
				              condition.append("\t\t</if>\r\n");
				              StringBuffer tmp = new StringBuffer();
				              tmp.append("\t\t<if test=\"" + noEquals + fliedName + "!=null\">\r\n");
				              tmp.append("\t\t\t and ").append(cm.getName()).append("<![CDATA[<>]]>#{").append(noEquals).append(fliedName).append(",jdbcType=").append(cm.getJdbcType()).append("}\r\n");
				              tmp.append("\t\t</if>\r\n");

				              tmp = new StringBuffer();
				              tmp.append("\t\t<if test=\"" + in + fliedName + "!=null\">\r\n");
				              tmp.append("\t\t\t and ").append(cm.getName()).append(" in\r\n");
				              tmp.append("\t\t\t<foreach collection=\"" + in + fliedName + "\" index=\"index\" item=\"" + in + fliedName + "\" open=\"(\" separator=\",\" close=\")\">\r\n");
				              tmp.append("\t\t\t\t#{").append(in).append(fliedName).append("}\r\n");
				              tmp.append("\t\t\t</foreach>\r\n");
				              tmp.append("\t\t</if>\r\n");
				              searchfileds.append(tmp);
				              condition.append(tmp);

				              tmp = new StringBuffer();
				              tmp.append("\t\t<if test=\"" + notIn + fliedName + "!=null\">\r\n");
				              tmp.append("\t\t\t and ").append(cm.getName()).append(" not in\r\n");
				              tmp.append("\t\t\t<foreach collection=\"" + notIn + fliedName + "\" index=\"index\" item=\"" + notIn + fliedName + "\" open=\"(\" separator=\",\" close=\")\">\r\n");
				              tmp.append("\t\t\t\t#{").append(notIn).append(fliedName).append("}\r\n");
				              tmp.append("\t\t\t</foreach>\r\n");
				              tmp.append("\t\t</if>\r\n");
				              searchfileds.append(tmp);
				              condition.append(tmp);
						}

					}else{
						fileds.append("\t/** 原始属性"+cm.getComment()+" "+isPri+"**/\r\n");
						fileds.append("\tprivate "+cm.getType()+" "+caseName+";\r\n");
						fileds.append("\t/** 等于"+cm.getComment()+" "+isPri+"**/\r\n");
						fileds.append("\tprivate "+cm.getType()+" "+equals+fliedName+";\r\n");

						methods.append("\tpublic void set"+fliedName+"("+cm.getType()+" "+caseName+"){\r\n");
						methods.append("\t\tthis."+caseName+"="+caseName+";\r\n");
						methods.append("\t}\r\n");
						methods.append("\tpublic "+cm.getType()+" get"+fliedName+"(){\r\n");
						methods.append("\t\treturn "+caseName+";\r\n");
						methods.append("\t}\r\n");
						methods.append("\tpublic void set"+equals.substring(0,1).toUpperCase()+equals.substring(1)+fliedName+"("+cm.getType()+" "+equals+fliedName+"){\r\n");
						methods.append("\t\tthis."+equals+fliedName+"="+equals+fliedName+";\r\n");
						methods.append("\t}\r\n");
						methods.append("\tpublic "+cm.getType()+" get"+equals.substring(0,1).toUpperCase()+equals.substring(1)+fliedName+"(){\r\n");
						methods.append("\t\treturn "+equals+fliedName+";\r\n");
						methods.append("\t}\r\n");

						if(Config.daoType.equals("ibatis")){
							searchfileds.append("\t\t<isPropertyAvailable property=\""+caseName+"\">\r\n");
							searchfileds.append("\t\t\t<isNotNull property=\""+caseName+"\" prepend=\" and \">\r\n");
							searchfileds.append("\t\t\t\t").append(cm.getName()).append("=#").append(caseName).append("#\r\n");
							searchfileds.append("\t\t\t</isNotNull>\r\n");
							searchfileds.append("\t\t</isPropertyAvailable>\r\n");
						}else if(Config.daoType.equals("mybatis")){
				              if (cm.getType().equals("String")) {
				                  searchfileds.append("\t\t<if test=\"" + caseName + "!=null and " + caseName + "!=''\">\r\n");
				                } else {
				                  searchfileds.append("\t\t<if test=\"" + caseName + "!=null\">\r\n");
				                }
				                searchfileds.append("\t\t\t and ").append(cm.getName()).append("=#{").append(caseName).append(",jdbcType=").append(cm.getJdbcType()).append("}\r\n");
				                searchfileds.append("\t\t</if>\r\n");
						}

						//is not null
						fileds.append("\t/** 是否为空"+cm.getComment()+" "+isPri+"**/\r\n");
						fileds.append("\tprivate Boolean "+isNotNull+fliedName+";\r\n");

						fileds.append("\t/** In"+cm.getComment()+" "+isPri+"**/\r\n");
						fileds.append("\tprivate List<"+cm.getType()+"> "+in+fliedName+";\r\n");
						fileds.append("\t/** NotIn"+cm.getComment()+" "+isPri+"**/\r\n");
						fileds.append("\tprivate List<"+cm.getType()+"> "+notIn+fliedName+";\r\n");

						fileds.append("\t/** 不等于"+cm.getComment()+" "+isPri+"**/\r\n");
						fileds.append("\tprivate "+cm.getType()+" "+noEquals+fliedName+";\r\n");
						fileds.append("\t/** 大于"+cm.getComment()+" "+isPri+"**/\r\n");
						fileds.append("\tprivate "+cm.getType()+" "+greater+fliedName+";\r\n");
						fileds.append("\t/** 大于等于"+cm.getComment()+" "+isPri+"**/\r\n");
						fileds.append("\tprivate "+cm.getType()+" "+greaterEquals+fliedName+";\r\n");
						fileds.append("\t/** 小于"+cm.getComment()+" "+isPri+"**/\r\n");
						fileds.append("\tprivate "+cm.getType()+" "+less+fliedName+";\r\n");
						fileds.append("\t/** 小于等于"+cm.getComment()+" "+isPri+"**/\r\n");
						fileds.append("\tprivate "+cm.getType()+" "+lessEquals+fliedName+";\r\n");


						methods.append("\tpublic void set"+isNotNull.substring(0,1).toUpperCase()+isNotNull.substring(1)+fliedName+"(Boolean "+isNotNull+fliedName+"){\r\n");
						methods.append("\t\tthis."+isNotNull+fliedName+"="+isNotNull+fliedName+";\r\n");
						methods.append("\t}\r\n");
						methods.append("\tpublic Boolean get"+isNotNull.substring(0,1).toUpperCase()+isNotNull.substring(1)+fliedName+"(){\r\n");
						methods.append("\t\treturn "+isNotNull+fliedName+";\r\n");
						methods.append("\t}\r\n");

						methods.append("\tpublic void set"+in.substring(0,1).toUpperCase()+in.substring(1)+fliedName+"(List<"+cm.getType()+"> "+in+fliedName+"){\r\n");
						methods.append("\t\tthis."+in+fliedName+"="+in+fliedName+";\r\n");
						methods.append("\t}\r\n");
						methods.append("\tpublic List<"+cm.getType()+"> get"+in.substring(0,1).toUpperCase()+in.substring(1)+fliedName+"(){\r\n");
						methods.append("\t\treturn "+in+fliedName+";\r\n");
						methods.append("\t}\r\n");
						methods.append("\tpublic void set"+notIn.substring(0,1).toUpperCase()+notIn.substring(1)+fliedName+"(List<"+cm.getType()+"> "+notIn+fliedName+"){\r\n");
						methods.append("\t\tthis."+notIn+fliedName+"="+notIn+fliedName+";\r\n");
						methods.append("\t}\r\n");
						methods.append("\tpublic List<"+cm.getType()+"> get"+notIn.substring(0,1).toUpperCase()+notIn.substring(1)+fliedName+"(){\r\n");
						methods.append("\t\treturn "+notIn+fliedName+";\r\n");
						methods.append("\t}\r\n");
						methods.append("\tpublic void set"+noEquals.substring(0,1).toUpperCase()+noEquals.substring(1)+fliedName+"("+cm.getType()+" "+noEquals+fliedName+"){\r\n");
						methods.append("\t\tthis."+noEquals+fliedName+"="+noEquals+fliedName+";\r\n");
						methods.append("\t}\r\n");
						methods.append("\tpublic "+cm.getType()+" get"+noEquals.substring(0,1).toUpperCase()+noEquals.substring(1)+fliedName+"(){\r\n");
						methods.append("\t\treturn "+noEquals+fliedName+";\r\n");
						methods.append("\t}\r\n");
						methods.append("\tpublic void set"+greater.substring(0,1).toUpperCase()+greater.substring(1)+fliedName+"("+cm.getType()+" "+greater+fliedName+"){\r\n");
						methods.append("\t\tthis."+greater+fliedName+"="+greater+fliedName+";\r\n");
						methods.append("\t}\r\n");
						methods.append("\tpublic "+cm.getType()+" get"+greater.substring(0,1).toUpperCase()+greater.substring(1)+fliedName+"(){\r\n");
						methods.append("\t\treturn "+greater+fliedName+";\r\n");
						methods.append("\t}\r\n");
						methods.append("\tpublic void set"+greaterEquals.substring(0,1).toUpperCase()+greaterEquals.substring(1)+fliedName+"("+cm.getType()+" "+greaterEquals+fliedName+"){\r\n");
						methods.append("\t\tthis."+greaterEquals+fliedName+"="+greaterEquals+fliedName+";\r\n");
						methods.append("\t}\r\n");
						methods.append("\tpublic "+cm.getType()+" get"+greaterEquals.substring(0,1).toUpperCase()+greaterEquals.substring(1)+fliedName+"(){\r\n");
						methods.append("\t\treturn "+greaterEquals+fliedName+";\r\n");
						methods.append("\t}\r\n");
						methods.append("\tpublic void set"+less.substring(0,1).toUpperCase()+less.substring(1)+fliedName+"("+cm.getType()+" "+less+fliedName+"){\r\n");
						methods.append("\t\tthis."+less+fliedName+"="+less+fliedName+";\r\n");
						methods.append("\t}\r\n");
						methods.append("\tpublic "+cm.getType()+" get"+less.substring(0,1).toUpperCase()+less.substring(1)+fliedName+"(){\r\n");
						methods.append("\t\treturn "+less+fliedName+";\r\n");
						methods.append("\t}\r\n");
						methods.append("\tpublic void set"+lessEquals.substring(0,1).toUpperCase()+lessEquals.substring(1)+fliedName+"("+cm.getType()+" "+lessEquals+fliedName+"){\r\n");
						methods.append("\t\tthis."+lessEquals+fliedName+"="+lessEquals+fliedName+";\r\n");
						methods.append("\t}\r\n");
						methods.append("\tpublic "+cm.getType()+" get"+lessEquals.substring(0,1).toUpperCase()+lessEquals.substring(1)+fliedName+"(){\r\n");
						methods.append("\t\treturn "+lessEquals+fliedName+";\r\n");
						methods.append("\t}\r\n");
						StringBuffer tmp=null;
						if(Config.daoType.equals("ibatis")){

							{
								//is not null or is null
								tmp=new StringBuffer();
								tmp.append("\t\t<isPropertyAvailable property=\""+isNotNull+fliedName+"\">\r\n");
								tmp.append("\t\t\t<isNotNull property=\""+isNotNull+fliedName+"\" prepend=\" and \">\r\n");
								tmp.append("\t\t\t\t<isEqual property=\""+isNotNull+fliedName+"\" compareValue=\"true\">\r\n");
								tmp.append("\t\t\t\t\t").append(cm.getName()).append(" is not null\r\n");
								tmp.append("\t\t\t\t</isEqual>\r\n");
								tmp.append("\t\t\t\t<isEqual property=\""+isNotNull+fliedName+"\" compareValue=\"false\">\r\n");
								tmp.append("\t\t\t\t\t").append(cm.getName()).append(" is null\r\n");
								tmp.append("\t\t\t\t</isEqual>\r\n");
								tmp.append("\t\t\t</isNotNull>\r\n");
								tmp.append("\t\t</isPropertyAvailable>\r\n");
								searchfileds.append(tmp);
								condition.append(tmp);
							}
							{
								//in
								tmp=new StringBuffer();
								tmp.append("\t\t<isPropertyAvailable property=\""+in+fliedName+"\">\r\n");
								tmp.append("\t\t\t<isNotNull>\r\n");
								tmp.append("\t\t\t\t<isNotEmpty property=\""+in+fliedName+"\" prepend=\" and \">\r\n");
								tmp.append("\t\t\t\t\t").append(cm.getName()).append(" in \r\n");
								tmp.append("\t\t\t\t\t").append("<iterate property=\""+in+fliedName+"\" conjunction=\",\" open=\"(\" close=\")\">\r\n");
								tmp.append("\t\t\t\t\t\t").append("#").append(in).append(fliedName).append("[]#\r\n");
								tmp.append("\t\t\t\t\t").append("</iterate>\r\n");
								tmp.append("\t\t\t\t</isNotEmpty>\r\n");
								tmp.append("\t\t\t</isNotNull>\r\n");
								tmp.append("\t\t</isPropertyAvailable>\r\n");
								searchfileds.append(tmp);
								condition.append(tmp);
							}
							{
								//not in
								tmp=new StringBuffer();
								tmp.append("\t\t<isPropertyAvailable property=\""+notIn+fliedName+"\">\r\n");
								tmp.append("\t\t\t<isNotNull>\r\n");
								tmp.append("\t\t\t\t<isNotEmpty property=\""+notIn+fliedName+"\" prepend=\" and \">\r\n");
								tmp.append("\t\t\t\t\t").append(cm.getName()).append(" not in \r\n");
								tmp.append("\t\t\t\t\t").append("<iterate property=\""+notIn+fliedName+"\" conjunction=\",\" open=\"(\" close=\")\">\r\n");
								tmp.append("\t\t\t\t\t\t").append("#").append(notIn).append(fliedName).append("[]#\r\n");
								tmp.append("\t\t\t\t\t").append("</iterate>\r\n");
								tmp.append("\t\t\t\t</isNotEmpty>\r\n");
								tmp.append("\t\t\t</isNotNull>\r\n");
								tmp.append("\t\t</isPropertyAvailable>\r\n");
								searchfileds.append(tmp);
								condition.append(tmp);
							}
							{
								//<>
								tmp=new StringBuffer();
								tmp.append("\t\t<isPropertyAvailable property=\""+noEquals+fliedName+"\">\r\n");
								tmp.append("\t\t\t<isNotNull property=\""+noEquals+fliedName+"\" prepend=\" and \">\r\n");
								tmp.append("\t\t\t\t").append(cm.getName()).append("<![CDATA[<>]]>#").append(noEquals+fliedName).append("#\r\n");
								tmp.append("\t\t\t</isNotNull>\r\n");
								tmp.append("\t\t</isPropertyAvailable>\r\n");
								searchfileds.append(tmp);
								condition.append(tmp);
							}
							{
								//=
								tmp=new StringBuffer();
								tmp.append("\t\t<isPropertyAvailable property=\""+equals+fliedName+"\">\r\n");
								tmp.append("\t\t\t<isNotNull property=\""+equals+fliedName+"\" prepend=\" and \">\r\n");
								tmp.append("\t\t\t\t").append(cm.getName()).append("=#").append(equals+fliedName).append("#\r\n");
								tmp.append("\t\t\t</isNotNull>\r\n");
								tmp.append("\t\t</isPropertyAvailable>\r\n");
								searchfileds.append(tmp);
								condition.append(tmp);
							}
							{
//							searchfileds.append("\t\t<isPropertyAvailable property=\""+noEquals+fliedName+"\">\r\n");
//							searchfileds.append("\t\t\t<isNotNull property=\""+noEquals+fliedName+"\" prepend=\" and \">\r\n");
//							searchfileds.append("\t\t\t\t").append(cm.getName()).append("<![CDATA[<>]]>#").append(noEquals+fliedName).append("#\r\n");
//							searchfileds.append("\t\t\t</isNotNull>\r\n");
//							searchfileds.append("\t\t</isPropertyAvailable>\r\n");
							}
							{
								//>
								tmp=new StringBuffer();
								tmp.append("\t\t<isPropertyAvailable property=\""+greater+fliedName+"\">\r\n");
								tmp.append("\t\t\t<isNotNull property=\""+greater+fliedName+"\" prepend=\" and \">\r\n");
								tmp.append("\t\t\t\t").append(cm.getName()).append("<![CDATA[>]]>#").append(greater+fliedName).append("#\r\n");
								tmp.append("\t\t\t</isNotNull>\r\n");
								tmp.append("\t\t</isPropertyAvailable>\r\n");
								searchfileds.append(tmp);
								condition.append(tmp);
							}
							{
								//>=
								tmp=new StringBuffer();
								tmp.append("\t\t<isPropertyAvailable property=\""+greaterEquals+fliedName+"\">\r\n");
								tmp.append("\t\t\t<isNotNull property=\""+greaterEquals+fliedName+"\" prepend=\" and \">\r\n");
								tmp.append("\t\t\t\t").append(cm.getName()).append("<![CDATA[>]]>=#").append(greaterEquals+fliedName).append("#\r\n");
								tmp.append("\t\t\t</isNotNull>\r\n");
								tmp.append("\t\t</isPropertyAvailable>\r\n");
								searchfileds.append(tmp);
								condition.append(tmp);
							}
							{
								//<
								tmp=new StringBuffer();
								tmp.append("\t\t<isPropertyAvailable property=\""+less+fliedName+"\">\r\n");
								tmp.append("\t\t\t<isNotNull property=\""+less+fliedName+"\" prepend=\" and \">\r\n");
								tmp.append("\t\t\t\t").append(cm.getName()).append("<![CDATA[<]]>#").append(less+fliedName).append("#\r\n");
								tmp.append("\t\t\t</isNotNull>\r\n");
								tmp.append("\t\t</isPropertyAvailable>\r\n");
								searchfileds.append(tmp);
								condition.append(tmp);
							}
							{
								//<=
								tmp=new StringBuffer();
								tmp.append("\t\t<isPropertyAvailable property=\""+lessEquals+fliedName+"\">\r\n");
								tmp.append("\t\t\t<isNotNull property=\""+lessEquals+fliedName+"\" prepend=\" and \">\r\n");
								tmp.append("\t\t\t\t").append(cm.getName()).append("<![CDATA[<]]>=#").append(lessEquals+fliedName).append("#\r\n");
								tmp.append("\t\t\t</isNotNull>\r\n");
								tmp.append("\t\t</isPropertyAvailable>\r\n");
								searchfileds.append(tmp);
								condition.append(tmp);
							}
						}else if(Config.daoType.equals("mybatis")){
							{
								tmp=new StringBuffer();
								tmp.append("\t\t<if test=\""+isNotNull+fliedName+"!=null and "+isNotNull+fliedName+"==true\">\r\n");
								tmp.append("\t\t\t and ").append(cm.getName()).append(" is not null\r\n");
								tmp.append("\t\t</if>\r\n");
								tmp.append("\t\t<if test=\""+isNotNull+fliedName+"!=null and "+isNotNull+fliedName+"==false\">\r\n");
								tmp.append("\t\t\t and ").append(cm.getName()).append(" is null\r\n");
								tmp.append("\t\t</if>\r\n");
								searchfileds.append(tmp);
								condition.append(tmp);
							}
							{
								tmp=new StringBuffer();
								tmp.append("\t\t<if test=\""+in+fliedName+"!=null\">\r\n");
								tmp.append("\t\t\t and ").append(cm.getName()).append(" in\r\n");
								tmp.append("\t\t\t<foreach collection=\"" + in + fliedName + "\" index=\"index\" item=\"" + in + fliedName + "\" open=\"(\" separator=\",\" close=\")\">\r\n");
								tmp.append("\t\t\t\t#{").append(in).append(fliedName).append("}\r\n");
								tmp.append("\t\t\t</foreach>\r\n");
								tmp.append("\t\t</if>\r\n");
								searchfileds.append(tmp);
								condition.append(tmp);
							}
							{
								tmp=new StringBuffer();
								tmp.append("\t\t<if test=\""+notIn+fliedName+"!=null\">\r\n");
								tmp.append("\t\t\t and ").append(cm.getName()).append(" not in\r\n");
								tmp.append("\t\t\t<foreach collection=\"" + notIn + fliedName + "\" index=\"index\" item=\"" + notIn + fliedName + "\" open=\"(\" separator=\",\" close=\")\">\r\n");
								tmp.append("\t\t\t\t#{").append(notIn).append(fliedName).append("}\r\n");
								tmp.append("\t\t\t</foreach>\r\n");
								tmp.append("\t\t</if>\r\n");
								searchfileds.append(tmp);
								condition.append(tmp);
							}

							{
								tmp=new StringBuffer();
								tmp.append("\t\t<if test=\""+noEquals+fliedName+"!=null\">\r\n");
								tmp.append("\t\t\t and ").append(cm.getName()).append("<![CDATA[<>]]>#{").append(noEquals).append(fliedName).append(",jdbcType=").append(cm.getJdbcType()).append("}\r\n");
								tmp.append("\t\t</if>\r\n");
								searchfileds.append(tmp);
								condition.append(tmp);
							}

							{
								tmp=new StringBuffer();
								tmp.append("\t\t<if test=\""+equals+fliedName+"!=null\">\r\n");
								tmp.append("\t\t\t and ").append(cm.getName()).append("=#{").append(equals).append(fliedName).append(",jdbcType=").append(cm.getJdbcType()).append("}\r\n");
								tmp.append("\t\t</if>\r\n");
								searchfileds.append(tmp);
								condition.append(tmp);
							}

							{
								tmp=new StringBuffer();
								tmp.append("\t\t<if test=\""+greater+fliedName+"!=null\">\r\n");
								tmp.append("\t\t\t and ").append(cm.getName()).append("<![CDATA[>]]>#{").append(greater).append(fliedName).append(",jdbcType=").append(cm.getJdbcType()).append("}\r\n");
								tmp.append("\t\t</if>\r\n");
								searchfileds.append(tmp);
								condition.append(tmp);
							}
							{
								tmp=new StringBuffer();
								tmp.append("\t\t<if test=\""+greaterEquals+fliedName+"!=null\">\r\n");
								tmp.append("\t\t\t and ").append(cm.getName()).append("<![CDATA[>=]]>#{").append(greaterEquals).append(fliedName).append(",jdbcType=").append(cm.getJdbcType()).append("}\r\n");
								tmp.append("\t\t</if>\r\n");
								searchfileds.append(tmp);
								condition.append(tmp);
							}
							{
								tmp=new StringBuffer();
								tmp.append("\t\t<if test=\""+less+fliedName+"!=null\">\r\n");
								tmp.append("\t\t\t and ").append(cm.getName()).append("<![CDATA[<]]>#{").append(less).append(fliedName).append(",jdbcType=").append(cm.getJdbcType()).append("}\r\n");
								tmp.append("\t\t</if>\r\n");
								searchfileds.append(tmp);
								condition.append(tmp);
							}
							{
								tmp=new StringBuffer();
								tmp.append("\t\t<if test=\""+lessEquals+fliedName+"!=null\">\r\n");
								tmp.append("\t\t\t and ").append(cm.getName()).append("<![CDATA[<=]]>#{").append(lessEquals).append(fliedName).append(",jdbcType=").append(cm.getJdbcType()).append("}\r\n");
								tmp.append("\t\t</if>\r\n");
								searchfileds.append(tmp);
								condition.append(tmp);
							}
						}


						if(cm.getType().equals("String")){
							fileds.append("\t/** Like"+cm.getComment()+" "+isPri+"**/\r\n");
							fileds.append("\tprivate "+cm.getType()+" "+like+fliedName+";\r\n");
							fileds.append("\t/** Like左匹配"+cm.getComment()+" "+isPri+"**/\r\n");
							fileds.append("\tprivate "+cm.getType()+" "+leftLike+fliedName+";\r\n");
							fileds.append("\t/** Like右匹配"+cm.getComment()+" "+isPri+"**/\r\n");
							fileds.append("\tprivate "+cm.getType()+" "+rightLike+fliedName+";\r\n");

							methods.append("\tpublic void set"+like.substring(0,1).toUpperCase()+like.substring(1)+fliedName+"("+cm.getType()+" "+like+fliedName+"){\r\n");
							methods.append("\t\tthis."+like+fliedName+"="+like+fliedName+";\r\n");
							methods.append("\t}\r\n");
							methods.append("\tpublic "+cm.getType()+" get"+like.substring(0,1).toUpperCase()+like.substring(1)+fliedName+"(){\r\n");
							methods.append("\t\treturn "+like+fliedName+";\r\n");
							methods.append("\t}\r\n");
							methods.append("\tpublic void set"+leftLike.substring(0,1).toUpperCase()+leftLike.substring(1)+fliedName+"("+cm.getType()+" "+leftLike+fliedName+"){\r\n");
							methods.append("\t\tthis."+leftLike+fliedName+"="+like+fliedName+";\r\n");
							methods.append("\t}\r\n");
							methods.append("\tpublic "+cm.getType()+" get"+leftLike.substring(0,1).toUpperCase()+leftLike.substring(1)+fliedName+"(){\r\n");
							methods.append("\t\treturn "+leftLike+fliedName+";\r\n");
							methods.append("\t}\r\n");
							methods.append("\tpublic void set"+rightLike.substring(0,1).toUpperCase()+rightLike.substring(1)+fliedName+"("+cm.getType()+" "+rightLike+fliedName+"){\r\n");
							methods.append("\t\tthis."+rightLike+fliedName+"="+rightLike+fliedName+";\r\n");
							methods.append("\t}\r\n");
							methods.append("\tpublic "+cm.getType()+" get"+rightLike.substring(0,1).toUpperCase()+rightLike.substring(1)+fliedName+"(){\r\n");
							methods.append("\t\treturn "+rightLike+fliedName+";\r\n");
							methods.append("\t}\r\n");
							if(Config.daoType.equals("ibatis")){
								tmp=new StringBuffer();
								tmp.append("\t\t<isPropertyAvailable property=\""+like+fliedName+"\">\r\n");
								tmp.append("\t\t\t<isNotNull property=\""+like+fliedName+"\" prepend=\" and \">\r\n");
								tmp.append("\t\t\t\t").append(cm.getName()).append(" like '%$").append(like+fliedName).append("$%'\r\n");
								tmp.append("\t\t\t</isNotNull>\r\n");
								tmp.append("\t\t</isPropertyAvailable>\r\n");
								tmp.append("\t\t<isPropertyAvailable property=\""+leftLike+fliedName+"\">\r\n");
								tmp.append("\t\t\t<isNotNull property=\""+leftLike+fliedName+"\" prepend=\" and \">\r\n");
								tmp.append("\t\t\t\t").append(cm.getName()).append(" like '%$").append(leftLike+fliedName).append("$'\r\n");
								tmp.append("\t\t\t</isNotNull>\r\n");
								tmp.append("\t\t</isPropertyAvailable>\r\n");
								tmp.append("\t\t<isPropertyAvailable property=\""+rightLike+fliedName+"\">\r\n");
								tmp.append("\t\t\t<isNotNull property=\""+rightLike+fliedName+"\" prepend=\" and \">\r\n");
								tmp.append("\t\t\t\t").append(cm.getName()).append(" like '$").append(rightLike+fliedName).append("$%'\r\n");
								tmp.append("\t\t\t</isNotNull>\r\n");
								tmp.append("\t\t</isPropertyAvailable>\r\n");
								searchfileds.append(tmp);
								condition.append(tmp);
							}else if(Config.daoType.equals("mybatis")){
				                tmp = new StringBuffer();
				                tmp.append("\t\t<if test=\"" + like + fliedName + "!=null and " + like + fliedName + "!=''\">\r\n");
				                tmp.append("\t\t\t and ").append(cm.getName()).append(" like \"%\"#{").append(like).append(fliedName).append(",jdbcType=").append(cm.getJdbcType()).append("}\"%\"\r\n");
				                tmp.append("\t\t</if>\r\n");
				                tmp.append("\t\t<if test=\"" + leftLike + fliedName + "!=null and " + leftLike + fliedName + "!=''\">\r\n");
				                tmp.append("\t\t\t and ").append(cm.getName()).append(" like \"%\"#{").append(leftLike).append(fliedName).append(",jdbcType=").append(cm.getJdbcType()).append("}\r\n");
				                tmp.append("\t\t</if>\r\n");
				                tmp.append("\t\t<if test=\"" + rightLike + fliedName + "!=null and " + rightLike + fliedName + "!=''\">\r\n");
				                tmp.append("\t\t\t and ").append(cm.getName()).append(" like #{").append(rightLike).append(fliedName).append(",jdbcType=").append(cm.getJdbcType()).append("}\"%\"\r\n");
				                tmp.append("\t\t</if>\r\n");
				                searchfileds.append(tmp);
				                condition.append(tmp);
							}

						}
					}
				}
				d=d.replace("%FILEDS%", fileds.toString());
				d=d.replace("%METHODS%", methods.toString());
				out.write(d);
				out.flush();
				out.close();

				file=new File(maps+"\\"+className+".xml");
				if(file.exists())
					file.delete();
				out = new OutputStreamWriter(new FileOutputStream(file),Config.encoding);
				StringBuffer sbCols=new StringBuffer();
				StringBuffer sbTypes=new StringBuffer();
		        StringBuffer keyGen = new StringBuffer();
		        StringBuffer selectKey = new StringBuffer();
				StringBuffer updateStr=new StringBuffer();
				StringBuffer dynamicUpdateStr=new StringBuffer();
				StringBuffer dynamicStr=new StringBuffer();
				if(Config.daoType.equals("ibatis")){
					dynamicUpdateStr.append("\t<dynamic prepend=\"set \">\r\n");
					dynamicStr.append("\t<dynamic prepend=\"where \">\r\n");
				}else if(Config.daoType.equals("mybatis")){
					dynamicUpdateStr.append("\t<set>\r\n");
					dynamicStr.append("\t<where>\r\n");
				}
				StringBuffer resultMapStr=new StringBuffer("\t");
				for(int f=0;f<cols.size();f++){
					ColumnModel cm=cols.get(f);
					String[] cns=cm.getName().split(Config.columnSplit);
					StringBuffer cnsb=new StringBuffer();
					if(cns.length==1){
						cnsb.append(Config.isToLower?cm.getName().toLowerCase():cm.getName());
					}else{
						for (int l=0;l<cns.length;l++) {
							if(l==0){
								cnsb.append(cns[0].substring(0, 1).toLowerCase()+cns[0].substring(1).toLowerCase());
							}else{
								cnsb.append(cns[l].substring(0, 1).toUpperCase()+cns[l].substring(1).toLowerCase());
							}
						}
					}
					String filedName=cnsb.toString();
					if (!cm.isAutoIncrement()){
						sbCols.append(cm.getName());
						if(Config.daoType.equals("ibatis")){
							sbTypes.append("#"+filedName+":"+cm.getJdbcType()+"#");
						}else if(Config.daoType.equals("mybatis")){
							sbTypes.append("#{"+filedName+"}");
						}
					}else{
			            String selectKeyType = "int";
			            if (cm.getType().equals("Long")) {
			              selectKeyType = "long";
			            }
			            keyGen.append("useGeneratedKeys=\"true\" keyProperty=\"" + filedName + "\"  keyColumn=\"" + cm.getName() + "\"");
			            selectKey.append("<selectKey keyProperty=\"" + filedName + "\" resultType=\"" + selectKeyType + "\" order=\"AFTER\">\r\n");
			            selectKey.append("\t\t\tSELECT LAST_INSERT_ID();\r\n");
			            selectKey.append("\t\t\t</selectKey>");
					}

					if(Config.daoType.equals("ibatis")){
						updateStr.append(cm.getName()).append("=#").append(filedName).append(":").append(cm.getJdbcType()).append("#");
						dynamicUpdateStr.append("\t\t<isPropertyAvailable property=\""+filedName+"\">\r\n");
						dynamicUpdateStr.append("\t\t\t<isNotNull property=\""+filedName+"\" prepend=\",\" removeFirstPrepend=\"true\">\r\n");
						dynamicUpdateStr.append("\t\t\t\t").append(cm.getName()).append("=#").append(filedName).append("#\r\n");
						dynamicUpdateStr.append("\t\t\t</isNotNull>\r\n");
						dynamicUpdateStr.append("\t\t</isPropertyAvailable>\r\n");

						dynamicStr.append("\t\t<isPropertyAvailable property=\""+filedName+"\">\r\n");
						dynamicStr.append("\t\t\t<isNotNull property=\""+filedName+"\" prepend=\" and \">\r\n");
						dynamicStr.append("\t\t\t\t").append(cm.getName()).append("=#").append(filedName).append("#\r\n");
						dynamicStr.append("\t\t\t</isNotNull>\r\n");
						dynamicStr.append("\t\t</isPropertyAvailable>\r\n");
					}else if(Config.daoType.equals("mybatis")){
						updateStr.append(cm.getName()).append("=#{").append(filedName).append(",jdbcType=").append(cm.getJdbcType()).append("}");
						StringBuffer tmp=new StringBuffer();
						tmp.append("\t\t<if test=\""+filedName+"!=null\">\r\n");
						tmp.append("\t\t\t").append(cm.getName()).append("=#{").append(filedName).append(",jdbcType=").append(cm.getJdbcType()).append("},\r\n");
						tmp.append("\t\t</if>\r\n");
						dynamicUpdateStr.append(tmp);
						tmp=new StringBuffer();
						tmp.append("\t\t<if test=\""+filedName+"!=null\">\r\n");
						tmp.append("\t\t\t and ").append(cm.getName()).append("=#{").append(filedName).append(",jdbcType=").append(cm.getJdbcType()).append("}\r\n");
						tmp.append("\t\t</if>\r\n");
						dynamicStr.append(tmp);
					}



					if(f<cols.size()-1){
						if (!cm.isAutoIncrement()){
							sbCols.append(",");
							sbTypes.append(",");
						}
						updateStr.append(",");
					}
					resultMapStr.append("<result property=\""+filedName+"\" column=\""+cm.getName()+"\" />");
					if(f<cols.size()-1){
						resultMapStr.append("\r\n\t\t");
					}
				}
				if(Config.daoType.equals("ibatis")){
					dynamicUpdateStr.append("\t</dynamic>");
				}else if(Config.daoType.equals("mybatis")){
					dynamicUpdateStr.append("\t</set>");
				}


				List<ColumnModel> priList=new ArrayList<ColumnModel>();
				for(ColumnModel cm:cols){
					if(cm.isPrimaryKey())
						priList.add(cm);
				}
			
				StringBuffer conditionStr=new StringBuffer("");
				if(priList.size()>0){
					conditionStr.append("WHERE ");
					for(int t=0;t<priList.size();t++){
						ColumnModel cm=priList.get(t);
						String[] cns=cm.getName().split(Config.columnSplit);
						StringBuffer cnsb=new StringBuffer();
						if(cns.length==1){
							cnsb.append(Config.isToLower?cm.getName().toLowerCase():cm.getName());
						}else{
							for (int l=0;l<cns.length;l++) {
								if(l==0){
									cnsb.append(cns[0].substring(0, 1).toLowerCase()+cns[0].substring(1).toLowerCase());
								}else{
									cnsb.append(cns[l].substring(0, 1).toUpperCase()+cns[l].substring(1).toLowerCase());
								}
							}
						}
						String filedName=cnsb.toString();
						if(Config.daoType.equals("ibatis")){
							conditionStr.append(cm.getName()).append("=").append("#").append(filedName).append(":").append(cm.getJdbcType()).append("#");
						}else if(Config.daoType.equals("mybatis")){
							conditionStr.append(cm.getName()).append("=").append("#{").append(filedName).append(",jdbcType=").append(cm.getJdbcType()).append("}");
						}
						
						if(t<priList.size()-1){
							conditionStr.append(" AND ");
						}
					}
				}
			
				d=codeTemplateStr.getMapStr().replaceAll("%TableName%",className);
				d=d.replaceAll("%tTableName%", selections[i]);
				d=d.replaceAll("%sTableName%", selections[i].toLowerCase()).replaceAll("%PackageName%",packageName.toLowerCase() );
				d=d.replaceAll("%FieldList%", sbCols.toString()).replaceAll("%ValuesList%", sbTypes.toString());
				d=d.replaceAll("%keyGen%", keyGen.toString()).replaceAll("%selectKey%", selectKey.toString());
				d=d.replace("%UpdateStr%", updateStr.toString());
				d=d.replace("%Condition%", conditionStr.toString());
				if(Config.daoType.equals("ibatis")){
					d=d.replace("%DYNAMICUPDATE%", dynamicUpdateStr.toString());
					condition.append("\t</dynamic>");
					d=d.replace("%DYNAMICCONDITIONWHERE%", condition.toString());
					dynamicStr.append("\t</dynamic>");
					d=d.replace("%DYNAMICWHERE%", dynamicStr.toString());
					searchfileds.append("\t</dynamic>");
					d=d.replace("%DYNAMICSEARCHBEANWHERE%", searchfileds.toString());
				}else if(Config.daoType.equals("mybatis")){
					d=d.replace("%DYNAMICUPDATE%", dynamicUpdateStr.toString());
					condition.append("\t</where>");
					d=d.replace("%DYNAMICCONDITIONWHERE%", condition.toString());
					dynamicStr.append("\t</where>");
					d=d.replace("%DYNAMICWHERE%", dynamicStr.toString());
					searchfileds.append("\t</where>");
					d=d.replace("%DYNAMICSEARCHBEANWHERE%", searchfileds.toString());
				}
				if ((Config.cacheName != null) && (!"".equals(Config.cacheName))) {
					d = d.replaceAll("%CACHE%", "type=\"" + Config.cacheName + "\"");
				}else{
					d = d.replaceAll("%CACHE%", "");
				}
				d=d.replaceAll("%RESULTMAP%", resultMapStr.toString());
				out.write(d);
				out.flush();
				out.close();
				
				file=new File(service+"\\"+className+"Service.java");
				if(file.exists())
					file.delete();
				out=new OutputStreamWriter(new FileOutputStream(file), Config.encoding);
				d=codeTemplateStr.getServiceStr().replaceAll("%TableName%", className);
				d=d.replaceAll("%PackageName%", packageName.toLowerCase());
				d=d.replaceAll("%pTableName%", pTableName);
				d=d.replaceAll("%public%", commonPackage);
				out.write(d);
				out.flush();
				out.close();
				
				file=new File(service+"\\"+className+"ServiceImpl.java");
				if(file.exists())
					file.delete();
				out=new OutputStreamWriter(new FileOutputStream(file), Config.encoding);
				d=codeTemplateStr.getServiceImplStr().replaceAll("%TableName%", className);
				d=d.replaceAll("%PackageName%", packageName.toLowerCase());
				d=d.replaceAll("%pTableName%", pTableName);
				d=d.replaceAll("%public%", commonPackage);
				out.write(d);
				out.flush();
				out.close();
				
				file=new File(action+"\\"+className+"Action.java");
				if(file.exists())
					file.delete();
				out=new OutputStreamWriter(new FileOutputStream(file), Config.encoding);
				d=codeTemplateStr.getActionStr().replaceAll("%TableName%", className);
				d=d.replaceAll("%PackageName%", packageName.toLowerCase());
				d=d.replaceAll("%pTableName%", pTableName);
				d=d.replaceAll("%lTableName%", packageName.toLowerCase().substring(packageName.lastIndexOf(".")+1));
				d=d.replaceAll("%public%", commonPackage);
				d=d.replaceAll("%urlext%", Config.urlExt);
				out.write(d);
				out.flush();
				out.close();
				
				file=new File(struts2+"\\"+className.toLowerCase()+".xml");
				if(file.exists())
					file.delete();
				out=new OutputStreamWriter(new FileOutputStream(file), Config.encoding);
				d=codeTemplateStr.getStruts2Str().replaceAll("%TableName%", className);
				d=d.replaceAll("%pTableName%", pTableName);
				d=d.replaceAll("%lTableName%", className.toLowerCase());
				out.write(d);
				out.flush();
				out.close();
				
				classList.add(className);
				
				
				
				
				//IOS
				Map<String,String> typeMap=new HashMap<String,String>();
				typeMap.put("Integer", "NSNumber");
				typeMap.put("String", "NSString");
				typeMap.put("Long", "NSNumber");
				typeMap.put("Double", "NSNumber");
				StringBuffer bufh=new StringBuffer();
				StringBuffer bufm=new StringBuffer();
				bufh.append("@interface "+className+":NSObject\r\n");
				bufm.append("@implementation ").append(className).append("\r\n");
				for(int k=0;k<cols.size();k++){
					ColumnModel cm=cols.get(k);
					String[] cns=cm.getName().split(Config.columnSplit);
					StringBuffer cnsb=new StringBuffer();
					if(cns.length==1){
						cnsb.append(Config.isToLower?cm.getName().toLowerCase():cm.getName());
					}else{
						for (int l=0;l<cns.length;l++) {
							if(l==0){
								cnsb.append(cns[0].substring(0, 1).toLowerCase()+cns[0].substring(1).toLowerCase());
							}else{
								cnsb.append(cns[l].substring(0, 1).toUpperCase()+cns[l].substring(1).toLowerCase());
							}
						}
					}
					String caseName=cnsb.toString();
					String fliedName=caseName.substring(0, 1).toUpperCase()+caseName.substring(1);
					bufh.append("/** ").append(cm.getComment()).append(" */\r\n");
					bufh.append("@property (strong, atomic)"+typeMap.get(cm.getType())+"* "+caseName+";\r\n");
					bufm.append("@synthesize ").append(caseName).append(";\r\n");
					if(k==cols.size()-1){
						bufh.append("@end\r\n");
						bufm.append("@end\r\n");
					}
				}
				//file = new File(ios + "\\" + className + ".h");
				out=new OutputStreamWriter(new FileOutputStream(iosH,true),Config.encoding);
				out.write("/** "+comment+" */\r\n");
				out.write(bufh.append("\r\n").toString());
				out.flush();
				out.close();
				
				//file = new File(ios + "\\" + className + ".m");
				out=new OutputStreamWriter(new FileOutputStream(iosM,true),Config.encoding);
				out.write("/** "+comment+" */\r\n");
				out.write(bufm.append("\r\n").toString());
				out.flush();
				out.close();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		try{
			OutputStreamWriter out= new OutputStreamWriter(new FileOutputStream(configFile,false),Config.encoding);
			for (String className : classList) {
				if(Config.daoType.equals("ibatis")){
					out.write("<sqlMap resource=\"conf/"+Config.daoType+"/"+className+".xml\"/>\r\n");
				}else if(Config.daoType.equals("mybatis")){
					out.write("<typeAlias alias=\""+className+"\" type=\""+packageName+".bean."+className+"\"/>\r\n");
				}
			}
			out.write("\r\n");
			for (String className : classList) {
				if(Config.daoType.equals("mybatis")){
					out.write("<mapper resource=\"conf/mybatis/"+className+".xml\" />\r\n");
				}
			}
			
			out.flush();
			out.close();
			
			for (String className : classList) {
				out=new OutputStreamWriter(new FileOutputStream(springDaoFile,true),Config.encoding);
				if(Config.daoType.equals("ibatis")){
					out.write("\t<bean id=\""+className.substring(0, 1).toLowerCase()+className.substring(1)+"Dao\" class=\""+packageName+".dao."+className+"DaoImpl\">\r\n");
					out.write("\t\t<property name=\"dbType\" value=\"${dbType}\"/>\r\n");
					out.write("\t\t<property name=\"sqlMapClient\" ref=\"sqlMapClient\" />\r\n");
					out.write("\t</bean>\r\n");
				}else if(Config.daoType.equals("mybatis")){
					out.write("\t<bean id=\""+className.substring(0, 1).toLowerCase()+className.substring(1)+"Dao\" class=\""+packageName+".dao."+className+"DaoImpl\">\r\n");
					out.write("\t\t<property name=\"sqlSession\" ref=\"sqlSession\" />\r\n");
					out.write("\t</bean>\r\n");
				}
				
				out.flush();
				out.close();
				
				out=new OutputStreamWriter(new FileOutputStream(springServiceFile,true),Config.encoding);
				out.write("\t<bean id=\""+className.substring(0, 1).toLowerCase()+className.substring(1)+"Service\" class=\""+packageName+".service."+className+"ServiceImpl\">\r\n");
				out.write("\t\t<property name=\""+className.substring(0, 1).toLowerCase()+className.substring(1)+"Dao\" ref=\""+className.substring(0, 1).toLowerCase()+className.substring(1)+"Dao\"/>\r\n");
				out.write("\t</bean>\r\n");
				out.flush();
				out.close();
			}
			
			
		}catch (Exception e) {
			log.info("生成代码异常",e);
		}

	}		
}
