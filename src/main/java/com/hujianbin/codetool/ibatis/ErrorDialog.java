package com.hujianbin.codetool.ibatis;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.*;


public class ErrorDialog extends Dialog {

	private Text text;
	protected Object result;
	protected Shell shell;
	
	public ErrorDialog(String caption,Shell parent,int style){
		super(parent,style);
		this.setText(caption);
	}

	/**
	 * Create the dialog
	 * @param parent
	 * @param style
	 */
	public ErrorDialog(Shell parent, int style) {
		super(parent, style);
	}

	/**
	 * Create the dialog
	 * @param parent
	 */
	public ErrorDialog(Shell parent) {
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

	/**
	 * Create contents of the dialog
	 */
	protected void createContents() {
		shell = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		shell.setSize(356, 207);
		shell.setText("出错啦");

		final Canvas canvas = new Canvas(shell, SWT.NONE);
		canvas.setBounds(22, 10, 57, 55);

		final CLabel label = new CLabel(shell, SWT.NONE);
		label.setText("label");
		label.setBounds(105, 30, 86, 18);

		text = new Text(shell, SWT.WRAP | SWT.V_SCROLL | SWT.MULTI | SWT.BORDER);
		text.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		text.setEditable(false);
		text.setBounds(8, 89, 334, 76);
		//
	}

}
