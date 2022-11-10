package com.hotelmanagement.system.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
/**
 * 
 * @author Premala
 *
 */
@Entity
@Table(name="user_master")
public class User {
	@Id
	@GeneratedValue(generator = "user", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "user", initialValue = 01)
	@Column(name="user_id")
	private long userId;
	
	@Column(name="first_name")
	@NotBlank(message="first name is required..")
	private String firstName;
	
	@Column(name="last_name")
	@NotBlank(message="last name is required..")
	private String lastName;
	
	@NotBlank(message = "Contact number must be required.")
	@Pattern(regexp="(^$|[0-9]{10})",message = "Invalid Number") 
	private  long contactNo;
	
	@Email(message=" please write proper email id")
	@NotBlank(message="please add email id...")
	private String email;
	
	@NotBlank(message="identity is must...")
	private String identity;
	
	@Column(name="user_name")
	private String userName;
		
	@Column(name="password")
	private String password;
	
	
     private String userRole;

	private boolean enabled;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	


	public User(long userId, @NotBlank(message = "first name is required..") String firstName,
			@NotBlank(message = "last name is required..") String lastName,
			@NotBlank(message = "Contact number must be required.") @Pattern(regexp = "(^$|[0-9]{10})", message = "Invalid Number") long contactNo,
			@Email(message = " please write proper email id") @NotBlank(message = "please add email id...") String email,
			@NotBlank(message = "identity is must...") String identity, String userName, String password,
			String userRole, boolean enabled) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNo = contactNo;
		this.email = email;
		this.identity = identity;
		this.userName = userName;
		this.password = password;
		this.userRole = userRole;
		this.enabled = enabled;
	}




	

	public String getUserRole() {
		return userRole;
	}




	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}




	public long getUserId() {
		return userId;
	}



	public void setUserId(long userId) {
		this.userId = userId;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public long getContactNo() {
		return contactNo;
	}



	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getIdentity() {
		return identity;
	}



	public void setIdentity(String identity) {
		this.identity = identity;
	}



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




	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", contactNo="
				+ contactNo + ", email=" + email + ", identity=" + identity + ", userName=" + userName + ", password="
				+ password + ", userRole=" + userRole + ", enabled=" + enabled + "]";
	}

	
	




}