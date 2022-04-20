package com.laptrinhjavawebshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavawebshop.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
	CategoryEntity findOneByCode (String code);
}
