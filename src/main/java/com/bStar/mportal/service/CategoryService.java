package com.bstar.mportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bstar.mportal.dao.AbstractEntryDao;
import com.bstar.mportal.model.Category;

@Service
public class CategoryService {

	@Autowired
	AbstractEntryDao<Category> categoryDao;

	public void save(Category category) throws Exception {
		categoryDao.save(category);
	}

	public void delete(Category category) throws Exception {
		categoryDao.delete(category);
	}

	public void update(Category category) throws Exception {
		categoryDao.update(category);
	}
	
	public Category find(Integer id) throws Exception {
		return categoryDao.get(id);
	}

	public List<Category> findAll() throws Exception {
		return categoryDao.findAll();
	}

	public List<Category> findByIds(int[] categoryIds) {
		return categoryDao.findByIds(categoryIds);
	}

}
