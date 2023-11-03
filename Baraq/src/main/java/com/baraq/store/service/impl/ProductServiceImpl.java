package com.baraq.store.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baraq.store.model.Address;
import com.baraq.store.model.Product;
import com.baraq.store.repository.ProductRepository;
import com.baraq.store.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
    
	@Autowired
    private ProductRepository productRepository;

	@Transactional
    public Long createProduct(String name, int inventory, double price, Address pickupAddress) {
        Product product = new Product();
        product.setName(name);
        product.setInventory(inventory);
        product.setPrice(price);
        product.setAddress(pickupAddress);
        productRepository.save(product);
        return product.getProductId();
    }
}
