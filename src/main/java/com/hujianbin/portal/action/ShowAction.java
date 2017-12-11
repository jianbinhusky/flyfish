package com.hujianbin.portal.action;

import com.hujianbin.basis.bean.BeautyGirl;
import com.hujianbin.basis.search.BeautyGirlSearchBean;
import com.hujianbin.basis.service.BeautyGirlService;
import com.hujianbin.common.spring.BaseAction;
import com.hujianbin.common.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ShowAction extends BaseAction {

	private static int GIRLS_NUM_EACH_SCROLL = 20;

	@Autowired
	private BeautyGirlService beautyGirlService;

	@Value("#{config['img.server.url']}")
	private String imgServerUrl;

	/**
	 * Get
	 * @param result
	 * @param request
	 * @param condition
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "/girl")
	public String showOtherGirls(
			ModelMap result,
			HttpServletRequest request,
			BeautyGirlSearchBean condition,
			@RequestParam(value = "pageno", required = false, defaultValue = "1") int pageNo,
			@RequestParam(value = "pagesize", required = false, defaultValue = "20") int pageSize) {
		condition.setStart((pageNo - 1) * pageSize);
		condition.setCount(pageSize);
		condition.setOrderSql("order by time_stamp asc");
		List<BeautyGirl> beautyGirlList = new ArrayList<BeautyGirl>();
		PageModel pageModel = beautyGirlService
				.queryBeautyGirlByCondition(condition);
		beautyGirlList = (List<BeautyGirl>) pageModel.getData();
		long minTimestamp = beautyGirlList.get(beautyGirlList.size() - 1)
				.getTimeStamp();


		result.put("imgServerUrl", imgServerUrl);
		result.put("minTimestamp", minTimestamp);
		result.put("beautyGirlList", beautyGirlList);

		// Request Info
//		String serverName = request.getServerName();
//		String contextPath = request.getContextPath();
//		String localAddr = request.getLocalAddr();
//		String method = request.getMethod();
//		String pathInfo = request.getPathInfo();
//		String servletPath = request.getServletPath();
//		String scheme = request.getScheme();
				
		return "portal/showGirls";
	}

	/**
	 * Get
	 * @param result
	 * @param condition
	 * @param pageNo
	 * @param pageSize
	 */
	@RequestMapping(value = "/showAnotherGirls")
	public void showAnotherGirls(
			ModelMap result,
			BeautyGirlSearchBean condition,
			@RequestParam(value = "pageno", required = false, defaultValue = "1") int pageNo,
			@RequestParam(value = "pagesize", required = false, defaultValue = "20") int pageSize) {
		System.out.println("pageno = " + pageNo);
		result.clear();
		condition.setStart((pageNo - 1) * pageSize);
		condition.setCount(pageSize);
		condition.setOrderSql("order by time_stamp asc");
		List<BeautyGirl> beautyGirlList = new ArrayList<BeautyGirl>();
		PageModel pageModel = beautyGirlService
				.queryBeautyGirlByCondition(condition);
		beautyGirlList = (List<BeautyGirl>) pageModel.getData();

		result.put("imgServerUrl", imgServerUrl);
		result.put("beautyGirlList", beautyGirlList);

	}
	
	@RequestMapping(value = "/hiBeautyGirls")
	public String showGirls(
			ModelMap result,
			BeautyGirlSearchBean condition,
			@RequestParam(value = "pageno", required = false, defaultValue = "1") int pageNo,
			@RequestParam(value = "pagesize", required = false, defaultValue = "20") int pageSize) {
		condition.setStart((pageNo - 1) * pageSize);
		condition.setCount(pageSize);
		condition.setOrderSql("order by time_stamp desc");
		List<BeautyGirl> beautyGirlList = new ArrayList<BeautyGirl>();
		PageModel pageModel = beautyGirlService
				.queryBeautyGirlByCondition(condition);
		beautyGirlList = (List<BeautyGirl>) pageModel.getData();
		long minTimestamp = beautyGirlList.get(beautyGirlList.size() - 1)
				.getTimeStamp();

		result.put("imgServerUrl", imgServerUrl);
		result.put("minTimestamp", minTimestamp);
		result.put("beautyGirlList", beautyGirlList);
				
		return "portal/index";
	}

	@RequestMapping(value = "/showMoreGirls")
	public void showMoreGirls(ModelMap result, BeautyGirlSearchBean condition,
			long timestamp) {
		result.clear();
		condition.setStart(0);
		condition.setCount(GIRLS_NUM_EACH_SCROLL);
		condition.setLessTimeStamp(timestamp);
		condition.setOrderSql("order by time_stamp desc");
		List<BeautyGirl> beautyGirlList = new ArrayList<BeautyGirl>();
		PageModel pageModel = beautyGirlService
				.queryBeautyGirlByCondition(condition);
		beautyGirlList = (List<BeautyGirl>) pageModel.getData();

		long minTimestamp = beautyGirlList.get(beautyGirlList.size() - 1)
				.getTimeStamp();
		result.put("imgServerUrl", imgServerUrl);
		result.put("minTimestamp", minTimestamp);
		result.put("beautyGirlList", beautyGirlList);

	}

	@RequestMapping(value = "/init")
	public void init() {
		for (int i = 0; i <  1913; i++) {
			String imageUrl = "beauty_girl_" + i + ".jpg";
			BeautyGirl beautyGirl = new BeautyGirl();
			beautyGirl.setImageUrl(imageUrl);
			beautyGirl.setCreateTime(new Date());
			beautyGirl.setTimeStamp(System.currentTimeMillis() - 1000000);
			beautyGirlService.addBeautyGirl(beautyGirl);
		}
	}

	@RequestMapping(value = "/add")
	public void addNewImg(){
		List<BeautyGirl> girls = new ArrayList<BeautyGirl>();
		File file = new File("D://Program Files//MM");
		if(file.exists()){
			File[] files = file.listFiles();
			int count = 0;
			for (File file1 : files) {
				String yearMonth = file1.getName();
				String[] filenames = file1.list();
				for (String filename : filenames) {
					String path = "MM" + "/" + yearMonth + "/" + filename;
					System.out.println(path);
					count++;

					BeautyGirl beautyGirl = new BeautyGirl();
					beautyGirl.setImageUrl(path);
					beautyGirl.setCreateTime(new Date());
					beautyGirl.setTimeStamp(System.currentTimeMillis() - 1000000);
					girls.add(beautyGirl);
				}
			}
			System.out.println("Total = " +count);
			beautyGirlService.batchAddBeautyGirl(girls);
		}

	}

	@RequestMapping(value = "post")
	public String testHtmlFormPost(HttpServletRequest request , ModelMap result){
		String messge = request.getParameter("message");
		result.put("message",messge );
		return "portal/post";
	}

	@RequestMapping(value = "/infinite")
	public String infinite() {
		return "portal/infinite";
	}

	@RequestMapping(value = "/image")
	public String image() {
		return "portal/image";
	}

	@RequestMapping(value = "/gallery")
	public String gallery() {
		return "portal/gallery";
	}

	@RequestMapping(value = "/gallery_button")
	public String gallery_button() {
		return "portal/gallery_button";
	}

//	@RequestMapping(value = "/goLogin")
//	public String goLogin() {
//		return "manage/login";
//	}

	@RequestMapping(value = "/8210")
	public String goWater() {
		return "wwwroot/show";
	}

	@RequestMapping(value = "/bobo")
	public String bobo() {
		return "wwwroot/water";
	}


}