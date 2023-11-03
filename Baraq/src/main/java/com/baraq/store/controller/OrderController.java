package com.baraq.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baraq.store.exceptions.InsufficientStockException;
import com.baraq.store.exceptions.PincodeUnserviceableException;
import com.baraq.store.requestdto.OrderDTO;
import com.baraq.store.service.OrderService;

@RestController
@RequestMapping("/baraq/orders")
public class OrderController {
    
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createOrder(@RequestBody OrderDTO dto) {
        try {
            String result = orderService.createOrder(dto.getBuyerId(), dto.getProductId(), dto.getQuantity(), dto.getPaymentMode());
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (PincodeUnserviceableException e) {
            return new ResponseEntity<>("Order failed because pincode is unserviceable", HttpStatus.BAD_REQUEST);
        } catch (InsufficientStockException e) {
            return new ResponseEntity<>("Order failed because product stock is insufficient", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Order creation failed: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // Other API endpoints for CRUD operations or retrieval

}
