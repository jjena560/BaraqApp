package com.baraq.store.exceptions;

@SuppressWarnings("serial")
public class PincodeUnserviceableException extends RuntimeException {

    public PincodeUnserviceableException() {
        super("Order failed because pincode is unserviceable");
    }

    public PincodeUnserviceableException(String message) {
        super(message);
    }
}
