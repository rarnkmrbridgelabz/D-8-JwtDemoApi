package com.bridgelabz.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.dto.LoginDTO;
import com.bridgelabz.entity.User;
import com.bridgelabz.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public User userRegister(@RequestBody User user) {
		return userService.userRegister(user);
	}
	
	@PostMapping("/login")
	public String userLogin(@RequestBody LoginDTO loginDTO) {
		return userService.userLogin(loginDTO);
	}

}
