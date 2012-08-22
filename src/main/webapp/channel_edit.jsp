<!DOCTYPE HTML>
<!-- 
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
 -->
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>频道节目编辑</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script>
	$(function(){
		$("#channel_select").change(function(){
			var arr = $("#channel_select option:selected");
			var str = "";
			$("#channelId").val();
			for(i = 0;i<arr.length;i++){
				str = str+$(arr.get(i)).val()+"&";
			}
			$("#channelId").val(str);
		});
	});
</script>
</head>
<body>
	<form method="post" action="api/AddEvent.action">
		频道<input id="channelId" name="channelIdString" readonly/>
		<div>
				<s:action name="ChannelSelect" namespace="/api" executeResult="true"></s:action>
		</div>
		节目开始时间<input name="beginTime"/><br>
		节目持续时间<input name="duration"/><br>
		节目ID<input name="id"><br>
		节目类型<input name="type"><br>
		EgpTextLanguage<input name="language"/><br>
		EgpTextName<input name="name"/><br>
		EgpTextShortDescription<input name="shortDescription"/><br>
		<input type="submit" value="添加"/>
		
	</form>
</body>
</html>