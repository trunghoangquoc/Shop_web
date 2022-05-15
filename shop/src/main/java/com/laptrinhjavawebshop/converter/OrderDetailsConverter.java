package com.laptrinhjavawebshop.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavawebshop.entity.CartDetailsEntity;
import com.laptrinhjavawebshop.entity.OrderDetailsEntity;

@Component
public class OrderDetailsConverter {
     
	public OrderDetailsEntity toOrderDetailsEntity (CartDetailsEntity item) {
		OrderDetailsEntity result = new OrderDetailsEntity();
		
		result.setNameProduct(item.getNameProduct());
		result.setPrice(item.getPrice());
		result.setQuantity(item.getQuantity());
		result.setUserNameOrder(item.getUserNameOfCart());
		result.setCodeImg(item.getCodeImg());
		
		return result;
	}
}
