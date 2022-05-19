package com.laptrinhjavawebshop.api.web;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
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
	
	@PutMapping("/api/cart")
	public List<CartDTO> updateStatus(@RequestBody Object[] obj) {

		List<CartDTO> listCartDto = new ArrayList<CartDTO>();
		ObjectMapper objmapper = new ObjectMapper();
	
		 Gson son = new Gson(); 
		 for (Object object : obj) {
			 String data = object+"";  
			 System.out.println(data); 
			 CartDTO fromJson = son.fromJson(data, CartDTO.class); 
			 listCartDto.add(fromJson);
			 }
		return cartService.updateStatusCart(listCartDto); 
		
				
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
