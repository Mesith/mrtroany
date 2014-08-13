package com.lk.savsiri.DAO;


import java.util.Map;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.Request.Method;
import com.android.volley.toolbox.Volley;
import com.lk.savsiri.constants.SavsiriConstants;
import com.lk.savsiri.data.AuthData;
import com.lk.savsiri.services.SavsiriRequest;



import android.content.Context;

/**
 * @author Administrator
 *
 */
public class AuthDAO implements Response.Listener<AuthData>,Response.ErrorListener{
	
	
	Context mcontext;
	
	
	
	private AuthCallBackInterface mAuthCallBack;
	
	public AuthDAO(Context context,AuthCallBackInterface authCallBack)
	{
		this.mcontext=context;
		this.mAuthCallBack=authCallBack;
		
		
	}
	
	
	
	public void sendLoginRequest(String username,String password)
	{
		
		RequestQueue queue = Volley.newRequestQueue(mcontext);
		SavsiriRequest<AuthData> myReq = new SavsiriRequest<AuthData>(Method.GET,
	                                            getUrl(username,password),
	                                            AuthData.class,
	                                            this,
	                                            this);
		
				
        queue.add(myReq);
		
	}
	
	



	String getUrl(String username,String password){
		
	String tokenAPIUrl=SavsiriConstants.LOGIN_URL+"?username="+username+"&password="+password;
		//String tokenAPIUrl="http://matrimony.apiary-mock.com/notes";
		return tokenAPIUrl;
	}
	
	
	
	
	public interface AuthCallBackInterface{
		public void onGetTokenComplete(AuthData authData);
		public void onGetTokenError(VolleyError error);
	}



	@Override
	public void onResponse(AuthData authData) {
	
		mAuthCallBack.onGetTokenComplete(authData);
	}


	@Override
	public void onErrorResponse(VolleyError error) {
		
		mAuthCallBack.onGetTokenError(error);
	}

	

}

