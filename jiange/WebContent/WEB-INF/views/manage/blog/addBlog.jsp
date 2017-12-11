<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<!--[if IE 7 ]>		 <html class="no-js ie ie7 lte7 lte8 lte9" lang="zh-cmn-Hans-CN"> <![endif]-->
<!--[if IE 8 ]>		 <html class="no-js ie ie8 lte8 lte9" lang="zh-cmn-Hans-CN"> <![endif]-->
<!--[if IE 9 ]>		 <html class="no-js ie ie9 lte9" lang="zh-cmn-Hans-CN"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<html class="no-js" lang="zh-cmn-Hans-CN">
  <!--<![endif]-->
  <head> 
    <meta charset="utf-8" /> 
    <meta name="renderer" content="webkit|ie-comp|ie-stand" /> 
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" /> 
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" /> 
    <meta http-equiv="Cache-Control" content="no-siteapp" /> 
    <title>博客~~写博客</title>
    <meta name="keywords" content="" />
    <meta name="description" content="java,j2ee,j2ee.top, tinygroup,tinygroup.org,eclipse,插件,idea,TinyFramework,悠然,悠悠然然,Tiny,Framework,CEP,通用事件处理,ui引擎,ui engine,模块化,业务单元,文档生成,xml parser,html parser,xml,html,parser,spider,网络爬虫,flow,流程,业务流,页面流,Java,SOA,框架,组件,分层,水平扩展,分区,分表,db router,db cluster,framework,框架,分布式计算,VFS,Web" /> 
    <script>var contextPath = "/joby";</script>
    <link rel="shortcut icon" href="/joby/img/tiny32.png" /> 
    <script src="/joby/org/monkey/jquery/js/jquery-1.11.2.min.js"></script>
    <script src="<c:url value='/joby/org/monkey/jquery/js/jquery-1.11.2.min.js'/>"></script>
    <script src="/joby/org/monkey/jquery/js/jquery.brower.js"></script>
    <script src="/joby/org/monkey/jquery/js/moment.js"></script> 
    <link href="/joby/org/monkey/bootstrap/css/bootstrap.min.css" rel="stylesheet" /> 
    <link href="<c:url value='/joby/org/monkey/bootstrap/css/bootstrap.min.css' />" rel="stylesheet" />
    <script src="/joby/org/monkey/bootstrap/js/bootstrap.min.js"></script>
    <link href="/joby/org/monkey/frameCommon/assets/stylesheets/tiny-admin.min.css" rel="stylesheet" />
    <link href="/joby/org/monkey/frameCommon/assets/stylesheets/widgets.min.css" rel="stylesheet" />
    <script src="/joby/org/monkey/frameCommon/assets/javascripts/tiny-admin.min.js"></script>
    <script>
      var tinyTplList=[];	</script>
    <link href="/joby/org/monkey/frameTplDeepblue/assets/stylesheets/themes.min.css" rel="stylesheet" />
    <script>
      tinyTplList.push({sort:2,name: 'adminflare',  title: '深蓝', img: contextPath+'/img/themes/deep-blue.png' });	</script>
    <link href="/joby/org/monkey/publicComponent/css/tiny-ui.css" rel="stylesheet" /> 
    <link href="/joby/org/monkey/publicComponent/iconfont/iconfont.css" rel="stylesheet" /> 
    <link href="/joby/org/monkey/publicComponent/css/font-awesome.min.css" rel="stylesheet" /> 
    <script src="/joby/org/monkey/publicComponent/js/stickUp.min.js"></script> 
    <script src="/joby/org/monkey/publicComponent/js/tiny-ui.js"></script> 
    <script src="/joby/org/monkey/publicComponent/js/common.js"></script> 
    <script src="/joby/org/monkey/publicComponent/js/Tinyui.admin.js"></script> 
    <script src="/joby/org/monkey/publicComponent/js/Tinyui.admin.doc.js"></script> 
    <script src="/joby/org/monkey/publicComponent/js/jquery.cookie.js"></script> 
    <!--[if lt IE 9]>
																																																							<link href="/joby/org/monkey/publicComponent/css/ie8apply.css" rel="stylesheet" />
																																																														<script src="/joby/org/monkey/publicComponent/js/html5shiv.min.js"></script>
																												<script src="/joby"></script>
																	                            <![endif]--> 
    <link href="/joby/org/monkey/interfaceElements/css/jquery.range.css" rel="stylesheet" /> 
    <script src="/joby/org/monkey/interfaceElements/js/jquery.spinner.js"></script> 
    <script src="/joby/org/monkey/interfaceElements/js/jquery.range.js"></script> 
    <script src="/joby/org/monkey/interfaceElements/js/jquery.twbsPagination.js"></script> 
    <script src="/joby/org/monkey/interfaceElements/js/dataPaging.js"></script> 
    <link href="/joby/org/monkey/timeline/css/history.css" rel="stylesheet" /> 
    <script src="/joby/org/monkey/timeline/js/main.js"></script> 
    <script src="/joby/org/monkey/timeline/js/jquery.timelinr.js"></script> 
    <script src="/joby/org/monkey/lineChart/js/chartMain.js"></script> 
    <script src="/joby/org/monkey/lineChart/js/chart.line.min.js"></script> 
    <link href="/joby/org/monkey/buttonGroup/css/buttonGroup.css" rel="stylesheet" /> 
    <link href="/joby/org/monkey/thumbnails/css/thumbnails.css" rel="stylesheet" /> 
    <script src="/joby/org/monkey/thumbnails/js/thumbnails.js"></script> 
    <link href="/joby/org/monkey/labelBadge/css/labelBadge.css" rel="stylesheet" /> 
    <link href="/joby/org/monkey/superBox/css/superBox.css" rel="stylesheet" /> 
    <script src="/joby/org/monkey/superBox/js/superbox.js"></script> 
    <link href="/joby/org/monkey/tabShow/css/tabcut.css" rel="stylesheet" /> 
    <script src="/joby/org/monkey/tabShow/js/artTabs.js"></script> 
    <link href="/joby/org/monkey/button/css/button.css" rel="stylesheet" /> 
    <link href="/joby/org/monkey/example/css/example.css" rel="stylesheet" /> 
    <link href="/joby/org/monkey/bootstrapDate/css/daterangepicker-bs3.css" rel="stylesheet" /> 
    <script src="/joby/org/monkey/bootstrapDate/js/daterangepicker.js"></script> 
    <script src="/joby/org/monkey/bootstrapDate/js/WdatePicker.js"></script> 
    <link href="/joby/org/monkey/modal/css/modal.css" rel="stylesheet" /> 
    <script src="/joby/org/monkey/modal/js/jquery-drag.js"></script> 
    <script src="/joby/org/monkey/modal/js/bootstrap-modalmanager.js"></script> 
    <script src="/joby/org/monkey/modal/js/bootstrap-modal.js"></script> 
    <link href="/joby/org/monkey/fullCalendar/css/fullcalendar.css" rel="stylesheet" /> 
    <script src="/joby/org/monkey/fullCalendar/js/fullcalendar.min.js"></script> 
    <script src="/joby/org/monkey/jqueryForm/js/jquery.form.js"></script> 
    <link href="/joby/org/monkey/tourbus/css/jquery-tourbus.css" rel="stylesheet" /> 
    <script src="/joby/org/monkey/tourbus/js/jquery.scrollTo.min.js"></script> 
    <script src="/joby/org/monkey/tourbus/js/jquery-tourbus.js"></script> 
    <link href="/joby/org/monkey/mmGrid/src/mmGrid.css" rel="stylesheet" /> 
    <link href="/joby/org/monkey/mmGrid/src/theme/bootstrap/mmGrid-bootstrap.css" rel="stylesheet" /> 
    <link href="/joby/org/monkey/mmGrid/src/mmPaginator.css" rel="stylesheet" /> 
    <link href="/joby/org/monkey/mmGrid/src/theme/bootstrap/mmPaginator-bootstrap.css" rel="stylesheet" /> 
    <script src="/joby/org/monkey/mmGrid/examples/js/plugins.js"></script> 
    <script src="/joby/org/monkey/mmGrid/examples/js/vendor/json2.js"></script> 
    <script src="/joby/org/monkey/mmGrid/src/mmGrid.js"></script> 
    <script src="/joby/org/monkey/mmGrid/src/mmPaginator.js"></script> 
    <link href="/joby/org/monkey/jqueryUi/css/ui-production.min.css" rel="stylesheet" /> 
    <script src="/joby/org/monkey/jqueryUi/js/jquery-ui-1.10.3.min.js"></script> 
    <script src="/joby/org/monkey/widget/js/app.config.js"></script> 
    <script src="/joby/org/monkey/widget/js/jarvis.widget.min.js"></script> 
    <script src="/joby/org/monkey/widget/js/app.min.js"></script> 
    <script src="/joby/org/monkey/morris/js/raphael.min.js"></script> 
    <script src="/joby/org/monkey/morris/js/morris.min.js"></script> 
    <link href="/joby/org/monkey/frameTplFashion/assets/stylesheets/themes.min.css" rel="stylesheet" /> 
    <script>
	tinyTplList.push({sort:10, name: 'white',  title: '时尚', img: contextPath+'/img/themes/fashion.png' });	</script> 
    <link href="/joby/org/monkey/progress/css/progress.css" rel="stylesheet" /> 
    <script src="/joby/org/monkey/progress/js/progress.js"></script> 
    <link href="/joby/org/monkey/search/css/search.css" rel="stylesheet" /> 
    <script src="/joby/org/monkey/search/js/search.js"></script> 
    <link href="/joby/org/monkey/highCharts/css/highCharts.css" rel="stylesheet" /> 
    <script src="/joby/org/monkey/highCharts/js/highcharts.js"></script> 
    <script src="/joby/org/monkey/highCharts/js/exporting.js"></script> 
    <script src="/joby/org/monkey/highCharts/js/data.js"></script> 
    <script src="/joby/org/monkey/highCharts/js/highcharts-3d.js"></script> 
    <script src="/joby/org/monkey/pieCharts/js/jsapi.js"></script> 
    <script src="/joby/org/monkey/pieCharts/js/corechart.js"></script> 
    <script src="/joby/org/monkey/pieCharts/js/jquery.gvChart-1.0.1.min.js"></script> 
    <script>
	$(document).ready(function(){
                gvChartInit();
            });	</script> 
    <link href="/joby/org/monkey/searchPage/css/searchPage.css" rel="stylesheet" /> 
    <link href="/joby/org/monkey/frameTplOrange/assets/stylesheets/themes.min.css" rel="stylesheet" /> 
    <script>
	tinyTplList.push({sort:5,name: 'dust',  title: '橙色', img: contextPath+'/img/themes/orange.png'});	</script> 
    <link href="/joby/org/monkey/picture/css/picture.css" rel="stylesheet" /> 
    <link href="/joby/org/monkey/frameTplPurple/assets/stylesheets/themes.min.css" rel="stylesheet" /> 
    <script>
	tinyTplList.push({ sort:8,name: 'purple-hills', title: '紫色', img: contextPath+'/img/themes/purple-hills.png' });	</script> 
    <link href="/joby/org/monkey/uedTips/css/uedTip.css" rel="stylesheet" /> 
    <script src="/joby/org/monkey/uedTips/js/uedTip.js"></script> 
    <link href="/joby/org/monkey/dropDown/css/dropDown.css" rel="stylesheet" /> 
    <script src="/joby/org/monkey/dropDown/js/dropDown.js"></script> 
    <link href="/joby/org/monkey/webupload/lib/webuploader.css" rel="stylesheet" /> 
    <script src="/joby/org/monkey/webupload/lib/webuploader.min.js"></script> 
    <link href="/joby/org/monkey/loginRegistered/images/ue_grid.css" rel="stylesheet" /> 
    <link href="/joby/org/monkey/loginRegistered/images/style.css" rel="stylesheet" /> 
    <link href="/joby/org/monkey/loginRegistered/css/style.css" rel="stylesheet" /> 
    <script src="/joby/org/monkey/loginRegistered/script/jquery.easing.min.js"></script> 
    <script src="/joby/org/monkey/loginRegistered/script/custom.js"></script> 
    <link href="/joby/org/monkey/zoomPic/css/zoomPic.css" rel="stylesheet" /> 
    <script src="/joby/org/monkey/zoomPic/js/zoominfo.js"></script> 
    <link href="/joby/org/monkey/unslider/css/slide.css" rel="stylesheet" /> 
    <script src="/joby/org/monkey/unslider/js/jquery.touchSlider.js"></script> 
    <link href="/joby/org/monkey/ad/css/ad.css" rel="stylesheet" /> 
    <script src="/joby/org/monkey/ad/js/ad.js"></script> 
    <link href="/joby/org/monkey/tab/css/tab.css" rel="stylesheet" /> 
    <script src="/joby/org/monkey/tab/js/tab.js"></script> 
    <link href="/joby/org/monkey/code/css/code.css" rel="stylesheet" /> 
    <script src="/joby/org/monkey/code/js/prettify.js"></script> 
    <link href="/joby/org/monkey/easy/css/jquery.easy-pie-chart.css" rel="stylesheet" /> 
    <script src="/joby/org/monkey/easy/js/excanvas.js"></script> 
    <script src="/joby/org/monkey/easy/js/jquery.easy-pie-chart.js"></script> 
    <link href="/joby/org/monkey/flot/css/flot.css" rel="stylesheet" /> 
    <script src="/joby/org/monkey/flot/js/jquery.flot.cust.min.js"></script> 
    <script src="/joby/org/monkey/flot/js/jquery.flot.resize.min.js"></script> 
    <script src="/joby/org/monkey/flot/js/jquery.flot.fillbetween.min.js"></script> 
    <script src="/joby/org/monkey/flot/js/jquery.flot.orderBar.min.js"></script> 
    <script src="/joby/org/monkey/flot/js/jquery.flot.pie.min.js"></script> 
    <script src="/joby/org/monkey/flot/js/jquery.flot.time.min.js"></script> 
    <script src="/joby/org/monkey/flot/js/jquery.flot.tooltip.min.js"></script> 
    <link href="/joby/org/monkey/fold/fold/css/fold.css" rel="stylesheet" /> 
    <script src="/joby/org/monkey/fold/fold/js/fold.js"></script> 
    <link href="/joby/org/monkey/layer/skin/layer.css" rel="stylesheet" /> 
    <script src="/joby/org/monkey/layer/layer.min.js"></script> 
    <script src="/joby/org/monkey/layer/extend/layer.ext.js"></script> 
    <link href="/joby/org/monkey/form/css/form.css" rel="stylesheet" /> 
    <script src="/joby/org/monkey/form/js/Validform_v5.3.2.js"></script> 
    <script src="/joby/org/monkey/form/js/jquery.icheck.min.js"></script> 
    <script src="/joby/org/monkey/form/js/ajaxfileupload.js"></script> 
    <script src="/joby/org/monkey/form/js/jquery.queryFor.js"></script> 
    <link href="/joby/org/monkey/icon/css/icon.css" rel="stylesheet" /> 
    <link href="/joby/org/monkey/tags/css/tags.css" rel="stylesheet" /> 
    <script src="/joby/org/monkey/tags/js/tags.js"></script> 
    <link href="/joby/org/monkey/alert/css/alert.css" rel="stylesheet" /> 
    <script src="/joby/org/monkey/alert/js/alert.js"></script> 
    <link href="/joby/org/monkey/UEditor/css.css" rel="stylesheet" /> 
    <script src="/joby/org/monkey/UEditor/umeditor.config.js"></script> 
    <script src="/joby/org/monkey/UEditor/umeditor.js"></script> 
    <script src="/joby/org/monkey/UEditor/lang/zh-cn/zh-cn.js"></script> 
    <script src="/joby/org/monkey/UEditor/dialogs/link/link.js"></script> 
    <script src="/joby/org/monkey/UEditor/dialogs/image/image.js"></script> 
    <script src="/joby/org/monkey/UEditor/dialogs/video/video.js"></script> 
    <script src="/joby/org/monkey/UEditor/dialogs/map/map.js"></script> 
    <script src="/joby/org/monkey/UEditor/dialogs/formula/formula.js"></script> 
    <script src="/joby/org/monkey/UEditor/dialogs/emotion/emotion.js"></script> 
    <link href="/joby/org/monkey/forum/css/forum.css" rel="stylesheet" /> 
    <link href="/joby/org/monkey/gantt/css/jsgantt.css" rel="stylesheet" /> 
    <script src="/joby/org/monkey/gantt/js/jsgantt.js"></script> 
    <link href="/joby/org/monkey/media/css/media.css" rel="stylesheet" /> 
    <link href="/joby/org/monkey/table/css/table.css" rel="stylesheet" /> 
    <script src="/joby/org/monkey/table/js/jquery.form.js"></script> 
    <script src="/joby/org/monkey/table/js/jquery.twbsPagination.js"></script> 
    <link href="/joby/org/monkey/toTop/css/toTop.css" rel="stylesheet" /> 
    <script src="/joby/org/monkey/toTop/js/toTop.js"></script> 
    <link href="/joby/org/monkey/zTree/css/zTreeStyle/zTreeStyle.css" rel="stylesheet" /> 
    <link href="/joby/org/monkey/zTree/css/awesomeStyle/awesome.css" rel="stylesheet" /> 
    <script src="/joby/org/monkey/zTree/js/jquery.ztree.core-3.5.js"></script> 
    <script src="/joby/org/monkey/zTree/js/jquery.ztree.exhide-3.5.js"></script> 
    <script src="/joby/org/monkey/zTree/js/jquery.ztree.excheck-3.5.js"></script> 
    <script src="/joby/org/monkey/zTree/js/jquery.ztree.exedit-3.5.js"></script> 
    <script src="/joby/org/monkey/zTree/js/ztree.selected.js"></script> 
    <link href="/joby/org/monkey/gridSystems/css/gridSystems.css" rel="stylesheet" /> 
    <link href="/joby/org/monkey/Smart-treeview/css/Smart-treeview.css" rel="stylesheet" /> 
    <link href="/joby/org/monkey/Smart-treeview/css/treeview.css" rel="stylesheet" /> 
    <script src="/joby/org/monkey/Smart-treeview/js/treeview.js"></script> 
    <link href="/joby/org/monkey/fooTable/css/footable.core.css" rel="stylesheet" /> 
    <link href="/joby/org/monkey/fooTable/css/fooTable.css" rel="stylesheet" /> 
    <script src="/joby/org/monkey/fooTable/js/footable.all.min.js"></script> 
    <link href="/joby/org/monkey/userComment/css/zyComment.css" rel="stylesheet" /> 
    <script src="/joby/org/monkey/userComment/js/zyComment.js"></script> 
    <link href="/joby/org/monkey/frameTplDark/assets/stylesheets/themes.min.css" rel="stylesheet" /> 
    <script>
	tinyTplList.push({sort:1, name: 'clean',  title: '深色', img: contextPath+'/img/themes/dark.png' });	</script> 
    <link href="/joby/org/monkey/frameTplGray/assets/stylesheets/themes.min.css" rel="stylesheet" /> 
    <script>
	tinyTplList.push({sort:4, name: 'default', title: '灰色', img: contextPath+'/img/themes/default.png' });	</script> 
    <link href="/joby/org/monkey/viewsControl/css/styles.min.css" rel="stylesheet" /> 
    <script src="/joby/org/monkey/viewsControl/js/jplist.min.js"></script> 
    <link href="/joby/org/monkey/maskBar/css/maskBar.css" rel="stylesheet" /> 
    <link href="/joby/org/monkey/comment/css/comment.css" rel="stylesheet" /> 
    <script src="/joby/org/monkey/comment/js/myComment.js"></script> 
    <link href="/joby/org/monkey/compose/css/compose.css" rel="stylesheet" /> 
    <link href="/joby/org/monkey/emailTemplate/css/email.css" rel="stylesheet" /> 
    <link href="/joby/org/monkey/frameTplLightblue/assets/stylesheets/themes.min.css" rel="stylesheet" /> 
    <script>
	tinyTplList.push({sort:7,name: 'frost',  title: '浅蓝', img: contextPath+'/img/themes/light-blue.png' });	</script> 
    <link href="/joby/org/monkey/animation/css/animation.css" rel="stylesheet" /> 
    <link href="/joby/org/monkey/Smart-navigation/css/Smart-navigation.css" rel="stylesheet" /> 
    <link href="/joby/org/monkey/voteCharts/css/voteCharts.css" rel="stylesheet" /> 
    <script src="/joby/org/monkey/voteCharts/js/voteCharts.js"></script> 
    <link href="/joby/org/monkey/dataTables/css/jquery.dataTables.min.css" rel="stylesheet" /> 
    <script src="/joby/org/monkey/dataTables/js/jquery.dataTables.min.js"></script> 
    <script src="/joby/newLogin/js/cloud.js"></script> 
    <link href="/joby/org/monkey/rolling/css/rolling.css" rel="stylesheet" /> 
    <script src="/joby/org/monkey/rolling/js/jcarousellite.min.js"></script> 
    <script src="/joby/org/monkey/rolling/js/jquery.textSlider.js"></script> 
    <script src="/joby/org/monkey/rolling/js/dropDown.js"></script> 
    <link href="/joby/org/monkey/frameTplBlack/assets/stylesheets/themes.min.css" rel="stylesheet" /> 
    <script>
	tinyTplList.push({sort:9, name: 'silver',  title: '黑色', img: contextPath+'/img/themes/black.png' });	</script> 
    <link href="/joby/org/monkey/frameTplGreen/assets/stylesheets/themes.min.css" rel="stylesheet" /> 
    <script>
	tinyTplList.push({sort:3,name: 'asphalt', title: '绿色', img: contextPath+'/img/themes/asphalt.png'});	</script> 
    <link href="/joby/org/monkey/frameTplGreenyellow/assets/stylesheets/themes.min.css" rel="stylesheet" /> 
    <script>
	tinyTplList.push({sort:6,name: 'fresh',  title: '绿黄', img: contextPath+'/img/themes/green.png' });	</script> 
    <link href="/joby/org/monkey/trumbowyg/css/trumbowyg.min.css" rel="stylesheet" /> 
    <script src="/joby/org/monkey/trumbowyg/js/trumbowyg.min.js"></script> 
    <script src="/joby/org/monkey/trumbowyg/js/trumbowyg.base64.min.js"></script> 
    <script src="/joby/org/monkey/trumbowyg/js/trumbowyg.colors.min.js"></script> 
    <script src="/joby/org/monkey/trumbowyg/js/trumbowyg.upload.js"></script> 
    <script src="/joby/org/monkey/trumbowyg/js/trumbowyg.editlink.min.js"></script> 
    <script src="/joby/org/monkey/trumbowyg/js/zh_cn.js"></script> 
    <link href="/joby/org/monkey/syntaxhighlighter/styles/shCore.css" rel="stylesheet" /> 
    <script src="/joby/org/monkey/syntaxhighlighter/scripts/shCore.js"></script> 
    <script src="/joby/org/monkey/syntaxhighlighter/scripts/shBrushCss.js"></script> 
    <script src="/joby/org/monkey/syntaxhighlighter/scripts/shBrushJava.js"></script> 
    <script src="/joby/org/monkey/syntaxhighlighter/scripts/shBrushJScript.js"></script> 
    <script src="/joby/org/monkey/syntaxhighlighter/scripts/shBrushXml.js"></script> 
    <script src="/joby/org/monkey/syntaxhighlighter/scripts/shBrushTiny.js"></script> 
    <script>
	$(document).ready(function(){
                SyntaxHighlighter.highlight();
            });	</script> 
    <link href="/joby/org/monkey/iconTab/css/iconTab.css" rel="stylesheet" /> 
    <link href="/joby/org/monkey/burndownChart/css/burndownChart.css" rel="stylesheet" /> 
    <script src="/joby/org/monkey/burndownChart/js/burndownChart.js"></script> 
    <link href="/joby/org/monkey/navigation/css/navigation.css" rel="stylesheet" /> 
    <script src="/joby/org/monkey/navigation/js/pagenav.cn.js"></script> 
    <style>
            @media (min-width:768px) {
                #main-navbar .navbar-form,#main-navbar .navbar-nav {
					width:600px;
                    margin-right: calc(100%-100vw);
                }

            }
			</style> 
  </head> 
  <body class=" main-menu-animated"> 
    <script>var init = [];</script> 
    <script src="/joby/js/setting.js"></script> 
    <div id="main-wrapper"> 
      <div id="main-navbar" class="navbar navbar-inverse" role="navigation"> 
        <!-- Main menu toggle --> 
        <button type="button" id="main-menu-toggle"><i class="navbar-icon fa fa-bars icon"></i><span class="hide-menu-text"></span></button> 
        <div class="navbar-inner"> 
          <!-- navbar-header start--> 
          <div class="navbar-header"> 
            <!-- Logo --> 
            <a href="index.html" class="navbar-brand"> 
              <div>
                <img title="Tinyframework" src="/joby/img/main-navbar-logo.png" />
              </div> 
              <!--TinyAdmin--> </a> 
            <!-- navbar-toggle start --> 
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#main-navbar-collapse"><i class="navbar-icon fa fa-bars"></i></button> 
            <!-- navbar-toggle end --> 
          </div> 
          <div id="main-navbar-collapse" class="collapse navbar-collapse main-navbar-collapse"> 
            <div> 
              <ul class="nav navbar-nav"> 
                <li class="tttt"> <a href="/joby/ajax.html">切换到AJAX</a> </li> 
                <li class="dropdown"> <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">下拉菜单</a> 
                  <ul class="dropdown-menu"> 
                    <li> <a href="#">第一项</a> </li> 
                    <li> <a href="#">第二项</a> </li> 
                    <li class="divider"></li> 
                    <li> <a href="#">第三项</a> </li> 
                  </ul> </li> 
              </ul> 
              <div class="right clearfix"> 
                <ul class="nav navbar-nav pull-right right-navbar-nav"> 
                  <li class="nav-icon-btn nav-icon-btn-danger dropdown"> <a href="javascript:void(0);notifications" class="dropdown-toggle" data-toggle="dropdown"> <span class="label">5</span> <i class="nav-icon fa fa-bullhorn"></i> <span class="small-screen-text">通知</span> </a> 
                    <!-- NOTIFICATIONS --> 
                    <!-- Javascript --> <script>
									init.push(function () {
										$('#main-navbar-notifications').slimScroll({ height: 250});
									});
								</script> 
                    <!-- / Javascript --> 
                    <div class="dropdown-menu widget-notifications no-padding" style="width: 300px"> 
                      <div class="notifications-list" id="main-navbar-notifications"> 
                        <div class="notification"> 
                          <div class="notification-title text-danger">
                            系统
                          </div> 
                          <div class="notification-description"> 
                            <strong>500错误</strong>: 语法错误在索引&times;&times;行 
                            <strong>461</strong>. 
                          </div> 
                          <div class="notification-ago">
                            12小时前
                          </div> 
                          <div class="notification-icon fa fa-hdd-o bg-danger"></div> 
                        </div> 
                        <div class="notification"> 
                          <div class="notification-title text-info">
                            仓库
                          </div> 
                          <div class="notification-description">
                             你有 
                            <strong>9</strong> 新订单。 
                          </div> 
                          <div class="notification-ago">
                            12小时前
                          </div> 
                          <div class="notification-icon fa fa-truck bg-info"></div> 
                        </div> 
                        <div class="notification"> 
                          <div class="notification-title text-default">
                            进程
                          </div> 
                          <div class="notification-description">
                             工作 
                            <strong>&quot;清理&quot;</strong> 完成。 
                          </div> 
                          <div class="notification-ago">
                            12小时前
                          </div> 
                          <div class="notification-icon fa fa-clock-o bg-default"></div> 
                        </div> 
                        <div class="notification"> 
                          <div class="notification-title text-success">
                            体系
                          </div> 
                          <div class="notification-description">
                             服务器 
                            <strong>内存已满。</strong>. 
                          </div> 
                          <div class="notification-ago">
                            11小时前
                          </div> 
                          <div class="notification-icon fa fa-hdd-o bg-success"></div> 
                        </div> 
                        <div class="notification"> 
                          <div class="notification-title text-warning">
                            系统
                          </div> 
                          <div class="notification-description">
                             服务器 
                            <strong>内存已满。</strong>. 
                          </div> 
                          <div class="notification-ago">
                            10小时前
                          </div> 
                          <div class="notification-icon fa fa-hdd-o bg-warning"></div> 
                        </div> 
                      </div> 
                      <!-- / .notifications-list --> 
                      <a href="javascript:void(0);" class="notifications-link">更多的通知</a> 
                    </div> 
                    <!-- / .dropdown-menu --> </li> 
                  <li class="nav-icon-btn nav-icon-btn-success dropdown"> <a href="javascript:void(0);notifications" class="dropdown-toggle" data-toggle="dropdown"> <span class="label">12</span> <i class="nav-icon fa fa-envelope"></i> <span class="small-screen-text">所得的消息</span> </a> 
                    <!-- NOTIFICATIONS --> 
                    <!-- Javascript --> <script>
									init.push(function () {
										$('#main-navbar-notifications').slimScroll({ height: 250});
									});
								</script> 
                    <!-- / Javascript --> 
                    <div class="dropdown-menu widget-notifications no-padding" style="width: 300px"> 
                      <div class="notifications-list" id="main-navbar-notifications"> 
                        <div class="message"> 
                          <img src="/joby/img/portraits/2.jpg" alt="" class="message-avatar" /> 
                          <a href="javascript:void(0);" class="message-subject"> 有一位新成员加入Tiny框架... </a> 
                          <div class="message-description">
                             来自 
                            <a href="#">xxx</a> &nbsp;&nbsp;&nbsp;&nbsp; 2小时前 
                          </div> 
                        </div> 
                        <!-- / .message --> 
                        <div class="message"> 
                          <img src="/joby/img/portraits/3.jpg" alt="" class="message-avatar" /> 
                          <a href="javascript:void(0);" class="message-subject"> 有一位Tiny粉丝评论了博文... </a> 
                          <div class="message-description">
                             来自 
                            <a href="#">xxx</a> &nbsp;&nbsp;&nbsp;&nbsp; 2小时前 
                          </div> 
                        </div> 
                        <!-- / .message --> 
                        <div class="message"> 
                          <img src="/joby/img/portraits/4.jpg" alt="" class="message-avatar" /> 
                          <a href="javascript:void(0);" class="message-subject"> myeclipse安装tiny报错，请教各位高手。 </a> 
                          <div class="message-description">
                             来自 
                            <a href="#">xxx</a> &nbsp;&nbsp;&nbsp;&nbsp; 2小时前 
                          </div> 
                        </div> 
                        <!-- / .message --> 
                        <div class="message"> 
                          <img src="/joby/img/portraits/5.jpg" alt="" class="message-avatar" /> 
                          <a href="javascript:void(0);" class="message-subject"> page中获取session的值为什么是旧的... </a> 
                          <div class="message-description">
                             来自 
                            <a href="#">xxx</a> &nbsp;&nbsp;&nbsp;&nbsp; 2小时前 
                          </div> 
                        </div> 
                        <!-- / .message --> 
                      </div> 
                      <!-- / .notifications-list --> 
                      <a href="javascript:void(0);" class="notifications-link">更多的信息</a> 
                    </div> 
                    <!-- / .dropdown-menu --> </li> 
                  <li class="fullscreen"> <a href="javascript:void(0);" onclick="launchFullScreen(document.documentElement);" title="全屏"><i class="fa fa-fullscreen"></i></a> </li> 
                  <li> 
                    <form action="/sdpm-web/a/quality/bug/bugInfo?no=" method="get" id="msb-box"> 
                      <div class="input-groups " style="width:269px;padding-top:9px"> 
                        <div class="input-group-btns"> 
                          <button type="button" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"> <span id="msb-currentName">Bug</span> <span class="carets"></span> </button> 
                          <ul class="dropdown-menus msb-item-list" style="margin-top:-1px;width: 212px;"> 
                            <li class="active"><a href="/sdpm-web/a/quality/bug/bugInfo?no=" data-value="" data-type="form">Bug</a></li> 
                            <li><a href="/sdpm-web/a/product/storySpec/find/productDemandDetail?no=" data-value="" data-type="form">需求</a></li> 
                            <li><a href="/sdpm-web/a/project/task/findTask?no=" data-value="" data-type="form">任务</a></li> 
                            <li><a href="/sdpm-web/a/quality/testCase/case/viewInfo?no=" data-value="" data-type="form">用例</a></li> 
                            <li><a href="/sdpm-web/a/project/view?projectId=" data-value="" data-type="form">项目</a></li> 
                            <li><a href="/sdpm-web/a/product/find/overview?productId=" data-value="" data-type="form">产品</a></li> 
                            <li><a href="/sdpm-web/a/quality/version/versionInfo?no=" data-value="" data-type="form">版本</a></li> 
                            <li><a href="/sdpm-web/a/product/release/forword/reRelateStory?no=" data-value="" data-type="form">发布</a></li> 
                            <li><a href="/sdpm-web/a/product/plan/forword/reRelateStory?no=" data-value="" data-type="form">产品计划</a></li> 
                            <li><a href="/sdpm-web/a/document/doc/view?docid=" data-value="" data-type="form">文档</a></li> 
                          </ul> 
                        </div> 
                        <input type="text" name="key" id="msb-box-input" value="" class="form-controls " placeholder="请输入ID" datatype="n" nullmsg="请输入ID" /> 
                        <div id="objectSwitcher" class="input-group-btns "> 
                          <button class="searchBtn"><i class="fa fa-search"></i></button> 
                        </div> 
                      </div> 
                    </form> <script type="text/javascript">
				    $(function(){
				        $("#msb-box .msb-item-list a").each(function(){
				            var $this = $(this);
				            $this.click(function() {
				        if($this.attr("data-type")=="form"){
				            $("#msb-box li.active").removeClass("active");
				            $this.closest("li").addClass("active");
				            $("#msb-box").attr("action",$this.attr("href"));
				            $("#msb-currentName").text($this.text());
				            $("#msb-box .dropdown-toggle").dropdown('toggle');
				            return false;
				            }
				            });
				            if($this.text()=="Bug"){
				                    $this.closest("li").addClass("active");
				                $("#msb-box").attr("action",$this.attr("href"));
				            }
				        });
				        $("#msb-box").Validform({
				            beforeSubmit:function(curform){
				                window.location.href=$(curform).attr("action")+$("#msb-box-input").val();
				                return false;
				            }
				        })
				    });
				</script> </li> 
                  <li class="dropdown"> <a href="javascript:void(0);" class="dropdown-toggle user-menu" data-toggle="dropdown"> <img src="/joby/img/portraits/1.jpg" alt="" /> <span>密缘之友</span> </a> 
                    <ul class="dropdown-menu"> 
                      <li><a href="javascript:void(0);"><span class="label label-warning pull-right">新的</span>资料文件</a></li> 
                      <li><a href="javascript:void(0);"><span class="badge badge-primary pull-right">新的</span>个人中心</a></li> 
                      <li><a href="javascript:void(0);"><i class="dropdown-icon fa fa-cog"></i>&nbsp;&nbsp;设置</a></li> 
                      <li class="divider"></li> 
                      <li><a href="javascript:void(0);"><i class="dropdown-icon fa fa-power-off"></i>&nbsp;&nbsp;退出</a></li> 
                    </ul> </li> 
                </ul> 
              </div> 
            </div> 
          </div> 
          <!-- main-navbar-collapse end --> 
        </div> 
        <!-- navbar-inner end --> 
      </div> 
      <!-- main-navbar end --> 
      <div id="main-menu" role="navigation"> 
        <div id="main-menu-inner"> 
          <div class="menu-content top" id="menu-content-demo"> 
            <div> 
              <div class="text-bg">
                <span class="text-slim">欢迎您,</span> 
                <span class="text-semibold">Liyl</span>
              </div> 
              <img src="/joby/img/portraits/1.jpg" alt="" class="" /> 
              <div class="btn-group"> 
                <a href="javascript:void(0);" class="btn btn-xs btn-primary btn-outline dark"><i class="fa fa-envelope"></i></a> 
                <a href="javascript:void(0);" class="btn btn-xs btn-primary btn-outline dark"><i class="fa fa-user"></i></a> 
                <a href="javascript:void(0);" class="btn btn-xs btn-primary btn-outline dark"><i class="fa fa-cog"></i></a> 
                <a href="javascript:void(0);" class="btn btn-xs btn-danger btn-outline dark"><i class="fa fa-power-off"></i></a> 
              </div> 
            </div> 
          </div> 
          <ul class="navigation"> 
            <li> <a href="/joby/page/index.html" class="navitem" data-treeid="0"><i class="menu-icon fa fa-home"></i><span class="mm-text">首页</span> </a> </li>
            <li class="mm-dropdown open"> <a href="javascript:void(0);" data-treeid="12"><i class="menu-icon fa fa-book"></i><span class="mm-text">博客</span> </a>
              <ul>
                <li class="active"> <a href="/joby/page/addBlog.html" class="navitem"  data-treeid="12.1"><i class="menu-icon fa fa-edit"></i><span class="mm-text">新增博客</span> </a> </li>
                <li> <a href="/joby/page/listBlog.html" class="navitem" data-treeid="12.2"><i class="menu-icon fa fa-list-ul"></i><span class="mm-text">管理博客</span> </a> </li>
              </ul>
            </li>
            <li> <a href="/joby/page/overview.html" class="navitem" title="概述" data-treeid="1"><i class="menu-icon fa fa-dashboard"></i><span class="mm-text">概述</span> </a> </li>
            <li class="mm-dropdown class java.util.HashMap"> <a href="javascript:void(0);" data-treeid="2"><i class="menu-icon fa fa-th"></i><span class="mm-text">布局</span> </a>
              <ul> 
                <li> <a href="/joby/page/gridSystem.html" class="navitem" title="栅格系统" data-treeid="2.1"><span class="mm-text">栅格系统</span> </a> </li> 
                <li> <a href="/joby/page/tabShow.html" class="navitem" title="Tabs展现" data-treeid="2.2"><span class="mm-text">Tabs展现</span> </a> </li> 
                <li> <a href="/joby/page/togglebox.html" class="navitem" title="ToggleBox" data-treeid="2.3"><span class="mm-text">ToggleBox</span> </a> </li> 
              </ul> </li> 
            <li class="mm-dropdown class java.util.HashMap"> <a href="javascript:void(0);" data-treeid="3"><i class="menu-icon fa fa-desktop"></i><span class="mm-text">基础</span> </a> 
              <ul> 
                <li> <a href="/joby/page/typography.html" class="navitem" title="排版" data-treeid="3.1"><span class="mm-text">排版</span> </a> </li> 
                <li> <a href="/joby/page/icon.html" class="navitem" title="图标" data-treeid="3.3"><span class="mm-text">图标</span> </a> </li> 
                <li> <a href="/joby/page/button.html" class="navitem" title="按钮" data-treeid="3.4"><span class="mm-text">按钮</span> </a> </li> 
                <li> <a href="/joby/page/buttonGroups.html" class="navitem" title="按钮组" data-treeid="3.5"><span class="mm-text">按钮组</span> </a> </li> 
                <li> <a href="/joby/page/tables.html" class="navitem" title="表格" data-treeid="3.6"><span class="mm-text">表格</span> </a> </li> 
              </ul> </li> 
            <li class="mm-dropdown class java.util.HashMap"> <a href="javascript:void(0);" data-treeid="4"><i class="menu-icon fa icon-wrench"></i><span class="mm-text">元素</span> </a> 
              <ul> 
                <li> <a href="/joby/page/labelBadge.html" class="navitem" title="便签与标号" data-treeid="4.1"><span class="mm-text">便签与标号</span> </a> </li> 
                <li> <a href="/joby/page/alert.html" class="navitem" title="警告" data-treeid="4.2"><span class="mm-text">警告</span> </a> </li> 
                <li> <a href="/joby/page/progress.html" class="navitem" title="进度条" data-treeid="4.3"><span class="mm-text">进度条</span> </a> </li> 
                <li> <a href="/joby/page/interfaceElements.html" class="navitem" title="界面元素" data-treeid="4.4"><span class="mm-text">界面元素</span> </a> </li> 
                <li> <a href="/joby/page/nav.html" class="navitem" title="导航" data-treeid="4.5"><span class="mm-text">导航</span> </a> </li> 
              </ul> </li> 
            <li class="mm-dropdown class java.util.HashMap"> <a href="javascript:void(0);" data-treeid="5"><i class="menu-icon fa fa-tasks"></i><span class="mm-text">表单</span> </a> 
              <ul> 
                <li> <a href="/joby/page/forms.html" class="navitem" title="表单列表" data-treeid="5.1"><span class="mm-text">表单列表</span> </a> </li> 
                <li> <a href="/joby/page/tinyForm.html" class="navitem" title="表单实例" data-treeid="5.2"><span class="mm-text">表单实例</span> </a> </li> 
                <li> <a href="/joby/page/editor.html" class="navitem" title="编辑器" data-treeid="5.3"><span class="mm-text">编辑器</span> </a> </li> 
                <li> <a href="/joby/page/bootstrapDate.html" class="navitem" title="日期控件" data-treeid="5.4"><span class="mm-text">日期控件</span> </a> </li> 
                <li> <a href="/joby/page/dropDown.html" class="navitem" title="下拉菜单" data-treeid="5.5"><span class="mm-text">下拉菜单</span> </a> </li> 
                <li> <a href="/joby/page/search.html" class="navitem" title="搜索" data-treeid="5.6"><span class="mm-text">搜索</span> </a> </li> 
                <li> <a href="/joby/page/webupload.html" class="navitem" title="多文件上传" data-treeid="5.7"><span class="mm-text">多文件上传</span> </a> </li> 
                <li> <a href="/joby/page/authorlist.html" class="navitem" title="权限移动" data-treeid="5.8"><span class="mm-text">权限移动</span> </a> </li> 
              </ul> </li> 
            <li class="mm-dropdown class java.util.HashMap"> <a href="javascript:void(0);" data-treeid="6"><i class="menu-icon fa icon-picture"></i><span class="mm-text">图库</span> </a> 
              <ul> 
                <li> <a href="/joby/page/picture.html" class="navitem" title="图片" data-treeid="6.1"><span class="mm-text">图片</span> </a> </li> 
                <li> <a href="/joby/page/thumbnails.html" class="navitem" title="缩略图" data-treeid="6.2"><span class="mm-text">缩略图</span> </a> </li> 
                <li> <a href="/joby/page/media.html" class="navitem" title="媒体插入" data-treeid="6.3"><span class="mm-text">媒体插入</span> </a> </li> 
                <li> <a href="/joby/page/ad.html" class="navitem" title="广告" data-treeid="6.4"><span class="mm-text">广告</span> </a> </li> 
                <li> <a href="/joby/page/uedTips.html" class="navitem" title="UED提示" data-treeid="6.5"><span class="mm-text">UED提示</span> </a> </li> 
              </ul> </li> 
            <li class="mm-dropdown class java.util.HashMap"> <a href="javascript:void(0);" data-treeid="7"><i class="menu-icon fa icon-random"></i><span class="mm-text">交互</span> </a> 
              <ul> 
                <li> <a href="/joby/page/animation.html" class="navitem" title="动画" data-treeid="7.1"><span class="mm-text">动画</span> </a> </li> 
                <li> <a href="/joby/page/Unslider.html" class="navitem" title="幻灯片" data-treeid="7.2"><span class="mm-text">幻灯片</span> </a> </li> 
                <li> <a href="/joby/page/tab.html" class="navitem" title="选项卡" data-treeid="7.3"><span class="mm-text">选项卡</span> </a> </li> 
                <li> <a href="/joby/page/modal.html" class="navitem" title="对话框 弹出层" data-treeid="7.4"><span class="mm-text">对话框 弹出层</span> </a> </li> 
                <li> <a href="/joby/page/rolling.html" class="navitem" title="滚动" data-treeid="7.5"><span class="mm-text">滚动</span> </a> </li> 
                <li> <a href="/joby/page/tags.html" class="navitem" title="标签" data-treeid="7.6"><span class="mm-text">标签</span> </a> </li> 
                <li> <a href="/joby/page/fold.html" class="navitem" title="折叠" data-treeid="7.7"><span class="mm-text">折叠</span> </a> </li> 
                <li> <a href="/joby/page/maskBar.html" class="navitem" title="遮罩条" data-treeid="7.8"><span class="mm-text">遮罩条</span> </a> </li> 
              </ul> </li> 
            <li class="mm-dropdown class java.util.HashMap"> <a href="javascript:void(0);" data-treeid="8"><i class="menu-icon fa icon-legal"></i><span class="mm-text">部件</span> </a> 
              <ul> 
                <li> <a href="/joby/page/kefu.html" class="navitem" title="客服" data-treeid="8.1"><span class="mm-text">客服</span> </a> </li> 
                <li> <a href="/joby/page/toTop.html" class="navitem" title="返回顶部" data-treeid="8.2"><span class="mm-text">返回顶部</span> </a> </li> 
                <li> <a href="/joby/page/share.html" class="navitem" title="分享" data-treeid="8.3"><span class="mm-text">分享</span> </a> </li> 
                <li> <a href="/joby/page/example.html" class="navitem" title="案例" data-treeid="8.4"><span class="mm-text">案例</span> </a> </li> 
                <li> <a href="/joby/page/Smart-treeview.html" class="navitem" title="树形视图" data-treeid="8.5"><span class="mm-text">树形视图</span> </a> </li> 
                <li class="mm-dropdown class java.util.HashMap"> <a href="javascript:void(0);" data-treeid="8.6"><span class="mm-text">图表</span> </a> 
                  <ul> 
                    <li> <a href="/joby/page/charts.html" class="navitem" title="图表展示" data-treeid="8.6.1"><span class="mm-text">图表展示</span> </a> </li> 
                    <li> <a href="/joby/page/burndownChart.html" class="navitem" title="燃尽图表" data-treeid="8.6.3"><span class="mm-text">燃尽图表</span> </a> </li> 
                    <li> <a href="/joby/page/highCharts.html" class="navitem" title="highCharts图表" data-treeid="8.6.4"><span class="mm-text">highCharts图表</span> </a> </li> 
                  </ul> </li> 
                <li> <a href="/joby/page/calendar.html" class="navitem" title="日历" data-treeid="8.7"><span class="mm-text">日历</span> </a> </li> 
                <li> <a href="/joby/page/workCalendar.html" class="navitem" title="背景日历" data-treeid="8.8"><span class="mm-text">背景日历</span> </a> </li> 
              </ul> </li> 
            <li class="mm-dropdown class java.util.HashMap"> <a href="javascript:void(0);" data-treeid="9"><i class="menu-icon fa icon-th-list"></i><span class="mm-text">实例</span> </a> 
              <ul> 
                <li> <a href="/joby/page/comment.html" class="navitem" title="评论列表" data-treeid="9.1"><span class="mm-text">评论列表</span> </a> </li> 
                <li> <a href="/joby/page/userComment.html" class="navitem" title="用户评论" data-treeid="9.2"><span class="mm-text">用户评论</span> </a> </li> 
                <li> <a href="/joby/page/searchPage.html" class="navitem" title="搜索页" data-treeid="9.3"><span class="mm-text">搜索页</span> </a> </li> 
                <li> <a href="/joby/page/gantt.html" class="navitem" title="Gantt图" data-treeid="9.4"><span class="mm-text">Gantt图</span> </a> </li> 
                <li> <a href="/joby/page/tourbus.html" class="navitem" title="操作向导" data-treeid="9.5"><span class="mm-text">操作向导</span> </a> </li> 
                <li class="mm-dropdown class java.util.HashMap"> <a href="javascript:void(0);" data-treeid="9.6"><span class="mm-text">邮件模板</span> </a> 
                  <ul> 
                    <li> <a href="/joby/page/emailTemplate.html" class="navitem" title="邮件列表" data-treeid="9.6.1"><span class="mm-text">邮件列表</span> </a> </li> 
                    <li> <a href="/joby/page/mailDetail.html" class="navitem" title="邮件详情" data-treeid="9.6.2"><span class="mm-text">邮件详情</span> </a> </li> 
                    <li> <a href="/joby/page/mailCompose.html" class="navitem" title="编写邮件" data-treeid="9.6.3"><span class="mm-text">编写邮件</span> </a> </li> 
                  </ul> </li> 
                <li> <a href="/joby/page/timeline.html" class="navitem" title="时间轴" data-treeid="9.7"><span class="mm-text">时间轴</span> </a> </li> 
                <li class="mm-dropdown class java.util.HashMap"> <a href="javascript:void(0);" data-treeid="9.8"><span class="mm-text">论坛</span> </a> 
                  <ul> 
                    <li> <a href="/joby/page/forum.html" class="navitem" title="论坛布局" data-treeid="9.8.1"><span class="mm-text">论坛布局</span> </a> </li> 
                    <li> <a href="/joby/page/forum-topic.html" class="navitem" title="论坛列表" data-treeid="9.8.2"><span class="mm-text">论坛列表</span> </a> </li> 
                    <li> <a href="/joby/page/forum-post.html" class="navitem" title="论坛详情" data-treeid="9.8.3"><span class="mm-text">论坛详情</span> </a> </li> 
                  </ul> </li> 
                <li> <a href="/joby/page/viewsControl.html" class="navitem" title="视图控制" data-treeid="9.9"><span class="mm-text">视图控制</span> </a> </li> 
                <li> <a href="/joby/page/iconTab.html" class="navitem" title="图标控制" data-treeid="9.10"><span class="mm-text">图标控制</span> </a> </li> 
              </ul> </li> 
            <li class="mm-dropdown class java.util.HashMap"> <a href="javascript:void(0);" data-treeid="10"><i class="menu-icon fa fa-files-o"></i><span class="mm-text">其它</span> </a> 
              <ul> 
                <li> <a href="/joby/page/error404.html" class="navitem" title="错误404" data-treeid="10.1"><span class="mm-text">错误404</span> </a> </li> 
                <li> <a href="/joby/page/error500.html" class="navitem" title="错误500" data-treeid="10.2"><span class="mm-text">错误500</span> </a> </li> 
                <li> <a href="/joby/page/loginRegistered.html" class="navitem" title="登录注册" data-treeid="10.3"><span class="mm-text">登录注册</span> </a> </li> 
                <li> <a href="/joby/page/loadscrollingpic.html" class="navitem" title="屏幕内图片加载" data-treeid="10.4"><span class="mm-text">屏幕内图片加载</span> </a> </li> 
              </ul> </li> 
            <li class="mm-dropdown class java.util.HashMap"> <a href="javascript:void(0);" data-treeid="11"><i class="menu-icon fa fa-sitemap"></i><span class="mm-text">多级导航</span> <span class="label label-warning">6</span> </a> 
              <ul> 
                <li> <a href="/joby/page/first.html" class="navitem" title="一级菜单" data-treeid="11.1"><span class="mm-text">一级菜单</span> </a> </li> 
                <li class="mm-dropdown class java.util.HashMap"> <a href="javascript:void(0);" data-treeid="11.2"><span class="mm-text">一级菜单</span> <span class="label label-warning">5</span> </a> 
                  <ul> 
                    <li> <a href="/joby/page/second.html" class="navitem" title="二级菜单" data-treeid="11.2.1"><span class="mm-text">二级菜单</span> </a> </li> 
                    <li class="mm-dropdown class java.util.HashMap"> <a href="javascript:void(0);" data-treeid="11.2.2"><span class="mm-text">二级菜单</span> <span class="label label-warning">5</span> </a> 
                      <ul> 
                        <li class="mm-dropdown class java.util.HashMap"> <a href="javascript:void(0);" data-treeid="11.2.2.1"><span class="mm-text">三级菜单</span> <span class="label label-warning">5</span> </a> 
                          <ul> 
                            <li> <a href="/joby/page/fourth.html" class="navitem" title="四级菜单" data-treeid="11.2.2.1.1"><span class="mm-text">四级菜单</span> </a> </li> 
                          </ul> </li> 
                        <li> <a href="/joby/page/third.html" class="navitem" title="三级菜单" data-treeid="11.2.2.2"><span class="mm-text">三级菜单</span> </a> </li> 
                      </ul> </li> 
                    <li> <a href="second2.html" class="navitem" title="二级菜单2" data-treeid="11.2.3"><span class="mm-text">二级菜单2</span> </a> </li> 
                  </ul> </li> 
              </ul> </li> 
          </ul> 
          <!-- navigation end --> 
          <div class="menu-content"> 
            <a href="javascript:void(0);" class="btn btn-primary btn-block btn-outline dark">创建页面</a> 
          </div> 
        </div> 
      </div> 
      <div id="main-menu-bg"></div> 
      <div class="content-wrapper-bg"></div> 
      <div id="content-wrapper"> 
        <div class="postion-nav"> 
          <ul class="breadcrumb"> 
            <li class="text-light-gray">所在位置： </li> 
            <li><a href="/joby/page">首页</a></li>
            <li>博客</li>
            <li>新增博客</li>
          </ul>
        </div> 
        <!-- 主体 start -->
        <div class="row">
          <div id="tinypagecontent" style="min-height:490px">
            <h2> 写博客 </h2>
            <div class="codeView bs-docs-blog">
              <form id="blogform" class="form" action="<c:url value ='/manage/saveBlog.json' />" method="post">
                <div class="row cl ">
                  <label class="form-label col-2"> 标 题： </label>
                  <div class="formControls col-8">
                    <input type="text" name="title" value="" class="input-text radius" id="title" placeholder="请输入博客标题" datatype="*1-50" nullmsg="标题不能为空"/>
                  </div>
                  <div class="col-2">
                  </div>
                </div>
                <div class="row cl ">
                  <label class="form-label col-2"> 摘 要： </label>
                  <div class="formControls col-8 ">
                    <textarea class="form-control" rows="3" id="summary" name="summary" placeholder="说点什么...最少输入10个字符" datatype="*10-200" nullmsg="摘要不能为空！"></textarea>
                  </div>
                  <div class="col-2">
                  </div>
                </div>
                <div class="row cl">
                  <label class="form-label col-2"> 标 签： </label>
                  <div class="formcontrols col-8">
                    <div class="hui-tags radius">
                      <div class="hui-tags-editor cl ">
                        <i class="icon-tags "> </i>
                        <span class="hui-tags-token "> JavaScript</span>
                        <span class="hui-tags-token "> CSS3 </span>
                        <span class="hui-tags-token "> HTML5 </span>
                        <div class="hui-tags-iptwrap ">
                          <input type="text" class="hui-tags-input" maxlength="20" />
                          <input id="tags" name="tag" type="hidden" class="hui-tags-input" />
                          <lable class="hui-tags-lable ">
                            添加相关标签，用空格或回车分隔
                          </lable>
                        </div>
                      </div>
                      <div class="hui-tags-list ">
                        <div class="hui-notag " style="display:none">
                          暂无常用标签
                        </div>
                        <div class="hui-tags-has ">
                          <span> MySql </span>
                          <span> Spring </span>
                          <span> Java </span>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="col-2"></div>
                </div>
                <div class="row cl ">
                  <label class="form-label col-2"> 分 类： </label>
                  <div class="formControls col-8 radius">
                    <input type="hidden" id="category" name="categoryId" value="2" fixdataval="1" dataid="sid" placeholder="查询数据" datatext="stext" datatype="*" userId="1"/>
                    <script type="text/javascript">
                      $(function(){
                        var _inputVal=$("#category");
                        var multiple=_inputVal.attr("multiple");
                        multiple=multiple?true:false;
                        _inputVal.select2({
                          multiple:multiple,
                          ajax: {
                            url: "<c:url value='/manage/getCategoryList.json'/>",
                            dataType: 'json',
                            quietMillis: 250,
                            data: function (term, page) {
                              var data={userId:_inputVal.attr("userId")};
                              return data;
                            },
                            results: function (reData, page) {
                              var data=[];
                              for(var i= 0,l=reData.blogCategoryList.length;i<l;i++){
                                data.push({id:reData.blogCategoryList[i].id,text:reData.blogCategoryList[i].categoryName})
                              }
                              return { results: data};
                            },
                            cache: true
                          },
                          initSelection: function (element, callback) {   // 初始化时设置默认值
                            var v=element.val();
                            $.ajax({
                              url:"<c:url value='/manage/getCategoryList.json'/>",
                              type:"get",
                              data:{userId:_inputVal.attr("userId")},
                              dataType:"json",
                              success:function(reData){
                                var data=[];
                                for(var i= 0,l=reData.blogCategoryList.length;i<l;i++){
                                  data.push({id:reData.blogCategoryList[i].id,text:reData.blogCategoryList[i].categoryName})
                                }
                                if(!data) return false;
                                if(multiple){
                                  callback(data);
                                }else{
                                  callback(data[0]);
                                }
                              }
                            })
                          },
                          formatResult: function(data){return "<div>"+data.text+"</div>";},
                          formatSelection: function(data){
                            return data.text;
                          },
                          formatInputTooShort: function(){return "请输入关键字"},
                        });
                        $("#category").prev("div").find("abbr.select2-search-choice-close").show();
                        _inputVal.on("select2-blur",function(){
                          $(this).trigger("blur");
                        }).on("change",function(){
                          if($(this).val()){
                            $(this).prev("div").find("abbr.select2-search-choice-close").show();
                            //$("#category-input-hide").remove();
                          }else{
                            $(this).prev("div").find("abbr.select2-search-choice-close").hide();
                            //$(this).after($("<input>").attr({"id":"category-input-hide","type":"hidden","name":$(this).attr("name")}).val(""));
                          }
                        }).on("disable",function(){
                          var disabled=$(this).attr("disabled");
                          if(disabled){
                            disabled=true;
                            $(this).removeAttr("disabled");
                          }else{
                            disabled=false;
                            $(this).attr("disabled","true");
                          }
                          $(this).select2("enable", disabled);
                        });
                      })
                    </script>
                    <div class="fixtools hide" id="category-fix">
                      <div class="fixselect2foot">
                        <a class="r" data-target="#myModal2" data-toggle="modal" data-width="600" modal-title="增加" href="/joby/page/form/4.6.pagelet"> 增加 </a>
                        <a href="/joby/page/">全部</a>
                      </div>
                    </div>
                    <script type="text/javascript">
                      $(function(){
                        var isinit=false;
                        $("#category").on("select2-open", function (e) {
                          var $sel=$(this);
                          if(!isinit){
                            $("#select2-drop").append($("#category-fix").html());
                            $("#select2-drop").on("click","a[data-toggle!=modal]",function(){
                              window.location.href=$(this).attr("href");
                            }).on("click",'[data-toggle="modal"]',function(e){
                              $("#select2-drop").hide();
                              var $this =	$(this),
                                      href = $this.attr('href'),
                                      height =$this.attr('data-height'),
                                      width =$this.attr('data-width'),
                                      modalTitle =$this.attr('modal-title'),
                                      modalUrl =$this.attr('modal-url'),
                                      modalData =$this.attr('modal-Data'),
                                      $target = $($this.attr('data-target') || (href && href.replace(/.*(?=^\s]+$)/, ''))),
                                      option = $target.data('modal') ? 'toggle' : $.extend({
                                        remote: !/#/.test(href) && href,
                                        height: height ? height : 0,
                                        maxHeight: $(window).height() * 0.8 - 100,
                                        modalTitle: modalTitle ? modalTitle : null,
                                        modalUrl: modalUrl ? modalUrl : null,
                                      },$target.data() , $this.data());
                              $target.drag({
                                handle: ".modal-header"
                              });
                              e.preventDefault();
                              $target.modal(option).one('hide',function() {
                                $this.focus();
                              });
                            });
                            isinit=true;
                          }
                        });
                      });
                    </script>
                  </div>
                  <div class="col-2">
                  </div>
                </div>
                <div class="row cl ">
                  <label class="form-label col-2"> 图 片： </label>
                <div class="formControls col-8 ">
                    <input type="hidden" class="form-control" value="" name="img" id="blogimg" placeholder="可点击图标进行上传" />
                    <span class="btn btn-primary upload-btn" id="uploadImg"><i class="iconfont">󰀠</i> 浏览文件 <input type="file" class="input-file" name="upfile" id="img" /></span>
                    <span id="showimg"></span>
                    <script type="text/javascript">
                      $(function(){
                        $("#uploadImg").on("change","#img",function(){
                          $.ajaxFileUpload({
                            url: '<c:url value='/manage/uploadImg.json'/>',
                            secureuri: false,
                            fileElementId: "img",
                            dataType:'json',
                            success: function (data, status) {
                              if(data.success){
                                $("#blogimg").val(data.url);
                                $("#showimg").html("<img src='"+"<c:url value="/"/>"+data.url+"' width='200'>");
                              }else{
                                var str=!data.info;
                                if(!str){str="参数有误";}
                                layer.msg(str);
                              }
                            }
                          });
                        });
                      });
                    </script>
                  </div>
                  <div class="col-2">
                  </div>
                </div>
                <div class="row cl ">
                  <label class="form-label col-2" id=""> 内 容： </label>
                  <div class="formControls col-8 ">
                    <script type="text/plain" id="contentxx2"></script>
                    <script type="text/javascript">
                      window.UMEDITOR_CONFIG.textarea='content';
                      UM.delEditor('contentxx2');
                      UM.getEditor('contentxx2',{
                        initialFrameHeight:"600",
                      });
                    </script>
                  </div>
                  <div class="col-2">
                  </div>
                </div>
                <div class="row cl ">
                  <div class="col-1 col-offset-5 form-inline">
                    <input type="submit" name="submitbtn" value=" 提 交 " class="btn radius btn-primary btn-large" />
                  </div>
                  <div class="col-2 form-inline">
                    <input id="reset" type="button" name="resetbtn" value=" 重 置 " class="btn radius btn-info btn-large" />
                  </div>
                </div>
              </form>
            </div>
          </div>
        </div>
        <div id="tinyfooter"> 
          <div class="tinyfooterrap"> 
            <span class="right"> <a class="record-num" target="_blank" href="#">京ICP备xxxxxxxx号-1</a> </span> Joby个人网站 &copy; 2015-2016
          </div> 
        </div> 
      </div> 
    </div> 
    <script type="text/javascript">
        init.push(function () {
            var menucount=$(".navigation:first>li").size();
            $("#topmenurap .navigation>li").css("width",100/menucount+"%");
            var menuList=[];
            $(".navigation:first a.navitem").each(function(){
                var href=$(this).attr("href");
                var treeid=$(this).attr("data-treeid");
                menuList.push({id:treeid,url:href});
            });
//                $.ajax({
//                    url:"/joby/action/savemenulist.pagelet",
//                    type:"post",
//                    data:{data:JSON.stringify(menuList)},
//                    success:function(data){
//                        if(window.location.pathname!=contextPath+"/page/")
//                            window.location.reload();
//                    }
//                })
        });
        $(function(){
          $("#blogform").Validform({
            tiptype:2,
            beforeCheck:function(curform){
              //在表单提交执行验证之前执行的函数，curform参数是当前表单对象。
              //这里明确return false的话将不会继续执行验证操作;
            },
            beforeSubmit:function(curform){
              var tags = "";
              var spans = $('span.hui-tags-token');
              $.each(spans, function(i,n){
                console.log(i);
                console.log($.trim($(n).text()));
                if(i != 0 && i != spans.length){
                  tags = tags + "," + $.trim($(n).text());
                }else{
                  tags = tags + $.trim($(n).text());
                }
              });
              $("#tags").val(tags);
              $(curform).ajaxSubmit({
                dataType:"json",
                success:function(data){
                  if(data.success){
                    layer.msg(data.info,2, 1);
                    $(curform).closest(".modal").trigger("close");
                  }else{
                    layer.msg(data.info);
                  }
                  try{
                    $(curform).closest(".modal").trigger("close");//当弹出框时触发弹出框关闭
                    //$(curform).closest(".modal").find(".modal-header .close").trigger("click");//弹出框关闭
                    $("table.tinytable").trigger("initnav"); ////可配合TINYTABLE 做刷新
                  }catch(e){console.log(e)}
                },
                error:function(){
                  layer.msg(data.info);
                }
              });
              return false;

              //在验证成功后，表单提交前执行的函数，curform参数是当前表单对象。
              //这里明确return false的话表单将不会提交;
            }

          });
          $("#reset").click(function(){
//            $("#title").val("");
//            $("#summary").val("");
//            $("#tags").val("");
//            $("#category").val("");
//            $("#blogimg").val("");
//            $("#showimg").children().remove();
//            $("#contentxx2").html("");
            window.location.reload();
          });
        });
    </script>   
  </body>
</html>