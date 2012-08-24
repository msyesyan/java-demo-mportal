<%@ page pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/layouts/application_head.jsp" %>
		<h1>编辑频道</h1>
		
		<form method="post" action="<s:url value='/admin/channels/edit' />">
			<%@ include file="_form.jsp" %>
			
			<div class="control-group">
				<div class="controls">
					<input type="hidden" name="id" value="${id}" />
					<button type="submit" class="btn">增加</button>
				</div>
			</div>
		</form>
<%@ include file="/WEB-INF/views/layouts/application_foot.jsp" %>