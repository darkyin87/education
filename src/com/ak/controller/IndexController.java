package com.ak.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
    @RequestMapping
    public String getIndexPage() {
        return "/views/layout.html";
    }
    
    
    @RequestMapping("/loginss")
    public String getIndexPag() {
        return "/views/layout.html";
    }
    
    
    
}