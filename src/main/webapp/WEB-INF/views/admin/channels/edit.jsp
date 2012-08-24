<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>编辑频道信息</title>
	<link href="../../css/bootstrap.css" rel="stylesheet">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.js"></script>
	<script src="../../js/myjs.js" type="text/javascript"></script>
	<script src="../../js/bootstrap.js"></script>
</head>
<body>
	<div class="navbar navbar-inverse navbar-static-top">
			<div class="navbar-inner">
				<div class="container">
					<ul class="nav">
						<li><a class="brand" href="#">频道编辑</a></li>
					</ul>
				</div>
			</div>
	</div>
	<form id="form" method="post" action="/admin/channels/edit">
    	<label>频道名称</label><input type="text" name="name"/><br>
		<label>频道号</label><input type="text" name="num"/><br>
		<label>频道logo</label><input type="text" name="logoUrl"/><br>
    	<input type="hidden" value="${id}" name="id"/>
    	<button type="submit" class="btn">提交</button>
    </form>
</body>
</html>