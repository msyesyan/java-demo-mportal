package com.bstar.mportal.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.bstar.mportal.model.Channel;

@Repository
public class ChannelDao extends AbstractEntryDao<Channel> {
	public Channel findByName(Integer num) {
		Criteria criteria = currentSession().createCriteria(this.entityClass);
		return (Channel) criteria.add(Restrictions.eq("num", num)).uniqueResult();
	}
}
