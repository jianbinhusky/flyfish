package com.hujianbin.manage.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class ManageInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		//拦截未登录

		HttpSession session=arg0.getSession();
		Object obj = session.getAttribute("manager");
		if (obj == null) {
			String from = arg0.getRequestURL().toString();
			String queryString = arg0.getQueryString();
			System.out.println("from == " + from);
			System.out.println("queryString == " + queryString);
			if (queryString != null && !"".equals(queryString)) {
				from += "?" + queryString;
			}
			from = com.hujianbin.common.util.UrlUtil.encode(from, "");
			arg1.sendRedirect(arg0.getContextPath()
					+ "/manage/goLogin.htm?from=" + from);
		}
		return true;
	}

}
