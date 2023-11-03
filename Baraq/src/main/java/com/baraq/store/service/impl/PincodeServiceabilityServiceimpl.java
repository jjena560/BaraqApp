package com.baraq.store.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baraq.store.model.PincodeServiceability;
import com.baraq.store.repository.PincodeServiceabilityRepository;
import com.baraq.store.requestdto.PincodeServiceabilityDTO;
import com.baraq.store.service.PincodeServiceabilityService;

@Service
public class PincodeServiceabilityServiceimpl implements PincodeServiceabilityService{
	@Autowired
	private PincodeServiceabilityRepository pincodeServiceabilityRepository;
	
    private Map<String, String> serviceabilityMap;

    void populateMap() {
        serviceabilityMap = new HashMap<>();
        List<PincodeServiceability> serviceabilityList = (List<PincodeServiceability>) pincodeServiceabilityRepository.findAll();

        for (PincodeServiceability serviceability : serviceabilityList) {
            String sourcePincode = serviceability.getSourcePincode();
            String destinationPincode = serviceability.getDestinationPincode();
            String paymentMode = serviceability.getPaymentMode();
            String valuePair = sourcePincode + "-" + destinationPincode;

//            serviceabilityMap.putIfAbsent(paymentMode);

            serviceabilityMap.put(paymentMode,valuePair);
              
        }
    }

	public void saveServiceability(PincodeServiceabilityDTO pincodeServiceabilityDTO) {
		PincodeServiceability serviceAbility = new PincodeServiceability();
		if (pincodeServiceabilityDTO != null) {
			serviceAbility.setSourcePincode(pincodeServiceabilityDTO.getSourcePincode());
			serviceAbility.setDestinationPincode(pincodeServiceabilityDTO.getDestinationPincode());
			serviceAbility.setPaymentMode(pincodeServiceabilityDTO.getPaymentMode());

		}
		pincodeServiceabilityRepository.save(serviceAbility);

	}

	public boolean isServiceable(String sourcePincode, String destinationPincode, String paymentMode) {

		populateMap();
		if (serviceabilityMap.containsKey(paymentMode)) {
            String sourceDestinationMap = serviceabilityMap.get(paymentMode);
            String value = sourcePincode + "-" + destinationPincode;
            
            // Check if the key (source-destination) exists in the map
            return sourceDestinationMap.contains(value);
        }
        
        return false;
	}
}
