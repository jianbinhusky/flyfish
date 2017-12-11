package com.hujianbin.codetool.ibatis;


import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class GenSearchBean {
	
	public static void main(String[] args) throws Exception {
		String packageName = "com.onlinecredit.model";
		String searchBaseDir="d:\\gen\\search\\";

		List<String> classNames = getClassName(packageName);
		for (String className : classNames) {
			if(className.contains(".validate.")||className.contains(".vo."))
				continue;
			String searchName=className.substring(0, className.lastIndexOf("."));
			searchName=searchName.replaceFirst("model", "search");
			
			Class clazz=Class.forName(className);
			Field[] fields=clazz.getDeclaredFields();
			StringBuffer fieldBuf=new StringBuffer();
			List<Field> list=new ArrayList<Field>();
			for (Field field : fields) {
				int modifier=field.getModifiers();
				String fieldName=field.getName();
				String typeSimpleName=field.getType().getSimpleName();
				if(modifier!=26){
					if(isBaseType(typeSimpleName)){
						//System.out.println(className+":"+field.getName());
						//fieldBuf.append("\t").append("private ").append(typeSimpleName).append(" ").append(fieldName).append(";\r\n");
						list.add(field);
					}
				}
			}
			if(list.size()>0)
			writeFile(searchBaseDir, clazz.getSimpleName(), searchName, list);
		}
	}
	
	public static void writeFile(String searchBaseDir,String modelName,String searchPackageName,List<Field> fields){
		String packPath=searchPackageName.replaceAll("\\.", "\\\\");
		System.out.println(searchBaseDir+packPath);
		File dir=new File(searchBaseDir+packPath);
		if(!dir.exists())
			dir.mkdirs();
		StringBuffer sb=new StringBuffer();
		sb.append("package ").append(searchPackageName).append(";\r\n");
		sb.append("import java.util.Date;\r\n\r\n");

		sb.append("import lombok.Data;\r\n\r\n");

		sb.append("import org.hibernate.Criteria;\r\n");
		sb.append("import org.hibernate.criterion.Order;\r\n");
		sb.append("import org.hibernate.criterion.Restrictions;\r\n\r\n");

		sb.append("import com.onlinecredit.search.OrderBean;\r\n");
		sb.append("import com.onlinecredit.search.SearchBean;\r\n\r\n");
		
		sb.append("@Data\r\n");
		sb.append("public class ").append(modelName).append("SearchBean extends SearchBean {\r\n\r\n");
		StringBuffer fieldBuf=new StringBuffer();
		StringBuffer methodBuf=new StringBuffer();
		for (Field field : fields) {
			String type=field.getType().getSimpleName();
			String fieldName=field.getName();
			String fieldName1=fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
			fieldBuf.append("\tprivate ").append(field.getType().getSimpleName()).append(" equals").append(fieldName1).append(";\r\n");
			fieldBuf.append("\tprivate ").append(field.getType().getSimpleName()).append(" noEquals").append(fieldName1).append(";\r\n");
			fieldBuf.append("\tprivate Boolean").append(" isNull").append(fieldName1).append(";\r\n");
			fieldBuf.append("\tprivate Boolean").append(" isNotNull").append(fieldName1).append(";\r\n");
			
			methodBuf.append("\t\tif(equals").append(fieldName1).append("!=null){\r\n");
			methodBuf.append("\t\t\tcriteria.add(Restrictions.eq(\"").append(fieldName).append("\",eqauls").append(fieldName1).append(");\r\n");
			methodBuf.append("\t\t}\r\n");
			methodBuf.append("\t\tif(noEquals").append(fieldName1).append("!=null){\r\n");
			methodBuf.append("\t\t\tcriteria.add(Restrictions.ne(\"").append(fieldName).append("\",noEqauls").append(fieldName1).append(");\r\n");
			methodBuf.append("\t\t}\r\n");
			methodBuf.append("\t\tif(isNull").append(fieldName1).append("!=null){\r\n");
			methodBuf.append("\t\t\tcriteria.add(Restrictions.isNull(\"").append(fieldName).append("\");\r\n");
			methodBuf.append("\t\t}\r\n");
			methodBuf.append("\t\tif(isNotNull").append(fieldName1).append("!=null){\r\n");
			methodBuf.append("\t\t\tcriteria.add(Restrictions.isNotNull(\"").append(fieldName).append("\");\r\n");
			methodBuf.append("\t\t}\r\n");
			if("Integer".equals(type)||"Double".equals(type)||"Date".equals(type)){
				fieldBuf.append("\tprivate ").append(field.getType().getSimpleName()).append(" greater").append(fieldName1).append(";\r\n");
				fieldBuf.append("\tprivate ").append(field.getType().getSimpleName()).append(" greaterEquals").append(fieldName1).append(";\r\n");
				fieldBuf.append("\tprivate ").append(field.getType().getSimpleName()).append(" less").append(fieldName1).append(";\r\n");
				fieldBuf.append("\tprivate ").append(field.getType().getSimpleName()).append(" lessEquals").append(fieldName1).append(";\r\n");
				methodBuf.append("\t\tif(greater").append(fieldName1).append("!=null){\r\n");
				methodBuf.append("\t\t\tcriteria.add(Restrictions.gt(\"").append(fieldName).append("\",greater").append(fieldName1).append(");\r\n");
				methodBuf.append("\t\t}\r\n");
				methodBuf.append("\t\tif(greaterEquals").append(fieldName1).append("!=null){\r\n");
				methodBuf.append("\t\t\tcriteria.add(Restrictions.ge(\"").append(fieldName).append("\",greaterEquals").append(fieldName1).append(");\r\n");
				methodBuf.append("\t\t}\r\n");
				methodBuf.append("\t\tif(less").append(fieldName1).append("!=null){\r\n");
				methodBuf.append("\t\t\tcriteria.add(Restrictions.lt(\"").append(fieldName).append("\",less").append(fieldName1).append(");\r\n");
				methodBuf.append("\t\t}\r\n");
				methodBuf.append("\t\tif(lessEquals").append(fieldName1).append("!=null){\r\n");
				methodBuf.append("\t\t\tcriteria.add(Restrictions.le(\"").append(fieldName).append("\",lessEquals").append(fieldName1).append(");\r\n");
				methodBuf.append("\t\t}\r\n");
			}else if("String".equals(type)){
				fieldBuf.append("\tprivate ").append(field.getType().getSimpleName()).append(" like").append(fieldName1).append(";\r\n");
				fieldBuf.append("\tprivate ").append(field.getType().getSimpleName()).append(" startLike").append(fieldName1).append(";\r\n");
				fieldBuf.append("\tprivate ").append(field.getType().getSimpleName()).append(" endLike").append(fieldName1).append(";\r\n");
				methodBuf.append("\t\tif(like").append(fieldName1).append("!=null){\r\n");
				methodBuf.append("\t\t\tcriteria.add(Restrictions.like(\"").append(fieldName).append("\",like").append(fieldName1).append(",MatchMode.ANYWHERE);\r\n");
				methodBuf.append("\t\t}\r\n");
				methodBuf.append("\t\tif(startLike").append(fieldName1).append("!=null){\r\n");
				methodBuf.append("\t\t\tcriteria.add(Restrictions.like(\"").append(fieldName).append("\",startLike").append(fieldName1).append(",MatchMode.START);\r\n");
				methodBuf.append("\t\t}\r\n");
				methodBuf.append("\t\tif(endLike").append(fieldName1).append("!=null){\r\n");
				methodBuf.append("\t\t\tcriteria.add(Restrictions.like(\"").append(fieldName).append("\",endLike").append(fieldName1).append(",MatchMode.END);\r\n");
				methodBuf.append("\t\t}\r\n");
			}
			
		}
		sb.append(fieldBuf);
		sb.append("\r\n");
		sb.append("\tpublic Criteria buildCriteria(Criteria criteria){\r\n");
		sb.append(methodBuf);
		sb.append("\t\tfor (OrderBean orderBean : this.getOrderByCondtion()) {\r\n");
		sb.append("\t\t\tif(orderBean.isDesc()){\r\n");
		sb.append("\t\t\t\tcriteria.addOrder(Order.desc(orderBean.getFieldName()));\r\n");
		sb.append("\t\t\t}else{\r\n");
		sb.append("\t\t\t\tcriteria.addOrder(Order.asc(orderBean.getFieldName()));\r\n");
		sb.append("\t\t\t}\r\n");
		sb.append("\t\t}\r\n");
		sb.append("\t}\r\n");
		sb.append("}");
		File searchFile=new File(searchBaseDir+packPath+"\\"+modelName+"SearchBean.java");
		try {
			OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream(searchFile),"utf-8");
			osw.write(sb.toString());
			osw.flush();
			osw.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static boolean isBaseType(String type){
		return type.equals("Integer")||type.equals("Double")||type.equals("String")||type.equals("Boolean")||type.equals("Date")||type.equals("Long");
	}

	public static List<String> getClassName(String packageName) {
		String filePath = ClassLoader.getSystemResource("").getPath() + packageName.replace(".", "\\");
		filePath=filePath.replaceAll("test-classes", "classes");
		List<String> fileNames = getClassName(filePath, null);
		return fileNames;
	}

	private static List<String> getClassName(String filePath, List<String> className) {
		List<String> myClassName = new ArrayList<String>();
		File file = new File(filePath);
		
		File[] childFiles = file.listFiles();
		for (File childFile : childFiles) {
			if (childFile.isDirectory()) {
				myClassName.addAll(getClassName(childFile.getPath(), myClassName));
			} else {
				String childFilePath = childFile.getPath();
				childFilePath = childFilePath.substring(childFilePath.indexOf("\\classes") + 9, childFilePath.lastIndexOf("."));
				childFilePath = childFilePath.replace("\\", ".");
				myClassName.add(childFilePath);
			}
		}

		return myClassName;
	}
}