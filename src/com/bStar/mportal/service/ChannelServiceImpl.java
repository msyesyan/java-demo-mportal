package com.bStar.mportal.service;

import java.util.ArrayList;
import java.util.List;

import com.bStar.mportal.dao.ChannelDao;
import com.bStar.mportal.dao.ChannelDaoJdbcImpl;
import com.bStar.mportal.dao.ResourceDao;
import com.bStar.mportal.dao.ResourceDaoJdbcImpl;
import com.bStar.mportal.pojo.Category;
import com.bStar.mportal.pojo.Channel;
import com.bStar.mportal.pojo.Resource;

public class ChannelServiceImpl implements ChannelService {

	private ChannelDao channelDao = new ChannelDaoJdbcImpl();
	private ResourceDao resourceDao = new ResourceDaoJdbcImpl();
	private CategoryService categoryService = new CategoryServiceImpl();
	public List<Channel> findByCategoryId(int id) throws Exception {
		return channelDao.findByCategoryId(id);
	}

	public void save(Channel channel) throws Exception {
		channelDao.save(channel);
	}

	public Channel findById(int channelId) throws Exception {
		 Channel channel = channelDao.findById(channelId);
		 List<Resource>resources = findResourceByChannelId(channelId);
		 channel.setResouces(resources);
		 return channel;
	}

	public void save(Channel channel, List<Resource> resources)throws Exception {
		save(channel);
		for(int i = 0;i<resources.size();i++){
			System.out.println("SveResourceService "+resources.get(i).getId());
			resources.get(i).setId(resourceDao.save(resources.get(i)));
			channelDao.saveResource(channel.getChannelId(), resources.get(i).getId());
		}
	}

	public List<Resource> findResourceByChannelId(int channelId)
			throws Exception {
		return resourceDao.findByChannelId(channelId);
	}

	public List<Channel> findAll() throws Exception {
		List<Channel>channels =  channelDao.findAll();
		for(int i = 0;i<channels.size();i++){
			List<Resource>resources = findResourceByChannelId(channels.get(i).getChannelId());
			List<Category>categorys = categoryService.findByChannelId(channels.get(i).getChannelId()); 
			System.out.println("findAll--"+resources.size());
			
			List<String>categoryName = new ArrayList<String>();
			for(Category ce : categorys){
				categoryName.add(ce.getCategoryName());
			}
			channels.get(i).setResouces(resources);
			channels.get(i).setCategorys(categoryName);
		}
		
		return channels;
	}

}
