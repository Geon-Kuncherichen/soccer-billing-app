package com.soccer_bill_splitter.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soccer_bill_splitter.dto.ResponseDto;
import com.soccer_bill_splitter.dto.SignInDto;
import com.soccer_bill_splitter.dto.UserDto;
import com.soccer_bill_splitter.service.UserService;

@RestController
@RequestMapping("/api/login")
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/saveUser")
	public ResponseEntity<ResponseDto>saveUser(@RequestBody @Valid UserDto user )
	{
		
		return new ResponseEntity<ResponseDto>(userService.saveUser(user),HttpStatus.OK);
	}
	
	@PostMapping("/signIn")
	public ResponseEntity<ResponseDto>signIn(@RequestBody @Valid SignInDto signInDto )
	{
		
		return new ResponseEntity<ResponseDto>(userService.signIn(signInDto),HttpStatus.OK);
	}
	
	@PutMapping("/logoutUser")
	public ResponseEntity<ResponseDto>logoutUser(Principal principal )
	{
		System.out.println(principal.getName());
		return null;
	//	return new ResponseEntity<ResponseDto>(userService.logoutUser(user),HttpStatus.OK);
	}
	
	@GetMapping("/hai")
	public String hai(Principal principal )
	{
		return "hai "+principal.getName();
	}

}
