package com.maurya_ekart.exception;

public class SellerException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String message;

	public SellerException() {
		
		this.message = "Seller Exception";
	}
	
	public SellerException(String message) {
		super();
		this.message = message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
	
	
}
