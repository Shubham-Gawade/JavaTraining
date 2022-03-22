package com.xoriant.hibernatetutorials;

import javax.persistence.Embeddable;

//Do not create another table add columns into Student Table
@Embeddable
public class SName {

	private String fname;
	private String lname;
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	@Override
	public String toString() {
		return "SName [fname=" + fname + ", lname=" + lname + "]";
	}
}
