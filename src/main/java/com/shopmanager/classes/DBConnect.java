package com.shopmanager.classes;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

	private static String url = "jdbc:mysql://localhost:3306/inventory_managment_db";
	private static String userName = "root";
	private static String password = "Awandya2000@";
	private static Connection con;
	
	public static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, userName, password);
			
		}catch(Exception e) {
			
			System.out.println("Database connection is not success!");
		}
		
		return con;
	}
}
