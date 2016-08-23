package com.ak.service;


import java.util.List;

import com.ak.model.Children;


public interface ChildrenService {

		
		public List<Children> getAll();
		
		public List<Object[]> findWithDonation();

		
	}

