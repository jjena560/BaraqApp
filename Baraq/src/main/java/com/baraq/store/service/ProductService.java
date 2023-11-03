package com.baraq.store.service;
import org.springframework.transaction.annotation.Transactional;

import com.baraq.store.model.Address;

public interface ProductService {
    

	@Transactional
    public Long createProduct(String name, int inventory, double price, Address pickupAddress);
}
