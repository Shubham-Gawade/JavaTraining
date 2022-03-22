package com.xoriant.hibernatetutorials;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
//@Entity(name = "students")
//@Table(name = "students_table")
public class Student {
	
	//primary key
	@Id
	private int sid;
	
	//Not Store this Column in DB
	//@Transient
	private SName sname;
	
	//Change Column name
	@Column(name = "student_marks")
	private double smarks;

	//@OneToOne
	//private Laptop laptop;
	
	//-----------------------------------------------------
	
	//@OneToMany(mappedBy = "student")
	//private List<Laptop> laptops=new ArrayList<Laptop>();
	
	//-----------------------------------------------------
	
	@ManyToMany(mappedBy = "students",fetch = FetchType.EAGER)
	private List<Laptop> laptops=new ArrayList<Laptop>();
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public SName getSname() {
		return sname;
	}
	public void setSname(SName sname) {
		this.sname = sname;
	}
	public double getSmarks() {
		return smarks;
	}
	public void setSmarks(double smarks) {
		this.smarks = smarks;
	}
	
//	public Laptop getLaptop() {
//		return laptop;
//	}
//	public void setLaptop(Laptop laptop) {
//		this.laptop = laptop;
//	}
//	
//	@Override
//	public String toString() {
//		return "Student [sid=" + sid + ", sname=" + sname + ", smarks=" + smarks + ", laptop=" + laptop + "]";
//	}
	
//------------------------------------------------------------------------------------------
	
	public List<Laptop> getLaptops() {
		return laptops;
	}
	public void setLaptops(List<Laptop> laptops) {
		this.laptops = laptops;
	}
	
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", smarks=" + smarks + ", laptops=" + laptops + "]";
	}
	
}
