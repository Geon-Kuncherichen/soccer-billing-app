package com.soccer_bill_splitter.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserDto {

	private Long userId;

	@NotNull(message = "email cannot be empty")
	@NotBlank
	private String email;

	private String userName;

	@NotNull(message = "password cannot be empty")
	@NotBlank
	private String password;

	private Date createdOn;

	private Boolean isLoggedIn;

	@NotNull(message = "Gpay Number cannot be empty")
	@NotBlank
	private String gpayNumber;

	private String upiId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Boolean getIsLoggedIn() {
		return isLoggedIn;
	}

	public void setIsLoggedIn(Boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public UserDto(Long userId, String userName) {

		this.userId = userId;
		this.userName = userName;
	}
	
	

	public String getGpayNumber() {
		return gpayNumber;
	}

	public void setGpayNumber(String gpayNumber) {
		this.gpayNumber = gpayNumber;
	}

	public String getUpiId() {
		return upiId;
	}

	public void setUpiId(String upiId) {
		this.upiId = upiId;
	}

	public UserDto() {

	}

}
