package com.example.demo.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.form.SigninForm;
import com.example.demo.service.SigninService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class SigninController {
	
	
	private final SigninService service;
	private final PasswordEncoder passwordEncoder;
	
	
	@GetMapping("/signin")
	public String view(Model model, SigninForm form) {
		model.addAttribute("signinForm", form);
		return "signin";
	}
	
	@PostMapping("/signin")
	public String signin(Model model, SigninForm form) {
		
		var admins = service.searchUserByEmail(form.getEmail());
		
		if (admins.isPresent() && passwordEncoder.matches(form.getPassword(), admins.get().getPassword())) {
			return "redirect:/admin/contacts";
		}else{
			model.addAttribute("errorMsg", "ログインIDとパスワードの組み合わせが間違っています。");
			return "signin";
		}
		
	}

}
