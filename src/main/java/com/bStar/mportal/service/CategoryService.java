package com.bStar.mportal.service;

import java.util.List;

import com.bStar.mportal.dao.CategoryDao;
import com.bStar.mportal.model.Category;
import com.bStar.mportal.model.Channel;

public class CategoryService {

	CategoryDao categoryDao = new CategoryDao();

	public List<Category> findAll() throws Exception {
		return categoryDao.findAll();
	}

	public void addChannel(int CategoryId, Channel channel) throws Exception {
		categoryDao.addChannel(CategoryId, channel);
	}

	public List<Category> findByChannelId(int channelId) throws Exception {
		return categoryDao.findByChannelId(channelId);
	}

}
