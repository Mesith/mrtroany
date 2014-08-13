package com.lk.savsiri.adapters;

import java.util.ArrayList;
import java.util.List;

import com.lk.savsiri.viewitems.DropDownViewItem;
import com.lk.savsiri.viewitems.Dropdown;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class DropDownAdapter extends BaseAdapter {
	
	Context context;
	
	List<Dropdown> dropDownMenuList;
	
	public DropDownAdapter(Context context){
		
		this.context=context;
		dropDownMenuList=new ArrayList<Dropdown>();
		
	}

	@Override
	public int getCount() {
		
		return dropDownMenuList.size();
	}

	@Override
	public Dropdown getItem(int position) {
		
		return dropDownMenuList.get(position);
	}

	@Override
	public long getItemId(int arg0) {
		
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		DropDownViewItem viewItem;
		
		if(convertView==null){
			viewItem=new DropDownViewItem(context);
		}else{
			viewItem=(DropDownViewItem) convertView;
		}
		
		viewItem.bindData(dropDownMenuList.get(position));
		
		return viewItem;
	}
	
	
	public void setMenuList(List<Dropdown> menuList){
		
		this.dropDownMenuList=menuList;
		notifyDataSetChanged();
		
	}

}
