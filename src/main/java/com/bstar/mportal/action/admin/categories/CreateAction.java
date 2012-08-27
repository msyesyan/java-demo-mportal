package com.bstar.mportal.action.admin.categories;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;


@Action
@Result(type="redirect", location="/admin/categories/")
public class CreateAction extends NewAction {
	
	private static final long serialVersionUID = -4937201174820582195L;
	
	public String execute() throws Exception {
		categoryService.save(category);
		return "success";
	}
}
