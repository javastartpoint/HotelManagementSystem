package com.hotelmanagement.system.service;

import java.util.List;


import com.hotelmanagement.system.entity.Room;
import com.hotelmanagement.system.exception.DataNotFoundException;
/**
 * 
 * @author Premala
 *
 */
public interface RoomService {
	
	List<Room> findAll();

	Room findById(long roomId) throws DataNotFoundException;

	void save(Room room);

	boolean delete(long roomId);
	
//	Room findByRoomNo(String roomNo);
//	
//	String deleteByRoomNo(String roomNo);
}
