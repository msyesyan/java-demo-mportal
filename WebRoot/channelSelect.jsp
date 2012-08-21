<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<select id="channel_select" multiple="multiple" size="2">
	<s:iterator value="channels">
		<option value="${channelId}">${name}</option>		
	</s:iterator>
</select>