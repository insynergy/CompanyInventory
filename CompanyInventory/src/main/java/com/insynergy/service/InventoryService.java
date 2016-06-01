package com.insynergy.service;

import java.util.List;

import com.insynergy.model.Inventory;

public interface InventoryService {

	public void addInventory(Inventory i);
	public void updateInventory(Inventory i);
//	public void enterOtp(Inventory p);
	public List<Inventory> listInventories();
	public Inventory getInventoryById(int id);
	public void removeInventory(int id);
	public void sendNotification(Inventory i);
	// public boolean checkLogin(String uname, String pwd);
//public List<Inventory> searchForInventory(String searchText);
public List<Inventory> dosearch(String searchIteam);
	
}
