package com.laptrinhjavawebshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavawebshop.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	UserEntity findOneByUserNameAndStatus(String name, int status);
	
	 UserEntity findByUserName(String userName);
	 UserEntity  findByEmail(String email);
}
