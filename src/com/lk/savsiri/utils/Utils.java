package com.lk.savsiri.utils;

import com.lk.savsiri.constants.SavsiriConstants;

import android.content.Context;
import android.content.SharedPreferences;


public class Utils {
	
	
	
	public static void putJsonToSharedPreference(Context ctx,String key, String json){
		
		SharedPreferences preferences = ctx.getSharedPreferences(SavsiriConstants.SS_SHARED_PREFERENCES_KEY, Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = preferences.edit();
		editor.putString(key, json);
		editor.commit();
		
	}
	
	
	public static String getJsonSharedPreference(Context ctx,String key){
		SharedPreferences preferences = ctx.getSharedPreferences(SavsiriConstants.SS_SHARED_PREFERENCES_KEY, Context.MODE_PRIVATE);
		return preferences.getString(key, null);

	}

}
