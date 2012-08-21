package com.bStar.mportal.dao;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.bStar.mportal.pojo.Employee;
import com.bStar.mportal.util.Dbutil;
import com.bStar.mportal.util.XmlUtil;

public class MportalDaoImpl implements MportalDao {

	public static final String save = "insert into employee (name,sex,age) values(?,?,?)";
	public static final String findAll = "select * from employee";
	public void createXml(String fileName) throws Exception {

	}
	public static void main(String[] args) throws Exception {
		MportalDaoImpl dao = new MportalDaoImpl();
		System.out.println(
				dao.parseXml("E:/Users/msyesyan/Workspaces/MyEclipse 8.5/mportal/src/test.xml")
				.get(2).getName());
	}
	public List<Employee> parseXml(String fileName) throws Exception {
		File file = new File(fileName);
		SAXReader saxReader = new SAXReader();
		XmlUtil xmlUtil = new XmlUtil();
		List<Employee> lists = new ArrayList<Employee>();
		try {
			Document document = saxReader.read(file);
			Element employee = document.getRootElement();
			List<Element> employees = xmlUtil.getAllChildren(employee);
			for (int i = 0; i < employees.size(); i++) {
				Element element = employees.get(i);
				Employee em = new Employee();
				em.setName(xmlUtil.getTextByName(element, "name"));
				em.setSex(xmlUtil.getTextByName(element, "sex"));
				em.setAge(Integer.parseInt(xmlUtil.getTextByName(element, "age")));
				lists.add(em);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lists;

	}

	public List<Employee> findAll() throws Exception {
		ResultSet rs = Dbutil.getConnection().createStatement().executeQuery(findAll);
		List<Employee>lists = new ArrayList<Employee>();
		while(rs.next()){
			Employee e = new Employee();
			e.setId();
			e.setName(rs.getString("name"));
			e.setSex(rs.getString("sex"));
			e.setAge(rs.getInt("age"));
			lists.add(e);
		}
		return lists;
	}

	public String findById() throws Exception {
		return null;
	}

	public void save(Employee e) throws Exception {
		PreparedStatement prep = Dbutil.getConnection().prepareStatement(save);
		prep.setString(1, e.getName());
		prep.setString(2, e.getSex());
		prep.setInt(3, e.getAge());
		prep.executeUpdate();

	}

}
