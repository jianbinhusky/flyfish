package com.hujianbin.common.spring;

import java.text.SimpleDateFormat;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

public class CustomDataBinding implements WebBindingInitializer {

	@Override
	public void initBinder(WebDataBinder arg0, WebRequest arg1) {
		// TODO Auto-generated method stub
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);

		SimpleDateFormat datetimeFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		datetimeFormat.setLenient(false);

		arg0.registerCustomEditor(java.util.Date.class, new CustomDateEditor(
				dateFormat, true));
	}

}
