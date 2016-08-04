package com.ak.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/", method = RequestMethod.GET)
@Controller
public class DefaultController {
    public String home(ModelMap modelMap) {
        return "/views/index.html";
    }
}
