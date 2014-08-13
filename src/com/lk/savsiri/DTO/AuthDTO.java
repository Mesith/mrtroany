package com.lk.savsiri.DTO;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.lk.savsiri.domain.User;


public class AuthDTO {
	
	@SerializedName("user")
	public User user;
	
	@SerializedName("message")
	String message;
	
	@SerializedName("success")
	String success;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	
	
	

}
