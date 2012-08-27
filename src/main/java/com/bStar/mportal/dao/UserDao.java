package com.bstar.mportal.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bstar.mportal.model.User;

@Repository
public class UserDao extends AbstractEntryDao<User> {

	public User findByName(String name) {
		Criteria criteria = currentSession().createCriteria(this.entityClass);
		return (User) criteria.add(Restrictions.eq("name", name)).uniqueResult();
	}
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
