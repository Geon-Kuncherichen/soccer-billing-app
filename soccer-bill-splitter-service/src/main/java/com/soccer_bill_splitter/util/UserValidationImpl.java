package com.soccer_bill_splitter.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soccer_bill_splitter.dto.ResponseDto;
import com.soccer_bill_splitter.dto.UserDto;
import com.soccer_bill_splitter.repository.UserRepository;


@Service
public class UserValidationImpl implements ValidationService{
	
	@Autowired
	UserRepository userRepository;
	
	Logger logger = LogManager.getLogger(UserValidationImpl.class);
	
	public  ResponseDto isValid(UserDto user)
	{
		try {
			if(userRepository.existsByEmail(user.getEmail()))
				return UtilService.errorMessage("email already registered"); 
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return UtilService.errorMessage("error"); 
		}
		return UtilService.successMessage("success"); 
	}


	

}
