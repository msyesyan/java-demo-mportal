<%@ page pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/layouts/application_head.jsp" %>
	<h1>用户登录</h1>
	
	<form method ="post" action="login">
    	<div class="control-group">
    		<label class="control-label" for="inputEmail">姓名</label>
   		 	<div class="controls">
   				 <input type="text" id="inputEmail" name="name" value="${name }" placeholder="name">
			</div>
    	</div>
    	<div class="control-group">
    		<label class="control-label" for="inputPassword">密码</label>
    			<div class="controls">
    				<input type="password" id="inputPassword" name="password" placeholder="Password">
    			</div>
    	</div>
    	<div class="control-group">
    		<div class="controls">
    			<label class="checkbox">
    				<input type="checkbox"> 记住我
    			</label>
    			<button type="submit" class="btn">登录</button>
    		</div>
    	</div>
    </form>
<%@ include file="/WEB-INF/views/layouts/application_foot.jsp" %>