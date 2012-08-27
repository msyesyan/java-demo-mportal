<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div class="control-group">
	<label class="control-label" for="inputname">名称</label>
	<div class="controls">
		<input type="text" id="inputname" name="channel.name" value="${channel.name}" />
	</div>
</div>
<div class="control-group">
	<label class="control-label" for="inputNum">频道号</label>
	<div class="controls">
		<input type="text" id="inputNum" name="channel.num" value="${channel.num}" />
	</div>
</div>
<div class="control-group">
	<label class="control-label" for="inputNum">分类</label>
	<div class="controls">
		<select multiple="multiple" name="categoryIds">
			<s:iterator value="%{categoryService.findAll()}" var="category">
				<s:if test="%{#category.id in channel.categoryIds}">
					<option value="${category.id}" selected="selected">${category.name}</option>
				</s:if>
				<s:else>
					<option value="${category.id}">${category.name}</option>
				</s:else>
			</s:iterator>
		</select>
	</div>
</div>
<div class="control-group">
	<label class="control-label" for="inputLogo">台标</label>
	<div class="controls">
		<input type="file" id="inputLogo" name="logo" />
	</div>
	<div class="controls">
		<img src="<s:url value='/upload/logo/' />${channel.logo }"/>
	</div>
</div>