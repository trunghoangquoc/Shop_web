package com.laptrinhjavawebshop.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavawebshop.dto.ProductDTO;
import com.laptrinhjavawebshop.dto.UserDTO;
import com.laptrinhjavawebshop.service.IUserService;

@RestController(value = "userAPIOfAdmin")
public class UserAPI {

	@Autowired
	private IUserService userService;
	
	@PostMapping("/api/user") 
	public UserDTO createUser(@RequestBody UserDTO dto) {
		return userService.save(dto);
	}
	
	@PutMapping("/api/user") 
	public UserDTO updateUser(@RequestBody UserDTO dto) {
		return userService.save(dto);
	}
	
	@DeleteMapping("/api/user")
	public void deleteUserActive(@RequestBody long[] ids) {
		userService.deleteUserActive(ids);
		
	}
	@DeleteMapping("/api/user/noActive")
	public void deleteUserNoActive(@RequestBody long[] ids) {
		userService.deleteUserNoActive(ids);
		
	}
}
