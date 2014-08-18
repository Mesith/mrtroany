package com.lk.savsiri.adapters;

import java.util.ArrayList;
import java.util.List;

import com.lk.savsiri.viewitems.DropDownViewItem;
import com.lk.savsiri.viewitems.Dropdown;
import com.lk.savsiri.viewitems.ProfileItem;
import com.lk.savsiri.viewitems.ProfileItemView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class MatchingProfilesAdapter extends BaseAdapter {

	Context context;
	
	List<ProfileItem> profileList;
	
	public MatchingProfilesAdapter(Context context){
		
		this.context=context;
		profileList=new ArrayList<ProfileItem>();
		
	}
	
	@Override
	public int getCount() {
		
		return profileList.size();
	}

	@Override
	public ProfileItem getItem(int position) {
		
		return profileList.get(position);
	}

	@Override
	public long getItemId(int arg0) {
		
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		ProfileItemView viewItem;
		
		if(convertView==null){
			viewItem=new ProfileItemView(context);
		}else{
			viewItem=(ProfileItemView) convertView;
		}
		
		viewItem.bindData(profileList.get(position));
		
		return viewItem;
	}
	
	public void setProfileList(List<ProfileItem> profileList){
		
		this.profileList = profileList;
		notifyDataSetChanged();
		
	}

}
