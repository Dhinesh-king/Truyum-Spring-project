package com.cognizant.truyum.model;

import javax.validation.constraints.NotBlank;

public class LoginData {

	@NotBlank(message = "User Name is Required")
	private String userName;
	@NotBlank(message = "Password is Required")
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
