package com.lk.savsiri.activities;

import com.lk.savsiri.domain.User;

import android.app.Application;

public class SavsiriAppilicationContext extends Application {
	
	
	User user;
	
	
	
	private boolean isFirstTime;
	
	
	

	public boolean isFirstTime() {
		return isFirstTime;
	}

	public void setFirstTime(boolean isFirstTime) {
		this.isFirstTime = isFirstTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	

}
