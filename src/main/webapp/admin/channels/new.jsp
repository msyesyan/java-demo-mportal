<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>编辑频道信息</title>
	<link href="../../css/bootstrap.min.css" rel="stylesheet">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
	<script src="../../js/myjs.js" type="text/javascript"></script>
	<script src="../../js/bootstrap.min.js"></script>
</head>
<body>
	<div class="navbar navbar-inverse navbar-static-top">
			<div class="navbar-inner">
				<div class="container">
					<ul class="nav">
						<li><a class="brand" href="#">增加频道</a></li>
					</ul>
				</div>
			</div>
	</div>
	
	
	<form class="form-horizontal">
    	<div class="control-group">
    		<label class="control-label" for="inputEmail">Email</label>
   		 	<div class="controls">
   				 <input type="text" id="inputEmail" placeholder="Email">
			</div>
    	</div>
    	<div class="control-group">
    		<label class="control-label" for="inputPassword">Password</label>
    			<div class="controls">
    				<input type="password" id="inputPassword" placeholder="Password">
    			</div>
    	</div>
    	<div class="control-group">
    		<div class="controls">
    			<label class="checkbox">
    				<input type="checkbox"> Remember me
    			</label>
    	<button type="submit" class="btn">Sign in</button>
    </div>
    </div>
    </form>
	
	
	
	<form id="form" method="post" action="/admin/channels/new">
    	<label>频道名称</label><input type="text" name="name"/><br>
		<label>频道号</label><input type="text" name="num"/><br>
		<label>频道logo</label><input type="text" name="logoUrl"/><br>
    	<button type="submit" class="btn">增加</button>
    </form>
</body>
</html>