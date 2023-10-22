package com.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.classes.DBConnect;
import com.classes.Item;
import com.classes.ShopManager;

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
			String sql = "SELECT * FROM Item WHERE location='shop'";
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
				int purchase = rs.getInt(10);
				int sold = rs.getInt(11);
				
				Item i = new Item(itemId, Type, brandName, unitPrice, Location, shopId, shopMgrId, amount, purchase, sold);
				
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
			String sql = "update Item set amount = amount + 1, purchase = purchase + 1 where itemId = "+id+";";
			
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
	
	public static boolean undoPurchase(int id) {
		
		boolean isSuccess = false;
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "update Item set amount = amount - 1, purchase = purchase - 1 where itemId = "+id+";";
			
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
	
	public static boolean undoSold(int id) {
		
		boolean isSuccess = false;
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "update Item set amount = amount + 1, sold = sold - 1 where itemId = "+id+";";
			
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
			String sql = "update Item set amount = amount - 1, sold = sold + 1 where itemId = "+id+";";
			
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

	public static boolean updateItem(int id, String type, String brand, float unitprice) {
		
		boolean isSuccess = false;
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "update Item set type='"+type+"', brandName='"+brand+"', unitprice="+unitprice+" where itemId="+id+"";
			
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
	
	public static boolean insertItems(String brand, String location, int wid, int sid, int smid, String type, float unitPrice, int amount) {
		
		isSuccess = false;
		
		try {
	        con = DBConnect.getConnection();
	        stmt = con.createStatement();
	        
	        String sql = "INSERT INTO Item VALUES(0, '"+brand+"', '"+location+"', "+wid+", "+sid+", "+smid+", '"+type+"', "+unitPrice+", "+amount+", "+amount+", 0);";
	        
	        int rs = stmt.executeUpdate(sql);
	        
	        if (rs > 0) {
	            isSuccess = true;
	        } else {
	            isSuccess = false;
	        }
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return isSuccess;

	    }
	
	public static List<Item> searchItem(String details){
		
		ArrayList<Item> item = new ArrayList<>();
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "SELECT * FROM Item WHERE location='shop' AND type LIKE LOWER('%"+details+"%') OR brandName LIKE LOWER('%"+details+"%')";
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
				int purchase = rs.getInt(10);
				int sold = rs.getInt(11);
				
				Item i = new Item(itemId, Type, brandName, unitPrice, Location, shopId, shopMgrId, amount, purchase, sold);
				
				item.add(i);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return item;
	}
	
	public static List<ShopManager> validateShopManager(String username, String password){
		
		ArrayList<ShopManager> manager = new ArrayList<>();
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "SELECT * FROM shopManager WHERE username='"+username+"' and password='"+password+"'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int mid = rs.getInt(1);
				String uname = rs.getString(2);
				String name = rs.getString(4);
				String pwd = rs.getString(3);
				
				ShopManager mgr = new ShopManager(mid, uname, name, pwd);
				
				manager.add(mgr);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return manager;
	}
	
	
	
}
