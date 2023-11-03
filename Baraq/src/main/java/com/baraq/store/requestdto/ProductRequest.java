package com.baraq.store.requestdto;

import com.baraq.store.model.Address;

public class ProductRequest {
    private String name;
    private int inventory;
    private double price;
    private Address pickupAddress;
    
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getInventory() {
		return inventory;
	}
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Address getPickupAddress() {
		return pickupAddress;
	}
	public void setPickupAddress(Address pickupAddress) {
		this.pickupAddress = pickupAddress;
	}
	
}
