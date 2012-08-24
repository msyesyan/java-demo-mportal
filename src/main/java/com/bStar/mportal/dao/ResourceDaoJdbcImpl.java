package com.bStar.mportal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bStar.mportal.model.Resource;
import com.bStar.mportal.util.Dbutil;
import com.mysql.jdbc.Statement;

public class ResourceDaoJdbcImpl implements ResourceDao{

	
	public static final String save = "insert into resource (type,url) values(?,?)";
	public static final String findByChannelId = "select * from resource " +
			"where id in " +
			"(select resource_id from channel_resource " +
			"where channel_id = ?);";
	public int save(Resource resource) throws Exception {
		PreparedStatement prep = Dbutil.getConnection().prepareStatement(save,Statement.RETURN_GENERATED_KEYS);
		prep.setString(1, resource.getType());
		prep.setString(2, resource.getUrl());
		prep.executeUpdate();
		ResultSet rs = prep.getGeneratedKeys();
		Integer id=null;
		if(rs.next())
			id= rs.getInt(1);
		return id;
	}
	public List<Resource> findAll() throws Exception {
		return null;
	}
	public List<Resource> findByChannelId(int channelId) throws Exception {
		PreparedStatement prep = Dbutil.getConnection().prepareStatement(findByChannelId);
		prep.setInt(1, channelId);
		ResultSet rs = prep.executeQuery();
		List<Resource>lists = new ArrayList<Resource>();
		while(rs.next()){
			Resource re = new Resource();
			re.setId(rs.getInt("id"));
			re.setType(rs.getString("type"));
			re.setUrl(rs.getString("url"));
			lists.add(re);
		}
		return lists;
	}
	public static void main(String[] args) throws Exception {
		ResourceDaoJdbcImpl dao = new ResourceDaoJdbcImpl();
		System.out.println(dao.findByChannelId(10000).get(0).getId());
	}

}
