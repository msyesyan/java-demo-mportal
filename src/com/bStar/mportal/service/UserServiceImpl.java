package com.bStar.mportal.service;

import com.bStar.mportal.dao.UserDao;
import com.bStar.mportal.dao.UserDaoJdbcImpl;
import com.bStar.mportal.pojo.User;

public class UserServiceImpl implements UserService{

	UserDao userDao = new UserDaoJdbcImpl();
	public void save(User user) throws Exception {
		userDao.save(user);
	}
	public User findByName(String name) throws Exception {
		return userDao.findByName(name);
	}

}