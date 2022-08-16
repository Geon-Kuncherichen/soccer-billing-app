package com.soccer_bill_splitter.controller;

import java.security.Principal;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soccer_bill_splitter.entity.Player;
import com.soccer_bill_splitter.service.PlayerService;

@RestController
@RequestMapping("/player")
public class PlayerController {
	
	@Autowired
	PlayerService playerService;
	
	@PostMapping("/addPlayer")
	public CompletableFuture<ResponseEntity> addPlayer(@RequestBody Player player,Principal principal)
	{
		return playerService.addPlayer(player,principal).thenApply(ResponseEntity::ok);
	}

}
