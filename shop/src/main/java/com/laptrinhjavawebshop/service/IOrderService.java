package com.laptrinhjavawebshop.service;

import com.laptrinhjavawebshop.dto.OrderDTO;

public interface IOrderService {
  
    OrderDTO createOrder (OrderDTO orderDto);
    void delete(long[] ids);
}
