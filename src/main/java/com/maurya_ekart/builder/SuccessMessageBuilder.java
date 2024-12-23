package com.maurya_ekart.builder;

import java.util.Objects;

import jakarta.ws.rs.core.Response.Status;




public class SuccessMessageBuilder {

	private Status statusCode;
	private String message;
	

	SuccessMessageBuilder(Status statusCode) {
		super();
		this.statusCode = statusCode;
	}


	public static SuccessMessageBuilder statusCode(Status httpStatus){
		return new SuccessMessageBuilder(httpStatus);
	}
	
	public SuccessMessageBuilder message(String message){
		this.message=message;
		return this;
	}

	
	public SuccessMessage build(){
		Objects.requireNonNull(this.statusCode,"statusCode must not be null");
		return new SuccessMessage(this.statusCode, this.message);
	}

}
