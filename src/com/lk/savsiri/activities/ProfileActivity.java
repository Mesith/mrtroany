package com.lk.savsiri.activities;

import android.app.ActionBar.OnNavigationListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.lk.savsiri.R;
import com.lk.savsiri.constants.SavsiriConstants;
import com.lk.savsiri.data.AuthData;
import com.lk.savsiri.utils.BitmapLruCache;
import com.lk.savsiri.utils.Utils;

public class ProfileActivity extends SaviriBaseActivity implements OnNavigationListener {
	
	AuthData authData;
	Gson gson;
	
	NetworkImageView profileImage;
	
	TextView name;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getCustomActionbar(this,MY_PROFILES);
		setContentView(R.layout.profile_layout);
		
		gson=new Gson();
		
		String userString=Utils.getJsonSharedPreference(this, SavsiriConstants.SS_USER_KEY);
		authData=gson.fromJson(userString, AuthData.class);
		
		initUI();
	}
	
	
	
	
	void initUI(){
		
		
		name=(TextView) findViewById(R.id.name);
		name.setText(authData.getUserData().getUser().getName());
		profileImage=(NetworkImageView) findViewById(R.id.profile_image);
		
		ImageLoader.ImageCache imageCache = new BitmapLruCache();
		ImageLoader imageLoader = new ImageLoader(Volley.newRequestQueue(this), imageCache);
		profileImage.setImageUrl(authData.getUserData().getUser().getProfileImage(), imageLoader);
		
	}
	


	@Override
	public boolean onNavigationItemSelected(int position, long itemId) {
		
		
		switch (position) {
		case 0:
			
			Intent intent=new Intent(this,MatchingProfilesActivity.class);
			startActivity(intent);
		
			return true;
			
		case 1:
			
			
			
			return false;
			
		case 2:
			
			return false;

		default:
			
			
			return false;
			
		}
		
	}

}
