package com.laptrinhjavawebshop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavawebshop.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	 Page<UserEntity> findByStatus(Integer status , Pageable page);
	 UserEntity findOneByUserNameAndStatus(String name, int status);
	
	 UserEntity findByUserName(String userName);
	 UserEntity  findByEmail(String email);
	
}
