package com.xoriant.xorbankonline.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.TableGenerator;

import org.springframework.format.annotation.DateTimeFormat;

import com.xoriant.xorbankonline.enums.Gender;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class PersonInfo {

	@Id
	@TableGenerator(name = "PersonInfo_Gen", table = "PersonInfo_ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", pkColumnValue = "Personinfo_Gen", initialValue = 10000, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "PersonInfo_Gen")
	protected long personId;
	protected String personName;
	@Enumerated(EnumType.STRING)
	protected Gender gender;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	protected LocalDate dateOfBirth;
	protected String emailId;
	protected long mobileNo;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "adddressId")
	protected Address address;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "userId",referencedColumnName = "userId")
	protected User user;

	public long getPersonId() {
		return personId;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "PersonInfo [personId=" + personId + ", personName=" + personName + ", gender=" + gender
				+ ", dateOfBirth=" + dateOfBirth + ", emailId=" + emailId + ", mobileNo=" + mobileNo + ", address="
				+ address + ", user=" + user + "]";
	}
}
