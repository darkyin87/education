package com.ak.service;



import com.ak.model.User;

public interface UserService {

		public User createUser(User user);
		public User loadUserByUserName(String userName);
		public String fetchPassword(String userId);

	}
