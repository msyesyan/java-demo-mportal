<%@ page pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/layouts/application_head.jsp" %>
		<h1>增加频道</h1>
		
		<form method="post" enctype="multipart/form-data" action="<s:url value='/admin/channels/create' />">
			<%@ include file="_form.jsp" %>
			
			<div class="control-group">
				<div class="controls">
					<button type="submit" class="btn">增加</button>
				</div>
			</div>
		</form>
<%@ include file="/WEB-INF/views/layouts/application_foot.jsp" %>