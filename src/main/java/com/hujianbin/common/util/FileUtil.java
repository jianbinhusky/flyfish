package com.hujianbin.common.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.POIXMLProperties;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.http.MediaType;

public class FileUtil {
	private static Logger log = Logger.getLogger(FileUtil.class);

	public static int parseFileLine(String file) throws Exception{
		int lineCount = 0;
		if (file.endsWith(".txt")) {// txt
			FileReader in = new FileReader(file);
			LineNumberReader reader = new LineNumberReader(in);
			String s = reader.readLine();
			while (s != null&&!"".equals(s)) {
				lineCount++;
				s = reader.readLine();
			}
			reader.close();
			in.close();
		}

		return lineCount;
	}
	
	public static List<String> parseFile(String file){
		List<String> mobiles=new ArrayList<String>();
		BufferedReader buf=null;
		FileInputStream input=null;
		try {
			if(file.endsWith(".txt")){
				buf=new BufferedReader(new UnicodeReader(new FileInputStream(file),Charset.defaultCharset().name()));
				String mobile=null;
				while((mobile=buf.readLine())!=null&&!"".equals(mobile)){
					mobiles.add(mobile);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (buf != null) {
					buf.close();
				}
				if (input != null) {
					input.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return mobiles;
	}
	
	public static List<String> parseMobileFile(String file){
		List<String> mobiles=new ArrayList<String>();
		List<String> tmp=parseFile(file);
		for (String string : tmp) {
			if(string.length()<13)
				mobiles.add(string);
		}
		tmp.clear();
		tmp=null;
		return mobiles;
	}
	
	public static List<String> parseBlackWordFile(String file){
		return parseFile(file);
	}
	
	public static List<String> parseCorpNoFile(String file){
		List<String> corpNos=new ArrayList<String>();
		List<String> tmp=parseFile(file);
		for (String string : tmp) {
			if(string.length()<7)
				corpNos.add(string);
		}
		tmp.clear();
		tmp=null;
		return corpNos;
	}
	
	public static List<String> listResource(String dir){
		List<String> list=new ArrayList<String>();
		File directory=new File(dir);
		if(directory.exists()){
			File[] files=directory.listFiles();
			long st=DateUtil.getTodayStartTime();
			for (File file : files) {
				long mt=file.lastModified();
				if(mt<st)//今天以前的文件
					list.add(file.getAbsolutePath());
			}
		}
		return list;
	}
	
	public static void deleteFile(String file){
		File f=new File(file);
		if(f.exists())
			f.delete();
	}
	
	public static String createTempFile(String dir,List<String> list,String charsetName){
		String fileName=UUID.randomUUID().toString()+".txt";
		try {
			OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream(dir+fileName), charsetName);
			for (String string : list) {
				osw.write(string);
				osw.write("\r\n");
			}
			osw.flush();
			osw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileName;
	}
	
	public static String exportExcelFile(List<String[]> dataList,List<String> titleList,String dir,String sheetName){
		String fileName=null;
		FileOutputStream fos=null;
		try {
			fileName=UUID.randomUUID().toString()+".xlsx";
			Workbook wb=new SXSSFWorkbook(2000);
			POIXMLProperties props=((SXSSFWorkbook)wb).getXSSFWorkbook().getProperties();
			POIXMLProperties.CoreProperties coreProps=props.getCoreProperties();
			coreProps.setCreator("");
			Sheet sheet=wb.createSheet(sheetName);
			Row row=sheet.createRow(0);
			CellStyle titleStyle=wb.createCellStyle();
			Font titleFont=wb.createFont();
			titleFont.setFontName("黑体");
			titleFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
			titleStyle.setFont(titleFont);
			titleStyle.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());
			titleStyle.setFillBackgroundColor(IndexedColors.PALE_BLUE.getIndex());
			titleStyle.setFillPattern(CellStyle.BIG_SPOTS);
			for(int i=0;i<titleList.size();i++){//写标题
				Cell cell=row.createCell(i);
				cell.setCellStyle(titleStyle);
				cell.setCellValue(titleList.get(i));
			}
			for(int i=0;i<dataList.size();i++){//写数据
				row=sheet.createRow(i+1);
				String[] obj=dataList.get(i);
				for (int j = 0; j < obj.length; j++) {
					String object = obj[j];
					Cell cell=row.createCell(j);
					cell.setCellValue(object);
				}
			}
			for(int i=0;i<titleList.size();i++){
				sheet.autoSizeColumn(i);
			}
			fos=new FileOutputStream(dir+fileName);
			wb.write(fos);
		} catch (Exception e) {
			fileName=null;
			e.printStackTrace();
		} finally{
			try {
				if(fos!=null){
					fos.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return fileName;
	}
	
	public static void writeFile(File downfile, HttpServletRequest request, HttpServletResponse response, String filename,boolean isDownload) {

		if (downfile != null && downfile.exists()) {
			if (downfile.getName().toLowerCase().endsWith(".gif")) {
				response.setContentType(MediaType.IMAGE_GIF_VALUE);
			} else if (downfile.getName().toLowerCase().endsWith(".jpg")) {
				response.setContentType(MediaType.IMAGE_JPEG_VALUE);
			} else if (filename.toLowerCase().endsWith(".jpg")) {
				response.setContentType(MediaType.IMAGE_JPEG_VALUE);
			} else if (downfile.getName().toLowerCase().endsWith(".jpeg")) {
				response.setContentType(MediaType.IMAGE_JPEG_VALUE);
			} else if (downfile.getName().toLowerCase().endsWith(".png")) {
				response.setContentType(MediaType.IMAGE_PNG_VALUE);
			} else if (downfile.getName().toLowerCase().endsWith(".flv")) {
				response.setContentType("video/flv");
			} else if (downfile.getName().toLowerCase().endsWith(".mp4")) {
				response.setContentType("video/mp4");
			} else if (downfile.getName().toLowerCase().endsWith(".mov")) {
				response.setContentType("video/mov");
			} else if (downfile.getName().toLowerCase().endsWith(".3gp")) {
				response.setContentType("video/3gp");
			} else if (downfile.getName().toLowerCase().endsWith(".ogg")) {
				response.setContentType("video/ogg");
			} else {
				response.setContentType("application/download");
				response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
			}
			
			response.setHeader("Content-Length", "" + downfile.length());
			response.setHeader("Content-Disposition", "inline; filename=\"" + filename + "\"");

			response.setHeader("Accept-Ranges", "bytes");

			if(isDownload){
				response.setContentType("application/download");
				response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
			}
			long start = 0;
			long end = 0;
			end = downfile.length();
			
			response.setHeader("Content-Length", new Long(end - start).toString());


			FileInputStream fin = null;

			try {
				byte buff[] = new byte[1024];
				fin = new FileInputStream(downfile);
				int rsize = 0;
				int totalrsize = (int) (end - start);
				fin.skip(start);
				while (totalrsize > 0 && (rsize = fin.read(buff, 0, Math.min(1024, totalrsize))) > 0) {
					response.getOutputStream().write(buff, 0, rsize);
					// response.getOutputStream().flush();
					totalrsize -= rsize;
				}

			} catch (Exception e) {
				log.error("下载文件异常",e);
			} finally {
				if (fin != null) {
					try {
						fin.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
