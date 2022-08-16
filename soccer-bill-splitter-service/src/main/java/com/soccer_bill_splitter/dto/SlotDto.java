package com.soccer_bill_splitter.dto;

import java.math.BigDecimal;
import java.util.List;



import com.soccer_bill_splitter.entity.Player;


public class SlotDto {

	private Long slotId;

	private String turfName;

	private String time;

	private BigDecimal perHead;

	private Long payeeId;
	
	private BigDecimal totalAmount;

	private List<PlayerDto> playerList;
	
	private String createdDate;
	
	private String payeeName;

	public Long getSlotId() {
		return slotId;
	}

	public void setSlotId(Long slotId) {
		this.slotId = slotId;
	}

	public String getTurfName() {
		return turfName;
	}

	public void setTurfName(String turfName) {
		this.turfName = turfName;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public BigDecimal getPerHead() {
		return perHead;
	}

	public void setPerHead(BigDecimal perHead) {
		this.perHead = perHead;
	}

	

	public List<PlayerDto> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(List<PlayerDto> playerList) {
		this.playerList = playerList;
	}

	public Long getPayeeId() {
		return payeeId;
	}

	public void setPayeeId(Long payeeId) {
		this.payeeId = payeeId;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getPayeeName() {
		return payeeName;
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}
	
	

}
