function MailAutoComplete(Obj){
	this.index=-1;
	this.val='';
	this.input=$();
	if(!Obj){Obj={}}
	this.Tinfo = {
		 obj:Obj.obj,
		 autoClass:Obj.autoClass || true,
		 mailArr:Obj.mailArr || ['qq.com','163.com','126.com','sina.com','gmail.com','139.com','21cn.com','sohu.com','hotmail.com','outlook.com'] //邮件数组
	 };
	 
	 //创建下拉框
	 this.mailCon=function(newArr,v){
		 if(newArr.length<=0){$('.justForJs').remove(); return;}
		 $('.justForJs').remove();
		 var nObj = this.Tinfo.obj;
		 var nObjPadding_TB = parseFloat(nObj.css('paddingTop'))+ parseFloat(nObj.css('paddingBottom'));
		 var nObjPadding_LR = parseFloat(nObj.css('paddingLeft'))+ parseFloat(nObj.css('paddingRight'));
		 this.mail={
			 w:nObj.width()+nObjPadding_LR,
			 t:nObj.offset().top+nObj.height()+5+nObjPadding_TB,
			 l:nObj.offset().left
		 } 
         
		 this.Con = $('<div class="justForJs" id="'+this.sjs+'" style="z-index:999;min-width:'+this.mail.w+'px;_width:'+this.mail.w+'px;position:absolute;top:'+this.mail.t+'px;left:'+this.mail.l+'px;">'+this.createHtml(newArr,v)+'</div>');	 
		 $('body').append(this.Con);
	 }
	 
	 //生成提示内容
	 this.createHtml = function(arr,str){
		var mailHtml = "";

		for(var i=0;i<arr.length;i++){
		   mailHtml += '<div class="mailHover list_box" id="mailList_'+i+'"><span class="">'+str+'</span>@'+arr[i]+'</div>';
		};
		return mailHtml;
	 };
	 this.show=function(){
		this.sjs = "at"+Math.floor(Math.random()*10000);
		this.Tinfo.obj.addClass(this.sjs);
		var this_=this;
		//页面装载CSS样式
		if(this.Tinfo.autoClass && $("#mailListAppendCss").size() === 0){
		$('<style id="mailListAppendCss" type="text/css">.justForJs{opacity:0.95;background-color:#fff;border:1px solid #ccc;}.list_box {color:#333;cursor: pointer;padding:5px;}.mail_focus{background-color: #E6E6E6;}</style>').appendTo($("head"));
		}
		  
		  //监听键盘响应
		  this.Tinfo.obj.focus(function(){

				  var newArr =[];
				  this_.index = -1;
				  //键盘事件
				  $(this).keyup(function(e){
				  this_.val = v = $(this).val().replace(/[ ]/g,"");
				  
				  if(v.length > 0){
						//如果按键是上下键
						if(e.keyCode === 38){
							//向上
							if(this_.index <= 0){
								this_.index = newArr.length;	
							}
							this_.index--;
						}else if(e.keyCode === 40){
							//向下
							if(this_.index >= newArr.length - 1){
								this_.index = -1;
							}
							this_.index++;
						}else if(e.keyCode === 13){
							//回车
							if(this_.index > -1 && this_.index < newArr.length){
								//如果当前有激活列表
								$(this).val($("#mailList_"+this_.index).text());	
								$('.justForJs').remove();
								this_.index=-1;
							}
						}else{
							//if(/@/.test(v)){
							if(/^([a-zA-Z0-9]+[\_|\.]?)*[a-zA-Z0-9]+@{1}(\w+)?(\.)?(com|cn|c|co)?$/.test(v)){
								
								//获得@后面的值
								s = v.split('@')[0];
								//创建新匹配数组
								var site = v.replace(/.*@/,"");
								
								newArr = $.map(this_.Tinfo.mailArr,function(n){
									var reg = null;
									eval("var reg = /^" + site + "/");
									if(reg.test(n)){
										return n;	
									}
								});
								
								this_.mailCon(newArr,s);
							}else{
								newArr = this_.Tinfo.mailArr;
								$('.justForJs').remove();
							}
						}
						if(this_.index!==-1){
						   $('.mailHover').removeClass('mail_focus');
						   $('.mailHover',this_.Con).eq(this_.index).addClass('mail_focus');	
						}
						
				  }else{
					  $('.justForJs').remove();
				  }
				  
				  
				});
				
			//失去焦点初始化  
			}).blur(function(){
				
				this_.index=-1;
				$(this).unbind('keyup');
			   $('.justForJs').remove();
		 });	
		  
		  //鼠标操作事件
		  $('.mailHover','#'+this.sjs).live('mouseover',function(){
			   $(this).addClass('mail_focus');
			   this_.index = Number($(this).attr("id").split("_")[1]);
		  });
		  $('.mailHover','#'+this.sjs).live('mouseout',function(){
			   $(this).removeClass('mail_focus');
		  });
		  $(".mailHover",'#'+this.sjs).live("mousedown",function(){
			   $('.'+this_.sjs).val($("#mailList_"+this_.index).text());
			   this_.index =-1;
		  });
		  
	 } 	 
	 return this.show();
 }