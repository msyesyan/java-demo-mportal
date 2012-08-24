package com.bstar.mportal.util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class DateUtil {
	public static Date parseDate(String str) throws ParseException{
		String yearStr[] = str.split("T");
		String hourStr[] = yearStr[1].split("\\+");
		String time=yearStr[0]+" "+hourStr[0];
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		return format.parse(time);
	} 
	public static String parseISO8601(Date date){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		String dateString = format.format(date);
		String str[] = dateString.split("\\s"); 
		return str[0]+"T"+str[1]+"+08";
	}
	public static void main(String[] args) {
		System.out.println(parseISO8601(new Date()));
	}
}
