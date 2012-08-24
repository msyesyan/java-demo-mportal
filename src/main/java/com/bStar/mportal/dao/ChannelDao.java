package com.bStar.mportal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bStar.mportal.model.Channel;
import com.bStar.mportal.util.Dbutil;

public class ChannelDao {

	public static final String findByCategoryId = "select * from channel where id in("
			+ "select channel_id from channel_category where category_id = ?)";
	public static final String save = "insert into channel "
			+ "(num,name,logo) "
			+ "values(?,?,?)";
	public static final String findById = "select * from channel where id = ?";
	public static final String saveResource = "insert into channel_resource(channel_id,resource_id) values(?,?)";
	public static final String findAll = "select * from channel";
	public static final String delete = "delete from channel where id = ?";
	public static final String update = "update channel set name=?,num=?,logo=? where id=?";
	public List<Channel> findAll() throws Exception {
		ResultSet rs = Dbutil.getConnection().createStatement().executeQuery(findAll);
		List<Channel>lists = new ArrayList<Channel>();
		while (rs.next()) {
			Channel channel = new Channel();
			channel.setId(rs.getInt("id"));
			channel.setName(rs.getString("name"));
			channel.setNum(rs.getInt("num"));
			channel.setLogo(rs.getString("logo"));			
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
			channel.setId(rs.getInt("id"));
			channel.setName(rs.getString("name"));
			channel.setNum(rs.getInt("num"));
			channel.setLogo(rs.getString("logo_url"));
			lists.add(channel);
		}
		return lists;
	}

	public void save(Channel channel) throws Exception {
		PreparedStatement prep = Dbutil.getConnection().prepareStatement(save, Statement.RETURN_GENERATED_KEYS);
		// id,num,name,updated_at,logo_url,resources_type,resources_url,programs_endpoint
		prep.setInt(1, channel.getNum());
		prep.setString(2, channel.getName());		
		prep.setString(3, channel.getLogo());
		prep.executeUpdate();
		ResultSet rs = prep.getGeneratedKeys();
		if(rs.next()) {
			channel.setId(rs.getInt(1));
		}
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
			channel.setId(rs.getInt("id"));
			channel.setName(rs.getString("name"));
			channel.setNum(rs.getInt("num"));
			channel.setLogo(rs.getString("logo"));
		}
		return channel;
	}

	public void delete(Integer channelId) throws Exception {
		PreparedStatement prep = Dbutil.getConnection().prepareStatement(delete);
		prep.setInt(1, channelId);
		prep.executeUpdate();
	}

	public void update(Channel channel) throws Exception {
		PreparedStatement prep = Dbutil.getConnection().prepareStatement(update);
		prep.setString(1, channel.getName());
		prep.setInt(2, channel.getNum());
		prep.setString(3, channel.getLogo());
		prep.setInt(4, channel.getId());
		prep.executeUpdate();
	}

}
