package com.laptrinhjavawebshop.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavawebshop.dto.FeedBackDTO;
import com.laptrinhjavawebshop.entity.FeedBackEntity;

@Component
public class FeedBackConverter {
	public FeedBackDTO toDto(FeedBackEntity entity) {
		FeedBackDTO result = new FeedBackDTO();
		result.setId(entity.getId());
		result.setFullName(entity.getFullName());
		result.setAddress(entity.getAddress());
		result.setNumberPhone(entity.getNumberPhone());
		result.setEmail(entity.getEmail());
		result.setYourMessager(entity.getYourMessager());
		return result;
	}
	
	
	
	public FeedBackEntity toEntity(FeedBackDTO dto) {
		
		FeedBackEntity result = new FeedBackEntity();
		
		result.setFullName(dto.getFullName());
		result.setAddress(dto.getAddress());
		result.setNumberPhone(dto.getNumberPhone());
		result.setEmail(dto.getEmail());
		result.setYourMessager(dto.getYourMessager());
		return result;
	}
	
}
