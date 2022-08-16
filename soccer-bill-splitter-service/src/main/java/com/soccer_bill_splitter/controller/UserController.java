package com.soccer_bill_splitter.controller;


import java.security.Principal;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soccer_bill_splitter.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	@GetMapping("/getUserNameList")
	public CompletableFuture<ResponseEntity> getUserNameList(Principal principal )
	{
		return userService.getUserNameList().thenApply(ResponseEntity::ok);
	}

}
