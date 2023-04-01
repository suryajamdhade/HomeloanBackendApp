package com.adm.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adm.app.config.JwtResponse;
import com.adm.app.config.JwtTokenUtil;
import com.adm.app.service.LoginService;
import com.adm.app.serviceImpl.CustomUserDetailsService;

@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@PostMapping
	public ResponseEntity<JwtResponse> login(@RequestParam("username") String username, @RequestParam("password") String password, final HttpServletRequest request) {
		
		this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		
		UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(username);
		
		
		String token = this.jwtTokenUtil.generateToken(userDetails);
		
		System.out.println("JWT "+token);
		
		return ResponseEntity.ok(new JwtResponse(token));
		
		//return loginService.login(username, password);
		
		
	}
	
	@GetMapping("/home")
	public String home() {
		return "Home";
	}
	
}
