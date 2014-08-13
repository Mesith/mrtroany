package com.lk.savsiri.domain;

import com.google.gson.annotations.SerializedName;

public class User {
	
	@SerializedName("nick_name")
	String name;
	
	@SerializedName("id")
	String userId;
	
	@SerializedName("email")
	String email;
	
	@SerializedName("status")
	String status;
	
	@SerializedName("role")
	String role;
	
	@SerializedName("couple")
	String couple;

	@SerializedName("sex")
	String sex;
	
	@SerializedName("looking_for")
	String lookingFor;
	
	@SerializedName("date_of_birth")
	String birthDay;
	
	@SerializedName("description_me")
	String description;
	
	@SerializedName("female")
	String lookingForl;
	
	@SerializedName("contact_number")
	String contactNumber;
	
	@SerializedName("mobile_number")
	String mobileNumber;
	
	@SerializedName("relationship_status")
	String relationshipStatus;
	
	@SerializedName("education")
	String education;
	
	@SerializedName("description_expect")
	String descriptionExpect;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getCouple() {
		return couple;
	}

	public void setCouple(String couple) {
		this.couple = couple;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getLookingFor() {
		return lookingFor;
	}

	public void setLookingFor(String lookingFor) {
		this.lookingFor = lookingFor;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLookingForl() {
		return lookingForl;
	}

	public void setLookingForl(String lookingForl) {
		this.lookingForl = lookingForl;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getRelationshipStatus() {
		return relationshipStatus;
	}

	public void setRelationshipStatus(String relationshipStatus) {
		this.relationshipStatus = relationshipStatus;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getDescriptionExpect() {
		return descriptionExpect;
	}

	public void setDescriptionExpect(String descriptionExpect) {
		this.descriptionExpect = descriptionExpect;
	}


	


}
