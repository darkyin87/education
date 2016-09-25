package com.ak.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ak.model.User;
import com.ak.service.UserService;


@RestController
@RequestMapping("/login")
public class HelloWorldController {
	
	@Autowired
	UserService userService;
	
	 @RequestMapping("/user")
	    public User user(Principal user) {
		 System.out.println(" going here inside the user principal");
		 
		 if(user != null)
			 return userService.loadUserByUserName(user.getName());
		 else
			 return userService.loadUserByUserName("");
	      //return user;
	    }
	 
	
	 
}
