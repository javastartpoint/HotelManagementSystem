/**
 * 
 */
package com.hotelmanagement.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelmanagement.system.entity.Hotel;

import com.hotelmanagement.system.exception.DataNotFoundException;
import com.hotelmanagement.system.exception.ErrorResponce;
import com.hotelmanagement.system.service.HotelService;

/**
 * @author Premala
 *
 */
@RestController
@RequestMapping("/api")
public class HotelRestController {
	 
	HotelService hotelService;
	
	@Autowired
	public HotelRestController(HotelService hotelService) {
		super();
		this.hotelService=hotelService;
	}

		@GetMapping("/hotels")
		public List<Hotel> findAll(){
			return hotelService.findAll();
		}
		
		@GetMapping("/hotels/{hotelId}")
		public Hotel getHotelById(@PathVariable long hotelId) throws DataNotFoundException {
			 Hotel hotel=hotelService.findById(hotelId);
			return hotel;
		}
		@PostMapping("/hotels")
		public Hotel addHotel(@RequestBody Hotel hotel) {
			//setting id as 0 because just in case they are passing id in JSON
			//force it to insert
			hotel.setHotelId(0);
			hotelService.save(hotel);
			return hotel;
		}
		
		@PutMapping("/hotels")
		public Hotel updateHotel(@RequestBody Hotel hotel) {
				hotelService.save(hotel);
				return hotel;
			}
		@DeleteMapping("/hotels/{hotelId}")
			public String deleteHotel(@PathVariable long hotelId) throws DataNotFoundException {
				String msg=hotelService.delete(hotelId);
				return msg;
				
			}
		@GetMapping("/hotels/name/{hotelName}")
		public Hotel findHotelByName(@PathVariable String hotelName) throws DataNotFoundException{
			Hotel hotel=hotelService.findByHotelName(hotelName);
			return hotel;
			
		}
}
