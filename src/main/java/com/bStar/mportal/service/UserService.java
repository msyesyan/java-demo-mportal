package com.bstar.mportal.service;

import com.bstar.mportal.dao.UserDao;
import com.bstar.mportal.dao.UserDaoJdbcImpl;
import com.bstar.mportal.model.User;

public class UserService {

	UserDao userDao = new UserDaoJdbcImpl();

	public void save(User user) throws Exception {
		userDao.save(user);
	}

	public User findByName(String name) throws Exception {
		return userDao.findByName(name);
	}
	
}
