package com.bStar.mportal.action.admin;

import java.util.List;

import com.bStar.mportal.model.Category;
import com.bStar.mportal.service.CategoryService;

public class CategorySelectAction {
	private CategoryService categoryService = new CategoryService();
	private List<Category> categorys;

	public String execute() {
		try {

			categorys = categoryService.findAll();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	public List<Category> getCategorys() {
		return categorys;
	}

	public void setCategorys(List<Category> categorys) {
		this.categorys = categorys;
	}

}
