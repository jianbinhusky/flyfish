package com.hujianbin.codetool.ibatis;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.*;

import java.io.*;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class SetupDialog extends Dialog {

	protected Object result;
	private Display display;
	protected Shell shell;
	private Combo combo;
	private String filePath="config.properties";
	private Text importText;
	private Text tablePrefixText;
	private Text tableSplitText;
	private Text columnSplitText;
	private Button btnRadioButton;
	private Button btnRadioButton_1;
	private Text cacheNameText;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public SetupDialog(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		display = getParent().getDisplay();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent(), SWT.TITLE | SWT.SYSTEM_MODAL | SWT.BORDER | SWT.CLOSE);
		shell.setSize(360, 277);
		
		Rectangle rect=display.getBounds();
		int height=rect.height;
		int width=rect.width;
		//shell.setSize(345, 218);
		shell.setBounds((width-345)/2, (height-218)/2, 345, 247);
		
		Rectangle parentBounds = shell.getParent().getBounds(); 
		Rectangle shellBounds = shell.getBounds(); 

		shell.setLocation(parentBounds.x + (parentBounds.width - shellBounds.width)/2, parentBounds.y + (parentBounds.height - shellBounds.height)/2); 
		shell.setText("系统设置");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(23, 10, 49, 17);
		lblNewLabel.setText("字符集");
		
		combo = new Combo(shell, SWT.READ_ONLY);
		combo.setItems(new String[] {"UTF-8", "GBK"});
		combo.setBounds(78, 7, 88, 25);
		
		Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(saveConfig()){
					shell.dispose();
				}else{
					MessageBox msgBox=new MessageBox(shell, SWT.ABORT);
					msgBox.setText("错误");
					msgBox.setMessage("保存失败");					
					msgBox.open();
				}
			}
		});
		button.setBounds(78, 182, 73, 27);
		button.setText("保存");
		
		Button button_1 = new Button(shell, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
			}
		});
		button_1.setBounds(182, 182, 73, 27);
		button_1.setText("消失");
		
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(23, 116, 49, 17);
		label.setText("引入类");
		
		importText = new Text(shell, SWT.BORDER | SWT.MULTI);
		importText.setBounds(78, 113, 225, 63);
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBounds(23, 38, 49, 17);
		lblNewLabel_1.setText("表前缀：");
		
		tablePrefixText = new Text(shell, SWT.BORDER);
		tablePrefixText.setBounds(78, 33, 88, 21);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setAlignment(SWT.RIGHT);
		label_1.setBounds(172, 38, 61, 17);
		label_1.setText("表分割：");
		
		tableSplitText = new Text(shell, SWT.BORDER);
		tableSplitText.setBounds(235, 34, 88, 21);
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setBounds(23, 82, 54, 17);
		label_2.setText("列分割：");
		
		columnSplitText = new Text(shell, SWT.BORDER);
		columnSplitText.setBounds(78, 79, 88, 21);
		
		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setBounds(172, 10, 73, 17);
		lblNewLabel_2.setText("大小写转换：");
		
		btnRadioButton = new Button(shell, SWT.RADIO);
		btnRadioButton.setBounds(251, 8, 33, 16);
		btnRadioButton.setText("是");
		
		btnRadioButton_1 = new Button(shell, SWT.RADIO);
		btnRadioButton_1.setBounds(290, 8, 33, 16);
		btnRadioButton_1.setText("否");
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setBounds(172, 82, 61, 17);
		label_3.setText("缓存类型");
		
		cacheNameText = new Text(shell, SWT.BORDER);
		cacheNameText.setBounds(235, 77, 88, 21);
		
		readConfig();
	}
	
	private void readConfig(){
		File file=new File(filePath);
		if(file.exists()){
			try {
				InputStream in = new BufferedInputStream(new FileInputStream(file));
				ResourceBundle rb = new PropertyResourceBundle(in);
				in.close();
				String encoding=rb.getString("encoding");
				combo.setText(encoding);
				Config.encoding=encoding;
				String tolower=rb.getString("istolower");
				if("1".equals(tolower)){
					btnRadioButton.setSelection(true);
				}else{
					btnRadioButton_1.setSelection(true);
				}
				Config.isToLower=btnRadioButton.getSelection();
				String tablePrefix=rb.getString("table_prefix");
				tablePrefixText.setText(tablePrefix);
				Config.tablePrefix=tablePrefix;
				String tableSplit=rb.getString("table_split");
				tableSplitText.setText(tableSplit);
				Config.tableSplit=tableSplit;
				String columnSplit=rb.getString("column_split");
				columnSplitText.setText(columnSplit);
				Config.columnSplit=columnSplit;
				String cacheName=rb.getString("cache_name");
				cacheNameText.setText(cacheName);
				Config.cacheName=cacheName;
				String importStr=rb.getString("import");
				importText.setText(importStr);
				Config.importStr=importStr;
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	private boolean saveConfig() {
		String encoding = combo.getText();
		Config.encoding = encoding;
		boolean isSelected = btnRadioButton.getSelection();
		Config.isToLower = isSelected;
		String tablePrefix = tablePrefixText.getText();
		Config.tablePrefix = tablePrefix;
		String tableSplit = tableSplitText.getText();
		Config.tableSplit = tableSplit;
		String columnSplit = columnSplitText.getText();
		Config.columnSplit = columnSplit;
		String cacheName = cacheNameText.getText();
		Config.cacheName = cacheName;
		String importStr = importText.getText();
		Config.importStr = importStr;
		ConfigUtil.saveConfig();
		return true;
	}
}
