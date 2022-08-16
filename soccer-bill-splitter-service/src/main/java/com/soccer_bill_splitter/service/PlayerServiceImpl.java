package com.soccer_bill_splitter.service;

import java.security.Principal;
import java.util.Date;
import java.util.concurrent.CompletableFuture;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soccer_bill_splitter.dto.ResponseDto;
import com.soccer_bill_splitter.entity.Player;
import com.soccer_bill_splitter.repository.PlayerRepository;
import com.soccer_bill_splitter.util.UtilService;


@Service
public class PlayerServiceImpl implements PlayerService{
	
	//@Autowired
	//PlayerRepository playerRepository;
	
	Logger logger = LogManager.getLogger(PlayerServiceImpl.class);

	@Override
	public CompletableFuture<ResponseDto> addPlayer(Player player, Principal principal) {
		try {
			Player playerObj=new Player();
			playerObj.setStatus(0);
			playerObj.setPlayerName(player.getPlayerName());
			playerObj.setIsAttachmentPresent(false);
			playerObj.setCreatedDate(new Date());
			//playerRepository.save(player);
			
			return CompletableFuture.completedFuture(UtilService.successMessage("Player created successfully"));	
			
		}catch(Exception e)
		{
			logger.error(e.getMessage(), e);
			return CompletableFuture.completedFuture(UtilService.errorMessage("Player creation failed"));	
		}
	}

}
