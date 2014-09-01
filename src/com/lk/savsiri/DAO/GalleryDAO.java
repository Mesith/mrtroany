package com.lk.savsiri.DAO;

import android.content.Context;

import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.lk.savsiri.constants.SavsiriProperties;
import com.lk.savsiri.data.GalleryData;
import com.lk.savsiri.services.SavsiriRequest;

public class GalleryDAO implements Response.Listener<GalleryData>,Response.ErrorListener{
	
	
	AlbumCallbackinterface mListner;
	
	Context mcontext;
	
	
	public GalleryDAO(Context context,AlbumCallbackinterface listner){
		
		this.mcontext=context;
		this.mListner=listner;
		
		
	}
	
	
	public interface AlbumCallbackinterface{
		public void onGallerySuccess(GalleryData data);
		public void onGalleryError(VolleyError error);
	}
	
	
	
	public void retriveImageGallery(String id){
		
		
		RequestQueue queue = Volley.newRequestQueue(mcontext);
		SavsiriRequest<GalleryData> myReq = new SavsiriRequest<GalleryData>(Method.GET,
	                                            getURL(id),
	                                            GalleryData.class,
	                                            this,
	                                            this);
		
				
        queue.add(myReq);
		
	}

	@Override
	public void onErrorResponse(VolleyError error) {
		
		mListner.onGalleryError(error);
		
	}

	@Override
	public void onResponse(GalleryData data) {
		
		mListner.onGallerySuccess(data);
		
	}
	
	
	private String getURL(String id){
		
		String Url=SavsiriProperties.GALLERY_URL+"?userid="+id;
		
		return Url;
		
	}
	
	

}
