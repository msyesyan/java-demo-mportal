package com.bstar.mportal.service;

import java.net.HttpURLConnection;
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
	}
	
	static class MyTask extends TimerTask{

		public void run() {
			
		}
		
	}
}
