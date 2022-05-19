package com.laptrinhjavawebshop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.laptrinhjavawebshop.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity,Long>{
   
	Page<OrderEntity> findByUserNameOrder(String userNameOrder , Pageable page);
}
