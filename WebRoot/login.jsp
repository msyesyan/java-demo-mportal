<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户登录</title>
</head>
<body>
	<form method ="post" action="api/Login.action">
		用户名<input type="text" name="name"/>
		密码<input type="password" name="password"/>
		<input type="submit" value="登录">
	</form>
</body>
</html>