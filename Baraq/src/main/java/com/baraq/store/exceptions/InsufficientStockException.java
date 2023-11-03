package com.baraq.store.exceptions;

@SuppressWarnings("serial")
public class InsufficientStockException extends RuntimeException {

	public InsufficientStockException() {
		super("Order failed because product stock is insufficient");
	}

	public InsufficientStockException(String message) {
		super(message);
	}
}
