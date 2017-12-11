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
 
<!-- Add mousewheel plugin (this is optional) -->
<script type="text/javascript" src="http://www.ostools.net/uploads/jquery/dialog/fancybox/lib/jquery.mousewheel-3.0.6.pack.js"></script>
 
<!-- Add fancyBox -->
<link rel="stylesheet" href="http://www.ostools.net/uploads/jquery/dialog/fancybox/source/jquery.fancybox.css?v=2.0.6" type="text/css" media="screen" />
<script type="text/javascript" src="http://www.ostools.net/uploads/jquery/dialog/fancybox/source/jquery.fancybox.pack.js?v=2.0.6"></script>
 
<!-- Optionally add helpers - button, thumbnail and/or media -->
<link rel="stylesheet" href="http://www.ostools.net/uploads/jquery/dialog/fancybox/source/helpers/jquery.fancybox-buttons.css?v=1.0.2" type="text/css" media="screen" />
<script type="text/javascript" src="http://www.ostools.net/uploads/jquery/dialog/fancybox/source/helpers/jquery.fancybox-buttons.js?v=1.0.2"></script>
<script type="text/javascript" src="http://www.ostools.net/uploads/jquery/dialog/fancybox/source/helpers/jquery.fancybox-media.js?v=1.0.0"></script>
 
<link rel="stylesheet" href="http://www.ostools.net/uploads/jquery/dialog/fancybox/source/helpers/jquery.fancybox-thumbs.css?v=2.0.6" type="text/css" media="screen" />
<script type="text/javascript" src="http://www.ostools.net/uploads/jquery/dialog/fancybox/source/helpers/jquery.fancybox-thumbs.js?v=2.0.6"></script>		
<style>
    .section{padding:5px;}
    .title{font-size:16px;margin:10px;}
    .section img{height:160px;}
    body{font-size: 14px;font-family: Microsoft YaHei, 微软雅黑, Verdana, sans-serif, 宋体;line-height: 18px;}
    ul.list {float: left;width: 200px;}
    .clear {clear: both;font-size: 1px;line-height: 0;}
</style>
<script type="text/javascript">
$(document).ready(function() {
    $("#single_1").fancybox({
          helpers: {
              title : {
                  type : 'float'
              }
          }
      });
 
    $("#single_2").fancybox({
        openEffect  : 'elastic',
        closeEffect : 'elastic',
 
        helpers : {
            title : {
                type : 'inside'
            }
        }
    });
 
    $("#single_3").fancybox({
        openEffect : 'none',
        closeEffect : 'none',
        helpers : {
            title : {
                type : 'outside'
            }
        }
    });
 
    $("#single_4").fancybox({
        helpers : {
            title : {
                type : 'over'
            }
        }
    });
 
    $(".fancybox").fancybox({
        openEffect  : 'none',
        closeEffect : 'none'
    });
     
    $(".various").fancybox({
        maxWidth    : 800,
        maxHeight   : 600,
        fitToView   : false,
        width       : '70%',
        height      : '70%',
        autoSize    : false,
        closeClick  : false,
        openEffect  : 'none',
        closeEffect : 'none'
    });
 
    $(".fancybox-button").fancybox({
        prevEffect      : 'none',
        nextEffect      : 'none',
        closeBtn        : false,
        helpers     : {
            title   : { type : 'inside' },
            buttons : {}
        }
    });
     
    $('.fancybox-media').fancybox({
        openEffect  : 'none',
        closeEffect : 'none',
        helpers : {
            media : {}
        }
    });
});
</script>		
	</head>
	<body>
<div class="section">
    <div class="title">基本演示</div>
    <a id="single_1" href="http://farm8.staticflickr.com/7100/6917703112_d18e3e1b95_b.jpg" title="Assunção - Santo Tirso...a New Dimension... (Alex Matos)">
        <img src="http://farm8.staticflickr.com/7100/6917703112_d18e3e1b95_m.jpg" alt="" />
    </a>
    <a id="single_2" href="http://farm8.staticflickr.com/7140/7061825385_0ccedf2a8e_b.jpg" title="206/365 Delicate (Sunshine-D)">
        <img src="http://farm8.staticflickr.com/7140/7061825385_0ccedf2a8e_m.jpg" alt="" />
    </a>
    <a id="single_3" href="http://farm8.staticflickr.com/7065/7058141285_064170310e_b.jpg" title="Cummeengeera Settlement/Rabachs Glen. (alancronin02)">
        <img src="http://farm8.staticflickr.com/7065/7058141285_064170310e_m.jpg" alt="" />
    </a>
    <a id="single_4" href="http://farm6.staticflickr.com/5333/7061356373_1af921fd78_b.jpg" title="1968 Dodge Charger R/T - Solaris (1968 Dodge Charger R/T)">
        <img src="http://farm6.staticflickr.com/5333/7061356373_1af921fd78_m.jpg" alt="" />
    </a>
</div>
 
<div class="section">
    <div class="title">Gallery演示</div>
    <a class="fancybox" rel="gallery1" href="http://farm8.staticflickr.com/7069/7060779347_fbee5aae15_b.jpg" title="morning after[explored] (mariosworld343)">
        <img src="http://farm8.staticflickr.com/7069/7060779347_fbee5aae15_m.jpg" alt="" />
    </a>
    <a class="fancybox" rel="gallery1" href="http://farm8.staticflickr.com/7234/7047458501_46a2203733_b.jpg" title="Self confined... (TVidhya)">
        <img src="http://farm8.staticflickr.com/7234/7047458501_46a2203733_m.jpg" alt="" />
    </a>
    <a class="fancybox" rel="gallery1" href="http://farm8.staticflickr.com/7053/6918451990_20fa76f338_b.jpg" title="kleiner schrittmacher (KatjaGiersig)">
        <img src="http://farm8.staticflickr.com/7053/6918451990_20fa76f338_m.jpg" alt="" />
    </a>
    <a class="fancybox" rel="gallery1" href="http://farm8.staticflickr.com/7121/7059981833_abe404f4a0_b.jpg" title="(caro diario.)">
        <img src="http://farm8.staticflickr.com/7121/7059981833_abe404f4a0_m.jpg" alt="" />
    </a>
</div>

<div class="section">
    <div class="title">其他演示</div>
         
    <ul class="list">
        <li>
            <a class="various fancybox.ajax" href="ajaxColorBox">Ajax</a>
        </li>
        <li>
            <a class="various" data-fancybox-type="iframe" href="http://www.ostools.net/">Iframe</a>
        </li>
        <li>
            <a class="various" href="#inline">Inline</a>
        </li>
        <li>
            <a class="various" href="http://www.adobe.com/jp/events/cs3_web_edition_tour/swfs/perform.swf">SWF</a>
        </li>
    </ul>
     
    <ul class="list">
        <li>
            <a class="various fancybox.iframe" href="http://player.youku.com/player.php/sid/XNDI3MTgyMDky/v.swf">嵌入视频 (iframe)</a>
        </li>
        <li>
            <a class="various fancybox.iframe" href="http://maps.google.com.hk/?output=embed&f=q&source=s_q&hl=en&geocode=&q=London+Eye,+County+Hall,+Westminster+Bridge+Road,+London,+United+Kingdom&hl=lv&ll=51.504155,-0.117749&spn=0.00571,0.016512&sll=56.879635,24.603189&sspn=10.280244,33.815918&vpsrc=6&hq=London+Eye&radius=15000&t=h&z=17">Google Maps (iframe)</a>
        </li>
        <li>
            <a class="various" href="/data/non_existing_image.jpg">不存在的链接</a>
        </li>
    </ul>
	    <div id="inline" style="width: 500px; display: none; ">
            <script type="text/javascript">
                $("#add_paragraph").click(function(){
                    $("#inline").append("<p>这是新加的一行</p>");
                });
            </script>
            <h2>这是一个本页的隐藏区域</h2>
 
            <p>
                <a id="add_paragraph" title="Add" class="button button-blue" href="javascript:;">新加一个段落</a>
                &nbsp;
                <a href="javascript:$.fancybox.close();">关闭</a>
    </div>        
</div>
<div class="clear"></div>
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
</ul>
</div>
	</body>
</html>

