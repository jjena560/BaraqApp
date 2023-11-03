package com.baraq.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baraq.store.requestdto.PincodeServiceabilityDTO;
import com.baraq.store.service.PincodeServiceabilityService;

@RestController
@RequestMapping("/baraq/pincode-serviceability")
public class PincodeServiceabilityController {
	
	@Autowired
    private PincodeServiceabilityService pincodeServiceabilityService;


	@PostMapping("/create")
    public ResponseEntity<String> createServiceability(@RequestBody PincodeServiceabilityDTO pincodeServiceabilityDTO) {
        try {
            pincodeServiceabilityService.saveServiceability(pincodeServiceabilityDTO);
            return new ResponseEntity<>("Serviceability stored successfully.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error storing serviceability: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
