package com.laptrinhjavawebshop.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavawebshop.dto.ProductDTO;
import com.laptrinhjavawebshop.service.IProductService;

@RestController(value = "productAPIOfAdmin")
public class ProductAPI {
	@Autowired
	private IProductService productService;
	
	@PostMapping("/api/product") 
	public ProductDTO createNew(@RequestBody ProductDTO dto) {
		return productService.save(dto);
	}
	
	@PutMapping("/api/product")
	public ProductDTO updateNew(@RequestBody ProductDTO updateProduct) {
		return productService.save(updateProduct);
	}


	@DeleteMapping("/api/product")
	public void deleteNew(@RequestBody long[] ids) {
		//@RequestBody long[] ids : là nhận về 1mảng để chứa Id bài viết cần xóa
		productService.delete(ids);
	}
}
