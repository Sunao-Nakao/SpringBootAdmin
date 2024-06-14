package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.form.SigninForm;

@Controller
@RequestMapping("/admin")
public class SigninController {
	
	private static final String EMAIL = "user";
			
	private static final String PASSWORD = "pwd";
	
	
	@GetMapping("/signin")
	public String view(Model model, SigninForm form) {
		
		return "signin";
	}
	
	
	@PostMapping("/signin")
	public String signin(Model model, SigninForm form) {
		var isCorrectUserAuth = form.getEmail().equals(EMAIL)
				&&form.getPassword().equals(PASSWORD);
		if(isCorrectUserAuth) {
			return "redirect:/admin/contacts";
		}else{
			model.addAttribute("errorMag", "ログインIDとパスワードの組み合わせが間違っています。");
			return "signin";
		}
	}

}
