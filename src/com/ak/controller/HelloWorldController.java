package com.ak.controller;

import java.security.Principal;
import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ak.model.User;
import com.ak.model.UserRoles;
import com.ak.service.UserService;


@RestController
@RequestMapping("/login")
public class HelloWorldController {
	
	@Autowired
	UserService userService;
	
	 @RequestMapping("/user")
	    public User user(Principal user) {
		 System.out.println(" going here inside the user principal");
		 
		 if(user != null){
			 User returnUser = userService.loadUserByUserName(user.getName());
			 
			 Set<UserRoles> roles = returnUser.getRoles();
			 Iterator itr = roles.iterator();
			 while(itr.hasNext()){
				 UserRoles role = (UserRoles)itr.next();
			 System.out.println(" return user is --  " + role.getRole());
			 }
			 return returnUser;
			 
		 }else {
			 return userService.loadUserByUserName("");
		 }
	      //return user;
	    }
	 
	
	 
}
