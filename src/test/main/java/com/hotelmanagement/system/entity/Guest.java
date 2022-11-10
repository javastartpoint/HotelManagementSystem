package com.hotelmanagement.system.entity;
/**
 * @author Premala
 */
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="guest_master")
public class Guest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="guest_id")
	private long guestId;
	
	@Column(name="first_name")
	@NotBlank(message="first name is required..")
	private String firstName;
		
	@Column(name="last_name")
	@NotBlank(message="last name is required..")
	private String lastName;
	
	@NotBlank(message="This Field is required..")
	private String gender;
	
	@NotBlank(message = "Contact number must be required.")
	@Pattern(regexp="(^$|[0-9]{10})",message = "Invalid Number") 
	private String contactNo;
	
	@Email(message=" please write proper email id")
	@NotBlank(message="please add email id...")
	private String email;
	
	@NotBlank(message="you can't keep this field empty...")
	private Address guestAddress;
	
	@NotNull
	@Pattern(regexp="(^$|[1-9])",message="invalid data..")
	@Size(min=1,max=10,message="that much members can't be accomadated in room")
	private int noOfMembers;
	
	@NotBlank(message="identity is must...")
	private String identity;
	
	@Column(name="user_name")
	@NotBlank(message="username is must...")
	@Pattern(regexp="^[a-zA-Z0-9]{20}",message="username must be less than 20 characters..")
	private String username;
	
	@Column(name="password")
	@Pattern(regexp ="(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,16}",message="atleat 1 lowercase letter,1 Uppercase letter,1 numeric value and 1 special symbol is mandatery")
	private String password;
	
	//@JoinColumn(name="booking_id",referencedColumnName = "booking_id")
	//@OneToMany(cascade = CascadeType.ALL)
	@OneToMany(mappedBy = "bookingId")
	private Set<Booking> booking;
	
	//@JoinColumn(name="payment_id",referencedColumnName = "payment_id")
	//@OneToMany(cascade = CascadeType.ALL)
	@OneToMany(mappedBy = "paymentId")
	private Set<Payment> payment;
	
	public Guest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Guest(long guestId, @NotBlank(message = "first name is required..") String firstName,
			@NotBlank(message = "last name is required..") String lastName,
			@NotBlank(message = "This Field is required..") String gender,
			@NotBlank(message = "Contact number must be required.") @Pattern(regexp = "(^$|[0-9]{10})", message = "Invalid Number") String contactNo,
			@Email(message = " please write proper email id") @NotBlank(message = "please add email id...") String email,
			@NotBlank(message = "you can't keep this field empty...") Address guestAddress,
			@NotNull @Pattern(regexp = "(^$|[1-9])", message = "invalid data..") @Size(min = 1, max = 10, message = "that much members can't be accomadated in room") int noOfMembers,
			@NotBlank(message = "identity is must...") String identity,
			@NotBlank(message = "username is must...") @Pattern(regexp = "^[a-zA-Z0-9]{20}", message = "username must be less than 20 characters..") String username,
			@Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,16}", message = "atleat 1 lowercase letter,1 Uppercase letter,1 numeric value and 1 special symbol is mandatery") String password,
			Set<Booking> booking, Set<Payment> payment) {
		super();
		this.guestId = guestId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.contactNo = contactNo;
		this.email = email;
		this.guestAddress = guestAddress;
		this.noOfMembers = noOfMembers;
		this.identity = identity;
		this.username = username;
		this.password = password;
		this.booking = booking;
		this.payment = payment;
	}

	public long getGuestId() {
		return guestId;
	}



	public void setGuestId(long guestId) {
		this.guestId = guestId;
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



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getContactNo() {
		return contactNo;
	}



	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Address getGuestAddress() {
		return guestAddress;
	}



	public void setGuestAddress(Address guestAddress) {
		this.guestAddress = guestAddress;
	}



	public int getNoOfMembers() {
		return noOfMembers;
	}



	public void setNoOfMembers(int noOfMembers) {
		this.noOfMembers = noOfMembers;
	}



	public String getIdentity() {
		return identity;
	}



	public void setIdentity(String identity) {
		this.identity = identity;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public Set<Booking> getBooking() {
		return booking;
	}



	public void setBooking(Set<Booking> booking) {
		this.booking = booking;
	}



	public Set<Payment> getPayment() {
		return payment;
	}



	public void setPayment(Set<Payment> payment) {
		this.payment = payment;
	}



	@Override
	public String toString() {
		return "Guest [guestId=" + guestId + ", firstName=" + firstName + ", lastName=" + lastName + ", gender="
				+ gender + ", contactNo=" + contactNo + ", email=" + email + ", guestAddress=" + guestAddress
				+ ", noOfMembers=" + noOfMembers + ", identity=" + identity + ", username=" + username + ", password="
				+ password + ", booking=" + booking + ", payment=" + payment + "]";
	}



	


}
