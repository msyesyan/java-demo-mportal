<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<select id="channel_select" multiple="multiple" size="2">
	<s:iterator value="channels">
		<option value="${channelId}">${name}</option>		
	</s:iterator>
</select>