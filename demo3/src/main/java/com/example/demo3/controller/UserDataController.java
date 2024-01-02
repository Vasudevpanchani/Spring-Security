package com.example.demo3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo3.model.UserData;
import com.example.demo3.service.UserDataService;

@Controller
public class UserDataController {

	@Autowired
	private UserDataService userDataService;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@GetMapping("/logout-success")
	public String logoutPage() {
		return "logout";
	}

	@PostMapping("/addUser")
	public ModelAndView saveUser(@ModelAttribute UserData userData) {
		userDataService.saveUser(userData);
		return new ModelAndView("/login");
	}

}
