package com.laptrinhjavawebshop.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laptrinhjavawebshop.entity.CartDetailsEntity;
import com.laptrinhjavawebshop.entity.ProductEntity;


@Repository
public interface CartDetailsRepository extends JpaRepository<CartDetailsEntity, Long> {

	Page<CartDetailsEntity> findByUserNameOfCart(String userNameOfCart, Pageable page);
	CartDetailsEntity  findByProduct(ProductEntity product);
	CartDetailsEntity findByProductId (Long productId);
    List<CartDetailsEntity> findByStatusAndUserNameOfCart(Integer status , String userNameOfCart);
}
