package com.lk.savsiri.activities;

import com.lk.savsiri.R;
import com.lk.savsiri.adapters.GalleryAdapter;
import com.lk.savsiri.adapters.ProfilePagerAdapter;
import com.lk.savsiri.data.GalleryData;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

public class GalleryPagerActivity extends FragmentActivity {
	
	
	ViewPager tabPager;
	
	GalleryAdapter adapter;
	
	GalleryData imageData;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profile_detail_layout);
		
		tabPager=(ViewPager) findViewById(R.id.tab_pager);
	}
	
	
	
	private void setPager(int position){
		
		adapter=new GalleryAdapter(getSupportFragmentManager(), this);
		adapter.setGallery(imageData);
		tabPager.setAdapter(adapter);
		tabPager.setCurrentItem(position);
		
		
		
	}

}
