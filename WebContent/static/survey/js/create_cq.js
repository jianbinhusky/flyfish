$(function(){
		 function hei(){
		 	var _hei=$(window).height(true);
		 	$('.tc_nr,.tc_box').css('height',_hei-192);
		 	//$('#firame_box iframe').attr('height',_hei-192);
		 }
		 hei();
		 $(window).resize(function(){
		 	hei(); 
		 }); 
		 $('.btn_a a').click(function(){
		 	$(this).addClass('active').siblings().removeClass('active');
		 	var now=$(this).index();
		 	$('.tc_box').eq(now).show().addClass('.show').siblings('.tc_box').hide().removeClass('show');
		 	if(now==1){
		 		$('.tc_box').eq(now).jScrollPane({
				    maintainPosition: true
				}); 
		 	} 
		 });
		 $('.btn_a a:first').trigger('click'); 

		 $('.tab_list .tr').live('click',function(){ 
		 	$('.btn_a a:first').trigger('click'); 
		 	if(!$('.slide_box').hasClass('show')){ 
		 		$('.slide_box').show().stop(true,true).animate({
		 			'right':'0px'
		 		},500,function(){ 
		 			$('.slide_box').addClass('show');  
		 		});
		 	} 
		 });
		 $('.slide_box .close').click(function(){
		 	$('.slide_box').stop(true,true).animate({
		 		'right':'-922px'
		 	},500,function(){
		 		$('.slide_box').removeClass("show").hide();
		 		$('.tab_list .tr').removeClass('active');
		 	});
		 });
	});