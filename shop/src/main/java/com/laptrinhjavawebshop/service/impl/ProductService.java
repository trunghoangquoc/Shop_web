package com.laptrinhjavawebshop.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
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
			result.setId(item.getId());
			result.setName(item.getName());
			result.setTotalNumber(item.getTotalNumber());
			result.setPrice(item.getPrice());
			result.setShortDescription(item.getShortDescription());
			result.setCategoryCode(item.getCategory().getCode());
			productDTO.add(result);
		}
		return productDTO;
		
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

	@Override
	@Transactional
	public ProductDTO save(ProductDTO dto) {
		CategoryEntity category = categoryRepository.findOneByCode(dto.getCategoryCode());
		Optional<ProductEntity> result;
		ProductEntity entity = new ProductEntity();
		if (dto.getId() != null ) {
			result = productRepository.findById(dto.getId());
			ProductEntity old = new ProductEntity();
			old.setName(result.get().getName());
			old.setPrice(result.get().getPrice());
			old.setShortDescription(result.get().getShortDescription());
			old.setTotalNumber(result.get().getTotalNumber());
			old.setCreatedBy(result.get().getCreatedBy());
			old.setCreatedDate(result.get().getCreatedDate());
			old.setModifiedBy(result.get().getModifiedBy());
			old.setModifiedDate(result.get().getModifiedDate());
			
			entity = productConverter.toEntity(dto, old);
			
		}else {
			entity = productConverter.toEntity(dto);
		}
		entity.setCategory(category);
		return productConverter.toDto(productRepository.save(entity));
	}

	@Override
	@Transactional
	public void delete(long[] ids) {
		for (long id: ids) {
			productRepository.deleteById(id);
		}
	}

}
