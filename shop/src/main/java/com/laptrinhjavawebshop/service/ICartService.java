package com.laptrinhjavawebshop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.laptrinhjavawebshop.dto.CartDTO;
import com.laptrinhjavawebshop.entity.CartDetailsEntity;

public interface ICartService {
	 int getTotalItem();
	 CartDTO addCart(long id);
	 List<CartDTO> findAll();
	 Page<CartDetailsEntity> findByNameOfCart (String userNameOfCart, Pageable page);
	 Boolean deleteProductOfCart(long [] ids);
	 List<CartDetailsEntity> findByStatusAndUserNameOfCart();
	 
	 //update Status cart
	 List<CartDTO> updateStatusCart (List<CartDTO> cartDto);
}
