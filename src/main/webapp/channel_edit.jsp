<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>频道节目编辑</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script src="js/myjs.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
<form method ="post" action="AddEvent.action">
    	<label>频道</label><input id="channelId" name="channelIdString"/>
    	<div>
				<s:action name="ChannelSelect" namespace="/" executeResult="true"></s:action>
		</div>
    	<label>节目开始时间</label><input name="beginTime"/>
		<label>节目持续时间 </label><input name="duration"/>
		<label>节目ID</label><input name="id">
		<label>节目类型</label><input name="type">
		<label>EgpTextLanguage</label><input name="language"/>
		<label>EgpTextName</label><input name="name"/>
		<label>EgpTextShortDescription</label><input name="shortDescription"/><br>
    	<button type="submit" class="btn">增加</button>
    	<input type="button" onclick="document.location='channel_list.jsp'" class="btn" value="返回"/> 
    </form>
</body>
</html>