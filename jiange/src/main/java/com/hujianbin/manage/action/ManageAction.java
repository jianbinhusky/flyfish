package com.hujianbin.manage.action;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hujianbin.basis.bean.SysManager;
import com.hujianbin.basis.service.SysManagerService;
import com.hujianbin.common.spring.BaseAction;
import com.hujianbin.common.util.MD5;

@Controller
@RequestMapping(value = "/manage")
public class ManageAction extends BaseAction {

	@Autowired
	private SysManagerService sysManagerService;

	@RequestMapping(value = "/goLogin")
	public String goLogin() {
		return "manage/login";
	}

	@RequestMapping(value = "/login")
	public String login(ModelMap result, HttpSession session,
			String managername, String password) {
		result.put("success", false);
		SysManager sysManager = new SysManager();
		sysManager.setManagername(managername);
		sysManager.setPassword(MD5.getMD5(password));
		sysManager.setState(1);
		
		sysManager = sysManagerService.getSysManagerByExample(sysManager);
		if (sysManager != null) {
			session.setAttribute("manager", sysManager);
			SysManager newSysManager = new SysManager();
			newSysManager.setId(sysManager.getId());
			newSysManager.setLoginIp(getClientIP());
			newSysManager.setLoginTime(new Date());
			sysManagerService.modifySysManagerByExample(newSysManager);
			result.put("success", true);
		} else {
			result.put("msg", "用户名或密码错误，或者帐号已被禁用");
		}

		return "manage/index";
	}

	@RequestMapping(value = "/uploadify")
	public String goUploadify() {
		return "manage/uploadify";
	}

}
