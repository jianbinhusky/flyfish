package com.hujianbin.codetool.ibatis;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ProgressBar;


public class ProcessThread extends Thread {
	private Display display;
	private ProgressBar progressBar;
	
	public ProcessThread(Display display,ProgressBar progressBar){
		this.display = display;
        this.progressBar = progressBar;
	}
	
	 public void run() {

		display.asyncExec(new Runnable() {
			public void run() {
				if (progressBar.isVisible())
					return;
		
				progressBar.setSelection(progressBar.getSelection() + 1);
			}
		});
	}
}
