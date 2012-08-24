package com.bstar.mportal.action.admin;

import java.util.List;

import com.bstar.mportal.action.BaseAction;
import com.bstar.mportal.model.Category;
import com.bstar.mportal.service.CategoryService;

public class CategoriesController extends BaseAction {
	
	private static final long serialVersionUID = 7697381108725842445L;
	
	List<Category> categories;
	Category category;
	CategoryService categoryService = new CategoryService();
	private Integer id;
	private String name;
	
	public String index() throws Exception {
		categories = categoryService.findAll();
		return "index";
	}
	
	public String create() throws Exception {
		if (request.getMethod().equals("GET")) {
			return "new";
		}
		Category category = new Category();
		category.setName(name);
		categoryService.save(category);
		return "save";
	}

	public String destroy() throws Exception {
		Category category = categoryService.findById(id);
		categoryService.delete(category);
		return "destroy";
	}
	
	public String edit() throws Exception {
		if (request.getMethod().equals("GET")) {
			return "edit";
		}
		Category category = categoryService.findById(this.id);
		category.setName(this.name);
		categoryService.update(category);
		return "edited";
	}
	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
