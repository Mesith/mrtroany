package com.lk.savsiri.adapters;

import java.util.List;

import com.lk.savsiri.constants.SavsiriConstants;
import com.lk.savsiri.data.GalleryData;
import com.lk.savsiri.fragment.GalleryPagerFragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

public class GalleryAdapter extends FragmentPagerAdapter {
	
	Context  mContext;
	
	//List<String> images;
	
	
	
	GalleryData galleryImages;
	
	
	public GalleryAdapter(FragmentManager fm,Context context) {
		super(fm);
		this.mContext=context;
		
	}
	
	@Override
	public int getCount() {
	
		return galleryImages.getImages().size();
	}



	@Override
	public Fragment getItem(int position) {
		
		Fragment fragment=new GalleryPagerFragment();
		Bundle bundle=new Bundle();
		bundle.putString(SavsiriConstants.ALBUM_IMAGE, galleryImages.getImages().get(position).getImageUrl());
		fragment.setArguments(bundle);
		
		return fragment;
	}

	
	public void setGallery(GalleryData galleryImages){
		
		this.galleryImages=galleryImages;
		notifyDataSetChanged();
		
	}
	
}
