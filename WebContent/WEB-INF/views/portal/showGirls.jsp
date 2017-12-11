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
		<meta name="Author" content="hujianbin" />    
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>WaterFlow|BeautyGirl</title>
		<link rel="shortcut icon" href="<c:url value="/static/images/ico.png" />"/>
		<link rel="bookmark" href="<c:url value="/static/images/ico.png " />"/> 
	    <link type="text/css" href="<c:url value="/static/css/style.css" /> " rel="stylesheet" />
	    <link type="text/css" href="<c:url value="/static/css/jquery.fancybox-thumbs.css" /> " rel="stylesheet" media="screen" /> 
	    <link type="text/css" href="<c:url value="/static/css/jquery.fancybox-buttons.css" /> " rel="stylesheet" media="screen" />
	    <link type="text/css" href="<c:url value="/static/css/jquery.fancybox.css" /> " rel="stylesheet" media="screen" />
	</head>
	<body>
	    <div id="main">
	    	<c:forEach items="${beautyGirlList}" var="beautyGirl">
		        <!--每一个小块-->
		        <div class="pin">
		            <div class="box">
		            	<a class="fancybox-button" rel="fancybox-button" href="<c:url value="/static/images/${beautyGirl.imageUrl}" />">
		                	<img src="<c:url value="/static/images/${beautyGirl.imageUrl} " />">
		                </a>
		            </div>
		        </div>	    	
	    	</c:forEach>
	    </div>
	    <div id="navigation">
	    	<a href="<c:url value="/showAnotherGirls.json?pageno=2"/>"></a>
	    </div>
	</body>
		<script type="text/javascript" src="<c:url value='/static/scripts/jquery-1.7.2.min.js' />"></script>
		<script type="text/javascript" src="<c:url value='/static/scripts/jquery.masonry.min.js' />"></script>
		<script type="text/javascript" src="<c:url value='/static/scripts/jquery.infinitescroll.js' />"></script>
		<script type="text/javascript" src="<c:url value='/static/scripts/jquery.livequery.js' />"></script>
		<script type="text/javascript" src="<c:url value='/static/scripts/jquery.fancybox.pack.js' />"></script>
		<script type="text/javascript" src="<c:url value='/static/scripts/jquery.fancybox-buttons.js' />"></script>
		<script type="text/javascript" src="<c:url value='/static/scripts/jquery.fancybox-media.js' />"></script>
		<script type="text/javascript" src="<c:url value='/static/scripts/jquery.fancybox-thumbs.js' />"></script>
	    <script type="text/javascript">
	        $(document).ready(function(){
	            $(".fancybox-button").fancybox({
	                prevEffect      : 'none',
	                nextEffect      : 'none',
	                closeBtn        : true,
	                helpers     : {
	                    title   : { type : 'inside' },
	                    buttons : {}
	                }
	            });
	            
	            var oParent = document.getElementById("main");
	            var aPin = getClassObject(oParent,"pin");//获取父级[第一个参数]下的所有的子元素[按照第二个参数匹配]
	            var iPinW = aPin[0].offsetWidth;//获取每一个块的宽度
	            var num = Math.floor(document.documentElement.clientWidth/iPinW);//计算每行放多少个pin(瀑布流块)页面的宽度/每一个瀑布流块的宽度
	            oParent.style.cssText="width:" + num*iPinW + "px;margin:0 auto;"; //重置父级的样式,这样保证图片整体居中
	            
	            /**
	             *     获取parent下所有样式名为className的对象集合
	             */
	            function getClassObject(parent,className){
	                var obj = parent.getElementsByTagName("*");
	                var result = [];
	                for(var i=0; i<obj.length;i++){
	                    if(obj[i].className==className){//变量如果匹配className,将匹配的对象放入数组
	                        result.push(obj[i]);
	                    }
	                }
	                return result;
	            } 
	            
	            var $container = $('#main');
	            $container.imagesLoaded( function(){
	                $container.masonry({
	                	//containerStyle:{ position: 'relative',margin:0},
	                    itemSelector : '.pin',
	                    gutterWidth : 0,
	                    //columnWidth: function( containerWidth ) {
	                    //	 return containerWidth / 5;
	                    //},
	                    isAnimated: true,
	                    isFitWidth:true,
	                    isResizable:true
	                });
	            });
	            
	            $container.infinitescroll({
		                navSelector  : '#navigation',    // selector for the paged navigation 
		                nextSelector : '#navigation a',  // selector for the NEXT link (to page 2)
		                itemSelector : '.pin',     // selector for all items you'll retrieve
		                debug: false,
		                animate: true, //当有新数据加载进来的时候，页面是否有动画效果，默认没有
		                extraScrollPx: 150, //滚动条距离底部多少像素的时候开始加载，默认150
		                errorCallback: function() {
		                }, //当出错的时候，比如404页面的时候执行的函数
		                localMode: false, //是否允许载入具有相同函数的页面，默认为false
		                dataType: 'json',//可以是json
		                template: function(data) {
		                    //data表示服务端返回的json格式数据，这里需要把data转换成瀑布流块的html格式，然后返回给回到函数
		                    var item = '';
							for(var i=0;i<data.beautyGirlList.length;i++){
								var imageUrl = data.beautyGirlList[i].imageUrl;
								item = item +  '<div class="pin">' +
												'<div class="box">' +
													'<a class="fancybox-button" rel="fancybox-button" href="<c:url value="/static/images/'+imageUrl+'" />">'+
														'<img src="<c:url value="/static/images/'+imageUrl+' " />">' +
													'</a>' +
												'</div>' +
											'</div>';
							}
		                    return item;
		                },
		                loading: {
		                    //finishedMsg: 'No more pages to load.',
		                    //img: 'http://i.imgur.com/6RMhx.gif'
		                  }
	           	 },function( newElements ) { // trigger Masonry as a callback
	                  var $newElems = $( newElements ).css({ opacity: 0 });// hide new items while they are loading
	                  $newElems.imagesLoaded(function(){ // ensure that images load before adding to masonry layout
	                    $newElems.animate({ opacity: 1 });// show elems now they're ready
	                    $container.masonry( 'appended', $newElems, true ); 
	                  });
	                }
	              );
	        });
	    </script> 		
</html>
