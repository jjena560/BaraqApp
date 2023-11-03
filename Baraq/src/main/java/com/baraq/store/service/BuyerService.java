package com.baraq.store.service;
import org.springframework.stereotype.Service;

import com.baraq.store.model.Address;
import com.baraq.store.model.Buyer;


@Service
public interface BuyerService {
   
	
    public Long createBuyer(String name, Address add);

	public Buyer getBuyer(Long id);
}
