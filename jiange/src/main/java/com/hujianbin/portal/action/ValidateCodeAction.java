package com.hujianbin.portal.action;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hujianbin.common.captcha.CaptchaServiceSingleton;
import com.hujianbin.common.captcha.CustomManageableImageCaptchaService;

@Controller
@Slf4j
public class ValidateCodeAction {

	@Autowired
	private CustomManageableImageCaptchaService imageCaptchaService;
	/**
	 * 验证码
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="/randcode",method=RequestMethod.GET)
	public void randcode(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String captchaId = request.getSession(true).getId();  
        BufferedImage challenge = (BufferedImage)imageCaptchaService.getChallengeForID(captchaId, request.getLocale());  
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();  
        ImageIO.write(challenge, "jpg", byteArrayOutputStream);
        response.setHeader("Cache-Control", "no-store");    
        response.setHeader("Pragma", "no-cache");    
        response.setDateHeader("Expires", 0);    
        response.setContentType("image/jpeg");    
        ServletOutputStream responseOutputStream = response.getOutputStream();    
        responseOutputStream.write(byteArrayOutputStream.toByteArray());    
        responseOutputStream.flush();    
        responseOutputStream.close();
	}
}
