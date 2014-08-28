package com.lk.savsiri.adapters;

import java.util.List;

import com.lk.savsiri.data.GalleryData;
import com.lk.savsiri.fragment.GalleryPagerFragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

public class GalleryAdapter extends FragmentPagerAdapter {
	
	Context  mContext;
	
	List<String> images;
	
	Fragment fragment;
	
	GalleryData galleryImages;
	
	
	public GalleryAdapter(FragmentManager fm,Context context) {
		super(fm);
		this.mContext=context;
		
	}
	
	@Override
	public int getCount() {
	
		return images.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		
		return false;
	}

	@Override
	public Fragment getItem(int arg0) {
		
		fragment=new GalleryPagerFragment();
		
		return fragment;
	}

	
	public void setGallery(GalleryData galleryImages){
		
		this.galleryImages=galleryImages;
		notifyDataSetChanged();
		
	}
	
}
