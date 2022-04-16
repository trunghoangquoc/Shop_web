package com.laptrinhjavawebshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavawebshop.entity.UserEntity;
//tại sao chỉ có name mà ko get passwork?
//passwork đã xử lý khi BYding data lên rồi
public interface UserRepository extends JpaRepository<UserEntity, Long> {	
	UserEntity findOneByUserNameAndStatus(String name, int status);
}
