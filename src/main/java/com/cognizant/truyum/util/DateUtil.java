package com.cognizant.truyum.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil 
{
    public static Date convertToDate(String indate) throws ParseException
	{
    	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    	Date date = formatter.parse(indate);
    	
    	return date;
	}

}
