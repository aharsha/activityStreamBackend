package com.stackroute.activitystream.model;


import javax.persistence.Entity;


import javax.persistence.Id;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class User {
	@Id
	@NotBlank
	@NotEmpty
	@Pattern(regexp="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")

	private String email;
	


	@NotEmpty
	@NotBlank
	@Pattern(regexp="[a-zA-Z]{3,}", message="FristName must contain only alphabet with atleast 6 characters")
	private String userName;
	
	
		
	
	@Pattern(regexp="[0-9]{10}")
	private String mobile;
	
	
	
	
	
	@NotBlank
	@NotEmpty
	@Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{8,}")
	private String password;
	
	
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	@Override
	public String toString() {
		return "Clients [userName=" + userName + ", email="
				+ email + ", mobile=" + mobile  + " password=" + password + ", cpassword="
	+"]";
	}
	

}
