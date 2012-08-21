<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div>
	<div>
		<h2>
			频道列表
		</h2>
		
		<!--1级分类开始-->
			<s:iterator value="categorys">
			<div>
				<h3>
					[${ categoryName }]&nbsp;
					
				</h3>
				<ul">
						<!--2级分类开始-->
						<s:iterator value="channels">
						<li>
							${ name }
						</li>
						</s:iterator>
						<!--2级分类结束-->

				</ul>
			</div>
			</s:iterator>
			<!--1级分类结束-->
	</div>
</div>

