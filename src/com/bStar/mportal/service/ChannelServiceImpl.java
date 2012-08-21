package com.bStar.mportal.service;

import java.util.List;

import com.bStar.mportal.dao.ChannelDao;
import com.bStar.mportal.dao.ChannelDaoJdbcImpl;
import com.bStar.mportal.pojo.Channel;

public class ChannelServiceImpl implements ChannelService {
	
	private ChannelDao channelDao = new ChannelDaoJdbcImpl();
	public List<Channel> findByCategoryId(int id) throws Exception {
		return channelDao.findByCategoryId(id);
	}
	public void save(Channel channel) throws Exception {
		channelDao.save(channel);
	}

}
