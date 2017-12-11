package com.hujianbin.codetool.ibatistools.action;


import com.alibaba.fastjson.JSON;
import com.hujianbin.codetool.ibatistools.bean.CodeTemplateStr;
import com.hujianbin.codetool.ibatistools.bean.Config;
import com.hujianbin.codetool.ibatistools.bean.ConnectionBean;
import com.hujianbin.codetool.ibatistools.util.DBUtil;
import com.hujianbin.codetool.ibatistools.util.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.sql.Connection;
import java.util.List;

/**
 * localhost:8080/tools/ibatis.htm
 */

@Controller
@Slf4j
@RequestMapping(value = "/tools")
public class IbatisToolAction {
	
	public static  Connection conn = null;
	public static  int db = -1;
	public static String mapend = "";
	public static String commonPackage = "";

	public static final String SEPARATOR = "&";

	
	public final static String[] SHOW_TABLE_SQL = {"show tables",
		"SELECT NAME TABLE_NAME FROM SYS.TABLES WHERE TYPE='U'",
		"SELECT TABLE_NAME FROM USER_ALL_TABLES ORDER BY TABLE_NAME",
		"select tablename from pg_tables where schemaname='public' order by tablename",
		"show tables"};
	public static CodeTemplateStr codeTemplateStr = null;
	
	/**
	 * go tool index page
	 * @return
	 */
	@RequestMapping(value = "/ibatis")
	public String goIndex(ModelMap result, HttpServletRequest request){
		codeTemplateStr = getFileTemplate(request);
		
		CodeTemplateStr codeTemplateStrDisplay = getDisplayCodeTemplateStr();

		String file = request.getSession().getServletContext().getRealPath("/") + "/template/connHistory.log";
		List<ConnectionBean> list = FileUtil.readHistory(file);
		
		result.put("code", 200);
		result.put("msg", "工具首页");
		result.put("data", codeTemplateStrDisplay);
		result.put("history", list);
		result.put("historyJson", JSON.toJSONString(list));

		return "ibatis/index";
	}
	
	private CodeTemplateStr getDisplayCodeTemplateStr(){
		
		CodeTemplateStr codeTemplateStrDisplay = new CodeTemplateStr();
		String actionStr = codeTemplateStr.getActionStr();
		String beanStr = codeTemplateStr.getBeanStr();
		String daoImplStr = codeTemplateStr.getDaoImplStr();
		String daoStr = codeTemplateStr.getDaoStr();
		String searchBeanStr = codeTemplateStr.getSearchBeanStr();
		String serviceStr = codeTemplateStr.getServiceImplStr();
		String serviceImplStr = codeTemplateStr.getServiceStr();
		
		codeTemplateStrDisplay.setActionStr(actionStr.replaceAll("\r\n", "<br>").replaceAll(" ", "&nbsp;"));
		codeTemplateStrDisplay.setBeanStr(beanStr.replaceAll("\r\n", "<br>").replaceAll(" ", "&nbsp;"));
		codeTemplateStrDisplay.setDaoImplStr(daoImplStr.replaceAll("\r\n", "<br>").replaceAll(" ", "&nbsp;"));
		codeTemplateStrDisplay.setDaoStr(daoStr.replaceAll("\r\n", "<br>").replaceAll(" ", "&nbsp;"));
		codeTemplateStrDisplay.setSearchBeanStr(searchBeanStr.replaceAll("\r\n", "<br>").replaceAll(" ", "&nbsp;"));
		codeTemplateStrDisplay.setServiceImplStr(serviceStr.replaceAll("\r\n", "<br>").replaceAll(" ", "&nbsp;"));
		codeTemplateStrDisplay.setServiceStr(serviceImplStr.replaceAll("\r\n", "<br>").replaceAll(" ", "&nbsp;"));
		codeTemplateStrDisplay.setStruts2Str(codeTemplateStr.getStruts2Str());
		codeTemplateStrDisplay.setMapStr(codeTemplateStr.getMapStr());
		
		return codeTemplateStrDisplay;
	}
	
	/**
	 * 应用当前连接
	 * @param result
	 * @param conBean
	 */
	@RequestMapping(value = "/ibatis/checkConn")
	public void checkConn(ModelMap result , ConnectionBean conBean){
		String driver = conBean.getDriver();
		String url = conBean.getUrl();
		String username = conBean.getUsername();
		String password = conBean.getPassword();
		IbatisToolAction.conn = DBUtil.checkConn(driver, url, username, password);
		if(IbatisToolAction.conn != null){
			db = conBean.getDbType();
			mapend = conBean.getMapend().toLowerCase();
			result.put("code", 200);
			result.put("msg", "连接成功");
		}else{
			result.put("code", 400);
			result.put("msg", "连接失败");
		}
	}

	@RequestMapping(value = "/ibatis/saveConn")
	public void saveConn(ModelMap result, ConnectionBean conBean, HttpServletRequest request) {
		String name = conBean.getConnName();
		String driver = conBean.getDriver();
		String url = conBean.getUrl();
		String username = conBean.getUsername();
		String password = conBean.getPassword();
		Integer dbType = conBean.getDbType();

		StringBuffer content = new StringBuffer();
		content.append(name);
		content.append(SEPARATOR);
		content.append(driver);
		content.append(SEPARATOR);
		content.append(url);
		content.append(SEPARATOR);
		content.append(username);
		content.append(SEPARATOR);
		content.append(password);
		content.append(SEPARATOR);
		content.append(dbType);

		String file = request.getSession().getServletContext().getRealPath("/") + "/template/connHistory.log";
		FileUtil.saveHistoryToFile(file,content.toString());

		result.put("code", 200);
		result.put("msg", "保存成功");
	}

	
	/**
	 * 获取所有表
	 * @param result
	 */
	@RequestMapping(value = "/ibatis/getTableList")
	public void getTableList(ModelMap result){
		if(conn != null){
			String sql = SHOW_TABLE_SQL[db];
			List<String> tableList = DBUtil.getTabaleList(conn, sql);
			result.put("code", 200);
			result.put("msg", "数据库表获取成功");
			result.put("tableList", tableList);			
		}else {
			result.put("code", 400);
			result.put("msg", "请先连接数据库");
		}
	}
	
	private static CodeTemplateStr getFileTemplate(HttpServletRequest request){
		
		String baseDir = request.getSession().getServletContext().getRealPath("/");
		
		File actionfile=new File(baseDir + "/template/norAction_"+Config.actionType+".txt");
		File daofile=new File(baseDir + "template/norDao_"+Config.daoType+".txt");
		File implfile=new File(baseDir + "/template/norDaoImpl_"+Config.daoType+".txt");
		File beanfile=new File(baseDir + "/template/norBean.txt");
		File searchfile=new File(baseDir + "/template/norSearchBean.txt");
		File servicefile=new File(baseDir + "/template/norService.txt");
		File serviceimplfile=new File(baseDir + "/template/norServiceImpl.txt");
		File struts2file=new File(baseDir + "/template/norStruts2.txt");
		File mapfile=new File(baseDir + "/template/norSqlMap_"+ Config.daoType+".txt");
		
		CodeTemplateStr codeTemplateStr = new CodeTemplateStr();
		codeTemplateStr.setActionStr(FileUtil.readTemplateFile(actionfile));
		codeTemplateStr.setDaoStr(FileUtil.readTemplateFile(daofile));
		codeTemplateStr.setDaoImplStr(FileUtil.readTemplateFile(implfile));
		codeTemplateStr.setBeanStr(FileUtil.readTemplateFile(beanfile));
		codeTemplateStr.setSearchBeanStr(FileUtil.readTemplateFile(searchfile));
		codeTemplateStr.setServiceImplStr(FileUtil.readTemplateFile(serviceimplfile));
		codeTemplateStr.setServiceStr(FileUtil.readTemplateFile(servicefile));
		codeTemplateStr.setMapStr(FileUtil.readTemplateFile(mapfile));
		codeTemplateStr.setStruts2Str(FileUtil.readTemplateFile(struts2file));	
		
		return codeTemplateStr;
	}
	
	@RequestMapping(value = "/ibatis/generate")
	public void generate(ModelMap result , HttpServletRequest request , String[] selections, String dirPath, String packageName , String commonPackage){
		
		log.info("selections = "+selections.toString());
		log.info("dirPath = "+dirPath);
		log.info("packageName = "+packageName);
		
		for (String string : selections) {
			log.info("selection = " +string);
		}
		
		FileUtil.writeFile(selections, dirPath, packageName, commonPackage , codeTemplateStr);

		FileUtil.sendFileToWorkspaceFrom(dirPath);
		
		result.put("code", 200);
		result.put("msg", "代码生成成功");
	}
	
}
