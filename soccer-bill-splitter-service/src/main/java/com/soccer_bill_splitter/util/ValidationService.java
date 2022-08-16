package com.soccer_bill_splitter.util;

import com.soccer_bill_splitter.dto.ResponseDto;
import com.soccer_bill_splitter.dto.UserDto;

public interface ValidationService {
	
	ResponseDto isValid(UserDto user);

}
