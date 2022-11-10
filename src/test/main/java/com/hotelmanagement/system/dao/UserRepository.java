package com.hotelmanagement.system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.hotelmanagement.system.entity.User;
/**
 * 
 * @author Premala
 *
 */

public interface UserRepository extends JpaRepository<User, Long> {
	

	List<User> findByFirstName(String userName);

	List<User> findByUserRole(String userRole);

	
	

}
