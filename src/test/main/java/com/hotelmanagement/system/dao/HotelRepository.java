package com.hotelmanagement.system.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelmanagement.system.entity.Hotel;
/**
 * 
 * @author Premala
 *
 */
public interface HotelRepository extends JpaRepository<Hotel,Long> {
	Hotel findByHotelName(String hotelName);
}
