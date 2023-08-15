package com.bhushan_blogging_api.playload;

public class ApiResponse {

	private String message;
	private boolean succes;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isSucces() {
		return succes;
	}
	public void setSucces(boolean succes) {
		this.succes = succes;
	}
	public ApiResponse(String message, boolean succes) {
		super();
		this.message = message;
		this.succes = succes;
	}
	public ApiResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}

