package com.bstar.mportal.service;

import org.springframework.stereotype.Service;

import com.bstar.mportal.dao.UserDao;
import com.bstar.mportal.model.User;

@Service
public class UserService {

	UserDao userDao = new UserDao();

	public User findByName(String name) throws Exception {
		return userDao.findByName(name);
	}
	
}
