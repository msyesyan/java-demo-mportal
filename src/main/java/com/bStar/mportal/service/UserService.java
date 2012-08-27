package com.bstar.mportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bstar.mportal.dao.UserDao;
import com.bstar.mportal.model.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public User findByName(String name) throws Exception {
		return userDao.findByName(name);
	}
	
}
