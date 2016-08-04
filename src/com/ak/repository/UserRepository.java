package com.ak.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ak.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByUserName(String username);
	
	public List<User> findAll();
	
	

}
