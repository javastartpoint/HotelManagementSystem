package com.hotelmanagement.system.service;

import java.util.List;
import java.util.Optional;

import com.hotelmanagement.system.entity.User;
import com.hotelmanagement.system.exception.DataNotFoundException;
/**
 * 
 * @author Premala
 *
 */
public interface UserService {
	
	List<User> findAll();

	User findById(long userId) throws DataNotFoundException;

	String save(User user);

	String delete(long userId) throws DataNotFoundException;
	
	List<User> findByFirstName(String userName) throws DataNotFoundException;

	List<User> findByUserRole(String userRole) throws DataNotFoundException;

}

