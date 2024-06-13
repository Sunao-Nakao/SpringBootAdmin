package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.data.SignupData;

@Controller
public class SinupController {
	@PostMapping("/signup")
	public ModelAndView signup(@ModelAttribute SignupData signupData, ModelAndView mv) {
								
		mv.setViewName("admin/confirmation");

		mv.addObject("lastName", signupData.getLastName());
		mv.addObject("firstName", signupData.getFirstName());
		mv.addObject("email", signupData.getEmail());
		mv.addObject("password", signupData.getPassword());
		
		return mv;
	}

}
