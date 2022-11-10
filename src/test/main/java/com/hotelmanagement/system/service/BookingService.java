package com.hotelmanagement.system.service;

import java.util.List;

import com.hotelmanagement.system.entity.Booking;
import com.hotelmanagement.system.exception.DataNotFoundException;
/**
 * 
 * @author Premala
 *
 */

public interface BookingService {
	
	List<Booking> findAll();

	Booking findById(long bookingId) throws DataNotFoundException;

	void save(Booking booking);

	boolean deleteByBookingId(long bookingId);

	List<Booking> findByGuest(long guestId);
	
	boolean deleteByGuestId(long guestId);

}
