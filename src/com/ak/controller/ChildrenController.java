package com.ak.controller;

import java.sql.Array;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ak.model.Children;
import com.ak.service.ChildrenService;

@Controller
@RequestMapping("/Children")
public class ChildrenController {
	
	@Autowired
	private ChildrenService childrenService;
	
	
	 @RequestMapping(value = "/getAll", method = RequestMethod.GET)
	 @ResponseBody
		List<Object[]> getChildren() {
		 
		 System.out.println("inside the get all children");
		 
			List<Children> childrenList = childrenService.getAll();
			List<Object[]> childrens = childrenService.findWithDonation();
			
			System.out.println(" the size of children is --   " + childrens);
			System.out.println("childrenList -- "+ childrens.get(0)[2]);
			//return childrenList;
			return childrens;
		}
	 

}
