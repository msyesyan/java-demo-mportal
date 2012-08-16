package com.bStar.dao;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



public class XmlDao {
	
	public static void main(String[] args) {
		load("E:\\Users\\msyesyan\\Workspaces\\MyEclipse 8.5\\mportal/src/test.xml");
	}
	//将document中的内容写入文件中
	public static boolean doc2XmlFile(Document document,String fileName) {
		//File document = new File(
		//		"E:\\Users\\msyesyan\\Workspaces\\MyEclipse 8.5\\mportal/src/test.xml");

		boolean flag = true;
		try {
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.ENCODING,"UTF-8");
			DOMSource source = new DOMSource();
			StreamResult result = new StreamResult(new File(fileName));
			transformer.transform(source, result);
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}
	
	public static Document load(String fileName){
		
		Document document = null;
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			document = builder.parse(new File(fileName));
			Element element = document.getDocumentElement();
			NodeList nodeList = element.getChildNodes();
			for(int i = 0;i<nodeList.getLength();i++){
				Node result = nodeList.item(i);
				System.out.println(result.getTextContent()+" "+result.getNodeType());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return document;
	}
	
}
