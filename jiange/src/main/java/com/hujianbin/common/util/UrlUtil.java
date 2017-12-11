package com.hujianbin.common.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class UrlUtil {

	private static String charset="utf-8";
	
	public static String encode(String url,String queryString){  
	    try {
	    	if(queryString!=null&&!"".equals(queryString))
	    		url+="?"+queryString;
			return URLEncoder.encode(url, charset);
		} catch (UnsupportedEncodingException e) {
			
		}
	    return url+"?"+queryString;
	}  
	  
	public static String decode(String source){  
	    try {
			return URLDecoder.decode(source, charset);
		} catch (UnsupportedEncodingException e) {
			
		}
		return source;  
	}
}
