package com.bStar.mportal.dao;

import java.util.List;

import com.bStar.mportal.pojo.Resource;

public interface ResourceDao {
	int save(Resource resource)throws Exception;
	List<Resource>findAll()throws Exception;
	List<Resource>findByChannelId(int channelId)throws Exception;
}
