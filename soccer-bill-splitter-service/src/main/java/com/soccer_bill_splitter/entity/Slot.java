package com.soccer_bill_splitter.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Slot {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long slotId;
	
	private String turfName;

	private String time;
	
	private BigDecimal perHead;
	
	//private String payeeName;
	
	@ManyToOne(targetEntity = User.class,cascade = CascadeType.ALL)
	@JoinColumn(name="payee_user_id_fk",referencedColumnName = "userId")
	private User user;
	
	
	@OneToMany(targetEntity = Player.class,cascade = CascadeType.ALL)
	@JoinColumn(name="slot_fk",referencedColumnName = "slotId")
	List<Player>playerList;
	
	private BigDecimal totalAmount;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;


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


	

	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public List<Player> getPlayerList() {
		return playerList;
	}


	public void setPlayerList(List<Player> playerList) {
		this.playerList = playerList;
	}


	public BigDecimal getTotalAmount() {
		return totalAmount;
	}


	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}


	public Date getCreatedOn() {
		return createdOn;
	}


	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	
	

}
