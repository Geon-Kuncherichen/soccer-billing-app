package com.soccer_bill_splitter.controller;

import java.security.Principal;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.soccer_bill_splitter.dto.SlotDto;
import com.soccer_bill_splitter.service.SlotService;

@RestController
@RequestMapping("/slot")
public class SlotController {
	
	@Autowired
	SlotService slotService;
	
	@PostMapping("/addSlot")
	public CompletableFuture<ResponseEntity> addSlot(@RequestBody SlotDto slotDto,Principal principal)
	{
		return slotService.addSlot(slotDto,principal).thenApply(ResponseEntity::ok);
	}
	
	@GetMapping("/getSlotList")
	public CompletableFuture<ResponseEntity> getSlotList(Principal principal)
	{
		return slotService.getSlotList(principal).thenApply(ResponseEntity::ok);
	}
	
	@GetMapping("/getSlot")
	public CompletableFuture<ResponseEntity> getSlot(@RequestParam Long slotId ,Principal principal)
	{
		return slotService.getSlot(slotId,principal).thenApply(ResponseEntity::ok);
	}

}
