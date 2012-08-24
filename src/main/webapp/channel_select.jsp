<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<select  id="category_select" multiple="multiple" size="2">
	<s:iterator value="categorys">
		<option value="${categoryId}">${categoryName }</option>		
	</s:iterator>
</select>