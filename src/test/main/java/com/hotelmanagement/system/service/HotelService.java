package com.hotelmanagement.system.service;

import java.util.List;

import com.hotelmanagement.system.entity.Hotel;
import com.hotelmanagement.system.exception.DataNotFoundException;
/**
 * 
 * @author Premala
 *
 */
public interface HotelService {
	List<Hotel> findAll();

	Hotel findById(long id) throws DataNotFoundException;

	void save(Hotel hotel);

	String delete(long id) throws DataNotFoundException;
	
	Hotel findByHotelName(String hotelName) throws DataNotFoundException;


}
