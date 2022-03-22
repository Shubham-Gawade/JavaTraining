package com.xoriant.xorbankonline.model;

import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.xoriant.xorbankonline.enums.Gender;

public class UserDetailsDTO {
	
	 int userId;
	 String userName;
	 String personName;
	 LocalDate dateOfBirth;
	 Gender gender;
	 
	 String emailId;
	 long mobileNo;
	 
	 
	
	public UserDetailsDTO(int userId, String userName, String personName, LocalDate dateOfBirth, Gender gender,
			String emailId, long mobileNo) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.personName = personName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	@Override
	public String toString() {
		return "PersonInfoResultDTO [userId=" + userId + ", userName=" + userName + ", personName=" + personName
				+ ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + ", emailId=" + emailId + ", mobileNo="
				+ mobileNo + "]";
	}
	

}
