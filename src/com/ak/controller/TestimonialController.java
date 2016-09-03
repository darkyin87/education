package com.ak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ak.model.Testimonial;
import com.ak.service.TestimonialService;

@Controller
@RequestMapping("/testimonial")
public class TestimonialController {


	@Autowired
	private TestimonialService testimonialService;
	
	
	 @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public ResponseEntity<String> save(@RequestBody Testimonial testimonial) {
		 
		 testimonialService.save(testimonial);

	        return new ResponseEntity<String>("sucess", HttpStatus.OK);

		}
	
}
