package com.hujianbin.common.captcha;

import com.octo.captcha.engine.CaptchaEngine;
import com.octo.captcha.service.CaptchaServiceException;
import com.octo.captcha.service.captchastore.CaptchaStore;
import com.octo.captcha.service.image.DefaultManageableImageCaptchaService;

public class CustomManageableImageCaptchaService extends
		DefaultManageableImageCaptchaService implements
		CustomImageCaptchaService {

	public CustomManageableImageCaptchaService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomManageableImageCaptchaService(CaptchaStore captchaStore,
			CaptchaEngine captchaEngine, int minGuarantedStorageDelayInSeconds,
			int maxCaptchaStoreSize, int captchaStoreLoadBeforeGarbageCollection) {
		super(captchaStore, captchaEngine, minGuarantedStorageDelayInSeconds,
				maxCaptchaStoreSize, captchaStoreLoadBeforeGarbageCollection);
		// TODO Auto-generated constructor stub
	}

	public CustomManageableImageCaptchaService(
			int minGuarantedStorageDelayInSeconds, int maxCaptchaStoreSize,
			int captchaStoreLoadBeforeGarbageCollection) {
		super(minGuarantedStorageDelayInSeconds, maxCaptchaStoreSize,
				captchaStoreLoadBeforeGarbageCollection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean validateResponseForID(String ID, Object response)
			throws CaptchaServiceException {
		if (!this.store.hasCaptcha(ID)) {
			throw new CaptchaServiceException(
					"Invalid ID, could not validate unexisting or already validated captcha");
		}
		Boolean valid = this.store.getCaptcha(ID).validateResponse(response);
		return valid;
	}

	@Override
	public void removeCaptcha(String sessionId) {
		if(sessionId!=null && this.store.hasCaptcha(sessionId)){  
            this.store.removeCaptcha(sessionId);  
        }
	}

}
