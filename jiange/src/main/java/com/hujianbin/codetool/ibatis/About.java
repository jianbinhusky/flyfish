package com.hujianbin.codetool.ibatis;

import com.hujianbin.codetool.swtdesigner.SWTResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.ole.win32.*;
import org.eclipse.swt.widgets.*;


public class About extends Dialog {

	private StyledText styledText;
	protected Object result;
	private Display display = null;
	protected Shell shell;

	/**
	 * Create the dialog
	 * @param parent
	 * @param style
	 */
	public About(Shell parent, int style) {
		super(parent, style);
	}

	/**
	 * Create the dialog
	 * @param parent
	 */
	public About(Shell parent) {
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
		Rectangle rect=display.getBounds();
		int height=rect.height;
		int width=rect.width;
		shell = new Shell(getParent(), SWT.APPLICATION_MODAL | SWT.NO_TRIM);
		shell.setAlpha(220);
		shell.setBounds((width-347)/2,(height-245)/2,347, 245);
		Rectangle parentBounds = shell.getParent().getBounds(); 
		Rectangle shellBounds = shell.getBounds(); 

		shell.setLocation(parentBounds.x + (parentBounds.width - shellBounds.width)/2, parentBounds.y + (parentBounds.height - shellBounds.height)/2); 
		shell.setText("关于");
		shell.addMouseListener(new MouseAdapter() {
			public void mouseDown(final MouseEvent e) {
				shell.dispose();
			}
		});

		final Canvas canvas = new Canvas(shell, SWT.NONE);
		canvas.setBackgroundImage(SWTResourceManager.getImage(About.class, "/images.jpg"));
		canvas.setBounds(0, 0, 118, 243);

		final CLabel label = new CLabel(shell, SWT.NONE);
		label.setText("ibatis代码生成工具");
		label.setBounds(173, 10, 118, 18);

		final CLabel c2011Label = new CLabel(shell, SWT.NONE);
		c2011Label.setText("(c)2011 ");
		c2011Label.setBounds(173, 34, 54, 18);
		
		Control[] children=shell.getChildren();

		final Link eclipseorgLink = new Link(shell, SWT.NONE);
		eclipseorgLink.setText("<a href=\"mailto:zuoguodang@163.com\">左国党</a>");
		eclipseorgLink.setBounds(230, 37, 45, 18);
		eclipseorgLink.addMouseListener(new MouseAdapter(){

			@Override
			public void mouseDown(MouseEvent e) {
				 try {
					OleFrame frame = new OleFrame(shell, SWT.NONE);
					OleClientSite site = new OleClientSite(frame, SWT.NONE,"OVCtl.OVCtl");
					site.doVerb(OLE.OLEIVERB_INPLACEACTIVATE);
					OleClientSite site2 = new OleClientSite(frame, SWT.NONE,"Outlook.Application");
					OleAutomation outlook = new OleAutomation(site2);
					OleAutomation mail = invoke(outlook, "CreateItem", 0).getAutomation();
					setProperty(mail, "To", "zuoguodang@163.com");
					setProperty(mail, "BodyFormat", 2 );
					setProperty(mail, "Subject", "Ibatis代码生成工具问题");
					setProperty(mail, "HtmlBody","<html>Hello,<p>请在此处把你的问题描述清楚，谢谢。</html>");
					invoke(mail, "Display");
					return;
				} catch (Exception e1) {
					MessageBox mb=new MessageBox(shell);
					mb.setText("出错啦");
					mb.setMessage("无法启动邮件客户端，请手工发邮件到zuoguodang@163.com");
					mb.open();
				}
				shell.dispose();
			}
			
		});

		styledText = new StyledText(shell, SWT.BORDER|SWT.V_SCROLL);
		styledText.setEditable(false);
		styledText.setWordWrap(true);
		styledText.setBounds(131, 135, 200, 98);
		//styledText.sets
		final String desc="从2009年就准备写一个这样的工具直到现在才完成第一个版本，谢谢大家";
		final String[] log={"更新记录：","1.0完成了基本功能","1.1增加了数据库连接历史"};
		new Thread(new Runnable(){

			public void run() {
				for (int i = 0; i < desc.length(); i++) {
					final String tmp = String.valueOf(desc.charAt(i));
					display.asyncExec(new Runnable() {
						public void run() {
							if (shell.isDisposed())
								return;
							styledText.setText(styledText.getText() + tmp);
							styledText.setSelection(styledText.getCharCount());
						}

					});
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				for (int i = 0; i < log.length; i++) {
					final String tmp = log[i];
					display.asyncExec(new Runnable() {
						public void run() {
							if (shell.isDisposed())
								return;
							styledText.setText(styledText.getText() + "\n"+ tmp);
							styledText.setSelection(styledText.getCharCount());
						}
					});
					try {
						Thread.sleep(500);
						if(i==log.length-1)
							Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				display.asyncExec(new Runnable() {
					public void run() {
						if (shell.isDisposed())
							return;
						shell.dispose();
					}
				});

			}
			
		}).start();
		for (Control control : children) {
			control.addMouseListener(new MouseAdapter(){
				public void mouseDown(final MouseEvent e) {
					shell.dispose();
				}
			});
		};
		
	}
	
	@SuppressWarnings("unused")
	private static OleAutomation getProperty(OleAutomation auto, String name) {
		Variant varResult = auto.getProperty(property(auto, name));
		if (varResult != null && varResult.getType() != OLE.VT_EMPTY) {
			OleAutomation result = varResult.getAutomation();
			varResult.dispose();
			return result;
		}
		return null;
	}

	@SuppressWarnings("unused")
	private static Variant invoke(OleAutomation auto, String command,
			String value) {
		return auto.invoke(property(auto, command),
				new Variant[] { new Variant(value) });
	}

	private static Variant invoke(OleAutomation auto, String command) {
		return auto.invoke(property(auto, command));
	}

	private static Variant invoke(OleAutomation auto, String command, int value) {
		return auto.invoke(property(auto, command),
				new Variant[] { new Variant(value) });
	}

	private static boolean setProperty(OleAutomation auto, String name,
			String value) {
		return auto.setProperty(property(auto, name), new Variant(value));
	}

	private static boolean setProperty(OleAutomation auto, String name,
			int value) {
		return auto.setProperty(property(auto, name), new Variant(value));
	}

	private static int property(OleAutomation auto, String name) {
		return auto.getIDsOfNames(new String[] { name })[0];
	}


}
