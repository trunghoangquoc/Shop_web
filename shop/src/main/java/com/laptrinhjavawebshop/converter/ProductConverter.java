package com.laptrinhjavawebshop.converter;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.laptrinhjavawebshop.dto.ProductDTO;
import com.laptrinhjavawebshop.entity.ProductEntity;


@Component
public class ProductConverter {
	public ProductEntity toEntity(ProductDTO dto) {
		ProductEntity entity = new ProductEntity();

	    entity.setName(dto.getName());
	    entity.setTotalNumber(dto.getTotalNumber());
	    entity.setPrice(dto.getPrice());
	    entity.setShortDescription(dto.getShortDescription());
	    
		return entity;
	}
	
	public ProductDTO toDTO(Optional<ProductEntity> entity) {
		ProductDTO dto = new ProductDTO();
		if (entity.get().getId() != null) {
			dto.setId(entity.get().getId());
		}
		dto.setName(entity.get().getName());
		dto.setTotalNumber(entity.get().getTotalNumber());
		dto.setPrice(entity.get().getPrice());
		dto.setShortDescription(entity.get().getShortDescription());
	    dto.setCategoryCode(entity.get().getCategory().getCode());
		return dto;
	}
	

	public ProductDTO toDto (ProductEntity entity) {
		ProductDTO dto = new ProductDTO();
		if (entity.getId() != null) {
			dto.setId(entity.getId());
		}
		dto.setName(entity.getName());
		dto.setTotalNumber(entity.getTotalNumber());
		dto.setPrice(entity.getPrice());
		dto.setShortDescription(entity.getShortDescription());
	    dto.setCategoryCode(entity.getCategory().getCode());
		return dto;
	}

	

}
