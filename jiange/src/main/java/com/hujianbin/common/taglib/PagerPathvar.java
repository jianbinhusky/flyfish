package com.hujianbin.common.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * @author user
 * 
 */
public class PagerPathvar extends TagSupport {

	private static final long serialVersionUID = 1L;

	private Integer curPage;
	private Integer totalPage;
	private Integer pageSize = 10;
	private Integer totalCount = 0;
	private String formId;
	private String baseUrl;
	private String theme;
	private String style;

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	@Override
	public int doStartTag() throws JspException {

		JspWriter out = pageContext.getOut();

		String ctx = this.pageContext.getServletContext().getContextPath();
		String path = ctx + baseUrl;

		int pageNumber = 0;
		if (totalPage % pageSize == 0) {
			pageNumber = totalPage / pageSize;
		} else {
			pageNumber = (totalPage / pageSize) + 1;
		}
		if (curPage < 1) {
			curPage = 1;
		}

		try {
			if (pageNumber > 0) {
					
				out.print("<ul class=\"pagination\">");
				int start = 1;
				int end = totalPage;
				for (int i = 2; i >= 1; i--) {
					if ((curPage - i) >= 1) {
						start = curPage - i;
						break;
					}
				}
				for (int i = 2; i >= 1; i--) {
					if ((curPage + i) <= totalPage) {
						end = curPage + i;
						break;
					}
				}
				// 如果小于9则右侧补齐
				if (end - start + 1 <= 5) {
					Integer padLen = 5 - (end - start + 1);
					for (int i = padLen; i >= 1; i--) {
						if ((end + i) <= totalPage) {
							end = end + i;
							break;
						}
					}
				}

				// 如果还小于9左侧补齐
				if (end - start + 1 <= 5) {
					Integer padLen = 5 - (end - start + 1);
					for (int i = padLen; i >= 1; i--) {
						if ((start - i) >= 1) {
							start = start - i;
							break;
						}
					}
				}

				if("article".equals(theme)){
					out.print("<ul class=\"gpages\" style=\"display: block;\">");
					if (curPage > 1) {
						if (start > 1) {
							out.print("<li><a href=\"javascript:void(0)\" onclick=\"search2(1)\">首页</a></li>");
						}
						out.print("<li><a href=\"javascript:void(0)\" onclick=\"search2("+(curPage-1)+")\">上一页</a></li>");
					}

					for (int i = start; i <= end; i++) {
						if (i == curPage) {
							out.print("<li><span>"+curPage+"</span></li>");
						} else {
							out.print("<li><a href=\"javascript:void(0)\" onclick=\"search2("+i+")\">"+i+"</a></li>");
						}
					}
					if (curPage < totalPage) {
						out.print("<li><a href=\"javascript:void(0)\" onclick=\"search2("+(curPage+1)+")\">下一页</a></li>");
						if (end < totalPage) {
							out.print("<li><a href=\"javascript:void(0)\" onclick=\"search2("+totalPage+")\">末页</a></li>");
						}
					}
					out.print("</ul>");
				}else{
					if (curPage > 1) {
						if (start > 1) {
							out.print("<li class=\"first-child\"><a href='"
									+ path + "/1.htm'>首页</a></li>");
						}
						out.print("<li class=\"first-child\"><a href='"
								+ path
								+ "/"
								+ (curPage - 1)
								+ ".htm' id=\"pagination_pre_link\">&lt;</a></li>");
					}

					for (int i = start; i <= end; i++) {
						if (i == curPage) {
							out.print("<li class='active'><a href='#'>" + i
									+ "</a></li>");
						} else {
							out.print("<li class=''><a href='" + path + "/"
									+ i + ".htm'>"
									+ i
									+ "</a></li>");
						}
					}
					if (curPage < totalPage) {
						out.print("<li class=\"last-child\"><a href='"
								+ path
								+ "/"
								+ (curPage + 1)
								+ ".htm' id=\"pagination_next_link\">&gt;</a></li>");
						if (end < totalPage) {
							out.print("<li><a href='" + path + "/"
									+ totalPage + ".htm'>尾页</a></li>");
						}
					}
//					out.print("<li><a href='javascript:void(0)'>共" + totalPage
//							+ "页&nbsp;&nbsp;" + this.totalCount + "条</a></li>");
					out.print("</ul>");
				}
				
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.doStartTag();

	}

	public static Integer getStartIndex(Integer pageNum, Integer pageSize) {
		Integer res = 0;
		if (pageNum > 0) {
			res = (pageNum - 1) * pageSize;
		}
		return res;
	}
}
