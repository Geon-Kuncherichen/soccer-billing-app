package com.soccer_bill_splitter.service;

import java.security.Principal;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.http.ResponseEntity;

import com.soccer_bill_splitter.dto.ResponseDto;
import com.soccer_bill_splitter.dto.SlotDto;

public interface SlotService {

	CompletableFuture<ResponseDto> addSlot(SlotDto slotDto, Principal principal);

	CompletableFuture<List<SlotDto>> getSlotList(Principal principal);

	CompletableFuture<SlotDto> getSlot(Long slotId, Principal principal);

}
