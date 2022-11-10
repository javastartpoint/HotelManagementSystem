package com.hotelmanagement.system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelmanagement.system.entity.Booking;
import com.hotelmanagement.system.entity.Guest;
/**
 * 
 * @author Premala
 *
 */
public interface BookingRepository extends JpaRepository<Booking,Long> {
	
	List<Booking> findByGuest(Optional<Guest> guest);
	
	boolean deleteByGuest(Optional<Guest> guest);
}
