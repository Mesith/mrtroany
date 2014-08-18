package com.lk.savsiri.viewitems;

import com.lk.savsiri.R;

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
	
	ImageView icon;
	
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
		
		icon=(ImageView) this.findViewById(R.id.drop_down_icon);
		btnShortList = (Button) this.findViewById(R.id.btn_shortlist);
		
	}
	
	public void bindData(ProfileItem pitem){
		tvName.setText(pitem.getProfileName());
		tvHeight.setText(pitem.getHeight());
		tvReligion.setText(pitem.getReligionStatus());
		tvAddress.setText(pitem.getAddress());
		tvProfession.setText(pitem.getProfession());
		
		icon.setBackgroundResource(pitem.getIcon());
	}
}
