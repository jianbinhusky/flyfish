<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
  	<head>
	    <meta charset="utf-8">
		<meta name="keywords" content="" />
		<meta name="description" content="" />
		<meta name="Author" content="DEEJ" />    
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>WaterFlow|BeautyGirl</title>
		<link rel="shortcut icon" href="<c:url value="/static/images/ico.png" />"/>
		<link rel="bookmark" href="<c:url value="/static/images/ico.png " />"/> 
	    <link type="text/css" href="<c:url value="/static/css/style.css" /> " rel="stylesheet" />
	
		<script type="text/javascript" src="<c:url value='/static/scripts/jquery-1.8.2.min.js' />"></script>
		<script type="text/javascript" src="<c:url value='/static/scripts/jquery.masonry.min.js' />"></script>
		<script type="text/javascript" src="<c:url value='/static/scripts/jquery.infinitescroll.js' />"></script>
		<script type="text/javascript" src="<c:url value='/static/scripts/jquery.livequery.js' />"></script>
		
		<style type="text/css">
		*{margin:0;padding:0;list-style-type:none;}
		a,img{border:0;}
		body{background:#eee;font:12px/180% Arial, Helvetica, sans-serif, "新宋体";}
		
		.demo{width:490px;margin:30px auto;}
		.box{float:left;width:100px;height:100px;border:1px solid white;background:#EEE;margin:10px;position:relative;display:inline;}
		.box a{display:block;width:100px;height:100px;overflow:hidden;position:absolute;left:0;top:0;z-index:9;}
		.boxBor{
			position:absolute;left:0;top:0;display:none;border:1px solid white;z-index:4;
			background:#fff;
			background:-moz-linear-gradient(top,rgba(255,255,255,0.25),rgba(255,255,255,0.77));
			background:-webkit-linear-gradient(top,rgba(255,255,255,0.25),rgba(255,255,255,0.77));
			background:-o-linear-gradient(top,rgba(255,255,255,0.25),rgba(255,255,255,0.77));
			background:-ms-linear-gradient(top,rgba(255,255,255,0.25),rgba(255,255,255,0.77));
		}
		</style>		
		
	</head>
	<body>
		<div class="boxBor"></div>

		<div class="demo">
			<div class="box"><a href="http://www.17sucai.com/"></a><img width="100" height="100" src="<c:url value="/static/images/beauty_girl_1.jpg " />" alt="" /></div>
			<div class="box"><a href="http://www.17sucai.com/"></a><img width="100" height="100" src="<c:url value="/static/images/beauty_girl_2.jpg " />" alt="" /></div>
			<div class="box"><a href="http://www.17sucai.com/"></a><img width="100" height="100" src="<c:url value="/static/images/beauty_girl_3.jpg " />" alt="" /></div>
			<div class="box"><a href="http://www.17sucai.com/"></a><img width="100" height="100" src="<c:url value="/static/images/beauty_girl_4.jpg " />" alt="" /></div>
			<div class="box"><a href="http://www.17sucai.com/"></a><img width="100" height="100" src="<c:url value="/static/images/beauty_girl_5.jpg " />" alt="" /></div>
			<div class="box"><a href="http://www.17sucai.com/"></a><img width="100" height="100" src="<c:url value="/static/images/beauty_girl_6.jpg " />" alt="" /></div>
			<div class="box"><a href="http://www.17sucai.com/"></a><img width="100" height="100" src="<c:url value="/static/images/beauty_girl_7.jpg " />" alt="" /></div>
			<div class="box"><a href="http://www.17sucai.com/"></a><img width="100" height="100" src="<c:url value="/static/images/beauty_girl_8.jpg " />" alt="" /></div>
			<div class="box"><a href="http://www.17sucai.com/"></a><img width="100" height="100" src="<c:url value="/static/images/beauty_girl_9.jpg " />" alt="" /></div>
			<div class="box"><a href="http://www.17sucai.com/"></a><img width="100" height="100" src="<c:url value="/static/images/beauty_girl_10.jpg " />" alt="" /></div>
			<div class="box"><a href="http://www.17sucai.com/"></a><img width="100" height="100" src="<c:url value="/static/images/beauty_girl_11.jpg " />" alt="" /></div>
			<div class="box"><a href="http://www.17sucai.com/"></a><img width="100" height="100" src="<c:url value="/static/images/beauty_girl_12.jpg " />" alt="" /></div>
			<div style="clear:both;"></div>
		</div>

	
		<script type="text/javascript">
		$(function(){
			$('.box').bind('mouseover',function(){
			//定义一个隐藏方法鼠标移动到上面改变背景颜色的方法
				var oPosition=$(this).position();
				//定义参数
				var oThis=$(this);	
				//定义参数	
				$('.boxBor').queue('fnHide');	
				//定义方法显示或操作在匹配元素上执行	
				if($(".boxBor").attr('deta-switch')!=='true'){
				//定义改变图像的 width 属性方法
					$(".boxBor").attr('deta-switch','true');
					//定义改变图像的 width 属性方法
					$(".boxBor").css({
						width:'100%',
						height:$(window).height(),
						left:'0px',
						top:'0px',
						opacity:0,
						display:'block'
					})
					//通过jquery 来修改 css 修改的有长度 高度 距左和距上 透明度 和是否隐藏
				}
				$(".boxBor").stop(false,false).animate({
				//定义停止当前正在运行的动画方法
					opacity:0.8,
					//让透明度为0.8
					left:oPosition.left+10,
					//距左为oPosition参数的距左再加10
					top:oPosition.top+10,
					//距上oPosition参数的距左再加10
					width:oThis.width(),
					//长度oThis参数长度
					height:oThis.height()
					//长度oThis参数宽度
				},250)
				//全部完成时间0.25秒
			});
		})
		</script>  
	</body>
</html>

