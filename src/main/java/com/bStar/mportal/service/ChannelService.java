package com.bStar.mportal.service;

import java.util.List;

import com.bStar.mportal.pojo.Channel;
import com.bStar.mportal.pojo.Resource;

public interface ChannelService {
	List<Channel>findByCategoryId(int id)throws Exception;
	List<Resource>findResourceByChannelId(int channelId)throws Exception;
	void save(Channel channel)throws Exception;
	Channel findById(int channelId)throws Exception;
	void save(Channel channel, List<Resource> resources)throws Exception;
	List<Channel> findAll()throws Exception;
}
