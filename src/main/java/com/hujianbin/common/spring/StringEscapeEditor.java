package com.hujianbin.common.spring;

import java.beans.PropertyEditorSupport;

public class StringEscapeEditor extends PropertyEditorSupport {

	private boolean escapeHTML;
	private boolean escapeJavaScript;
	private boolean escapeSQL;

	public StringEscapeEditor() {
		super();
	}

	public StringEscapeEditor(boolean escapeHTML, boolean escapeJavaScript,
			boolean escapeSQL) {
		super();
		this.escapeHTML = escapeHTML;
		this.escapeJavaScript = escapeJavaScript;
		this.escapeSQL = escapeSQL;
	}

	@Override
	public void setAsText(String text) {
		if (text == null) {
			setValue(null);
		} else {
			String value = text;
			
	        value = value.replaceAll(">", "&gt;");
	        value = value.replaceAll("<", "&lt;");
	        value = value.replaceAll("\"", "&quot;");
	        value = value.replaceAll("&", "&amp;");
	        value = value.replaceAll("'", "&#x27;");
	        value = value.replaceAll("/", "&#x2F;");
			setValue(value);
		}
	}

	@Override
	public String getAsText() {
		Object value = getValue();
		return value != null ? value.toString() : "";
	}
}
