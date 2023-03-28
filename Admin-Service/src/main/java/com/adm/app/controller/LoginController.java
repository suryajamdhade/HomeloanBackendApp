package com.adm.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adm.app.service.LoginService;

@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginController {

	@Autowired
	private LoginService loginService;
	@GetMapping
	public String login(@RequestParam("username") String username, @RequestParam("password") String password, final HttpServletRequest request) {
		
		return loginService.login(username, password);
		
		
	}
	
	@GetMapping("/home")
	public String home() {
		return "Home";
	}
	
}
