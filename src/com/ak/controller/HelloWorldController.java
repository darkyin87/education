package com.ak.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/welcome")
public class HelloWorldController {

	 @RequestMapping(method = RequestMethod.GET)
	    public String sayHello(ModelMap model) {
		 System.out.println(" is it coming here in the controller");
	        model.addAttribute("greeting", "Hello World from Spring 4 MVC");
	        return "/views/index.html";
	    }
	 
	 
	
	 
	 
}
