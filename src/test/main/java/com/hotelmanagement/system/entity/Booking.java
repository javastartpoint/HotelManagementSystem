package com.hotelmanagement.system.entity;
/**
 * @author Premala
 */
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="booking_master")
public class Booking {
	@Id
	@GeneratedValue(generator = "bookingId", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "bookingId", initialValue = 1000)
	@Column(name = "booking_id")
	private long bookingId;
	
	@Column(name="booking_date")
	@NotNull(message="Booking date must be required ")
	@DateTimeFormat(iso = ISO.DATE)
    private LocalDate localDate;
	
	@Column(name="booking_description")
	@NotBlank(message="Booking Description is Required!!")
	private String bookingDescription;
	
	@Column(name="booking_type")
	@NotNull(message="Booking type must be required ")
	@Size(min=3,message="Type of Booking  must be have 3 or more charactor !!!!")
	private  String BookingType;
	
	@Column(name="expected_checkin_date")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate expectedCheckInDate;
	
	@Column(name="expected_checkout_date")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate expectedCheckOutDate;
	
	@ManyToOne
	@JoinColumn(name="guestId",referencedColumnName = "guest_id")
	private Guest guest;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "roomId")
	//@JoinColumn(name="roomId",referencedColumnName = "roomId")
	private Room room;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="hotelId",referencedColumnName = "hotel_id")
	private Hotel hotel;
	
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Booking(long bookingId, @NotNull(message = "Booking date must be required ") LocalDate localDate,
			@NotBlank(message = "Booking Description is Required!!") String bookingDescription,
			@NotNull(message = "Booking type must be required ") @Size(min = 3, message = "Type of Booking  must be have 3 or more charactor !!!!") String bookingType,
			LocalDate expectedCheckInDate, LocalDate expectedCheckOutDate, Guest guestId, Room room,
			Hotel hotel) {
		super();
		this.bookingId = bookingId;
		this.localDate = localDate;
		this.bookingDescription = bookingDescription;
		this.BookingType = bookingType;
		this.expectedCheckInDate = expectedCheckInDate;
		this.expectedCheckOutDate = expectedCheckOutDate;
		this.guest = guestId;
		this.room = room;
		this.hotel = hotel;
	}



	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	public LocalDate getLocalDate() {
		return localDate;
	}

	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}

	public String getBookingDescription() {
		return bookingDescription;
	}

	public void setBookingDescription(String bookingDescription) {
		this.bookingDescription = bookingDescription;
	}

	public String getBookingType() {
		return BookingType;
	}

	public void setBookingType(String bookingType) {
		BookingType = bookingType;
	}

	public LocalDate getExpectedCheckInDate() {
		return expectedCheckInDate;
	}

	public void setExpectedCheckInDate(LocalDate expectedCheckInDate) {
		this.expectedCheckInDate = expectedCheckInDate;
	}

	public LocalDate getExpectedCheckOutDate() {
		return expectedCheckOutDate;
	}

	public void setExpectedCheckOutDate(LocalDate expectedCheckOutDate) {
		this.expectedCheckOutDate = expectedCheckOutDate;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}



	public Guest getGuestId() {
		return guest;
	}



	public void setGuestId(Guest guestId) {
		this.guest = guestId;
	}



	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", localDate=" + localDate + ", bookingDescription="
				+ bookingDescription + ", BookingType=" + BookingType + ", expectedCheckInDate=" + expectedCheckInDate
				+ ", expectedCheckOutDate=" + expectedCheckOutDate + ", guest=" + guest + ", room=" + room + ", hotel="
				+ hotel + "]";
	}

	
}
