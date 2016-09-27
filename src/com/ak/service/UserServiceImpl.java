package com.ak.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ak.model.User;
import com.ak.repository.UserRepository;
import com.ak.repository.UserRolesRepository;

@Service
public class UserServiceImpl implements UserService{

	@Resource
    private UserRepository userRepository;
	@Resource
	private UserRolesRepository userRolesRepository;
	
	@Autowired
    private PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public User createUser(User user) {
		User createdUser = user;
		System.out.println("before");
		createdUser.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(createdUser);
		
	}
	@Override
	public User loadUserByUserName(String userName){
		
		User user =  userRepository.findByUserName(userName);
		return user;
}
	
	
	

}
