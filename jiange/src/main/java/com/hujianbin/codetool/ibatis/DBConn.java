package com.hujianbin.codetool.ibatis;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConn extends Dialog {

	private Text text_1;
	private Text text_2;
	private Text rootText;
	private Text text;
	private Combo combo;
	protected Object result;
	private Display display=null;
	protected Shell shell;
	private String drivername=null,url=null,user=null,password=null;
	private String[] drivers={"com.mysql.jdbc.Driver",
			"net.sourceforge.jtds.jdbc.Driver",
			"oracle.jdbc.driver.OracleDriver",
			"org.postgresql.Driver","org.h2.Driver"};
	private String[] urls={"jdbc:mysql://<host>:3306/<database>",
			"jdbc:jtds:sqlserver://<host>:1433;DatabaseName=<database>",
			"jdbc:oracle:thin:@<host>:1521:<sid>","jdbc:postgresql://<host>:5432/<database>",
			"jdbc:h2:tcp://<host>/<dir>/<database>"};

	/**
	 * Create the dialog
	 * @param parent
	 * @param style
	 */
	public DBConn(Shell parent, int style) {
		super(parent, style);
	}

	/**
	 * Create the dialog
	 * @param parent
	 */
	public DBConn(Shell parent) {
		this(parent, SWT.NONE);
	}

	/**
	 * Open the dialog
	 * @return the result
	 */
	public Object open() {
		display = getParent().getDisplay();
		createContents();
		shell.open();
		shell.layout();
		
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		return result;
	}

	/**
	 * Create contents of the dialog
	 */
	protected void createContents() {
		shell = new Shell(getParent(), SWT.TITLE | SWT.SYSTEM_MODAL | SWT.BORDER | SWT.CLOSE);
		final GridLayout gridLayout = new GridLayout();
		gridLayout.verticalSpacing = 10;
		gridLayout.horizontalSpacing = 2;
		gridLayout.numColumns = 2;
		shell.setLayout(gridLayout);
		Rectangle rect=display.getBounds();
		int height=rect.height;
		int width=rect.width;
		//shell.setSize(345, 218);
		shell.setBounds((width-345)/2, (height-218)/2, 345, 247);
		
		Rectangle parentBounds = shell.getParent().getBounds(); 
		Rectangle shellBounds = shell.getBounds(); 

		shell.setLocation(parentBounds.x + (parentBounds.width - shellBounds.width)/2, parentBounds.y + (parentBounds.height - shellBounds.height)/2); 
		
		shell.setText("新建数据库连接");

		final Label label_4 = new Label(shell, SWT.RIGHT);
		label_4.setLayoutData(new GridData(72, SWT.DEFAULT));
		label_4.setText("名称：");

		text_1 = new Text(shell, SWT.BORDER);
		text_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		final Label label = new Label(shell, SWT.RIGHT);
		label.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		label.setText("数据库类型：");

		combo = new Combo(shell, SWT.READ_ONLY);
		combo.setText("请选择数据库类型");
		combo.setVisibleItemCount(10);
		combo.setLayoutData(new GridData(233, SWT.DEFAULT));
		combo.add("MySQL");
		combo.add("MSSQLServer");
		combo.add("Oracle");
		combo.add("PostgreSQL");
		combo.add("H2");
		
		combo.addModifyListener(new ModifyListener(){

			public void modifyText(ModifyEvent e) {
				text.setText(urls[combo.getSelectionIndex()]);
			}
			
		});

		final Label label_1 = new Label(shell, SWT.RIGHT);
		label_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		label_1.setText("URL：");

		text = new Text(shell, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		final Label label_2 = new Label(shell, SWT.NONE);
		label_2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		label_2.setText("用户名：");

		rootText = new Text(shell, SWT.BORDER);
		rootText.setText("");
		rootText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		final Label label_3 = new Label(shell, SWT.NONE);
		label_3.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		label_3.setText("密码：");

		text_2 = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		text_2.setText("");
		text_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);

		final Composite composite = new Composite(shell, SWT.NONE);
		final GridData gd_composite = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
		gd_composite.widthHint = 331;
		gd_composite.heightHint = 37;
		composite.setLayoutData(gd_composite);

		final Button button = new Button(composite, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				drivername=combo.getText();
				url=text.getText();
				user=rootText.getText();
				password=text_2.getText();
				MessageBox msgBox=new MessageBox(shell, SWT.ABORT);
				msgBox.setText("提示");
				if(drivername==null||"".equals(drivername.trim())){					
					msgBox.setMessage("请选择数据库类型");					
					msgBox.open();
				}else if(url==null||"".equals(url.trim())){
					msgBox.setMessage("请填写数据库地址");					
					msgBox.open();
				}else if(user==null||"".equals(user.trim())){
					msgBox.setMessage("请填写用户名");					
					msgBox.open();
				}else{
					if(password==null) password="";
					if(IbatisTools.conn!=null){
						try {
							IbatisTools.conn.close();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
					IbatisTools.conn=checkConn(url, user, password);
					if(IbatisTools.conn!=null){
						IbatisTools.db=combo.getSelectionIndex();
						IbatisTools.mapend=combo.getText().toLowerCase();
						msgBox.setMessage("连接成功");					
						msgBox.open();
					}else{
						msgBox.setMessage("连接失败");					
						msgBox.open();
					}
				}
			}
		});
		button.setText("测试");
		button.setBounds(60, 0, 52, 23);

		final Button button_1 = new Button(composite, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				String name=text_1.getText();
				drivername=combo.getText();
				url=text.getText();
				user=rootText.getText();
				password=text_2.getText();
				MessageBox msgBox=new MessageBox(shell, SWT.ABORT);
				msgBox.setText("提示");
				if(drivername==null||"".equals(drivername.trim())){					
					msgBox.setMessage("请选择数据库类型");					
					msgBox.open();
				}else if(url==null||"".equals(url.trim())){
					msgBox.setMessage("请填写数据库地址");					
					msgBox.open();
				}else if(user==null||"".equals(user.trim())){
					msgBox.setMessage("请填写用户名");					
					msgBox.open();
				}else if(name==null||"".equals(name.trim())){
					msgBox.setMessage("请填写名称");					
					msgBox.open();
				}else{
					if(password==null) password="";
					if(IbatisTools.conn!=null){
						try {
							IbatisTools.conn.close();
							IbatisTools.conn=null;
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
					IbatisTools.conn=checkConn(url, user, password);
					if(IbatisTools.conn!=null){
						IbatisTools.db=combo.getSelectionIndex();
						IbatisTools.mapend=combo.getText().toLowerCase();
						HistoryManager hm=new HistoryManager();
						if(!hm.checkNameExists(name)){
							ConnHistory ch=new ConnHistory();
							ch.setName(name);
							ch.setDbType(combo.getText());
							ch.setDriverClass(drivers[combo.getSelectionIndex()]);
							ch.setDbUrl(url);
							ch.setDbUser(user);
							ch.setDbPasswd(password);
							ch.setDbIndex(combo.getSelectionIndex());
							hm.addHistory(ch);
						}else{
							msgBox.setMessage("该名称已存在");					
							msgBox.open();
							return;
						}
						shell.dispose();
					}else{
						msgBox.setMessage("连接失败");					
						msgBox.open();
					}
				}
				
			}
		});
		button_1.setText("保存");
		button_1.setBounds(135, 0, 52, 23);

		final Button button_2 = new Button(composite, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				shell.dispose();
			}
		});
		button_2.setText("取消");
		button_2.setBounds(210, 0, 52, 23);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		//
	}
	
	private Connection checkConn(String url,String user,String password){
		Connection conn=null;
		try {
			Class.forName(drivers[combo.getSelectionIndex()]);
			conn=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			
		}
		return conn;
	}
	
}
