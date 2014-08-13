package com.lk.savsiri.activities;


import com.lk.savsiri.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LandingPage extends Activity {
	
	private Button login;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.landing_layout);
		
		login=(Button) findViewById(R.id.login_btn);
		login.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				Intent intent=new Intent(LandingPage.this,LoginActivity.class);
				startActivity(intent);
				overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
				finish();
				
			}
		});
	}

}
