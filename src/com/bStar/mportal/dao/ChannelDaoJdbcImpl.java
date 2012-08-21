package com.bStar.mportal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bStar.mportal.pojo.Channel;
import com.bStar.mportal.util.Dbutil;

public class ChannelDaoJdbcImpl implements ChannelDao {

	public static final String findByCategoryId = "select * from channel where id in("
			+ "select channel_id from channel_category where category_id = ?)";
	public static final String save = "insert into channel "
			+ "(id,num,name,updated_at,logo_url,resources_type,resources_url,programs_endpoint) "
			+ "values(?,?,?,?,?,?,?,?)";
	
	public List<Channel> findAll() throws Exception {
		return null;
	}

	public List<Channel> findByCategoryId(int id) throws Exception {
		PreparedStatement prep = Dbutil.getConnection().prepareStatement(
				findByCategoryId);
		prep.setInt(1, id);
		List<Channel> lists = new ArrayList<Channel>();
		ResultSet rs = prep.executeQuery();
		while (rs.next()) {
			Channel channel = new Channel();
			channel.setChannelId(rs.getInt("id"));
			channel.setName(rs.getString("name"));
			channel.setNum(rs.getInt("num"));
			channel.setLogoUrl(rs.getString("logo_url"));
			channel.setResourcesType(rs.getString("resources_type"));
			channel.setResourcesUrl(rs.getString("resources_url"));
			channel.setUpdated_at(rs.getLong("updated_at"));
			channel.setProgramsEndPoint(rs.getString("programs_endpoint"));
			lists.add(channel);
		}
		return lists;
	}

	public static void main(String[] args) throws Exception {
		ChannelDaoJdbcImpl dao = new ChannelDaoJdbcImpl();
		System.out.println(dao.findByCategoryId(100).size());
	}

	public void save(Channel channel) throws Exception {
		PreparedStatement prep = Dbutil.getConnection().prepareStatement(save);
		// id,num,name,updated_at,logo_url,resources_type,resources_url,programs_endpoint
		prep.setInt(1, channel.getChannelId());
		prep.setInt(2, channel.getNum());
		prep.setString(3, channel.getName());
		prep.setLong(4, channel.getUpdated_at());
		prep.setString(5, channel.getLogoUrl());
		prep.setString(6, channel.getResourcesType());
		prep.setString(7, channel.getResourcesUrl());
		prep.setString(8, channel.getProgramsEndPoint());
		prep.executeUpdate();
	}
	

}
