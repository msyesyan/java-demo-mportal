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
					var optionarray = $("select option:selected");
					$("#category_name").html();
					var str = "";
					for(i = 0;i<optionarray.length;i++){
						str = str+$(optionarray.get(i)).val()+"&";
					}
					$("#category_name").val(str);
				});
	});
</SCRIPT>
</head>
<body>
	<form method ="post" action="api/AddChannel.action">
		频道Id<input type="text" name="id"/><br>
		频道名称<input type="text" name="name"/><br>
		
		频道类别 <input id="category_name" type="text" name="categoryName"/>
			<div>
				<s:action name="CategorySelect" namespace="/api" executeResult="true"></s:action>
			</div>
		频道号     <input type="text" name="num"/><br>
		频道logo<input type="text" name="logoUrl"/><br>
		资源类型<input type="text" name="resourcesType"/><br>
		资源地址<input type="text" name="resoucesUrl"/><br>
		节目地址<input type="text" name="programsEndPoint"/><br>
		
		<input type="submit" value="增加"/>
	</form>
</body>
</html>