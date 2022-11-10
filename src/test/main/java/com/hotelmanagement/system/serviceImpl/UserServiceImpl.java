/**
 * 
 */
package com.hotelmanagement.system.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hotelmanagement.system.dao.UserRepository;
import com.hotelmanagement.system.entity.User;
import com.hotelmanagement.system.exception.DataNotFoundException;
import com.hotelmanagement.system.service.UserService;

/**
 * @author Premala
 *
 */
@Service
public class UserServiceImpl implements UserService {
	
	UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository=userRepository;
	}

	@Override
	public List<User> findAll() {
		
		return userRepository.findAll();
	}

	@Override
	public User findById(long userId) throws DataNotFoundException {
		Optional<User> result=userRepository.findById(userId);
		User theUser=null;
		if(result.isPresent())
		{
			theUser=result.get();
		}
		else {
			throw new DataNotFoundException("User id not found :"+userId);
		}
		return theUser;
	}

	@Override
	public String save(User user) {
		userRepository.save(user);
		return user.getFirstName()+"saved !!";
		
	}

	@Override
	public String delete(long id) throws DataNotFoundException {
		User user=findById(id);
		if(user!=null) {
			userRepository.deleteById(id);
		}
		return "deleted user id"+id;
	}

	@Override
	public List<User> findByFirstName(String userName) throws DataNotFoundException {
		List<User> result=userRepository.findByFirstName(userName);
		if(result.isEmpty()) {
			throw new DataNotFoundException("Hotel with "+userName+" name not found..");
		}
		return result;
	}

	@Override
	public List<User> findByUserRole(String userRole) throws DataNotFoundException {
		List<User> result=userRepository.findByUserRole(userRole);
		if(result.isEmpty()) {
			throw new DataNotFoundException("User with "+userRole+" name not found..");
		}
		return result;
	}

}
