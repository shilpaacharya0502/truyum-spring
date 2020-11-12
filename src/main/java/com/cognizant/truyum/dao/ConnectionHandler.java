package com.cognizant.truyum.dao;
import java.sql.SQLException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionHandler 
{
	private static Connection conn=null;
	private static Properties props=new Properties();
	public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException
	{
		FileInputStream fis=null;
		try 
		{
			fis=new FileInputStream("connection.properties");
			props.load(fis);
			Class.forName(props.getProperty("driver"));
			conn=DriverManager.getConnection(props.getProperty("connection-url"),props.getProperty("user"),props.getProperty("password"));
			
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		return conn;
		
	}
}
