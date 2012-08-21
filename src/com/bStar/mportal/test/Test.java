package com.bStar.mportal.test;

import java.util.List;

import net.sf.json.JSONArray;

import com.bStar.mportal.dao.MportalDao;
import com.bStar.mportal.dao.MportalDaoImpl;
import com.bStar.mportal.pojo.Employee;

public class Test {

	static MportalDao dao = new MportalDaoImpl();

	public static void main(String[] args) {
		try {
			/*
			List<Employee> lists = dao
					.parseXml("F:\\Documents and Settings\\Administrator"
							+ "\\Workspaces\\MyEclipse 8.5\\mportal\\src\\test.xml");
			for (int i = 0; i < lists.size(); i++) {
				dao.save(lists.get(i));
			}
			*/
			List<Employee>reList = dao.findAll();
			for(int i = 0;i<reList.size();i++){
				Employee e = reList.get(i);
				JSONArray arr = JSONArray.fromObject(e);
				System.out.println(arr.toString());
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
