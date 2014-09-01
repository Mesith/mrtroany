package com.lk.savsiri.viewitems;



import com.lk.savsiri.R;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class DropDownViewItem extends RelativeLayout {
	
	
	TextView title;
	
	ImageView icon;
	
	Context context;
	
	
	public DropDownViewItem(Context context) {
		super(context);
		this.context=context;
		init();
	}
	
	public DropDownViewItem(Context context, AttributeSet attrs) {
		super(context, attrs);
		
	}

	public DropDownViewItem(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		
	}
	
	
	void init(){
		
		LayoutInflater.from(context).inflate(R.layout.drop_down_layout, this);
		Typeface font = Typeface.createFromAsset(context.getAssets(), "Roboto-Regular.ttf");
		
		title=(TextView) this.findViewById(R.id.drop_doen_text);
		title.setTypeface(font);
		icon=(ImageView) this.findViewById(R.id.drop_down_icon);
		
	}
	
	public void bindData(Dropdown item){
		title.setText(item.getName());
		icon.setBackgroundResource(item.getIcon());
	}

}
