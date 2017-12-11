<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" class=" js flexbox canvas canvastext webgl no-touch geolocation postmessage websqldatabase indexeddb hashchange history draganddrop websockets rgba hsla multiplebgs backgroundsize borderimage borderradius boxshadow textshadow opacity cssanimations csscolumns cssgradients cssreflections csstransforms csstransforms3d csstransitions fontface generatedcontent video audio localstorage sessionstorage webworkers applicationcache svg inlinesvg smil svgclippaths">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="Cache-Control" content="no-transform ">
		<meta http-equiv="Cache-Control" content="no-siteapp">
		<title>
			问卷调查
		</title>
		<meta name="keywords" content="">
		<meta name="description" content="">
		<link rel="stylesheet" type="text/css" href="<c:url value="/static/survey/css/list.css" /> ">
		<link rel="stylesheet" type="text/css" href="<c:url value="/static/survey/css/public.css" /> ">
		<style type="text/css">
			/*增加手机找回密码结束*/ .cq_yh_box{ width: 549px; height: 440px; background: url(static/images/cq_yh.png)
			no-repeat center center; position: fixed; left: 50%; margin-left: -275px;
			top: 50%; margin-top: -220px; z-index: 1000;} .cq_bg{ width: 100%; height:
			100%; position: fixed; left: 0px; top: 0px; z-index: 999; background: #000;
			opacity: 0.6; filter:alpha(opacity:60);} .cq_yh_box .close_yh{display:
			inline-block; width: 22px; height: 21px;background: url(/static/images/close_yh.png)
			no-repeat left top; position: absolute; right: 45px; top: 45px;} .cq_yh_box
			.close_yh:hover{background: url(/static/images/close_yh.png) no-repeat
			left bottom;} .cq_yh_box .cq_lq{display: inline-block; width: 141px; height:
			39px; text-align: center; line-height: 39px;color: #fff; background:#53a4f4;
			position: absolute; bottom: 55px; left: 204px; border-radius: 3px;} .cq_yh_box
			.cq_lq:hover{background: #6fc5ff;} /*cq_yh_box*/ body{min-width: 1220px;}
		</style>
		<script src="<c:url value="/static/survey/js/jquery.js" /> "></script>
		<script src="<c:url value="/static/survey/js/jquery.cookie.js" /> "></script>
		<script src="<c:url value="/static/survey/js/modernizr.custom.js" /> "></script>
		<script type="text/javascript" src="<c:url value="/static/survey/js/tools.js" /> "></script>
		<script type="text/javascript" src="<c:url value="/static/survey/js/base_utils.js" /> "></script>
		<script type="text/javascript" src="<c:url value="/static/survey/js/plug-in/jsbox/jsbox.js" /> "></script>
		<!--[if lt IE 10]>
			<script type="text/javascript">
				$(function() {
					$('.login_name .txt').val('邮箱/手机号/用户名');
					$('.login_center_cq .login_name .txt').focus(function() {
						if ($(this).val() == "邮箱/手机号/用户名") {
							$(this).val("");
						}
					}).blur(function() {
						if ($(this).val() == "") {
							$(this).val('邮箱/手机号/用户名');
						}
					});
				});
			</script>
		<![endif]-->
	</head>
	<body>
		<div class="list_head clearfix">
			<h1>
				<a href="#">
					<img src="<c:url value="/static/survey/images/logo.png"/> " alt="">
				</a>
			</h1>
			<div class="head_nav">
				<a href="#"
				class="active">
					我 的
				</a>
				<a>
				</a>
				<a href="#">
					模板库
				</a>
				<a href="#">
					帮 助
				</a>
			</div>
			<div class="head_mem">
				<ul class="util-nav">
					<li>
						<a class="wjNews" href="#">
						</a>
					</li>
					<li class="username">
						<a href="javascript:;" title="session">
							session
						</a>
						<div class="arrowup">
							<div class="arrowupt">
							</div>
						</div>
						<div class="loginMeun" style="display: none;">
							<div class="opacityDIV">
							</div>
							<div class="loginMenu_n">
								<ul class="UserMenu">
									<li>
										<a href="#">
											我的账户
										</a>
									</li>
									<li>
										<a href="#">
											使用券
										</a>
									</li>
									<li>
										<a href="#">
											联系人
										</a>
									</li>
									<li class="bbnot">
										<a href="login.html">
											退出
										</a>
									</li>
								</ul>
							</div>
						</div>
					</li>
				</ul>
			</div>
		</div>
		<script type="text/javascript">
			$(function() {
				$('.head_nav .a').each(function() {
					if (window.location.href.indexOf($(this).attr('href')) > -1) {
						$(this).addClass('active').siblings('.a').removeClass('active');
					}
				});
				$('.head_nav .mb_a').hover(function() {
					$(this).find('.down_nav').stop(true, true).fadeIn(150);
				},
				function() {
					$(this).find('.down_nav').stop(true, true).fadeOut(150);
				});
				$('.username').click(function() {
					if ($(".loginMeun:visible").length > 0) {
						$(this).find('.loginMeun').hide();
						$(this).find('.arrowupt').removeClass('atop');
					} else {
						$(this).find('.loginMeun').show();
						$(this).find('.arrowupt').addClass('atop');
					}
					return false;
				});
				$(".login_but").click(function() {
					if ($(".loginBox:visible").length > 0) {
						$(".loginBox").fadeOut("slow");
					} else {
						$(".loginBox").fadeIn("slow");
					}
					return false;
				});
				$(".loginBox,.loginMeun").click(function(event) {
					event.stopPropagation();
				});
				$('body').click(function() {
					$(".loginBox").fadeOut("slow");
					$('.username').find('.loginMeun').hide();
					$('.username').find('.arrowupt').removeClass('atop');
				});
			});
		</script>
		<div class="list_cont">
			<div class="list_check clearfix" style="width: 1220px; margin: 0px auto;">
				<!--<div class="list_tab">
					<a href="javascript:;">
						<i class="box_icon">
						</i>
					</a>
					<a href="javascript:;" class="active">
						<i class="list_icon">
						</i>
					</a>
				</div>-->
				<div class="list_sel">
					<!--<div class="dropdown" id="state_sel__jQSelect0" tabindex="0">
						<select id="state_sel" style="display: none;">
							<option name="all" p_type="0" value="全部" selected="selected">
								全部
							</option>
							<option name="survey" p_type="3" value="问卷">
								问卷
							</option>
							<option name="form" p_type="1" value="表单">
								表单
							</option>
							<option name="assess" p_type="2" value="测评">
								测评
							</option>
						</select>
						<div class="dropselectbox">
							<h4 style="width: 59px;">
								全部
							</h4>
							<ul style="width: 74px; display: none;">
							</ul>
						</div>
					</div>-->
					<div class="dropdown" id="sort_sel__jQSelect1" tabindex="0">
						<select id="sort_sel">
							<option sort="1" selected="selected">
								从新到旧
							</option>
							<option sort="0">
								从旧到新
							</option>
						</select>
						<div class="dropselectbox">
							<h4 style="width: 87px;">
								从新到旧
							</h4>
							<ul style="width: 102px;">
							</ul>
						</div>
					</div>
				</div>
				<a href="<c:url value="/create.htm" />" class="new_create" style="display: block;">
					+新建
				</a>
				<div class="list_sear">
					<input type="text" id="search_txt" class="txt" value="输入标题搜索">
					<input type="button" value="" id="search_btn" class="btn">
				</div>
			</div>
			<div class="list_nr">
				<div class="listBox hzBox" style="width: 1220px; margin: 0px auto; display: none;">
					<ul class="clearfix ul_list" id="listHz" style="width: 1244px; margin-left: -20px;">
						<li class="create" oldid="null">
							<a href="http://www.wenjuan.com/new/">
								<i>
								</i>
								新建
							</a>
						</li>
					</ul>
				</div>
				<div class="listBox lbBox" style="display: block; width: 1180px; margin: 0px auto;">
					<table id="proj_list" class="table_list" width="100%" cellspacing="0"
					cellpadding="0">
						<tbody>
							<tr class="thead_td">
								<td width="42%" class="first">
									标题
								</td>
								<td class="tl">
									收集状态
								</td>
								<td class="trc">
									收到数据
								</td>
								<td class="tl tdcj">
									创建时间
								</td>
								<td class="tl">
									编辑时间
								</td>
								<td class="last">
									操作
								</td>
							</tr>
							<tr oldid="null" status="0" class="tr closed">
								<td class="first" width="42%" oid="55d30169f7405b36d2d43174">
									<span class="proj_title" style="width:483.59999999999997px" title="暑假开学吗">
										暑假开学吗
									</span>
								</td>
								<td class="tl">
									<select pccount="0" panelsite="null" pid="55d30169f7405b36d2d43174" lastv="0"
									copy_from_pid="null" isfirstc="true" is_shared="0" onchange="proj_status_changed(this);"
									style="width:80px;">
										<option class="unpublished" selected="selected" value="0">
											未发布
										</option>
										<option class="collection" value="1">
											收集中
										</option>
										<option class="closed" value="2">
											已结束
										</option>
									</select>
								</td>
								<td class="cq_sdsj trc" id="rspd_count_55d30169f7405b36d2d43174" pid="55d30169f7405b36d2d43174">
									0
								</td>
								<td class="tl tdcj">
									2015年08月18日
								</td>
								<td class="tl">
									17小时前
								</td>
								<td class="last" type="问卷">
									<a onclick="project_design_confirm(this);return false;" pid="55d30169f7405b36d2d43174"
									fid="51dd234e9b9fbe6646bf4dd2" class="editor btn">
									</a>
									<a href="http://www.wenjuan.com/collect/urllink/55d30169f7405b36d2d43174"
									class="collect_a">
									</a>
									<a href="http://www.wenjuan.com/report/basic_chart/55d30169f7405b36d2d43174?pid=55d30169f7405b36d2d43174"
									class="analysis">
									</a>
									<a href="http://www.wenjuan.com/s/ARNzUf?test=1" target="_blank" class="a">
										预览
									</a>
									<a href="javascript:;" pid="55d30169f7405b36d2d43174" fid="51dd234e9b9fbe6646bf4dd2"
									class="a copysurvey2" data-title="暑假开学吗">
										复制
									</a>
									<a href="javascript:;" id="cleanup_55d30169f7405b36d2d43174" pid="55d30169f7405b36d2d43174"
									class="a color_gray">
										清空
									</a>
									<a href="javascript:;" pid="55d30169f7405b36d2d43174" fid="51dd234e9b9fbe6646bf4dd2"
									class="a deletebtn">
										删除
									</a>
								</td>
							</tr>
							<tr oldid="null" status="0" class="tr closed">
								<td class="first" width="42%" oid="55c95959f7405b0d33e07575">
									<span class="proj_title" style="width:483.59999999999997px" title="七夕情人节送什么礼物">
										七夕情人节送什么礼物
									</span>
								</td>
								<td class="tl">
									<select pccount="0" panelsite="null" pid="55c95959f7405b0d33e07575" lastv="0"
									copy_from_pid="null" isfirstc="true" is_shared="0" onchange="proj_status_changed(this);"
									style="width:80px;">
										<option class="unpublished" selected="selected" value="0">
											未发布
										</option>
										<option class="collection" value="1">
											收集中
										</option>
										<option class="closed" value="2">
											已结束
										</option>
									</select>
								</td>
								<td class="cq_sdsj trc" id="rspd_count_55c95959f7405b0d33e07575" pid="55c95959f7405b0d33e07575">
									0
								</td>
								<td class="tl tdcj">
									2015年08月11日
								</td>
								<td class="tl">
									19小时前
								</td>
								<td class="last" type="问卷">
									<a onclick="project_design_confirm(this);return false;" pid="55c95959f7405b0d33e07575"
									fid="51dd234e9b9fbe6646bf4dd3" class="editor btn">
									</a>
									<a href="http://www.wenjuan.com/collect/urllink/55c95959f7405b0d33e07575"
									class="collect_a">
									</a>
									<a href="http://www.wenjuan.com/report/basic_chart/55c95959f7405b0d33e07575?pid=55c95959f7405b0d33e07575"
									class="analysis">
									</a>
									<a href="http://www.wenjuan.com/s/EBnQri9?test=1" target="_blank" class="a">
										预览
									</a>
									<a href="javascript:;" pid="55c95959f7405b0d33e07575" fid="51dd234e9b9fbe6646bf4dd3"
									class="a copysurvey2" data-title="七夕情人节送什么礼物">
										复制
									</a>
									<a href="javascript:;" id="cleanup_55c95959f7405b0d33e07575" pid="55c95959f7405b0d33e07575"
									class="a color_gray">
										清空
									</a>
									<a href="javascript:;" pid="55c95959f7405b0d33e07575" fid="51dd234e9b9fbe6646bf4dd3"
									class="a deletebtn">
										删除
									</a>
								</td>
							</tr>
							<tr oldid="null" status="0" class="tr closed">
								<td class="first" width="42%" oid="55c5b9d9f7405b7db459b40b">
									<span class="proj_title" style="width:483.59999999999997px" title="大学生暑假时间利用情况调查">
										大学生暑假时间利用情况调查
									</span>
								</td>
								<td class="tl">
									<select pccount="0" panelsite="null" pid="55c5b9d9f7405b7db459b40b" lastv="0"
									copy_from_pid="null" isfirstc="true" is_shared="0" onchange="proj_status_changed(this);"
									style="width:80px;">
										<option class="unpublished" selected="selected" value="0">
											未发布
										</option>
										<option class="collection" value="1">
											收集中
										</option>
										<option class="closed" value="2">
											已结束
										</option>
									</select>
								</td>
								<td class="cq_sdsj trc" id="rspd_count_55c5b9d9f7405b7db459b40b" pid="55c5b9d9f7405b7db459b40b">
									0
								</td>
								<td class="tl tdcj">
									2015年08月08日
								</td>
								<td class="tl">
									1天前
								</td>
								<td class="last" type="问卷">
									<a onclick="project_design_confirm(this);return false;" pid="55c5b9d9f7405b7db459b40b"
									fid="51dd234e9b9fbe6646bf4dd2" class="editor btn">
									</a>
									<a href="http://www.wenjuan.com/collect/urllink/55c5b9d9f7405b7db459b40b"
									class="collect_a">
									</a>
									<a href="http://www.wenjuan.com/report/basic_chart/55c5b9d9f7405b7db459b40b?pid=55c5b9d9f7405b7db459b40b"
									class="analysis">
									</a>
									<a href="http://www.wenjuan.com/s/Q7nqYz?test=1" target="_blank" class="a">
										预览
									</a>
									<a href="javascript:;" pid="55c5b9d9f7405b7db459b40b" fid="51dd234e9b9fbe6646bf4dd2"
									class="a copysurvey2" data-title="大学生暑假时间利用情况调查">
										复制
									</a>
									<a href="javascript:;" id="cleanup_55c5b9d9f7405b7db459b40b" pid="55c5b9d9f7405b7db459b40b"
									class="a color_gray">
										清空
									</a>
									<a href="javascript:;" pid="55c5b9d9f7405b7db459b40b" fid="51dd234e9b9fbe6646bf4dd2"
									class="a deletebtn">
										删除
									</a>
								</td>
							</tr>
						</tbody>
					</table>
					<div id="pagenum" class="pagenum" style="display: none;">
						<span class="disabled">
							上一页
						</span>
						<span class="current">
							1
						</span>
						<span class="disabled">
							下一页
						</span>
					</div>
				</div>
			</div>
		</div>
		<div id="media_div" style="display:none">
			<div class="cq_bg">
			</div>
			<div class="cq_yh_box">
				<a href="javascript:;" class="close_yh">
				</a>
				<a href="http://www.wenjuan.com/media" target="_blank" class="cq_lq">
					立即领取
				</a>
			</div>
		</div>
		<form id="form1" action="" method="POST" callback="del_project_callback">
			<input type="hidden" name="proj_id" p_type="">
			<input type="hidden" name="status">
			<input type="hidden" name="is_shared">
			<input type="hidden" name="_xsrf" value="844c9158e22b4cccb8654b8c4b34cb8c">
		</form>
		<form id="search_form" action="http://www.wenjuan.com/edit/project_search_title/"
		method="POST">
			<input type="hidden" name="search_txt">
			<input type="hidden" name="_xsrf" value="844c9158e22b4cccb8654b8c4b34cb8c">
		</form>
		<form id="proj_copy_form" action="http://www.wenjuan.com/edit/ajax/survey_copy/"
		method="POST" callback="survey_copy_callback">
			<input type="hidden" name="proj_id">
			<input type="hidden" name="func_id">
			<input type="hidden" name="proj_title">
			<input type="hidden" name="vcode">
			<input type="hidden" name="_xsrf" value="844c9158e22b4cccb8654b8c4b34cb8c">
		</form>
		<form id="del_rspd_data" action="http://www.wenjuan.com/report/ajax/cleanup_project/"
		method="POST" callback="update_rspd_count">
			<input type="hidden" name="proj_id">
			<input type="hidden" name="_xsrf" value="844c9158e22b4cccb8654b8c4b34cb8c">
		</form>
		<form id="project_archive_form" action="http://www.wenjuan.com/report/ajax/project_archive/"
		method="POST" callback="project_archive_form_callback">
			<input type="hidden" name="proj_id">
			<input type="hidden" name="is_merge">
			<input type="hidden" name="_xsrf" value="844c9158e22b4cccb8654b8c4b34cb8c">
		</form>
		<form id="get_rspd_count_form" action="http://www.wenjuan.com/edit/ajax/get_rspd_count/"
		method="POST" callback="pget_rspd_count_callback">
			<input type="hidden" name="proj_id" p_type="">
			<input type="hidden" name="_xsrf" value="844c9158e22b4cccb8654b8c4b34cb8c">
		</form>
		<form id="get_project_info_form" action="http://www.wenjuan.com/edit/ajax/get_project_info/"
		method="POST" callback="proj_status_changed">
			<input type="hidden" name="project_id">
			<input type="hidden" name="_xsrf" value="844c9158e22b4cccb8654b8c4b34cb8c">
		</form>
		<form id="check_is_need_rm_rawdata" action="http://www.wenjuan.com/report/ajax/is_need_rm_rawdata/"
		style="display:none" method="POST" callback="check_is_need_rm_rawdata_callback">
			<input type="hidden" name="proj_id">
			<input type="hidden" name="_xsrf" value="844c9158e22b4cccb8654b8c4b34cb8c">
		</form>
		<form id="is_validate_code_form" style="display:none" action="http://www.wenjuan.com/operate/ajax/get_validate_status/"
		method="POST" callback="validate_callback">
			<input type="hidden" name="key" value="55c5b9a5f7405b0c950f3987_c_p_n_l">
			<input type="hidden" name="_xsrf" value="844c9158e22b4cccb8654b8c4b34cb8c">
		</form>
		<form id="validate_vcode_form" style="display:none" action="http://www.wenjuan.com/operate/ajax/validate_vcode/"
		method="POST" callback="validate_vcode_form_callback">
			<input type="hidden" name="vcode">
			<input type="hidden" name="_xsrf" value="844c9158e22b4cccb8654b8c4b34cb8c">
		</form>
		<input type="hidden" id="zon_page" value="1">
		<script type="text/javascript" src="<c:url value="/static/survey/js/jquery_1.8.js" /> "></script>
		<script type="text/javascript" src="<c:url value="/static/survey/js/list.js" /> "></script>
		<script type="text/javascript" src="<c:url value="/static/survey/js/jquery.page.js" /> "></script>
		<script type="text/javascript" src="<c:url value="/static/survey/js/jquery.select-1.3.6.js" /> "></script>
		<script type="text/javascript" src="<c:url value="/static/survey/js/jquery.cookie.js" /> "></script>
		<!--old-->
		<script type="text/javascript" src="<c:url value="/static/survey/js/base_utils.js" /> "></script>
		<!--弹出框-->
		<link href="<c:url value="/static/survey/js/plug-in/jsbox/jsbox.css" /> " rel="stylesheet" type="text/css">
		<script type="text/javascript" src="<c:url value="/static/survey/js/plug-in/jsbox/jsbox.js" /> "></script>
		<!--加载提示-->
		<link href="<c:url value="/static/survey/js/plug-in/load/load.css" /> " rel="stylesheet" type="text/css">
		<script type="text/javascript" src="<c:url value="/static/survey/js/plug-in/load/load.js" /> "></script>
		<link href="<c:url value="/static/survey/js/plug-in/hcheckbox/hcheckbox.css" /> " rel="stylesheet">
		<script type="text/javascript" src="<c:url value="/static/survey/js/plug-in/hcheckbox/jquery-hcheckbox.js" /> "></script>
		<!--日期组件-->
		<link type="text/css" rel="stylesheet" href="<c:url value="/static/survey/js/plug-in/date/css/zebra_datepicker_metallic.css" /> ">
		<script type="text/javascript" src="<c:url value="/static/survey/js/plug-in/date/javascript/zebra_datepicker.js" /> ">
		</script>
		<!--old end-->
		<script type="text/javascript">
			var project_fun_list = [{
				"name": "\u54c1\u724c\u8425\u9500",
				"value": "51dd234e9b9fbe6646bf4dcc"
			},
			{
				"name": "\u4ea7\u54c1\u6d4b\u8bd5",
				"value": "51dd234e9b9fbe6646bf4dcd"
			},
			{
				"name": "\u6d88\u8d39\u8005\u5206\u6790",
				"value": "51dd234e9b9fbe6646bf4dce"
			},
			{
				"name": "\u6ee1\u610f\u5ea6\u8c03\u67e5",
				"value": "51dd234e9b9fbe6646bf4dcf"
			},
			{
				"name": "\u4eba\u529b\u8d44\u6e90",
				"value": "51dd234e9b9fbe6646bf4dd0"
			},
			{
				"name": "\u5b66\u672f\u6559\u80b2",
				"value": "51dd234e9b9fbe6646bf4dd1"
			},
			{
				"name": "\u793e\u4f1a\u6c11\u610f",
				"value": "51dd234e9b9fbe6646bf4dd2"
			},
			{
				"name": "\u5176\u4ed6",
				"value": "51dd234e9b9fbe6646bf4dd3"
			}]
			var form_fun_list = [{
				"name": "\u62a5\u540d",
				"value": "536b5a38f7405b4d51ca75c6"
			},
			{
				"name": "\u767b\u8bb0",
				"value": "536b5a38f7405b4d51ca75c7"
			},
			{
				"name": "\u9080\u8bf7",
				"value": "536b5a38f7405b4d51ca75c8"
			},
			{
				"name": "\u53cd\u9988",
				"value": "536b5a38f7405b4d51ca75c9"
			},
			{
				"name": "\u8ba2\u5355",
				"value": "536b5a38f7405b4d51ca75ca"
			},
			{
				"name": "\u8bb0\u4e8b",
				"value": "536b5a38f7405b4d51ca75cb"
			},
			{
				"name": "\u5176\u4ed6",
				"value": "536b5a38f7405b4d51ca75cc"
			}]
			var assess_fun_list = [{
				"name": "\u57f9\u8bad\u8003\u8bc4",
				"value": "54b638e0f7405b3dc0db45fb"
			},
			{
				"name": "\u6559\u5b66\u6d4b\u9a8c",
				"value": "54b638e0f7405b3dc0db45fc"
			},
			{
				"name": "\u5458\u5de5\u8003\u6838",
				"value": "54b638e0f7405b3dc0db45fd"
			},
			{
				"name": "\u8da3\u5473\u6d4b\u8bd5",
				"value": "54b638e0f7405b3dc0db45fe"
			},
			{
				"name": "\u5fc3\u7406\u6d4b\u8bd5",
				"value": "54b638e0f7405b3dc0db45ff"
			}]
			var display_type = "list";
			var p_type = "0";
			var order = "1";
			function remember() {
				if (display_type == 'block') {
					$('.list_tab a:first').click();
				} else if (display_type == 'list') {
					$('.list_tab a:last').click();
				}
				if (p_type == 'None') {
					type = 3;
				} else if (p_type == 0) {
					type = 0;
				} else if (p_type == 1) {
					type = 1;
				} else if (p_type == 2) {
					type = 2;
				}
				if (order == 0) {
					sort = 0;
				} else if (order == 1) {
					sort = 1;
				}
				$("#state_sel").find("option[p_type=" + type + "]").attr("selected", true);
				$("#sort_sel").find("option[sort=" + sort + "]").attr("selected", true);

				$('#listHz').html('<li class="create" oldId="null"><a href="/new/"><i></i>新建</a></li>');

				loaded(1);
			}
		</script>
		<script type="text/javascript">
			var continue_type = '';
			var p_s_id = "";
			jQuery(document).ready(function() {
				//close
				$('.cq_yh_box .close_yh').click(function() {
					$('.cq_yh_box').fadeOut(200,
					function() {
						$('.cq_bg').fadeOut(100);
					});
				});
				if ($.cookie("media_view_55c5b9a5f7405b0c950f3987") != "1" && "0" == "7") {
					$("#media_div").show();
					$.cookie("media_view_55c5b9a5f7405b0c950f3987", "1", {
						expires: 30,
						path: '/'
					})
				}
				var survey_options = '',
				form_options = '',
				assess_options = '';
				for (var i = 0; i < project_fun_list.length; i++) {
					survey_options += '<option value="' + project_fun_list[i].value + '">' + project_fun_list[i].name + '</option>';
				}
				for (var i = 0; i < form_fun_list.length; i++) {
					form_options += '<option value="' + form_fun_list[i].value + '">' + form_fun_list[i].name + '</option>';
				}
				for (var i = 0; i < assess_fun_list.length; i++) {
					assess_options += '<option value="' + assess_fun_list[i].value + '">' + assess_fun_list[i].name + '</option>';
				}
				$('.head_nav a').each(function() {
					if (window.location.href.indexOf($(this).attr('href')) > -1) {
						$(this).addClass('active').siblings().removeClass('active');
					}
				});
				$('.username').click(function() {
					if ($(".loginMeun:visible").length > 0) {
						$(this).find('.loginMeun').hide();
						$(this).find('.arrowupt').removeClass('atop');
					} else {
						$(this).find('.loginMeun').show();
						$(this).find('.arrowupt').addClass('atop');
					}
					return false;
				});
				$(".login_but").click(function() {
					if ($(".loginBox:visible").length > 0) {
						$(".loginBox").fadeOut("slow");
					} else {
						$(".loginBox").fadeIn("slow");
					}
					return false;
				});
				$(".loginBox,.loginMeun").click(function(event) {
					event.stopPropagation();
				});
				$('body').click(function() {
					$(".loginBox").fadeOut("slow");
					$('.username').find('.loginMeun').hide();
					$('.username').find('.arrowupt').removeClass('atop');
				});
				$(".deletebtn").live('click',
				function() {
					var type = $(this).parent().attr('type');
					var proj_id = $(this).attr("pid");
					var $form = $("#form1");
					$form.attr("action", "/edit/ajax/del_project");
					$form.attr("callback", "del_project_callback");
					$form.find('input[name="proj_id"]').val(proj_id);
					$form.find('input[name="proj_id"]').attr('p_type', type);
					var show_txt = '<a class="jsbox_close" title="关闭" href="javascript:void(0)"></a>';
					show_txt += '<img style="display: block; margin: 10px auto 25px;" src="<c:url value="/static/images/exclamation_mark.png"/> " /><span style="color:red;height:30px;display:block;font-size:16px;">你要删除这份' + type + '吗？删除后无法恢复</span>';
					var confirm_popup_win = Object();
					confirm_popup_win.title = "删除" + type + "确认";
					confirm_popup_win.content = show_txt;
					confirm_popup_win.obj = del_project_func;
					confirm_popup_win.obj_text = "我知道了";
					confirm_popup_win.conw = "330";
					jsConfirm(confirm_popup_win);
				});
				$(".color").live('click',
				function() {
					var proj_id = $(this).attr("pid");
					var type = $(this).parent().attr('type');
					rspd_count = $("#rspd_count_" + proj_id).text();
					if (rspd_count != 0) {
						continue_type = 'clear_data';
						cur_design_obj = $(this);
						var confirm_popup_win = Object;
						confirm_popup_win.title = '清空' + type + '确认';
						var content = '<img style="display: block; margin: 10px auto 25px;" src="<c:url value="/static/images/exclamation_mark.png"/> " />';
						content += '<span style="color:red;height:30px;display:block;font-size:16px;">你的' + type + '已收集' + rspd_count + '份答卷数据，确定清空吗？</span>';
						confirm_popup_win.content = content;
						confirm_popup_win.obj = clear_rspd_data;
						confirm_popup_win.obj_text = "我知道了";
						confirm_popup_win.conw = 360;
						// confirm_popup_win.close_obj = continue_design_project;
						jsConfirm(confirm_popup_win);
					}
				});
				$(".copysurvey2").live('click',
				function() {
					var type = $(this).parent().attr('type');
					var proj_id = $(this).attr("pid");
					var status_selector = $(this).parent().prev().prev().children(0);
					$("#proj_copy_form").find('input[name="proj_id"]').val(proj_id);
					var func_id = $(this).attr("fid");
					$("#proj_copy_form").find('input[name="func_id"]').val(func_id);
					var func_options = '';
					if ($(this).parent('.last').attr('type') == "问卷") {
						func_options = survey_options;
					} else if ($(this).parent('.last').attr('type') == "表单") {
						func_options = form_options;
					} else if ($(this).parent('.last').attr('type') == "测评") {
						func_options = assess_options;
					}
					var title = $(this).attr('data-title');
					// var title = $(this).parent().parent().children().eq(0).attr("title") + "";
					var show_txt = '<h2 class="jsboxTitle">复制' + type + '</h2><a class="jsbox_close" title="关闭" href="javascript:void(0)"></a>';
					show_txt += '<div><div class="copyconfirm"><div class="alertdiv"><table><tr>';
					show_txt += '<td width="90" class="alignr">新' + type + '标题：</td><td><input type="text" id="proj_copy_title" class="btx" value="' + title + '"/>';
					show_txt += '</td></tr><tr><td class="alignr">类别：</td><td><select id="proj_copy_func_id" func_id="' + func_id + '">' + func_options + '</select></td></tr>';
					show_txt += '<tr><td></td><td><div class="WJButton wj_blue smallfontsize mtop13 tcQz">创 建</div></td></tr>';
					show_txt += '</table></div></div></div>';
					proj_copy_confirm('400', show_txt, proj_copy_submitter, $(this).attr("fid"));
				});
			});
			function del_project_func() {
				ajaxSubmit($("#form1"));
			}
			//提示
			function search_handle() {
				var search_txt = $("#search_title").val().trim();
				// if("" == search_txt) {
				// loadMack({off:'on',Limg:0,text:'请输入问卷标题',set:1500});
				// $("#search_title").focus();
				// return;
				// }
				window.location.href = encodeURI("/mysurvey?search_txt=" + search_txt);
			}
			function proj_copy_confirm(conw, show_txt, obj, func_id) {
				var wb = new jsbox({
					onlyid: "maptss",
					conw: conw,
					//FixedTop:170,
					content: show_txt,
					range: true,
					mack: true
				}).show();
				var func_id = $("#proj_copy_func_id").attr("func_id");
				$("#proj_copy_func_id").children().each(function() {
					if (func_id == $(this).val()) {
						$(this).attr("selected", "selected");
						return;
					}
				});
				$('.tcQz').one('click',
				function() {
					$("#proj_copy_form").find('input[name="proj_title"]').val($("#proj_copy_title").val());
					$("#proj_copy_form").find('input[name="func_id"]').val($("#proj_copy_func_id").val());
					obj();
				});
			}
			function proj_copy_submitter() {
				ajaxSubmit($("#is_validate_code_form"));
			}
			function validate_callback(info) {
				if (info.is_gt_l_p_num == 1) {
					var validate_obj = Object;
					validate_obj.title = '提示';
					var content = '你今天创建的项目数已经超过上限了，休息一下';
					validate_obj.content = content;
					validate_obj.conw = 280;
					validate_obj.obj_text = "确定";
					jsAlert(validate_obj);
				} else if (info.is_validate == 1) {
					var validate_obj = Object;
					validate_obj.title = '验证码';
					var content = '<tr><td class="alignr"><p style="margin-bottom: 10px;">请输入验证码</p></td><td><input type="text" id="vcode_input" ipt="vcode" name="vcode" class="btx" style="width:80px;"/><img style="display: inline-block;margin: 1px 13px 1px 10px;vertical-align: top;height: 27px;" id="vcode_img" src="/?action=proj_c_vcode" border="0" onclick="this.src=this.src.substr(this.src.indexOf(\'/?action=proj_c_vcode\'),28)+\'&\'+Math.random()"><a style="display:inline;" href="javascript:change_vcode()">换一张</a><br><label id="code_err_msg" style="display:none" class="info_lab text_red">请输入正确的验证码</label></td></tr>';
					validate_obj.content = content;
					validate_obj.obj = submit_vcode;
					validate_obj.obj_text = "确定";
					validate_obj.close_text = "取消";
					jsConfirm(validate_obj);
				} else create_project();
			}
			function change_vcode() {
				var urlstr = $("#vcode_img").attr("src");
				var imgsrc = urlstr.substr(urlstr.indexOf('/?action=proj_c_vcode'), 28) + '&' + Math.random();
				$("#vcode_img").attr("src", imgsrc);
			}
			function submit_vcode() {
				$("#validate_vcode_form input[name='vcode']").val($("#vcode_input").val());
				$("#proj_copy_form input[name='vcode']").val($("#vcode_input").val());
				ajaxSubmit($("#validate_vcode_form"));
				return 1;
			}
			function validate_vcode_form_callback(info) {
				if (info.result == 1) {
					create_project();
				} else {
					$("#code_err_msg").show();
				}
			}
			function create_project() {
				var $form = $("#proj_copy_form");
				var title = $form.find('input[name="proj_title"]').val();
				if (title.trim() == "") {
					alert("请输入新项目标题！");
					return;
				}
				var func_id = $form.find('input[name="func_id"]').val();
				ajaxSubmit($form);
			}
			function survey_copy_callback(resultJson) {
				window.location.href = "/edit/survey/" + resultJson.proj_id + "";
			}
			function get_project_list_by_order(fld) {
				var cls_order = $("#proj_" + fld).attr("class");
				var query_status_selected = $("#project_status_selector").find("option:selected").val();
				var url = "/mysurvey?fld=" + fld
				if (cls_order == "sequencedown") {
					if ("all" != query_status_selected) {
						url += "&status=" + query_status_selected;
					}
				} else {
					if ("all" != query_status_selected) {
						url += "&status=" + query_status_selected + "&ord=asc";
					} else {
						url += "&ord=asc";
					}
				}
				var search_txt = $("#search_title").val().trim();
				if ("" != search_txt) {
					url += "&search_txt=" + search_txt;
				}
				window.location.href = encodeURI(url);
			}
			function action_submitter() {
				ajaxSubmit($("#form1"));
			}
			//提示
			var param_obj_for_status = "";
			function proj_status_changed(obj) {
				var status = $(obj).val();
				var proj_id = $(obj).attr("pid");
				var proj_title = $(obj).parents('.tr').find('.proj_title').text();
				var lastv = $(obj).attr("lastv");
				var pcs_count = $(obj).attr("pccount");
				var pop_win_title = "";
				var pop_win_content = "";
				var $form = $("#form1");
				$form.attr("action", "/edit/ajax/update_project_status/");
				$form.find('input[name="proj_id"]').val(proj_id);
				$form.find('input[name="status"]').val(status);
				var show_txt = "";
				if (status == 0) {
					pop_win_title = "停止发布确认";
					if (pcs_count != 0 && pcs_count != "undefined") {
						pop_win_content = '<img style="display: block; margin: 10px auto 25px;" src="<c:url value="/static/images/exclamation_mark.png"/> " />停止收集你的有偿收集订单也将被<span style="color:#cd4444;">取消</span>！你想再收集时可至“<span style="color:#cd4444;">收集数据→有偿收集</span>”重新下订单。';
					} else {
						pop_win_content += '<a class="jsbox_close" title="关闭" href="javascript:void(0)"></a>';
						pop_win_content += '你要停止发布表单《' + proj_title + '》吗？';
						pop_win_content += '该表单所有数据收集将被止，答卷链暂时关闭。';
					}
				} else if (status == 1) {
					pop_win_title = "发布表单确认";
					var is_shared = $(obj).attr("is_shared");
					var copy_from_pid = $(obj).attr("copy_from_pid");
					var panelsite = $(obj).attr("panelsite");
					pop_win_content += '<a class="jsbox_close" title="关闭" href="javascript:void(0)"></a>';
					pop_win_content += '你要发布表单《' + proj_title + '》吗？<br/>';
					if (is_shared == 0 && copy_from_pid == 'False' && panelsite != '3') {
						pop_win_content += '<label><input type="checkbox" checked="checked" id="checkbox_selector"/>共享到模板库。</label>';
						pop_win_content += '<i class="tips" title="选中该选项，本表单经审核合格后会添加到表单库中，供其他会员制作表单时参考。"></i>';
					}
				} else {
					pop_win_title = "结束表单确认";
					if (pcs_count != 0 && pcs_count != "undefined") {
						pop_win_content = '<img style="display: block; margin: 10px auto 25px;" src="<c:url value="/static/images/exclamation_mark.png"/> " />停止收集你的有偿收集订单也将被<span style="color:#cd4444;">取消</span>！你想再收集时可至“<span style="color:#cd4444;">收集数据→有偿收集</span>”重新下订单。';
					} else {
						pop_win_content += '<a class="jsbox_close" title="关闭" href="javascript:void(0)"></a>';
						pop_win_content += '你要结束表单《' + proj_title + '》吗？';
						pop_win_content += '已结束的表单将不可再编辑和收集。';
						pop_win_content += '如果想要重新收集，你可以将该表单复制成一份新的表单重新发布。';
					}
				}
				param_obj_for_status = $(obj);
				status_changed_confirm(pop_win_title, pop_win_content, status_changed_ok, status_changed_cancle);
			}
			function status_changed_confirm(title, content, ok_func, cancle_func) {
				var confirm_popup_win = Object();
				confirm_popup_win.title = title;
				confirm_popup_win.content = content;
				confirm_popup_win.obj = ok_func;
				confirm_popup_win.close_obj = cancle_func;
				jsConfirm(confirm_popup_win);
			}
			function status_changed_ok() {
				var is_shared = $(param_obj_for_status).attr("is_shared");
				if (is_shared == 0) {
					var status = $(param_obj_for_status).val();
					if (status == 1) {
						if ("checked" == $("#checkbox_selector").attr("checked")) {
							var $form = $("#form1");
							$form.find('input[name="is_shared"]').val("checked");
						}
					}
				}
				ajaxSubmit($("#form1"));
				if ($(param_obj_for_status).find('option:selected').val() == 2) {
					$(param_obj_for_status).parents('.tr').find('.editor,.collect_a').addClass('end').attr("href", 'javascript:;');
					$(param_obj_for_status).parents('.tr').find.find('.editor').attr("onclick", '');
				} else {
					var pid = $(param_obj_for_status).attr('pid');
					$(param_obj_for_status).parents('.tr').find('.editor,.collect_a').removeClass('end').attr("href", '/collect/urllink/' + pid);
					$(param_obj_for_status).parents('.tr').find.find('.editor').attr("onclick", 'project_design_confirm(this);return false;');
				}
			}
			function status_changed_cancle() {
				var sel_index = $(param_obj_for_status).attr("lastv");
				$(param_obj_for_status).get(0).selectedIndex = sel_index;
				$('#maptss').remove();
				$('#lightBox').remove();
			}
			var cur_design_obj;
			function project_design_confirm(obj) {
				cur_design_obj = obj;
				$("#get_rspd_count_form input[name='proj_id']").val($(obj).attr("pid"));
				$("#get_rspd_count_form input[name='proj_id']").attr('p_type', $(obj).parent().attr('type'));
				ajaxSubmit($("#get_rspd_count_form"));
			}
			function pget_rspd_count_callback(info) {
				var type = $("#get_rspd_count_form input[name='proj_id']").attr("p_type");
				//有答卷数据需确认，没有的话直接跳转答卷设计
				if (info.rspd_count != 0 || info.new_rspd_count != 0) {
					if (info.pc_count != 0) {
						var confirm_popup_win = Object;
						confirm_popup_win.title = '修改确认';
						var content = '<img style="display: block; margin: 10px auto 25px;" src="<c:url value="/static/images/exclamation_mark.png"/> " />修改将使你的项目暂停收集，你的有偿收集订单也将被<span style="color:#cd4444;">取消</span>！完成修改后请重新发布问卷，至“<span style="color:#cd4444;">收集数据→有偿收集</span>”重新下订单。';
						confirm_popup_win.content = content;
						if (info.new_rspd_count != 0) {
							confirm_popup_win.obj = continue_design_project;
						} else {
							confirm_popup_win.obj = continue_design_project_zero;
						}
						confirm_popup_win.conw = 400;
						confirm_popup_win.obj_text = "我知道了";
						confirm_popup_win.close_Param = false;
						jsConfirm(confirm_popup_win);
					} else if (info.new_rspd_count != 0) {
						var confirm_popup_win = Object;
						confirm_popup_win.title = '修改提示';
						var content = "<div class='tccCon_d' style='padding:0 15px;'>你的" + type + "已收集 " + info.rspd_count + " 份数据，现在进行题目删改可能会影响已收集的数据";
						content += "<br/><br/>在修改" + type + "时，问卷会暂停收集，你需在修改完后再次发布" + type + "才可继续收集<br/><br/></div>";
						confirm_popup_win.content = content;
						confirm_popup_win.obj = continue_design_project;
						confirm_popup_win.conw = 470;
						confirm_popup_win.obj_text = "确定";
						confirm_popup_win.close_text = "取消";
						jsConfirm(confirm_popup_win);
						$('.tccCon_d').jqTransform();
					} else if (info.proj_status == 1) {
						var confirm_zero_win = Object;
						confirm_zero_win.title = '修改提示';
						var content_zero = "你修改" + type + "时，问卷会暂停收集，你需在修改完后再次发布" + type + "才可继续进行收集，原" + type + "链接不会改变";
						confirm_zero_win.content = content_zero;
						confirm_zero_win.obj = continue_design_project_zero;
						confirm_zero_win.conw = 470;
						confirm_zero_win.obj_text = "确定";
						confirm_zero_win.close_text = "取消";
						jsConfirm(confirm_zero_win);
					} else {
						location.href = "/edit/survey/" + $(cur_design_obj).attr("pid");
					}
				} else if (info.proj_status == 0) {
					location.href = "/edit/survey/" + $(cur_design_obj).attr("pid");
				} else if (info.proj_status == 1) {
					if (info.pc_count != 0) {
						var confirm_popup_win = Object;
						confirm_popup_win.title = '修改确认';
						var content = '<img style="display: block; margin: 10px auto 25px;" src="<c:url value="/static/images/exclamation_mark.png"/> " />修改将使你的项目暂停收集，你的有偿收集订单也将被<span style="color:#cd4444;">取消</span>！完成修改后请重新发布问卷，至“<span style="color:#cd4444;">收集数据→有偿收集</span>”重新下订单。';
						confirm_popup_win.content = content;
						confirm_popup_win.obj = continue_design_project_zero;
						confirm_popup_win.conw = 400;
						confirm_popup_win.obj_text = "我知道了";
						confirm_popup_win.close_Param = false;
						jsConfirm(confirm_popup_win);
					} else {
						var confirm_zero_win = Object;
						confirm_zero_win.title = '修改提示';
						var content_zero = "你修改" + type + "时，" + type + "会暂停收集，你需在修改完后再次发布" + type + "才可继续进行收集，原" + type + "链接不会改变";
						confirm_zero_win.content = content_zero;
						confirm_zero_win.obj = continue_design_project_zero;
						confirm_zero_win.conw = 470;
						confirm_zero_win.obj_text = "确定";
						confirm_zero_win.close_text = "取消";
						jsConfirm(confirm_zero_win);
					}
				}
			}
			function continue_design_project_zero() {
				$.ajax({
					url: "/edit/ajax/update_project_status/",
					type: "POST",
					data: {
						"proj_id": $(cur_design_obj).attr("pid"),
						"status": 0,
						"_xsrf": $.cookie("_xsrf")
					},
					dataType: "JSON",
					success: function(ret) {
						location.href = "/edit/survey/" + $(cur_design_obj).attr("pid");
					}
				});
			}
			/*清空问卷数据,因为采用归档，故先注释*/
			function clear_rspd_data() {
				$("#del_rspd_data").find('input[name="proj_id"]').val($(cur_design_obj).attr("pid"));
				var new_url = $("#del_rspd_data").attr("action") + "?pid=" + $(cur_design_obj).attr("pid");
				$("#del_rspd_data").attr("action", new_url);
				ajaxSubmit($("#del_rspd_data"));
			}
			function update_rspd_count(info) {
				if (info.rspd_count == 0) {
					$("#rspd_count_" + info.proj_id).text(info.rspd_count);
					$("#cleanup_" + info.proj_id).removeClass('color');
					$("#cleanup_" + info.proj_id).addClass("color_gray");
				}
			}
			/*继续编辑设计问卷*/
			function continue_design_project() {
				$("#project_archive_form input[name='is_merge']").val(0);
				$("#project_archive_form").find('input[name="proj_id"]').val($(cur_design_obj).attr("pid"));
				var new_url = $("#project_archive_form").attr("action") + "?pid=" + $(cur_design_obj).attr("pid");
				$("#project_archive_form").attr("action", new_url);
				ajaxSubmit($("#project_archive_form"));
			}
			function project_archive_form_callback(info) {
				if (info.result == "Success") location.href = "/edit/survey/" + $(cur_design_obj).attr("pid");
			}
			function project_status_unchanged(obj) {
				obj.val(obj.attr("lastv"));
			}
			function del_project_callback(resultJson) {
				var $form = $("#form1");
				var p_type = $form.find('input[name="proj_id"]').attr('p_type');
				var curr_proj_id = $form.find('input[name="proj_id"]').val();
				if ("page_index_del" == resultJson.type) {
					$(".deletebtn").each(function() {
						var curr_pid = $(this).attr("pid");
						if (curr_proj_id == curr_pid) {
							$(this).parent().parent().remove();
							// var lines_num = $("#proj_list tbody").children("tr").length;
							// if(lines_num < 7) {
							if (curr_page >= total_pages) {
								if (mid == '51dd234e9b9fbe6646bf4dd5') window.location.href = "/mysurvey?fld=created&page=" + total_pages;
								else window.location.href = "/mysurvey?page=" + total_pages;
							} else {
								if (mid == '51dd234e9b9fbe6646bf4dd5') window.location.href = "/mysurvey?fld=created&page=" + curr_page;
								else window.location.href = "/mysurvey?page=" + curr_page;
							}
							// }
							return;
						}
					});
				} else if ("page_index_cleanup" == resultJson.type) {
					$(".alignc").each(function() {
						var curr_pid = $(this).attr("pid");
						if (curr_proj_id == curr_pid) {
							$(this).text(0);
							return;
						}
					})
				} else if ("page_index_status_changed" == resultJson.type) {
					$(".surveytable table tbody tr td select").each(function() {
						var tmp_pid = $(this).attr("pid");
						if (curr_proj_id == tmp_pid) {
							var status = $(this).find("option:selected").val();
							$(this).attr("lastv", status);
							if (resultJson.shared && resultJson.shared == "True") {
								$(this).attr("is_shared", 1);
								$(this).attr("copy_from_pid", "True");
							}
							var curr_status = $(this).val();
							if (curr_status == 2) {
								var design_copy = $(this).parent().next().next().children().eq(0);
								design_copy.removeClass("editor").addClass("editorgray");
								design_copy.attr("href", "javascript:void(0);");
								var collect = $(this).parent().next().next().children().eq(1);
								collect.removeClass("collect").addClass("collectgray");
								collect.attr("href", "javascript:void(0);");
							} else {
								if (curr_status == 1) {
									loadMack({
										off: 'on',
										text: '发布中',
										set: 3000
									});
									setTimeout(function() {
										var design_copy = $(this).parent().next().next().children().eq(0);
										design_copy.attr("title", "" + p_type + "设计");
										design_copy.removeClass("editorgray").addClass("editor");
										design_copy.attr("href", "/edit/survey/" + curr_proj_id);
										var collect = $(this).parent().next().next().children().eq(1);
										collect.attr("href", "/collect/urllink/" + curr_proj_id);
										collect.removeClass("collectgray").addClass("collect");
									},
									3000);
								} else {
									var design_copy = $(this).parent().next().next().children().eq(0);
									design_copy.attr("title", "" + p_type + "设计");
									design_copy.removeClass("editorgray").addClass("editor");
									design_copy.attr("href", "/edit/survey/" + curr_proj_id);
									var collect = $(this).parent().next().next().children().eq(1);
									collect.attr("href", "/collect/urllink/" + curr_proj_id);
									collect.removeClass("collectgray").addClass("collect");
								}
							}
							return false;
						}
					});
				}
				$('#maptss').remove();
				$('#lightBox').remove();
			}
		</script>
		<div class="list_foot">
		</div>
		<script type="text/javascript">
			$(function() {
				$('.head_nav .mb_a').hover(function() {
					$(this).find('.down_nav').stop(true, true).fadeIn(150);
				},
				function() {
					$(this).find('.down_nav').stop(true, true).fadeOut(150);
				});
				var _href = window.location.href;
				$('.head_index .a').each(function() {
					if (_href.indexOf($(this).attr('href')) > -1) {
						$(this).addClass('active').siblings('.a').removeClass('active');
					}
				});
				if (_href.indexOf('share') > -1 || _href.indexOf('classify') > -1 || _href.indexOf('lib') > -1) {
					$('.head_nav .mb_a').addClass('active').siblings('.a').removeClass('active');
				}
				$('.login_dj_cq').click(function() {
					$('.login_center_cq .error').text('');
					$('.bg_ceng').fadeIn(100,
					function() {
						$('.tc_login_cq').show();
						var wid = $('.tc_login_cq').width();
						var hei = $('.tc_login_cq').height();
						$('.tc_login_cq').css({
							'margin-left': -wid / 2,
							'margin-top': -hei / 2
						}).animate({
							'opacity': '1'
						},
						300);
					});
				});
				$('.tc_login_cq .close_tc').click(function() {
					$('.tc_login_cq').animate({
						'opacity': '0'
					},
					300,
					function() {
						$('.tc_login_cq').hide();
						$('.bg_ceng').fadeOut(100);
					});
				});
			});
		</script>
	</body>
</html>