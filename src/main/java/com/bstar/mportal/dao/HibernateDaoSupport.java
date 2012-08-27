package com.bstar.mportal.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateDaoSupport {

	protected SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session currentSession() {
		return this.sessionFactory.getCurrentSession();
	}

}