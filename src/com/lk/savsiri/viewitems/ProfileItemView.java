package com.lk.savsiri.viewitems;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.lk.savsiri.R;
import com.lk.savsiri.domain.Profile;
import com.lk.savsiri.utils.BitmapLruCache;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ProfileItemView extends RelativeLayout{

	
	TextView tvName;
	TextView tvHeight;
	TextView tvReligion;
	TextView tvAddress;
	TextView tvProfession;
	
	NetworkImageView icon;
	
	Button btnShortList;
	
	Context context;
	
	public ProfileItemView(Context context) {
		super(context);
		this.context=context;
		init();
	}
	
	void init(){
		
		LayoutInflater.from(context).inflate(R.layout.profile_item_layout, this);
		Typeface font = Typeface.createFromAsset(context.getAssets(), "Roboto-Medium.ttf");
		
		tvName = (TextView) this.findViewById(R.id.tv_profile_name);
		tvName.setTypeface(font);
		
		tvHeight = (TextView) this.findViewById(R.id.tv_height);
		tvHeight.setTypeface(font);
		
		tvReligion = (TextView) this.findViewById(R.id.tv_religion);
		tvReligion.setTypeface(font);
		
		tvAddress=(TextView) this.findViewById(R.id.tv_address);
		tvAddress.setTypeface(font);
		
		tvProfession=(TextView) this.findViewById(R.id.tv_profession);
		tvProfession.setTypeface(font);
		
		icon=(NetworkImageView) this.findViewById(R.id.profile_image);
		btnShortList = (Button) this.findViewById(R.id.btn_shortlist);
		
	}
	
	public void bindData(Profile pitem){
		tvName.setText(pitem.getFirstName());
		tvHeight.setText(pitem.getHeight());
		tvReligion.setText(pitem.getReligion());
		tvAddress.setText(pitem.getContactAddress());
		tvProfession.setText(pitem.getProfessioneExpect());
		
		
		ImageLoader.ImageCache imageCache = new BitmapLruCache();
		ImageLoader imageLoader = new ImageLoader(Volley.newRequestQueue(context), imageCache);
		icon.setImageUrl(pitem.getImageUrl(),imageLoader);
		
		//icon.setBackgroundResource(pitem.getImageUrl());
	}
}
