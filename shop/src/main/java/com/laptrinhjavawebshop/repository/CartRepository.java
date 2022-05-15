package com.laptrinhjavawebshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavawebshop.entity.CartEntity;



public interface CartRepository extends JpaRepository<CartEntity, Long>{
	CartEntity findByUserNameOfCart(String userNameOfCart);
}
