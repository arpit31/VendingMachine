package com.market.machine.exception;

public class NotFullPaidException extends RuntimeException{
	int originalPrice;
	int actualPaid;
	String message;

	public int getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(int originalPrice) {
		this.originalPrice = originalPrice;
	}

	public int getActualPaid() {
		return actualPaid;
	}

	public void setActualPaid(int actualPaid) {
		this.actualPaid = actualPaid;
	}

	public String getMessage() {
		return (message + " remaining amount is " + (originalPrice - actualPaid));
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public NotFullPaidException(int originalPrice, int actualPaid, String message) {
		super();
		this.originalPrice = originalPrice;
		this.actualPaid = actualPaid;
		this.message = message;
	}

}
