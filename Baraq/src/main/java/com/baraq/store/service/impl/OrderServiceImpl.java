package com.baraq.store.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baraq.store.exceptions.InsufficientStockException;
import com.baraq.store.exceptions.PincodeUnserviceableException;
import com.baraq.store.model.Buyer;
import com.baraq.store.model.Order;
import com.baraq.store.model.Product;
import com.baraq.store.repository.BuyerRepository;
import com.baraq.store.repository.OrderRepository;
import com.baraq.store.repository.ProductRepository;
import com.baraq.store.service.InventoryService;
import com.baraq.store.service.OrderService;
import com.baraq.store.service.PincodeServiceabilityService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private InventoryService inventoryService;

	@Autowired
	private PincodeServiceabilityService pincodeServiceabilityService;

	@Autowired
	private OrderRepository orderRepo;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private BuyerRepository buyerRepository;

	@Transactional
	public String createOrder(String buyerId, String productId, int quantity, String paymentMode) {
		Buyer buyer = buyerRepository.findById(Long.parseLong(buyerId)).get();
		Product product = productRepository.findById(Long.parseLong(productId)).get();

		// Check pincode serviceability
		if (!pincodeServiceabilityService.isServiceable(product.getAddress().getPinCode(),
				buyer.getAddress().getPinCode(), paymentMode)) {
			throw new PincodeUnserviceableException();
		}

		// Check inventory availability
		if (!inventoryService.hasSufficientStock(productId, quantity)) {
			throw new InsufficientStockException();
		}

		Order order = new Order();
		order.setBuyerId(buyerId);
		order.setProductId(productId);
		order.setQuantity(quantity);
		order.setPaymentMode(paymentMode);
		orderRepo.save(order);
		return String.format("Order created successfully with ID: %d", order.getOrderId());
	}
}
