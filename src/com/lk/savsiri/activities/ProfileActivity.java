package com.lk.savsiri.activities;

import android.app.ActionBar.OnNavigationListener;
import android.content.Intent;
import android.os.Bundle;

import com.lk.savsiri.R;

public class ProfileActivity extends SaviriBaseActivity implements OnNavigationListener {
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getCustomActionbar(this,MY_PROFILES);
		setContentView(R.layout.profile_layout);
	}
	


	@Override
	public boolean onNavigationItemSelected(int position, long itemId) {
		
		
		switch (position) {
		case 0:
			
			Intent intent=new Intent(this,MatchingProfilesActivity.class);
			startActivity(intent);
		
			return true;
			
		case 1:
			
			
			
			return false;
			
		case 2:
			
			return false;

		default:
			
			
			return false;
			
		}
		
	}

}
