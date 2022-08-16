package com.soccer_bill_splitter.service;

import java.security.Principal;
import java.util.concurrent.CompletableFuture;

import com.soccer_bill_splitter.dto.ResponseDto;
import com.soccer_bill_splitter.entity.Player;

public interface PlayerService {
	
	CompletableFuture<ResponseDto> addPlayer(Player player,Principal principal);

}
