package com.example.demo.service;


import org.dozer.Mapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Admins;
import com.example.demo.form.SignupForm;
import com.example.demo.repository.AdminsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SignupService {
	
private final AdminsRepository repository;

private final Mapper mapper;

private final PasswordEncoder passwordEncoder;
	
	public Admins registerAdmins(SignupForm form) {
		
		var admins = mapper.map(form, Admins.class);
		
		var encodedPassword = passwordEncoder.encode(form.getPassword());
		admins.setPassword(encodedPassword);
		
		return repository.save(admins);
	}	

}
