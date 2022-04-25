package com.laptrinhjavawebshop.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.laptrinhjavawebshop.dto.UserDTO;
import com.laptrinhjavawebshop.entity.UserEntity;

@Component
public class UserConverter {
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserDTO toDto(UserEntity entity) {
		UserDTO result = new UserDTO();
		result.setId(entity.getId());
		result.setFullName(entity.getFullName());
		result.setPassWord(entity.getPassword());
		result.setUserName(entity.getUserName());
		result.setStatus(entity.getStatus());
		result.setEmail(entity.getEmail());
		result.setAddress(entity.getAddress());
//		result.setRoleCode(entity.getRoles());
		return result;
	}
	
	
	

	public UserEntity toEntity(UserDTO dto) {
		
		 UserEntity userEntity = new UserEntity();
		 
		 userEntity.setFullName(dto.getFullName());
		 userEntity.setPassword(bCryptPasswordEncoder.encode(dto.getPassWord()));
		 userEntity.setStatus(dto.getStatus());
		 userEntity.setUserName(dto.getUserName());
		 userEntity.setEmail(dto.getEmail());
		 userEntity.setAddress(dto.getAddress());
		return userEntity;
	}
	
}
