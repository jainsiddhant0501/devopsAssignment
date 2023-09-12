package com.nagarro.siddhantjain.DevopsAssignment.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.siddhantjain.DevopsAssignment.models.User;
import com.nagarro.siddhantjain.DevopsAssignment.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	//get all users
	public List<User> getAllUsers(){
		return this.userRepository.findAll();
	}
	
	//get user by id
	public User getUserById(long id) {
		return this.userRepository.getUserByUserId(id);
	}
	
	//add user
	public User addUser(User user) {
		return this.userRepository.save(user);
	}
	
	//edit user
	public User editUser(User user,long id) {
		User existUser = this.userRepository.getUserByUserId(id);
		if(existUser!=null) {
			existUser.setUsername(user.getUsername());
			existUser.setEmail(user.getEmail());
		}
		return this.userRepository.save(existUser);
	}
	
	//delete user
	public User deleteUser(long id) {
		User existUser = this.userRepository.getUserByUserId(id);
		if(existUser!=null) {
			this.userRepository.delete(existUser);
		}
		return null;
	}

}
