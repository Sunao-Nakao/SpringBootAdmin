package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.SignupForm;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
public class SignupController {
	
	@GetMapping("/admin/signup")
	public String signup(Model model) {
		model.addAttribute("signupForm", new SignupForm());
		
		return "signup";
	}
	
	@PostMapping("/admin/signup")
	public String signup(@Validated @ModelAttribute("signupForm") SignupForm signupForm, BindingResult errorResult, HttpServletRequest request) {
		
		if (errorResult.hasErrors()) {
			return "signup";
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("signupForm", signupForm);
		
		return "redirect:/admin/signup/confirm";
	}
	
	
	@GetMapping("/admin/signup/confirm")
	public String confirm(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		SignupForm signupForm = (SignupForm) session.getAttribute("signupForm");
		model.addAttribute("signupForm", signupForm);
		return "confirmation";
	}

}
