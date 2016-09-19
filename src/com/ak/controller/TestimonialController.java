package com.ak.controller;

import java.sql.Array;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ak.model.Testimonial;
import com.ak.service.TestimonialService;

@Controller
@RequestMapping("/Testimonial")
public class TestimonialController {
    
    @Autowired
    private TestimonialService testimonialService;
    
    
     @RequestMapping(value = "/getAll", method = RequestMethod.GET)
     @ResponseBody
        List<Testimonial> getChildren() {
         
         System.out.println("inside the get all children");
         
            List<Testimonial> testimonialList = testimonialService.getAll();
            
            System.out.println(" the size of children is --   " + testimonialList.size());
            return testimonialList;
        }
     

}
