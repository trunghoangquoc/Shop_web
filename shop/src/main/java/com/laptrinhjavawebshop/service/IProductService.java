package com.laptrinhjavawebshop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.laptrinhjavawebshop.dto.ProductDTO;
import com.laptrinhjavawebshop.entity.ProductEntity;

public interface IProductService {
	
	Page<ProductEntity> findByCategoryCode(String categoryCode, Pageable page);

	int getTotalItem();

	List<ProductDTO> findAllLimit();
	List<ProductDTO> findByName(String name);
	List<ProductDTO> findAll(Pageable page);

	ProductDTO findById(long id);

	ProductDTO save(ProductDTO dto);

	void delete(long[] ids);
}
