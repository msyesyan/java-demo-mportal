package com.bStar.mportal.service;

import java.util.List;

import com.bStar.mportal.dao.CategoryDao;
import com.bStar.mportal.dao.CategoryDaoJdbcImpl;
import com.bStar.mportal.pojo.Category;
import com.bStar.mportal.pojo.Channel;

public class CategoryServiceImpl implements CategoryService {

	CategoryDao categoryDao = new CategoryDaoJdbcImpl();

	public List<Category> findAll() throws Exception {
		return categoryDao.findAll();
	}

	public void addChannel(int CategoryId, Channel channel) throws Exception {
		categoryDao.addChannel(CategoryId, channel);
	}

}
