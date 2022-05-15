package com.laptrinhjavawebshop.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavawebshop.dto.OrderDTO;
import com.laptrinhjavawebshop.entity.OrderEntity;

@Component
public class OrderConverter {

	public OrderEntity toOrderEntity(OrderDTO orderDto) {

		OrderEntity result = new OrderEntity();
		result.setReceiverName(orderDto.getReceiverName());
		result.setReceiverAddress(orderDto.getReceiverAddress());
		result.setReceiverPhone(orderDto.getReceiverPhone());
		result.setEmail(orderDto.getEmail());
		
		return result;
	}
	
	public OrderDTO toDto (OrderEntity orderEntity) {
		
		OrderDTO result = new OrderDTO();
		result.setId(orderEntity.getId());
		result.setReceiverAddress(orderEntity.getReceiverAddress());
		result.setReceiverName(orderEntity.getReceiverName());
		result.setReceiverPhone(orderEntity.getReceiverPhone());
		result.setShortDescription(orderEntity.getShortDescription());
		result.setEmail(orderEntity.getEmail());
		result.setOrderStatus(orderEntity.getOrderStatus());
		result.setUserNameOrder(orderEntity.getUserNameOrder());
		result.setTotalPay(orderEntity.getTotalPay());
		
		return result;
		
	}
}