package com.hujianbin.codetool.ibatis;

import java.io.*;
import java.util.Enumeration;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class ConfigUtil {

	public static void init(){
		try {
			File file=new File("config.properties");
			if(file.exists()){
				InputStream in = new BufferedInputStream(new FileInputStream(file));
				ResourceBundle rb = new PropertyResourceBundle(in);
				in.close();
				Enumeration<String> keys=rb.getKeys();
				String encoding=rb.getString("encoding");
				Config.encoding=encoding;
				String importStr=rb.getString("import");
				Config.importStr=importStr;
				String tablePrefix=rb.getString("table_prefix");
				Config.tablePrefix=tablePrefix;
				String tableSplit=rb.getString("table_split");
				Config.tableSplit=tableSplit;
				String columnSplit=rb.getString("column_split");
				Config.columnSplit=columnSplit;
				String isToLower=rb.getString("istolower");
				if("1".equals(isToLower))
					Config.isToLower=true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void saveConfig(){
		File file = new File("config.properties");
		try {
			Properties prop = new Properties(); 
			FileInputStream fis = new FileInputStream(file);
			prop.load(fis);
			fis.close();

			prop.setProperty("encoding", Config.encoding);
			prop.setProperty("istolower", Config.isToLower?"1":"0");
			prop.setProperty("table_prefix", Config.tablePrefix);
			prop.setProperty("table_split", Config.tableSplit);
			prop.setProperty("column_split", Config.columnSplit);
			prop.setProperty("cache_name", Config.cacheName);
			prop.setProperty("import", Config.importStr);
			prop.setProperty("package_name", Config.packageName);
			prop.setProperty("file_dir", Config.fileDir);
			FileOutputStream fos = new FileOutputStream(file); 
			prop.store(fos, "Copyright (c) Guodang Zuo"); 
			fos.close();// �ر��� 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
