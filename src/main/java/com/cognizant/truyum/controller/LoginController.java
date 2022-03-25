package com.cognizant.truyum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.cognizant.truyum.model.LoginData;

@Controller
public class LoginController {

	@GetMapping("/")
	public String showWelcomPage() {
		return "welcome";
	}

	@GetMapping("/admin-login")
	public String adminLoginPage(@ModelAttribute("login") LoginData loginData) {
		return "admin-login";
	}

	@GetMapping("/customer-login")
	public String customerLoginPage() {
		return "customer-login";
	}
}
