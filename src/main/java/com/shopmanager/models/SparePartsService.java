package com.shopmanager.models;

import java.util.List;

import com.shopmanager.classes.Item;

public interface SparePartsService {
	
	public List<Item> getItemDetails();
	
	public boolean incrementAmount(int id);
	
	public boolean undoPurchase(int id);
	
	public boolean undoSold(int id);
	
	public boolean decrementAmount(int id);
	
	public boolean deleteItems(int id);
	
	public boolean updateItem(int id, String type, String brand, float unitprice);
	
	public boolean insertItems(String brand, String location, int wid, int sid, int smid, String type, float unitPrice, int amount);
	
	public List<Item> searchItem(String details);

}
