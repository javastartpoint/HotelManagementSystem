package com.hotelmanagement.system.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelmanagement.system.entity.Booking;
import com.hotelmanagement.system.entity.Guest;
/**
 * 
 * @author Premala
 *
 */
public interface GuestRepository extends JpaRepository<Guest,Long>{

	List<Guest> findByFirstName(String firstName);
	
	//String deleteBookingByGuestId(long guestId);

	//Guest findGuestByBookingId(long bookingId);
}
