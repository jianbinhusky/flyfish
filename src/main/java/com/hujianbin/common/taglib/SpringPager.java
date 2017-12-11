package com.hujianbin.common.taglib;

import org.springframework.web.servlet.tags.RequestContextAwareTag;

public class SpringPager extends RequestContextAwareTag {

	private Integer curPage;
	private Integer totalPage;
	private Integer pageSize = 10;
	private Integer totalCount = 0;
	private String formId;
	private String baseUrl;
	private String theme;//可定义多种theme，以适配多页面
	private String style;//url重写或form提交
	
	@Override
	protected int doStartTagInternal() throws Exception {
		
		
		
		//EVAL_PAGE表示继续处理视图；SKIP_PAGE表示不处理视图
		return EVAL_PAGE;
	}
	public Integer getCurPage() {
		return curPage;
	}
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public String getFormId() {
		return formId;
	}
	public void setFormId(String formId) {
		this.formId = formId;
	}
	public String getBaseUrl() {
		return baseUrl;
	}
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}

}
