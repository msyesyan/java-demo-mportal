<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<select  id="category_select" multiple="multiple" size="2">
	<s:iterator value="categorys">
		<option value="${categoryId}">${categoryName }</option>		
	</s:iterator>
</select>