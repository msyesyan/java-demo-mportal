<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>编辑频道信息</title>
	<link href="../../css/bootstrap.css" rel="stylesheet">
	<script src="../../js/bootstrap.js"></script>
</head>
<body>
	<div class="navbar navbar-inverse navbar-static-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="brand" href="#">直播管理系统</a>
				<ul class="nav">
					<li class="active"><a href="/admin/channels/index">频道管理</a></li>
					<li><a href="/admin/categories/index">类别管理</a></li>
				</ul>
			</div>
		</div>
	</div>
	
	<div class="container">
		<h1>增加频道</h1>
		
		<form class="form-horizontal" method="post" action="/admin/channels/new">
			<div class="control-group">
				<label class="control-label" for="inputname">名称</label>
				<div class="controls">
					<input type="text" id="inputname" placeholder="name" name="name"/>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputNum">频道号</label>
				<div class="controls">
					<input type="text" id="inputNum" placeholder="num" name="num" />
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputLogo">台标</label>
				<div class="controls">
					<input type="text" id="inputLogo" placeholder="logo" name="logoUrl" />
				</div>
			</div>
			
			<div class="control-group">
				<div class="controls">
					<button type="submit" class="btn">增加</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>