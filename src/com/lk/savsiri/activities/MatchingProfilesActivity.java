package com.lk.savsiri.activities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.ActionBar.OnNavigationListener;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.lk.savsiri.R;
import com.lk.savsiri.DAO.ProfileDAO;
import com.lk.savsiri.DAO.ProfileDAO.ProfileDataCallBackListner;
import com.lk.savsiri.adapters.MatchingProfilesAdapter;
import com.lk.savsiri.constants.SavsiriConstants;
import com.lk.savsiri.data.AuthData;
import com.lk.savsiri.data.ProfileData;
import com.lk.savsiri.domain.Profile;
import com.lk.savsiri.utils.Utils;

public class MatchingProfilesActivity extends SaviriBaseActivity implements OnNavigationListener,
																			ProfileDataCallBackListner,
																			OnRefreshListener,OnItemClickListener{
	
	AuthData authData;
	
	Gson gson;
	
	SwipeRefreshLayout swipeLayout;
	
	ListView listView;
	
	MatchingProfilesAdapter adapter;
	
	ProfileData profileData;
	
	SharedPreferences preferences;
	
	SharedPreferences.Editor editor;
	
	Profile[] shortListArray;
	
	List<Profile> shortList;
	
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
		
		preferences=getSharedPreferences(SavsiriConstants.SS_SHARED_PREFERENCES_KEY, Context.MODE_PRIVATE);
		editor = preferences.edit();
		
		initUI();

	}
	
	
	
	private void initUI(){
		
		swipeLayout=(SwipeRefreshLayout) findViewById(R.id.swipe_container);
		swipeLayout.setOnRefreshListener(this);
		swipeLayout.setColorScheme(android.R.color.holo_blue_bright, 
                android.R.color.holo_green_light, 
                android.R.color.holo_orange_light, 
                android.R.color.holo_red_light);
		
		listView=(ListView) findViewById(R.id.list);
		
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
			
			return false;
			
		case 3:
			
			Intent shortListIntent=new Intent(this,ShortListedProfileActivity.class);
			startActivity(shortListIntent);
			
			return true;
			
		case 4:
			
			return false;

		default:
			
			
			return false;
			
		}
		
	}


	@Override
	public void onProfileDataRetriveSuccess(ProfileData profileData) { 
		
		this.profileData=profileData;
		
		System.out.println("PROFILES "+profileData.getProfiles().size());
		
		
		
	    if(preferences.getString(SavsiriConstants.SHORT_LISTED, null)!=null){ 
	    	
	    	String shortListJson=preferences.getString(SavsiriConstants.SHORT_LISTED, null);
	    	shortListArray=new Gson().fromJson(shortListJson, Profile[].class);
	    	System.out.println("ppppppppppp");
	    	
	    }else {
	    	
	    	System.out.println("kkkkkkkkkkk");
	    	shortListArray=new Gson().fromJson("[]", Profile[].class);
	    	
		}
		
	    shortList=new ArrayList<Profile>(Arrays.asList(shortListArray));
    	adapter=new MatchingProfilesAdapter(this,shortList); 
	    //adapter=new MatchingProfilesAdapter(this,profileData.getProfiles()); 
	    adapter.setProfileList(profileData.getProfiles());
		
		
		
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(this);
	}


	@Override
	public void onProfileDataRetriveError(VolleyError error) {
		
		
	}


	@Override
	public void onRefresh() {
		
		// Start showing the refresh animation
		swipeLayout.setRefreshing(true);

        // Simulate a long running activity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
            	System.out.println("REFRESHING");
            	
            	swipeLayout.setRefreshing(false);
            }
        }, 5000);
	}



	@Override
	public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
		
		
		Intent intent=new Intent(this,MatchingProfileDetailActivity.class);
		Bundle bundle=new Bundle();
		bundle.putParcelable(SavsiriConstants.PROFILE_LIST, profileData);
		bundle.putInt("position", position);
		intent.putExtra("extra", bundle);
		
		startActivity(intent);
		overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
		
	}
	
	
	
}
