<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="<c:url value='/static/ibatis/css/bootstrap.min.css' /> " />
		<link rel="stylesheet" href="<c:url value='/static/ibatis/css/bootstrap-theme.min.css' /> " />
		<link rel="stylesheet" href="<c:url value='/static/ibatis/css/custom/default.css' /> " />
		<title>ibatis 代码生成工具</title>
	</head>
	<body>
		<nav class="navbar navbar-inverse"> <!-- nav start -->
			<div class="container">
				<div class="navbar-header">
				<ul class="btn-group">
				  <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				    系统 <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu">
				    <li><a href="#" data-toggle="modal" data-target="#createConn">新建连接</a></li>
				    <li><a href="#">打开目录</a></li>
				    <li class="dropDown dropDown_hover">
						<a class="dropDown_A" href="#"> 历史记录 </a>
							<span class="dropDown-menu menu-left box-shadow">
								<div>
									<c:forEach items="${history}" var="conn">
										<div id="${conn.connName}"><a href="#">${conn.connName}</a></div>
									</c:forEach>
								</div>
							</span>
					</li>
				    <li role="separator" class="divider"></li>
				    <li><a href="#">清空历史</a></li>
				  </ul>
				</div>
				<div class="btn-group">
				  <button type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				    设置 <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu">
				    <li><a href="#" data-toggle="modal" data-target="#set">系统设置</a></li>
				  </ul>
				</div>
				<div class="btn-group">
				  <button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				    帮助 <span class="caret"></span>
				  </button>
				</div>
				</div>
			</div>
		</nav><!-- nav end -->
		
		<div class="container-fluid">
			<div class="col-md-4">
				<button id="getTable" type="button" class="btn btn-warning btn-lg center-block">
					<span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span> 获取表
				</button>
				<form id="generateForm" action="#">
					<div class="panel panel-info vertical-distance-1 fix-height-1">
					  	<div class="panel-heading">
					    	<h3 class="panel-title">数据库表</h3>
					  	</div>
						<select id="tables" name="selections" multiple class="form-control fix-height-2">
	
						</select>
					</div>
					<div class="input-group">
						<span class="input-group-addon alert-danger" id="basic-addon1">基本类包名</span>
						<input id="packageName" type="text" name="packageName" value="com.hujianbin.basis" class="form-control" placeholder="基础类包名" aria-describedby="basic-addon1">
					</div>
					<div class="input-group vertical-distance-1">
						<span class="input-group-addon alert-danger" id="basic-addon2">公共类包名</span>
						<input id="importStr" type="text" name="commonPackage" value="com.hujianbin.common" class="form-control" placeholder="公共类包名" aria-describedby="basic-addon1">
					</div>										
					<div class="input-group vertical-distance-1">
						<span class="input-group-addon alert-danger" id="basic-addon3">存储的路径</span>
						<input id="dirPath" type="text" name="dirPath" value="d:\gen" class="form-control" placeholder="路径" aria-describedby="basic-addon1">
						<a class=" btn input-group-addon">选择...</a>
					</div>
					<button id="generate" type="button" class="btn btn-success btn-lg center-block vertical-distance-1">
						<span class="glyphicon glyphicon-floppy-save" aria-hidden="true"></span> 生成代码
					</button>
				</form>				
			</div>
			<div class="col-md-8">
				<ul class="nav nav-tabs nav-justified">
					<li role="presentation" class="active"><a href="#home" data-toggle="tab">说明</a></li>
					<li role="presentation"><a href="#action" data-toggle="tab">Action</a></li>
					<li role="presentation"><a href="#service" data-toggle="tab">Service</a></li>
					<li role="presentation"><a href="#serviceImpl" data-toggle="tab">ServiceImpl</a></li>
					<li role="presentation"><a href="#dao" data-toggle="tab">Dao</a></li>
					<li role="presentation"><a href="#daoImpl" data-toggle="tab">DaoImpl</a></li>
					<li role="presentation"><a href="#bean" data-toggle="tab">Bean</a></li>
					<li role="presentation"><a href="#searchBean" data-toggle="tab">SearchBean</a></li>
					<li role="presentation"><a href="#sqlMap" data-toggle="tab">SqlMap</a></li>
					<li role="presentation"><a href="#structs2" data-toggle="tab">Structs2</a></li>
				</ul>
				<div class="tab-content">
				  	 <div class="tab-pane fade in active" id="home">
				  	 	<h4>帮助说明：</h4>
						<p>第1步，连接数据库</p>
						<p>第2步，获取表</p>
						<p>第3步，选择要生成对应代码的表</p>
						<p>第4步，修改包名和选择文件保存路径</p>
				  	 </div>
				 	 <div class="tab-pane fade" id="action">
				 		<c:out value="${data.actionStr }" escapeXml="false" />
				 	 </div>
				 	 <div class="tab-pane fade" id="service">
				 	 	<c:out value="${data.serviceStr }" escapeXml="false" />
				 	 </div>
				  	 <div class="tab-pane fade" id="serviceImpl">
				  	 	<c:out value="${data.serviceImplStr }" escapeXml="false" />
				  	 </div>
				 	 <div class="tab-pane fade" id="dao">
				 	 	<c:out value="${data.daoStr }" escapeXml="false" />
				 	 </div>
				  	 <div class="tab-pane fade" id="daoImpl">
				  	 	<c:out value="${data.daoImplStr }" escapeXml="false" />
				  	 </div>		
				 	 <div class="tab-pane fade" id="bean">
				 	 	<c:out value="${data.beanStr }" escapeXml="false" />
				 	 </div>
				  	 <div class="tab-pane fade" id="searchBean">
				  	 	<c:out value="${data.searchBeanStr }" escapeXml="false" />
				  	 </div>
				 	 <div class="tab-pane fade" id="sqlMap">
				 	 	<c:out value="${data.mapStr }"  />
				 	 </div>
				  	 <div class="tab-pane fade" id="structs2">
				  	 	<c:out value="${data.struts2Str }"  />
				  	 </div>					  	 
				</div>					
			</div>
		</div>
		
		<!-- Modal for createConn start -->
		<div class="modal fade" id="createConn" tabindex="-1" role="dialog" aria-labelledby="createConnlLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="createConnlLabel">新建连接</h4>
					</div>
					<div class="modal-body">
						<div id="msg" class="alert alert-warning alert-dismissible hidden" role="alert">
						  	<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						 	<strong><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span></strong>
						 	<span id="msgContent"></span> 
						</div>	
						<form id="connForm" action="">
							<div class="form-group form-inline">
								<label for="connName" class="fix-width-1">名 称 </label>
								<input id="connName" name="connName" type="text" class="form-control width-80" placeholder="连接名称" />
							</div>
							<div class="form-group form-inline">
								<label for="dbtype" class="fix-width-1">数据库类型</label>
								<select id="dbType" name="dbType" class="form-control width-80">
									<option value="-1">请选择数据库</option>
									<option value="0">MySQL</option>
									<option value="1">MSSQLServer</option>
									<option value="2">Oracle</option>
									<option value="3">PostgreSQL</option>
									<option value="4">H2</option>
								</select>
								<input id="driver" name="driver" type="hidden" />
								<input id="mapend" name="mapend" type="hidden" />
							</div>
							<div class="form-group form-inline">
								<label for="url" class="fix-width-1">URL </label>
								<input id="url" name="url" type="text" class="form-control width-80" placeholder="URL" />
							</div>
							<div class="form-group form-inline">
								<label for="username" class="fix-width-1">用 户 名</label>
								<input id="username" name="username" type="text" class="form-control width-80" placeholder="用户名" />
							</div>
							<div class="form-group form-inline">
								<label for="password" class="fix-width-1">密 码 </label>
								<input id="password" name="password" type="password" class="form-control width-80" placeholder="密码" />
							</div>	
						</form>					
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-warning" data-dismiss="modal">关 闭</button>
						<button id="save" type="button" class="btn btn-success">保 存</button>
						<button id="test" type="button" class="btn btn-info">应 用</button>
					</div>
				</div>
			</div>
		</div><!-- Modal for createConn end -->
		
		<!-- Modal for set start -->
		<div class="modal fade" id="set" tabindex="-1" role="dialog" aria-labelledby="setLabel">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="setLabel">系统设置</h4>
					</div>
					<div class="modal-body">
						<div class="container-fluid">
							<div class="row">
								<div class="col-md-6">
									<div class="form-group form-inline">
										<label for="dbtype" class="fix-width-2">字符集</label>
										<select class="form-control">
											<option>UTF-8</option>
											<option>GBK</option>
										</select>										
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group form-inline">
										<label for="name" class="fix-width-2">大小写转换</label>
									    <label class="checkbox-inline">
									      <input type="radio" name="optionsRadiosinline" id="optionsRadios3" 
									         value="1"> 是
									    </label>
									    <label class="checkbox-inline">
									       	<input type="radio" name="optionsRadiosinline" id="optionsRadios4" 
									         value="0" checked> 否
									    </label>
									</div>										
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group form-inline">
										<label for="pre" class="fix-width-2">表前缀</label>
										<input id="pre" name="pre" value="t_" type="text" class="form-control"  />
									</div>									
								</div>
								<div class="col-md-6">
									<div class="form-group form-inline">
										<label for="divide" class="fix-width-2">表分割</label>
										<input id="divide" name="divide" value="_" type="text" class="form-control"  />
									</div>									
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group form-inline">
										<label for="coldivide" class="fix-width-2">列分割</label>
										<input id="coldivide" name="coldivide" value="_" type="text" class="form-control"  />
									</div>										
								</div>
								<div class="col-md-6">
									<div class="form-group form-inline">
										<label for="cache" class="fix-width-2">缓存类型</label>
										<input id="cache" name="cache" value="LRU" type="text" class="form-control"  />
									</div>										
								</div>
							</div>	
							<div class="row">
								<div class="col-md-8">
									<div class="form-group form-inline">
										<label for="import" class="fix-width-2">引入类</label>
										<input id="import" name="import" value="com.***.common" type="text" class="form-control width-80"  />
									</div>										
								</div>								
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-warning" data-dismiss="modal">取 消</button>
						<button type="button" class="btn btn-success">保 存</button>
					</div>
				</div>
			</div>
		</div><!-- Modal for set end -->
		
		<!-- Modal for errorInfo start -->
		<div class="modal fade" id="errorInfo" tabindex="-1" role="dialog" aria-labelledby="errorInfoLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="errorInfoLabel">提示</h4>
					</div>
					<div class="modal-body">
						<div class="alert alert-warning alert-dismissible" role="alert">
						 	<strong><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span></strong>
						 	<span id="errorMsg"></span> 
						</div>						
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" data-dismiss="modal">关 闭</button>
					</div>
				</div>
			</div>
		</div><!-- Modal for errorInfo end -->		
		<script type="text/javascript" src="<c:url value='/static/ibatis/js/jquery.min.js' /> "></script>
		<script type="text/javascript" src="<c:url value='/static/ibatis/js/bootstrap.min.js' /> "></script>
		<script type="text/javascript" src="<c:url value='/static/ibatis/js/dropDown.js' /> "></script>
		<script>
			//按照dbType类型菜单顺序定义驱动数组，连接url模板
			var drivers = ["com.mysql.jdbc.Driver",
			               "net.sourceforge.jtds.jdbc.Driver",
			               "oracle.jdbc.driver.OracleDriver",
			               "org.postgresql.Driver",
			               "org.h2.Driver"];
			var urls = ["jdbc:mysql://<host>:3306/<database>",
						"jdbc:jtds:sqlserver://<host>:1433;DatabaseName=<database>",
						"jdbc:oracle:thin:@<host>:1521:<sid>",
						"jdbc:postgresql://<host>:5432/<database>",
						"jdbc:h2:tcp://<host>/<dir>/<database>"];
			//数据库类型变化改变url连接模板和驱动
			$("#dbType").change(function(){
				var index = $("#dbType").val();
				$("#driver").val(drivers[index]);
				$("#url").val(urls[index]);
				$("#mapend").val($("#dbType option:selected").text());
			});

			//保存当前连接
			$("#save").click(function(){
				if(validateConnForm()){
					$.ajax({
						url: '<c:url value="/tools/ibatis/saveConn.json" />',
						type: 'post',
						data: $("#connForm").serialize(),
						dataType: 'json',
						success: function(data){
							$("#msg").removeClass("hidden");
							$("#msgContent").text(data.msg);
						}
					});
				}else{
					$("#msg").removeClass("hidden");
					$("#msgContent").text(msg);
				}
			});
			
			//应用当前连接
			$("#test").click(function(){
				if(validateConnForm()){
					$.ajax({
						url: '<c:url value="/tools/ibatis/checkConn.json" />',
						type: 'post',
						data: $("#connForm").serialize(),
						dataType: 'json',
						success: function(data){
							$("#msg").removeClass("hidden");
							$("#msgContent").text(data.msg);
						}
					});					
				}else{
					$("#msg").removeClass("hidden");
					$("#msgContent").text(msg);
				}
			});
			var msg;
			function validateConnForm(){
				var connName = $("#connName").val();
				var url = $().val("#url");
				var username = $("#username").val();
				var dbType = $("#dbType").val();
				var password = $("#password").val();
				if(connName == null || connName == ''){
					msg = "请填写连接名称";
				}else if(dbType == -1){
					msg = "请选择数据库";
				}else if(url == null || url == ''){
					msg = "请填写url";
				}else if(username == null || username == ''){
					msg = "请填写用户名";
				}else if(password == null || password == ''){
					msg = "请填写密码";
				}
				if(msg == null || msg == ''){
					return true;
				}
				return false;
			}
			
			$("#getTable").click(function(){
				$.ajax({
					url: '<c:url value = "/tools/ibatis/getTableList.json" />',
					type: 'post',
					success: function(data){
						if(data.code == 200){
							$("#tables").empty();
							var element = "";
							for(var i=0; i < data.tableList.length; i++){
								element += "<option value="+data.tableList[i]+">" + data.tableList[i] + "</option>";
							}
							$("#tables").append(element);							
						}else {
							$("#errorInfo").modal('show');
							$("#errorMsg").text(data.msg);
						}
					}
				});
			});
			
			var errorMsg;
			function validateGenerateForm(){
				errorMsg = '';
				var tables = $("#tables option:selected").text();
				var packageName = $("#packageName").val();
				var dirPath = $("#dirPath").val();
				if(tables == null || tables == ''){
					errorMsg = "请选择表";
				}else if(packageName == null || packageName == ''){
					errorMsg = "请填写包名";
				}else if(dirPath == null || dirPath == ''){
					errorMsg = "请填写生成路径";
				}
				if(errorMsg == null || errorMsg == ''){
					return true;
				}
				return false;
			}
			
			$("#generate").click(function(){
				if(validateGenerateForm()){
					$.ajax({
						url: '<c:url value = "/tools/ibatis/generate.json" />',
						type:'post',
						data: $("#generateForm").serialize(),
						success: function(data){
							$("#errorInfo").modal('show');
							$("#errorMsg").text(data.msg);
						}
					});
				}else{
					$("#errorInfo").modal('show');
					$("#errorMsg").text(errorMsg);
				}
			});

			$.each(${historyJson},function(n,value){
				$("#"+value.connName).click(function(){
					$("#connName").val(value.connName);
					$("#driver").val(value.driver);
					$("#url").val(value.url);
					$("#username").val(value.username);
					$("#password").val(value.password);
					$("#dbType").val(value.dbType);
					$.ajax({
						url: '<c:url value="/tools/ibatis/checkConn.json" />',
						type: 'post',
						data: $("#connForm").serialize(),
						dataType: 'json',
						success: function(data){
						}
					});
				});
			});
		</script>
	</body>
</html>
