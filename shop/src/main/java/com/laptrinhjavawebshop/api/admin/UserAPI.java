package com.laptrinhjavawebshop.api.admin;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavawebshop.dto.ProductDTO;

@RestController(value = "userAPIOfAdmin")
public class UserAPI {

	
	@PostMapping("/api/user") 
	public ProductDTO createNew(@RequestBody ProductDTO dto) {
		return null;
	}
	
	
	@DeleteMapping("/api/user")
	public void deleteNew(@RequestBody long[] ids) {
		//@RequestBody long[] ids : là nhận về 1mảng để chứa Id bài viết cần xóa
		
	}
}
