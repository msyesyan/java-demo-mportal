package com.bstar.mportal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bstar.mportal.model.Category;
import com.bstar.mportal.util.Dbutil;

public class CategoryDao {

	public static String save = "insert into category (name) values(?)";
	public static String delete = "delete from category where id = ?";
	public static String update = "update category set name = ? where id = ?";
	public static String findById = "select * from category where id = ?";
	public static String findAll = "select * from category";
	/*
	 * save
	 */
	public void save(Category category) throws Exception {
		PreparedStatement prep = Dbutil.getConnection().prepareStatement(save);
		prep.setString(1, category.getName());
		prep.executeUpdate();
	}
	/*
	 * delete
	 */
	public void delete(Category category) throws Exception {
		PreparedStatement prep = Dbutil.getConnection()
				.prepareStatement(delete);
		prep.setInt(1, category.getId());
		prep.executeUpdate();
	}
	/*
	 * update
	 */
	public void update(Category category) throws Exception {
		PreparedStatement prep = Dbutil.getConnection().prepareStatement(update);
		prep.setString(1, category.getName());
		prep.setInt(2, category.getId());
		prep.executeUpdate();
	}
	/*
	 * findById
	 */
	public Category findById(Integer id) throws Exception {
		PreparedStatement prep = Dbutil.getConnection().prepareStatement(
				findById);
		prep.setInt(1, id);
		ResultSet rs = prep.executeQuery();
		Category category = null;
		if (rs.next()) {
			category = new Category();
			category.setId(rs.getInt("id"));
			category.setName(rs.getString("name"));
		}
		return category;
	}

	/*
	 * findAll
	 */
	public List<Category> findAll() throws Exception {
		ResultSet rs = Dbutil.getConnection().createStatement()
				.executeQuery(findAll);
		List<Category> lists = new ArrayList<Category>();
		while (rs.next()) {
			Category category = new Category();
			category.setId(rs.getInt("id"));
			category.setName(rs.getString("name"));
			lists.add(category);
		}
		return lists;
	}

	// public void addChannel(int CategoryId, Channel channle) throws Exception
	// {
	// PreparedStatement prep =
	// Dbutil.getConnection().prepareStatement(addChannel);
	// System.out.println("hello+ "+channle.getId());
	// prep.setInt(1, channle.getId());
	// prep.setInt(2,CategoryId);
	// prep.executeUpdate();
	// }

	// public List<Category> findByChannelId(int channelId) throws Exception {
	// List <Category>lists = new ArrayList<Category>();
	// PreparedStatement prep =
	// Dbutil.getConnection().prepareStatement(findByChannelId);
	// prep.setInt(1, channelId);
	// ResultSet rs = prep.executeQuery();
	// while(rs.next()){
	// Category ca = new Category();
	// ca.setCategoryId(rs.getInt("category_id"));
	// ca.setCategoryName(rs.getString("category_name"));
	// lists.add(ca);
	// }
	// return lists;
	// }

}
