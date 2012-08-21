package com.bStar.mportal.service;

import java.util.List;

import com.bStar.mportal.pojo.Category;
import com.bStar.mportal.pojo.Channel;

public interface CategoryService {
	List<Category>findAll()throws Exception;
	void addChannel(int CategoryId,Channel channel)throws Exception;
	List<Category>findByChannelId(int channelId)throws Exception;
}
