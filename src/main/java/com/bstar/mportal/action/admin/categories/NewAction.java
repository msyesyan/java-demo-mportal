package com.bstar.mportal.action.admin.categories;

import org.apache.struts2.convention.annotation.Action;

import com.bstar.mportal.action.BaseAction;
import com.bstar.mportal.model.Category;

@Action
public class NewAction extends BaseAction {
	
	private static final long serialVersionUID = -4937201174820582195L;
	protected Category category;
	
	public void prepare() throws Exception {
		category = new Category();
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
}
