package com.lk.savsiri.DAO;

import android.content.Context;

import com.android.volley.Request.Method;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.Volley;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.lk.savsiri.constants.SavsiriConstants;
import com.lk.savsiri.constants.SavsiriProperties;
import com.lk.savsiri.data.AuthData;
import com.lk.savsiri.data.ProfileData;
import com.lk.savsiri.services.SavsiriRequest;

public class ProfileDAO implements Listener<ProfileData>, ErrorListener {
	
	
	Context mContext;
	
	ProfileDataCallBackListner Profilelistner;
	
	public ProfileDAO(Context context,ProfileDataCallBackListner listner){
		
		this.mContext=context;
		this.Profilelistner=listner;
		
	}
	
	
	public void getMatchingProfiles(String gender){
		
		
		RequestQueue queue = Volley.newRequestQueue(mContext);
		SavsiriRequest<ProfileData> myReq = new SavsiriRequest<ProfileData>(Method.GET,
	                                            getUrl(gender),
	                                            ProfileData.class,
	                                            this,
	                                            this);
		
				
        queue.add(myReq);
		
		
		
	}
	
	
	private String getUrl(String gender){
		
		String url=SavsiriProperties.PROFILES_URL+"?gender="+gender;

		return url;
	}
	
	
	
	public interface ProfileDataCallBackListner{
		public void onProfileDataRetriveSuccess(ProfileData profileData);
		public void onProfileDataRetriveError(VolleyError error);
		
	}

	@Override
	public void onErrorResponse(VolleyError error) {
		
		Profilelistner.onProfileDataRetriveError(error);

	}

	@Override
	public void onResponse(ProfileData profileData) {
		
		Profilelistner.onProfileDataRetriveSuccess(profileData);
	}

}
