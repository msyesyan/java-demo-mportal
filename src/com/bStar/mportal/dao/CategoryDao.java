package com.bStar.mportal.dao;

import java.util.List;

import com.bStar.mportal.pojo.Category;
import com.bStar.mportal.pojo.Channel;

public interface CategoryDao {
	List<Category> findAll()throws Exception;
	void addChannel(int CategoryId,Channel channle)throws Exception;
}
