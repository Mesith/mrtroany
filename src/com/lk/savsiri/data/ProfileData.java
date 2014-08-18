package com.lk.savsiri.data;

import java.util.ArrayList;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.lk.savsiri.domain.Profile;

public class ProfileData implements Parcelable {

	@SerializedName("data")
	private List<Profile> profiles;
	
	



	public List<Profile> getProfiles() {
		return profiles;
	}

	public void setProfiles(List<Profile> profiles) {
		this.profiles = profiles;
	}

	protected ProfileData(Parcel in) {
        if (in.readByte() == 0x01) {
            profiles = new ArrayList<Profile>();
            in.readList(profiles, Profile.class.getClassLoader());
        } else {
            profiles = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (profiles == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(profiles);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<ProfileData> CREATOR = new Parcelable.Creator<ProfileData>() {
        @Override
        public ProfileData createFromParcel(Parcel in) {
            return new ProfileData(in);
        }

        @Override
        public ProfileData[] newArray(int size) {
            return new ProfileData[size];
        }
    };
}
