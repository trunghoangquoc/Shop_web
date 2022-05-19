package com.laptrinhjavawebshop.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavawebshop.dto.OrderDetailsDTO;
import com.laptrinhjavawebshop.entity.CartDetailsEntity;
import com.laptrinhjavawebshop.entity.OrderDetailsEntity;

@Component
public class OrderDetailsConverter {

	public OrderDetailsEntity toOrderDetailsEntity(CartDetailsEntity item) {
		OrderDetailsEntity result = new OrderDetailsEntity();

		result.setNameProduct(item.getNameProduct());
		result.setPrice(item.getPrice());
		result.setQuantity(item.getQuantity());
		result.setUserNameOrder(item.getUserNameOfCart());
		result.setCodeImg(item.getCodeImg());

		return result;
	}

	public OrderDetailsDTO toDto(OrderDetailsEntity entity) {
		
		OrderDetailsDTO result = new OrderDetailsDTO();
		
		result.setCodeImg(entity.getCodeImg());
		result.setId(entity.getId());
		result.setNameProduct(entity.getNameProduct());
		result.setPrice(entity.getPrice());
		result.setUserNameOrder(entity.getUserNameOrder());
		result.setQuantity(entity.getQuantity());
		result.setTotalMoney(entity.getTotalMoney());
		
		return result;
	}
}
