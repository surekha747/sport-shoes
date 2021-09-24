package com.simplilearn.sportyshoes.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.simplilearn.sportyshoes.dto.UserRegistrationDto;
import com.simplilearn.sportyshoes.model.User;



public interface UserService extends UserDetailsService {
	User save(UserRegistrationDto registrationDto);
	List<User> getAll();
}
