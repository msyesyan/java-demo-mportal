package com.bstar.mportal.action.admin.categories;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.web.bind.ServletRequestUtils;

import com.bstar.mportal.action.BaseAction;
import com.bstar.mportal.model.Category;
import com.bstar.mportal.service.CategoryService;

@Action
@Result(type="redirect", location="/admin/categories/")
public class DestroyAction extends BaseAction {
	
	private static final long serialVersionUID = -4362228654198692933L;

	private Category category;
	
	public void prepare() throws Exception {
		int id = ServletRequestUtils.getRequiredIntParameter(request, "id");
		category = categoryService.find(id);
	}
	
	public String execute() throws Exception {
		categoryService.delete(category);
		return SUCCESS;
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
