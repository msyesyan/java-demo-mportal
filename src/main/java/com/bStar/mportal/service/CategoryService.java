package com.bstar.mportal.service;

import java.util.List;

import com.bstar.mportal.dao.CategoryDao;
import com.bstar.mportal.model.Category;
import com.bstar.mportal.model.Channel;

public class CategoryService {

	CategoryDao categoryDao = new CategoryDao();

	public void save(Category category) throws Exception {
		categoryDao.save(category);
	}

	public void delete(Category category) throws Exception {
		categoryDao.delete(category);
	}

	public void update(Category category) throws Exception {
		categoryDao.update(category);
	}
	
	public Category findById(Integer id) throws Exception {
		return categoryDao.findById(id);
	}

	public List<Category> findAll() throws Exception {
		return categoryDao.findAll();
	}

}
