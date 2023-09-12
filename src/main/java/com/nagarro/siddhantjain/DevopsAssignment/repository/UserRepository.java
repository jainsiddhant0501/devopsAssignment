package com.nagarro.siddhantjain.DevopsAssignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.siddhantjain.DevopsAssignment.models.User;


public interface UserRepository extends JpaRepository<User, Long>{
	
	public User getUserByUserId(long id);
}
