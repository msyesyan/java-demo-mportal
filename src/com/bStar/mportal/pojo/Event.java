package com.bStar.mportal.pojo;

import java.util.Date;

public class Event {

	private int eventId;
	private Date eventBeginTime;
	private long eventDuration;
	private EgpProduction egpProduction;
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	
	public Date getEventBeginTime() {
		return eventBeginTime;
	}
	public void setEventBeginTime(Date eventBeginTime) {
		this.eventBeginTime = eventBeginTime;
	}
	
	public long getEventDuration() {
		return eventDuration;
	}
	public void setEventDuration(long eventDuration) {
		this.eventDuration = eventDuration;
	}
	public EgpProduction getEgpProduction() {
		return egpProduction;
	}
	public void setEgpProduction(EgpProduction egpProduction) {
		this.egpProduction = egpProduction;
	}
	
}
