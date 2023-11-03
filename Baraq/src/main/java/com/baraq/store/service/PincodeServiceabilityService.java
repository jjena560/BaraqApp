package com.baraq.store.service;

import com.baraq.store.requestdto.PincodeServiceabilityDTO;

public interface PincodeServiceabilityService {

	public void saveServiceability(PincodeServiceabilityDTO pincodeServiceabilityDTO);

	public boolean isServiceable(String sourcePincode, String destinationPincode, String paymentMode);
}
