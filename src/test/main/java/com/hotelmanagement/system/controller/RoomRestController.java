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
import com.hotelmanagement.system.entity.Room;
import com.hotelmanagement.system.exception.DataNotFoundException;
import com.hotelmanagement.system.service.RoomService;

/**
 * @author Premala
 *
 */

@RestController
@RequestMapping("/api")
public class RoomRestController {
	
	RoomService roomService;
	
	@Autowired
	public RoomRestController(RoomService roomService) {
		super();
		this.roomService=roomService;
	}
	
	@GetMapping("/rooms")
	public List<Room> findAll(){
		return roomService.findAll();
	}
	
	@GetMapping("/rooms/{roomId}")
	public Room getRoomById(@PathVariable long roomId) throws DataNotFoundException {
		 Room room=roomService.findById(roomId);
		return room;
	}
	@PostMapping("/rooms")
	public Room addRoom(@RequestBody Room room) {
		//setting id as 0 because just in case they are passing id in JSON
		//force it to insert
		room.setRoomId(0);
		roomService.save(room);
		return room;
	}
	
	@PutMapping("/rooms")
	public Room updateRoom(@RequestBody Room room) {
			roomService.save(room);
			return room;
		}
		@DeleteMapping("/rooms/{roomId}")
		public boolean deleteRoom(@PathVariable long roomId) throws DataNotFoundException {
			boolean msg=roomService.delete(roomId);
			return msg;
			
		}
}
