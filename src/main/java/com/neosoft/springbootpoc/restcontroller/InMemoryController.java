package com.neosoft.springbootpoc.restcontroller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.springbootpoc.entity.User;

@RestController
public class InMemoryController {

	@GetMapping("/")
	public String login() {
		return "authenticate successfully";
	}

	@GetMapping("/getUsers")
	public List<User> getUsers() {

		/*
		 * return Stream .of(new User(1, "shubham", "shubham@gmail.com", 324324), new
		 * User(2, "rohit", "rohit@gmail.com", 54345)) .collect(Collectors.toList());
		 */

		return Stream.of(new User(1, "shubham", "Deshmukh", 23), new User(2, "rohit", "kulkarni", 34))
				.collect(Collectors.toList());
	}
}
