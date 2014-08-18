package com.lk.savsiri.activities;

import android.app.ActionBar.OnNavigationListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;

import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.lk.savsiri.R;
import com.lk.savsiri.DAO.ProfileDAO;
import com.lk.savsiri.DAO.ProfileDAO.ProfileDataCallBackListner;
import com.lk.savsiri.constants.SavsiriConstants;
import com.lk.savsiri.data.AuthData;
import com.lk.savsiri.data.ProfileData;
import com.lk.savsiri.utils.Utils;

public class MatchingProfilesActivity extends SaviriBaseActivity implements OnNavigationListener,
																			ProfileDataCallBackListner,
																			OnRefreshListener{
	
	AuthData authData;
	Gson gson;
	
	SwipeRefreshLayout swipeLayout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		getCustomActionbar(this,MATCHING_PROFILES);
		setContentView(R.layout.matching_profiles_layout);
		
		gson=new Gson();
		
		String userString=Utils.getJsonSharedPreference(this, SavsiriConstants.SS_USER_KEY);
		authData=gson.fromJson(userString, AuthData.class);
		
		ProfileDAO profileService=new ProfileDAO(this, this);
		profileService.getMatchingProfiles(authData.getUserData().getUser().getSex());
		
		swipeLayout=(SwipeRefreshLayout) findViewById(R.id.swipe_container);
		swipeLayout.setOnRefreshListener(this);
		swipeLayout.setColorScheme(android.R.color.holo_blue_bright, 
                android.R.color.holo_green_light, 
                android.R.color.holo_orange_light, 
                android.R.color.holo_red_light);

	}
	

	@Override
	public boolean onNavigationItemSelected(int position, long arg1) {
		
		switch (position) {
		case 0:

			return false;
			
		case 1:
			
			Intent intent=new Intent(this,ProfileActivity.class);
			startActivity(intent);
			
			return true;
			
		case 2:
			Intent shortList=new Intent(this,ShortListProfileActivity.class);
			startActivity(shortList);
			return true;

		default:
			
			
			return false;
			
		}
		
	}


	@Override
	public void onProfileDataRetriveSuccess(ProfileData profileData) {
		
		System.out.println("PROFILESSSSS    "+profileData.getProfiles().size());
	}


	@Override
	public void onProfileDataRetriveError(VolleyError error) {
		
		
	}


	@Override
	public void onRefresh() {
		System.out.println("REFRESHING");
		
	}
	
	
	
}
