<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>
			创建问卷
		</title>
		<link href="/static/survey/css/create.css" rel="stylesheet">
		<script type="text/javascript" src="/static/survey/js/jquery.js"></script>
		<script type="text/javascript" src="/static/survey/js/base_utils.js"></script>
		<script type="text/javascript" src="/static/survey/js/create_cq.js"></script>
	</head>
	<body>
		<div class="head_nav">
			<a href="http://www.wenjuan.com/new" class="back">
				返回
			</a>
			<div class="nav">
				<a href="create.html" class="create active">
					创建全新问卷
				</a>
				<a href="http://www.wenjuan.com/ref?p_type=" class="quote">
					引用问卷模板
				</a>
				<a href="http://www.wenjuan.com/copy?p_type=" class="copy">
					复制已有问卷
				</a>
			</div>
		</div>
		<!--top end-->
		<div class="main">
			<div class="box step_one tabs_content">
				<form id="form1" method="POST" action="<c:url value="/place.htm"/>">
					<h2>
						问卷标题
					</h2>
					<input type="textarea" onkeypress="if(event.keyCode==13||event.which==13){return check_condition();}"
					name="title" id="proj_title" style="border: 1px solid rgb(210, 210, 210);">
					<input type="hidden" name="project_func" id="project_func">
					<h2>
						选择类别
					</h2>
					<ul class="ssort clearfix">
						<li class="survey_0" id="51dd234e9b9fbe6646bf4dcc">
							<a href="javascript:;">
							</a>
						</li>
						<li class="survey_1" id="51dd234e9b9fbe6646bf4dcd">
							<a href="javascript:;">
							</a>
						</li>
						<li class="survey_2" id="51dd234e9b9fbe6646bf4dce">
							<a href="javascript:;">
							</a>
						</li>
						<li class="survey_3" id="51dd234e9b9fbe6646bf4dcf">
							<a href="javascript:;">
							</a>
						</li>
						<li class="survey_4" id="51dd234e9b9fbe6646bf4dd0">
							<a href="javascript:;">
							</a>
						</li>
						<li class="survey_5" id="51dd234e9b9fbe6646bf4dd1">
							<a href="javascript:;">
							</a>
						</li>
						<li class="survey_6" id="51dd234e9b9fbe6646bf4dd2">
							<a href="javascript:;">
							</a>
						</li>
						<li class="survey_7" id="51dd234e9b9fbe6646bf4dd3">
							<a href="javascript:;">
							</a>
						</li>
					</ul>
					<div class="btn_create">
						<p class="btn_ceng">
							创建
						</p>
						<div class="btn1" id="btn_submit">
							创 建
						</div>
					</div>
					<input type="hidden" name="vvcode" value="58">
					<input type="hidden" name="vcode" id="vcode">
					<input type="hidden" name="s_func_id" value="84">
					<input type="hidden" name="s_code" value="" id="s_code">
					<input type="hidden" name="vvv" value="eaa1994f233a55d43e849ca58c9110cc">
					<input type="hidden" name="_xsrf" value="844c9158e22b4cccb8654b8c4b34cb8c">
				</form>
			</div>
		</div>
		<form id="is_validate_code_form" style="display:none" action="<c:url value='/operate/ajax/get_validate_status.json'/>"
		method="POST" callback="validate_callback">
			<input type="hidden" name="key" value="55c5b9a5f7405b0c950f3987_c_p_n_l">
			<input type="hidden" name="_xsrf" value="844c9158e22b4cccb8654b8c4b34cb8c">
		</form>
		<form id="validate_vcode_form" style="display:none" action="<c:url value='/operate/ajax/validate_vcode/'/>"
		method="POST" callback="validate_vcode_form_callback">
			<input type="hidden" name="vcode">
			<input type="hidden" name="_xsrf" value="844c9158e22b4cccb8654b8c4b34cb8c">
		</form>
		<!--wjContent end-->
		<!--加载提示-->
		<link href="/static/survey/js/plug-in/load/load.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="/static/survey/js/plug-in/load/load.js"></script>
		<script type="text/javascript" src="/static/survey/js/plug-in/jsbox/jsbox.js"></script>
		<script type="text/javascript" src="/static/survey/js/security_func.js"></script>
		<link href="/static/survey/js/plug-in/jsbox/jsbox.css" rel="stylesheet">
		<script type="text/javascript">
			//old
			var vvcode = '58';
			var fname = "lzcYJHTA";
			eval(eval("s1(10)+s1(102)+s1(117)+s1(110)+s1(99)+s1(116)+s1(105)+s1(111)+s1(110)+s1(32)+s1(108)+s1(122)+s1(99)+s1(89)+s1(74)+s1(72)+s1(84)+s1(65)+s1(40)+s1(112)+s1(52)+s1(53)+s1(54)+s1(41)+s1(32)+s1(123)+s1(10)+s1(32)+s1(32)+s1(32)+s1(32)+s1(114)+s1(101)+s1(116)+s1(117)+s1(114)+s1(110)+s1(32)+s1(53)+s1(45)+s1(54)+s1(45)+s1(50)+s1(43)+s1(49)+s1(48)+s1(42)+s1(57)+s1(43)+s1(112)+s1(52)+s1(53)+s1(54)+s1(59)+s1(10)+s1(125)+s1(10)"));
			jQuery(document).ready(function() {
				// $("#form1").bind("submit",return function(){listenSubmit();});
				$("#btn_submit").click(function(event) {
					$(this).prev('.btn_ceng').show();
					ajaxSubmit($("#is_validate_code_form"));
				});
				$("#proj_title").focus();
				$('.create').addClass('active');

				$('.head_nav .back').attr("href", '/new');

				var _href = $('.nav .quote').attr('href');
				function load_id(obj) {
					var func_id = $(obj).attr('id');
					$('.nav .quote').attr('href', _href + '&func_id=' + func_id + '');
				}
				$('#form1 li').live('click',
				function() {
					load_id(this);
				});
				$('#form1 li').each(function() {
					if ($(this).hasClass('active')) {
						$(this).click();
					}
				});
				$('#proj_title').focus(function() {
					$(this).css('border', '1px solid #0099FF');
				}).blur(function() {
					$(this).css('border', '1px solid #d2d2d2');
				});
				$('#proj_title').focus();
				$('.tabs_content ul li').live('click',
				function() {
					$(this).addClass('active').siblings().removeClass('active');
					$(this).find('a').addClass('active').html('<img src="/static/survey/images/selected.png" />');
					$(this).siblings('li').find('a').removeClass('active').html('');
					var _id = $(this).attr('id');
					$('#project_func').attr('value', _id);
				});
				$('.tabs_content ul li').each(function() {
					if (window.location.href.indexOf($(this).attr('id')) > -1) {
						$(this).click();
					}
				});
			});
			function validate_callback(info) {
				setTimeout(function() {
					$('.btn_create .btn_ceng').fadeOut(150);
				},
				1000);
				if (info.is_gt_l_p_num == 1) {
					var validate_obj = Object;
					validate_obj.title = '提示';
					var content = '你今天创建的问卷数已经超过上限了，休息一下';
					validate_obj.content = content;
					validate_obj.obj_text = "确定";
					jsConfirm(validate_obj);
				} else if (info.is_validate == 1) {
					var validate_obj = Object;
					validate_obj.title = '验证码';
					var content = '<tr><td class="alignr"><p style="margin-bottom: 10px;">请输入验证码</p></td><td><input type="text" id="vcode_input" ipt="vcode" name="vcode" class="btx" style="width:80px;"/><img style="display: inline-block;margin: 1px 13px 1px 10px;vertical-align: top;height: 27px;" id="vcode_img" src="/?action=proj_c_vcode" border="0" onclick="this.src=this.src.substr(this.src.indexOf(\'/?action=proj_c_vcode\'),28)+\'&\'+Math.random()"><a style="display:inline;" href="javascript:change_vcode()">换一张</a><br><label id="code_err_msg" style="display:none" class="info_lab text_red">请输入正确的验证码</label></td></tr>';
					validate_obj.content = content;
					validate_obj.obj = submit_vcode;
					validate_obj.obj_text = "确定";
					validate_obj.close_text = "取消";
					jsConfirm(validate_obj);
				} else {
					create_project();
				}
			}
			function change_vcode() {
				var urlstr = $("#vcode_img").attr("src");
				var imgsrc = urlstr.substr(urlstr.indexOf('/?action=proj_c_vcode'), 28) + '&' + Math.random();
				$("#vcode_img").attr("src", imgsrc);
			}
			function submit_vcode() {
				$("#validate_vcode_form input[name='vcode']").val($("#vcode_input").val());
				$("#vcode").val($("#vcode_input").val());
				ajaxSubmit($("#validate_vcode_form"));
				return 1;
			}
			function validate_vcode_form_callback(info) {
				if (info.result == 1) {
					create_project();
				} else {
					$("#code_err_msg").css('display', '');
				}
			}
			function create_project() {
				var title = $("#proj_title").val();
				title = title.trim();
				if (title == "") {
					loadMack({
						off: 'on',
						Limg: 0,
						text: '新问卷标题不能为空',
						set: 1500
					});
					$("#proj_title").focus();
					return false;
				}
				if ($(".ssort .active").length == 0) {
					loadMack({
						off: 'on',
						Limg: 0,
						text: '请选择类别',
						set: 1500
					});
					return false;
				}
				var project_func;
				$(".ssort .active").each(function() {
					project_func = $(this).parent().attr("id")
				});
				var code = 'var s_code = ' + fname + '(' + vvcode + ')';
				eval(code);
				$("#s_code").val(s_code);
				$("#project_func").val(project_func);
				$("#proj_title").attr("value", title);
				$("#form1").submit();
			}
			function check_condition() {
				var title = $("#proj_title").val();
				title = title.trim();
				if (title == "") {
					loadMack({
						off: 'on',
						Limg: 0,
						text: '新问卷标题不能为空',
						set: 1500
					});
					$("#proj_title").focus();
					return false;
				}
				var project_func = $("#project_func").val();
				if (project_func == "") {
					loadMack({
						off: 'on',
						Limg: 0,
						text: '请选择类别',
						set: 1500
					});
					$("#project_func").focus();
					return false;
				}
				create_project()
			}
		</script>
		<script type="text/javascript">
			$(function() {
				if ($('#pagenum').length > 0) {
					var pagenum = $('#pagenum').html();
					pagenum = pagenum.replace("..", "<em>...</em>");
					pagenum = pagenum.replace(" .. ", "<em>...</em>");
					$('#pagenum').html(pagenum);
				}
			})
		</script>
	</body>

</html>