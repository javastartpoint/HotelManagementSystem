/**
 * 
 */
package com.hotelmanagement.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hotelmanagement.system.entity.User;
import com.hotelmanagement.system.exception.DataNotFoundException;
import com.hotelmanagement.system.service.UserService;

/**
 * @author Premala
 *
 */
//@SpringBootApplication
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class UserRestController {
	
	//@Autowired
	UserService userService;
	
	@Autowired
	public UserRestController(UserService userService) {
		super();
		this.userService=userService;
	}
	@GetMapping("/users")
	public List<User> findAll(){
		return userService.findAll();
	}
	
	@GetMapping("/users/{userId}")
	public User getUserById(@PathVariable long userId) throws DataNotFoundException {
		User user=userService.findById(userId);
		return user;
	}
	
	@PostMapping("/users")
	public String addUser(@RequestBody User user) {
		//setting id as 0 because just in case they are passing id in JSON
		//force it to insert
		user.setUserId(0);
		userService.save(user);
		return "Hi " + user.getFirstName() + " your Registration process successfully completed";
	}
	
	@PutMapping("/users")
	public User updateUser(@RequestBody User user) {
			userService.save(user);
			return user;
		}
	
	@DeleteMapping("/users/{userId}")
		public String deleteUser(@PathVariable long userId) throws DataNotFoundException {
			String msg=userService.delete(userId);
			return msg;
			
		}
	@GetMapping("/users/name/{userName}")
	public List<User> findUserByName(@PathVariable String userName) throws DataNotFoundException{
		List<User> user=userService.findByFirstName(userName);
		return user;
		
	}
	
	@GetMapping("/users/role/{userRole}")
	public List<User> findUserByRole(@PathVariable String userRole) throws DataNotFoundException{
		List<User> user=userService.findByUserRole(userRole);
		return user;
		
	}

}
