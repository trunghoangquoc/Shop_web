package com.laptrinhjavawebshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.laptrinhjavawebshop.entity.OrderDetailsEntity;

public interface OrderDetailsRepository extends JpaRepository<OrderDetailsEntity,Long>{
	 List<OrderDetailsEntity> findByOrderId (long orderId);
}
