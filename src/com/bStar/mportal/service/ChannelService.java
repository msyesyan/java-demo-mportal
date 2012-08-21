package com.bStar.mportal.service;

import java.util.List;

import com.bStar.mportal.pojo.Channel;

public interface ChannelService {
	List<Channel>findByCategoryId(int id)throws Exception;
	void save(Channel channel)throws Exception;
}
