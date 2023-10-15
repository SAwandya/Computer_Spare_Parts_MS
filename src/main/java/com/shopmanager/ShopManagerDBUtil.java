package com.shopmanager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ShopManagerDBUtil {
	
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	public static List<Item> getItemDetails(){
		
		ArrayList<Item> item = new ArrayList<>();
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "SELECT * FROM Item";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				int itemId = rs.getInt(1);
				String Type = rs.getString(7);
				String brandName = rs.getString(2);
				float unitPrice = rs.getFloat(8);
				String Location = rs.getString(3);
				int shopId = rs.getInt(5);
				int shopMgrId = rs.getInt(6);
				int amount = rs.getInt(9);
				
				Item i = new Item(itemId, Type, brandName, unitPrice, Location, shopId, shopMgrId, amount);
				
				item.add(i);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return item;
	}
	
	public static boolean incrementAmount(int id) {
		
		boolean isSuccess = false;
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "update Item set amount = amount + 1 where itemId = "+id+";";
			
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				isSuccess = true;
			}else {
				isSuccess = false;
			}
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	public static boolean decrementAmount(int id) {
		
		boolean isSuccess = false;
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "update Item set amount = amount - 1 where itemId = "+id+";";
			
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				isSuccess = true;
			}else {
				isSuccess = false;
			}
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	public static boolean deleteItems(int id) {
		
		boolean isSuccess = false;
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "DELETE FROM Item WHERE itemId="+id+"";
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				
				isSuccess = true;
			}else {
				
				isSuccess = false;
			}
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return isSuccess;
	}

	public static boolean updateItem(int id, String type, String brand, float unitprice, int amount) {
		
		boolean isSuccess = false;
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "update Item set type='"+type+"', brandName='"+brand+"', unitprice="+unitprice+", amount="+amount+" where itemId="+id+"";
			
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				isSuccess = true;
			}else {
				isSuccess = false;
			}
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return isSuccess;
	}
}
