package com.lk.savsiri.activities;


import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.lk.savsiri.R;
import com.lk.savsiri.constants.SavsiriConstants;
import com.lk.savsiri.domain.Profile;
import com.lk.savsiri.fragment.ProfileDetailFragment;

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
		CreateFragment();
		
	}
	
	public void CreateFragment() {
		  FragmentManager fragmentManager = getFragmentManager();
	      FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
	      ProfileDetailFragment fragmentProfile = new ProfileDetailFragment();
	      fragmentTransaction.replace( R.id.detail_container, fragmentProfile);
	      fragmentTransaction.addToBackStack(null);
	      fragmentTransaction.commit();
	      
	}

}
