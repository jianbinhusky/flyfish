package com.hujianbin.manage.action;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.hujianbin.common.spring.BaseAction;
import com.hujianbin.common.spring.LogAnnotation;
import com.hujianbin.common.util.StringUtil;

@Controller
@RequestMapping(value="/manage")
@Slf4j
public class UploadAction extends BaseAction{

	@RequestMapping(value="/upload")
	@LogAnnotation(module="上传管理",action="上传Logo")
	public void upload(ModelMap result,HttpServletRequest request){
		log.info("uploadNewsLogo");
		result.clear();
		result.put("success", false);
		String baseDir=request.getSession().getServletContext().getRealPath("/");
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
            MultipartFile mf = entity.getValue();    
            String fileName = mf.getOriginalFilename();  
            
            String uuid = StringUtil.getUUID();
			String newFileName = uuid+fileName.substring(fileName.lastIndexOf("."));
			File dir=new File(baseDir+"/upload/logo/");
			if(!dir.exists()){
				dir.mkdirs();
			}
			String file = baseDir+"/upload/logo/"+newFileName;
            File uploadFile = new File(file);   
            
            try { 
                FileCopyUtils.copy(mf.getBytes(), uploadFile);
                result.put("success", true);
				result.put("fileName", newFileName);
            }catch(Exception e){
            	log.info("上传文件异常",e);
            }
		}
	}
	
	@RequestMapping(value="/uploadFile")
	@LogAnnotation(module="上传管理",action="上传文件")
	public void uploadFile(ModelMap result,HttpServletRequest request){
		log.info("uploadNewsLogo");
		result.clear();
		result.put("success", false);
		String baseDir=request.getSession().getServletContext().getRealPath("/");
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
            MultipartFile mf = entity.getValue();    
            String fileName = mf.getOriginalFilename();  
            
            //String uuid = StringUtil.getUUID();
			//String newFileName = uuid+fileName.substring(fileName.lastIndexOf("."));
			File dir=new File(baseDir+"/upload/file/");
			if(!dir.exists()){
				dir.mkdirs();
			}
			String file = baseDir+"/upload/file/"+fileName;
            File uploadFile = new File(file);   
            
            try {
            	if(uploadFile.exists()){
            		for(int i=1;i<100;i++){
            			String tmpFileName=fileName.substring(0,fileName.lastIndexOf("."))+"("+i+")"+fileName.substring(fileName.lastIndexOf("."));
            			uploadFile=new File(baseDir+"/upload/file/"+tmpFileName);
            			if(!uploadFile.exists()){
            				fileName=tmpFileName;
            				break;
            			}
            		}
            	}
                FileCopyUtils.copy(mf.getBytes(), uploadFile);
                result.put("success", true);
				result.put("fileName", fileName);
            }catch(Exception e){
            	log.info("上传文件异常",e);
            }
		}
	}
	
}
