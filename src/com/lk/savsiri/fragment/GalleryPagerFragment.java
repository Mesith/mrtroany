package com.lk.savsiri.fragment;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.lk.savsiri.R;
import com.lk.savsiri.constants.SavsiriConstants;
import com.lk.savsiri.utils.BitmapLruCache;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;

public class GalleryPagerFragment extends Fragment {
	
	
	String  imageUrl;
	
	private View view;
	
	NetworkImageView  picture;
	
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		if(getArguments().containsKey(SavsiriConstants.ALBUM_IMAGE)){
			
			imageUrl=getArguments().getString(SavsiriConstants.ALBUM_IMAGE);
			
		}
		
		
	}
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		
		if(view==null){
			
			 view=inflater.inflate(R.layout.gallery_layout, null);
		}else
		{
			
			((ViewGroup) view.getParent()).removeView(view);
		}
		
		bindData();
		
		return view;
	}
	
	
	private void bindData() {
		
		if(view!=null){

			picture=(NetworkImageView) view.findViewById(R.id.album_image);
			
			ImageLoader.ImageCache imageCache = new BitmapLruCache();
			ImageLoader imageLoader = new ImageLoader(Volley.newRequestQueue(getActivity()), imageCache);
			System.out.println("URL  >>>"+imageUrl);
			picture.setImageUrl(imageUrl, imageLoader);
			
			
			
		}
		
		
	}
	
	

}
