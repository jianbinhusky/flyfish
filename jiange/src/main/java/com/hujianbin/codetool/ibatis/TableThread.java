package com.hujianbin.codetool.ibatis;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.ProgressBar;

import java.sql.Connection;


public class TableThread extends Thread {

	private Display display;
	private List list;
	private ProgressBar progressBar;
	private Button btn;
	private Connection conn;
	private String sql;
	
	public TableThread(Display display,List list,ProgressBar progressBar,Button btn,Connection conn,String sql){
		this.display=display;
		this.list=list;
		this.progressBar=progressBar;
		this.btn=btn;
		this.conn=conn;
		this.sql=sql;
	}
	
	public void run(){
		final String[] allt=DBUtil.getAllTables(conn, sql);
		if (allt != null) {
			display.asyncExec(new Runnable() {
				public void run() {
					if(display.isDisposed())
						return;
					list.removeAll();
					list.setItems(allt);
					progressBar.setVisible(false);
	            	progressBar.setSelection(0);
	            	btn.setEnabled(true);
				}
			});
		}
		
	}
}
