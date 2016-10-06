package com.ak.security;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.ak.model.User;
import com.ak.model.UserRoles;
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
		System.out.println("after ther loaduser --  " + user.getRoles());

		List authorities = buildUserAuthority(user.getRoles());
		
		System.out.println("authoritieze --  " + authorities);;
		if(user == null){
			throw new UsernameNotFoundException("UserName "+userName+" not found");
		}
		
		System.out.println(" before the return statement");;
		
		return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),true,true,true,true,authorities);
	}
	
	private List buildUserAuthority(Set<UserRoles> userRoles){
		Set setAuths = new HashSet<>();
		
		for (UserRoles userRole : userRoles){
			setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
			
		}
		
		List result = new ArrayList(setAuths);
		return result;
	}
	
	
}