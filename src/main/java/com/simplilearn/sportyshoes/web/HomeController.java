package com.simplilearn.sportyshoes.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@GetMapping("/changepassword")
	public String changepassword() {
		return "change-password";
	}
	@GetMapping("/")
	public String home() {
		return "index";
	}
}

