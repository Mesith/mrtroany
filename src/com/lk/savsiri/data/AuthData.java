package com.lk.savsiri.data;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.lk.savsiri.DTO.AuthDTO;




public class AuthData  {
	
	
	@SerializedName("data")
	AuthDTO userData;

	public AuthDTO getUserData() {
		return userData;
	}

	public void setUserData(AuthDTO userData) {
		this.userData = userData;
	}

	

	
	
	

}
