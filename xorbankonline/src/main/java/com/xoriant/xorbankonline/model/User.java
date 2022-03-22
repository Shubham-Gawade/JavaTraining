package com.xoriant.xorbankonline.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.TableGenerator;

import com.xoriant.xorbankonline.enums.Role;

@Entity
public class User {

	@Id
	@TableGenerator(name = "User_Gen", table = "User_ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", pkColumnValue = "User_Gen", initialValue = 10000, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "User_Gen")
	private int userId;
	private String userName;
	private String password;
	private String securityQuestion;
	private String securityAnswer;

	@Enumerated(EnumType.STRING)
	private Role role;

	//@OneToOne(mappedBy = "user")
	@OneToOne(cascade = CascadeType.PERSIST, mappedBy = "user")
	private PersonInfo personInfo;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "managerId")
	private Manager manager;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public String getSecurityAnswer() {
		return securityAnswer;
	}

	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public PersonInfo getPersonInfo() {
		return personInfo;
	}

	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}
}
