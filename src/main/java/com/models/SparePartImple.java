package com.models;

import java.util.List;

import com.classes.Item;
import com.classes.ShopManager;

public class SparePartImple implements SparePartsService{
	
	
	public List<Item> getItemDetails(){
		
		return ShopManagerDBUtil.getItemDetails();
	}
	
	public boolean incrementAmount(int id) {
		
		boolean isSuccess = ShopManagerDBUtil.incrementAmount(id);
		
		return isSuccess;
	}
	
	public boolean undoPurchase(int id) {
		
		boolean isSuccess = ShopManagerDBUtil.undoPurchase(id);
		
		return isSuccess;
	}
	
	public boolean undoSold(int id) {
		
		boolean isSuccess = ShopManagerDBUtil.undoSold(id);
		
		return isSuccess;
	}
	
	public boolean decrementAmount(int id) {
		
		boolean isSuccess = ShopManagerDBUtil.decrementAmount(id);
		
		return isSuccess;
	}
	
	public boolean deleteItems(int id) {
		
		boolean isSuccess = ShopManagerDBUtil.deleteItems(id);
		
		return isSuccess;
	}
	
	public boolean updateItem(int id, String type, String brand, float unitprice) {
		
		boolean isSuccess = ShopManagerDBUtil.updateItem(id, type, brand, unitprice);
		
		return isSuccess;
	}
	
	public boolean insertItems(String brand, String location, int wid, int sid, int smid, String type, float unitPrice, int amount) {
		
		boolean isSuccess = ShopManagerDBUtil.insertItems(brand, location, wid, sid, smid, type, unitPrice, amount);
		
		return isSuccess;
	}
	
	public List<Item> searchItem(String details){
		
		return ShopManagerDBUtil.searchItem(details);
	}
	
	public List<ShopManager> validateShopManager(String username, String password){
		
		return ShopManagerDBUtil.validateShopManager(username, password);
	}
}
