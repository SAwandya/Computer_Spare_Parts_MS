package com.shopmanager;

public class Item {
	
	private int itemId;
	private String type;
	private String brandName;
	private float unitPrice;
	private String Location;
	private int shopId;
	private int shopMgrId;
	private int amount;
	
	public Item(int itemId, String type, String brandName, float unitPrice, String location, int shopId, int shopMgrId,
			int amount) {
		
		this.itemId = itemId;
		this.type = type;
		this.brandName = brandName;
		this.unitPrice = unitPrice;
		Location = location;
		this.shopId = shopId;
		this.shopMgrId = shopMgrId;
		this.amount = amount;
	}

	public int getItemId() {
		return itemId;
	}

	
	public String gettype() {
		return type;
	}


	public String getBrandName() {
		return brandName;
	}

	
	public float getUnitPrice() {
		return unitPrice;
	}



	public String getLocation() {
		return Location;
	}

	

	public int getShopId() {
		return shopId;
	}

	

	public int getShopMgrId() {
		return shopMgrId;
	}



	public int getAmount() {
		return amount;
	}

	
	
	
	

}
