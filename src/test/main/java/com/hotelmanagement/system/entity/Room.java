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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
/**
 * 
 * @author Premala
 *
 */
@Entity
@Table(name="room_master")
public class Room {
	@Id
	@Column(name="roomId")
	@GeneratedValue(generator = "roomId", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "roomId", initialValue = 500)
	private long roomId;
	
	@Column(name="room_no")
	@NotNull(message="room number is required..")
	@Pattern(regexp="(^$|[0-9a-zA-z){10}",message="size<10,and can include characters and numeric value")
	private String roomNumber;
	
	@NotBlank(message="Room type is required!!")
	@Size(min=3,message="invalid type")
	private  String roomType;
	
	@NotBlank(message="Room Category is required!!")
	@Size(min=2,message="invalid input..")
	private String roomCategory;
	
	@NotNull(message="Room Rate is required!!")
	@Pattern(regexp="(^$|[0-9])",message="invalid input...")
    private long roomRate;
	
	@NotBlank(message="Room description is required...")
    private String roomdescription;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="hotel_id",referencedColumnName = "hotel_id")
	private Hotel roomHotelId;
	
	@OneToMany(mappedBy = "bookingId")
	//@JoinColumn(name="bookingId",referencedColumnName = "bookingId")
	private Set<Booking> booking;
    
	@NotBlank(message="Room Status is required...")
	private String roomStatus;//booked or available or  will available on date

	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Room(long roomId,
			@NotNull(message = "room number is required..") @Pattern(regexp = "(^$|[0-9a-zA-z){10}", message = "size<10,and can include characters and numeric value") String roomNumber,
			@NotBlank(message = "Room type is required!!") @Size(min = 3, message = "invalid type") String roomType,
			@NotBlank(message = "Room Category is required!!") @Size(min = 2, message = "invalid input..") String roomCategory,
			@NotNull(message = "Room Rate is required!!") @Pattern(regexp = "(^$|[0-9])", message = "invalid input...") long roomRate,
			@NotBlank(message = "Room description is required...") String roomdescription, Hotel roomHotelId,
			Set<Booking> bookingid, @NotBlank(message = "Room Status is required...") String roomStatus) {
		super();
		this.roomId = roomId;
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		this.roomCategory = roomCategory;
		this.roomRate = roomRate;
		this.roomdescription = roomdescription;
		this.roomHotelId = roomHotelId;
		this.booking = bookingid;
		this.roomStatus = roomStatus;
	}


	public long getRoomId() {
		return roomId;
	}

	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(@NotNull(message = "room number is required..") @Pattern(regexp = "(^$|[0-9a-zA-z){10}", message = "size<10,and can include characters and numeric value") String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getRoomCategory() {
		return roomCategory;
	}

	public void setRoomCategory(String roomCategory) {
		this.roomCategory = roomCategory;
	}

	public long getRoomRate() {
		return roomRate;
	}

	public void setRoomRate(long roomRate) {
		this.roomRate = roomRate;
	}

	public String getRoomdescription() {
		return roomdescription;
	}

	public void setRoomdescription(String roomdescription) {
		this.roomdescription = roomdescription;
	}

	public Hotel getRoomHotelId() {
		return roomHotelId;
	}

	public void setRoomHotelId(Hotel roomHotelId) {
		this.roomHotelId = roomHotelId;
	}

	public String getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}


	public Set<Booking> getBookingId() {
		return booking;
	}


	public void setBookingId(Set<Booking> bookingId) {
		this.booking = bookingId;
	}


	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", roomNumber=" + roomNumber + ", roomType=" + roomType + ", roomCategory="
				+ roomCategory + ", roomRate=" + roomRate + ", roomdescription=" + roomdescription + ", roomHotelId="
				+ roomHotelId + ", booking=" + booking + ", roomStatus=" + roomStatus + "]";
	}
	
}
