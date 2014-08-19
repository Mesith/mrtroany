package com.lk.savsiri.adapters;

import java.util.ArrayList;
import java.util.List;

import com.lk.savsiri.R;
import com.lk.savsiri.domain.Profile;
import com.lk.savsiri.viewitems.DropDownViewItem;
import com.lk.savsiri.viewitems.Dropdown;
import com.lk.savsiri.viewitems.ProfileItem;
import com.lk.savsiri.viewitems.ProfileItemView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;

public class MatchingProfilesAdapter extends BaseAdapter {

	Context context;
	
	List<Profile> profileList;
	private int lastPosition = -1;
	
	public MatchingProfilesAdapter(Context context){
		
		this.context=context;
		profileList=new ArrayList<Profile>();
		
	}
	
	@Override
	public int getCount() {
		
		return profileList.size();
	}

	@Override
	public Profile getItem(int position) {
		
		return profileList.get(position);
	}

	@Override
	public long getItemId(int arg0) {
		
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ProfileItemView viewItem;

		if (convertView == null) {
			viewItem = new ProfileItemView(context);
		} else {
			viewItem = (ProfileItemView) convertView;
		}

		viewItem.bindData(profileList.get(position));

		Animation animation = AnimationUtils.loadAnimation(context,
				(position > lastPosition) ? R.anim.up_from_bottom
						: R.anim.down_from_top);
		viewItem.startAnimation(animation);
		lastPosition = position;

		return viewItem;
	}
	
	public void setProfileList(List<Profile> profileList){
		
		this.profileList = profileList;
		notifyDataSetChanged();
		
	}

}
