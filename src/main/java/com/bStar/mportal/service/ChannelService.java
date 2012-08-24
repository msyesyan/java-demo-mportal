package com.bstar.mportal.service;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jetty.util.resource.Resource;

import com.bstar.mportal.dao.ChannelDao;
import com.bstar.mportal.model.Category;
import com.bstar.mportal.model.Channel;

public class ChannelService {

	private ChannelDao channelDao = new ChannelDao();
	private CategoryService categoryService = new CategoryService();
	public List<Channel> findByCategoryId(int id) throws Exception {
		return channelDao.findByCategoryId(id);
	}

	public void save(Channel channel) throws Exception {
		channelDao.save(channel);
	}

	public Channel findById(int channelId) throws Exception {
		 Channel channel = channelDao.findById(channelId);
		 return channel;
	}

	public void save(Channel channel, List<Resource> resources)throws Exception {
		save(channel);
	}

	public List<Channel> findAll() throws Exception {
		List<Channel>channels =  channelDao.findAll();
		return channels;
	}
	
	public boolean delete(Channel channel) throws Exception{
		if(findById(channel.getId())!=null){
			channelDao.delete(channel.getId());
			return true;
		}
		return false;
		
	}

	public void edit(Channel channel) throws Exception{
		channelDao.update(channel);
	}

}
