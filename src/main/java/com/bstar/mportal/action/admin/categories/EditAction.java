package com.bstar.mportal.action.admin.categories;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.web.bind.ServletRequestUtils;

import com.bstar.mportal.action.BaseAction;
import com.bstar.mportal.model.Category;
import com.bstar.mportal.service.CategoryService;

@Action
public class EditAction extends BaseAction {
	
	private static final long serialVersionUID = 1708232373848709716L;

	protected Category category;
	
	public void prepare() throws Exception {
		int id = ServletRequestUtils.getRequiredIntParameter(request, "id");
		category = categoryService.find(id);
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
}
