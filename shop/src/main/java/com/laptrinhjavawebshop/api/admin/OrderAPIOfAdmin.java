package com.laptrinhjavawebshop.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavawebshop.service.IOrderService;

@RestController(value = "orderAPIOfAdmin")
public class OrderAPIOfAdmin {

	@Autowired
	private IOrderService orderService;
	

	@DeleteMapping("/api/admin/order")
	public void reviewOrder(@RequestBody long[] ids) {
		
		orderService.reivewOrder(ids);
	}
}
