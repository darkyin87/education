package com.ak.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ak.model.Children;
import com.ak.service.AdminService;
import com.ak.service.ChildrenService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/admin")
public class AdminController {


	@Autowired
	private AdminService adminService;
	@Autowired
	private ChildrenService childrenService;
	
	
	 @RequestMapping(value = "/save", method = RequestMethod.POST)
	 public ResponseEntity<String> saveChildren() {
		 
		 	
	        return new ResponseEntity<String>("sucess", HttpStatus.OK);
			
		}
	 
	 
	 
	 
	 @RequestMapping(value = "/saveUserDataAndFile", method = RequestMethod.POST)
		@ResponseBody
		public Object saveUserDataAndFile(@RequestParam(value = "children") String childrenInfo,
		        @RequestParam(value = "file") MultipartFile file,HttpServletRequest request) {
			
			System.out.println("Inside File upload" + childrenInfo);
			ObjectMapper mapper = new ObjectMapper();
			
			
			//String rootDirectory = request.getSession().getServletContext().getRealPath("/");
			String rootDirectory = "/Users/gdharumar/Documents/Personal/LoadHere/";
			System.out.println("Root Directory "+rootDirectory);
			try {
				Children children = mapper.readValue(childrenInfo, Children.class);
				children.setPicture(file.getOriginalFilename());
				childrenService.save(children);
				System.out.println(" the user value is --  " + children.getFirstName());
				file.transferTo(new File(rootDirectory  + file.getOriginalFilename()));
				System.out.print("is it done transfer???");
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
			
		}

}
