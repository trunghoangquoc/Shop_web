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
	    entity.setCodeImg(dto.getCodeImg());
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
	    dto.setCodeImg(entity.get().getCodeImg());
		return dto;
	}
	
	public ProductEntity toEntity(Optional<ProductEntity> entity) {
		ProductEntity productEntity = new ProductEntity();
		if (entity.get().getId() != null) {
			productEntity.setId(entity.get().getId());
		}
		productEntity.setCategory(entity.get().getCategory());
		productEntity.setCreatedBy(entity.get().getCreatedBy());
		productEntity.setCreatedDate(entity.get().getCreatedDate());
		productEntity.setName(entity.get().getName());
		productEntity.setTotalNumber(entity.get().getTotalNumber());
		productEntity.setPrice(entity.get().getPrice());
		productEntity.setShortDescription(entity.get().getShortDescription());
		productEntity.setCodeImg(entity.get().getCodeImg());
		
		return productEntity;
	}
	

	public ProductDTO toDto (ProductEntity entity) {
		ProductDTO result = new ProductDTO();
		result.setId(entity.getId());
		result.setName(entity.getName());
		result.setTotalNumber(entity.getTotalNumber());
		result.setPrice(entity.getPrice());
		result.setShortDescription(entity.getShortDescription());
		result.setCategoryCode(entity.getCategory().getCode());
		result.setCategoryName(entity.getCategory().getName());
		result.setCodeImg(entity.getCodeImg());
		return result;
	}

	

}
