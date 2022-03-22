package com.xoriant.xorbankonline.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@PrimaryKeyJoinColumn(name = "managerId")
public class Manager extends PersonInfo {
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "branchId")
	private Branch branch;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "manager",fetch = FetchType.EAGER)
	private List<User> users=new ArrayList<>();

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public void addUser(User user) {
		this.users.add(user);
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
