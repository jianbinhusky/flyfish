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
	
<!-- Add jQuery library -->
<script type="text/javascript" src="http://www.ostools.net/js/jquery/jquery-1.7.2.js"></script>
 
<!-- Add fancyBox -->
<link rel="stylesheet" href="http://www.ostools.net/uploads/jquery/dialog/fancybox/source/jquery.fancybox.css?v=2.0.6" type="text/css" media="screen" />
<link rel="stylesheet" href="http://www.ostools.net/uploads/jquery/dialog/fancybox/source/helpers/jquery.fancybox-thumbs.css?v=2.0.6" type="text/css" media="screen" />
<script type="text/javascript" src="http://www.ostools.net/uploads/jquery/dialog/fancybox/source/jquery.fancybox.pack.js?v=2.0.6"></script>
 
<!-- Optionally add helpers - button, thumbnail and/or media -->
<link rel="stylesheet" href="http://www.ostools.net/uploads/jquery/dialog/fancybox/source/helpers/jquery.fancybox-buttons.css?v=1.0.2" type="text/css" media="screen" />
<script type="text/javascript" src="http://www.ostools.net/uploads/jquery/dialog/fancybox/source/helpers/jquery.fancybox-buttons.js?v=1.0.2"></script>
<script type="text/javascript" src="http://www.ostools.net/uploads/jquery/dialog/fancybox/source/helpers/jquery.fancybox-media.js?v=1.0.0"></script>
<script type="text/javascript" src="http://www.ostools.net/uploads/jquery/dialog/fancybox/source/helpers/jquery.fancybox-thumbs.js?v=2.0.6"></script>		
<style>
    .section{padding:5px;}
    .title{font-size:16px;margin:10px;}
    .section img{height:160px;}
    body{font-size: 14px;font-family: Microsoft YaHei, 微软雅黑, Verdana, sans-serif, 宋体;line-height: 18px;}
</style>
<script type="text/javascript">
$(document).ready(function() {
    $(".fancybox-button").fancybox({
        prevEffect      : 'none',
        nextEffect      : 'none',
        closeBtn        : false,
        helpers     : {
            title   : { type : 'inside' },
            buttons : {}
        }
    });
});
</script>		
	</head>
	<body>
	<div class="section">
	    <div class="title">扩展功能</div>
	    <div class="title">Button Helper</div>
	    <a class="fancybox-button" rel="fancybox-button" href="http://farm6.staticflickr.com/5442/7059876047_2507e47bb4_b.jpg" title="... (Zippy *)">
	    	<img src="http://farm6.staticflickr.com/5442/7059876047_2507e47bb4_m.jpg" alt="" />
	    </a>
	    
	    <a class="fancybox-button" rel="fancybox-button" href="http://farm8.staticflickr.com/7171/6417719753_374653e28c_b.jpg" title="IHAMA Rocky beach II (HDR) (nextBlessing)">
	        <img src="http://farm8.staticflickr.com/7171/6417719753_374653e28c_m.jpg" alt="" />
	    </a>
	    <a class="fancybox-button" rel="fancybox-button" href="http://farm8.staticflickr.com/7029/6396010873_8298f7a218_b.jpg" title="Morning Sun (mjm383)">
	        <img src="http://farm8.staticflickr.com/7029/6396010873_8298f7a218_m.jpg" alt="" />
	    </a>
	    <a class="fancybox-button" rel="fancybox-button" href="http://farm7.staticflickr.com/6108/6370684145_ff592edaa9_b.jpg" title="Brasted Kent (Trevor Taylor Photography)">
	        <img src="http://farm7.staticflickr.com/6108/6370684145_ff592edaa9_m.jpg" alt="" />
	    </a>
	</div>
	</body>
</html>

