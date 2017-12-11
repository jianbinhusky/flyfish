package com.hujianbin.codetool.ibatis;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Text;

import java.io.*;
import java.util.List;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class InitThread extends Thread {

	private Display display;
	private Menu historyMenu;
	private File actionFile,serviceFile,serviceImplFile,daoFile,daoImplFile,beanFile,searchBeanFile,struts2File;
	private Text actionText,serviceText,serviceImplText,daoText,daoImplText,searchBeanText,beanText,struts2Text;
	private Text packageNameText,pathText;
	
	List<ConnHistory> historys=null;
	StringBuffer actionStr=new StringBuffer();
	StringBuffer serviceStr=new StringBuffer();
	StringBuffer serviceImplStr=new StringBuffer();
	StringBuffer daoStr=new StringBuffer();
	StringBuffer daoImplStr=new StringBuffer();
	StringBuffer beanStr=new StringBuffer();
	StringBuffer searchBeanStr=new StringBuffer();
	StringBuffer struts2Str=new StringBuffer();
	
	private String filePath="config.properties";
	
	public InitThread(){
		
	}
	
	public InitThread(Display display,Menu historyMenu,File actionFile,File serviceFile,File serviceImplFile,File daoFile,File daoImplFile,File beanFile,File searchBeanFile,File struts2File,Text actionText,Text serviceText,Text serviceImplText,Text daoText,Text daoImplText,Text searchBeanText,Text beanText,Text struts2Text,Text packageNameText,Text pathText){
		this.display=display;
		this.historyMenu=historyMenu;
		this.actionFile=actionFile;
		this.serviceFile=serviceFile;
		this.serviceImplFile=serviceImplFile;
		this.daoFile=daoFile;
		this.daoImplFile=daoImplFile;
		this.beanFile=beanFile;
		this.searchBeanFile=searchBeanFile;
		this.struts2File=struts2File;
		this.actionText=actionText;
		this.serviceText=serviceText;
		this.serviceImplText=serviceImplText;
		this.daoText=daoText;
		this.daoImplText=daoImplText;
		this.searchBeanText=searchBeanText;
		this.beanText=beanText;
		this.struts2Text=struts2Text;
		
		this.packageNameText=packageNameText;
		this.pathText=pathText;
	}

	public void run() {
		HistoryManager hm=new HistoryManager();
		historys=hm.getHistory();
//		try {
//			BufferedReader buf=new BufferedReader(new InputStreamReader(new FileInputStream(actionFile)));
//			String linedata=null;
//			while((linedata=buf.readLine())!=null){
//				actionStr.append(linedata+"\r\n");
//			}
//			buf.close();
//		} catch (FileNotFoundException e1) {
//			e1.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		try {
			BufferedReader buf=new BufferedReader(new InputStreamReader(new FileInputStream(serviceFile)));
			String linedata=null;
			while((linedata=buf.readLine())!=null){
				serviceStr.append(linedata+"\r\n");
			}
			buf.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			BufferedReader buf=new BufferedReader(new InputStreamReader(new FileInputStream(serviceImplFile)));
			String linedata=null;
			while((linedata=buf.readLine())!=null){
				serviceImplStr.append(linedata+"\r\n");
			}
			buf.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		try {
//			BufferedReader buf=new BufferedReader(new InputStreamReader(new FileInputStream(daoFile)));
//			String linedata=null;
//			while((linedata=buf.readLine())!=null){
//				daoStr.append(linedata+"\r\n");
//			}
//			buf.close();
//		} catch (FileNotFoundException e1) {
//			e1.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		try {
//			BufferedReader buf=new BufferedReader(new InputStreamReader(new FileInputStream(daoImplFile)));
//			String linedata=null;
//			while((linedata=buf.readLine())!=null){
//				daoImplStr.append(linedata+"\r\n");
//			}
//			buf.close();
//		} catch (FileNotFoundException e1) {
//			e1.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		try {
			BufferedReader buf=new BufferedReader(new InputStreamReader(new FileInputStream(beanFile)));
			String linedata=null;
			while((linedata=buf.readLine())!=null){
				beanStr.append(linedata+"\r\n");
			}
			buf.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			BufferedReader buf=new BufferedReader(new InputStreamReader(new FileInputStream(searchBeanFile)));
			String linedata=null;
			while((linedata=buf.readLine())!=null){
				searchBeanStr.append(linedata+"\r\n");
			}
			buf.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			BufferedReader buf=new BufferedReader(new InputStreamReader(new FileInputStream(struts2File)));
			String linedata=null;
			while((linedata=buf.readLine())!=null){
				struts2Str.append(linedata+"\r\n");
			}
			buf.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		File file=new File(filePath);
		if(!file.exists())
				initConfig();
		try {
			InputStream in = new BufferedInputStream(new FileInputStream(file));
			ResourceBundle rb = new PropertyResourceBundle(in);
			in.close();
			if(rb.containsKey("encoding")){
				String encoding=rb.getString("encoding");
				Config.encoding = encoding;
			}
			if(rb.containsKey("istolower")){
				String tolower=rb.getString("istolower");
				if("1".equals(tolower))
					Config.isToLower=true;
			}
			if(rb.containsKey("table_prefix")){
				String tablePrefix = rb.getString("table_prefix");
				Config.tablePrefix = tablePrefix;
			}
			if(rb.containsKey("table_split")){
				String tableSplit = rb.getString("table_split");
				Config.tableSplit = tableSplit;
			}
			if(rb.containsKey("column_split")){
				String columnSplit = rb.getString("column_split");
				Config.columnSplit = columnSplit;
			}
			if(rb.containsKey("cache_name")){
				String cacheName = rb.getString("cache_name");
				Config.cacheName = cacheName;
			}
			if(rb.containsKey("import")){
				String importStr = rb.getString("import");
				Config.importStr = importStr;
			}
			if(rb.containsKey("package_name")){
				String packageName = rb.getString("package_name");
				Config.packageName=packageName;
			}
			if(rb.containsKey("file_dir")){
				String fileDir = rb.getString("file_dir");
				Config.fileDir = fileDir;
			}
			
		} catch (IOException e) {
				e.printStackTrace();
		}
		
		display.asyncExec(new Runnable(){

			public void run() {
				if(display.isDisposed())
					return;
				if(historys!=null&&historys.size()>0){
					for(int i=0;i<historys.size();i++){
						ConnHistory ch=historys.get(i);
						MenuItem cmi=new MenuItem(historyMenu,SWT.RADIO);
						cmi.setText(ch.getName());
						cmi.setData(ch);
						cmi.addSelectionListener(new HistoryMenuItemListener(display.getActiveShell()));
					}
				}else{
					MenuItem cmi=new MenuItem(historyMenu,SWT.MENU);
					cmi.setText("无");
					cmi.setEnabled(false);
				}
				//actionText.setText(actionStr.toString());
				serviceText.setText(serviceStr.toString());
				serviceImplText.setText(serviceImplStr.toString());
				//daoText.setText(daoStr.toString());
				//daoImplText.setText(daoImplStr.toString());
				beanText.setText(beanStr.toString());
				searchBeanText.setText(searchBeanStr.toString());
				struts2Text.setText(struts2Str.toString());
				
				packageNameText.setText(Config.packageName);
				pathText.setText(Config.fileDir);
			}
			
		});
	}
	
	private void initConfig(){
		File file=new File(filePath);
		try {
			FileWriter fw=new FileWriter(file);
			fw.write("encoding="+Config.encoding+"\r\n");
			fw.write("istolower=0\r\n");
			fw.write("table_prefix="+Config.tablePrefix+"\r\n");
			fw.write("table_split="+Config.tableSplit+"\r\n");
			fw.write("column_split="+Config.columnSplit+"\r\n");
			fw.write("cache_name="+Config.cacheName+"\r\n");
			fw.write("import=\r\n");
			fw.write("package_name=\r\n");
			fw.write("file_dir=");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void setDisplay(Display display) {
		this.display = display;
	}

	public void setHistoryMenu(Menu historyMenu) {
		this.historyMenu = historyMenu;
	}

	public void setActionFile(File actionFile) {
		this.actionFile = actionFile;
	}

	public void setServiceFile(File serviceFile) {
		this.serviceFile = serviceFile;
	}

	public void setServiceImplFile(File serviceImplFile) {
		this.serviceImplFile = serviceImplFile;
	}

	public void setDaoFile(File daoFile) {
		this.daoFile = daoFile;
	}

	public void setDaoImplFile(File daoImplFile) {
		this.daoImplFile = daoImplFile;
	}

	public void setBeanFile(File beanFile) {
		this.beanFile = beanFile;
	}

	public void setSearchBeanFile(File searchBeanFile) {
		this.searchBeanFile = searchBeanFile;
	}

	public void setStruts2File(File struts2File) {
		this.struts2File = struts2File;
	}

	public void setActionText(Text actionText) {
		this.actionText = actionText;
	}

	public void setServiceText(Text serviceText) {
		this.serviceText = serviceText;
	}

	public void setServiceImplText(Text serviceImplText) {
		this.serviceImplText = serviceImplText;
	}

	public void setDaoText(Text daoText) {
		this.daoText = daoText;
	}

	public void setDaoImplText(Text daoImplText) {
		this.daoImplText = daoImplText;
	}

	public void setSearchBeanText(Text searchBeanText) {
		this.searchBeanText = searchBeanText;
	}

	public void setBeanText(Text beanText) {
		this.beanText = beanText;
	}

	public void setStruts2Text(Text struts2Text) {
		this.struts2Text = struts2Text;
	}

	public void setHistorys(List<ConnHistory> historys) {
		this.historys = historys;
	}

	public void setActionStr(StringBuffer actionStr) {
		this.actionStr = actionStr;
	}

	public void setServiceStr(StringBuffer serviceStr) {
		this.serviceStr = serviceStr;
	}

	public void setServiceImplStr(StringBuffer serviceImplStr) {
		this.serviceImplStr = serviceImplStr;
	}

	public void setDaoStr(StringBuffer daoStr) {
		this.daoStr = daoStr;
	}

	public void setDaoImplStr(StringBuffer daoImplStr) {
		this.daoImplStr = daoImplStr;
	}

	public void setBeanStr(StringBuffer beanStr) {
		this.beanStr = beanStr;
	}

	public void setSearchBeanStr(StringBuffer searchBeanStr) {
		this.searchBeanStr = searchBeanStr;
	}

	public void setStruts2Str(StringBuffer struts2Str) {
		this.struts2Str = struts2Str;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
}
