package com.bstar.mportal.action.admin.categories;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import com.bstar.mportal.action.BaseAction;
import com.bstar.mportal.model.Category;
import com.bstar.mportal.service.CategoryService;

@Action
public class IndexAction extends BaseAction {
	

	private static final long serialVersionUID = -894556763224746002L;

	private List<Category> categories;
	
	public String execute() throws Exception {
		categories = categoryService.findAll();
		return SUCCESS;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

}
