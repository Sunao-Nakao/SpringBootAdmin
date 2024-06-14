package com.example.demo.service;


import org.dozer.Mapper;
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
	
	public Admins registerAdmins(SignupForm form) {
		
		
		var admins = mapper.map(form, Admins.class);
		
		return repository.save(admins);
	}	

}
