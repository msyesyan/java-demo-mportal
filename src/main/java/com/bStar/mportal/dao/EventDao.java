package com.bStar.mportal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bStar.mportal.model.Channel;
import com.bStar.mportal.model.EgpProduction;
import com.bStar.mportal.model.Event;
import com.bStar.mportal.util.DateUtil;
import com.bStar.mportal.util.Dbutil;
import com.mysql.jdbc.Statement;

public class EventDao {

	public static final String save ="insert into event values(?,?,?,?,?,?)";
	public static final String saveChannel = "insert into channel_event(channel_id,event_id)values(?,?)";
	public static final String findByChannelId = "select * from event where eventId in(select event_id from channel_event where channel_id = ?)";
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
		prep.setInt(1,channel.getId());
		prep.setInt(2, eventId);
		prep.executeUpdate();
	}
	public List<Event> findByChannelId(int channelId) throws Exception {
		System.out.println("eventDao================"+channelId);
		List<Event>lists = new ArrayList<Event>();
		PreparedStatement prep = Dbutil.getConnection().prepareStatement(findByChannelId);
		prep.setInt(1, channelId);
		System.out.println("beginQuery");
		ResultSet rs = prep.executeQuery();
		while(rs.next()){
			System.out.println("hasNext()");
			Event event = new Event();
			EgpProduction egp = new EgpProduction();
			egp.setShortDescription(rs.getString("egp_production_text_shortDescription"));
			egp.setName(rs.getString("egp_production_text_name"));
			egp.setLanguage(rs.getString("egp_production_text_language"));
			System.out.println(egp.getLanguage()+" "+egp.getName()+" "+egp.getShortDescription());
			event.setEventId(rs.getInt("eventId"));
			event.setEgpProduction(egp);
			event.setEventBeginTime(DateUtil.parseDate(rs.getString("event_begin_time")));
			event.setEventDuration(rs.getLong("event_duration"));
			lists.add(event);
		}
		return lists;
	}

}
