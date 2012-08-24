<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/bootstrap.min.js"></script>
<title>用户注册</title>
</head>
<body>
	<form method ="post" action="Regist.action">
    	<div class="control-group success">
			<label class="control-label" for="inputSuccess">用户名</label>
				<div class="controls">
    				<input type="text" id="inputSuccess" name="user.name">
     			</div>
    		<label class="control-label" for="passwordSuccess">密码</label>
    			<div class="controls">
   					 <input type="password" id="passwordSuccess" name="user.password">
    			</div>
    	</div>
    	<button type="submit" class="btn">增加</button> 
    </form>
</body>
</html>