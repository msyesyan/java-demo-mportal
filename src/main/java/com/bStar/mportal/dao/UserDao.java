package com.bstar.mportal.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.bstar.mportal.model.User;

@Repository
public class UserDao extends EntryDaoSupport<User> {

	public User findByName(String name) {
		Criteria criteria = currentSession().createCriteria(this.entityClass);
		return (User) criteria.add(Restrictions.eq("name", name)).uniqueResult();
	}

}
