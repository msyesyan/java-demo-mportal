<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/bootstrap.css" rel="stylesheet">
<title>用户登录</title>
</head>
<body>
	<div class="navbar navbar-inverse navbar-static-top">
			<div class="navbar-inner">
				<div class="container">
					<ul class="nav">
						<li><a class="brand" href="#">用户登录</a></li>
					</ul>
				</div>
			</div>
	</div>
	<form class="form-horizontal" style="margin-left:9%;padding-top:3%;" method ="post" action="login">
    	<div class="control-group">
    		<label class="control-label" for="inputEmail">姓名</label>
   		 	<div class="controls">
   				 <input type="text" id="inputEmail" name="name" value="${name }" placeholder="name">
			</div>
    	</div>
    	<div class="control-group">
    		<label class="control-label" for="inputPassword">密码</label>
    			<div class="controls">
    				<input type="password" id="inputPassword" name="password" placeholder="Password">
    			</div>
    	</div>
    	<div class="control-group">
    		<div class="controls">
    			<label class="checkbox">
    				<input type="checkbox"> 记住我
    			</label>
    			<button type="submit" class="btn">登录</button>
    		</div>
    	</div>
    </form>
</body>
</html>