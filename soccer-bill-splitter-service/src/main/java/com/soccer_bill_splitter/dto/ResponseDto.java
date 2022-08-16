package com.soccer_bill_splitter.dto;

import java.util.HashMap;

public class ResponseDto {
	
	
	private String status;
	
	private String message;
	
	private HashMap<String,String>details;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HashMap<String, String> getDetails() {
		return details;
	}

	public void setDetails(HashMap<String, String> details) {
		this.details = details;
	}
	
	

}
