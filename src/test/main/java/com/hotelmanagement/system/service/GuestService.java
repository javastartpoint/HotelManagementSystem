package com.hotelmanagement.system.service;

import java.util.List;

import com.hotelmanagement.system.entity.Guest;
import com.hotelmanagement.system.exception.DataNotFoundException;
/**
 * 
 * @author Premala
 *
 */
public interface GuestService {
	List<Guest> findAll();

	Guest findById(long id) throws DataNotFoundException;

	void save(Guest guest);

	String delete(long id) throws DataNotFoundException;
	
}
