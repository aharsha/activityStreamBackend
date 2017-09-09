package com.stackroute.activitystream.model;


import javax.persistence.Entity;


import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name="user")
public class User extends ResourceSupport {
	@Id
	@NotBlank
	@NotEmpty
	@Pattern(regexp="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")

	private String email;
	


	@NotEmpty
	@NotBlank
	@Pattern(regexp="[a-zA-Z]{3,}", message="FristName must contain only alphabet with atleast 6 characters")
	private String username;
	
	
		
	
	// 
	//[0-9]{10}
	@Pattern(regexp = "[789]\\d{9}", message = "Mobile Number is not Proper.")
		private String mobile;
	
	
	
	
	
	@NotBlank
	@NotEmpty
	@Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{8,}")
	private String password;
	
	
	
	public User()
	{
		
	}
	
	
	public User(String email, String username, String mobile, String password) {
		super();
		this.email = email;
		this.username = username;
		this.mobile = mobile;
		this.password = password;
	}
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
	
	
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "Clients [userName=" + username + ", email="
				+ email + ", mobile=" + mobile  + " password=" + password + ", cpassword="
	+"]";
	}
	

}
