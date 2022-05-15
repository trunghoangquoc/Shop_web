package com.laptrinhjavawebshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.laptrinhjavawebshop.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity,Long>{

}
