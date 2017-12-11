package com.hujianbin.common.spring;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

@Slf4j
public class CustomSimpleMappingExceptionResolver extends
		SimpleMappingExceptionResolver {

	@Override
	protected ModelAndView doResolveException(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3) {
		String uri=arg0.getRequestURI();
		log.error("请求异常,URI="+uri, arg3);
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("code", 999);
		map.put("msg", "请求异常");
		map.put("exception", arg3);
		Map<String,Object> result=new HashMap<String,Object>();
		result.put("res", map);
		result.put("success", false);
		return new ModelAndView("500",result);
	}

}
