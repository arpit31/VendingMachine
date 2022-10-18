package com.market.machine.exception;

public class NotSufficientPaidException {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public NotSufficientPaidException(String message) {
		super();
		this.message = message;
	}

}
