package com.lk.savsiri.activities;

import com.lk.savsiri.domain.User;

import android.app.Application;

public class SavsiriAppilicationContext extends Application {
	
	
	User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	

}
