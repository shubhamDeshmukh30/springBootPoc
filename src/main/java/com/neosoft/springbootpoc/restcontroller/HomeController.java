package com.neosoft.springbootpoc.restcontroller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.springbootpoc.entity.User;
import com.neosoft.springbootpoc.util.JwtUtil;

@RestController
public class HomeController {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@GetMapping("/home")
	public String home() {
		return "This is Home Page";
	}

	@GetMapping("/admin")
	public String admin() {
		return "This is Admin Page";
	}

	/*
	 * @PostMapping("/authenticate") public String generateToken(@RequestBody User
	 * authRequest) throws Exception { try { authenticationManager.authenticate( new
	 * UsernamePasswordAuthenticationToken(authRequest.getUsername(),
	 * authRequest.getPassword())); } catch (Exception ex) { throw new
	 * Exception("inavalid username/password"); } return
	 * jwtUtil.generateToken(authRequest.getUsername()); }
	 */
}