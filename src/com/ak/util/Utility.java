package com.ak.util;

import org.springframework.stereotype.Service;

@Service
public class Utility {
	
	
	public String getFirstString(String data, int i) {
		
		return data.split(",")[i];
	}
	
	


}
