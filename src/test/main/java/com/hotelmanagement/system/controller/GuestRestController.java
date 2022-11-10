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

import com.hotelmanagement.system.entity.Guest;
import com.hotelmanagement.system.exception.DataNotFoundException;
import com.hotelmanagement.system.service.GuestService;

/**
 * @author Premala
 *
 */

@RestController
@RequestMapping("/api")
public class GuestRestController {
	
	GuestService guestService;
	
	@Autowired
	public GuestRestController(GuestService guestService) {
		super();
		this.guestService=guestService;
	}
	
	@GetMapping("/guests")
	public List<Guest> findAll(){
		return guestService.findAll();
	}
	
	@GetMapping("/guests/{guestId}")
	public Guest getGuestById(@PathVariable long guestId) throws DataNotFoundException {
		 Guest guest=guestService.findById(guestId);
		return guest;
	}
	@PostMapping("/guests")
	public Guest addGuest(@RequestBody Guest guest) {
		//setting id as 0 because just in case they are passing id in JSON
		//force it to insert
		guest.setGuestId(0);
		guestService.save(guest);
		return guest;
	}
	
	@PutMapping("/guests")
	public Guest updateGuest(@RequestBody Guest guest) {
			guestService.save(guest);
			return guest;
		}
		@DeleteMapping("/guests/{guestId}")
		public String deleteGuest(@PathVariable long guestId) throws DataNotFoundException {
			String msg=guestService.delete(guestId);
			return msg;
			
		}

}
