package com.lk.savsiri.activities;


import com.lk.savsiri.R;
import com.lk.savsiri.constants.SavsiriConstants;
import com.lk.savsiri.domain.Profile;

import android.app.Activity;
import android.os.Bundle;

public class MatchingProfileDetailActivity extends Activity {
	
	Profile profile;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profile_detail_layout);
		
		if(getIntent().getExtras().containsKey(SavsiriConstants.PROFILE_DETAIL)){
			
			profile=(Profile) getIntent().getExtras().get(SavsiriConstants.PROFILE_DETAIL);
			
			System.out.println("xxxxxxxxxx"+profile.getFirstName());
			
		}
		
		
	}

}
