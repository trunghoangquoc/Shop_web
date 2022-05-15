package com.laptrinhjavawebshop.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.laptrinhjavawebshop.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

	Page<ProductEntity>  findByCategoryCode(String categoryCode , Pageable page);
	Page<ProductEntity>   findByName(String name , Pageable page);
	List<ProductEntity> findByNameContaining(String name);
	
	 @Query("select p from ProductEntity p where p.name LIKE ?1%")
	 List<ProductEntity> findByName(String name);
}
