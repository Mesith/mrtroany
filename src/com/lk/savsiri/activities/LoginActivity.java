package com.lk.savsiri.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.lk.savsiri.R;
import com.lk.savsiri.DAO.AuthDAO;
import com.lk.savsiri.DAO.AuthDAO.AuthCallBackInterface;
import com.lk.savsiri.constants.SavsiriConstants;
import com.lk.savsiri.data.AuthData;
import com.lk.savsiri.utils.Utils;


public class LoginActivity extends Activity implements OnClickListener,AuthCallBackInterface {
	
	EditText userName;
	EditText password;
	Button loginBtn;
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_layout);
		initUi();
		
		
	}
	
	void initUi(){
		
		userName=(EditText) findViewById(R.id.username);
		password=(EditText) findViewById(R.id.password);
		loginBtn=(Button) findViewById(R.id.login_btn);
		loginBtn.setOnClickListener(this);
		
		
		
		
		
	}
	
	
	private void login(String username,String password){
		
		 AuthDAO auth=new AuthDAO(this,this);
 		 auth.sendLoginRequest(username,password);
	}
	
	
	private void showHomescreen(){
		
		Intent intent=new Intent(this,MatchingProfilesActivity.class);
		startActivity(intent);
		overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
		finish();
		
	}
	

	@Override
	public void onClick(View v) {
		
		
		switch (v.getId()) {
		case R.id.login_btn:
			
			login(userName.getText().toString(),password.getText().toString());
			
			break;
		
		default:
			break;
		}
		
		
		
	}

	@Override
	public void onGetTokenComplete(AuthData authData) {
		
		
		
		
		if(authData.getUserData().getUser()!=null){
			
			Utils.putJsonToSharedPreference(this, SavsiriConstants.SS_USER_KEY, new Gson().toJson(authData));
			
		
			showHomescreen();
		}
		
		/*if(authData.getUserData().getSuccess().equals(MatrimonyConstants.RESPONSE_OK)){
			showHomescreen();
		}*/
	}

	@Override
	public void onGetTokenError(VolleyError error) { 
	
		System.out.println("error"+error.getMessage());
	}

	
}
