package com.hotelmanagement.system.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelmanagement.system.entity.Room;
/**
 * 
 * @author Premala
 *
 */
public interface RoomRepository extends JpaRepository<Room,Long> {

}
