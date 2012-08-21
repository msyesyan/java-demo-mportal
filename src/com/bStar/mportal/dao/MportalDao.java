package com.bStar.mportal.dao;

import java.util.List;

import com.bStar.mportal.pojo.Employee;

public interface MportalDao {
	public void createXml(String fileName)throws Exception;
	public List<Employee> parseXml(String fileName)throws Exception;
	public void save(Employee e)throws Exception;
	public List<Employee> findAll()throws Exception;
	public String findById()throws Exception;
	
}
