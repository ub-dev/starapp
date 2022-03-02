package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@CrossOrigin
public class LoginController {
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
}
