package com.ak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ak.model.PaymentDetail;
import com.ak.service.PaymentService;

@Controller
@RequestMapping("/Payment")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	
	

	 @RequestMapping(value = "/checkForChildrenId", method = RequestMethod.GET)
		public ResponseEntity<PaymentDetail> checkForChildrenId(@RequestParam int childrenId) {
		 
		 System.out.println("inside the get all children" + childrenId);
		 PaymentDetail paymentDetail = paymentService.checkChildrenPresent(childrenId);
			System.out.println(" the size of children is --   " + paymentDetail);
			return new ResponseEntity<PaymentDetail>(HttpStatus.OK);
		}
	 

}
