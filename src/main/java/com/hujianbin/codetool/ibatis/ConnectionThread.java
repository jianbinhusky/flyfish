package com.hujianbin.codetool.ibatis;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionThread extends Thread {
	private Display display;
	private WaitDialog wd;
	private MenuItem item;
	private ConnHistory history;
	public ConnectionThread(MenuItem item,WaitDialog wd){
		this.display=item.getDisplay();
		this.wd=wd;
		this.history=(ConnHistory)item.getData();
		this.item=item;
	}
	
	public void run(){
		Connection conn=DBUtil.getConnection(history);
		if(conn!=null){
			IbatisTools.db=history.getDbIndex();
			
			if(IbatisTools.conn!=null){
				try {
					IbatisTools.conn.close();
					IbatisTools.conn=null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			IbatisTools.conn=conn;
			IbatisTools.mapend=history.getDbType().toLowerCase();
			display.asyncExec(new Runnable(){

				public void run() {
					wd.close();
				}
				
			});
		}else{
			display.asyncExec(new Runnable(){

				public void run() {
					MessageBox msgBox=new MessageBox(display.getActiveShell(), SWT.ABORT);
					msgBox.setText("提示");
					msgBox.setMessage("连接失败！");					
					msgBox.open();
					wd.close();
					item.setSelection(false);
				}
				
			});
		}
	}
}
