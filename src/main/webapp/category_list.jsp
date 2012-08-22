<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div>
	<div>
		<h2>
			<a href = "#javascript:;" onclick="location='ChannelList.action'">频道列表</a>
		</h2>
		
		
			<s:iterator value="categorys">
			<div>
				<h3>
					[${ categoryName }]&nbsp;
					
				</h3>
				<ul>
						<s:iterator value="channels">
						<li>
							<a href="#javascript:;" onclick="document.location='ChannelPlay.action?channelId=${channelId}'">${ name }</a>
						</li>
						</s:iterator>
			
				</ul>
			</div>
			</s:iterator>
			
	</div>
</div>

