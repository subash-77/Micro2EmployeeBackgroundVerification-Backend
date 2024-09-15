package com.subash.api.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@Column(name = "userName")
	private String userName;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "role")
	private String role;
	@Column(name = "companyName")
	private String companyName;
	
	

	@OneToMany(targetEntity = OnboardingEmployee.class, cascade = CascadeType.ALL)
	@JoinColumn()
	private List<OnboardingEmployee> onBoardingEmployee = new ArrayList<>();
	
	@OneToMany(targetEntity = OnboardingExpEmployee.class, cascade = CascadeType.ALL)
	@JoinColumn()
	private List<OnboardingExpEmployee> onBoardingExpEmployee = new ArrayList<>();

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int userId, String userName, String email, String password, String role, String companyName,
			List<OnboardingEmployee> onBoardingEmployee, List<OnboardingExpEmployee> onBoardingExpEmployee) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.role = role;
		this.companyName = companyName;
		this.onBoardingEmployee = onBoardingEmployee;
		this.onBoardingExpEmployee = onBoardingExpEmployee;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public List<OnboardingEmployee> getOnBoardingEmployee() {
		return onBoardingEmployee;
	}

	public void setOnBoardingEmployee(List<OnboardingEmployee> onBoardingEmployee) {
		this.onBoardingEmployee = onBoardingEmployee;
	}

	public List<OnboardingExpEmployee> getOnBoardingExpEmployee() {
		return onBoardingExpEmployee;
	}

	public void setOnBoardingExpEmployee(List<OnboardingExpEmployee> onBoardingExpEmployee) {
		this.onBoardingExpEmployee = onBoardingExpEmployee;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", email=" + email + ", password=" + password
				+ ", role=" + role + ", companyName=" + companyName + ", onBoardingEmployee=" + onBoardingEmployee
				+ ", onBoardingExpEmployee=" + onBoardingExpEmployee + "]";
	}

//	@OneToOne(cascade = CascadeType.ALL)
//	private PsychiatristLogin psychiatristLogin;
	
	
	

	

	

}
