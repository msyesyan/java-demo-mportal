<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>节目列表</title>
		<link href="<s:url value="../../css/bootstrap.css"/>" rel="stylesheet" />
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
		<script src="../../js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="navbar navbar-inverse navbar-static-top">
    		<div class="navbar-inner">
    			<div class="container">
					<a class="brand" href="#">直播管理系统</a>
    				<ul class="nav">
						<li><a href="/admin/channels/index">频道管理</a></li>
						<li class="active"><a href="/admin/categorys/index">类别管理</a></li>
   					 </ul>
				</div>
    		</div>
    	</div>
		<div class="container">
			<h1>类别列表</h1>
			
			<table class="table table-bordered">
    			<thead>
    				<tr>
    					<th>类别名称</th>
    					<th></th>
    				</tr>
    			</thead>
    			<tbody>
   					<s:iterator value="categories">
   					<tr>
   						<td>${name}</td>
   						<td>
   							<a class="btn" href="edit?id=${id}">编辑</a>
							<form method="post" action="/admin/categories/destroy" style="display: inline">
								<input type="hidden" name="id" value="${id}"/>
								<input type="submit" class="btn" value="删除"/>
							</form>
   						</td>
   					</tr>
   					</s:iterator>
    			</tbody>
    		</table>
    		
    		<div class="well">
    			<a class="btn btn-primary" href="new">新增类别</a>
			</div>
    		
		</div>
	</body>
</html>