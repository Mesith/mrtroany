package com.lk.savsiri.activities;

import com.android.volley.VolleyError;
import com.lk.savsiri.R;
import com.lk.savsiri.DAO.GalleryDAO;
import com.lk.savsiri.DAO.GalleryDAO.AlbumCallbackinterface;
import com.lk.savsiri.adapters.GalleryAdapter;
import com.lk.savsiri.adapters.ProfilePagerAdapter;
import com.lk.savsiri.constants.SavsiriConstants;
import com.lk.savsiri.data.GalleryData;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

public class GalleryPagerActivity extends FragmentActivity implements AlbumCallbackinterface{
	
	
	ViewPager tabPager;
	
	GalleryAdapter adapter;
	
	GalleryData imageData;
	
	GalleryDAO galleryService;
	
	String id;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profile_detail_layout);
		
		tabPager=(ViewPager) findViewById(R.id.tab_pager);
		
		if(getIntent().hasExtra(SavsiriConstants.PROFILE_ID)){
			
			id=getIntent().getStringExtra(SavsiriConstants.PROFILE_ID);
			
			System.out.println("IDDDDD "+id);
			
			galleryService=new GalleryDAO(this, this);
			
			galleryService.retriveImageGallery(id);
			
		}
		
		
	}

	private void setPager(int position){
		
		adapter=new GalleryAdapter(getSupportFragmentManager(), this);
		adapter.setGallery(imageData);
		tabPager.setAdapter(adapter);
		tabPager.setCurrentItem(position);

	}

	@Override
	public void onGallerySuccess(GalleryData data) {
		
		
		System.out.println("GALLERY SIZE "+data.getImages().size());
		
	}



	@Override
	public void onGalleryError(VolleyError error) {
		
		
	}

}
