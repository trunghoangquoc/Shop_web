package com.laptrinhjavawebshop.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavawebshop.entity.CategoryEntity;
import com.laptrinhjavawebshop.repository.CategoryRepository;
import com.laptrinhjavawebshop.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public Map<String, String> findAll() {
		 Map<String, String> result = new HashMap<String, String>();
		 List<CategoryEntity> entity = categoryRepository.findAll();
		 for (CategoryEntity categoryEntity : entity) {
			 result.put(categoryEntity.getCode(), categoryEntity.getName());
		}
		 
		return result;
	}
       
}
