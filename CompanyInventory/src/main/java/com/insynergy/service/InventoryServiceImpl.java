package com.insynergy.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.insynergy.dao.InventoryDAO;
import com.insynergy.model.Inventory;

@Service
public class InventoryServiceImpl implements InventoryService {
	
	private InventoryDAO inventoryDAO;

	public void setInventoryDAO(InventoryDAO inventoryDAO) {
		this.inventoryDAO = inventoryDAO;
	}

	@Override
	@Transactional
	public void addInventory(Inventory i) {
		this.inventoryDAO.addInventory(i);
	}

	@Override
	@Transactional
	public void updateInventory(Inventory i) {
		this.inventoryDAO.updateInventory(i);
	}
	
	/*@Override
	@Transactional
	public void enterOtp(Inventory p) {
		this.personDAO.enterOtp(p);
	}*/

	@Override
	@Transactional
	public List<Inventory> listInventories() {
		
		System.out.println("=========== List service class");
		
		return this.inventoryDAO.listInventories();
	}

	@Override
	@Transactional
	public Inventory getInventoryById(int id) {
		return this.inventoryDAO.getInventoryById(id);
	}

	@Override
	@Transactional
	public void removeInventory(int id) {
		System.out.println("===========remove service class");
		
		this.inventoryDAO.removeInventory(id);
	}

	@Override
	public void sendNotification(Inventory i) {
		this.inventoryDAO.sendNotification(i);
		
	}

	/*@Override
	public List<Inventory> searchForInventory(String searchText) {
		// TODO Auto-generated method stub
		return null;
	}*/

	/*@Override
	public List<Inventory> searchForInventory(String searchText) {
		return this.inventoryDAO.searchForInventory( searchText );
	}*/
	
	 @Override
     @Transactional
		public List<Inventory> dosearch( String searchIteam) {
		
			
			return  this.inventoryDAO.doSearch( searchIteam);
		}


	


}
