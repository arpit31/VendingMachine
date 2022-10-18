package com.market.machine.exception;

public class ItemsOutOfStockException {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ItemsOutOfStockException(String message) {
		super();
		this.message = message;
	}

}
