package com.soccer_bill_splitter.util;



import com.soccer_bill_splitter.dto.ResponseDto;

public class UtilService {
	
	
	public static ResponseDto errorMessage(String msg) {
		ResponseDto response = new ResponseDto();
		response.setStatus("failed");
		response.setMessage(msg);
		
		return response;
	}

	public static ResponseDto successMessage(String msg) {
		ResponseDto response = new ResponseDto();
		response.setStatus("success");
		response.setMessage(msg);
		return response;
	
	}

}
