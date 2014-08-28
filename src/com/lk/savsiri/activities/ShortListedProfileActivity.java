package com.lk.savsiri.activities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.lk.savsiri.R;
import com.lk.savsiri.adapters.ShaortListedAdapter;
import com.lk.savsiri.constants.SavsiriConstants;
import com.lk.savsiri.domain.Profile;

import android.app.ActionBar.OnNavigationListener;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputFilter.LengthFilter;
import android.widget.ListView;
import android.widget.Toast;

public class ShortListedProfileActivity extends SaviriBaseActivity implements OnNavigationListener{
	
	
	Profile[] shortListArray;
	
	SharedPreferences preferences;
	
	List<Profile> shortList;
	
	ShaortListedAdapter adapter;
	
	ListView list;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		getCustomActionbar(this, SHORT_LISTED);
		setContentView(R.layout.matching_profiles_layout);
		
		System.out.println("SHORT  LISTED ACTIVTY");
		
		preferences=getSharedPreferences(SavsiriConstants.SS_SHARED_PREFERENCES_KEY, Context.MODE_PRIVATE);
		String shortListJson=preferences.getString(SavsiriConstants.SHORT_LISTED, null);
		
		list=(ListView) findViewById(R.id.list);
		
		if(shortListJson!=null){
			
			showSavedProfiles(shortListJson);
			
		}else{
			
			//no matching profile
			Toast a=Toast.makeText(this, "No Profils",Toast.LENGTH_LONG);
			a.show();
			
		}
		
		
	}
	
	
	
	void showSavedProfiles(String shortListJson){  
		
		
	    shortListArray=new Gson().fromJson(shortListJson, Profile[].class);
		shortList=new ArrayList<Profile>(Arrays.asList(shortListArray));
		
		adapter=new ShaortListedAdapter(this);
		adapter.setProifileList(shortList);
		list.setAdapter(adapter);
		
	}



	@Override
	public boolean onNavigationItemSelected(int position, long itemId) {
		
		switch (position) {
		case 0:
			

			Intent mpIntent=new Intent(this,MatchingProfilesActivity.class);
			startActivity(mpIntent);

			return true;
			
		case 1:
			
			Intent intent=new Intent(this,ProfileActivity.class);
			startActivity(intent);
			
			return true;
			
		case 2:
			
			return false;
			
		case 3:
			
			//Intent shortListIntent=new Intent(this,ProfileActivity.class);
			//startActivity(shortListIntent);
			
			return true;
			
		case 4:
			
			return false;

		default:
			
			
			return false;
			
		}
	}
	

}
