package com.hotelmanagement.system.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
/**
 * 
 * @author Premala
 *
 */
@Entity
@Table(name="payment_master")
public class Payment {
	@Id
	@GeneratedValue(generator = "paymentId", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "paymentId", initialValue = 1000)
	@Column(name = "payment_id")
	private long paymentId;
	
	@Column(name="payment_date")
	@NotNull(message="payment date must be required ")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate paymentDate;
	
	@Column(name="checkin_date")
	@NotNull(message="checkin date must be required ")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate checkInDate;
	
	@Column(name="checkout_date")
	@NotNull(message="checkout date must be required ")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate checkOutDate;
	
	@ManyToOne
	@JoinColumn(name="guestId",referencedColumnName = "guest_id")
	private Guest guestId;
	
	/*
	 * @JoinColumn(name="hotel_id",referencedColumnName = "hotel_id") private Hotel
	 * hotelId;
	 * 
	 * @JoinColumn(name="roomId",referencedColumnName = "room_id") private Room
	 * room;
	 */
	
	@OneToOne
	@JoinColumn(name="bookingId",referencedColumnName = "booking_id")
	private Booking booking;
	
	@NotNull(message="ammount is required!!")
	@Pattern(regexp="[0-9]",message="enter only numeric values")
	private double ammount;
	
	@NotBlank(message="choose payment method..")
	private String paymentMethod;
	
	@Column(name="status")
	@NotBlank(message="required")
	private String paymentStatus;

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment(long paymentId, @NotNull(message = "payment date must be required ") LocalDate paymentDate,
			@NotNull(message = "checkin date must be required ") LocalDate checkInDate,
			@NotNull(message = "checkout date must be required ") LocalDate checkOutDate, Guest guestId,
			Booking booking,
			@NotNull(message = "ammount is required!!") @Pattern(regexp = "[0-9]", message = "enter only numeric values") double ammount,
			@NotBlank(message = "choose payment method..") String paymentMethod,
			@NotBlank(message = "required") String paymentStatus) {
		super();
		this.paymentId = paymentId;
		this.paymentDate = paymentDate;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.guestId = guestId;
		this.booking = booking;
		this.ammount = ammount;
		this.paymentMethod = paymentMethod;
		this.paymentStatus = paymentStatus;
	}

	public long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public LocalDate getCheckInDate() {
		return checkInDate;
	}

	

	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}

	
	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	public void setCheckInDate(LocalDate checkInDate) {
		this.checkInDate = checkInDate;
	}

	public void setCheckOutDate(LocalDate checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public Guest getGuestId() {
		return guestId;
	}

	public void setGuestId(Guest guestId) {
		this.guestId = guestId;
	}

	public double getAmmount() {
		return ammount;
	}

	public void setAmmount(double ammount) {
		this.ammount = ammount;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", paymentDate=" + paymentDate + ", CheckInDate=" + checkInDate
				+ ", CheckOutDate=" + checkOutDate + ", guestId=" + guestId + ", booking=" + booking + ", ammount="
				+ ammount + ", paymentMethod=" + paymentMethod + ", paymentStatus=" + paymentStatus + "]";
	}
	
	
}
