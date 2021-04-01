package com.neosoft.springbootpoc.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.springbootpoc.entity.User;
import com.neosoft.springbootpoc.exception.InvalidId;
import com.neosoft.springbootpoc.response.DataResponse;
import com.neosoft.springbootpoc.service.UserService;
import com.neosoft.springbootpoc.util.JwtUtil;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserService userservice;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@DeleteMapping(path = "/remove/hard/{userId}")
	public DataResponse deleteUser(@PathVariable("userId") int userId) {
		System.out.println(userId);
		if (userId == 0) {
			throw new InvalidId("Id should not be Null");
		} else {
			String message = userservice.removeUser(userId);
			DataResponse dataResponse = new DataResponse();
			dataResponse.setMessage(message);
			dataResponse.setStatus(HttpStatus.OK);
			return dataResponse;
		}
	}

	@GetMapping("/fetchuserbydob")
	public DataResponse sortUserByDob() {
		List<User> userlist = userservice.fetchUserByDob();
		DataResponse dataResponse = new DataResponse();
		dataResponse.setBody(userlist);
		return dataResponse;
	}

	@GetMapping("/fetchuserbydoj")
	public DataResponse sortUserByDoj() {
		List<User> userlist = userservice.fetchUserByDoj();
		DataResponse dataResponse = new DataResponse();
		dataResponse.setBody(userlist);
		return dataResponse;
	}

	@DeleteMapping("/soft/remove/{id}")
	public int softDelete(@PathVariable("id") int id) {
		if (id == 0) {
			throw new InvalidId("id should not be null");
		} else {
			int message = userservice.softDelete(id);
			return message;
		}

	}

	@GetMapping("/fetchalluser")
	public List<User> fetchAllUser() {
		return userservice.fetchAllUser();
	}

	@GetMapping("/authenticate")
	public String generateToken(@RequestBody User authRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		} catch (Exception ex) {
			throw new Exception("inavalid username/password");
		}
		return jwtUtil.generateToken(authRequest.getUsername());
	}
}
