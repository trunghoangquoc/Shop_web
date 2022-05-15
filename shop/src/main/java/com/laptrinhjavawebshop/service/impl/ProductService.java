package com.laptrinhjavawebshop.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.laptrinhjavawebshop.converter.ProductConverter;
import com.laptrinhjavawebshop.dto.ProductDTO;
import com.laptrinhjavawebshop.entity.CategoryEntity;
import com.laptrinhjavawebshop.entity.ProductEntity;
import com.laptrinhjavawebshop.repository.CategoryRepository;
import com.laptrinhjavawebshop.repository.ProductRepository;
import com.laptrinhjavawebshop.service.IProductService;

@Service
public class ProductService implements IProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductConverter productConverter;

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<ProductDTO> findAll(Pageable page) {
		List<ProductDTO> productDTO = new ArrayList<ProductDTO>();
		List<ProductEntity> productEntity = productRepository.findAll(page).getContent();
		for (ProductEntity item : productEntity) {
			ProductDTO result = new ProductDTO();
			result = productConverter.toDto(item);
			productDTO.add(result);
		}
		return productDTO;

	}
	
	
	@Override
	public List<ProductDTO> findAllLimit() {
		List<ProductDTO> productDTO = new ArrayList<ProductDTO>();
		List<ProductEntity> productEntity = productRepository.findAll();
		for (ProductEntity item : productEntity) {
			ProductDTO result = new ProductDTO();
			result = productConverter.toDto(item);
			if(productDTO.size() < 8) {
				productDTO.add(result);
			}
			
		}
		return productDTO;
	}
	//find theo category
	@Override
	public Page<ProductEntity>  findByCategoryCode(String categoryCode , Pageable page) {
		return productRepository.findByCategoryCode(categoryCode, page);
	}

	// find Search
	@Override
	public List<ProductDTO> findByName(String name) {
		List<ProductDTO> productDTO = new ArrayList<ProductDTO>();
		List<ProductEntity> productEntity = productRepository.findByName(name);
		
		if(productEntity != null && productEntity.size() > 0 ) {
			for (ProductEntity item : productEntity) {
				ProductDTO result = new ProductDTO();
				result = productConverter.toDto(item);
				productDTO.add(result);
			}
			return productDTO;
		}else {
			return null;
		}
		
		
	}

	@Override
	public int getTotalItem() {
		return (int) productRepository.count();
	}

	@Override
	public ProductDTO findById(long id) {
		Optional<ProductEntity> entity = productRepository.findById(id);
		return productConverter.toDTO(entity);
	}

	//create and update
	@Override
	@Transactional
	public ProductDTO save(ProductDTO dto) {
		CategoryEntity category = categoryRepository.findOneByCode(dto.getCategoryCode());
		ProductEntity entity = new ProductEntity();
		Optional<ProductEntity> oldProductEntity ;
		entity = productConverter.toEntity(dto);
		if(dto.getId() !=null) {
			oldProductEntity = productRepository.findById(dto.getId());
			entity.setId(dto.getId());
			entity.setCreatedBy(oldProductEntity.get().getCreatedBy());
			entity.setCreatedDate(oldProductEntity.get().getCreatedDate());
		}
		entity.setCategory(category);
		entity.setCategoryCode(category.getCode());
		return productConverter.toDto(productRepository.save(entity));
	}

	@Override
	@Transactional
	public void delete(long[] ids) {
		for (long id : ids) {
			productRepository.deleteById(id);
		}
	}

}
