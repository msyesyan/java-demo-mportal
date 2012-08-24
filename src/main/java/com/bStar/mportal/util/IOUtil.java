package com.bStar.mportal.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.bStar.mportal.model.Channel;
import com.bStar.mportal.model.ChannelJson;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class IOUtil {
	public static void writeJson(File file,Object json) throws IOException{
		
		System.out.println("json"+JSONObject.fromObject(json).toString());
		
		System.out.println("lujing "+file.getAbsolutePath());
		if(!file.exists()){
			System.out.println("No");
			file.createNewFile();
		}
		if(file.exists()){
			System.out.println("Yes");
			BufferedWriter br = new BufferedWriter(new FileWriter(file));
			br.write(JSONObject.fromObject(json).toString());
			br.close();
		}	
		
		System.out.println("IoOver");
	}
	public static void main(String[] args) {
		File file = new File("hhel");
		System.out.println(file.getAbsolutePath());
	}
}
