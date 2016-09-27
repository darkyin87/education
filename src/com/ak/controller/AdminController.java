package com.ak.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ak.model.Children;
import com.ak.model.Pages;
import com.ak.model.PagesSection;
import com.ak.model.Testimonial;
import com.ak.service.ChildrenService;
import com.ak.service.PageSectionService;
import com.ak.service.PageService;
import com.ak.service.TestimonialService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ChildrenService childrenService;
	@Autowired
	private TestimonialService testimonialService;
	@Autowired
	private PageService pageService;
	@Autowired
	private PageSectionService pagesSectionService;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<String> saveChildren() {

		return new ResponseEntity<String>("sucess", HttpStatus.OK);

	}

	@RequestMapping(value = "/saveUserDataAndFile", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> saveUserDataAndFile(@RequestParam(value = "children") String childrenInfo,
			@RequestParam(value = "file") MultipartFile file, HttpServletRequest request) {

		System.out.println("Inside File upload" + childrenInfo);
		ObjectMapper mapper = new ObjectMapper();

		// String rootDirectory =
		// request.getSession().getServletContext().getRealPath("/");
		String rootDirectory = "/Users/gdharumar/Documents/Personal/LoadHere/";
		System.out.println("Root Directory " + rootDirectory);
		try {
			Children children = mapper.readValue(childrenInfo, Children.class);
			children.setPicture(file.getOriginalFilename());
			childrenService.save(children);
			System.out.println(" the user value is --  " + children.getFirstName());
			file.transferTo(new File(rootDirectory + file.getOriginalFilename()));
			System.out.print("is it done transfer???");
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ResponseEntity<String>("sucess", HttpStatus.OK);
	}

	@RequestMapping(value = "/createTestimonial", method = RequestMethod.POST)
	public ResponseEntity<String> createTestimonial(@RequestBody Testimonial testimonial) {

		testimonialService.save(testimonial);

		return new ResponseEntity<String>("sucess", HttpStatus.OK);

	}

	@RequestMapping(value = "/createPageSection", method = RequestMethod.POST)
	public ResponseEntity<String> createPageSection(@RequestBody List<PagesSection> pageSection) {

		System.out.println(" pages section --  " + pageSection);

		// testimonialService.save(testimonial);
		
		pagesSectionService.saveOrUpdate(pageSection);

		return new ResponseEntity<String>("sucess", HttpStatus.OK);

	}

	@RequestMapping(value = "/createPage", method = RequestMethod.POST)
	public ResponseEntity<String> createPage(@RequestBody Pages page) {

		pageService.createPage(page);

		return new ResponseEntity<String>("sucess", HttpStatus.OK);

	}

	@RequestMapping(value = "/getPages", method = RequestMethod.GET)
	@ResponseBody
	public List<Pages> getPages() {

		List<Pages> pages = pageService.getPages();

		System.out.println(" the pages - " + pages);
		return pages;

	}

	@RequestMapping(value = "/getPageSectionForPage", method = RequestMethod.GET)
	@ResponseBody
	public List<PagesSection> getPageSectionForPage(@RequestParam(value = "pageId") String pageId) {

		List<PagesSection> pagesSectionList = pagesSectionService.getPageSectionForPage(pageId);

		System.out.println(" the pages - " + pagesSectionList);
		return pagesSectionList;

	}
	
	
	
	
	

}
