package com.soccer_bill_splitter.service;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.soccer_bill_splitter.dto.PlayerDto;
import com.soccer_bill_splitter.dto.ResponseDto;
import com.soccer_bill_splitter.dto.SlotDto;
import com.soccer_bill_splitter.entity.Player;
import com.soccer_bill_splitter.entity.Slot;
import com.soccer_bill_splitter.repository.SlotRepository;
import com.soccer_bill_splitter.repository.UserRepository;
import com.soccer_bill_splitter.util.UtilService;

@Service
public class SlotServiceImpl implements SlotService{

	
	Logger logger = LogManager.getLogger(SlotServiceImpl.class);
	
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	SlotRepository slotRepository;
	
	final SimpleDateFormat monthDayYearformatter = new SimpleDateFormat("MMMMM dd, yyyy");

	@Override
	public CompletableFuture<ResponseDto> addSlot(SlotDto slotDto, Principal principal) {
		try {
			Slot slot=new Slot();
			BeanUtils.copyProperties(slotDto, slot);
			slot.setUser(userRepository.findById(slotDto.getPayeeId()).get());
			slot.setCreatedOn(new Date());
			List<Player>playerList=new ArrayList();
			slotDto.getPlayerList().forEach(player->{
				Player playerObj=new Player();
				playerObj.setCreatedDate(new Date());
				playerObj.setIsAttachmentPresent(false);
				playerObj.setPaidDate(null);
				playerObj.setPlayerName(player.getPlayerName());
				playerObj.setStatus(0);
				playerList.add(playerObj);
			});
			slot.setPlayerList(playerList);
			
			slotRepository.save(slot);
			return CompletableFuture.completedFuture(UtilService.successMessage("Slot created Successfully")) ;
			
		}catch(Exception e)
		{
			logger.error(e.getMessage(),e);
			return CompletableFuture.completedFuture( UtilService.errorMessage("Slot failed to create"));	
		}
	}

	@Override
	public CompletableFuture<List<SlotDto>> getSlotList(Principal principal) {
		try {
			if(StringUtils.isEmpty(principal))
				return CompletableFuture.completedFuture( new ArrayList());	
			
			List<Slot>slotList=slotRepository.findAll();
			if(slotList.isEmpty())
				return CompletableFuture.completedFuture( new ArrayList());	
			
			List<SlotDto>slotDtoList=new ArrayList();
			
			  
			slotList.forEach(slot->{
				SlotDto slotDto=new SlotDto();
				slotDto.setCreatedDate(monthDayYearformatter.format((java.util.Date) slot.getCreatedOn())); 
				slotDto.setPayeeName(slot.getUser().getUserName());
				slotDto.setTime(slot.getTime());
				slotDto.setPerHead(slot.getPerHead());
				slotDto.setSlotId(slot.getSlotId());
				slotDto.setTurfName(slot.getTurfName());
				slotDtoList.add(slotDto);
			});
			
			return CompletableFuture.completedFuture( slotDtoList);
		}catch(Exception e)
		{
			logger.error(e.getMessage(),e);
			return CompletableFuture.completedFuture( new ArrayList());	
		}
	}

	@Override
	public CompletableFuture<SlotDto> getSlot(Long slotId, Principal principal) {
		try {
			Optional<Slot>slot=slotRepository.findById(slotId);
			if(!slot.isPresent())
				return CompletableFuture.completedFuture( new SlotDto());	
			
			SlotDto slotDto=new SlotDto();
			slotDto.setCreatedDate(monthDayYearformatter.format((java.util.Date) slot.get().getCreatedOn())); 
			slotDto.setPayeeName(slot.get().getUser().getUserName());
			slotDto.setTime(slot.get().getTime());
			slotDto.setPerHead(slot.get().getPerHead());
			slotDto.setSlotId(slot.get().getSlotId());
			slotDto.setTurfName(slot.get().getTurfName());
			List<PlayerDto>playerDtoList=new ArrayList();
			slot.get().getPlayerList().forEach(player->{
				PlayerDto playerDto=new PlayerDto();
				playerDto.setCreatedDate(monthDayYearformatter.format((java.util.Date) player.getCreatedDate()));
				playerDto.setIsAttachmentPresent(player.getIsAttachmentPresent());
				playerDto.setPlayerId(player.getPlayerId());
				playerDto.setPlayerName(player.getPlayerName());
				playerDto.setStatus(player.getStatus()==0?"Not Paid":"Paid");
				if(!StringUtils.isEmpty(player.getPaidDate()))
				{
					playerDto.setPaidDate(monthDayYearformatter.format((java.util.Date) player.getPaidDate()));
				}else {
					playerDto.setPaidDate("Not Paid Till Now");
				}
				playerDtoList.add(playerDto);
				
			});
			slotDto.setPlayerList(playerDtoList);
			
			return CompletableFuture.completedFuture(slotDto);
			
		}catch(Exception e)
		{
			logger.error(e.getMessage(),e);
			return CompletableFuture.completedFuture( new SlotDto());	
		}
	}

	
	
	
}
