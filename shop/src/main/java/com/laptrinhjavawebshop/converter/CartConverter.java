package com.laptrinhjavawebshop.converter;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.laptrinhjavawebshop.dto.CartDTO;
import com.laptrinhjavawebshop.entity.CartDetailsEntity;

@Component
public class CartConverter {
     
	public CartDTO toDto(CartDetailsEntity cartDetailsEntity) {
		CartDTO cartDto = new CartDTO();
		
		cartDto.setId(cartDetailsEntity.getId());
		cartDto.setNameProduct(cartDetailsEntity.getNameProduct());
		cartDto.setPrice(cartDetailsEntity.getPrice());
		cartDto.setQuantity(cartDetailsEntity.getQuantity());
		cartDto.setUserNameOfCart(cartDetailsEntity.getUserNameOfCart());
		cartDto.setTotalMoney(cartDetailsEntity.getTotalMoney());
		cartDto.setCodeImg(cartDetailsEntity.getCodeImg());
		return cartDto;
	}
	 
	public CartDetailsEntity toEntity (Optional<CartDetailsEntity> item) {
		CartDetailsEntity result = new CartDetailsEntity();
		
		result.setId(item.get().getId());
		result.setCart(item.get().getCart());
		result.setCodeImg(item.get().getCodeImg());
		result.setCreatedBy(item.get().getCreatedBy());
		result.setCreatedDate(item.get().getCreatedDate());
		result.setNameProduct(item.get().getNameProduct());
		result.setPrice(item.get().getPrice());
		result.setProduct(item.get().getProduct());
		result.setQuantity(item.get().getQuantity());
		result.setStatus(item.get().getStatus());
		result.setUserNameOfCart(item.get().getUserNameOfCart());
		
		return result;
	}
}
