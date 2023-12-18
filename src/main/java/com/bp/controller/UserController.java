package com.bp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bp.model.AuthDTO;
import com.bp.model.UserDTO;
import com.bp.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/login")
	public AuthDTO authenticateUser(@RequestBody UserDTO userDTO) {
		return userService.authenticateUser(userDTO);
	}
	
	@PostMapping("/createUser")
	public UserDTO createUser(@RequestBody UserDTO userDTO) {
		return userService.createUser(userDTO);
	}
}