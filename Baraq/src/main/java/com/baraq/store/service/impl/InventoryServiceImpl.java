package com.baraq.store.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baraq.store.model.Product;
import com.baraq.store.repository.ProductRepository;
import com.baraq.store.service.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService {
	@Autowired
	private ProductRepository productRepository;

    @SuppressWarnings("deprecation")
	public boolean hasSufficientStock(String productId, int quantity) {
    	Long pId = productId != null?Long.parseLong(productId):0;
    	Product product = productRepository.findById(pId).get();
    	if(product.getInventory() >= quantity) {
    		product.setInventory(product.getInventory() - quantity);
    		productRepository.save(product);
    		return true;
    	}
    	return false;
    }
}
