package com.soccer_bill_splitter.exception;

import java.util.HashMap;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.soccer_bill_splitter.dto.ResponseDto;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException ex) {
//    	System.out.println("*************************");
//        Map<String, String> errorMap = new HashMap<>();
//        ex.getBindingResult().getFieldErrors().forEach(error -> {
//            errorMap.put(error.getField(), error.getDefaultMessage());
//        });
//        return errorMap;
//    }

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		System.out.println("*************************");
		ResponseDto response = new ResponseDto();
		HashMap<String, String> errorMap = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error -> {
			errorMap.put(error.getField(), error.getDefaultMessage());
		});

		response.setStatus( "failed");
		response.setMessage("Validation failed");
		response.setDetails(errorMap);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@ExceptionHandler(UsernameNotFoundException.class)
	public ResponseEntity<ResponseDto>handleUserNotFoundException(UsernameNotFoundException exe)
	{
		System.out.println("-----********-------");
		ResponseDto response = new ResponseDto();
		response.setStatus( "failed");
		response.setMessage("Email not found");
		//response.setDetails(errorMap);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
	
	

}