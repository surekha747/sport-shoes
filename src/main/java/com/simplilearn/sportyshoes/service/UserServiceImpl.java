package com.simplilearn.sportyshoes.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import  com.simplilearn.sportyshoes.model.Role;
import com.simplilearn.sportyshoes.dto.UserRegistrationDto;
import com.simplilearn.sportyshoes.model.User;
import com.simplilearn.sportyshoes.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	@Override
	public User save(UserRegistrationDto registrationDto) {
		
		User user = new User(registrationDto.getFirstName(), registrationDto.getLastName(), registrationDto.getEmail(),
				passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new Role("Admin")));

		return userRepository.save(user);
	}
	@Override
	public User changepassword(UserRegistrationDto registrationDto) {
		
		String modelpassword=registrationDto.getPassword();
		String newpassword=registrationDto.getNewpassword();
		String username=registrationDto.getEmail();
		User entity = userRepository.findByEmail(username);
		String dbpassword=entity.getPassword();
		
		if (passwordEncoder.matches(modelpassword, dbpassword)) {
			
			entity.setPassword(passwordEncoder.encode(newpassword));
			
		}
		return entity= userRepository.save(entity);
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				mapRolesToAuthorities(user.getRoles()));
	}
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
	

	@Override
	public List<User> getAll() {
		
		return userRepository.findAll();
	}
	

}
