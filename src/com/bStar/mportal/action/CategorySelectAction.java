package com.bStar.mportal.action;

import java.util.List;

import com.bStar.mportal.pojo.Category;
import com.bStar.mportal.service.CategoryService;
import com.bStar.mportal.service.CategoryServiceImpl;

public class CategorySelectAction {
	private CategoryService categoryService = new CategoryServiceImpl();
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
