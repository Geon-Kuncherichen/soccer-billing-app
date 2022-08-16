package com.soccer_bill_splitter.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long playerId;

	private String playerName;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date paidDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	
	private Integer status;
	
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

	public Date getPaidDate() {
		return paidDate;
	}

	public void setPaidDate(Date paidDate) {
		this.paidDate = paidDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Boolean getIsAttachmentPresent() {
		return isAttachmentPresent;
	}

	public void setIsAttachmentPresent(Boolean isAttachmentPresent) {
		this.isAttachmentPresent = isAttachmentPresent;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	

}
