package com.laptrinhjavawebshop.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavawebshop.dto.UserDTO;
import com.laptrinhjavawebshop.service.IUserService;

@RestController(value = "newApiOfWeb")
public class UserAccount {
	@Autowired
	private IUserService userService;
	
	@PostMapping ("/api/registerAccount")
		public UserDTO registerAccount (@RequestBody UserDTO userDTO) {
		
		return userService.registerUser(userDTO);
	}
}
