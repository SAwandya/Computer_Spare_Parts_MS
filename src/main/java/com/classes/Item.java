package com.classes;

public class Item {
	
	private int itemId;
	private String type;
	private String brandName;
	private float unitPrice;
	private String Location;
	private int shopId;
	private int shopMgrId;
	private int amount;
	private int purchase;
	private int sold;
	
	public Item(int itemId, String type, String brandName, float unitPrice, String location, int shopId, int shopMgrId,
			int amount, int purchase, int sold) {
		
		this.itemId = itemId;
		this.type = type;
		this.brandName = brandName;
		this.unitPrice = unitPrice;
		this.Location = location;
		this.shopId = shopId;
		this.shopMgrId = shopMgrId;
		this.amount = amount;
		this.purchase = purchase;
		this.sold = sold;
	}

	public int getItemId() {
		return itemId;
	}
	
	public int getPurchase() {
		
		return purchase;
	}
	
	public int getSold() {
		
		return sold;
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
