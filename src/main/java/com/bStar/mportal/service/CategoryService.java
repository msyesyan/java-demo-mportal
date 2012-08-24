package com.bstar.mportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bstar.mportal.dao.CategoryDao;
import com.bstar.mportal.model.Category;
import com.bstar.mportal.model.Channel;

@Service
public class CategoryService {

	@Autowired
	CategoryDao categoryDao;

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
