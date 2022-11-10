package com.hotelmanagement.system.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
/**
 * 
 * @author Premala
 *
 */
@Entity
@Table(name="hotel_master")
public class Hotel {
	@Id
	@GeneratedValue(generator = "hotel", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "hotel", initialValue = 101)
	@Column(name = "hotel_id")
	private long hotelId;
	
	@Column(name = "hotel_name")
	@NotNull(message = "Hotel name must be required !!!")
	@Size(min = 2, message = "Name of the Hotel must have 2 or more character !!!")
	private String hotelName;
	
	//@NotEmpty(message="Address is required!!")
	private Address hotelAddress;
	
	@NotBlank(message = "Contact number must be required.")
	@Pattern(regexp="(^$|[0-9]{10})",message = "Invalid Number") 
	private String contactNumber;
	
	@NotBlank
	@Email
	private String hotelEmail;
	
	@NotBlank(message = "Hotel type must be required.")
	private String hotelType;
	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name="rooms",referencedColumnName = "room_no")
//	private Set<Room> rooms;
	
	@OneToMany(mappedBy = "roomId")
	private Set<Room> rooms;
	
	@NotBlank(message="Hotel Description is required!!")
	private String hotelDescription;

	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hotel(long hotelId,
			@NotNull(message = "Hotel name must be required !!!") @Size(min = 2, message = "Name of the Hotel must have 2 or more character !!!") String hotelName,
			//@NotEmpty(message = "Address is required!!")
			Address hotelAddress,
			@NotBlank(message = "Contact number must be required.") @Pattern(regexp = "(^$|[0-9]{10})", message = "Invalid Number") String contactNumber,
			@NotBlank @Email String hotelEmail, @NotBlank(message = "Hotel type must be required.") String hotelType,
			Set<Room> rooms, @NotBlank(message = "Hotel Description is required!!") String hotelDescription) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.hotelAddress = hotelAddress;
		this.contactNumber = contactNumber;
		this.hotelEmail = hotelEmail;
		this.hotelType = hotelType;
		this.rooms = rooms;
		this.hotelDescription = hotelDescription;
	}

	public long getHotelId() {
		return hotelId;
	}

	public void setHotelId(long hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public Address getHotelAddress() {
		return hotelAddress;
	}

	public void setHotelAddress(Address hotelAddress) {
		this.hotelAddress = hotelAddress;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getHotelEmail() {
		return hotelEmail;
	}

	public void setHotelEmail(String hotelEmail) {
		this.hotelEmail = hotelEmail;
	}

	public String getHotelType() {
		return hotelType;
	}

	public void setHotelType(String hotelType) {
		this.hotelType = hotelType;
	}

	public Set<Room> getRooms() {
		return rooms;
	}

	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}

	public String getHotelDescription() {
		return hotelDescription;
	}

	public void setHotelDescription(String hotelDescription) {
		this.hotelDescription = hotelDescription;
	}

	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", hotelName=" + hotelName + ", hotelAddress=" + hotelAddress
				+ ", contactNumber=" + contactNumber + ", hotelEmail=" + hotelEmail + ", hotelType=" + hotelType
				+ ", rooms=" + rooms + ", hotelDescription=" + hotelDescription + "]";
	}
	
	
}
