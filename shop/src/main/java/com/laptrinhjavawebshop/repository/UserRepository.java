package com.laptrinhjavawebshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavawebshop.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {	
	UserEntity findOneByUserName(String name);
}
