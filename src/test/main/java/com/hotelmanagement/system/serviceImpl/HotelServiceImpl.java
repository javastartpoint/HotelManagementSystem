package com.hotelmanagement.system.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelmanagement.system.dao.HotelRepository;
import com.hotelmanagement.system.entity.Hotel;
import com.hotelmanagement.system.exception.DataNotFoundException;
import com.hotelmanagement.system.service.HotelService;
/**
 * 
 * @author Premala
 *
 */
@Service
public class HotelServiceImpl implements HotelService {

	HotelRepository hotelRepository;

	@Autowired
	public HotelServiceImpl(HotelRepository hotelRepository) {
		super();
		this.hotelRepository=hotelRepository;
	}

	@Override
	public List<Hotel> findAll() {
		
		return hotelRepository.findAll();
	}

	@Override
	public Hotel findById(long id) throws DataNotFoundException {
		Optional<Hotel> result=hotelRepository.findById(id);
		Hotel theHotel=null;
		if(result.isPresent())
		{
			theHotel=result.get();
		}
		else {
			throw new DataNotFoundException("Hotel id not found :"+id);
		}
		return theHotel;
	}

	@Override
	public void save(Hotel hotel) {
		hotelRepository.save(hotel);
		
	}

	@Override
	public String delete(long id) throws DataNotFoundException {
		Hotel hotel=findById(id);
		if(hotel!=null) {
			hotelRepository.deleteById(id);
		}
		return "deleted hotel id  "+id;
	}

	@Override
	public Hotel findByHotelName(String hotelName) throws DataNotFoundException {
		Hotel result=hotelRepository.findByHotelName(hotelName);
		if(result == null) {
			throw new DataNotFoundException("Hotel with "+hotelName+" name not found..");
		}
		return result;
	}
	
}
