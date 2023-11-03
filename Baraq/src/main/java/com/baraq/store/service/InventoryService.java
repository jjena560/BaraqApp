package com.baraq.store.service;

public interface InventoryService {

	public boolean hasSufficientStock(String productId, int quantity);
}
