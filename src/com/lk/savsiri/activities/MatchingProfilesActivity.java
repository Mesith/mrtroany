package com.lk.savsiri.activities;

import android.app.ActionBar.OnNavigationListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
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
	
	private DrawerLayout mDrawerLayout;
	//private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;
	
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
		
		initUI();
		createNavigationDrawer();

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
			Intent shortList=new Intent(this,ShortListProfileActivity.class);
			startActivity(shortList);
			return true;

		default:
			
			
			return false;
			
		}
		
	}


	@Override
	public void onProfileDataRetriveSuccess(ProfileData profileData) {
		
		this.profileData=profileData;
		
		System.out.println("PROFILES "+profileData.getProfiles().size());
		
		adapter=new MatchingProfilesAdapter(this); 
		
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
		intent.putExtra(SavsiriConstants.PROFILE_DETAIL, profileData.getProfiles().get(position));
		startActivity(intent);
		overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
		
	}
	
	public void createNavigationDrawer()
	{
		mDrawerLayout = (DrawerLayout) this.findViewById(R.id.idrawer_layout);
	//	mDrawerList = (ListView) findViewById(R.id.idrawer);
		
		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close) {

			/** Called when drawer is closed */
			public void onDrawerClosed(View view) {
				getActionBar().setTitle("Rumesha");
				invalidateOptionsMenu();

			}

			/** Called when a drawer is opened */
			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle("JAVATECHIG.COM");
				invalidateOptionsMenu();
			}

		};



		mDrawerLayout.setDrawerListener(mDrawerToggle);
		
		getActionBar().setHomeButtonEnabled(true);

		// Enabling Up navigation
		getActionBar().setDisplayHomeAsUpEnabled(true);

		
	}
	
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onPostCreate(savedInstanceState);
		mDrawerToggle.syncState();
	}
	
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
	}
	
}
