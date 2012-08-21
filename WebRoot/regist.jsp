<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户注册</title>
</head>
<body>
	<form method ="post" action="api/Regist.action">
		用户名<input type="text" name="user.name"/>
		密码<input type="password" name="user.password"/>
		<input type="submit" value="注册">
	</form>
</body>
</html>