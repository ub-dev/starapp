package com.example.demo.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.User;
import com.example.demo.service.MyUserDetailService;

@RestController
@CrossOrigin
public class HomeController {

	@RequestMapping("/")
	public String home() {
		return "Home";
	}

	@Autowired
	private MyUserDetailService myUserDetailService;

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	@ResponseBody
	public User getUser(HttpServletRequest request) {
		String username = null;
		Principal principal = request.getUserPrincipal();
		if (principal != null) {
			username = principal.getName();
		}
		ModelAndView obj = new ModelAndView("index");
		obj.addObject("user", principal.getName());
		obj.addObject("user", myUserDetailService.loadUserByUsername(username).getUser().getUsername());
		return myUserDetailService.loadUserByUsername(username).getUser();
	}

}