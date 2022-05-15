package com.laptrinhjavawebshop.api.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavawebshop.dto.CartDTO;
import com.laptrinhjavawebshop.service.ICartService;


@RestController(value = "cartOfWeb")
public class CartAPI {
 
	@Autowired
	private ICartService cartService;
	

	@PostMapping("/api/cart")
	public CartDTO addProductCart(@RequestBody long id) {
		
		return cartService.addCart(id);
	}
	
	//true hay false thì đề nhảu vào success : function(result)
	//vì ko có mục dataType : 'json', -> dữ liệu trả từ server ra client
	@DeleteMapping(value ="/api/cart")
	public Boolean deleteProductOfCart(@RequestBody long[] ids) {
		if(cartService.deleteProductOfCart(ids) == true) {
			return true;
		}
		return false;
		
	}
}
