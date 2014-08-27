package com.lk.savsiri.adapters;

import com.lk.savsiri.constants.SavsiriConstants;
import com.lk.savsiri.data.ProfileData;
import com.lk.savsiri.fragment.ProfileDetailFragment;
import com.lk.savsiri.fragment.ProfileDetailFragment.pagerNavigationListner;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ProfilePagerAdapter extends FragmentPagerAdapter  {
	
	ProfileData profileData;
	
	Context  mContext;

	public ProfilePagerAdapter(FragmentManager fm,Context context) {
		super(fm);
		this.mContext=context;
		
	}

	@Override
	public Fragment getItem(int position) {
		
		Fragment fragment=new ProfileDetailFragment();
		Bundle bundle=new Bundle();
		bundle.putParcelable(SavsiriConstants.PROFILE_DETAIL, profileData.getProfiles().get(position));
		fragment.setArguments(bundle);
		return fragment;
	}

	@Override
	public int getCount() {
		
		return profileData.getProfiles().size();
	}
	
	
	public void setProfileList(ProfileData profileData){
		
		this.profileData=profileData;
		notifyDataSetChanged();
		
	}

	

}
