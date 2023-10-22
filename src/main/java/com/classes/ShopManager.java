package com.classes;

public class ShopManager {
	
	private int shopMgrId;
	private String username;
	private String password;
	private String name;
	
	
	public ShopManager(int shopMgrId, String username, String password, String name) {
		
		this.shopMgrId = shopMgrId;
		this.username = username;
		this.password = password;
		this.name = name;
	}


	public int getShopMgrId() {
		return shopMgrId;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

}
