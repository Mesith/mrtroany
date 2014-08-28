package com.lk.savsiri.data;

import java.util.ArrayList;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.lk.savsiri.domain.GalleryImage;

public class GalleryData implements Parcelable {
	
	
	@SerializedName("data")
	List<GalleryImage> images;
	


    public List<GalleryImage> getImages() {
		return images;
	}

	public void setImages(List<GalleryImage> images) {
		this.images = images;
	}

	protected GalleryData(Parcel in) {
        if (in.readByte() == 0x01) {
            images = new ArrayList<GalleryImage>();
            in.readList(images, GalleryImage.class.getClassLoader());
        } else {
            images = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (images == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(images);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<GalleryData> CREATOR = new Parcelable.Creator<GalleryData>() {
        @Override
        public GalleryData createFromParcel(Parcel in) {
            return new GalleryData(in);
        }

        @Override
        public GalleryData[] newArray(int size) {
            return new GalleryData[size];
        }
    };
}
