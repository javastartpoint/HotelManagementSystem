/**
 * 
 */
package com.hotelmanagement.system.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelmanagement.system.dao.RoomRepository;
import com.hotelmanagement.system.entity.Room;
import com.hotelmanagement.system.exception.DataNotFoundException;
import com.hotelmanagement.system.service.RoomService;

/**
 * @author Premala
 *
 */

@Service
public class RoomServiceImpl implements RoomService {
	
	RoomRepository roomRepository;
	
	@Autowired
	public RoomServiceImpl(RoomRepository roomRepository) {
		super();
		this.roomRepository=roomRepository;
	}

	@Override
	public List<Room> findAll() {
		
		return roomRepository.findAll();
	}

	@Override
	public Room findById(long roomId) throws DataNotFoundException {
		Optional<Room> result = roomRepository.findById(roomId);
		Room room = null;
		if (result.isPresent()) {
			room = result.get();
		} else {
			throw new DataNotFoundException("Room id not found :" + roomId);
		}
		return room;
	}

	@Override
	public void save(Room room) {
		try {
			if(null!=room) {
				roomRepository.save(room);
			} else {
				System.out.println("Couldn't save Room due to room object is null..!!");
			}
			System.out.println("saved room successfully..!!");
		} catch (Exception e) {
			System.out.println("Exception occured while saving Room..!!");
		}
		
	}

	@Override
	public boolean delete(long roomId) {
		try{
			roomRepository.deleteById(roomId);
			return true;
		} 
		catch(Exception e) {
			System.out.println("Exception occured while deleting booking..!!"+e);
			return false;
		}
	}

}
