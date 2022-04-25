package com.laptrinhjavawebshop.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavawebshop.dto.ProductDTO;
import com.laptrinhjavawebshop.service.IUserService;

@RestController(value = "userAPIOfAdmin")
public class UserAPI {

	@Autowired
	private IUserService userService;
	
	@PostMapping("/api/user") 
	public ProductDTO createUser(@RequestBody ProductDTO dto) {
		return null;
	}
	
	@PutMapping("/api/user") 
	public ProductDTO updateUser(@RequestBody ProductDTO dto) {
		return null;
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
