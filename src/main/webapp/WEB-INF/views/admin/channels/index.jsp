<%@ page pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/layouts/application_head.jsp" %>
			<h1>频道列表</h1>
			
			<table class="table table-bordered">
    			<thead>
    				<tr>
    					<th>频道名称</th>
    					<th>频道号</th>
    					<th>所属类别</th>
    					<th></th>
    				</tr>
    			</thead>
    			<tbody>
   					<s:iterator value="channels">
   					<tr>
   						<td>${name}</td>
   						<td>${num}</td>
   						<td>所属类别</td>
   						<td>
   							<a class="btn" href="edit?id=${id}">编辑</a>
							<form method="post" action="<s:url value='/admin/channels/destroy' />" style="display: inline">
								<input type="hidden" name="id" value="${id}"/>
								<input type="submit" class="btn" value="删除"/>
							</form>    							
   						</td>
   					</tr>
   					</s:iterator>
    			</tbody>
    		</table>
    		
    		<div class="well">
    			<a class="btn btn-primary" href="new">新增频道</a>
			</div>
    		
<%@ include file="/WEB-INF/views/layouts/application_foot.jsp" %>