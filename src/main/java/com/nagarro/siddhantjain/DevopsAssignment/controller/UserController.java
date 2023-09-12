package com.nagarro.siddhantjain.DevopsAssignment.controller;

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

import com.nagarro.siddhantjain.DevopsAssignment.models.User;
import com.nagarro.siddhantjain.DevopsAssignment.services.UserService;


@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<User> getAllUsers() {
		return this.userService.getAllUsers();
	}
	
	@PostMapping
	public User addUser(@RequestBody User user) {
		return this.userService.addUser(user);
	}
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable ("id") long id) {
		return this.userService.getUserById(id);
	}
	
	@PutMapping("/{id}")
	public User editUser(@RequestBody User user,@PathVariable ("id") long id) {
		return this.userService.editUser(user, id);
	}
	
	@DeleteMapping("/{id}")
	public User deleteUser(@PathVariable ("id") long id) {
		return this.userService.deleteUser(id);
	}

}
