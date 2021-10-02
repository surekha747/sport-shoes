package com.simplilearn.sportyshoes.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.simplilearn.sportyshoes.dto.UserRegistrationDto;
import com.simplilearn.sportyshoes.service.UserService;
@Controller
public class HomeController {
	private UserService userService;
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	public HomeController(UserService userService) {
		super();
		this.userService = userService;
	}
	@ModelAttribute("user")
	public UserRegistrationDto userRegistrationDto() {
		return new UserRegistrationDto();
	}
	@RequestMapping(value = "/changepassword", method = RequestMethod.GET)
	public String changepassword() {
		return "changepassword";
	}
	@RequestMapping(value = "/changepassword", method = RequestMethod.POST)
	public String changePassword(@ModelAttribute("user") UserRegistrationDto registrationDto) {
		userService.changepassword(registrationDto);
		return "redirect:/changepassword?success";
		
	}
	@GetMapping("/")
	public String home() {
		return "index";
	}
}

