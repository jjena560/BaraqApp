package com.baraq.store.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baraq.store.model.Buyer;
import com.baraq.store.service.BuyerService;

@RestController
@RequestMapping(value = "/baraq/buyers")
public class BuyerController {

	@Autowired
    private BuyerService buyerService;
    

    @PostMapping(value = "/add")
    public Long createBuyer(@RequestBody Buyer buyerRequest) {
        return buyerService.createBuyer(buyerRequest.getName(), buyerRequest.getAddress());
    }

    @GetMapping("/buyers/{id}")
    public Buyer getBuyer(@PathVariable Long id ) {
        return buyerService.getBuyer(id);
    }
    
    @GetMapping("")
    public String getBuyerOne() {
        return "Buyer";
    }
      
    
    
}
