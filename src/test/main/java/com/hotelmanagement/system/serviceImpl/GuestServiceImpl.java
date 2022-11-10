/**
 * 
 */
package com.hotelmanagement.system.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.hotelmanagement.system.dao.BookingRepository;
import com.hotelmanagement.system.dao.GuestRepository;
import com.hotelmanagement.system.entity.Booking;
import com.hotelmanagement.system.entity.Guest;
import com.hotelmanagement.system.exception.DataNotFoundException;
import com.hotelmanagement.system.service.GuestService;

/**
 * @author Premala
 *
 */
@Service
public class GuestServiceImpl implements GuestService {

	GuestRepository guestRepository;

	public GuestServiceImpl(GuestRepository guestRepository) {
		super();
		this.guestRepository = guestRepository;
	}

	@Override
	public List<Guest> findAll() {

		return guestRepository.findAll();
	}

	@Override
	public Guest findById(long id) throws DataNotFoundException {
		Optional<Guest> result = guestRepository.findById(id);
		Guest guest = null;
		if (result.isPresent()) {
			guest = result.get();
		} else {
			throw new DataNotFoundException("Guest id not found :" + id);
		}
		return guest;
	}

	@Override
	public void save(Guest guest) {

		guestRepository.save(guest);

	}

	@Override
	public String delete(long id) throws DataNotFoundException {
		Guest guest = findById(id);
		if (guest != null) {
			guestRepository.deleteById(id);
		}
		return "deleted guest id  " + id;
	}


}
