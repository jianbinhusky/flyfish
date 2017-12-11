var _kuan=0;
function resizeWidth(){ 
    var wid=$(window).outerWidth()-40; 
    var num = Math.floor(wid/290);
    var jianju = wid - num*290;
    var mar = Math.floor(jianju/(num-1));
    if(mar>=20){
        mar=20;
    }
    if(num<4){
        num=4;
    }
    $('.hzBox').css({'width':num*(290+mar)-mar,'margin':'0 auto'}); 
    $('.list_check').css({'width':num*(290+mar)-mar,'margin':'0 auto'});
    $('.lbBox').css({'width':num*(290+mar)-mar-40,'margin':'0 auto'}); 
    $('.hzBox ul').css({'width':num*(291+mar),'margin-left':-mar});
    $('.hzBox ul li').css({'margin-left':mar}); 
    _kuan=$('#proj_list').width()*0.42-12; 
    $('.proj_title').css('width',_kuan);
}
$(function(){
    loadMack({off:'on',Limg:1,text:'加载中...',set:1}); 
    $('#search_txt').focus(function(){
        $(this).css("color",'#454545');
    }).blur(function(){
        $(this).css("color",'#999');
    });
    resizeWidth();
    $(window).resize(function(){
        resizeWidth();
    });
    $('#listHz li').live('click',function(){
        if($(this).attr('oldId')=="null" && !$(this).hasClass('create')){ 
            var oid=$(this).attr('oid');
            window.location.href='/report/project/'+oid;
        }else if($(this).hasClass('create')){ 
            window.location.href='/new/';
        }
    }); 
    $('#listHz li').live('mouseenter',function(){
        $(this).find('.old_ceng').stop(true,true).fadeIn(200);
    }); 
    $('#listHz li').live('mouseleave',function(){
        $(this).find('.old_ceng').stop(true,true).fadeOut(200);
    }); 
    
    $('#proj_list .tr .first').live('click',function(){
        if($(this).parent('.tr').attr('oldId')=='null'){
            var oid=$(this).attr('oid');
            window.location.href='/report/project/'+oid;
        }
    }); 
    $('.list_tab a').click(function(){
        $(this).addClass('active').siblings('a').removeClass('active');
        $('.listBox').eq($(this).index()).show().siblings('.listBox').hide(); 
        if($(this).index()==1){
            $('.new_create').show(); 
        }else{ 
            $('.new_create').hide();
        }
        resizeWidth();
    }); 
    //focus
    $('.list_sear .txt').focus(function(){
        if($(this).val()==this.defaultValue){ 
            $(this).val(""); 
        }
    }).blur(function(){
        if($(this).val()==""){ 
            $(this).val(this.defaultValue); 
        }
    });   
    //hover
    var txt="";
    $("body .editor").live('mouseenter',function(){ 
      if(!$(this).hasClass('end')){
        txt="编辑"+$(this).parent().attr('type');
          var pophover='<div id="pophover" style="display:none;position:absolute;left:-15px;top: 23px;width:65px;z-index:20"><s class="arrow_t"></s><span style="background-color:#000;font-size:12px;line-height:26px;color:#fff;opacity:0.6;display:block;height:26px;text-align:center">'+txt+'</span></div>';
          $("body").append(pophover);
          $("#pophover").css({"top":$(this).offset().top+32,"left":$(this).offset().left-20})
          $("#pophover").show();
      } 
    });
    $("body .analysis").live('mouseenter',function(){
      txt="分析结果";
      var pophover='<div id="pophover" style="display:none;position:absolute;left:-15px;top: 23px;width:65px;z-index:20"><s class="arrow_t"></s><span style="background-color:#000;font-size:12px;line-height:26px;color:#fff;opacity:0.6;display:block;height:26px;text-align:center">'+txt+'</span></div>';
      $("body").append(pophover);
      $("#pophover").css({"top":$(this).offset().top+32,"left":$(this).offset().left-20})
      $("#pophover").show();
    });
    $("body .collect_a").live('mouseenter',function(){
      if(!$(this).hasClass('end')){
          txt="收集数据";
          var pophover='<div id="pophover" style="display:none;position:absolute;left:-15px;top: 23px;width:65px;z-index:20"><s class="arrow_t"></s><span style="background-color:#000;font-size:12px;line-height:26px;color:#fff;opacity:0.6;display:block;height:26px;text-align:center">'+txt+'</span></div>';
          $("body").append(pophover);
          $("#pophover").css({"top":$(this).offset().top+32,"left":$(this).offset().left-17})
          $("#pophover").show();
      }
    });
    $('body .collect_a,.analysis,.editor').live('mouseleave',function(){
        $("#pophover").remove();
    }); 
    $('.username').click(function(){
        if($(".loginMeun:visible").length>0){
            $(this).find('.loginMeun').hide();
            $(this).find('.arrowupt').removeClass('atop');
        }else{
            $(this).find('.loginMeun').show();
            $(this).find('.arrowupt').addClass('atop');
        }
        return false;
    });
    $(".login_but").click(function(){
        if($(".loginBox:visible").length>0){
            $(".loginBox").fadeOut("slow");
        }else{
            $(".loginBox").fadeIn("slow");
        }
        return false;
    });
    $(".loginBox,.loginMeun").click(function(event){
        event.stopPropagation();
    });
    $('body').click(function(){
        $(".loginBox").fadeOut("slow");
        $('.username').find('.loginMeun').hide();
        $('.username').find('.arrowupt').removeClass('atop');
    });    
    remember();
}); 
var page = 1;
var type=1; 
var on=true;
var txt='';
var sort=1;  
function getList(url,page,obj,p_type,search_txt,sort){ 
    var url=url;
    var timestamp = new Date().getTime()

    if(p_type==0){ 
        url+='?p_type=0'; 
    }else if(p_type==1){ 
        url+='?p_type=1'; 
    }else if(p_type==2){
        url+='?p_type=2';  
    }else if(p_type==3){
        url=url;
    } 
    if(search_txt!='' && p_type!=3){
        url+='&search_txt='+search_txt; 
    }else if(search_txt!='' && p_type==3){
        url+='?search_txt='+search_txt; 
    } 
    var pageTotal = $('#zon_page').val();
    if(pageTotal==0){
        pageTotal=10;
    } 
    if($(obj).hasClass('ul_list')){ 
        if(page<=pageTotal){
            $.ajax({
                type: 'get',
                url: url,
                data: {
                    page: page,
                    time_order:sort,
                    t:timestamp
                }, 
                success: function (data) { 
                    $('.loadCon,.loadMack').remove();  
                    var data=JSON.parse(data),list=data.project_list,len=list.length,html_hz='',html_lb='',_class='',_icon='',state='';
                    if(page > data.totalPage) {
                        page--;
                        return;
                    }
                    $('#zon_page').val(data.totalPage);
                    for(var i=0;i<len;i++){
                        if(list[i].p_type==null){
                            _class='survey';
                        }else if(list[i].p_type==1){
                            _class='form'; 
                        }else if(list[i].p_type==2){
                            _class='assess'; 
                        } 
                        if(list[i].status==0){
                            _icon='closed_icon';
                            state='未发布';  
                        }else if(list[i].status==1){
                            _icon='collect_icon';
                            state='收集中'; 
                        }else if(list[i].status==2){ 
                            _icon='end_icon';
                            state='已结束'; 
                        } 
                        html_hz +='<li class="hz '+_class+'" oid="'+list[i].id+'" oldId="'+list[i].old_id+'"><a href="javascript:;" class="bt" title="'+list[i].title+'">'+list[i].title+'</a><span class="edit_time">'+list[i].time_diff_display+'</span><div class="state clearfix"><span class="'+_icon+'"><i></i>'+state+'</span><em>'+list[i].rspd_count+' 份数据</em></div></li>';
                    } 
                    var $item = $(html_hz).hide();
                    $('#listHz').append($item);
                    $item.fadeIn(150);  
                    if($('#listHz').find('li.create').length==0){
                        $('#listHz').prepend('<li class="create" oldId="null"><a href="/new/"><i></i>新建</a></li>'); 
                    }
                    $('#listHz li').each(function(){
                        if($(this).attr('oldId')!='null'){ 
                            if($(this).find(".old_ceng").length==0){
                                $(this).append('<div class="old_ceng">旧数据</div>');
                            }
                        }
                        if($(this).find('a.bt').height()>=66){
                            if($(this).find('a.bt').find('i').length==0){  
                                $(this).find('a.bt').append('<i>...</i>');
                            }
                        }
                    }); 
                    resizeWidth(); 
                    if($('.hzBox').is(':visible')){ 
                        setTimeout("load()", 300); 
                    }     
                    on=true;
                },
                error: function () {  
                    loadMack({off:'on',Limg:1,text:'网络繁忙，请稍后再试！',set:1});
                } 
            }); 
        }
    }else if($(obj).hasClass('table_list')){ 
        if(page<=pageTotal){
            $.ajax({
                type: 'get',
                url: url,
                data: {
                    page: page,
                    time_order:sort,
                    t:timestamp
                }, 
                success: function (data) {    
                    var data=JSON.parse(data),list=data.project_list,len=list.length,html_hz='',html_lb='',_class='',_icon='',state='',leixing='',_sel='';
                    $('#zon_page').val(data.totalPage); 
                    for(var i=0;i<len;i++){ 
                        if(list[i].status==0){
                            _class='closed';
                            state='未发布';  
                            _sel='<select pccount="'+list[i].pcs_count+'" panelsite="'+data.panelsite+'" pid="'+list[i].id+'" lastv="'+list[i].status+'" copy_from_pid="'+list[i].copy_from_pid+'" isFirstC="true" is_shared="'+list[i].share_status+'" onchange="proj_status_changed(this);" style="width:80px;"><option class="unpublished" selected="selected" value="0">未发布</option><option class="collection" value="1">收集中</option><option class="closed" value="2">已结束</option></select>';
                        }else if(list[i].status==1){
                            _class='collect';
                            state='收集中';  
                            _sel='<select pccount="'+list[i].pcs_count+'" panelsite="'+data.panelsite+'" pid="'+list[i].id+'" lastv="'+list[i].status+'" copy_from_pid="'+list[i].copy_from_pid+'" isFirstC="true" is_shared="'+list[i].share_status+'" onchange="proj_status_changed(this);" style="width:80px;"><option class="unpublished" value="0">未发布</option><option class="collection"  selected="selected" value="1">收集中</option><option class="closed" value="2">已结束</option></select>';
                        }else if(list[i].status==2){
                            _class='end';
                            state='已结束'; 
                            _sel='<select pccount="'+list[i].pcs_count+'" panelsite="'+data.panelsite+'" pid="'+list[i].id+'" lastv="'+list[i].status+'" copy_from_pid="'+list[i].copy_from_pid+'" isFirstC="true" is_shared="'+list[i].share_status+'" onchange="proj_status_changed(this);" style="width:80px;"><option class="unpublished" value="0">未发布</option><option class="collection" value="1">收集中</option><option class="closed" selected="selected" value="2">已结束</option></select>';
                        } 
                        if(list[i].p_type==null){
                            leixing='问卷';
                        }else if(list[i].p_type==1){
                            leixing='表单'; 
                        }else if(list[i].p_type==2){
                            leixing='测评'; 
                        } 
                        html_lb+='<tr oldId="'+list[i].old_id+'" status="'+list[i].status+'" class="tr '+_class+'"><td class="first" width="42%" oid="'+list[i].id+'"><span class="proj_title" style="width:'+_kuan+'px" title="'+list[i].title+'">'+list[i].title+'</span></td><td class="tl">'+_sel+'</td><td class="cq_sdsj trc" id="rspd_count_'+list[i].id+'" pid="'+list[i].id+'">'+list[i].rspd_count+'</td><td class="tl tdcj">'+list[i].created_time+'</td><td class="tl">'+list[i].time_diff_display+'</td><td class="last" type="'+leixing+'"><a onclick="project_design_confirm(this);return false;" pid="'+list[i].id+'" fid="'+list[i].project_func_id+'" class="editor btn"></a><a href="/collect/urllink/'+list[i].id+'" class="collect_a"></a><a href="report/basic_chart/'+list[i].id+'?pid='+list[i].id+'" class="analysis"></a><a href="/s/'+list[i].short_id+'?test=1" target="_blank" class="a">预览</a><a href="javascript:;" pid="'+list[i].id+'" fid="'+list[i].project_func_id+'" class="a copysurvey2" data-title="'+list[i].title+'">复制</a><a href="javascript:;" id="cleanup_'+list[i].id+'" pid="'+list[i].id+'" class="color a">清空</a><a href="javascript:;" pid="'+list[i].id+'" fid="'+list[i].project_func_id+'" class="a deletebtn">删除</a></td></tr>';
                    } 
                    var _type=$('#state_sel').find("option:selected").val();
                    if(_type=="全部"){
                        _type="";
                    }
                    if(html_lb==''){
                        if(search_txt=="" || search_txt=="输入标题搜索"){
                             if (p_s_id=="315") {
                                             $('#proj_list').html('<tr style="border-bottom:none;"><td colspan="6"><p style="text-align:center; padding:150px 0px; font-size:16px;">暂无项目，点击<a href="/create" style="color:#53a4f4;">&nbsp;新建</a></p></td></tr>'); 
                                         }
                                         else{
                                             $('#proj_list').html('<tr style="border-bottom:none;"><td colspan="6"><p style="text-align:center; padding:150px 0px; font-size:16px;">暂无项目，点击<a href="/new" style="color:#53a4f4;">&nbsp;新建</a></p></td></tr>'); 
                                         }
//                            $('#proj_list').html('<tr style="border-bottom:none;"><td colspan="6"><p style="text-align:center; padding:150px 0px; font-size:16px;">暂无项目，点击<a href="/new" style="color:#53a4f4;">&nbsp;新建</a></p></td></tr>'); 
                        }else{
                           $('#proj_list').html('<tr style="border-bottom:none;"><td colspan="6"><p style="text-align:center; padding:150px 0px; font-size:16px;">对不起，没有找到你想要的结果</p></td></tr>');  
                       } 
                    }else{
                        $('#proj_list').html('<tr class="thead_td"><td width="42%" class="first">'+_type+'标题</td><td class="tl">收集状态</td><td class="trc">收到数据</td><td class="tl tdcj">创建时间</td><td class="tl">编辑时间</td><td class="last">操作</td></tr>'+html_lb); 
                    }
                    $('#proj_list .tr').each(function(){
                        if($(this).find('.cq_sdsj').text()==0){
                            $(this).find('.last .color').addClass('color_gray').removeClass('color');
                        }
                        if($(this).attr('status')==2){
                            $(this).find('.editor').attr("onclick",'');
                            $(this).find('.editor,.collect_a').addClass('end').attr("href",'javascript:;')
                        }
                        if($(this).attr('oldId')!='null'){ 
                            $(this).find('td').eq(1).html('');
                            $(this).find('td').eq(2).html('');
                            $(this).find('td').eq(3).html('');
                            $(this).find('td').eq(4).html('旧版数据');
                            $(this).find('.last').find('a:last').css({'float':'right','margin-right':'12px'}).prevAll('a').remove();
                        } 
                    });
                    $(".pagenum").createPage({
                        pageCount:data.totalPage,
                        current:page,
                        backFn:function(p){
                            loadMack({off:'on',Limg:1,text:'加载中...',set:1});
                           if(on){
                            on=false;
                            page=p;
                            loaded(p);
                           }
                        } 
                    }); 
                    if(data.totalPage<=1){
                        $('.pagenum').hide();
                    } 
                    on=true;   
                    $('.loadCon,.loadMack').remove();
                },
                error: function () {
                    loadMack({off:'on',Limg:1,text:'网络繁忙，请稍后再试！',set:1});
                } 
            });
        }
    } 
}  
function loaded(page){
    var type=$("#state_sel").find("option:selected").attr("p_type");

    if($('#search_txt').val()!='' && $('#search_txt').val()!='输入标题搜索'){
        txt= encodeURIComponent($('#search_txt').val());
    }else{
        txt='';
    }
    sort=$('#sort_sel').find("option:selected").attr("sort");
    if($('.hzBox').is(':visible')){
        getList('/edit/ajax/list/project_list/',page,'#listHz',type,txt,sort);
    }
    if($('.lbBox').is(':visible')){
        getList('/edit/ajax/list/project_list/',page,'#proj_list',type,txt,sort); 
    }
}
function install(){ 
    loadMack({off:'on',Limg:1,text:'加载中...',set:0});
  //  $('#listHz').html('<li class="create" oldId="null"><a href="/new/"><i></i>新建</a></li>');
     if (p_s_id=="315")
      {
          $('#listHz').html('<li class="create" oldId="null"><a href="/create/"><i></i>新建</a></li>');
     }
     else{
         $('#listHz').html('<li class="create" oldId="null"><a href="/new/"><i></i>新建</a></li>');
     }
    page=1;
    loaded(1);
} 
function saveState(){
    var display_type='',p_type,order=0;
    var leixing = $('.list_tab a.active').index();
    var fenlei=$("#state_sel").find("option:selected").attr("p_type"); 
    var paixu=$("#sort_sel").find("option:selected").attr("sort"); 
    if(leixing==0){
        display_type='block';
    }else{
        display_type='list';
    }
    if(fenlei==0){
        p_type=0;
    }else if(fenlei==1){ 
        p_type=1;
    }else if(fenlei==2){
        p_type=2; 
    }else if(fenlei==3){ 
        p_type=3;
    }
    if(paixu==0){
        order=0;
    }else if(paixu==1){
        order=1;
    }
    var url='';
    var timestamp = new Date().getTime()
    if(p_type==3){
       url ='/edit/ajax/list/settings?display_type='+display_type+'&'+'order='+order+'&t='+timestamp;
    }else{
        url ='/edit/ajax/list/settings?display_type='+display_type+'&'+'p_type='+p_type+'&'+'order='+order+'&t='+timestamp;
    }  
    $.ajax({
        type: 'get',
        url: url, 
        success: function (data) {    
            console.log(data);
        },
        error: function () {
            loadMack({off:'on',Limg:1,text:'网络繁忙，请稍后再试！',set:1});
        } 
    });
}
$(function(){    
    $(document).click(function(){
        $('.dropdown .dropselectbox ul').hide();
    });
    $('.dropdown').live('click',function(e){  
         e.stopPropagation();
    }); 
    $(".list_sel select").sSelect(); 
    $('#search_btn').click(function(){ 
        install();
    });
    $('#search_txt').keyup(function(e){
        if(e.keyCode==13){ 
            install();
        }  
    }); 
    //select
    $('#state_sel,#sort_sel').change(function(){  
        install();
        saveState();
    });
    //tab
    $('.list_tab a').click(function(){ 
        install(); 
        saveState();
    });   
    $(window).scroll(function(){
        var type=$("#state_sel").find("option:selected").attr("p_type"); 
        if($('.hzBox').is(':visible')){
            var top=$(window).scrollTop()+$(window).height();
            var lastTop=0;
            if($('#listHz li').length>0){
                lastTop=$('#listHz li:last').offset().top;
            }else{
                lastTop=$('#listHz').offset().top;
            } 
            if( lastTop <= top ){
                if(on){
                    on=false;
                    page++;
                    loaded(page);
                }
            }
        } 
    }); 
});
function load(){
    var top=0;
    if($('#listHz li').length>0){
        top=$('#listHz li:last').offset().top
    }else{
        top=$('#listHz').offset().top
    }
    if(top<$(window).height()){
        page++;
        loaded(page)
    } 
}
