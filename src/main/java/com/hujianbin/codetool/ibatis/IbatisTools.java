package com.hujianbin.codetool.ibatis;


import com.hujianbin.codetool.swtdesigner.SWTResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

import java.io.*;
import java.sql.Connection;


public class IbatisTools {

	private Text introText;
	private ProgressBar hBar1;
	private Composite composite_2;
	private TabFolder tabFolder;
	private Composite composite;
	private Shell shell=null;
	private Text sqlMapText;
	private Text beanText;
	private Text daoImplText;
	private Text daoText;
	private Text pathtext;
	private Text cnzuoguodangText;
	private Button button;
	private List list;
	private DBConn dbconn=null;
	private String[] showtable={"show tables",
			"SELECT NAME TABLE_NAME FROM SYS.TABLES WHERE TYPE='U'",
			"SELECT TABLE_NAME FROM USER_ALL_TABLES ORDER BY TABLE_NAME",
			"select tablename from pg_tables where schemaname='public' order by tablename",
			"show tables"};
	public static Connection conn=null;
	public static int db=-1;
	public static String mapend="";
	
	private File actionfile=new File("template/norAction.txt");
	private File daofile=new File("template/norDao.txt");
	private File implfile=new File("template/norDaoImpl.txt");
	private File beanfile=new File("template/norBean.txt");
	private File searchfile=new File("template/norSearchBean.txt");
	private File servicefile=new File("template/norService.txt");
	private File serviceimplfile=new File("template/norServiceImpl.txt");
	private File struts2file=new File("template/norStruts2.txt");
	private File mapfile=null;
	private Text searchBeanText;
	private Text serviceText;
	private Text serviceImplText;
	private Text actionText;
	private Text struts2Text;
	/**
	 * Launch the application
	 * @param args
	 */
	public static void main(String[] args) {
		
		//ConfigUtil.init();

		try {
			IbatisTools window = new IbatisTools();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window
	 */
	public void open() {
		final Display display = Display.getDefault();
		shell = new Shell();
		shell.addShellListener(new ShellAdapter() {
			public void shellClosed(final ShellEvent e) {
				String packageName=cnzuoguodangText.getText();
				Config.packageName=packageName;
				String fileDir=pathtext.getText();
				Config.fileDir=fileDir;
				ConfigUtil.saveConfig();
				System.exit(0);
			}
		});
		shell.setImage(SWTResourceManager.getImage(IbatisTools.class, "/com/sun/java/swing/plaf/windows/icons/Computer.gif"));
		shell.setLayout(new FillLayout());
		shell.setSize(604, 418);
		shell.setText("Ibatis自动生成工具");
		shell.open();

		final SashForm sashForm = new SashForm(shell, SWT.NONE);
		//sashForm.setWeights(new int[]{30,70});
		final SashForm sashForm_1 = new SashForm(sashForm, SWT.VERTICAL);
		sashForm_1.setMaximizedControl(hBar1);

		composite = new Composite(sashForm_1, SWT.NONE);

		hBar1 = new ProgressBar(composite, SWT.HORIZONTAL
				| SWT.INDETERMINATE);

		hBar1.setBounds(5, 35, 170, 17);
		hBar1.setVisible(false);
		final Button button_1 = new Button(composite, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				if(conn!=null){
					hBar1.setVisible(true);
					button_1.setEnabled(false);
					
					getMapContent();
					new ProcessThread(display,hBar1).start();
					new TableThread(display,list,hBar1,button_1,conn,showtable[db]).start();
					
				}else{
					MessageBox msgBox=new MessageBox(shell, SWT.ABORT);
					msgBox.setText("提示");
					msgBox.setMessage("请先设置数据库");					
					msgBox.open();
				}
			}
		});
		button_1.setText("获取表");
		button_1.setBounds(54, 10, 62, 23);

		
		final Composite composite_1 = new Composite(sashForm_1, SWT.NONE);
		final FillLayout fillLayout = new FillLayout();
		fillLayout.marginWidth = 20;
		composite_1.setLayout(fillLayout);

		list = new List(composite_1, SWT.V_SCROLL | SWT.MULTI | SWT.BORDER);
		list.addKeyListener(new KeyAdapter() {
			public void keyReleased(final KeyEvent e) {
				int c=e.character;
				if(c==8||c==127){
					int[] indeces=list.getSelectionIndices();
					for(int i=indeces.length-1;i>=0;i--){
						list.remove(indeces[i]);
					}
				}
			}
		});

		composite_2 = new Composite(sashForm_1, SWT.NONE);
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		composite_2.setLayout(gridLayout);

		final Label label = new Label(composite_2, SWT.NONE);
		label.setText("包名：");

		cnzuoguodangText = new Text(composite_2, SWT.BORDER);
		final GridData gd_cnzuoguodangText = new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1);
		gd_cnzuoguodangText.widthHint = 119;
		cnzuoguodangText.setLayoutData(gd_cnzuoguodangText);
		cnzuoguodangText.setText("com.xiaohu.ibatis");

		final Label label_1 = new Label(composite_2, SWT.NONE);
		label_1.setText("路径：");

		pathtext = new Text(composite_2, SWT.BORDER);
		final GridData gd_pathtext = new GridData(SWT.FILL, SWT.CENTER, false, false);
		gd_pathtext.widthHint = 89;
		pathtext.setLayoutData(gd_pathtext);
		pathtext.setEditable(false);

		final Button pathbtn = new Button(composite_2, SWT.NONE);
		final GridData gd_pathbtn = new GridData(SWT.FILL, SWT.CENTER, false, false);
		gd_pathbtn.widthHint = 26;
		pathbtn.setLayoutData(gd_pathbtn);
		pathbtn.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				DirectoryDialog fd=new DirectoryDialog(shell,SWT.OPEN);
				String oldPath=pathtext.getText();
				if(oldPath!=null&&!"".equals(oldPath))
					fd.setFilterPath(oldPath);
				String str=fd.open();
				if(str!=null)
					pathtext.setText(str);
			}
		});
		pathbtn.setText("...");
		new Label(composite_2, SWT.NONE);

		button = new Button(composite_2, SWT.NONE);
		button.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false));
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				String saveDir=pathtext.getText();
				if(saveDir==null||"".equals(saveDir)){
					MessageBox msgBox=new MessageBox(shell, SWT.ABORT);
					msgBox.setText("提示");
					msgBox.setMessage("请选择文件保存路径");					
					msgBox.open();
					return;
				}
				try {
					writeFile(display,saveDir);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		button.setText("应用");
		new Label(composite_2, SWT.NONE);
		sashForm_1.setWeights(new int[] {54, 205, 95});

		tabFolder = new TabFolder(sashForm, SWT.NONE);

		final TabItem introTabItem = new TabItem(tabFolder, SWT.NONE);
		introTabItem.setText("说明");

		introText = new Text(tabFolder, SWT.WRAP | SWT.V_SCROLL | SWT.READ_ONLY | SWT.BORDER);
		introText.setEditable(false);
		StringBuffer introStr=new StringBuffer();
		introStr.append("帮助说明\r\n");
		introStr.append("第1步，连接数据库\r\n");
		introStr.append("第2步，获取表\r\n");
		introStr.append("第3步，选择生成对应代码的表\r\n");
		introStr.append("第4步，修改包名和选择文件保存路径");
		introText.setText(introStr.toString());
		introText.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		introTabItem.setControl(introText);
		
		TabItem tbtmAction = new TabItem(tabFolder, SWT.NONE);
		tbtmAction.setText("Action");
		
		actionText = new Text(tabFolder, SWT.V_SCROLL | SWT.MULTI | SWT.H_SCROLL | SWT.BORDER);
		actionText.setFont(SWTResourceManager.getFont("宋体", 11, SWT.NONE));
		tbtmAction.setControl(actionText);
		
		TabItem tbtmService = new TabItem(tabFolder, SWT.NONE);
		tbtmService.setText("Service");
		
		serviceText = new Text(tabFolder, SWT.V_SCROLL | SWT.MULTI | SWT.H_SCROLL | SWT.BORDER);
		serviceText.setFont(SWTResourceManager.getFont("宋体", 11, SWT.NONE));
		tbtmService.setControl(serviceText);
		
		TabItem tbtmServiceimpl = new TabItem(tabFolder, SWT.NONE);
		tbtmServiceimpl.setText("ServiceImpl");
		
		serviceImplText = new Text(tabFolder, SWT.V_SCROLL | SWT.MULTI | SWT.H_SCROLL | SWT.BORDER);
		serviceImplText.setFont(SWTResourceManager.getFont("宋体", 11, SWT.NONE));
		tbtmServiceimpl.setControl(serviceImplText);
		
		final TabItem daoTabItem = new TabItem(tabFolder, SWT.NONE);
		daoTabItem.setText("Dao");


		daoText = new Text(tabFolder, SWT.V_SCROLL | SWT.MULTI | SWT.H_SCROLL | SWT.BORDER);
		daoText.setFont(SWTResourceManager.getFont("宋体", 11, SWT.NONE));
		daoText.setText("选择数据库后会加载对应的模板文件");
		daoTabItem.setControl(daoText);

		final TabItem daoImplTabItem = new TabItem(tabFolder, SWT.NONE);
		daoImplTabItem.setText("DaoImpl");

		daoImplText = new Text(tabFolder, SWT.V_SCROLL | SWT.MULTI | SWT.H_SCROLL | SWT.BORDER);
		daoImplText.setFont(SWTResourceManager.getFont("宋体", 11, SWT.NONE));
		daoImplText.setText("选择数据库后会加载对应的模板文件");
		daoImplTabItem.setControl(daoImplText);

		final TabItem beanTabItem = new TabItem(tabFolder, SWT.NONE);
		beanTabItem.setText("Bean");

		beanText = new Text(tabFolder, SWT.V_SCROLL | SWT.MULTI | SWT.H_SCROLL | SWT.BORDER);
		beanText.setFont(SWTResourceManager.getFont("宋体", 11, SWT.NONE));
		beanTabItem.setControl(beanText);

		TabItem tbtmSearchBean = new TabItem(tabFolder, SWT.NONE);
		tbtmSearchBean.setText("SearchBean");
		
		searchBeanText = new Text(tabFolder, SWT.V_SCROLL | SWT.MULTI | SWT.H_SCROLL | SWT.BORDER);
		tbtmSearchBean.setControl(searchBeanText);
		
		final TabItem sqlMapTabItem = new TabItem(tabFolder, SWT.NONE);
		sqlMapTabItem.setText("SqlMap");

		sqlMapText = new Text(tabFolder, SWT.V_SCROLL | SWT.MULTI | SWT.H_SCROLL | SWT.BORDER);
		sqlMapText.setFont(SWTResourceManager.getFont("宋体", 11, SWT.NONE));
		sqlMapText.setText("选择数据库后会加载对应的map文件");
		sqlMapTabItem.setControl(sqlMapText);
		
		TabItem struts2TabItem = new TabItem(tabFolder, SWT.NONE);
		struts2TabItem.setText("Struts2");
		
		struts2Text = new Text(tabFolder, SWT.V_SCROLL | SWT.MULTI | SWT.H_SCROLL | SWT.BORDER);
		struts2Text.setFont(SWTResourceManager.getFont("宋体", 11, SWT.NONE));
		struts2TabItem.setControl(struts2Text);
		
		sashForm.setWeights(new int[] {179, 414 });

		final Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);

		final MenuItem newSubmenuMenuItem = new MenuItem(menu, SWT.CASCADE);
		newSubmenuMenuItem.setText("系统");

		final Menu menu_1 = new Menu(newSubmenuMenuItem);
		newSubmenuMenuItem.setMenu(menu_1);

		final MenuItem newItemMenuItem = new MenuItem(menu_1, SWT.NONE);
		newItemMenuItem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				dbconn=new DBConn(shell,SWT.ABORT);
				dbconn.open();
			}
		});
		newItemMenuItem.setText("新建");

		final MenuItem newItemMenuItem_4 = new MenuItem(menu_1, SWT.NONE);
		newItemMenuItem_4.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				String path=pathtext.getText();
				if(path!=null&&!"".equals(path)){
					try {
						Runtime.getRuntime().exec("explorer "+path);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		newItemMenuItem_4.setText("打开");

		final MenuItem newSubmenuMenuItem_2 = new MenuItem(menu_1, SWT.CASCADE);
		newSubmenuMenuItem_2.setText("历史");

		final Menu menu_3 = new Menu(newSubmenuMenuItem_2);
		newSubmenuMenuItem_2.setMenu(menu_3);

		final MenuItem newItemMenuItem_3 = new MenuItem(menu_1, SWT.NONE);
		newItemMenuItem_3.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				HistoryManager hm=new HistoryManager();
				hm.clearHistory();
				MenuItem[] items=menu_3.getItems();
				for(MenuItem menuItem:items){
					menuItem.getText();
					menuItem.dispose();
				}
				MenuItem cmi=new MenuItem(menu_3,SWT.MENU);
				cmi.setText("无");
				cmi.setEnabled(false);
			}
		});
		newItemMenuItem_3.setText("清空历史");

		final MenuItem newItemMenuItem_1 = new MenuItem(menu_1, SWT.NONE);
		newItemMenuItem_1.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				String packageName=cnzuoguodangText.getText();
				Config.packageName=packageName;
				String fileDir=pathtext.getText();
				Config.fileDir=fileDir;
				ConfigUtil.saveConfig();
				System.exit(0);
			}
		});
		newItemMenuItem_1.setText("退出");
		
		MenuItem mntmNewSubmenu = new MenuItem(menu, SWT.CASCADE);
		mntmNewSubmenu.setText("设置");
		
		Menu menu_4 = new Menu(mntmNewSubmenu);
		mntmNewSubmenu.setMenu(menu_4);
		
		MenuItem menuItem = new MenuItem(menu_4, SWT.NONE);
		menuItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				SetupDialog sd=new SetupDialog(shell, SWT.ABORT);
				sd.open();
			}
		});
		menuItem.setText("系统设置");

		final MenuItem newSubmenuMenuItem_1 = new MenuItem(menu, SWT.CASCADE);
		newSubmenuMenuItem_1.setText("帮助");

		final Menu menu_2 = new Menu(newSubmenuMenuItem_1);
		newSubmenuMenuItem_1.setMenu(menu_2);

		final MenuItem newItemMenuItem_2 = new MenuItem(menu_2, SWT.NONE);
		newItemMenuItem_2.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				About about=new About(shell,SWT.ABORT);
				about.open();
			}
		});
		newItemMenuItem_2.setText("关于");
		shell.layout();
		init(display,menu_3, actionfile, servicefile, serviceimplfile, daofile, implfile, beanfile, searchfile,struts2file, actionText, serviceText, serviceImplText, daoText, daoImplText, searchBeanText, beanText,struts2Text);
		
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}
	
	private void getMapContent(){
		actionfile=new File("template/norAction_"+Config.actionType+".txt");
		mapfile=new File("template/norSqlMap_"+Config.daoType+".txt");
		daofile=new File("template/norDao_"+Config.daoType+".txt");
		implfile=new File("template/norDaoImpl_"+Config.daoType+".txt");
		try {
			String linedata=null;
			BufferedReader buf=new BufferedReader(new InputStreamReader(new FileInputStream(actionfile)));
			StringBuffer actionBuf=new StringBuffer();
			while((linedata=buf.readLine())!=null){
				actionBuf.append(linedata).append("\r\n");
			}
			buf.close();
			actionText.setText(actionBuf.toString());
			
			buf=new BufferedReader(new InputStreamReader(new FileInputStream(mapfile)));
			linedata=null;
			StringBuffer sqlMapBuf=new StringBuffer();
			while((linedata=buf.readLine())!=null){
				sqlMapBuf.append(linedata).append("\r\n");
			}
			buf.close();
			sqlMapText.setText(sqlMapBuf.toString());
			
			buf=new BufferedReader(new InputStreamReader(new FileInputStream(daofile)));
			StringBuffer daoBuf=new StringBuffer();
			
			while((linedata=buf.readLine())!=null){
				daoBuf.append(linedata).append("\r\n");
			}
			buf.close();
			daoText.setText(daoBuf.toString());
			buf=new BufferedReader(new InputStreamReader(new FileInputStream(implfile)));
			StringBuffer daoImplBuf=new StringBuffer();
			while((linedata=buf.readLine())!=null){
				daoImplBuf.append(linedata).append("\r\n");
			}
			buf.close();
			daoImplText.setText(daoImplBuf.toString());
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	}
	
	
	/**
	 *
	 * @param display
	 * @param dirPath
	 * @throws Exception
	 */
	private void writeFile(Display display,String dirPath) throws Exception{
		String[] selectiont=list.getSelection();
		String packageName=cnzuoguodangText.getText();
		String actionStr=actionText.getText();
		String daoStr=daoText.getText();
		String daoImplStr=daoImplText.getText();
		String beanStr=beanText.getText();
		String mapStr=sqlMapText.getText();
		String searchStr=searchBeanText.getText();
		String serviceStr=serviceText.getText();
		String serviceImplStr=serviceImplText.getText();
		String struts2Str=struts2Text.getText();
		hBar1.setVisible(true);
		button.setEnabled(false);
		new ProcessThread(display,hBar1).start();
		new WriteFileThread(display,hBar1,button,dirPath,selectiont,daoStr,daoImplStr,beanStr,mapStr,searchStr,serviceStr,serviceImplStr,actionStr,struts2Str,packageName).start();
	}
	
	private void init(Display display,Menu historyMenu,File actionFile,File serviceFile,File serviceImplFile,File daoFile,File daoImplFile,File beanFile,File searchBeanFile,File struts2File,Text actionText,Text serviceText,Text serviceImplText,Text daoText,Text daoImplText,Text searchBeanText,Text beanText,Text struts2Text){
		new InitThread(display, historyMenu,actionFile, serviceFile, serviceImplFile, daoFile, daoImplFile, beanFile, searchBeanFile,struts2File, actionText, serviceText, serviceImplText, daoText, daoImplText, searchBeanText, beanText,struts2Text,cnzuoguodangText,pathtext).start();
	}
	
}

/**
 * 
 * @author user
 *
 */
class HistoryMenuItemListener implements SelectionListener{

	private Shell shell;
	public HistoryMenuItemListener(Shell shell){
		this.shell=shell;
	}
	public void widgetDefaultSelected(SelectionEvent e) {
		
	}

	public void widgetSelected(SelectionEvent e) {
		Object source=e.getSource();
		if(source!=null){
			MenuItem item=(MenuItem)source;
			if(item.getSelection()){
				WaitDialog wd=new WaitDialog(shell,SWT.Activate);
				wd.setMsg("连接中...");
				new ConnectionThread(item,wd).start();
				wd.open();
			}
		}
	}
	
}
