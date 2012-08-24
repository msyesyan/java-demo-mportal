package com.bstar.mportal.service;

import java.util.List;

import org.eclipse.jetty.util.resource.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bstar.mportal.dao.ChannelDao;
import com.bstar.mportal.model.Channel;

@Service
public class ChannelService {

	@Autowired
	private ChannelDao channelDao;
	
	public void save(Channel channel) throws Exception {
		channelDao.save(channel);
	}

	public Channel findById(int channelId) throws Exception {
		 Channel channel = channelDao.get(channelId);
		 return channel;
	}

	public void save(Channel channel, List<Resource> resources)throws Exception {
		save(channel);
	}

	public List<Channel> findAll() throws Exception {
		List<Channel>channels =  channelDao.findAll();
		return channels;
	}
	
	public void delete(Channel channel) throws Exception{
			channelDao.delete(channel);
	}

	public void edit(Channel channel) throws Exception{
		channelDao.update(channel);
	}

}
