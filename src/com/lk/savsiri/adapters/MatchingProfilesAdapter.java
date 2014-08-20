package com.lk.savsiri.adapters;

import java.util.ArrayList;
import java.util.List;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.lk.savsiri.R;
import com.lk.savsiri.domain.Profile;
import com.lk.savsiri.utils.BitmapLruCache;
import com.lk.savsiri.viewitems.DropDownViewItem;
import com.lk.savsiri.viewitems.Dropdown;
import com.lk.savsiri.viewitems.ProfileItem;
import com.lk.savsiri.viewitems.ProfileItemView;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

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
		Typeface font = Typeface.createFromAsset(context.getAssets(), "Roboto-Medium.ttf");
		
		if(convertView==null){
			
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
		
		
		viewHolder.tvName.setText(profileList.get(position).getFirstName());
		viewHolder.tvHeight.setText(profileList.get(position).getHeight());
		viewHolder.tvReligion.setText(profileList.get(position).getReligion());
		viewHolder.tvAddress.setText(profileList.get(position).getContactAddress());
		viewHolder.tvProfession.setText(profileList.get(position).getProfessioneExpect());
		
		ImageLoader.ImageCache imageCache = new BitmapLruCache();
		ImageLoader imageLoader = new ImageLoader(Volley.newRequestQueue(context), imageCache);
		viewHolder.icon.setImageUrl(profileList.get(position).getImageUrl(),imageLoader);
		
		Animation animation = AnimationUtils.loadAnimation(context,
				(position > lastPosition) ? R.anim.up_from_bottom
						: R.anim.down_from_top);
		convertView.startAnimation(animation);
		lastPosition = position;
		
		return convertView;
	}
	
	public void setProfileList(List<Profile> profileList){
		
		this.profileList = profileList;
		notifyDataSetChanged();
		
	}

}
