package com.bstar.mportal.dao;

import java.util.List;

import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bstar.mportal.model.User;

@Repository
public class UserDao extends EntryDao<User> {

	private static final Logger log = LoggerFactory.getLogger(UserDao.class);
	// property constants
	public static final String NAME = "name";
	public static final String PASSWORD = "password";

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding User instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from User as model where model."
					+ propertyName + "= ?";
			Query queryObject = currentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public User findByName(Object name) {
		System.out.println("findUserByName");
		return (User)(findByProperty(NAME, name).get(0));
	}


	// public static final String save =
	// "insert into user (name,password) values(?,?)";
	// public static final String findByName =
	// "select * from user where name = ?";
	// public void save(User user) throws Exception {
	// PreparedStatement prep = Dbutil.getConnection().prepareStatement(save);
	// prep.setString(1,user.getName());
	// prep.setString(2,user.getPassword());
	// prep.executeUpdate();
	// }
	//
	// public User findByName(String name) throws Exception {
	// System.out.println(name);
	// PreparedStatement prep =
	// Dbutil.getConnection().prepareStatement(findByName);
	// prep.setString(1,name);
	// ResultSet rs = prep.executeQuery();
	// User user = null;
	// if(rs.next()){
	// user = new User();
	// user.setId(rs.getInt("id"));
	// user.setName(rs.getString("name"));
	// user.setPassword(rs.getString("password"));
	// }
	// return user;
	// }

}
