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
		<link rel="shortcut icon" href=""/>
		<link rel="bookmark" href=""/> 
	    <link type="text/css" href="<c:url value="/static/css/style.css" /> " rel="stylesheet" />
		<script type="text/javascript" src="<c:url value='/static/scripts/jquery-1.8.2.min.js' />"></script>
		<script type="text/javascript" src="<c:url value='/static/scripts/masonry-docs.min.js' />"></script>
	</head>
	<body>
	    <div id="main">
	    	<c:forEach items="${beautyGirlList}" var="beautyGirl">
		        <!--每一个小块-->
		        <div class="pin">
		            <div class="box">
		                <img src="<c:url value="/static/images/${beautyGirl.imageUrl} " />">
		            </div>
		        </div>	    	
	    	</c:forEach>
	    </div>
	
	    <script type="text/javascript">
	    	var timestamp = <c:out value="${minTimestamp}" /> ;
	        $(function(){
	            var oParent = document.getElementById("main");
	            //获取父级[第一个参数]下的所有的子元素[按照第二个参数匹配]
	            var aPin = getClassObject(oParent,"pin");
	            //获取每一个块的宽度
	            var iPinW = aPin[0].offsetWidth;
	            //计算每行放多少个pin(瀑布流块)页面的宽度/每一个瀑布流块的宽度
	            var num = Math.floor(document.documentElement.clientWidth/iPinW);
	            //重置父级的样式,这样保证图片整体居中
	            oParent.style.cssText="width:" + num*iPinW + "px;margin:0 auto;";
	            
	            /**
	             *     获取parent下所有样式名为className的对象集合
	             */
	            function getClassObject(parent,className){
	                var obj = parent.getElementsByTagName("*");
	                var result = [];
	                for(var i=0; i<obj.length;i++){
	                    //变量如果匹配className,将匹配的对象放入数组
	                    if(obj[i].className==className){
	                        result.push(obj[i]);
	                    }
	                }
	                return result;
	            }   
	            
	            function checkScrollSite(){
	                var oParent = document.getElementById("main");
	                var aPin = getClassObject(oParent,"pin");
	                //加载数据依赖最后一个瀑布流块变化
	                var lastPinHeight = aPin[aPin.length-1].offsetTop + Math.floor(aPin[aPin.length-1].offsetHeight/2) ;
	                var scrollTop = document.documentElement.scrollTop || document.body.scrollTop;
	                //alert("lastPinHeight = "+lastPinHeight);
	                //alert("scrollTop = "+scrollTop);
	                //浏览器高度
	                var documentH = document.documentElement.clientHeight;
					//alert("浏览器高度 documentH = "+documentH);
	                if(lastPinHeight<documentH + scrollTop){
	                    //请求数据
	                    return true;
	                }
	                return false;
	            }	            
	            
	            var $container = $('#main');
	            $container.imagesLoaded( function(){
	                $container.masonry({
	                    itemSelector : '.pin',
	                    gutterWidth : 20,
	                    isAnimated: true,
	                    isFitWidth:true,
	                    isResizable:true
	                });
	            });
	            
		        $(window).scroll(function(){
		        	if(checkScrollSite()){
		        	 //if ($(document).height() - $(this).scrollTop() - $(this).height()<50){  
						$.ajax({
							type:'post',
							data:'timestamp='+timestamp,
							url:'<c:url value="/showMoreGirls.json"/>',
							dataType:'json',
							success:function(data){
								timestamp = data.minTimestamp;
								var item = '';
								$container.imagesLoaded(function(){
									for(var i=0;i<data.beautyGirlList.length;i++){
										var imageUrl = data.beautyGirlList[i].imageUrl;
										item = item +  '<div class="pin">' +
														'<div class="box">' +
															'<img src="<c:url value="/static/images/'+imageUrl+' " />">' +
														'</div>' +
													'</div>';
											//$container.append(item);
											//$container.append(item).masonry( 'appended', item, true );
									}
									$container.imagesLoaded(function(){
									$container.append(item).masonry( 'appended', item);
									});
								});
								
								//alert(item);
									//item.css({ opacity: 0 });
				                  // ensure that images load before adding to masonry layout
				                  //$container.imagesLoaded(function(){
				                    // show elems now they're ready
				                    //item.animate({ opacity: 1 });
				                    //$container.masonry( 'appended', item, true ); 
				                 // });
							},
							error:function(error){ 
								alert("error = "+error);
							} 
						});
		        	}
		        });
	        });
	    </script>    
	</body>
</html>
