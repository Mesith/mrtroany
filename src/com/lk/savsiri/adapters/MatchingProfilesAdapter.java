package com.lk.savsiri.adapters;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.lk.savsiri.R;
import com.lk.savsiri.constants.SavsiriConstants;
import com.lk.savsiri.domain.Profile;
import com.lk.savsiri.utils.BitmapLruCache;
import com.lk.savsiri.utils.Utils;

public class MatchingProfilesAdapter extends BaseAdapter {

	Context mContext;
	
	List<Profile> profileList;
	
	private int lastPosition = -1;
	
	SharedPreferences preferences;
	
	SharedPreferences.Editor editor;
	
	List<Profile> shortList;
	
	List<Profile> shortListMarkedProfiles;
	
	
	public MatchingProfilesAdapter(Context context,List<Profile> shortList){
		
		this.mContext=context;
		this.shortList=shortList;
		System.out.println("SORT list SIZE"+shortList.size());
		profileList=new ArrayList<Profile>();
		shortListMarkedProfiles=new ArrayList<Profile>();
		preferences= mContext.getSharedPreferences(SavsiriConstants.SS_SHARED_PREFERENCES_KEY, Context.MODE_PRIVATE);
		editor = preferences.edit();
		
	}
	
	@Override
	public int getCount() {
		
		return shortListMarkedProfiles.size();
	}

	@Override
	public Profile getItem(int position) {
		
		return shortListMarkedProfiles.get(position);
	}

	@Override
	public long getItemId(int arg0) {
		
		return 0;
	}
	
	static class ViewHolderItem {
		TextView tvName;
		TextView tvHeight;
		TextView tvReligion;
		TextView tvAddress;
		TextView tvProfession;
		
		
		NetworkImageView icon;
		Button btnShortList;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		ViewHolderItem viewHolder;
		Typeface font = Typeface.createFromAsset(mContext.getAssets(), "Roboto-Medium.ttf");
		
		if(convertView==null){
			
			LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	        convertView = inflater.inflate(R.layout.profile_item_layout, parent, false);
	        
	        viewHolder = new ViewHolderItem();
	        viewHolder.tvName = (TextView) convertView.findViewById(R.id.tv_profile_name);
	        viewHolder.tvName.setTypeface(font);
	        
	        viewHolder.tvHeight = (TextView) convertView.findViewById(R.id.tv_height);
	        viewHolder.tvHeight.setTypeface(font);
	        
	        viewHolder.tvReligion = (TextView) convertView.findViewById(R.id.tv_religion);
	        viewHolder.tvReligion.setTypeface(font);
	        
	        viewHolder.tvAddress = (TextView) convertView.findViewById(R.id.tv_address);
	        viewHolder.tvAddress.setTypeface(font);
	        
	        viewHolder.tvProfession = (TextView) convertView.findViewById(R.id.tv_profession);
	        viewHolder.tvProfession.setTypeface(font);
	        
	        viewHolder.icon = (NetworkImageView) convertView.findViewById(R.id.profile_image);
	        viewHolder.btnShortList = (Button) convertView.findViewById(R.id.btn_shortlist);
	        
	        convertView.setTag(viewHolder);
			
		}else
		{
			 viewHolder = (ViewHolderItem) convertView.getTag();
		}
		
		
		viewHolder.tvName.setText(shortListMarkedProfiles.get(position).getFirstName());
		viewHolder.tvHeight.setText(shortListMarkedProfiles.get(position).getHeight());
		viewHolder.tvReligion.setText(shortListMarkedProfiles.get(position).getReligion());
		viewHolder.tvAddress.setText(shortListMarkedProfiles.get(position).getContactAddress());
		viewHolder.tvProfession.setText(shortListMarkedProfiles.get(position).getProfessioneExpect());
		
		ImageLoader.ImageCache imageCache = new BitmapLruCache();
		ImageLoader imageLoader = new ImageLoader(Volley.newRequestQueue(mContext), imageCache);
		viewHolder.icon.setImageUrl(shortListMarkedProfiles.get(position).getImageUrl(),imageLoader);
		viewHolder.btnShortList.setTag(shortListMarkedProfiles.get(position));
		
		viewHolder.btnShortList.setOnClickListener(clickListner);
		
		Animation animation = AnimationUtils.loadAnimation(mContext,
				(position > lastPosition) ? R.anim.up_from_bottom
						: R.anim.down_from_top);
		convertView.startAnimation(animation);
		lastPosition = position;
		
		
		if(shortListMarkedProfiles.get(position).isShortListed()){
			viewHolder.btnShortList.setText("Short Listed");
		}else{
			viewHolder.btnShortList.setText("Short List");
		}
		
		return convertView;
	}
	
	public void setProfileList(List<Profile> profileList){
		
		this.profileList = profileList;
		shortList();
		
		
	}
	
	
	
	View.OnClickListener clickListner=new OnClickListener() {
		
		@Override
		public void onClick(View view) {
			
			if(profileList.size()>0){
				
				Profile profile=(Profile) view.getTag();
				System.out.println("selected >>>>"+profile.getFirstName());
				
				shortList.add(profile);
				
				Utils.putJsonToSharedPreference(mContext, SavsiriConstants.SHORT_LISTED,
						new Gson().toJson(shortList.toArray(new Profile[shortList.size()])));
				
				shortList();
				
				System.out.println("SHORT listed  "+shortList.size());
				
			}
		}
	};
	
	

	
	
	void shortList(){
		
		
		Iterator<Profile>  iterator=profileList.iterator();
		Profile singleProfile;
		
		while (iterator.hasNext()) {
			
			singleProfile=iterator.next();
			
			for (int i = 0; i < shortList.size(); i++) {
				
				if(shortList.get(i).getId().equalsIgnoreCase(singleProfile.getId())){
					
					singleProfile.setShortListed(true);
					
				}
				
			}
			
			shortListMarkedProfiles.add(singleProfile);
		}
		
		notifyDataSetChanged();
		
	}

	

}
