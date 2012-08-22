package com.bStar.mportal.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.TimerTask;

public class Server {
	
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://58.196.13.10/~felix/tvportal_xml/SIG19F1_20120506020532_4.xml");
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setUseCaches(false);
		conn.setRequestMethod("GET");
		conn.setReadTimeout(1000*60*10);
		conn.setRequestProperty("Content-Type", "application/x-www-urlencoded");
		conn.connect();
		if(conn.getResponseCode()==HttpURLConnection.HTTP_OK){
			System.out.println("type:"+conn.getContentType());
			System.out.println("size:"+conn.getConnectTimeout());
		}
		
		/*
		Timer timer = new Timer();
		//在1秒后执行任务，每次间隔10分钟
		timer.schedule(new MyTask(), 1000, 1000*60*10);
		while(true){
			try {
				
			} catch (Exception e) {
			}
		}
		*/
	}
	static class MyTask extends TimerTask{

		public void run() {
			
		}
		
	}
}
