package com.baraq.store.service;

public interface OrderService {

    
    public String createOrder(String buyerId, String productId, int quantity, String paymentMode);
}
