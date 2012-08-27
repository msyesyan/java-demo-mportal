<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div class="input">
	<s:textfield label="名称"  name="channel.name" />
</div>

<div class="input">
	<s:textfield label="频道号"  name="channel.num" />
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
	<s:if test="%{#channel.logo == null}">
	</s:if>
	<s:else>
		<div class="controls">
			<img src="<s:url value='/upload/logo/' />${channel.logo}"/>
		</div>
	</s:else>
</div>