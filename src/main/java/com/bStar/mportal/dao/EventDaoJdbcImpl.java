package com.bStar.mportal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bStar.mportal.pojo.Channel;
import com.bStar.mportal.pojo.Event;
import com.bStar.mportal.util.DateUtil;
import com.bStar.mportal.util.Dbutil;
import com.mysql.jdbc.Statement;

public class EventDaoJdbcImpl implements EventDao {

	public static final String save ="insert into event values(?,?,?,?,?,?)";
	public static final String saveChannel = "insert into channel_event(channel_id,event_id)values(?,?)";
	public void save(Event event) throws Exception {
		System.out.println("eventDao");
		System.out.println(event.getEgpProduction().getShortDescription());
		PreparedStatement prep = Dbutil.getConnection().prepareStatement(save,Statement.RETURN_GENERATED_KEYS);
		prep.setInt(1,event.getEventId());
		prep.setString(2,DateUtil.parseISO8601(event.getEventBeginTime()));
		prep.setLong(3,event.getEventDuration());
		prep.setString(4, event.getEgpProduction().getLanguage());
		prep.setString(5, event.getEgpProduction().getName());
		prep.setString(6,event.getEgpProduction().getShortDescription());
		prep.executeUpdate();
	}
	public void saveChannel(int eventId, Channel channel) throws Exception {
		PreparedStatement prep = Dbutil.getConnection().prepareStatement(saveChannel);
		prep.setInt(1,eventId);
		prep.setInt(2, channel.getChannelId());
		prep.executeUpdate();
	}

}
