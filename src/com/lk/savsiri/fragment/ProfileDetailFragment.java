package com.lk.savsiri.fragment;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.lk.savsiri.R;
import com.lk.savsiri.activities.GalleryPagerActivity;
import com.lk.savsiri.constants.SavsiriConstants;
import com.lk.savsiri.domain.Profile;
import com.lk.savsiri.utils.BitmapLruCache;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.TextView;

@SuppressLint("ValidFragment")
public class ProfileDetailFragment extends Fragment {
	
	private View view;
	
	TextView name;
	
	Profile profile;
	
	NetworkImageView profileImage;
	
	Button next;
	
	Button pre;
	
	pagerNavigationListner pageListner;
	
	
     public ProfileDetailFragment(){
		
		
		
	}
	
	
	public ProfileDetailFragment(pagerNavigationListner pageListner){
		
		this.pageListner=pageListner;
		
	}
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		if(getArguments().containsKey(SavsiriConstants.PROFILE_DETAIL)){
			
			profile=getArguments().getParcelable(SavsiriConstants.PROFILE_DETAIL);
		}
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
	
		if(view==null){
			
			 view=inflater.inflate(R.layout.profile_detail_fragment_layout, null);
		}else
		{
			
			((ViewGroup) view.getParent()).removeView(view);
		}
		
		name=(TextView) view.findViewById(R.id.tvName);
		profileImage=(NetworkImageView) view.findViewById(R.id.profile_image);
		profileImage.setOnClickListener(clickListner);
		
		next=(Button) view.findViewById(R.id.next);
		pre=(Button) view.findViewById(R.id.previous);
		
		bindData();
		
		
		return view;
	}
	
	
	private void bindData(){
		
		if(profile!=null){
			
			name.setText(profile.getFirstName());
			
			ImageLoader.ImageCache imageCache = new BitmapLruCache();
			ImageLoader imageLoader = new ImageLoader(Volley.newRequestQueue(getActivity()), imageCache);
			profileImage.setImageUrl(profile.getImageUrl(),imageLoader);
			System.out.println("IMAGE URL "+profile.getImageUrl());
			
		}
		
		
	}
	
	
	View.OnClickListener clickListner=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
			if(v.getId()==R.id.next){
				
				pageListner.onPageNext();
			}
			else if(v.getId()==R.id.profile_image){
				
				Intent intent=new Intent(getActivity(),GalleryPagerActivity.class);
				startActivity(intent);
				
			}
			
		}
	};
	
	
	public interface pagerNavigationListner{
		
		public void onPageNext();
		public void onPagePrvious();
		
	}
	

}
