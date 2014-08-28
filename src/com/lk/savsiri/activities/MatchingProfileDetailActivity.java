package com.lk.savsiri.activities;


import com.android.volley.toolbox.NetworkImageView;
import com.lk.savsiri.R;
import com.lk.savsiri.adapters.ProfilePagerAdapter;
import com.lk.savsiri.constants.SavsiriConstants;
import com.lk.savsiri.data.ProfileData;
import com.lk.savsiri.domain.Profile;
import com.lk.savsiri.fragment.ProfileDetailFragment.pagerNavigationListner;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

public class MatchingProfileDetailActivity extends FragmentActivity implements pagerNavigationListner{
	
	ProfileData profileData;
	
	ProfilePagerAdapter adapter;
	
	ViewPager tabPager;
	
	
	int selectedPage;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profile_detail_layout);
		
		tabPager=(ViewPager) findViewById(R.id.tab_pager);
		
		
		if(getIntent().getBundleExtra("extra").containsKey(SavsiriConstants.PROFILE_LIST)){
			
			profileData=getIntent().getBundleExtra("extra").getParcelable(SavsiriConstants.PROFILE_LIST);
			
			selectedPage=getIntent().getBundleExtra("extra").getInt("position");
			setPager(selectedPage);
			
			System.out.println("xxxxxxxxxx"+selectedPage);
			
			
			
		}
		
		
	}
	
	
	private void setPager(int position){
		
		adapter=new ProfilePagerAdapter(getSupportFragmentManager(), this);
		adapter.setProfileList(profileData);
		tabPager.setAdapter(adapter);
		tabPager.setCurrentItem(position);
		
		
		
	}


	@Override
	public void onPageNext() {
		
	}


	@Override
	public void onPagePrvious() {
		
		
	}

}
