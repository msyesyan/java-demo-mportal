package com.bStar.mportal.test;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.bStar.mportal.dao.MportalDao;
import com.bStar.mportal.dao.MportalDaoImpl;

public class Test {

	static MportalDao dao = new MportalDaoImpl();

	public static void main(String[] args) throws ParseException {
		/**
		try {
			
			List<Employee> lists = dao
					.parseXml("F:\\Documents and Settings\\Administrator"
							+ "\\Workspaces\\MyEclipse 8.5\\mportal\\src\\test.xml");
			for (int i = 0; i < lists.size(); i++) {
				dao.save(lists.get(i));
			}
			
			List<Employee>reList = dao.findAll();
			for(int i = 0;i<reList.size();i++){
				Employee e = reList.get(i);
				JSONArray arr = JSONArray.fromObject(e);
				System.out.println(arr.toString());
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
		//testTime();
		
		testTime2();
	}
	public static void testTime(){
		System.out.println(new SimpleDateFormat("yyyy-mm-dd HH:ss:mm+08").format(System.currentTimeMillis()));
	}
	public static void testTime2() throws ParseException{
		String beginTime="2011-09-09T05:16:00+08";
		String yearStr[] = beginTime.split("T");
		String hourStr[] = yearStr[1].split("\\+");
		String time=yearStr[0]+" "+hourStr[0];
		System.out.println(time);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-dd-mm HH:mm:ss");
		Date date  = df.parse(time);
		System.out.println(df.format(date));
	}

	
}
