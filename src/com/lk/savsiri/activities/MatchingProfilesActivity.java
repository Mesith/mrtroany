package com.lk.savsiri.activities;

import android.app.ActionBar.OnNavigationListener;
import android.content.Intent;
import android.os.Bundle;

import com.lk.savsiri.R;

public class MatchingProfilesActivity extends SaviriBaseActivity implements OnNavigationListener {
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		getCustomActionbar(this,MATCHING_PROFILES);
		setContentView(R.layout.matching_profiles_layout);

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
	
	
	
}
