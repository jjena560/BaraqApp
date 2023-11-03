package com.baraq.store.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baraq.store.model.Address;
import com.baraq.store.model.Buyer;
import com.baraq.store.repository.AddressRepository;
import com.baraq.store.repository.BuyerRepository;
import com.baraq.store.service.BuyerService;


@Service
public class BuyerServiceImpl implements BuyerService {
    
	@Autowired
    private BuyerRepository buyerRepository;
	
	@Autowired
    private AddressRepository addressRepository;
    
   
	@Transactional
    public Long createBuyer(String name, Address add) {
       
        Address address = new Address();
        address.setStreet(add.getStreet());
        address.setCity(add.getCity());
        address.setCountry(add.getCountry());
        address.setPinCode(add.getPinCode());
        
        addressRepository.save(address);

        Buyer buyer = new Buyer();
        buyer.setName(name);
        buyer.setAddress(address);

        buyerRepository.save(buyer);
        return buyer.getId();
    }

	public Buyer getBuyer(Long id) {
		return buyerRepository.findById(id).get();
	}
}
