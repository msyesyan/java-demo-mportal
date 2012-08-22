<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>节目列表</title>
		<link href="css/category.css" rel="stylesheet" type="text/css" />
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
	</head>
	<body>
		&nbsp;
			<div>
				<s:action name="FindCategory" namespace="/api" executeResult="true"></s:action>
			</div>
		<input type="button" value="增加频道" onclick="document.location='/mportal/addChannel.jsp'"/>
		<input type="button" value="增加节目" onclick="document.location='/mportal/channel_edit.jsp'"/>
	</body>
</html>