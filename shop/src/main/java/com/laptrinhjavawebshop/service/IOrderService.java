package com.laptrinhjavawebshop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.laptrinhjavawebshop.dto.OrderDTO;
import com.laptrinhjavawebshop.dto.OrderDetailsDTO;
import com.laptrinhjavawebshop.entity.OrderEntity;


public interface IOrderService {
    
	Page<OrderEntity> findByUserNameOrder(String userNameOrder , Pageable page);
	List<OrderDTO> findAll(Pageable page);
	int getTotalItem();
	
    OrderDTO createOrder (OrderDTO orderDto);
    void delete(long[] ids);
    void reivewOrder(long[] ids);
    
    List<OrderDetailsDTO> orderDetails (long orderId);
}
