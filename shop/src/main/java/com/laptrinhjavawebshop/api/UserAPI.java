package com.laptrinhjavawebshop.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavawebshop.dto.UserDTO;
import com.laptrinhjavawebshop.service.IUserService;

@RestController
public class UserAPI {
	@Autowired
	private IUserService userService;

	@PostMapping(value = "/api/account")
	public UserDTO createAccount(@RequestBody UserDTO userDto) {
		
		return userService.save(userDto);
	}

}
