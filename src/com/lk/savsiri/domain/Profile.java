package com.lk.savsiri.domain;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Profile implements Parcelable {
	
	
	@SerializedName("father_status")
   	private String fatherStatus;
	
	@SerializedName("income")
   	private String income;
	
	@SerializedName("nIC")
   	private String NIC;
	
	@SerializedName("age_range")
   	private String ageRange;
	
	@SerializedName("cast_expect")
   	private String cast_expect;
	
	@SerializedName("city")
   	private String city;
	
	@SerializedName("contact_address")
   	private String contactAddress;
	
	@SerializedName("contact_number")
   	private String contactNumber;
	
	@SerializedName("country")
   	private String country;
	
	@SerializedName("couple")
   	private String couple;
	
	@SerializedName("date_of_birth")
   	private String dateOfBirth;
	
	@SerializedName("date_reg")
   	private String dateReg;
	
	@SerializedName("education")
   	private String education;
	
	@SerializedName("email")
   	private String email;
   	
	@SerializedName("email_notify")
   	private String emailNotify;
	
	@SerializedName("first_name")
   	private String firstName;
	
	@SerializedName("gender")
   	private String gender;
	
	@SerializedName("height")
   	private String height;
	
	@SerializedName("id")
   	private String id;
	
	@SerializedName("image_url")
   	private String imageUrl;
	
	@SerializedName("lang_id")
   	private String languageId;
	
	@SerializedName("last_name")
   	private String lastName;
	
	@SerializedName("living_district")
   	private String livingDistrict;
	
	@SerializedName("looking_for")
   	private String lookingFor;
	
	@SerializedName("looking_from")
   	private String lookingFrom;
	
	@SerializedName("marital_status")
   	private String maritalStatus;
	
	@SerializedName("mobile_number")
   	private String mobileNumber;
	
	@SerializedName("nick_name")
   	private String nickName;
	
	@SerializedName("origin_destrict")
   	private String originDestrict;
	
	@SerializedName("profession_expect")
   	private String professioneExpect;
	
	@SerializedName("race_expect")
   	private String raceExpect;
	
	@SerializedName("relationship")
   	private String relationship;
	
	@SerializedName("relationship_status")
   	private String relationshipStatus;
	
	@SerializedName("religion")
   	private String religion;
	
	@SerializedName("religion_expect")
   	private String religionExpect;
	
	@SerializedName("role")
   	private String role;
	
	@SerializedName("smallImageUrl")
   	private String small_image_url;
	
	@SerializedName("status")
   	private String status;
	
	@SerializedName("tags")
   	private String tags;
	
	@SerializedName("user_status")
   	private String userStatus;
	
	@SerializedName("views")
   	private String views;
	
	@SerializedName("weight")
   	private String weight;
	
	@SerializedName("zip")
   	private String zip;
	
	
    public String getFatherStatus() {
		return fatherStatus;
	}

	public void setFatherStatus(String fatherStatus) {
		this.fatherStatus = fatherStatus;
	}

	public String getIncome() {
		return income;
	}

	public void setIncome(String income) {
		this.income = income;
	}

	public String getNIC() {
		return NIC;
	}

	public void setNIC(String nIC) {
		NIC = nIC;
	}

	public String getAgeRange() {
		return ageRange;
	}

	public void setAgeRange(String ageRange) {
		this.ageRange = ageRange;
	}

	public String getCast_expect() {
		return cast_expect;
	}

	public void setCast_expect(String cast_expect) {
		this.cast_expect = cast_expect;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCouple() {
		return couple;
	}

	public void setCouple(String couple) {
		this.couple = couple;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getDateReg() {
		return dateReg;
	}

	public void setDateReg(String dateReg) {
		this.dateReg = dateReg;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailNotify() {
		return emailNotify;
	}

	public void setEmailNotify(String emailNotify) {
		this.emailNotify = emailNotify;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getLanguageId() {
		return languageId;
	}

	public void setLanguageId(String languageId) {
		this.languageId = languageId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLivingDistrict() {
		return livingDistrict;
	}

	public void setLivingDistrict(String livingDistrict) {
		this.livingDistrict = livingDistrict;
	}

	public String getLookingFor() {
		return lookingFor;
	}

	public void setLookingFor(String lookingFor) {
		this.lookingFor = lookingFor;
	}

	public String getLookingFrom() {
		return lookingFrom;
	}

	public void setLookingFrom(String lookingFrom) {
		this.lookingFrom = lookingFrom;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getOriginDestrict() {
		return originDestrict;
	}

	public void setOriginDestrict(String originDestrict) {
		this.originDestrict = originDestrict;
	}

	public String getProfessioneExpect() {
		return professioneExpect;
	}

	public void setProfessioneExpect(String professioneExpect) {
		this.professioneExpect = professioneExpect;
	}

	public String getRaceExpect() {
		return raceExpect;
	}

	public void setRaceExpect(String raceExpect) {
		this.raceExpect = raceExpect;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getRelationshipStatus() {
		return relationshipStatus;
	}

	public void setRelationshipStatus(String relationshipStatus) {
		this.relationshipStatus = relationshipStatus;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getReligionExpect() {
		return religionExpect;
	}

	public void setReligionExpect(String religionExpect) {
		this.religionExpect = religionExpect;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSmall_image_url() {
		return small_image_url;
	}

	public void setSmall_image_url(String small_image_url) {
		this.small_image_url = small_image_url;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getViews() {
		return views;
	}

	public void setViews(String views) {
		this.views = views;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public static Parcelable.Creator<Profile> getCreator() {
		return CREATOR;
	}

	protected Profile(Parcel in) {
        fatherStatus = in.readString();
        income = in.readString();
        NIC = in.readString();
        ageRange = in.readString();
        cast_expect = in.readString();
        city = in.readString();
        contactAddress = in.readString();
        contactNumber = in.readString();
        country = in.readString();
        couple = in.readString();
        dateOfBirth = in.readString();
        dateReg = in.readString();
        education = in.readString();
        email = in.readString();
        emailNotify = in.readString();
        firstName = in.readString();
        gender = in.readString();
        height = in.readString();
        id = in.readString();
        imageUrl = in.readString();
        languageId = in.readString();
        lastName = in.readString();
        livingDistrict = in.readString();
        lookingFor = in.readString();
        lookingFrom = in.readString();
        maritalStatus = in.readString();
        mobileNumber = in.readString();
        nickName = in.readString();
        originDestrict = in.readString();
        professioneExpect = in.readString();
        raceExpect = in.readString();
        relationship = in.readString();
        relationshipStatus = in.readString();
        religion = in.readString();
        religionExpect = in.readString();
        role = in.readString();
        small_image_url = in.readString();
        status = in.readString();
        tags = in.readString();
        userStatus = in.readString();
        views = in.readString();
        weight = in.readString();
        zip = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(fatherStatus);
        dest.writeString(income);
        dest.writeString(NIC);
        dest.writeString(ageRange);
        dest.writeString(cast_expect);
        dest.writeString(city);
        dest.writeString(contactAddress);
        dest.writeString(contactNumber);
        dest.writeString(country);
        dest.writeString(couple);
        dest.writeString(dateOfBirth);
        dest.writeString(dateReg);
        dest.writeString(education);
        dest.writeString(email);
        dest.writeString(emailNotify);
        dest.writeString(firstName);
        dest.writeString(gender);
        dest.writeString(height);
        dest.writeString(id);
        dest.writeString(imageUrl);
        dest.writeString(languageId);
        dest.writeString(lastName);
        dest.writeString(livingDistrict);
        dest.writeString(lookingFor);
        dest.writeString(lookingFrom);
        dest.writeString(maritalStatus);
        dest.writeString(mobileNumber);
        dest.writeString(nickName);
        dest.writeString(originDestrict);
        dest.writeString(professioneExpect);
        dest.writeString(raceExpect);
        dest.writeString(relationship);
        dest.writeString(relationshipStatus);
        dest.writeString(religion);
        dest.writeString(religionExpect);
        dest.writeString(role);
        dest.writeString(small_image_url);
        dest.writeString(status);
        dest.writeString(tags);
        dest.writeString(userStatus);
        dest.writeString(views);
        dest.writeString(weight);
        dest.writeString(zip);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Profile> CREATOR = new Parcelable.Creator<Profile>() {
        @Override
        public Profile createFromParcel(Parcel in) {
            return new Profile(in);
        }

        @Override
        public Profile[] newArray(int size) {
            return new Profile[size];
        }
    };
}