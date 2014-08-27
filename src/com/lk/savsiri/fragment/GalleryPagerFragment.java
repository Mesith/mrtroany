package com.lk.savsiri.fragment;

import com.lk.savsiri.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class GalleryPagerFragment extends Fragment {
	
	
	private View view;
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		
		if(view==null){
			
			 view=inflater.inflate(R.layout.gallery_layout, null);
		}else
		{
			
			((ViewGroup) view.getParent()).removeView(view);
		}
		
		
		return view;
	}
	
	
	

}
