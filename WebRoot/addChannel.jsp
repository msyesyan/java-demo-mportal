<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>编辑频道信息</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<SCRIPT type="text/javascript">
	$(function(){
		$('#category_select').change(function(){
					//alert("hello");
					var optionarray = $("#category_select option:selected");
					$("#category_name").html();
					var str = "";
					for(i = 0;i<optionarray.length;i++){
						str = str+$(optionarray.get(i)).val()+"&";
					}
					$("#category_name").val(str);
				});
	});
	
	function addResource(){
		$("#firstSelect").next().next().next().after("<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select class='sourceSelect'><option>hls</option><option>http</option></select>&nbsp;资源地址<input/>");
	}
	
	function allResource(){
		$("#resource").val();
		var sourceArray = $(".sourceSelect");
		var str = "";
		for(i = 0;i<sourceArray.length;i++){
			str = str+$(sourceArray.get(i)).val()+"#"+$(sourceArray.get(i)).next().val()+"-";
		}
		$("#resource").val(str);
	}
</SCRIPT>
</head>
<body>

	<form id = "form" method ="post" action="api/AddChannel.action">
		频道Id<input type="text" name="id"/><br>
		频道名称<input type="text" name="name"/><br>
		
		频道类别 <input id="category_name" type="text" name="categoryName"/>
			<div>
				<s:action name="CategorySelect" namespace="/api" executeResult="true"></s:action>
			</div>
		频道号     <input type="text" name="num"/><br>
		频道logo<input type="text" name="logoUrl"/><br>
		资源类型<input id="resource" type="text" name="resourceTU" readonly/><br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<select id="firstSelect" class="sourceSelect">
			<option>hls</option>
			<option>http</option>
		</select>&nbsp;资源地址<input/><input type="button" value="+" onclick="addResource();">&nbsp<input type="button" value="OK" onclick="allResource();"><br>
		节目地址<input type="text" name="programsEndPoint"/><br>
		
		<input type="submit" value="增加"/>
	</form>
</body>
</html>