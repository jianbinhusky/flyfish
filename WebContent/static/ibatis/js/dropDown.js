/*下拉菜单项*/

jQuery.Huihover =function(obj) {
	$(obj).hover(function () {
		$(this).addClass("hover");
	}, function () {
		$(this).removeClass("hover");
	});
}
$(function(){	
	$.Huihover('.dropDown');
	$(".dropDown_click .dropDown_A").click(function(){$(".dropDown").removeClass('open');if($(this).parents(".dropDown").hasClass('open')){$(this).parents(".dropDown").removeClass('open');}else{$(this).parents(".dropDown").addClass('open');} return false});
	$("body").click(function(){$(".dropDown").removeClass('open');});
	$(".dropDown-menu li a").click(function(){$(".dropDown").removeClass('open');});
	$(".dropDown_hover").hover(function(){$(this).addClass("open");$(".dropDown_hover .dropDown-menu").addClass("display");},function(){$(this).removeClass("open");$(".dropDown_hover .dropDown-menu").removeClass("display");});
});
