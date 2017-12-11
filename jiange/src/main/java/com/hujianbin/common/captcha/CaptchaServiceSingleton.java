package com.hujianbin.common.captcha;

import com.octo.captcha.service.captchastore.FastHashMapCaptchaStore;
import com.octo.captcha.service.image.DefaultManageableImageCaptchaService;
import com.octo.captcha.service.image.ImageCaptchaService;

public class CaptchaServiceSingleton {

	 private static CustomImageCaptchaService instance = new CustomManageableImageCaptchaService(new FastHashMapCaptchaStore(), new DefaultCaptchaEngine(), 180, 100000 , 75000);  
	 public static CustomImageCaptchaService getInstance(){  
	    return instance;  
	 }
}
