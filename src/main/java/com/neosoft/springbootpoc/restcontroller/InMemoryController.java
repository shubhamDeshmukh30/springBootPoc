package com.neosoft.springbootpoc.restcontroller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.springbootpoc.entity.Employee;
import com.neosoft.springbootpoc.entity.User;

@RestController
public class InMemoryController {

	@GetMapping("/")
	public String login() {
		return "authenticate successfully";
	}

	@GetMapping("/getUsers")
	public List<Employee> getUsers() {

		

		return Stream.of(new Employee(1, "shubham", "sd@gmail.com", 783738292),
				new Employee(2, "rohit", "rohit@gmail.com", 5345234)).collect(Collectors.toList());
	}
}
