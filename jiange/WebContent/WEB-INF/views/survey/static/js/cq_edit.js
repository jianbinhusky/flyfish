function save_cq(){  
  $('.btn .save_zt,.btn .ceng').fadeIn(200); 
  setTimeout(function(){
        $('.btn .save_zt,.btn .ceng').fadeOut(200,function(){
          $('.btn .save_zt,.btn .ceng').remove();
        });
  },1500); 
}
function click_cq(){ 
  //判断点击对象  
  var _idThis=$('.right_operate').attr('oid');  
  setTimeout(function(){
    var _class=$('#question_box').attr('_class');
    var _name=$('#question_box').attr('_name');
    var _idUl=$('#question_box').attr('_id');
    var _html=$('#question_box').attr('_html');   
    if(_idUl){
      if(_html){
        $('#'+_idUl).html(_html);
      }
      //单选下拉式菜单焦点
      if($('#'+_idUl).parents('ul').hasClass('xllist')){ 
        $('#'+_idUl).parents('ul').prev('.drop_zon').find('.bj_drop').click();  
        $('#'+_idUl).click();
      }else if($('#'+_idUl).hasClass('option_Fill')){ 
        $('#'+_idUl).find('input,textarea').focus();
      }else{  
        $('#'+_idUl).click();
      } 
      /*else if($('#'+_idUl).find('#'+_idUl)){
        //$('#'+_idUl).find('#'+_idUl).click();
      }*/
    }else{
      if(_html){
        $('#question_box li[oid='+_idThis+'] div[name='+_name+']').html(_html);
      } 
      //title
      $('#question_box li[oid='+_idThis+'] div[name='+_name+']').click();
    }     
  },200);  
}
//右侧悬浮滚动
function moveTop(obj){ 
    var offTop=$(obj).offset().top; 
    var scrTop=$(window).scrollTop(); 
    var winHeight=$(window).outerHeight();
    var cliTop=offTop-scrTop;
    var xfHeight=$('.right_operate').outerHeight(); 
    var top=0,chaH=0,_topCha=0;  
    if(offTop+26>(winHeight+scrTop)){ 
        $('.jt').css({
            'top':offTop-125
        });
    }else{
        $('.jt').css({
            'top':offTop-117
        });
    }
    //悬浮窗是否显示
    if(!$('.right_operate').hasClass('show')){ 
        if(cliTop < (winHeight/3)){
            //document.title = '上部分' ;
            top=scrTop-123; 
            if(cliTop+50>xfHeight){ 
                $('.right_operate').css('top',offTop-123).stop(true,true).animate({
                   'right':0
                },300,function(){$('.jt').fadeIn(100);});  
            }else{
                if(top>0){ 
                   $('.right_operate').css('top',top).stop(true,true).animate({
                       'right':0
                   },300,function(){$('.jt').fadeIn(100);});   
                }else{ 
                   $('.right_operate').css('top',0).stop(true,true).animate({
                       'right':0
                   },300,function(){$('.jt').fadeIn(100);});  
                }
            }  
        }else if( cliTop>(winHeight/3) && cliTop<((winHeight/3)*2) ){
            //document.title = '中部分' ;
            chaH=winHeight-xfHeight;
            top=scrTop-123; 
            _topCha=winHeight-cliTop;
            //点击位置距离底部的距离是否大于悬浮高度
            if(_topCha>xfHeight){ 
               $('.right_operate').css('top',offTop-123).stop(true,true).animate({
                   'right':0
               },300,function(){$('.jt').fadeIn(100);});  
            }else{
                //window高度是否大于悬浮窗高度
                if(chaH>0){ 
                   $('.right_operate').css('top',top+chaH).stop(true,true).animate({
                       'right':0
                   },300,function(){$('.jt').fadeIn(100);});  
                }else{ 
                   $('.right_operate').css('top',top).stop(true,true).animate({
                       'right':0
                   },300,function(){$('.jt').fadeIn(100);});   
                } 
            } 
        }else{
            //document.title = '下部分' ;
            chaH=winHeight-xfHeight;
            top=scrTop-123; 
            _topCha=winHeight-cliTop;
            //点击位置距离底部的距离是否大于悬浮高度
            if(_topCha+50>xfHeight){ 
               $('.right_operate').css('top',offTop-123).stop(true,true).animate({
                   'right':0
               },300,function(){$('.jt').fadeIn(100);});  
            }else{
                //window高度是否大于悬浮窗高度
                if(chaH>0){ 
                   $('.right_operate').css('top',top+chaH).stop(true,true).animate({
                       'right':0
                   },300,function(){$('.jt').fadeIn(100);});  
                }else{ 
                   $('.right_operate').css('top',top).stop(true,true).animate({
                       'right':0
                   },300,function(){$('.jt').fadeIn(100);});   
                } 
            } 
        } 
        $('.right_operate').addClass('show');  
    }else{
        if(cliTop < (winHeight/3)){
            //document.title = '上部分' ;
            top=scrTop-123;
            if(cliTop+50>xfHeight){
                $('.right_operate').stop(true,true).animate({
                   'top':offTop-123
                },300,function(){$('.jt').fadeIn(100);});  
            }else{
                if(top>0){ 
                   $('.right_operate').stop(true,true).animate({
                       'top':top
                   },300,function(){$('.jt').fadeIn(100);});   
                }else{ 
                   $('.right_operate').stop(true,true).animate({
                       'top':0
                   },300,function(){$('.jt').fadeIn(100);});  
                }   
            }  
        }else if( cliTop>(winHeight/3) && cliTop<((winHeight/3)*2) ){
            //document.title = '中部分' ;
            chaH=winHeight-xfHeight;
            top=scrTop-123; 
            _topCha=winHeight-cliTop;
            //点击位置距离底部的距离是否大于悬浮高度
            if(_topCha>xfHeight){ 
               $('.right_operate').stop(true,true).animate({
                   'top':offTop-123
               },300,function(){$('.jt').fadeIn(100);});  
            }else{
                //window高度是否大于悬浮窗高度
                if(chaH>0){ 
                   $('.right_operate').stop(true,true).animate({
                       'top':top+chaH
                   },300,function(){$('.jt').fadeIn(100);});  
                }else{ 
                   $('.right_operate').stop(true,true).animate({
                       'top':top
                   },300,function(){$('.jt').fadeIn(100);});   
                } 
            } 
        }else{
            //document.title = '下部分' ;
            chaH=winHeight-xfHeight;
            top=scrTop-123; 
            var _topCha=winHeight-cliTop;
            //点击位置距离底部的距离是否大于悬浮高度
            if(_topCha+50>xfHeight){ 
               $('.right_operate').stop(true,true).animate({
                   'top':offTop-123
               },300,function(){$('.jt').fadeIn(100);});  
            }else{
                //window高度是否大于悬浮窗高度
                if(chaH>0){ 
                   $('.right_operate').stop(true,true).animate({
                       'top':top+chaH
                   },300,function(){$('.jt').fadeIn(100);});  
                }else{ 
                   $('.right_operate').stop(true,true).animate({
                       'top':top
                   },300,function(){$('.jt').fadeIn(100);});   
                } 
            } 
        }  
    }  
}
//关闭
function moveLeft(){
    $('.jt').fadeOut(100);
    $('.right_operate').stop(true,true).animate({
        'right':'350px'
    },350,function(){
        $('.right_operate').css('top',0);
        $(".right_operate .setup").html('');
        $('#question_box').attr('_class','');
        $('#question_box').attr('_name','');
        $('#question_box').attr('_id',''); 
    }).removeClass('show'); 
}
//显示宽度判断
function changeWid(){
    var winW=$(window).outerWidth();
    var winH=$(window).outerHeight();
    if(winW>=1440){
        $('#css_url').attr('href','/static/css/edit_cq_v2.css');
    }else if(winW<1440){
        $('#css_url').attr('href','/static/css/edit_cq.css');
    }
    $('.cq_content,.rows2').css("min-height",winH-123);
}
//end
$(window).resize(function(){
    changeWid();
});
$(function(){
  $('.right_operate').delegate('.sel_cq','click',function(){
      if($('.cq_dx').hasClass('active')){  
        loadMack({off:'on',Limg:0,text:'本题题型为多选，选项布局不能改为下拉菜单',set:2800});
        $(this).parents('dl').find('.vertical').click(); 
      } 
  });
  $('.right_operate').delegate('.cq_dx','click',function(){
      if($('.sel_cq').hasClass('active')){  
        loadMack({off:'on',Limg:0,text:'本题选项布局为下拉式菜单，题型不能改为多选',set:2800});
        $(this).prev().click(); 
      } 
  });
	//js响应式
	changeWid(); 
	//统一hover样式
	var txt="",left=0,top=0,now=0; 
    function pophover_cq(e,obj){ 
      $("#pophover").remove();
      left=$(obj).parent('.setup-group').offset().left;
      top=$(obj).parent('.setup-group').offset().top;
      now=$(obj).index(); 
      if($(obj).hasClass('cq_fgx')){
      	var pophover='<div id="pophover" style="display:none;position:absolute;left:-15px;top: 23px;width:85px;z-index:1000"><span style="background-color:#454545;font-size:14px; padding:5px 0px; border-radius:5px; color:#fff;opacity:0.9;display:block;text-align:center">删除分割线</span></div>';
      }else{
      	var pophover='<div id="pophover" style="display:none;position:absolute;left:-15px;top: 23px;width:70px;z-index:1000"><span style="background-color:#454545;font-size:14px; padding:5px 0px; border-radius:5px; color:#fff;opacity:0.9;display:block;text-align:center">'+txt+'</span></div>';
      } 
      $('body').append(pophover);
      $("#pophover").css({"top":top+(now*30),"left":left+40});
      $("#pophover").show();
    }  
    function pophover_cq2(obj){ 
      $("#pophover").remove();
      left=$(obj).parent('.operationH').offset().left;
      top=$(obj).parent('.operationH').offset().top;
      now=$(obj).index(); 
      var pophover='<div id="pophover" style="display:none;position:absolute;left:-15px;top: 23px;width:70px;z-index:1000"><span style="background-color:#454545;font-size:14px; padding:5px 0px; border-radius:5px; color:#fff;opacity:0.9;display:block;text-align:center">'+txt+'</span></div>';
      $('body').append(pophover);
      $("#pophover").css({"top":top+25,"left":left+(now*28)-20});
      $("#pophover").show();
    }
    function pophover_cq3(obj){ 
      $("#pophover").remove();
      left=$(obj).parent('.operationV').offset().left;
      top=$(obj).parent('.operationV').offset().top;
      now=$(obj).index(); 
      var pophover='<div id="pophover" style="display:none;position:absolute;left:-15px;top: 23px;width:70px;z-index:1000"><span style="background-color:#454545;font-size:14px; padding:5px 0px; border-radius:5px; color:#fff;opacity:0.9;display:block;text-align:center">'+txt+'</span></div>';
      $('body').append(pophover);
      $("#pophover").css({"top":top+(now*27)-6,"left":left+25});
      $("#pophover").show();
    }  
    function pophover_cq4(obj){
      $("#pophover").remove();
      var pophover='<div id="pophover" style="display:none;position:absolute;left:50%;top: 45px;z-index:1000"><span style="background-color:#454545;font-size:14px;padding:5px 10px; border-radius:5px; color:#fff;opacity:0.9;display:block;text-align:center">'+txt+'</span></div>';
      $('body').append(pophover);  
      $(obj).live("mousemove",function(e){
        left=e.clientX;top=e.clientY+$(window).scrollTop();
        if($(obj).hasClass('q_title') || $(obj).parents('.module').hasClass('paging') || $(obj).parents('.module').hasClass('split_line')){
          $("#pophover").css({"left":left+10,'top':top+8});
        }else{
          $("#pophover").css({"left":left+16,'top':top+20});
        } 
      });
      $("#pophover").show();
    }
    $(".setup-group a,.rows1 ul li").live('click',function(){
      $("#pophover").remove();
    }); 
    $(".setup-group a.up_cq").live('mouseenter',function(e){
      txt="上移本题"; 
      pophover_cq(e,this); 
    });  
    $(".setup-group a.down_cq").live('mouseenter',function(e){
      txt="下移本题"; 
      pophover_cq(e,this);  
    });  
    $(".setup-group a.Bub").live('mouseenter',function(e){
      txt="复制题目"; 
      pophover_cq(e,this); 
    });  
    $(".setup-group a.Del").live('mouseenter',function(e){
      txt="删除题目"; 
      pophover_cq(e,this); 
    });   
    $(".setup-group a.DelPaging").live('mouseenter',function(e){
      txt="删除分页"; 
      pophover_cq(e,this); 
    });   
    $('.operationH .cq_add').live('mouseenter',function(e){
    	$(this).show();
    	txt="添加选项"; 
    	pophover_cq2(this); 
    });
    $('.operationH .Bub').live('mouseenter',function(e){
    	$(this).show();
    	txt="批量添加"; 
    	pophover_cq2(this); 
    });
    $('.operationV .cq_add').live('mouseenter',function(e){
    	$(this).show();
    	txt="添加选项"; 
    	pophover_cq3(this); 
    });
    $('.operationV .Bub').live('mouseenter',function(e){
    	$(this).show();
    	txt="批量添加"; 
    	pophover_cq3(this); 
    });
    $(".module .q_title").live('mouseenter',function(e){ 
      txt="按住拖动题目排序"; 
      pophover_cq4(this); 
    });
    $(".cq_lj_ts").live('mouseenter',function(e){ 
      $("#pophover").remove();
      txt="逻辑设置"; 
      left=$(this).offset().left;
      top=$(this).offset().top;
      now=$(this).index(); 
      var pophover='<div id="pophover" style="display:none;position:absolute;left:-15px;top: 23px;width:70px;z-index:1000"><span style="background-color:#454545;font-size:14px; padding:5px 0px; border-radius:5px; color:#fff;opacity:0.9;display:block;text-align:center">'+txt+'</span></div>';
      $('body').append(pophover);
      $("#pophover").css({"top":top-5,"left":left+42});
      $("#pophover").show(); 
    });
    $(".Lock_ico").live('mouseenter',function(e){
      $("#pophover").remove();
      $(this).attr('title',''); 
      txt="本题仅表单制作者可见,对普通填写者不显示";  
      var pophover='<div id="pophover" style="display:none;position:absolute;left:50%;top: 45px;z-index:1000"><span style="background-color:#454545;font-size:14px;padding:5px 10px; border-radius:5px; color:#fff;opacity:0.9;display:block;text-align:left; width:270px;">'+txt+'</span></div>';
      $('body').append(pophover);  
      $(this).live("mousemove",function(e){
        left=e.clientX;top=e.clientY+$(window).scrollTop();
        if($(window).outerWidth()<$(this).offset().left+270){
          $("#pophover").css({"left":left-270,'top':top+15});
        }else{
          $("#pophover").css({"left":left+15,'top':top+15});
        } 
      });
      $("#pophover").show();
    }); 
    $(".cq_ts_wh").live('mouseenter',function(e){
      $("#pophover").remove();
      $(this).attr('title','');  
      txt="唯一性检查，填写内容不能与已提交的内容重复"; 
      var pophover='<div id="pophover" style="display:none;position:absolute;left:50%;top: 45px;z-index:1000"><span style="background-color:#454545;font-size:14px;padding:5px 10px; border-radius:5px; color:#fff;opacity:0.9;display:block;text-align:left; width:296px;">'+txt+'</span></div>';
      $('body').append(pophover);  
      $(this).live("mousemove",function(e){
        left=e.clientX;top=e.clientY+$(window).scrollTop();
        if($(window).outerWidth()<$(this).offset().left+320){
          $("#pophover").css({"left":left-320,'top':top+15});
        }else{
          $("#pophover").css({"left":left+15,'top':top+15});
        }
      });
      $("#pophover").show();
    }); 
    $("#question_box .paging .topic_type_con,.split_line .topic_type_con").live('mouseenter',function(e){ 
      txt="按住拖动排序"; 
      pophover_cq4(this); 
    }); 
    /*$(".uploader").live('mouseenter',function(e){ 
      txt="添加图片";  
      pophover_cq4(this); 
    }); */ 
    $('.setup-group a,.module .q_title,.cq_lj_ts,.operationH a,.Lock_ico,.cq_ts_wh,.operationV a,.paging .topic_type_con,.split_line .topic_type_con').live('mouseleave',function(){
        $("#pophover").remove();
    }); 
    //focus
   	$('.cq_content .right_operate input[type="text"]').live('focus',function(){  
   		$(this).css('border','1px solid #53a4f4');
   	});
   	$('.right_operate input[type="text"]').live('blur',function(){ 
   		$(this).css('border','1px solid #e2e2e2'); 
   	}); 
    //click 
    $('.option_Fill input,.T_edit_td,.option_Fill textarea,.T_edit,.T_edit_min').live('click',function(e){
        //$('.btn .ceng,.save_zt').remove(); 
        $('#question_box').attr('_html','');
        $('.jt').hide();
        var _class=$(this).attr('class');
        var _name=$(this).attr('name');
        var _id; 
        if( $(this).parent().hasClass('option_Fill')){
          _id=$(this).parents('.option_Fill').attr('id');
        }else{
          _id = $(this).attr('id');
        } 
        $(this).parents('#question_box').attr('_class',_class);
        $(this).parents('#question_box').attr('_name',_name); 
        if(_id){
            $(this).parents('#question_box').attr('_id',_id);
        }else{
            $(this).parents('#question_box').attr('_id',''); 
        } 
        $('.right_operate').show(); 
        var _index=$(this).parents('.module').index();
        if($(this).hasClass('p_title') || $(this).hasClass('p_end_desc') ||$(this).hasClass('p_begin_desc') ){
            moveLeft();  
        }else{
            //点击题目右侧悬浮跳动 
            var _this= this ;
            setTimeout(function(){
                if($('.right_operate dl.way dd').length>0){
                    $('.right_operate dl.way').show();
                }  
                if($('.way dd .column').hasClass('active')){
                	$('#disp_type_column').show();
                }
                if(!initRightOperate()) {
                    moveTop(_this);
                }  
            },300); 
        } 
        e.stopPropagation(); 
    });  
    //冒泡
    $(document).click(function(){
        moveLeft();    
        $('.operationH .Bub,.operationV .Bub,.BubR').attr('title','');
    });    
    $(document).mouseup(function(){
      $('.pophover').remove();
    });
    //阻止冒泡 
    $('.jsbox,.jsBubble_s,.jsboxContent,#maptss,#lightBox,.bj_drop').live('click',function(e){
        e.stopPropagation();
    }); 
    $('.right_operate').click(function(e){
        e.stopPropagation();
    });
    $('.jsbox_close').live('click',function(e){
      $('.btn .ceng,.save_zt').remove(); 
      click_cq();
      e.stopPropagation();
    });
    //动态更新位置
    $('.right_operate').delegate('ul li','click',function(){ 
        setTimeout(function(){ 
            var hei_xf = $('.right_operate').outerHeight();
            var top_xf = $('.right_operate').offset().top;
            var hei_do = $(document).height();
            if((top_xf+hei_xf)>hei_do){
                $('.right_operate').animate({
                    'top':hei_do-hei_xf-132
                },300);
            }
        },100);
    });
    //save
    $('.right_operate .btn a.save').click(function(){ 
        if($('.btn .save_zt').length==0){ 
          $('.btn').append('<p class="save_zt">已保存</p><p class="ceng">保存</p>');
        }
        $('.SavePrompt').hide();
        if (validation()){  
            save_form(); 
            $('.SavePrompt').hide();
        }else{
          return false;
        }     
        click_cq();
    }); 
    //close
    $('.right_operate .close').click(function(){
        moveLeft();
        $('.SavePrompt').hide();
        $('.zon_edit').remove(); 
    });  
    $('.module').live('mouseup',function(){
      $('.pophover').remove();
    });
    $('.module').live('mouseenter',function(){
      $('.pophover').remove();
    });
    $('body').delegate('.add_edit','keyup',function(){
      var _html = $(this).html();
      $('#question_box').attr('_html',_html);
    });  
});