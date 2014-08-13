package com.lk.savsiri.activities;

import java.util.ArrayList;
import java.util.List;

import com.lk.savsiri.R;
import com.lk.savsiri.adapters.DropDownAdapter;
import com.lk.savsiri.viewitems.Dropdown;


import android.app.ActionBar;
import android.app.Activity;
import android.app.ActionBar.OnNavigationListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class SaviriBaseActivity extends Activity  {
	
	
	public static final int MATCHING_PROFILES=0;
	public static final int MY_PROFILES=1;
	public static final int INBOX=2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setTitle(null);
	}
	

	public void getCustomActionbar(OnNavigationListener listner,int selectedPosition){

		List<Dropdown> menuList=new ArrayList<Dropdown>();
		
		menuList.add(new Dropdown(R.drawable.ic_launcher, "Matching Profiles"));
		menuList.add(new Dropdown(R.drawable.ic_launcher, "Profiles"));
		menuList.add(new Dropdown(R.drawable.ic_launcher,"Inbox"));
		menuList.add(new Dropdown(R.drawable.ic_launcher,"Short Listed"));
		
		DropDownAdapter adapter=new DropDownAdapter(this);
		adapter.setMenuList(menuList);
		
		getActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
		
		ActionBar actionBar=getActionBar();
		actionBar.setListNavigationCallbacks(adapter, listner);
		actionBar.setSelectedNavigationItem(selectedPosition);
	}





	

}
