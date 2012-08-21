package com.bStar.mportal.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XmlUtil {

	public boolean isAbChildren(Element e) {
		boolean flag = true;
		Iterator i = e.elementIterator();
		int count = 0;
		while (i.hasNext()) {

			count++;
			i.next();
		}
		if (count > 1) {
			flag = false;
		}
		return flag;
	}

	public static List<Element> getAllChildren(Element e) {
		List<Element> lists = new ArrayList<Element>();
		Iterator i = e.elementIterator();
		while (i.hasNext()) {
			Element element = (Element) i.next();
			lists.add(element);
		}
		return lists;
	}
	public static String getTextByName(Element element,String name){
		List<Element>lists = getAllChildren(element);
		for (int i = 0; i < lists.size(); i++) {
			Element el = lists.get(i);
			if(el.getName().equals(name))
				return el.getText();
		}
		return null;
	}
	public Map<String,Element> parseXml(String fileName) {
		File file = new File(fileName);
		SAXReader saxReader = new SAXReader();
		Map<String, Element> map = new HashMap<String, Element>();
		XmlUtil xmlUtil = new XmlUtil();
		try {
			Document document = saxReader.read(file);
			Element employee = document.getRootElement();

			List<Element> employees = xmlUtil.getAllChildren(employee);
			for (int i = 0; i < employees.size(); i++) {
				Element element = employees.get(i);
				List<Element> datas = xmlUtil.getAllChildren(element);
				for(int j = 0;j<datas.size();j++){
					map.put(element.getName()+j, datas.get(j));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public static void main(String[] args) {
		String fileName = "F:\\Documents and Settings\\Administrator\\Workspaces\\MyEclipse 8.5\\mportal\\src\\test.xml";
		XmlUtil util = new XmlUtil();
		System.out.println(util.parseXml(fileName).size());;
	}
}
