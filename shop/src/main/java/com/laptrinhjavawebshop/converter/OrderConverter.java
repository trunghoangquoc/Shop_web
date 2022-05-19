package com.laptrinhjavawebshop.converter;

import java.util.Optional;

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
	    result.setCreatedDate(orderEntity.getCreatedDate());
		result.setCreatedBy(orderEntity.getCreatedBy());
		return result;
		
	}
	
	public OrderEntity toOrderEntity (Optional<OrderEntity> orderEntity) {
		
		OrderEntity result = new OrderEntity();
		result.setId(orderEntity.get().getId());
		result.setReceiverAddress(orderEntity.get().getReceiverAddress());
		result.setReceiverName(orderEntity.get().getReceiverName());
		result.setReceiverPhone(orderEntity.get().getReceiverPhone());
		result.setShortDescription(orderEntity.get().getShortDescription());
		result.setEmail(orderEntity.get().getEmail());
		result.setOrderStatus(orderEntity.get().getOrderStatus());
		result.setUserNameOrder(orderEntity.get().getUserNameOrder());
		result.setTotalPay(orderEntity.get().getTotalPay());
	    result.setCreatedDate(orderEntity.get().getCreatedDate());
		result.setCreatedBy(orderEntity.get().getCreatedBy());
		return result;
		
	}
	
}