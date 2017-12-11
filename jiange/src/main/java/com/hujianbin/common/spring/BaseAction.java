package com.hujianbin.common.spring;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.hujianbin.common.util.StringUtil;

public class BaseAction {
	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		// binder.registerCustomEditor(String.class, new
		// StringEscapeEditor(true, true, true));
	}

	public String getClientIP() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	public void responseFile(String dir, String fileName, String showName,
			HttpServletResponse response) {
		File file = new File(dir + fileName);
		if (file.exists()) {
			response.setContentType("application/x-download");
			response.setHeader("pragma", "No-cache");
			response.setHeader("Content-Length", String.valueOf(file.length()));
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			response.setHeader(
					"Content-Disposition",
					"attachment; filename="
							+ StringUtil.getUtf8Encode(showName
									+ fileName.substring(fileName
											.lastIndexOf("."))));
			response.setContentLength((int) file.length());
			OutputStream output = null;
			FileInputStream fis = null;
			try {
				output = response.getOutputStream();
				fis = new FileInputStream(file);
				byte[] b = new byte[1024];
				int i = 0;
				while ((i = fis.read(b)) > 0) {
					output.write(b, 0, i);
				}
				output.flush();
				if (fis != null) {
					fis.close();
					fis = null;
				}
				if (output != null) {
					output.close();
					output = null;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {

			}

		} else {
			try {
				PrintWriter out = response.getWriter();
				out.write("您访问的文件不存在,请重试.");
				out.write("<a href=\"javascript:void(0)\" onclick=\"javascript:window.history.back(1);\">返回</a>");
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}
