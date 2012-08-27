package com.bstar.mportal.service;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bstar.mportal.dao.ChannelDao;
import com.bstar.mportal.model.Channel;

@Service
public class ChannelService {

	@Autowired
	private ChannelDao channelDao;
	
	public void save(Channel channel) {
		channelDao.save(channel);
	}

	public Channel find(Integer channelId) {
		 return channelDao.get(channelId);
	}

	public List<Channel> findAll() {
		List<Channel>channels =  channelDao.findAll();
		return channels;
	}
	
	public void delete(Channel channel) {
			channelDao.delete(channel);
	}

	public void update(Channel channel) {
		channelDao.update(channel);
	}
	
	public void upload(File logo,ServletContext servletContext,Channel channel,String logoFileName){
		if(logo!=null){
			File logoDir = new File(servletContext.getRealPath("/upload/logo"));
			if (!logoDir.exists()) {
				logoDir.mkdirs();
			}
			File target = new File(logoDir, "logo-" + channel.getId() + logoFileName.substring(logoFileName.lastIndexOf(".")));
			logo.renameTo(target);
			channel.setLogo(target.getName());
			update(channel);
		}
	}

}
