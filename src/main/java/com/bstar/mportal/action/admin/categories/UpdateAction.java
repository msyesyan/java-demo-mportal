package com.bstar.mportal.action.admin.categories;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

@Action
@Result(type="redirect", location="/admin/categories/")
public class UpdateAction extends EditAction {
	
	
	private static final long serialVersionUID = -7158005258462761542L;

	public String execute() throws Exception {
		categoryService.update(category);
		return SUCCESS;
	}
}
