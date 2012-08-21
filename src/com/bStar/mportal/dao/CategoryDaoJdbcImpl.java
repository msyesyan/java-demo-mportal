package com.bStar.mportal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bStar.mportal.pojo.Category;
import com.bStar.mportal.pojo.Channel;
import com.bStar.mportal.util.Dbutil;

public class CategoryDaoJdbcImpl implements CategoryDao {
	
	public static String findAll = "select * from category";
	public static String addChannel = "insert into channel_category (channel_id,category_id) values(?,?)";
	public static String findByChannelId = "select * from category " +
			"where category_id in " +
			"(select category_Id from channel_category " +
			"where channel_id = ?);";
	public List<Category> findAll() throws Exception {
		List<Category>lists = new ArrayList<Category>();
		ResultSet rs = Dbutil.getConnection().createStatement().executeQuery(findAll);
		while(rs.next()){
			Category category = new Category();
			category.setCategoryId(rs.getInt("category_id"));
			category.setCategoryName(rs.getString("category_name"));
			lists.add(category);
		}
		return lists;	
	}
	public static void main(String[] args) throws Exception {
		CategoryDaoJdbcImpl dao = new CategoryDaoJdbcImpl();
		System.out.println(dao.findByChannelId(10000).size());
	}
	public void addChannel(int CategoryId, Channel channle) throws Exception {
		PreparedStatement prep = Dbutil.getConnection().prepareStatement(addChannel);
		System.out.println("hello+ "+channle.getChannelId());
		prep.setInt(1, channle.getChannelId());
		prep.setInt(2,CategoryId);
		prep.executeUpdate();
	}
	public List<Category> findByChannelId(int channelId) throws Exception {
		List <Category>lists = new ArrayList<Category>();
		PreparedStatement prep = Dbutil.getConnection().prepareStatement(findByChannelId);
		prep.setInt(1, channelId);
		ResultSet rs = prep.executeQuery();
		while(rs.next()){
			Category ca = new Category();
			ca.setCategoryId(rs.getInt("category_id"));
			ca.setCategoryName(rs.getString("category_name"));
			lists.add(ca);
		}
		return lists;
	}

}
