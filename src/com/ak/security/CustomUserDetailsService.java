package com.ak.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.ak.model.User;
import com.ak.service.UserService;
@Component
public class CustomUserDetailsService implements UserDetailsService
{
	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		System.out.println("inside the service");
		User user = userService.loadUserByUserName(userName);
		System.out.println("after ther loaduser --  " + user);
		if(user == null){
			throw new UsernameNotFoundException("UserName "+userName+" not found");
		}
		return new SecurityUser(user);
	}
}