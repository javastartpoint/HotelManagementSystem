package com.hotelmanagement.system.serviceImpl;

import java.util.ArrayList;
/**
 * @author Swapnil
 */
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelmanagement.system.dao.BookingRepository;
import com.hotelmanagement.system.dao.GuestRepository;
import com.hotelmanagement.system.entity.Booking;
import com.hotelmanagement.system.entity.Guest;
import com.hotelmanagement.system.exception.DataNotFoundException;
import com.hotelmanagement.system.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

	BookingRepository bookingRepository;

	@Autowired
	GuestRepository guestRepository;

	@Autowired
	public BookingServiceImpl(BookingRepository bookingRepository) {
		super();
		this.bookingRepository = bookingRepository;
	}

	@Override
	public List<Booking> findAll() {
		return bookingRepository.findAll();
	}

	public Booking findById(long id) throws DataNotFoundException {
		Optional<Booking> result = bookingRepository.findById(id);
		Booking theBooking = null;
		if (result.isPresent()) {
			theBooking = result.get();
		} else {
			throw new DataNotFoundException("Booking id not found " + id);
		}
		return theBooking;
	}

	@Override
	public void save(Booking booking) {
		try {
			if(null!=booking) {
				bookingRepository.save(booking);
			} else {
				System.out.println("Couldn't save booking due to booking object is null..!!");
			}
			System.out.println("saved booking successfully..!!");
		} catch (Exception e) {
			System.out.println("Exception occured while saving booking..!!");
		}
	}

	@Override
	public boolean deleteByBookingId(long bookingId) {
		try{
			bookingRepository.deleteById(bookingId);
			return true;
		} catch(Exception e) {
			System.out.println("Exception occured while deleting booking..!!");
			return false;
		}
	}

	public List<Booking> findByGuest(long guestId) {
		List<Booking> bookings = new ArrayList<Booking>();
		Optional<Guest> guest = guestRepository.findById(guestId);
		if (guest != null) {
			bookings = bookingRepository.findByGuest(guest);
		}
		return bookings;
	}

	@Override
	public boolean deleteByGuestId(long guestId) {
		try {
			Optional<Guest> guest = guestRepository.findById(guestId);
			if (guest != null) {
				bookingRepository.deleteByGuest(guest);
			}
		} catch (Exception e) {
			System.out.println("Exception occured while deleting booking..!!"+e);
			return false;
		}
		return true;
	}
}
