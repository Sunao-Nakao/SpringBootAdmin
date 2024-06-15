package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.Admins;
import com.example.demo.repository.AdminsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SigninService {

	private final AdminsRepository repository;
	
	public Optional<Admins> searchUserByEmail(String email) {
		return repository.findByEmail(email);
	}
	
}
