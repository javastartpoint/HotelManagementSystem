/**
 * 
 */
package com.hotelmanagement.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelmanagement.system.entity.Booking;
import com.hotelmanagement.system.exception.DataNotFoundException;
import com.hotelmanagement.system.service.BookingService;

/**
 * @author Premala
 *
 */

@RestController
@RequestMapping("/api")
public class BookingRestController {
	
	BookingService bookingService;
	
	@Autowired
	public BookingRestController(BookingService bookingService) {
		super();
		this.bookingService=bookingService;
	}
	
	@GetMapping("/bookings")
	public List<Booking> findAll(){
		return bookingService.findAll();
	}
	
	@GetMapping("/bookings/{bookingId}")
	public Booking getBookingById(@PathVariable long bookingId) throws DataNotFoundException {
		Booking booking=bookingService.findById(bookingId);
		return booking;
	}
	@PostMapping("/bookings")
	public Booking addBooking(@RequestBody Booking booking) {
		//setting id as 0 because just in case they are passing id in JSON
		//force it to insert
		booking.setBookingId(0);
		bookingService.save(booking);
		return booking;
	}
	
	@PutMapping("/bookings")
	public Booking updateBooking(@RequestBody Booking booking) {
			bookingService.save(booking);
			return booking;
		}
	
	@DeleteMapping("/bookings/{bookingId}")
		public boolean deleteBooking(@PathVariable long bookingId) throws DataNotFoundException {
			boolean msg=bookingService.deleteByBookingId(bookingId);
			return msg;
			
		}
	@GetMapping("/bookings/guest/{guestId}")
	public List<Booking> findBookingByGuest(@PathVariable long guestId) throws DataNotFoundException{
		List<Booking> booking=bookingService.findByGuest(guestId);
		return booking;
		
	}
	
	@GetMapping("/users/guest/{guestId}")
	public boolean deleteByGuestId(@PathVariable long guestId) throws DataNotFoundException{
		boolean msg =bookingService.deleteByGuestId(guestId);
		return msg;
		
	}
}
