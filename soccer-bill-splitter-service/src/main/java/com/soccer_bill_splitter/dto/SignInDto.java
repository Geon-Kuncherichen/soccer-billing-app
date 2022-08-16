package com.soccer_bill_splitter.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SignInDto {

	@NotNull(message = "email cannot be empty")
	@NotBlank
	private String email;

	@NotNull(message = "password cannot be empty")
	@NotBlank
	private String password;

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
	
	

}
