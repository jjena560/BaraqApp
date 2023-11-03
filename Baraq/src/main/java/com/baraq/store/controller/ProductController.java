package com.baraq.store.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baraq.store.model.Product;
import com.baraq.store.service.ProductService;

@RestController
@RequestMapping(value = "/baraq/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public Long createProduct(@RequestBody Product productRequest) {
        return productService.createProduct(productRequest.getName(), productRequest.getInventory(), productRequest.getPrice(), productRequest.getAddress());
    }
}
