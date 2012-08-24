package com.bstar.mportal.dao;

import java.util.List;

import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bstar.mportal.model.Category;

@Repository
public class CategoryDao extends BaseHibernateDao {
	private static final Logger log = LoggerFactory
			.getLogger(CategoryDao.class);

	public static final String NAME = "name";

	public void save(Category transientInstance) {
		log.debug("saving Category instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Category persistentInstance) {
		log.debug("deleting Category instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Category findById(java.lang.Integer id) {
		log.debug("getting Category instance with id: " + id);
		try {
			Category instance = (Category) getSession().get(
					"com.bstar.mportal.model.Category", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Category> findAll() {
		log.debug("finding all Category instances");
		try {
			String queryString = "from Category";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public void update(Category category){
		log.debug("update a Category instance");
		try {
			getSession().update(category);
		} catch (RuntimeException e) {
			log.error("update failed",e);
			throw e;
		}
	}


	// public static String save = "insert into category (name) values(?)";
	// public static String delete = "delete from category where id = ?";
	// public static String update =
	// "update category set name = ? where id = ?";
	// public static String findById = "select * from category where id = ?";
	// public static String findAll = "select * from category";
	//
	// public void save(Category category) throws Exception {
	// PreparedStatement prep = Dbutil.getConnection().prepareStatement(save);
	// prep.setString(1, category.getName());
	// prep.executeUpdate();
	// }
	// public void delete(Category category) throws Exception {
	// PreparedStatement prep = Dbutil.getConnection()
	// .prepareStatement(delete);
	// prep.setInt(1, category.getId());
	// prep.executeUpdate();
	// }
	// public void update(Category category) throws Exception {
	// PreparedStatement prep = Dbutil.getConnection().prepareStatement(update);
	// prep.setString(1, category.getName());
	// prep.setInt(2, category.getId());
	// prep.executeUpdate();
	// }
	// public Category findById(Integer id) throws Exception {
	// PreparedStatement prep = Dbutil.getConnection().prepareStatement(
	// findById);
	// prep.setInt(1, id);
	// ResultSet rs = prep.executeQuery();
	// Category category = null;
	// if (rs.next()) {
	// category = new Category();
	// category.setId(rs.getInt("id"));
	// category.setName(rs.getString("name"));
	// }
	// return category;
	// }
	//
	// public List<Category> findAll() throws Exception {
	// ResultSet rs = Dbutil.getConnection().createStatement()
	// .executeQuery(findAll);
	// List<Category> lists = new ArrayList<Category>();
	// while (rs.next()) {
	// Category category = new Category();
	// category.setId(rs.getInt("id"));
	// category.setName(rs.getString("name"));
	// lists.add(category);
	// }
	// return lists;
	// }

}
