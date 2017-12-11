<%@ page import="java.util.Random" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<title>
			问卷设计-Hello Lenovo
		</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="Cache-Control" CONTENT="no-cache">
		<meta http-equiv="Cache-Control" CONTENT="no-store">
		<meta http-equiv="Expires" content="0" />
		<link href="/static/survey/css/public_v2.css" rel="stylesheet">
		<link href="/static/survey/css/style_v2.css" rel="stylesheet">
		<link href="/static/survey/css/button.css" rel="stylesheet">
		<link href="/static/survey/css/popuplayer_v2.css" rel="stylesheet">
		<link href="/static/survey/css/edit_cq.css" rel="stylesheet">
		
		<link type="text/css" rel="stylesheet" href="/static/survey/js/plug-in/date/css/zebra_datepicker_metallic.css"/>
		<link type="text/css" rel="stylesheet" href="/static/survey/js/plug-in/tjj/Tjj.css"/>
		<link type="text/css" rel="stylesheet" href="/static/survey/js/plug-in/load/load.css"/>
		<link type="text/css" rel="stylesheet" href="/static/survey/js/plug-in/Jcrop/Jcrop.css"/>
		<link type="text/css" rel="stylesheet" href="/static/survey/js/plug-in/JsBubble/JsBubble.css"/>
		<link type="text/css" rel="stylesheet" href="/static/survey/js/plug-in/jsbox/jsbox.css"/>
		
		<script type="text/javascript" src="/static/survey/js/jquery_1.10.2.min.js"></script>
		<script type="text/javascript" src="/static/survey/js/jquery-migrate-1.2.1.js"></script>
		<script type="text/javascript" src="/static/survey/js/jquery.cookie.js"></script>
		<script type="text/javascript" src="/static/survey/js/jquery-ui-1.10.min.js"></script>
		<script type="text/javascript" src="/static/survey/js/json.js"></script>
		<script type="text/javascript" src="/static/survey/js/base_utils.js"></script>
	</head>
	<body>
		<div class="zon_v2 clear">
			<div class="left_nav">
				<a href="/list" class="BackPre">
					<i></i>
				</a>
				<ul class="left_Menu">
					<li>
						<a class="active" href="/edit/survey/55c95959f7405b0d33e07575" onclick="project_design_confirm();return false;">
							<i class="i_sheji"></i>
							编辑问卷
						</a>
					</li>
					<li>
						<a href="/collect/urllink/55c95959f7405b0d33e07575">
							<i class="i_soji"></i>
							收集数据
						</a>
					</li>
					<li>
						<a href="/report/basic_chart/55c95959f7405b0d33e07575?pid=55c95959f7405b0d33e07575">
							<i class="i_fengxi"></i>
							分析结果
						</a>
					</li>
				</ul>
				<div class="bot_nav">
					<ul class="left_Menu">
						<li class="gz_wx" style="margin-bottom:8px;">
							<i class="i_weixin"></i>
							<div class="gz_weixin_ewm">
								<img src="/static/survey/images/GZ_wenjuan.jpg" alt="微信二维码" />
							</div>
						</li>
						<li style="margin-bottom:9px;">
							<a href="/about/zxzx/" target="_blank">
								<i class="i_fankui"></i>
							</a>
						</li>
						<li style="margin-bottom:5px;">
							<a href="/message/list/" target="_blank">
								<i class="i_mail"></i>
							</a>
						</li>
						<li style="margin-bottom:5px;">
							<a href="/helpcenter" target="_blank">
								<i class="i_help"></i>
							</a>
						</li>
					</ul>
				</div>
			</div>
			<!--top end-->
			<div class="wjContent">
				<!--wentop-->
				<div class="wentop wentop_cq">
					<ul id="myTab" class="nav1 nav2-tabs">
						<li>
							<a href="/s/EBnQri9?test=1&v=0.55257802547" target="_blank">
								<i class="design-set4-icon"></i>
								预览问卷
							</a>
						</li>
						<li class="release_cq">
							<a target="_blank" onclick="publish_proj_confirm();return false;" href="#">
								<i class="design-set5-icon"></i>
								发布问卷
							</a>
						</li>
						<!-- <li class="active">
						<a href="#design" data-toggle="tab">问卷设计</a>
						</li>
						<li>
						<a href="/collect/urllink/55c95959f7405b0d33e07575" data-toggle="tab">答卷收集</a>
						</li>
						<li>
						<a href="/report/basic_chart/55c95959f7405b0d33e07575?pid=55c95959f7405b0d33e07575" data-toggle="tab">结果分析</a>
						</li> -->
					</ul>
					<h4 class="h4st1">
						<div class="h4Title">
							Hello Lenovo
						</div>
						<!-- <select name="proj_func_select" id="proj_func_select">
						<option value="51dd234e9b9fbe6646bf4dcc" >品牌营销</option>
						<option value="51dd234e9b9fbe6646bf4dcd" >产品测试</option>
						<option value="51dd234e9b9fbe6646bf4dce" >消费者分析</option>
						<option value="51dd234e9b9fbe6646bf4dcf" >满意度调查</option>
						<option value="51dd234e9b9fbe6646bf4dd0" >人力资源</option>
						<option value="51dd234e9b9fbe6646bf4dd1" >学术教育</option>
						<option value="51dd234e9b9fbe6646bf4dd2" >社会民意</option>
						<option value="51dd234e9b9fbe6646bf4dd3" selected="selected">其他</option>
						</select> -->
					</h4>
					<div id="myTabContent" class="tab2-content">
						<div class="tab-pane fade in active" id="design">
							<ul class="fr">
								<li>
									<a id="appearset" href="javascript:;">
										<i class="design-set1-icon active"></i>
										外观设置
									</a>
								</li>
								<li>
									<a class="logicset" href="javascript:;">
										<i class="design-set2-icon"></i>
										逻辑设置
									</a>
								</li>
							</ul>
						</div>
						<div class="tab-pane fade" id="collect">
							<ul class="fr">
								<li>
									<a href="javascript:;">
										<i class="collect-set1-icon active"></i>
										问卷链接
									</a>
								</li>
								<li>
									<a href="javascript:;">
										<i class="collect-set2-icon"></i>
										社交分享
									</a>
								</li>
								<li>
									<a href="javascript:;">
										<i class="collect-set3-icon"></i>
										邮件邀请
									</a>
								</li>
								<li>
									<a href="javascript:;">
										<i class="collect-set4-icon"></i>
										网站收集
									</a>
								</li>
							</ul>
						</div>
						<div class="tab-pane fade" id="analyse">
							<ul class="fr">
								<li>
									<a href="javascript:;">
										<i class="analyse-set1-icon active"></i>
										基本图表
									</a>
								</li>
								<li>
									<a href="javascript:;">
										<i class="analyse-set2-icon"></i>
										交叉图表
									</a>
								</li>
								<li>
									<a href="javascript:;">
										<i class="analyse-set3-icon"></i>
										答卷详情
									</a>
								</li>
							</ul>
						</div>
					</div>
					<!--/.tab2-content-->
				</div>
				<!--/.wentop-->
				<div class="cq_content clear">
					<div class="row-fluid clear">
						<div class="rows1">
							<div class="well sidebar-nav affix-top" id="accordion1">
								<div class="accordion-group">
									<h4 class="tc">
										<a href="javascript:;">
											常用题型
											<i class="icon_on"></i>
										</a>
									</h4>
									<ul class="ul-tool collapse">
										<li class="moduleL" name="2">
											<a href="javascript:;">
												<i class="basic-too11-icon-active"></i>
												单选题
											</a>
										</li>
										<li class="moduleL" name="3">
											<a href="javascript:;">
												<i class="basic-too12-icon-active"></i>
												多选题
											</a>
										</li>
										<li class="moduleL" name="2" disp_type="image_single">
											<a href="javascript:;">
												<i class="basic-too2013-icon-active"></i>
												图片单选题
											</a>
										</li>
										<li class="moduleL" name="3" disp_type="image_multiple">
											<a href="javascript:;">
												<i class="basic-too2014-icon-active"></i>
												图片多选题
											</a>
										</li>
										<li class="moduleL" name="6">
											<a href="javascript:;">
												<i class="basic-too13-icon-active"></i>
												单行填空题
											</a>
										</li>
										<li class="moduleL" name="6" disp_type="multi_line_blank">
											<a href="javascript:;">
												<i class="basic-too200-icon-active"></i>
												多行填空题
											</a>
										</li>
										<li class="moduleL" name="95">
											<a href="javascript:;">
												<i class="basic-too16-icon-active"></i>
												多项填空题
											</a>
										</li>
										<li class="moduleL" name="60">
											<a href="javascript:;">
												<i class="basic-too15-icon-active"></i>
												排序题
											</a>
										</li>
										<li class="moduleL" name="50">
											<a href="javascript:;">
												<i class="basic-too14-icon-active"></i>
												打分题
											</a>
										</li>
										<li class="moduleL" name="4">
											<a href="javascript:;">
												<i class="basic-too17-icon-active"></i>
												矩阵单选题
											</a>
										</li>
										<li class="moduleL" name="5">
											<a href="javascript:;">
												<i class="basic-too18-icon-active"></i>
												矩阵多选题
											</a>
										</li>
										<li class="moduleL" name="70">
											<a href="javascript:;">
												<i class="basic-too111-icon-active"></i>
												描述说明
											</a>
										</li>
										<li class="moduleL" name="3" disp_type="upload_file">
											<a href="javascript:;">
												<i class="basic-too2015-icon-active"></i>
												上传题
											</a>
										</li>
										<li class="moduleL" name="page">
											<a href="javascript:;">
												<i class="basic-too112-icon-active"></i>
												分页
											</a>
										</li>
									</ul>
									<h4 class="tc">
										<a href="javascript:;">
											更多题型
											<i class=""></i>
										</a>
									</h4>
									<ul id="common" class="ul-tool collapse" style="display:none;">
										<li class="moduleL" name="7">
											<a href="javascript:;">
												<i class="basic-too110-icon-active"></i>
												矩阵打分题
											</a>
										</li>
										<li class="moduleL" name="100">
											<a href="javascript:;">
												<i class="basic-too19-icon-active"></i>
												矩阵填空题
											</a>
										</li>
										<li class="moduleL" name="sex">
											<a href="javascript:;">
												<i class="basic-too207-icon-active"></i>
												性别
											</a>
										</li>
										<li class="moduleL" name="mobile">
											<a href="javascript:;">
												<i class="basic-too202-icon-active"></i>
												手机
											</a>
										</li>
										<li class="moduleL" name="email">
											<a href="javascript:;">
												<i class="basic-too203-icon-active"></i>
												邮箱
											</a>
										</li>
										<li class="moduleL" name="age">
											<a href="javascript:;">
												<i class="basic-too2020-icon-active"></i>
												生日
											</a>
										</li>
										<li class="moduleL" name="city">
											<a href="javascript:;">
												<i class="basic-too2019-icon-active"></i>
												城市
											</a>
										</li>
										<li class="moduleL" name="address">
											<a href="javascript:;">
												<i class="basic-too204-icon-active"></i>
												地址
											</a>
										</li>
										<!-- <li class="moduleL" name="name">
										<a href="javascript:;">
										<i class="basic-too201-icon-active"></i>
										姓名
										</a>
										</li> -->
										<li class="moduleL" name="work_ex">
											<a href="javascript:;">
												<i class="basic-too208-icon-active"></i>
												工作年限
											</a>
										</li>
										<li class="moduleL" name="education">
											<a href="javascript:;">
												<i class="basic-too209-icon-active"></i>
												教育程度
											</a>
										</li>
										<li class="moduleL" name="income">
											<a href="javascript:;">
												<i class="basic-too2010-icon-active"></i>
												个人收入
											</a>
										</li>
										<li class="moduleL" name="company">
											<a href="javascript:;">
												<i class="basic-too2011-icon-active"></i>
												工作单位
											</a>
										</li>
										<li class="moduleL" name="marriage">
											<a href="javascript:;">
												<i class="basic-too2012-icon-active"></i>
												婚姻状况
											</a>
										</li>
										<li class="moduleL" name="70" disp_type="split_line">
											<a href="javascript:;">
												<i class="basic-too2017-icon-active"></i>
												分割线
											</a>
										</li>
									</ul>
								</div>
							</div>
						</div>
						<!--/.rows1-->
						<div class="jt">
						</div>
						<div class="right_operate">
							<a href="javascript:;" class="close">
							</a>
							<h4 class="bt">
								题目设置
							</h4>
							<div class="operate_nr">
								<div class="setup">
								</div>
								<!-- <dl>
								<dt>选择方式</dt>
								<dd class="clear choose_way">
								<a href="javascript:;" class="active">单选</a>
								<a href="javascript:;">多选</a>
								</dd>
								</dl>
								<dl class="way">
								<dt>选择排列样式</dt>
								<dd>
								<a href="javascript:;" class="rank">横排</a>
								<a href="javascript:;" class="vertical">竖排</a>
								</dd>
								<dd>
								<a href="javascript:;" class="column">按列</a>
								<div class="lie">
								<input type="text" />列
								</div>
								</dd>
								<dd class="choose">
								最少选<input class="max" type="text"/>项
								</dd>
								<dd class="choose">
								最多选<input class="max" type="text"/>项
								</dd>
								</dl> -->
								<div class="btn_a">
									<a href="javascript:;" class="lj_btn">
										逻辑设置
									</a>
									<a href="javascript:;" class="yy_btn">
										引用设置
									</a>
								</div>
								<div class="btn">
									<a href="javascript:;" class="save">
										保存
									</a>
									<!-- <a href="javascript:;" class="reset">取消</a> -->
								</div>
							</div>
						</div>
						<!-- right_operate -->
						<div class="rows2 well2 Tj">
							<div class="cq_title">
								<h4 name="project" class="h4-bg T_edit p_title">
									Hello Lenovo
								</h4>
							</div>
							<table class="table1 bg-m">
								<tr>
									<td class="rb">
										&nbsp;
									</td>
									<td>
										<div class="th4 T_edit p_begin_desc" name="begin_desc">
											欢迎参加本次答题
										</div>
									</td>
								</tr>
							</table>
							<ul class="dragwen" id="question_box">
								<!-- NA-268 -->
								<!-- 题目的html放这里 -->
							</ul>
							<ul class="ul_tail">
								<li class="module paging" oid="|">
									<div class="topic_type">
										<div class="topic_type_menu">
											<div class="setup-group">
												<a class="DelPaging" href="javascript:;">
													<i class="del2-icon-active">
													</i>
												</a>
											</div>
										</div>
										<div class="topic_type_con">
											<div class="icon_paging">
											</div>
											<div class="fr con_paging">
												页码：
												<span>
													1/1
												</span>
											</div>
										</div>
									</div>
									<!-- <div class="updown">
									<a href="javascript:;">
									<i title="上移本题" class="up-icon-active"></i>
									</a>
									<a href="javascript:;">
									<i title="下移本题" class="down-icon-active"></i>
									</a>
									</div> -->
								</li>
							</ul>
							<table class="table1 bg-m">
								<tr>
									<td class="rb">
									</td>
									<td>
										<div class="selectEnd">
											<select id="end_desc_type">
												<option value="complete">
													正常完成
												</option>
												<option value="screenout">
													提前结束（不计入结果）
												</option>
												<!--option value="自动结束（指定份数）">自动结束（指定份数）</option-->
												<!--option value="自动结束（指定时间）">自动结束（指定时间）</option-->
											</select>
											<span>
												时显示
											</span>
										</div>
										<h4 name='end_desc' class="th4 T_edit p_end_desc" id="end_desc">
											您已完成本次问卷，感谢您的帮助与支持
										</h4>
									</td>
								</tr>
							</table>
						</div>
						<!--/.rows2-->
					</div>
					<!--/.row-fluid-->
				</div>
				<!--/container-fluid-->
			</div>
			<form id="change_project_status_form" action="/edit/ajax/update_project_status/" method="POST" callback="change_project_status_callback">
				<input type="hidden" name="proj_id">
				<input type="hidden" name="status">
				<input type="hidden" name="is_shared">
				<input type="hidden" name="_xsrf" value="844c9158e22b4cccb8654b8c4b34cb8c"/>
			</form>
			<script type="text/javascript">
				var project = <c:out value="${project}" escapeXml="false"/>;
			</script>
			<script type="text/javascript" src="/static/survey/js/cq_edit.js"></script>
			<!--日期组件-->
			<script type="text/javascript" src="/static/survey/js/plug-in/date/javascript/zebra_datepicker.js"></script>
			<script type="text/javascript">
				$(function() {
					$('#lightBox').remove();
					//loadMack({off:'on',Limg:0,text:'加载中...',set:0});
					$('.logicset').click(function() {
						ajax_loads(920, 256, '逻辑设置', '/edit/ajax/logic_set/55c95959f7405b0d33e07575/?v=' + new Date().getTime());
					});
					$('#appearset').click(function() {
						location.href = '/edit/appearset/55c95959f7405b0d33e07575/?v=' + new Date().getTime();
						//mapsets(918,600,'外观设置','/edit/appearset/55c95959f7405b0d33e07575/?v=' + new Date().getTime());
					});
					$('#ansrest').click(function() {
						ajax_loads(640, 380, '收集设置', '/edit/ansrest/55c95959f7405b0d33e07575/?pre_page=design&v=' + new Date().getTime());
					});
					var new_rspd_count = 0;
					if (new_rspd_count > 0) {
						jsAlert({
							content: "<p style='text-align:left;'>您的问卷已收集0份数据，修改问卷可能影响收集到的数据。如需修改问卷请至问卷列表页，点击设计按钮。</p>",
							obj: function() {
								window.location.href = "/mysurvey";
							}
						});
					}
					$().Tjj('.fast_machine a', {
						'widthType': false,
						'Top': 2
					});
					loadMack({
						off: 'off'
					});
				});
				function ajax_loads(w, h, title, url) {
					var wbs = new jsbox({
						onlyid: "maptss",
						title: title,
						conw: w,
						//conh:h,
						FixedTop: 170,
						loads: true,
						url: url,
						range: false,
						mack: true
					}).show();
				}
				//弹出框打包配置
				function mapsets(w, h, title, url) {
					var wbs = new jsbox({
						onlyid: "maptss",
						title: title,
						conw: w,
						conh: h,
						FixedTop: 170,
						iframe: true,
						url: url,
						range: false,
						mack: true
					}).show();
				}
				function close_pop_window() {
					$("#maptss").remove();
					$('#lightBox').remove();
				}
				function flush_after_close_window() {
					$("#maptss").remove();
					$('#lightBox').remove();
					window.location.href = "/edit/survey/55c95959f7405b0d33e07575/";
				}
				function publish_proj_confirm() {
					$(".question").each(function() {
						verify_question_option.hide($(this).attr("oid"));
					}); 
					$.ajax({
						url: '/edit/ajax/publish_check/' + get_oid(project) + '/',
						dataType: 'JSON',
						success: function(ret) {
							if (ret.invalid_qid_list.length === 0) {
								var confirm_popup_win = Object();
								confirm_popup_win.title = "确认发布";
								var content = "是否发布表单?";
								if (project.share_status == 0 && (project.copy_from_pid == undefined || project.copy_from_pid == null || project.copy_from_pid == '')) {
									content += "<br><label><input style='vertical-align:middle;margin-left:0px!important;' type='checkbox' checked='checked' id='checkbox_selector'/>共享到模板库</label><i class='tips' title='选中该选项，本问卷经审核合格后会添加到模板库中，供其他会员制作问卷时参考。'></i>";
								}
								confirm_popup_win.content = content;
								confirm_popup_win.obj = publish_proj;
								confirm_popup_win.close_obj = cancle_publish_proj;
								jsConfirm(confirm_popup_win);
							} else {
								for (var i = 0; i < ret.invalid_qid_list.length; i++) {
									var qid = ret.invalid_qid_list[i];
									var qmodel = get_qmodel(qid);
									qmodel.show_edit_error_msg();
								};
								scroll_to($(".question[oid=" + ret.invalid_qid_list[0] + "]"));
							}
						}
					});
				}
				function publish_proj() {
					var proj_id = project._id.$oid;
					$("#change_project_status_form input[name='proj_id']").val(proj_id);
					$("#change_project_status_form input[name='status']").val(1);
					$("#change_project_status_form input[name='is_shared']").val($("#checkbox_selector").attr("checked"));
					ajaxSubmit($("#change_project_status_form"));
				}
				function change_project_status_callback(info) {
					loadMack({
						off: 'on',
						text: '发布中',
						set: 3000
					});
					setTimeout(function() {
						var panelsite = 'None';
						if (panelsite == 3) {
							var alert_obj = Object();
							alert_obj.title = "成功信息";
							alert_obj.content = "你的问卷已经成功发布到研修网";
							alert_obj.obj_text = '确定';
							alert_obj.obj = function() {
								var url = "/collect/urllink/55c95959f7405b0d33e07575/";
								location.href = url;
							}
							jsAlert(alert_obj);
						} else if (panelsite == 317) {
							var alert_obj = Object();
							alert_obj.title = "成功信息";
							alert_obj.content = "你的问卷已经成功发布";
							alert_obj.obj_text = '确定';
							alert_obj.obj = function() {
								var url = "http://www.baidu.com";
								location.href = url;
							}
							jsAlert(alert_obj);
						} else if (panelsite == 315) {
							var alert_obj = Object();
							alert_obj.title = "成功信息";
							alert_obj.content = "你的问卷已经成功发布";
							alert_obj.obj_text = '确定';
							alert_obj.obj = function() {
								var url = "/list/";
								location.href = url;
							}
							jsAlert(alert_obj);
						} else {
							var url = "/collect/urllink/55c95959f7405b0d33e07575/?fp=" + info.first_publish;
							location.href = url;
						}
					},
					3000);
				}
				function cancle_publish_proj() {}
				var client_uuid = "7122705c-3fce-11e5-bfa5-90b11c535da3";
				//矩阵题宽度调整保存回调
				function matrixWidth_callback(qid, col_width_array, new_question) {
					var table_width = 0;
					var objPadding = 0;
					update_question(new_question);
					$("li[oid='" + qid + "'] .table tbody tr").each(function(m) {
						table_width = 0;
						$(this).children("td").each(function(i) {
							objPadding = parseFloat($(this).css('paddingLeft')) + parseFloat($(this).css('paddingRight')) + 1;
							if (col_width_array[i] == undefined) {
								col_width_array[i] = col_width_array[i - 1]
							};
							$(this).width(col_width_array[i] + "px");
							if (m > 0 && i > 0) {
								if ($(this).children(".div").length > 0) {
									$(this).find(".div").width(col_width_array[i] + "px");
								} else {
									$(this).wrapInner('<div class="div" style="width:' + (col_width_array[i]) + 'px"></div>');
								}
							}
							table_width += col_width_array[i] + objPadding;
						});
					});
					$("li[oid='" + qid + "'] .table").width(table_width);
					$(".jsbox_close").click();
				}
			</script>
			<script type="text/javascript" src="/static/survey/js/init.js"></script>
			<script type="text/javascript" src="/static/survey/js/public.js"></script>
			<script type="text/javascript" src="/static/survey/js/modernizr.custom.js"></script>
			<script type="text/javascript" src="/static/survey/js/enums.js"></script>
			<script type="text/javascript" src="/static/survey/js/models.js"></script>
			<script type="text/javascript" src="/static/survey/js/juicer.js"></script>
			<script type="text/javascript" src="/static/survey/js/survey_utils.js"></script>
			<!--加载提示-->
			<script type="text/javascript" src="/static/survey/js/plug-in/load/load.js"></script>
			<!--气泡弹框-->
			<script type="text/javascript" src="/static/survey/js/plug-in/JsBubble/JsBubble.js"></script>
			<!--弹出框-->
			<script type="text/javascript" src="/static/survey/js/plug-in/jsbox/jsbox.js"></script>
			<!--汽包弹出框-->

			<script type="text/javascript" src="/static/survey/js/plug-in/tjj/jquery.zn.js"></script>
			<!--FCK编辑器-->
			<script type="text/javascript" src="/static/survey/js/plug-in/ckeditor/ckeditor.js"></script>
			<script src="/static/survey/js/edit/edit.js?v=" + <%=new Random().nextInt() %>></script>
			<script src="/static/survey/js/edit/edit_utils.js"></script>
			<script src="/static/survey/js/edit/edit_init.js"></script>
			<script src="/static/survey/js/edit/q_template.js"></script>
			<script src="/static/survey/js/ssq.js"></script>
			<script type="text/javascript">
				var active_index = 0;
				var found = 0;
				$(".main-nav li a").each(function() {
					if ($(this).text() == '问卷') found = 1;
					if (found == 0) active_index += 1;
				});
				set_active_head_v2(active_index);
				var first_edit = false;
				if (first_edit) {
					//新手帮助
					//Help_up();
				}
				// window.onbeforeunload = function(){
				// syncPost('/edit/ajax/exit_edit/'+get_oid(project)+"/", {});
				// }
				var is_iframe = false;
			</script>
			<!--图片裁剪-->
			<script type="text/javascript" src="/static/survey/js/plug-in/Jcrop/Jcrop.js"></script>
			<script type="text/javascript" src="/static/survey/js/plug-in/dmuploader/demo.min.js"></script>
			<script type="text/javascript" src="/static/survey/js/plug-in/dmuploader/dmuploader.min.js"></script>
		</div>
<!-- 		<script type="text/javascript">
			$(function() {
				$().top_hj();
				$('.left_Menu li.gz_wx').hover(function() {
					$(this).find('.gz_weixin_ewm').stop(true, true).fadeIn(150);
				},
				function() {
					$(this).find('.gz_weixin_ewm').stop(true, true).fadeOut(150);
				});
				$(".loginBox").mouseup(function() {
					return false;
				});
				$('body').mouseup(function() {
					$(".loginBox").fadeOut("slow");
					$('.username').find('.loginMeun').hide();
					$('.username').find('.arrowupt').removeClass('atop');
				});
				$("a img[src='http://eiv.baidu.com/hmt/icon/21.gif']").hide();
			});

			$.ajax({
				type: "get",
				url: "/message/check",
				data: "",
				success: function(result) {
					if (result == 'True') {
						$('.wjNews').html("<span class='PointRed'></span>");
					}
				}
			});

			(function($) {
				$.fn.extend({
					"top_hj": function(Obj) {
						if (!Obj) {
							Obj = {}
						}
						var Tinfo = {
							parent: Obj.parent || ".Tj",
							url: Obj.url || "/about/zxzx/"
						};
						var Zonw = 0;
						var str = 'edit';
						/*if(location.href.indexOf(str)<0){
	$('body').prepend('<div class="GoBack ie6fixedBR" style="right:' + Zonw + 'px" ><a class="top_hj" title="置顶" href="javascript:;"></a><a title="关注问卷网微信" class="top_weixin" href="javascript:;"></a><a class="top_feedback" target="_blank" href="' + Tinfo.url + '"></a></div>');
	} */
						fu_scroll($(window));
						$(window).scroll(function() {
							$('.gzweixin').hide();
							fu_scroll($(this))
						});
						$('.top_hj').live('click',
						function() {
							$('html,body').animate({
								scrollTop: 0
							},
							'slow');
						});
						$('.top_weixin').die().live('click',
						function() {
							var gzweixin = $('.gzweixin:visible');
							if (gzweixin.length > 0) {
								gzweixin.hide()
							} else {
								addGzTip($(this));
							}
							return
						});
						function fu_scroll(_this) {
							var scrollT = _this.scrollTop();
							if (scrollT > 300) {
								$('.top_hj').show();
							} else {
								$('.top_hj').hide();
							}
						}
						function addGzTip(obj) {
							var x = obj.offset().left - 160;
							var y = obj.offset().top - 123;
							var gzweixin = $('gzweixin');
							if (gzweixin.length > 0) {
								gzweixin.css({
									'top': y + 'px',
									'left': x + 'px'
								});
							} else {
								var con = '<div style="top:' + y + 'px;left:' + x + 'px;" class="gzweixin"></div>';
								$('body').append(con);
							}
						}
					}
				})
			})(jQuery);
		</script>
 -->		<!--<script type="text/javascript" src="/static/survey/js/third_party_stat.js"></script>-->
		<script type="text/javascript">
			$(function() {
				autoheight();
				var resizeTimer1 = null;
				$(window).resize(function() {
					if (resizeTimer1) clearTimeout(resizeTimer1);
					resizeTimer1 = setTimeout("autoheight()", 100);
				});
			});
			function autoheight() {
				if (($(document).height() - $('body').innerHeight()) > 0) {
					$('.footer_w').css('margin-top', '0px');
					$('.footer_w').css('margin-top', ($(document).height() - $('body').innerHeight()) + 'px')
				};
			} (function($) {
				$.fn.extend({
					"MenuFixed_top": function(obj, top, as) {
						function Mf() {
							var scrollT = $(this).scrollTop();
							if (scrollT > top) {
								//obj.attr('style','position:absolute; top:'+(scrollT-80)+'px;');
								var h = obj.height();
								obj.attr('style', 'position:fixed; top:0px;');
								obj.addClass('this_fixed');
								obj.parent().css({
									paddingTop: h + 'px'
								});
								//$('<div class="fixed_next" style="width:1px;height:'+h+'+px"></div>').insertAfter(obj);
							} else {
								obj.parent().css({
									paddingTop: '0px'
								});
								obj.attr('style', '');
								obj.removeClass('this_fixed');
								// obj.next().remove();
							}
						}
						Mf();
						$(window).scroll(function() {
							Mf();
						});
					}
				});
			})(jQuery);
		</script>
	</body>
</html>