package com.laptrinhjavawebshop.api.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavawebshop.dto.CartDTO;
import com.laptrinhjavawebshop.dto.OrderDTO;
import com.laptrinhjavawebshop.service.IOrderService;



@RestController(value = "OrderOfWeb1")
public class OrderAPI {

	@Autowired
	private IOrderService orderService;
	
	@PostMapping (value = "/api/orderDetails")
	
	public List<OrderDTO> addOrderDetails(@RequestBody List<CartDTO> cartDto) {
		
		return null;
	}
	
	@DeleteMapping(value ="/api/order")
	public void deleteProductOfOrder(@RequestBody long[] ids) {
		
		orderService.delete(ids);
	}
}
