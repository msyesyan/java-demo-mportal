package com.bstar.mportal.dao;

import org.hibernate.SessionFactory;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.orm.hibernate4.SpringSessionContext;

public abstract class BaseHibernateDao extends HibernateDaoSupport {
	
	protected SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory2(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		this.setSessionFactory(sessionFactory);
	}
	
	public SpringSessionContext getSpringSessionContext() {
		return new SpringSessionContext((SessionFactoryImplementor) this.sessionFactory);
	}
}
