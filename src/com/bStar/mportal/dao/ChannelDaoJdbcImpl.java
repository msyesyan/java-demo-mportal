package com.bStar.mportal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bStar.mportal.pojo.Channel;
import com.bStar.mportal.pojo.Resource;
import com.bStar.mportal.util.Dbutil;

public class ChannelDaoJdbcImpl implements ChannelDao {

	public static final String findByCategoryId = "select * from channel where id in("
			+ "select channel_id from channel_category where category_id = ?)";
	public static final String save = "insert into channel "
			+ "(id,num,name,updated_at,logo_url,programs_endpoint) "
			+ "values(?,?,?,?,?,?)";
	public static final String findById = "select * from channel where id = ?";
	public static final String saveResource = "insert into channel_resource(channel_id,resource_id) values(?,?)";
	public static final String findAll = "select * from channel";
	public List<Channel> findAll() throws Exception {
		ResultSet rs = Dbutil.getConnection().createStatement().executeQuery(findAll);
		List<Channel>lists = new ArrayList<Channel>();
		while (rs.next()) {
			Channel channel = new Channel();
			channel.setChannelId(rs.getInt("id"));
			channel.setName(rs.getString("name"));
			channel.setNum(rs.getInt("num"));
			channel.setLogoUrl(rs.getString("logo_url"));
			channel.setUpdated_at(rs.getLong("updated_at"));
			channel.setProgramsEndPoint(rs.getString("programs_endpoint"));
			lists.add(channel);
		}
		return lists;
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
		prep.setString(6, channel.getProgramsEndPoint());
		prep.executeUpdate();
	}
	
	public void saveResource(int channelId,int resourceId) throws SQLException{
		PreparedStatement prep = Dbutil.getConnection().prepareStatement(saveResource);
		System.out.println("saveResourceDao===================");
		System.out.println(channelId+" "+resourceId);
		prep.setInt(1, channelId);
		prep.setInt(2, resourceId);
		prep.executeUpdate();
	}
	
	public Channel findById(int channelId) throws Exception {
		PreparedStatement prep = Dbutil.getConnection().prepareStatement(
				findById);
		prep.setInt(1, channelId);
		ResultSet rs = prep.executeQuery();
		Channel channel = null;
		if (rs.next()) {
			channel = new Channel();
			channel.setChannelId(rs.getInt("id"));
			channel.setName(rs.getString("name"));
			channel.setNum(rs.getInt("num"));
			channel.setLogoUrl(rs.getString("logo_url"));
			channel.setUpdated_at(rs.getLong("updated_at"));
			channel.setProgramsEndPoint(rs.getString("programs_endpoint"));
		}
		return channel;
	}

}
