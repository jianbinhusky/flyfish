package com.hujianbin.codetool.ibatis;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;


public class WaitDialog extends Dialog {

	protected Object result;
	protected Shell shell;
	private String msg;

	/**
	 * Create the dialog
	 * @param parent
	 * @param style
	 */
	public WaitDialog(Shell parent, int style) {
		super(parent, style);
	}

	/**
	 * Create the dialog
	 * @param parent
	 */
	public WaitDialog(Shell parent) {
		this(parent, SWT.NONE);
	}

	/**
	 * Open the dialog
	 * @return the result
	 */
	public Object open() {
		createContents();
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		return result;
	}
	
	public void close(){
		shell.dispose();
	}

	/**
	 * Create contents of the dialog
	 */
	protected void createContents() {
		shell = new Shell(getParent(), SWT.APPLICATION_MODAL);
		shell.setAlpha(200);
		shell.setLayout(new FillLayout());
		shell.setSize(197, 90);
		shell.setText("SWT Dialog");
		Rectangle parentBounds = shell.getParent().getBounds(); 
		Rectangle shellBounds = shell.getBounds(); 

		shell.setLocation(parentBounds.x + (parentBounds.width - shellBounds.width)/2, parentBounds.y + (parentBounds.height - shellBounds.height)/2); 

		final CLabel label = new CLabel(shell, SWT.CENTER);
		label.setText(msg);
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
