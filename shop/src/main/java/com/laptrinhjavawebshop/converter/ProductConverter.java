package com.laptrinhjavawebshop.converter;

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
	
	//sau khi lưu xuống database thì khi đưa lên phải converter qua DTO để trả về API
	public ProductDTO toDTO(ProductEntity entity) {
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
	//có sẵn các thông tin trong field cũ của entity rồi.
	//giờ chỉ thêm những thông tin mới từ thằng DTO mà cta vừa thay đổi gửi từ client về server.
	public ProductEntity toEntity(ProductDTO dto, ProductEntity entity) {
		entity.setName(dto.getName());
		entity.setTotalNumber(dto.getTotalNumber());
		entity.setPrice(dto.getPrice());
		entity.setShortDescription(dto.getShortDescription());
		return entity;
	}
}
