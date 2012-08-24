package com.bstar.mportal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bstar.mportal.model.User;
import com.bstar.mportal.util.Dbutil;

public class UserDaoJdbcImpl implements UserDao{
	
	public static final String save = "insert into user (name,password) values(?,?)";
	public static final String findByName = "select * from user where name = ?";
	public void save(User user) throws Exception {
		PreparedStatement prep = Dbutil.getConnection().prepareStatement(save);
		prep.setString(1,user.getName());
		prep.setString(2,user.getPassword());
		prep.executeUpdate();
	}

	public User findByName(String name) throws Exception {
		System.out.println(name);
		PreparedStatement prep = Dbutil.getConnection().prepareStatement(findByName);
		prep.setString(1,name);
		ResultSet rs = prep.executeQuery();
		User user = null;
		if(rs.next()){
			user = new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
		}
		return user;
	}
	public static void main(String[] args) throws Exception {
		UserDaoJdbcImpl dao = new UserDaoJdbcImpl();
		User user = dao.findByName("chenqian");
		System.out.println(user.getName()+" "+user.getPassword());;
		
	}

}
