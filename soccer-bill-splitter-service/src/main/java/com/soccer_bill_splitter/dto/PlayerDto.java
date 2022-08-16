package com.soccer_bill_splitter.dto;

import java.util.Date;



public class PlayerDto {
	
	private Long playerId;

	private String playerName;

	private String paidDate;
	
	private String createdDate;
	
	private String status;
	
	private Boolean isAttachmentPresent;

	public Long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPaidDate() {
		return paidDate;
	}

	public void setPaidDate(String paidDate) {
		this.paidDate = paidDate;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getIsAttachmentPresent() {
		return isAttachmentPresent;
	}

	public void setIsAttachmentPresent(Boolean isAttachmentPresent) {
		this.isAttachmentPresent = isAttachmentPresent;
	}
	
	

}
