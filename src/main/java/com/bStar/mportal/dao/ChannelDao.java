package com.bstar.mportal.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bstar.mportal.model.Channel;

@Repository
@SuppressWarnings("unchecked")
public class ChannelDao extends EntryDao<Channel> {

	public void save(Channel channel) {
		currentSession().save(channel);
	}

	public void delete(Channel channel) {
		currentSession().delete(channel);
	}

	public Channel get(Integer id) {
		return (Channel) currentSession().get(Channel.class, id);
	}

	public List<Channel> findAll() {
		return currentSession().createCriteria(Channel.class).list();
	}

	public void update(Channel channel) {
		currentSession().update(channel);
	}

}
