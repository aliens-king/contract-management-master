package com.sampana.cms.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sampana.cms.dto.UserDTO;
import com.sampana.cms.model.ResponseDTO;
import com.sampana.cms.model.User;
import com.sampana.cms.repository.UserRepository;
import com.sampana.cms.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;
	/*
	 * @GetMapping("/users")
	 * 
	 * @PostMapping("/users")
	 * 
	 * @GetMapping("/users/{id}")
	 * 
	 * @DeleteMapping("/users/{id}")
	 * 
	 * @PutMapping("/users/{id}")
	 */

	@GetMapping("/check")
	public String hello() {
		return "helloWorld!!";
	}

	@GetMapping("/{id}")
	public List<User> getUser(@PathVariable("id") long id) {
		return userService.getUsers(id);
	}

	@PostMapping(value = "/create", headers = "Accept=application/json")
	public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating User " + user.getFullName());
		userService.createUser(user);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@GetMapping(value="/get", headers="Accept=application/json")
    public List<User> getAllUser() {
        List<User> tasks=userService.getUser();
        return tasks;

    }
	@PostMapping("/save")
	public ResponseDTO createBookDetails(@RequestBody UserDTO userDTO) {
		return userService.saveUser(userDTO);
	}
}
